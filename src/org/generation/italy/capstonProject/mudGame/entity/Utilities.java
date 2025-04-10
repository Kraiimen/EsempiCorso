package org.generation.italy.capstonProject.mudGame.entity;

import java.util.Scanner;

public class Utilities {

    public static Integer readIntInputOrExit(Scanner scanner, int min, int max, String exitCmd) {
        Integer choice = null;
        boolean valid = false;

        while (!valid) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase(exitCmd)){
                return null;
            }

            try {
                int num = Integer.parseInt(input);
                if (num >= min && num < max) {
                    choice = num;
                    valid = true;
                } else {
                    System.out.println("There is no item corresponding to your choice. Please choose another one");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please choose an object by its index or press '" + exitCmd + "' to exit.");
            }
        }

        return choice;
    }



}
