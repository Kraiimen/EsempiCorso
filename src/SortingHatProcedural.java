// Il programma assegna ad ogni studente una casa, basandosi sul film di Harry Potter
// Se lo studente è fortunato, diamo la possibilità di assegnarlo alla casa che preferisce --> questo avviene con un numero casuale da 0 a 3
// Se lo studente non è fortunato, prendiamo una casa casuale che ha ancora spazio
// Ad ogni assegnazione di uno studente ad una casa, viene stampata l'estrazione
// Alla fine del programma ci sarà una tabella con le 4 case e i suoi rispettivi studenti

import java.io.Console;
import java.util.Arrays;
import java.util.Random;

public class SortingHatProcedural {
    // Array di frasi per la suspense 
    private static final String SUSPENCE[] = {"Ah, che mente affascinante! So esattamente dove collocarti...",
                         "Vedo dentro di te grandi qualità... la tua strada è chiara per me!",
                         "Ambizione, coraggio, saggezza o lealtà? Io so cosa ti definisce meglio!",
                         "Oh, che scelta interessante... ma ora so esattamente dove tu appartieni!",
                         "Non c'è alcun dubbio, il tuo destino è segnato... benvenuto nella tua nuova casa!"};

    private static final String[] HOUSE_NAMES = {"Gryffindor","Hufflepuff","Slytherin","Ravenclaw"};

    // Costanti per ricordare la posizione delle case nell'array HOUSE_NAMES
    private static final int GRYF_POS = 0;
    private static final int HUF_POS = 1;
    private static final int SLY_POS  = 2;
    private static final int RAVE_POS  = 3;

    // Array per i nomi dei prefetti (in corrispondenza della loro casa che si trova in HOUSE_NAMES)
    private static final String[] PREFECTS = {"Federico De Simone","Marta Petruzzelli","Carmine Erario","Filippo Aresu"};

    // Array bidimensionale per il nome dello studente e la sua preferenza
    private static final String STUDENTS[][] = {  
            {"Ilario Vasco Palaia",HOUSE_NAMES[SLY_POS]},
            {"Elvis La fata",HOUSE_NAMES[RAVE_POS]},
            {"Regina Ghering",HOUSE_NAMES[SLY_POS]},
            {"Luca Formica",HOUSE_NAMES[RAVE_POS]},
            {"Davide Mazzitelli",HOUSE_NAMES[RAVE_POS]},
            {"Piero Scarcina",HOUSE_NAMES[GRYF_POS]},
            {"Vittorio Aquila",HOUSE_NAMES[RAVE_POS]},
            {"Emanuele Giustiniani",HOUSE_NAMES[SLY_POS]},
            {"Gaspare Maione",HOUSE_NAMES[GRYF_POS]},
            {"Camilla Marchioro",HOUSE_NAMES[GRYF_POS]},
            {"Eugenio Manganelli",HOUSE_NAMES[HUF_POS]},
            {"Edoardo Bognanni",HOUSE_NAMES[RAVE_POS]},
            {"Lorenzo Coretti",HOUSE_NAMES[HUF_POS]},
            {"Sabrina Salerno",HOUSE_NAMES[HUF_POS]},
            {"Marcello Coppolino",HOUSE_NAMES[SLY_POS]},
            {"Stefano Pio Lorato", HOUSE_NAMES[GRYF_POS]},
            {"Nicolo Casertano",HOUSE_NAMES[GRYF_POS]},
            {"Alessio Basili",HOUSE_NAMES[RAVE_POS]}
    };

    // Numero di studenti che creerebbe 4 case della stessa dimensione (ovvero (18/4) * 4 = 16)
    // STUDENTS.length è un intero
    // intero / intero = intero (viene preso solo il numero prima della virgola)
    private static final int PERFECT_CLASS_SIZE = STUDENTS.length/4 *4;  

    // Prende il resto della divisione tra il numero degli studenti e il numero di case (che sarebbe il numero di studenti in più)
    private static final int EXTRA_STUDENTS = STUDENTS.length % HOUSE_NAMES.length;

