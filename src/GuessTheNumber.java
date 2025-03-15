import java.util.Random;
import java.io.Console;

public class GuessTheNumber{
    public static void main(String[] args){
        Console console = System.console();
        Random dice = new Random();
        int randomNumber = dice.nextInt(100_001);

        //chiede all'utente di indovinare il numero casuale,
        //se azzecca si congratule e ti dice il numero di tentativi fatti,
        // altrimenti ti dice se quello che hai detto è maggiore o minore

        //*
        int triesCount = 1;
        int chosenNumber = -1;

        while(chosenNumber != randomNumber){
            System.out.println("inserisci un numero da 0 a 100.000");
            String sn = console.readLine();
            chosenNumber = Integer.parseInt(sn);    //fallisce male se non scrivo un numero
            
            if(chosenNumber < randomNumber){
                System.out.println("prova con un numero più grande");
            }
            if(chosenNumber > randomNumber){
                System.out.println("prova con un numero più piccolo");
            }
            triesCount++;
        }
        System.out.printf("Congratulazioni, ci hai beccato! Ci hai messo %s tentativi\n", triesCount);
        //*/

    }
}