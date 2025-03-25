// una semplice calcolatrice 
// importo la console per leggere l'input dell'utente 
// creo una variabile di tipo int che chiamo x con il valore 0 
// dichiaro la string risposta 1
// dichiaro la string risposta x
// dichiaro la tring risposta y 
// inizio un ciclo, stampa "cosa ti serve? Moltiplicazione Divisione Sottrazione o Addizione? oppure premi X per uscire"
// se la risposta non è x e la risposta equivale a una delle opzioni elencate
    //es. se risposta equals moltiplicazione 
    // stampa "Cosa vuoi moltiplicare? scrivi tutti i numeri uno per uno e poi premi X"
    // dopo aver letto l'input dell'utente chiedere "poi? oppure quando hai finito premi q"
    // converto risposta x e y in numeri interi 
    // metti la formula x simbolo y 
    // altrimenti " Questo è il risultato!"
    // Una volta finito il ciclo stampa "Alla prossima!"
// se preme x alla prima domanda allora fa ":( ciaociao"

import java.io.Console;
public class Calcolatrice {
    public static void main(String[] args){
        Console console = System.console();
        int n = 0;
        String risposta;
        String u;
        String prim;

        do {
            System.out.println("Calcolatrice! Cosa ti serve? Addizione (+), Sottrazione (-), Moltiplicazione (x) o una Divisione(/)? Digita il simbolo per selezionalo. Oppure premi q per uscire!");
            risposta = console.readLine();
            if (risposta.equals("+")){
                    do {
                        System.out.println("Scrivi tutti i numeri uno per uno oppure premi u per il risultato.");
                        prim = console.readLine();
                        if (!prim.equals("u")){
                            int x = Integer.parseInt(prim);
                            n += x;
                        } else {
                            System.out.println("Il risultato è: " + n);
                        }
                        
                    } while (!prim.equals("u"));
            } 
        }while (!risposta.equals("q"));
        System.out.println("Alla prossima, ciao ciao! :D");
    }
}