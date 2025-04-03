package org.generation.italy.exceptions;

import java.io.Console;

public class ExerciseExceptions2 {
    public static void main (String[] args){
        Console console = System.console();
        String answer;
        int number;

        System.out.println("Dammi un numero intero");
        answer = console.readLine();
        try{
            number = Integer.parseInt(answer);
            System.out.println("bravo bel numero il " + number);
        } catch (NumberFormatException e){
            System.out.println("errore trovato " + e.getMessage());
        }
    }
}
