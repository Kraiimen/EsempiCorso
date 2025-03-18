import java.io.Console;

public class Methods {
    public static void main(String[] args) {
        int x1 = readInteger();
        int x2 = readInteger();

        System.out.println("La somma dei due numeri è " + sum(x1, x2));
        printSum(x1, x2);
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
}
