import java.io.Console;
public class Methods {
    public static void main(String[] args) {
    //     sumConsole();
    //     int x = readInteger();
    //    int z = sum(3,5);

      int lenght =  greetWithName(" Elvis");
      System.out.println(lenght);
      boolean even = isEven(lenght);
      System.out.println(even);
      printLenAndUpperCaseLowerCase("eLvIs");
      String longerName = getLonger("Elvis", "Sempronio");
      System.out.println(longerName);
    }



    public static int readInteger() {
        Console console = System.console();
        String input = console.readLine("dammi un numero: ");
        int x = Integer.parseInt(input);

        return x;

    }
    public static int sum(int x1, int x2) {
        int z = x1 + x2;
        return z;
    }

    public static int sumConsole() {
        Console console = System.console();
        String input1 = console.readLine("Dammi un numero: ");
        String input2 = console.readLine("Dammi un altro numero: ");
        int num1 = Integer.parseInt(input1);
        int num2 = Integer.parseInt(input2);

        return num1 + num2;
    }


    public static void greet() {
        System.out.println("è un piacere conoscerti");
    }

    public static int greetWithName(String name) {
        System.out.println("è un piacere conoscerti" + name);
        int len = name.length();
        return len;
    }

    public static boolean isEven(int number) {
     return number % 2 == 0;
    }

    public static void printLenAndUpperCaseLowerCase(String name) {
        System.out.println(name.length()); //non è un metodo statico perché il metodo viene chiamato sulla stringa stessa e non sulla classe String
        System.out.println(name.toUpperCase()); //non è un metodo statico
        String lower = name.toLowerCase();
        char first = name.charAt(0); //prende il primo carattere della stringa
        char firstUpper = Character.toUpperCase(first);
        String substring = lower.substring(1);
        String result = firstUpper + substring;
        System.out.println(result);
        // String correctPrint = correctPrint.toUpperCase().charAt(0); //mia linea di codice errata
    }

    
    public static String getLonger (String name, String name2) {
        // if(name.length() < name2.length()) {
        //     return name2;
        // }
        // else {
            return name.length() > name2.length() ? name : name2;
        }
        
}


