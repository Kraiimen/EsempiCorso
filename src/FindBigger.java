import java.io.Console;
public class FindBigger {
    public static void main(String [] args){
        // creerò una variabile intera che chiamo "sum" che do valore iniziale 0
        // eseguirò un ciclo
        // per ogni interazione del ciclo stamperò la stringa "inserisci un numero o premi q per terminare"
        // leggerò l'user enter dalla tastiera e lo inserirò in una nuova variabile di nome risposta
        // analizzo la risposta per verificare se è uguale alla stringa q 
        // se non è uguale alla stringa q creerò una variabile di tipo intero che chiamerò n 
        // userò il metodo parsInt per assegnare ad n un valore a partire dalla stringa risposta
        // avendo letto n aggiungo n al valore di sum
        // altrimenti (stringua uguale q) stamperò il valore della somma e uscirò dal ciclo 
        //invece che stampare la somma stampare il numero più alto 

        Console console = System.console();
        int sum = 0;
        String risposta;

        do {
            System.out.println("Inserisci un numero o premi Q per terminare per favore :3");
            risposta = console.readLine(); // metto la console per leggere la risposta typed
            if (!risposta.equals("Q")){ // risposta diversa da q
                int n = Integer.parseInt(risposta);
                sum += n;
            } else {
                System.out.println("La somma è " + sum );
            }

        } while(!risposta.equals("Q"));
    }
    
}
