import java.io.Console;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        
        Random dice = new Random();
        int n = dice.nextInt(100_001);
		Console console = System.console();
		if (console == null) {
			System.out.println("Console non disponibile, utilizza un terminale");
			return ;
		}
		int tries = 0;
		int num = -1;
		System.out.println("Dammi un numero qualsiasi tra 0 e 100000");
		//System.out.print("Aiutino per test, il numero è");
		//System.out.println(n);
		while (num != n) {
			System.out.println("Indovina il numero: ");
			String tentativo = console.readLine();
        	num = Integer.parseInt(tentativo); //passami in intero la stringa del tentativo
			if (num > n) {
				System.out.println("Sbagliato, il numero magico è più piccolo!");
			}
			else if (num < n) {
				System.out.println("Sbagliato, il numero magico è più grande");
			}
			else {
				System.out.println("Bravo, hai indovinato, sei un genio!");
			}
			tries++;
		}
		System.out.println("Il numero di tentativi è stato: " + tries);
    }
    
}

        //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta e: se azzecca stampa "bravo sei un genio"
        // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
        // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
        // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi
