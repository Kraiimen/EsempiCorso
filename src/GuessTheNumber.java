import java.util.Random;
import java.io.Console;

public class GuessTheNumber {
    public static void main(String[] args) {
	Console console = System.console();
         Random dice = new Random();
        
	int n = dice.nextInt(100_001);
	int t = 1;
	int x;
        //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta e: se azzecca stampa "bravo sei un genio"
        // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
        // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
        // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi

//  	   System.out.println("Inserisci il numero: ");
//	String ns = console.readLine();
//	int x = Integer.parseInt(ns);
//	
//	while (x != n){
//		if(x > n){
//			System.out.println("No, il numero è troppo grande");
//		}if else (x < n) {
//			System.out.println("No, il numero è troppo piccolo");
//		}
//
//		System.out.println("Tentativi: " + t++);
//	}


	do {
		System.out.println("Inserisci il numero: ");
		String ns = console.readLine();
		x = Integer.parseInt(ns);
		if(x > n){
			System.out.println("No, il numero è troppo grande");
		}else  {
			System.out.println("No, il numero è troppo piccolo");
			}
		System.out.println("Tentativi: " + t++);
		}while (x != n);
			

		

		
	


    }
    
}
