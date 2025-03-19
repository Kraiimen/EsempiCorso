import java.io.Console;
import java.util.Random;

 
public class GuessTheNumber {
    public static void main(String[] args){

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
