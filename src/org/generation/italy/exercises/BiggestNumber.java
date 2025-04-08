package org.generation.italy.exercises;

import java.io.Console;

public class BiggestNumber {
    public static void main (String[] args){
        Console console = System.console();

        // System.out.println("inserisci un numero");
        // String answer = console.readLine();
        // int number = Integer.parseInt(answer);
        // String answer2;
        // do {
        //     System.out.println("inserisci un altro numero o premi 'q' per uscire");
        //     answer2 = console.readLine();
        //     if (answer2.equals("q")){
        //         System.out.println("il numero più grande inserito è " + number);
        //     } else {
        //         int number2 = Integer.parseInt(answer2);
        //         if(number < number2){
        //             number = number2;
        //         }
        //     }
        // } while (!answer2.equals("q"));

        String answer2 = "";
        boolean hasAnswer = false;
        int number = 0;
        do {
            if (!hasAnswer){
                System.out.println("inserisci un numero");
                String answer = console.readLine();
                number = Integer.parseInt(answer);
                hasAnswer = true;
            } else {
                System.out.println("inserisci un altro numero o premi 'q' per uscire");
                answer2 = console.readLine();
                if (!answer2.equals("q")){
                    int number2 = Integer.parseInt(answer2);
                    if(number < number2){
                        number = number2;
                    }
                } else {
                    System.out.println("il numero più grande inserito è " + number);
                }
            }
        } while (!answer2.equals("q"));
    }
}

