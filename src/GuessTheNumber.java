import java.util.*;
import java.io.*;

    //Il programma deve chiedere di indovinare un numero misterioso
    //se indovina "Bravo, hai indovinato!"
    //se ha sbagliato ed è minore "hai sbagliato, il numero è maggiore di quello inserito"
    //se ha sbagliato ed è maggiore "hai sbagliato, il numero è minore di quello inserito"
    //voglio che il programma conti i tentativi e li riporti a fine del processo 

public class GuessTheNumber {
    public static void main(String[] args){

        Random dice = new Random();
        int n = dice.nextInt(10_001);

        Console console = System.console();

        String guess = null;

        int ns = -1;
        int attempts = 0;

        System.out.println("\nIl numero da indovinare è: "+n);

        do{
            guess = console.readLine("Indovina il numero tra 0 e 10.000 : ");
            ns = Integer.parseInt(guess);

            attempts++;

            if(ns < n) {
                System.out.println("\nHai sbagliato, il numero da indovinare è maggiore di quello inserito");
            }
            else if(ns > n) {
                System.out.println("\nHai sbagliato, il numero da indovinare è minore di quello inserito");   
            }
            else{
                System.out.println("\nBravo, hai indovinato!");
                System.out.println("Numero tentativi: "+attempts);
            }
            
        } while (ns != n);

    }
}
