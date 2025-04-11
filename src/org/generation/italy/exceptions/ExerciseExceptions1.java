package org.generation.italy.exceptions;
import java.io.Console;

public class ExerciseExceptions1 {
    public static void main (String[] args){
        Console console = System.console();

        String answer;
        int number = 0;
        int number2 = 0;
        double number3 = 0;

        System.out.println("Dammi due numeri interi separati da una virgola");
        answer = console.readLine();
        String[] splitArray = answer.split(",");

        try {
            number = Integer.parseInt(splitArray[0]);
            number2 = Integer.parseInt(splitArray[1]);
            number3 = number / number2;
            System.out.println(number3);

        } catch (ArithmeticException e){
            System.out.println("errore trovato on puoi fare / 0 " + e.getMessage());

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("E mettila sta cazzo di virgola");

        }catch(NumberFormatException e){
            System.out.println("error metti un numero cazzo " + e.getMessage());}

        System.out.println("fine main");
    }
}
