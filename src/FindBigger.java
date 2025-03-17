import java.io.Console;
// il programma finche ti chiede continuamente di inserire un numero o se volessi terminare inserisci la string q
// Quando inserisci la stringa q il programma termina stampando la somma del numero
// Se l utente dicesse q come prima risposta il programma terminerà stampando la string non hai inserito nessun numero

// stiamo dichiarando la classe che è pubblica (visibile a tutti) e rinominata FindBigger
public class FindBigger {

// stiamo dichiarando un metodo (Main) che viene avviato automaticamente all'inzio del p
    public static void main (String[] args){
    // Creo una variabile intera sum che avrà valore inziale 0
    // eseguirò un ciclo, 
    // per ogni interazione del ciclo stamperò la stringa per favore dammi un numero o Q per chiudere il terminale
    // leggerò quello che l utente inserisce con la tastiera e la inserirò in una variabile che avrà come nome risposta
    // Analizzerò la risposta per verificare se sia uguale alla stringa Q
    // Se non è uguale alla stringa Q crerò una variabile di tipo intero che chiamero n 
    // e userò il metodo parsInt per assegnare ad N un valore partendo dalla stringa risposta
    // Avendo letto il numero n aggiungerò la somma
    // Altrimenti(la stringa era uguale a (Q) stamperò il valore della somma e uscirò dal ciclo

        Console console = System.console();
        int sum = 0;
        String risposta;
        do { 
            System.out.print("Per favore dammi un numero o Q per terminare");
            risposta = console.readLine();
            if(!risposta.equals("Q")){
                int n = Integer.parseInt(risposta);
                sum += n;
            } else { 
                System.out.println("La somma è " + sum);
            }
        } while(!risposta.equals("Q"));


    }


}
 