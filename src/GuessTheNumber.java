import java.io.Console;
import java.util.Random;
import java.util.random.RandomGenerator;

public class GuessTheNumber{
        public static void main(String[] args){
        Random dice = new Random();
        int n=dice.nextInt(100);
        int input=0;
        int tentativi=0;
        //utente da un input, se sbaglia ad indovinare il numero random, indicare se minore o maggiore di questo
        //segnare il numero di tentativi e stamparlo
        Console console = System.console();
        do{
            System.out.println("Inserisci un numero:  ");
            String ns = console.readLine();
            input = Integer.parseInt(ns);
            tentativi +=1;
            if(input < n){
                System.out.println("hai sbagliato! Il numero magico è maggiore di quello inserito!");
            }else if(input > n){
                System.out.println("hai sbagliato! Il numero magico è minore di quello inserito!");
            }
        }while(n != input);
        System.out.println("hai impiegato " + tentativi + " tentativi.");
    }
}