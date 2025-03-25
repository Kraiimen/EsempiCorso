import java.io.Console;
import java.util.Random;

 
public class GuessTheNumber {

    public static void main(String[] args) {

        Console console = System.console();
        Random dice = new Random();
        int n = dice.nextInt(100); // real magic number
        // continuare questo programma. Deve chiedere un numero misterioso, se azzecca stampa "bravo sei un genio"
        // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
        // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
        // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi

        String ns;
        int y = 1; //mettere nome più preciso sullo scopo di quella variabile
        // int mN = 53790; 
        int iP; //dichiarazione di iP senza valore per ora
        do {
            
            System.out.println("Dammi un numero qualsiasi da 1 a 100.000");

            ns = console.readLine(); 
            iP = Integer.parseInt(ns);
            

            if(iP < n) {
                System.out.println("Hai sbagliato, il numero magico è più grande");  
                

            } 
            else if (iP > n) {
                System.out.println("Hai sbagliato, il numero magico è più piccolo");   
                          

            }
            else if (iP == n) {
                System.out.println("Congratulazioni! Hai azzeccato il numero magico!");                   
                System.out.println("Tentativi: " + y);
            }

            y++; 

        } while (iP != n); 
    }
}