import java.io.Console;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {

        Console console = System.console();
        Random dice = new Random();
        int n = dice.nextInt(100_001);
        // continuare questo programma. Deve chiedere un numero misterioso, se azzecca stampa "bravo sei un genio"
        // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
        // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
        // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi

        String ns;
        int y = 1; 
        int mN = 53790; 
        do {
            
            System.out.println("Dammi un numero qualsiasi da 1 a 100.000");

            ns = console.readLine(); 
            int iP = Integer.parseInt(ns);
            

            if(iP < mN) {
                System.out.println("Hai sbagliato, il numero magico è più grande");  
                y++;

            } 
            else if (iP > mN) {
                System.out.println("Hai sbagliato, il numero magico è più piccolo");   
                y++;              

            }
            else if (iP == mN) {
                System.out.println("Congratulazioni! Hai azzeccato il numero magico!");                   
                System.out.println("Tentativi: " + y);
            }
            
        } while (!ns.equals("53_790"));  
        
    }

        
} 


   

    

