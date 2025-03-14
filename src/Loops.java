import java.io.Console;
<<<<<<< HEAD
public class Loops {
    public static void main (String[] args){
        Console console = System.console();
        // for(int i = 0; i<10; i++){
        //     System.out.println(i);
        // }
        // fare i un ciclo che stampa i numeri dispari tra 1 e 100
        for(int i=1; i<=100; i+=2){
            System.out.println(i);
        }
        /* String answer;
        do{
            System.out.println("Inserisci una risposta di tipo Yes or No");
            answer = console.readLine();
            if(!answer.equals("Yes") && !answer.equals("No")){
                System.out.println("Ti ho detto di risposndere Yes or No!");
            }
        }while (!answer.equals("Yes") || !answer.equals("No")); */
        System.out.println("dammi un numero qualsiasi");
        String ns = console.readLine();
        int n = Integer.parseInt(ns);
        System.out.println(n+1);
    }
}

