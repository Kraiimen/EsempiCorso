//importa le librerie
import java.io.Console;
import java.util.Random;

//utente da un input, se sbaglia ad indovinare il numero random, indicare se minore o maggiore di questo
//segnare il numero di tentativi e stamparlo

public class GuessTheNumber{
        public static void main(String[] args){
        Random dice = new Random();                 //crea un oggetto di nome "dice" e di tipo Random
        int n=dice.nextInt(100);                    //crea una variabile di tipo int e di nome "n" e inserisce al suo interno un numero intero randomico tra 0 e 100
        int input=0;                                //inizializza una variabile di nome "input" che servirà per contenere l'intero inserito da tastiera
        int tentativi=0;                            //inizializza una variabile di nome "tentativi" che verrà utilizzata come contatore
        Console console = System.console();         //crea un oggetto di nome "console" e di classe Console

        //inizio ciclo 
        do{
            System.out.println("Inserisci un numero:  ");                                                   //chiede d'inserire un input da tastiera
            String ns = console.readLine();                                                                 //crea una variabile di tipo String e di nome "ns" dentro la quale viene inserita la stringa che l'utente scrive da tastiera
            input = Integer.parseInt(ns);                                                                   //all'interno della variabile input, viene inserito il contenuto di ns convertito in Int
            tentativi +=1;                                                                                  //il numero di tentativi viene aumentato di 1

            //controllo se l'input da tastiera(input) è maggiore o minore del numero generato(n)
            if(input < n){
                System.out.println("hai sbagliato! Il numero magico è maggiore di quello inserito!");
            }else if(input > n){
                System.out.println("hai sbagliato! Il numero magico è minore di quello inserito!");
            }
        }while(n != input);                                                                                  //il ciclo finisce quando il numero random coincide con l'input dato dalla tastiera
        System.out.println("hai impiegato " + tentativi + " tentativi.");                                    //stampa il numero di tentativi
    }
}