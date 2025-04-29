import java.io.Console;

public class Exceptions {
    public static void main(String[] args){
        Console console = System.console();

        String answer = console.readLine("Inserisci due numeri separati da virgola:");
        String stringWithoutSpaces = answer.replaceAll("\\s", "");
        String[] array = stringWithoutSpaces.split(",");

        try {
            int number1 = Integer.parseInt(array[0]);
            int number2 = Integer.parseInt(array[1]);
            double number3 = number1 / number2;
            System.out.println(number3);
        } catch(ArithmeticException | NumberFormatException | ArrayIndexOutOfBoundsException e){
            System.err.print("Error: " + e.getMessage());
        }
    }
    public static double division(int a, int b) throws ArithmeticException{
        return a / b;
    }
}
