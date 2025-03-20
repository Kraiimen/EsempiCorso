import java.io.Console;
import java.util.Random;

       //Il programma deve chiedere di indovinare un numero misterioso
       //se indovina "Bravo, hai indovinato!"
       //se ha sbagliato ed è minore "hai sbagliato, il numero è maggiore di quello inserito"
       //se ha sbagliato ed è maggiore "hai sbagliato, il numero è minore di quello inserito"
       //voglio che il programma conti i tentativi e li riporti a fine del processo
        

public class GuessTheNumber {
    public static void main(String[] args) {

          //Creaiamo dice per creare un numero random grazie alla classe random
         Random dice = new Random();

         //Creiamo console per scrivere nel terminale tramite tasiera
          Console console = System.console();
          // Dichiariamo  la variabile INT con la n, e la inizializziamo con dice.nextInt
          int n = dice.nextInt(100); // numero random ,output della linea di comando
          int numGuess; // è il numero che l utente digiterà all interno della linea di comando
          int tentativi = 0;

        do { 
            System.out.print("Prova ad indovinare il numero: ");
            String guess = console.readLine();  // Il numero inserito dalla tasteria per la prima volta
            tentativi++;
            numGuess = Integer.parseInt(guess); // Passiamo la stringa che ci da la tastiera e mi da indietro nel Numero corrispondente alla strina delll input.
             if(numGuess == n) {
                System.out.println("Bravo, hai indovinato ci hai messolo solo: " + tentativi + " volte");
            } else if(numGuess > n){
                System.out.println("il numero da indovinare è minore di quello che mi hai dato");
            } else  {
                System.out.println("il numero da indovinare è maggiore di quello che mi hai dato");
            } 
          
        } while (numGuess != n);
  
    }
    
}
