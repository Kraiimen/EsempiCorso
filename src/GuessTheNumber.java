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
    public static void main(String[] args) {
         Console console = System.console();
        
        Random dice = new Random();
        Console console = System.console();
        int n = dice.nextInt(100_001);
        //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta e: se azzecca stampa "bravo sei un genio"
        // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
        // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
        // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi

       String input ="-1";//numero casuale inserito nella console
       int t;//variabile per numero dei tentativi
       //System.out.println(n);//attivo solo per test in modo da visualizzare numero misterioso

       for(t = 0; Integer.parseInt(input)!= n; t++ ){
            System.out.println("inserisci numero");
            input = console.readLine();//numero casuale inserito nella console
            
          if(Integer.parseInt(input) == n){
            System.out.println("bravo sei un genio");
          } else if(Integer.parseInt(input) > n){
            System.out.println("hai sbagliato il numero magico è maggiore");
          }else{
            System.out.println("hai sbagliato, il numero è più piccolo ");
          }

       }

       System.out.println("numero di tentativi:");
       System.out.println(t);
      
           
            
            
     } 
     
    
}
