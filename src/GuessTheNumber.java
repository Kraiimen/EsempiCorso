import java.util.Random;
import java.io.Console;

public class GuessTheNumber {
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