    // Se la costante è true vuol dire che si sono sudenti extra  
    private static final boolean HAS_EXTRA_STUDENTS = EXTRA_STUDENTS != 0;  

    // Questo array tiene traccia del numero di studenti messi in ogni casa
    private static final int[] COUNTERS = new int[4]; 

    // Costante che indica il numero massimo di persone che possono essere in una casa
    // (STUDENTS.length + 4) = 22
    // (STUDENTS.length + 4) / 4 = 5 (perchè è un intero e non prende quello dopo la virgola)
    // SE ci sono sudenti extra aggiunge al risultato di prima 1
    private static final int HOUSE_SIZE = (STUDENTS.length + 4)/4 + (HAS_EXTRA_STUDENTS ? 1 : 0); 
    
    // Array bidimensionale che contiene le 4 case con gli studenti
    private static final String[][] HOUSES = new String[4][HOUSE_SIZE];

    // Dichiariamo l'oggetto di tipo Random
    private static final Random DICE = new Random(); 

    public static void main(String[] args) {

        randomize(); // Randomizziamo l'array di studenti
        
        assignPrefects(); // Assegniamo i prefetti nelle loro case

        // Ciclo for per iterare nell'array STUDENTS[][] (Ipotizzando che non ci siano studenti extra)
        for(int i = 0; i < PERFECT_CLASS_SIZE; i++) {                       
            String studentName = STUDENTS[i][0]; // Nome dello studente
            String favouriteHouse = STUDENTS[i][1]; // Casa preferita dello studente

            // In questo caso, visto che stiamo ipotizzando che non ci sono studenti extra, fullCapacity è false
            // fullCapacity = false --> considera la dimensione della casa (HOUSE_SIZE) senza studenti extra  
            assignToDestination(studentName, favouriteHouse, false); 
        }

        // Ciclo for per iterare gli studenti extra rimasti
        // Parte da dove ci siamo fermati nel ciclo precedente
        // Termina quando finisce il numero di studenti extra


        for(int i = PERFECT_CLASS_SIZE; i < PERFECT_CLASS_SIZE + EXTRA_STUDENTS; i++) {
            // In questo caso, visto che stiamo mettendo gli studenti extra, fullCapacity è true
            // fullCapacity = true --> considera la dimensione della casa (HOUSE_SIZE) con studenti extra  
            assignToDestination(STUDENTS[i][0], STUDENTS[i][1], true);
        }
        
        printFinalHouses();  // Stampa le case con gli studenti alla fine del programma
    }

    // Metodo per assegnare lo studente alla casa
    private static void assignToDestination(String studentName, String favouriteHouse, boolean fullCapacity) {
        boolean houseHasSpace = hasRoom(favouriteHouse, fullCapacity); // true se la casa ha spazio
        int luck = DICE.nextInt(4); // Numero casuale da 0 a 3

        // Se lo studente è fortunato e la casa ha spazio
        if(luck == 0 && houseHasSpace) { 
            assignStudentToHouse(studentName ,favouriteHouse); // Assegniamo lo studente alla casa
            printStudentDestination(studentName, favouriteHouse, true); // Stampiamo il sorteggio
            waitForReturn(); // Il terminale aspetta il return
        } else {
            String destination = getRandomAvailableHouse(fullCapacity); // Prendiamo una casa libera casuale

            // Se il metodo getRandomAvailableHouse restituisce null, terminiamo il programma
            if(destination == null) {
                System.out.println("ERRORE LOGICO: tutte le case risultano occupate al massimo. \nTerminiamo il programma.");
                System.exit(0); // Per terminare il programma
            }

            assignStudentToHouse(studentName, destination); // Assegniamo lo studente alla casa
            printStudentDestination(studentName, destination, false); // Stampiamo il sorteggio
            waitForReturn(); // Il terminale aspetta il return
        }
    }

