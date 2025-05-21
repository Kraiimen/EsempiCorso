package org.generation.italy.presentation;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

public class DatePresentation {
    public static void main(String[] args) {


    /*Fino a java 8 le classi utilizzate per lavorare con le date (Date e Calendar) presentavano vari problemi di ambiguità e precisione.
    Per esempio getYear() ritorna l’anno meno 1900, getMonth() va da 0 a 11.
    Molti sviluppatori, quindi, hanno cercato soluzioni alternative (librerie esterne), tra cui: Date4J (più semplice), Joda-Time (molto più completa).
    In java 8 è stato introdotto JSR-310 (Java Specification Request 310, una specifica, ovvero un documento formale che descrive come dovrebbe funzionare un'intera API
    per la gestione delle date e degli orari) la cui implementazione concreta è java.time con un API ispirata a JODA-TIME ---> creatore Stephen Colebourne (autore anche di Joda-Time).

    java.time contiene diverse classi utili:

    Classe	                    Descrizione
    LocalDate	                Data senza orario (es. 2025-05-18)
    DayOfWeek                   Un giorno della settimana (es. Martedì)
    LocalTime	                Orario senza data (es. 14:30:00)
    LocalDateTime	            Data + orario (senza fuso orario)
    ZonedDateTime	            Data + orario + fuso orario (es. Europe/Rome)
    Instant	                    Un punto specifico nel tempo con la precisione in nanosecondi(timestamp UTC)
    Duration	                Durata tra due tempi (es. "2 ore e 30 minuti")
    Period	                    Differenza tra due date (es. "2 anni, 3 mesi, 5 giorni")
    DateTimeFormatter	        Formattazione e parsing delle date/ore
    ChronoUnit / ChronoField	Unità e campi temporali (es. DAYS, MONTHS, YEARS, ecc.).

    Le classi del pacchetto java.time (come LocalDate, LocalTime, Instant, ecc.) non ereditano da una gerarchia comune, ma estendono direttamente Object.

    Anche se non ereditano da una classe madre comune (come Date o Calendar facevano), le classi della nuova API sono coerenti perché implementano le stesse interfacce.
    Queste interfacce si trovano in sottopacchetti di java.time, come:

    java.time.temporal.Temporal
    java.time.chrono.ChronoLocalDate
    java.time.temporal.TemporalAdjuster

    Questo permette di scrivere codice generico che funziona con qualsiasi tipo di data/ora.

    Le classi come LocalDate, Instant, ZonedDateTime, ecc. implementano l’interfaccia Comparable<T> (puoi usare il compareTo() per confrontarle)
    */

    //      LocalDate d1 = LocalDate.of(2025, 5, 18);
    //      LocalDate d2 = LocalDate.of(2023, 5, 18);
    //
    //      System.out.println(d1.compareTo(d2)); // > 0 → d1 è dopo d2
    //      System.out.println(d1.isAfter(d2));   // true

    /*
    PROBLEMA 1:
    trovare la data di oggi.

    SOLUZIONE:
    Le classi LocalDate, LocalTime e LocalDateTime non utilizzano un costruttore per essere inizializzate, quindi
    bisognerà invocare uno dei factory methods per crearne un oggetto (un factory method è un metodo statico che restituisce un'istanza della classe).
    Queste classi hanno tutte un metodo .now() che fa esattamente quello che intende.


       LocalDate dNow = LocalDate.now();
       System.out.println(dNow);

    /*
    In testing si può utilizzare un oggetto clock che può essere settato con qualunque orario si voglia
    */
    //      // 1. Creiamo una data e ora specifica
    //      LocalDateTime dataFissa = LocalDateTime.of(2001, 2, 24, 12, 0);
    //
    //      // 2. Convertiamola in un Instant usando il fuso orario
    //      ZoneId zona = ZoneId.of("America/New_York"); // o es. ZoneId.of("Europe/Rome")
    //      Instant istante = dataFissa.atZone(zona).toInstant();
    //
    //      // 3. Creiamo un Clock fisso
    //      Clock orologioFisso = Clock.fixed(istante, zona);
    //
    //      // 4. Usiamo il Clock per ottenere l’orario “finto”
    //      LocalDateTime oraSimulata = LocalDateTime.now(orologioFisso);
    //
    //      System.out.println("Ora simulata: " + oraSimulata);
    /*
    PROBLEMA 2:
    Ottenere una formattazione migliore per le date.

    SOLUZIONE:
    Utilizzare java.time.format.DateTimeFormatter.

    DateTimeFormatter ti consente di:
    -Convertire un oggetto LocalDate, LocalDateTime, ZonedDateTime, ecc. in una stringa leggibile.
    -Scegliere formattazioni predefinite, localizzate o basate su pattern.
    -Analizzare (parse) stringhe in oggetti data/ora (lato opposto della formattazione).

    La classe DateTimeFormatter ha molti formati predefiniti, tra cui:

        Nome	            Output esempio
    ISO_LOCAL_DATE	        2030-11-11
    BASIC_ISO_DATE	        20301111
    ISO_DATE_TIME	        2030-12-03T11:11:00+01:00
    ISO_ZONED_DATE_TIME	    2030-12-03T11:11:00+01:00[Europe/Rome]
    ISO_INSTANT	            2030-12-03T10:11:00Z
    RFC_1123_DATE_TIME	    Tue, 3 Jun 2030 10:11:00 GMT

    Esempio:
    */
    //      System.out.println("Data di adesso + ora : "+LocalDateTime.now());
    //      System.out.println("Ora : "+DateTimeFormatter.ISO_LOCAL_TIME.format(LocalDateTime.now()));
    //      System.out.println("Data : "+DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDateTime.now()));

    /*
    Obiettivo:
    Mostrare la data e l'ora nel formato tipico della lingua e cultura di un certo Locale (es. Italia, Francia, UK, Taiwan…).

    SOLUZIONE:
    Utilizzare DateTimeFormatter.ofLocalizedDateTime(style).

    esempio:
    */
    //  ZonedDateTime dt = ZonedDateTime.now();
    //  Locale locale = Locale.TAIWAN;
    //  DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
    //  System.out.println(locale.toString() + "--->" + f.format(dt));
    /*
    Si puo' anche personalizzare il pattern di formattazione delle date utilizzando la funzione:
    DateTimeFormatter.of Pattern(String pattern).
    il parametro d'input della funzione (String pattern) contiene dei caratteri che andranno a definirlo:

    Simbolo	Significato	        Tipo di rappresentazione	Esempi
    G	    Era	                Testo	                    AD, Anno Domini
    y	    Anno dell'era	    Numero                      (anno)	2004, 04
    u	    Anno (senza era)    Numero                      (anno)	2004
    D	    Giorno dell’anno    Numero	                    189
    M / L	Mese dell’anno	    Numero/Testo	            7, 07, Jul, July

    Le lettere ripetute influenzano la forma dell'output. Ad esempio:

    "M" → 1, "MM" → 01, "MMM" → Jan, "MMMM" → January.
    "E" → Tue, "EEEE" → Tuesday.

    Ogni lettera dell'alfabeto ha un significato.

    Esempio:
    */
    //  DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/LL/dd");
    //  System.out.println(df.format(LocalDate.now()));

    /*
    PROBLEMA:
    In informatica per determinare uno specifico momento nel tempo
    si utilizza la distanza in secondi/millisecondi dall'Epoch (1 Gennaio 1970. Introdotta da Unix e adottata poi da tutti)

    Quindi dobbiamo convertire quest'istante in una data.

    SOLUZIONE:
    Utilizzare il metodo ZonedDateTime.ofInstant(epochSec, zId) per gestire la conversione da istante a data o viceversa.
    */
    //  Instant epochSec = Instant.ofEpochSecond(1000000000L);
    //  ZoneId zId = ZoneId.systemDefault();
    //  ZonedDateTime then = ZonedDateTime.ofInstant(epochSec, zId);
    //  System.out.println("Data in quell'istante: "+then);

    /*
    PROBLEMA:
    Voglio trasformare una String in una Date.

    SOLUZIONE:
    Si utilizza parse(). Se non riesce a riconoscere la stringa d'input come data lancia DateTime xParseException.

    Esempio:
    */
    //  String armisticeDateString = "1918-11-11";
    //  LocalDate armisticeDate = LocalDate.parse(armisticeDateString);
    //  System.out.println("Data: " + armisticeDate);

    /*
    PROBLEMA:
    Voglio calcolare la differenza tra due date.

    SOLUZIONE:
    Si usa il metodo Period.between().

    Esempio:
    */
    //      LocalDate endOf20thCentury = LocalDate.of(2000, 12, 31);
    //      LocalDate now = LocalDate.now();
    //      Period diff = Period.between(endOf20thCentury, now);
    //      System.out.println("Differenza tra le due date:\n"+diff.getYears()+" Anni\n"+diff.getMonths()+" Mesi\n"+diff.getDays()+" Giorni");

    /*
    PROBLEMA:
    Aggiungere o sottrarre da una data.

    SOLUZIONE:
    Utilizzare la classe Period che ha un metodo .ofDays(giorni) per indicare una lunghezza di tempo
    e utilizzare il metodo .plus / .minus delle classi LocalDate per sommare / sottrarre i giorni dalla data.

    Esempio:
    */
    //      LocalDate now =  LocalDate.now();
    //      LocalDate then1 = now.plusDays(700);
    //
    //      //possiamo anche utilizzare Period.ofDays(n)
    //      Period p = Period.ofDays(700);
    //      LocalDate then2 = now.plus(p);
    //
    //      System.out.println("then1 (Data tra 700 giorni): "+ then1);
    //      System.out.println("then2 (Data tra 700 giorni usando il period): "+ then2);

    /*
    PROBLEMA:
    Definire date ricorsive

    SOLUZIONE:
    Utilizzare la classe TemporalAdjusters.
    Ti permette di modificare un oggetto data/tempo (es. LocalDate) secondo una regola. Per esempio:
    -Trova il primo lunedì del mese
    -Trova il terzo mercoledì del mese
    -Vai alla prossima domenica

        I metodi più usati sono:
    Metodo:	                        Significato:
    firstInMonth(DayOfWeek)	        Primo giorno della settimana in quel mese
    lastInMonth(DayOfWeek)	        Ultimo giorno della settimana in quel mese
    dayOfWeekInMonth(n, DayOfWeek)	n-esimo giorno della settimana in quel mese
    next(DayOfWeek)	                Giorno successivo alla data corrente
    nextOrSame(DayOfWeek)	        Come sopra, ma include anche oggi
    previous(DayOfWeek)	            Giorno precedente alla data corrente
    previousOrSame(DayOfWeek)	    Come sopra, ma include oggi

    Esempio:
    */
    //      LocalDate oggi = LocalDate.now();
    //
    //      // Trova il 3º mercoledì del mese corrente
    //      LocalDate terzoMercoledi = oggi.with(
    //          TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.WEDNESDAY)
    //      );
    //
    //      // Formatto la data in formato leggibile
    //      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    //
    //      System.out.println("Il terzo mercoledì del mese è: " + terzoMercoledi.format(formatter));

    /*
    PROBLEMA:
    Lavorare con date e orari di diversi fusi orari.

    SOLUZIONE:
    Utilizzare la classe ZonedDateTime e i suoi metodi plus() / minus().

    Esempio:
    */
    //      // Fusi orari
    //      ZoneId zonaPartenza = ZoneId.of("Europe/Rome");
    //      ZoneId zonaArrivo = ZoneId.of("Asia/Dubai");
    //
    //      // Orario di partenza (adesso, a Roma)
    //      ZonedDateTime partenza = ZonedDateTime.now(zonaPartenza);
    //
    //      // Durata del volo: 2 ore e 30 minuti
    //      Duration durataVolo = Duration.ofHours(2).plusMinutes(30);
    //
    //      // Orario d’arrivo in orario UTC (come Instant)
    //      Instant arrivoInstant = partenza.toInstant().plus(durataVolo);
    //
    //      // Converti l’arrivo in orario locale a Dubai
    //      ZonedDateTime arrivo = arrivoInstant.atZone(zonaArrivo);
    //
    //      // Stampa
    //      System.out.println("Partenza da Roma:  " + partenza);
    //      System.out.println("Durata volo:       " + durataVolo.toHours() +" ore "+durataVolo.minusHours(durataVolo.toHours()).toMinutes()+" minuti");
    //      System.out.println("Arrivo a Dubai:    " + arrivo);

    /*
    PROBLEMA:
    Avere a che fare con le vecchie classi Date e Calendar

    SOLUZIONE:
    Usare metodi di conversione tra API legacy e moderna.

        Legacy Class	            Converti in Legacy	                    Converti in Moderno
    java.util.Date	                Date.from(Instant)	                    date.toInstant()
    java.util.Calendar	            calendar.toInstant()                    (non applicabile)
    java.util.GregorianCalendar	    GregorianCalendar.from(ZonedDateTime)	calendar.toZonedDateTime()
    java.util.TimeZone		        timeZone.toZoneId()                     (non applicabile)
    java.text.Format	            dateTimeFormatter.toFormat()	        (non applicabile)

    Esempio:
    */
          //java.util.Date → LocalDateTime
    //      Date legacyDate = new Date();
    //      System.out.println("Legacy Date: " + legacyDate);
    //
    //      LocalDateTime modernDate = LocalDateTime.ofInstant(
    //              legacyDate.toInstant(), ZoneId.systemDefault());
    //      System.out.println("Converted to LocalDateTime: " + modernDate);
    //
    //      // LocalDateTime → java.util.Date
    //      Date backAgain = Date.from(modernDate
    //              .atZone(ZoneId.systemDefault())
    //              .toInstant());
    //      System.out.println("Back to legacy Date: " + backAgain);
    }
}
