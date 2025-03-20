import java.io.Console;
public class Methods {
    public static void main(String[] args) {
        // Console console = System.console();

        // System.out.print("Dammi un numero > ");
        // String input1 = console.readLine();
        // int x1 = Integer.parseInt(input1);
        // System.out.println();   //in questo caso non serviva
        // System.out.print("Dammi un numero > ");
        // String input2 = console.readLine();
        // int x2 = Integer.parseInt(input2);

        int x1 = readInteger();
        int x2 = readInteger();

        System.out.println("La somma dei due numeri è " + (x1 + x2));

        int result = sum(x1 , x2);
        System.out.println("La somma dei due numeri è " + result);

        printSum(x1 , x2);
        greet();
        int lunghezza = greetWithName("Vittorio");
        System.out.println(lunghezza);
        lunghezza = greetWithName("Eugenio");
        System.out.println(lunghezza);
        boolean even = isEven(7);
        System.out.println(even);
        printLengthAndUpperCaseLowerCase("Tutto bene?");
        String Longer = getlonger("pierino" , "pluto");
        printlnTiltleCase("pAPeRiNo");

    }

    public static int readInteger() {
        Console console = System.console();

        System.out.print("Dammi un numero intero > ");
        String input = console.readLine();
        int x = Integer.parseInt(input);
        return x;
    }

    public static int sum(int x , int y) {
        int z = x + y;
        return z;
    }

    public static void greet() {
        System.out.println("è un piacere conoscerti");
    }

    public static void printSum(int x , int y) {
        int z = x + y;
        System.out.println(z);
    }

    public static int greetWithName(String name) {
        System.out.println("è un piacere conoscerti: " + name);
        int length = name.length();
        return length;
    }

    public static boolean isEven(int x) {
        // if(x % 2 == 0) {
        //     return = true;
        // } else {
        //     return = false;
        // }
        return x % 2 == 0; 
    }

    public static void printLengthAndUpperCaseLowerCase(String sentence) {
        int length = sentence.length(); //lunghezza della stringa
        System.out.println(length);
        String lower = sentence.toLowerCase();
        System.out.println(lower);
        String upper = sentence.toUpperCase();
        System.out.println(upper);
    }

    public static String getlonger(String s1 , String s2) {
        // if(s1.length() > s2.length()) {
        //     return s1;
        // } else {
        //     return s2;
        // // }
        return s1.length() > s2.length() ? s1 : s2; //Operatore ternario (Lavora su 3 elementi) il ? segue un'espressione booleana
    }

    public static void printlnTiltleCase(String name) {
        System.out.println(name.length()); //stampa quello che ritorna della funzione legnth quando eseguita sulla stringa name
        System.out.println(name.toUpperCase()); //ritorna, crea e stampa una nuova stringa con la funzione uppercase sulla stringa name
        String upper = name.toUpperCase();
        String lower = name.toLowerCase();
        char first = name.charAt(0); //prende il primo carattere della stringa
        char firstUpper = Character.toUpperCase(first); //metodo statico di character che prende l'input first
        String subString = lower.substring(1);
        String result = firstUpper + subString;
        System.out.println(name);
        //le stringhe in java sono immutabili

    }
}