    // Metodo per randomizzare l'array STUDENTS[][]
    public static void randomize(){
        // Il ciclo itera 100 volte perché vogliamo scambiare due studenti casuali per 100 volte
        for(int i = 0; i < 100; i++){
            int n1 = DICE.nextInt(STUDENTS.length); // Prendiamo un numero casuale tra 0 e 17
            int n2;

            // Il "do while" svolge una volta il codice nel suo blocco di graffe, prima di controllare la condizione
            do{        
                n2 = DICE.nextInt(STUDENTS.length); // Prendiamo un numero casuale tra 0 e 17 
            } while(n2 == n1); // Se i numeri casuali sono uguali, rifacciamo il ciclo

            // Scambiamo i due studenti pescati casualmente
            String[] temp = STUDENTS[n1];
            STUDENTS[n1] = STUDENTS[n2];
            STUDENTS[n2] = temp; 
        }
    }

    // Metodo per controllare se in una casa c'è spazio
    private static boolean hasRoom(String houseName, boolean fullCapacity){ 
        // Crea una lista momentanea a partire dall'array HOUSE_NAMES e restituisce la posizione di quella casa nell'array HOUSE_NAMES
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName);
        // getEvenHouseSize() restituisce (HOUSE_SIZE - 1) nel nostro caso visto che lavoriamo con studenti extra
        int size = getEvenHouseSize();  
        
