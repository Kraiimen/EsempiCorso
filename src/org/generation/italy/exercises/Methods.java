package org.generation.italy.exercises;

import java.io.Console;
public class Methods {

    public static void main(String[] args) {
        // Console console = System.console();
        // System.out.print("Dammi un numero > ");
        // String input1=console.readLine();
        // int x1 = Integer.parseInt(input1);
        // System.out.println();
        // System.out.print("Dammi un numero > ");
        // String input2=console.readLine();
        // int x2 = Integer.parseInt(input2);
        // System.out.println();
        greet();
        int nameLength = greetWithName("Emanuele");
        int x1 = readInteger();
        int x2 = readInteger();
        int sum = sum(x1,x2);
        printSum(x1,x2);
        System.out.println("lunghezza nome: "+ nameLength);
        boolean even = isEven(7);
        System.out.println(even);
        printInTitleCase("cIaO");
    }

    public static int readInteger(){
        Console console = System.console();
        System.out.print("Dammi un numero intero > ");
        String input1=console.readLine();
        int x = Integer.parseInt(input1);
        return x;

    }

    public static int sum(int x,int y){
        int sum = x + y;
        return sum;
    }

    public static void printSum(int x, int y){
        System.out.println("La somma dei due numeri è "+ (x+y));
    }
    public static void greet(){
        System.out.println("è un piacere conoscerti!");
    }
    public static int greetWithName(String name){
        System.out.println("è un piacere conoscerti "+name);
        return name.length();
    }
    public static boolean isEven(int x){
        return x%2==0;
    }

    public static void printLenAndUpperCaseLowerCase (String sentence){
        System.out.println(sentence.length());
        String lower = sentence.toLowerCase();
        System.out.println(lower);
        String upper = sentence.toUpperCase();
        System.out.println(upper);
    }

    //funzione che riceve due stringhe e ritorna la piu lunga
    public static String getLonger(String s1, String s2){
        // if(s1.length()>s2.length()){
        //     return s1;
        // }else{
        //     return s2;
        // }
        return s1.length()>s2.length()? s1 : s2;
    }

    public static void printInTitleCase(String name){
        // System.out.println(name.length());
        // System.out.println(name.toUpperCase());
        // System.out.println(name);
        String upper = name.toUpperCase();
        String lower = name.toLowerCase();
        char first = name.charAt(0);
        char firstUpper = Character.toUpperCase(first);
        String subString = lower.substring(1);
        String result = firstUpper+subString;
        System.out.println(result);
    }
}
