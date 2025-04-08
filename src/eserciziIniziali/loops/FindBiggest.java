package eserciziIniziali.loops;

import java.io.Console;

public class FindBiggest{
    public static void main(String[] args){
        Console console = System.console();

        //*
        int maxValue = Integer.MIN_VALUE;
        String answer = "";

        while(!(answer.equalsIgnoreCase("Q"))){
            System.out.println("inserisci un numero, premi q per finire");
            answer = console.readLine();

            if(!(answer.equalsIgnoreCase("Q"))){    //chiunque stia leggendo il codice, ignori il .toUpperCase()
                int n = Integer.parseInt(answer);    //fallisce male se non scrivo un numero o Q
                if(maxValue < n){
                    maxValue = n;
                }
            }
        }
        if(maxValue != Integer.MIN_VALUE)
        {
            System.out.println("\nIl più grande inserito è " + maxValue);
        }
        else {
            System.out.println("\nnon hai inserito nessun numero");
        }
        //*/

    }
}