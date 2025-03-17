import java.io.Console;
import java.util.Random;

public class GuessTheNumber {
     public static void main(String[] args) {
                                             //PROGRAMMA 1 "GUESS THE NUMBER"//
          Random dice = new Random();
          int n = dice.nextInt(100_001);
          //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta e: se azzecca stampa "bravo sei un genio"
          // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
          // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
          // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi
          int numero = 0;
          int counter = 0;
          while(numero != n) {
               
          Console console = System.console();
          String input = console.readLine("Inserisci un numero \n");
          numero = Integer.parseInt(input);
          if(numero == n) {
              System.out.println("Bravo, sei un genio!");
              counter++;
              System.out.println("Hai indovinato il numero in " + counter + " tentativi." );
          }
             else if(numero < n) {
              System.out.println("Il numero che hai digitato è più piccolo del numero magico!");
              counter++;
             }
             else {
              System.out.println("il numero che hai digitato è maggiore del numero magico!");
              counter++;
             }
          }
               
                    
     }
          
     

}