import java.io.Console;
public class GuessTheNumber {
    public static void main(String[] args) {
        Console console = System.console();
        Random dice = new Random();
        int n = dice.nextInt(10);
        //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta e: se azzecca stampa "bravo sei un genio"
        // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
        // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
        // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi   
        
        
        int ns;    // cosa mette l'utente nella tastiera    
        int nt = 0;  
        
        do {
            System.out.println("dammi un numero qualsiasi da 1 a 10");
            String answer = console.readLine();
            ns = Integer.parseInt(answer);
            nt++; 
            if (ns > n ) {
                System.out.println("Hai sbagliato, il numero magico è più piccolo");  
            }
            else if (ns < n){
                System.out.println("hai sbagliato il numero magico è più grande");
            }else  {
                System.out.println("complimenti sei un genio");
            }
            

        }
        while (ns != n);
        System.out.println(nt);

        // creo una variabile intera che si chiamerà ns che conterrà l'imput numerico dell'utente 
        // creo una variabile intera cche chiamerò nt che conterà il numero di tentativi dell'utente con valore iniziale 0
        // eseguirò un ciclo do while in cui per ogni ciclo 
          // stamperò un promt chiedendo all'utente di inserire un numero 
          // leggerò questo numero in una stringa che chiamerò answer
          // incremento di uno il valore della variabile nt
          // trasformerò questa stringa answer in un numero e lo inserirò all'interno della variabile ns
          // se ns è maggior di n stamperò un messaggio dicendo che il numero più piccolo
          // altrimenti se ns è minore di n stamperò che il numero è più grande 
          // altrimenti stamperò un messaggio che dice che ho indovinato
        // il ciclo continuerà finché ns è diverso da n 
        // stampo il valore di nt
        


        
    }  
    
}
