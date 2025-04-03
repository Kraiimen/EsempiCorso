package edoardo.exceptions;

import java.io.Console;

public class SureDivision {
    public static void main(String [] args){
        Console c = System.console();
        System.out.println("Inserisci 2 numeri interi");
        String firstInput = c.readLine("Inserisci il primo numero: ");
        String secondInput = c.readLine("Inserisci il primo numero: ");
        try {
            int firstNum = Integer.parseInt(firstInput);
            int secondNum = Integer.parseInt(secondInput);
            try {
                System.out.println("Il risultato della divisione intera è:" + firstNum/secondNum);


            } catch (ArithmeticException e){
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (NumberFormatException e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();

        }
    }
}
