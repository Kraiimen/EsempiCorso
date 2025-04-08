package eserciziIniziali.loops;

import java.util.Random;
import java.io.Console;

public class GuessTheNumber{
    public static void main(String[] args){
        Console console = System.console();
        Random dice = new Random();
        int randomNumber = dice.nextInt(100_001);

        //chiede all'utente di indovinare il numero casuale,
        //se azzecca si congratula e ti dice il numero di tentativi fatti,
        // altrimenti ti dice se quello che hai detto è maggiore o minore

        //*
        int triesCount = 1;
        int chosenNumber = -1;

        while(chosenNumber != randomNumber){
            System.out.println("inserisci un numero da 0 a 100.000");
            String sn = console.readLine();
            chosenNumber = Integer.parseInt(sn);    //fallisce male se non scrivo un numero

            if(chosenNumber < randomNumber){
                System.out.print("prova con un numero più grande");
            }
            if(chosenNumber > randomNumber){
                System.out.print("prova con un numero più piccolo");
            }
            triesCount++;

            Integer encapsulatedRandomNumber = randomNumber;
            if(triesCount >= 5 && triesCount/5 <= encapsulatedRandomNumber.toString().length()){
                System.out.print(" ... eccoti un suggerimento: " + encapsulatedRandomNumber.toString().substring(0, triesCount/5));
                for(int i = triesCount/5; i < encapsulatedRandomNumber.toString().length(); ++i){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.printf("Congratulazioni, hai trovato il numero magico (%s)\nCi hai messo %s tentativi\n", randomNumber, triesCount);
        //*/

    }
}
