import java.io.Console;

public class Loops {
    public static void main(String[] args) {
        Console console = System.console();
        for( int i = 0 ; i < 10 ; i++ ) { //nel secondo slot sto dicendo dove terminare il ciclo, al termine fìdi ogni ciclo  incremento 1
            System.out.println(i);
        }
        System.out.println("ciclo terminato"); 
        // fare ciclo for che stampa i numeri dispari da 1 a 100

        // for(int i = 1 ; i < 101 ; i++ ) { 
        //     if(i % 2 != 0) {
        //         System.out.println(i);
        //     } //se il resto della divisione è 0 i numeri sono pari
        // }

        // for(int i = 100; i > 0; i -= 5) {  //questo stampa tutti i numeri da 100 a 0 tutti multipli di 5
        //     System.out.println(i);
        // }

        //     int y = 100;
        // while(y > 0) {
        //     System.out.println(y);
        //     y -= 5;
        // }

        // int z = 100;
        // do { 
        //     System.out.println(z);
        //     z -= 5;
        // } while (z > 0);
        
        String answer;
        do { 
            System.out.println("inserisci una risposta di tipo Yes or No");
            System.out.print("Risposta: ");
            answer = console.readLine();
            


            if(!answer.equals("Yes") && !answer.equals("No")) {
                System.out.println("Ti ho detto di rispondere Yes or No!");
            }
        } while 
                (!answer.equals("Yes") && !answer.equals("No"));

        System.out.println("dammi un numero qualsiasi");
        String ns = console.readLine();
        int n = Integer.parseInt(ns); //passami in intero la stringa ns
        System.out.println(n + 1);
    } 
    
} 
