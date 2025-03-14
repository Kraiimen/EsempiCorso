import java.util.Random;
import java.io.Console;

public class GuessTheNumber {
    public static void main(String[] args) {
         Console console = System.console();
        
        Random dice = new Random();
        int n = dice.nextInt(10);
        int x;
        int numeroTentativi = 0;
        //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta e: se azzecca stampa "bravo sei un genio"
        // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
        // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
        // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi

        do {System.out.println("Indovina un numero da 1 a 10!");
            String ns = console.readLine();
            numeroTentativi ++;
            x = Integer.parseInt(ns); 
             if (x > n){
                System.out.println("Hai sbagliato, il numero magico è minore");
             } else if (x < n) {
                System.out.println("Hai sbagliato, il numero magico è maggiore");
             }
        } while(x != n);
        System.out.println("Bravo, sei un genio! Hai indovinato con " + numeroTentativi + " tentativi.");
    }
    
}
