package introduction;

import java.io.Console;

public class Loops {
    public static void main(String[] args) {

        Console console = System.console();
        for (int i = 0; i < 10; i++)
            System.out.println(i);
        System.out.println("Loop is over");

        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }

        for (int i = 1; i < 100; i += 2) {
            System.out.println(i);
        }

        int y = 100;
        while (y > 0) {
            System.out.println(y);
            y -= 5;
        }

        int z = 100;
        do {
            System.out.println(z);
            z -= 5;
        } while (z > 0);
        
        /*  la variabile
         dichiarata fuori dalle parentesi graffe per essere accessibile a tutto il main*/

        String answer = console.readLine();
        do {
            System.out.print("Type either yes or no");
            if (!answer.equals("yes") && !answer.equals("no")) {
                System.out.println("I told you to type yes or no");
                //do this action until the user input is equal to yes or no
            }
        } while (!answer.equals("yes") && !answer.equals("no"));
        // answer sono variabili locali

        System.out.println("Give me a random number");
        String randomN = console.readLine();
        int randomNumber = Integer.parseInt(randomN); // passa in intero la stringa
        System.out.println(randomNumber + 1);

    }
}
