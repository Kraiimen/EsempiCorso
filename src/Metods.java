import java.io.*;

public class Metods{
    public static void main(String[] args){
        //printSum(readInteger(), readInteger());

        //String mancoPerIdea = new Integer(sum(3,4 )).toString();
        //System.out.println(mancoPerIdea);

        //System.out.println(isEven(7));
        //System.out.println(isEven(12));

        printInTitleCase("sUpErCaLiFrAgIlIsTiChEsPiRaLiDoSo");
    }

    public static int readInteger(){
        Console console = System.console();
        
        System.out.println("dammi un numero");
        int x = Integer.parseInt(console.readLine());
        return x;
    }

    public static int sum(int x, int y){
        return x+y;
    }
    public static void printSum(int x, int y){
        System.out.println(x+y);
    }

    public static void greet(){
        System.out.println("è un piacere conoscerti");
    }
    public static int greetWithName(String name){
        System.out.println("è un piacere conoscerti, " + name);
        return name.length();
    }

    public static boolean isEven(int n){
        return (n & 1) == 0;    //controllo se pari con bitwise operator (modo più veloce di fare il controllo)
    }
    
    public static void printLenghtUpperLowerCase(String s){
        System.out.println(s.length());
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
    }
    //*
    public static String getLonger(String s1, String s2){
        if(s1.length() > s2.length()){
            return s1;
        }
        return s2;
    }
    //*/
    /*
    public static String getLonger(String s1, String s2){
        return s1.length() > s2.length() ?
                                        s1 : s1.length() < s2.length() ? 
                                                                    s2 : "sono della stessa lunghezza";
    }
    //*/

    
    public static void printInTitleCase(String s){
        System.out.println(Character.toUpperCase(s.charAt(0)) + s.substring(s.length()).toLowerCase());
    }
}