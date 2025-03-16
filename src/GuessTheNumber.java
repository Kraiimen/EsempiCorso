import java.util.Random;
import java.io.Console;
        //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta e: se azzecca stampa "bravo sei un genio"
        // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
        // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
        // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi

public class GuessTheNumber {
    public static void main(String[] args) {
     Console console = System.console();  
     Random dice = new Random();
     int cont = 0;
     int g = 0 ;
     
     while(true){       
          int n = dice.nextInt(10) +1;

          System.out.println("il dado ha lanciato: "+ n); 
        
          
          System.out.println("Inserisci un numero da indovinare: (0 esci)");
          
          
          String ns = console.readLine();
          g = Integer.parseInt(ns);
          System.out.println("Hai inserito: " + g);
          
          if(g == 0)  break;
          if(g == n) {
             System.out.println("bravo sei un genio");
             cont++;
             
          }
          else if(g < n) {
             System.out.println("hai sbagliato, il numero magico è maggiore");
             cont++;
             
          }
          else if(g > n) {
             System.out.println("hai sbagliato, il numero magico è minore");
             cont++;
             
          }
          
    
          

        }
        System.out.print("hai giocato " + cont +" volte!");

    
    }
    
}
