// Un programma che all'avvio chieda un numero, poi chiede un altro numero o Q per smettere di inserire (e cosi via finché non viene inserito Q)
// Alla fine il programma stampa il numero più grande ricevuto

// importare java console che è una funziona java che ti permette di leggere l'imput dell'utente
// creare una variabile intera chiamata max che contenga un numero intero che sarà il numero massimo ricevuto
// eseguire un ciclo 
// per ogni interazione del ciclo stamperò la stringa "inserisci un numero o premi q per terminare"
// leggere l'user enter della tastiera e inserirlo in una nuova variabile di nome risposta 
// analizzare la risposta per verificare per verificare se è uguale alla stringa q
// se non è uguale alla stringa q creerò una variabile di tipo intero che chiamerò n
    // usare il metodo parsInt per assegnare ad n un valore a partire dalla stringa risposta 
    // avendo letto n lo confronto con l'attuale massimo che sta nella variabile max 
    // se il valore n inserito dall'utente è maggiore di max aggiornerò il varlore max con il valore n
// altrimenti (stringa = q) stamperò il valore del massimo ed esco dal ciclo

import java.io.Console;  // importo perché altrimenti non posso inserire imput
public class FindBigger {
    public static void main(String[] args) {
        Console console = System.console();  // perché altrimenti non mi legge l'imput
        // int max = Integer.MIN_VALUE; 
        String answer;
        boolean hasMax = false;
        int max = 0; 
        do {
            
            System.out.println("Inserisci un numero o premi q per terminare");
            answer = console.readLine(); 
            if (!(answer.equals("q"))) {
                int n = Integer.parseInt(answer);
                if (!(hasMax) || n>max) {
                    max = n;
                } 
                if (!hasMax) {
                    hasMax = true;
                }

            } else {
                System.out.println("il massimo è " + max);
            }

        
        } while (!(answer.equals("q")));
    }

}