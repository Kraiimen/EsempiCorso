package introduction;

import java.io.Console;

public class Methods {
    public static void main(String[] args) {
        // Console console = System.console();

        // System.out.print("Dammi un numero > ");
        // String input1 = console.readLine();
        // int x1 = Integer.parseInt(input1);
        // 
        // System.out.print("Dammi un numero > ");
        // String input2 = console.readLine();
        // int x2 = Integer.parseInt(input2);

        // int x1 = readInteger();
        // int x2 = readInteger();

        // System.out.println("La somma dei due numeri è " + (x1 + x2));

        // int result = sum(x1 , x2);
        // System.out.println("La somma dei due numeri è " + result);

        // printSum(x1 , x2);
        // sum(x1 , x2); //se non c'è una variabile che la riceve, 
        // //non cambia nulla invocando sum

        //printLenAndUpperCaseLowerCase("Hello everyone");
        // GetLongestString("Hello everyone", "Hey you");
        printTitleCase("wiwiwi");
    }

    public static int readInteger() {
        Console console = System.console();

        System.out.print("Dammi un numero intero > ");
        String input = console.readLine();
        int x = Integer.parseInt(input);
        return x;
    }

    public static int sum(int x, int y) {
        int z = x + y;
        return z;
    }

    public static void printSum(int x, int y) {
        int z = x + y;
        System.out.println(z);
    }

    public static boolean isEven(int number) {
        // if (number%2!=0)
        // {
        //     return false;
        // }
        // boolean result = true;
        // return result;

        return number % 2 == 0; // modo alternativo
    }

    public static void printLenAndUpperCaseLowerCase(String sentence) {
        int len = sentence.length();
        System.out.println(len);
        String lower = sentence.toLowerCase();
        System.out.println(lower);
        String upper = sentence.toUpperCase();
        System.out.println(upper);
    }

    //public static String getLongestString(String sentence1, String sentence2) {
    // String longest = "";
    // if (sentence1.length() > sentence2.length()) {
    //     longest = sentence1;
    // } else if (sentence1.length() == sentence2.length()) {
    //     System.out.println("Both strings are the same length");
    // } else {
    //     longest = sentence2;
    // }
    // System.out.println(longest);
    // return longest;

    // if (sentence1.length() > sentence2.length()) {
    //     return sentence1;
    // }
    // else {
    //     return sentence2;
    // }

    // return sentence1.length() > sentence2.length() ? sentence1 : sentence2;
    // operatore ternario (perché ha tre elementi)
    // // un'espressione booleana sarà true o false.
    // se è vera, è cio che sta immediatamente dopo il punto interrogativo.
    // se non è vera, il risultato è ciò che sta dopo i due punti
    //equivalente di if-else;

    // }

    public static void printTitleCase(String name) {
        System.out.println(name.length());
        System.out.println(name.toUpperCase());
        String upper = name.toUpperCase();
        String lower = name.toLowerCase();
        char first = name.charAt(0); // prende il primo carattere della stringa
        char firstUpper = Character.toUpperCase(first); //versione maiuscola di first
        System.out.println(name); //le stringhe in java sono immutabili
        String subString = lower.substring(1);
        String result = firstUpper + subString;
        System.out.println(result);
    }


    /*
     * 1)creare una funzione che prende in input una stringa e mi ritorna il suo
     * ultimo carattere in maiuscolo
     * 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu
     * piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne
     * ritorna una qualsiasi delle piu' piccole
     * 3) creare una funzione che prende in input un array di stringhe, e mi ritorna
     * la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una
     * qualsiasi delle piu' lunghe.
     * 4) creare una funzione che scambia i valori di due numeri interi
     * 5) creare una funzione che riceve in input un array di numeri interi positivi
     * e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
     * 6) creare una funzione che riceve in input un array di numeri interi e mi
     * restituisce la loro somma. Se l array e' vuoto mi restituisce -1
     * 7) creare una funzione che riceve in input una stringa e mi restituisce una
     * booleana true se la stringa non contiene vocali, false altrimenti
     * 8) creare una funzione che riceve in input una stringa e mi restituisce una
     * booleana true se la stringa e' palindroma, false altrimenti
     */


}