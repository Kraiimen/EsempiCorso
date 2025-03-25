import java.io.Console;

public class Methods {
    public static void main(String[] args) {
        int x1 = readInteger();
        int x2 = readInteger();

        System.out.println("La somma dei due numeri è " + sum(x1, x2));
        printSum(x1, x2);

        greet();
        System.out.println(greetWithName("Carmine"));

        int n = 2;
        System.out.println("Il numero "+n+" è pari? "+isEven(n));

        System.out.println("La stringa più lunga è: "+getLongerString("Ciao", "Buonasera"));
    }

    public static int readInteger(){
        Console console = System.console();

        String input = console.readLine("Inserisci un numero: ");

        return Integer.parseInt(input);
    }

    public static int sum(int x, int y){
        return (x + y);
    }

    public static void printSum(int x, int y){
        System.out.println("printSum() --> La somma dei due numeri è " + (x + y));


    }

    public static void greet(){
        System.out.println("Ciao!");
    }

    public static int greetWithName(String name){
        System.out.println("Ciao "+name+"!");
        return name.length();
    }

    public static boolean isEven(int x){
        return x % 2 == 0;
    }

    public static String getLongerString(String str1, String str2){
        // if(str1.length() > str2.length()){
        //     return str1;
        // } else {
        //     return str2;
        // }

        return str1.length() > str2.length() ? str1 : str2;
    }
}
