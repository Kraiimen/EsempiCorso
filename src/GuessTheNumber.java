import java.io.Console;
import java.util.Random;

 
public class GuessTheNumber {

    public static void main(String[] args) {


        Random dice = new Random();
        int n = dice.nextInt(100_001); // Genera un numero casuale tra 0 e 100.000
        int nUtente = 0; // Simuliamo un tentativo iniziale
        int tentativi = 0;

        System.out.println("Gioco 'Indovina il Numero' iniziato.");
        System.out.println("Il numero misterioso è stato generato. Simuliamo i tentativi...");

        do {
            nUtente = dice.nextInt(100_001); // Simuliamo una scelta casuale dell'utente
            tentativi++;

            if (nUtente < n) {
                System.out.println(nUtente + "Hai sbagliato, il numero misterioso è più piccolo.");
            } else if (nUtente > n) {
                System.out.println(nUtente + "Hai sbagliato, il numero misterioso è più grande.");
            }

        } while (nUtente != n);

        System.out.println("Il numero misterioso era" + n + ".");
        System.out.println("Numero di tentativi:" + tentativi);
    }



 //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta
        //se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero è più piccolo"
        //Caso inverso della seconda riga
        //Il programma tiene conto del numero dei tentativi e li riporti a fine del processo il numero di tentativi.


        
        Random dice = new Random();
        int n = dice.nextInt(100_001);
        //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta e: se azzecca stampa "bravo sei un genio"
        // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
        // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
        // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi

    public static void getRandom(String[] args){


        //creiamo dice per generare un numero casuale grazie alla classe Random
        Random dice = new Random();  

        //creiamo console per leggere da tastiera, grazie alla classe Console
        Console console = System.console();

        //dichiariamo la variabile di tipo Intero, con il nome n e la inizializziamo con il numero casuale da 0 a 10000
        int n = dice.nextInt(100);
        int numGuess; // dichiarare la variabile, numero che mette l'utente
        int tentativi = 0;

    do {
        System.out.print("Try to guess the magic number, I dare you!");
        String guess = console.readLine();
        tentativi++; // aggiunge +1 a tentativo
        numGuess = Integer.parseInt(guess); // passiamo la stringa che ci da lla tasiera e mi da indietro nek numero corr
        if (numGuess == n){  // SE il numero inserito equivale al giusto
            System.out.println ("Good job! you're a Wizard now! You tried " + tentativi + " times.. Do better!"); // test + n tentativi + testo
        } else if (numGuess > n){ // ALTRIMENTI se il numero inserito è maggiore
            System.out.println("Nope, the magic number is lower! Try again :D");
        } else{ // solo else, VA IN ESCLUSIVA, aka numero minore
            System.out.println("Nope, the magic number is higher! Try again :)");
        }
    } while (numGuess != n); // va a vanti finchè indovina ovvero finchè sbaglia 
        
    }
}

