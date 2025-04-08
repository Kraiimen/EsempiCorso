package firstExercises;

import java.io.Console;
import java.util.Random;
import java.io.Console;

public class GuessTheNumber {
    public static void main (String[] args){
        Console console = System.console();
        Random dice = new Random();
        int n = dice.nextInt(100);


        String answer;
        int number;
        int ntry = 0;
        do {
            System.out.println("indovina il numero segreto");
            answer = console.readLine();
            number = Integer.parseInt(answer);
            ntry ++;

            if(number < n){
                System.out.println("risposta sbagliata. il numero segreto è maggiore del numero inserito");
            } else if (number > n){
                System.out.println("risposta sbagliata. il numero segreto è minore del numero inserito");
            } else {
                System.out.println("Hai indovinato il numero segreto in " + ntry + " tentativi.");
            }
        } while (number != n);

    }
}
