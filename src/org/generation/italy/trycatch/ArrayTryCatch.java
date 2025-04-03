package org.generation.italy.trycatch;

import java.io.Console;
import java.util.ArrayList;

public class ArrayTryCatch {
    public static void main (String[] args) {
        f1();

    }

    private static void f1() {
        int[] numbers = {1, 2, 3, 4, 5, 8, 9};

        Console userInput = System.console();
        System.out.println("Inserisci il numero dell'elemento dell'Array a cui vuoi accedere");

        try {
            String input = userInput.readLine();
            int i = Integer.parseInt(input);
            System.out.println(numbers[i]);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Errore: " + e.getMessage());
        }
    }
}


