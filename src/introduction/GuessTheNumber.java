package introduction;

import java.io.Console;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Console console = System.console();
        Random dice = new Random();
        int numberToGuess = dice.nextInt(101);
        int userNumber = 0;
        int counter = 0;
        System.out.println("Guess the number");
        do {

            String userNumberString = console.readLine();
            userNumber = Integer.parseInt(userNumberString); // converts string to int type

            if (userNumber < numberToGuess) {
                System.out.println("You're wrong, the number is bigger. Try again");
            } else if (userNumber > numberToGuess) {
                System.out.println("You're wrong, the number is smaller. Try again");
            } else {
                System.out.println("Good job! You guessed the number");
            }

            counter++;
        } while (userNumber != numberToGuess);

        System.out.println("It took you " + counter + " tries");

        int i = 0;
        for (i = 1; i == 100; i++)
            System.out.println(i);
        if (i % 3 == 0 && i % 5 == 0) {
            System.out.println("fizzbuzz");
        } else if (i % 5 == 0) {
            System.out.println("buzz");
        } else if (i % 3 == 0) {
            System.out.println("fizz");
        }

        /*
         * stampa i primi numeri da 1 a 100,
         * se il numero è multiplo di 3 anzi che quello tampa fizz,
         * se è un multiplo di 5 spama buzz,
         * se è sia di 3 sia di 5 stampa fizzbuzz
         */
    }

}
