import java.io.Console;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random dice = new Random();
        int n = dice.nextInt(10001);
        Console console = System.console();
        int answer = 0 ;
        int tentativi = 0;
        //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta e: se azzecca stampa "bravo sei un genio"
        // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
        // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
        // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi
        do {
            String input = console.readLine("Indovina un numero da 1 a 10001: ");
            answer = Integer.parseInt(input);
            if (answer < n) {
                System.out.println("Hai sbagliato il numero è piu grande\n") ;
            }else if (answer > n) {
                System.out.println("Sbagliato il numero è piu piccolo\n") ;
            }
            tentativi++ ;
        } while (answer != n) ;
        System.out.println("Bravo il numero era " + n + " ci hai provato : " + tentativi + " volte" ) ;
    }
    
}
//Chiedere numero misterioso
//rispsota azzeccata brava (if)
//risp sbagliata e minore 
//risp sbagliata e maggiore
//mostra tenativi