        if(fullCapacity){
            // Se fullCapacity è true, il metodo ritorna true se c'è ancora spazio nella casa (considerando l'intera dimensione della casa) (nel nostro caso 6)
            return COUNTERS[housePos] < HOUSE_SIZE;  
        } else {
            // Altrimenti, il metodo ritorna true se c'è ancora spazio nella casa (considerando la dimensione ridotta della casa) (nel nostro caso 5)
            return COUNTERS[housePos] < size;  
        }
    }

    // Metodo che assegna uno studente ad una casa
    private static void assignStudentToHouse(String studentName , String houseName){
        // Crea una lista momentanea a partire dall'array HOUSE_NAMES e restituisce la posizione di quella casa nell'array HOUSE_NAMES
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName);
        int studentPos = COUNTERS[housePos]; // Posizione dove poi inserire lo studente nell'array delle case

        HOUSES[housePos][studentPos] = studentName; // Copiamo il nome dello studente nell'array della casa
        COUNTERS[housePos]++; // Aumentiamo il contatore di quella casa
    }

    // Metodo per assegnare inizialmente, prima degli studenti, i 4 prefetti nelle loro rispettive case
    private static void assignPrefects() {
        for(int i = 0; i < PREFECTS.length; i++) {
            HOUSES[i][0] = PREFECTS[i]; 
            COUNTERS[i]++; 
        }
    }

    // Metodo che restituisce una casa casuale tra quelle libere
    private static String getRandomAvailableHouse(boolean fullCapacity) {
        String[] hs = new String[HOUSES.length]; // Array di stringhe locale        
        int numAvail = 0; // Contatore di case con posti liberi
        // Se fullCapacity è true, restituisce la dimensione massima della casa, altrimenti quella diminuita
        int size = fullCapacity ? HOUSE_SIZE : getEvenHouseSize();

        // Ciclo for da 0 al numero di case (4)
        for(int i = 0; i < COUNTERS.length; i++) {
            // Se il numero di studenti è minore della dimensione della casa, quindi ci sono ancora posti disponibili
            if(COUNTERS[i] < size) { 
                hs[numAvail] = HOUSE_NAMES[i]; // Salviamo il nome della casa nell'array locale
                numAvail++;  // Incrementiamo il contatore di case disponibili
            }
        }

        // Se non ci sono case disponibili, ritorniamo null
        if(numAvail == 0) {
            return null; 
        }

        // Se tutto va bene, ritorniamo in modo casuale una delle case disponibili salvate nell'array locale
        return hs[DICE.nextInt(numAvail)];
    }

    // VERSIONE 2 UN PO' PIU' PULITA DEL METODO SOPRA (NIENTE PANICO)
    // private static String getRandomAvailableHouseVERSION2(boolean fullCapacity){
    //     String[] hs = new String[HOUSES.length];         
    //     int numAvail = 0; 
    //
    //     for (String name : HOUSE_NAMES) {
    //         boolean available = hasRoom(name, fullCapacity);
    //         if (available) {
    //             hs[numAvail] = name;
    //             numAvail++;
    //         }
    //     }
    //
    //     if(numAvail == 0) {
    //         return null; 
    //     }
    //
    //     return hs[DICE.nextInt(numAvail)];
    // }

    // Metodo per calcolare la dimensione della casa
    private static int getEvenHouseSize() {
        // Ritorna la dimensione della casa per il controllo del fullCapacity
        // Se ci sono studenti extra, la dimensione sarà HOUSE_SIZE - 1 (ovvero 5)
        return HOUSE_SIZE - (HAS_EXTRA_STUDENTS ? 1 : 0); 
    }

    /* ------------------------------------ */
    /* SE SEI ARRIVATO FIN QUI E HAI CAPITO */
    /*    HAI VINTO UN BISCOTTO DI MARTA    */
    /* ------------------------------------ */

    // Metodo per stampare il sorteggio dello studente nella casa
    private static void printStudentDestination(String studentName, String houseName, boolean wasLucky){
        System.out.println("\n"+studentName + "...");
        delay(1000); // Aggiungiamo suspense
        System.out.println(SUSPENCE[DICE.nextInt(5)]); // Stampiamo una frase casuale dell'array SUSPENCE[]
        delay(1500); // Aggiungiamo suspense

        if (wasLucky) {
            // Se lo studente è fortunato, stampiamo la stringa con "come da sua preferenza"
            System.out.println(houseName.toUpperCase()+" come da sua preferenza!");
        } else {
            System.out.println(houseName.toUpperCase()+" !");
        }
    }

    // Metodo per stampare la tabella finale
    private static void printFinalHouses() {
        // Variabile per la formattazione della stringa
        // % è un carattere speciale per indicare da dove inizia la stringa che passeremo
        // - significa che stiamo indentando la stringa a sinistra  
        // 25 è il numero fisso di caratteri che occuperà la stringa (a prescindere da quanto sia lunga)
        // s signigica che tutto quello tra il % ed s è una stringa
        String outputFormat = "%-25s%-25s%-25s%-25s%n";  
        
        System.out.println(); // Aggiungiamo una riga vuota nel terminale

        // Stampiamo il titolo della tabella, usando la fromattazione e passando le stringhe che sostituiscono %-25s (in ordine di come le vogliamo)
        System.out.printf(outputFormat, HOUSE_NAMES[0], HOUSE_NAMES[1], HOUSE_NAMES[2], HOUSE_NAMES[3]); 

        // Stampiamo anche gli studenti
        for(int i = 0; i < HOUSE_SIZE; i++) {
            // Passiamo le stringhe usando il metodo emptyIfNull per sostituire i valori null con ""
            System.out.printf(outputFormat, emptyIfNull(HOUSES[0][i]), emptyIfNull(HOUSES[1][i]),  emptyIfNull(HOUSES[2][i]),  emptyIfNull(HOUSES[3][i])); 
        }
    }

    /* ------------------------------------------------- */
    /* METODI AGGIUNTIVI PER FORMATTARE MEGLIO LA STAMPA */
    /* ------------------------------------------------- */

    // Metodo per sostituire i null con la stringa vuota nella stampa
    private static String emptyIfNull(String str){
        // Se la stringa è null, la sostituiamo con ""
        return str == null ? "" : str;
    }

    // Metodo per aggiungere suspance tra il nome e la casa scelta
    private static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Impossibile, il programma è mono thread
        }
    }

    // Metodo per aspettare che l'utente schiacci return per vedere il destino del prossimo studente
    private static void waitForReturn(){
        Console console = System.console();
        console.readLine(); // Aspetta il return
    }   
}
