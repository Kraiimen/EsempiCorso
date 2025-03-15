import java.io.Console;

public class ExsWhileQ {
    public static void main(String[] args) {
        Console console=System.console();
        String input="";

        do {
            System.out.print("Enter a number, enter \"q\" to stop: ");
            input=console.readLine();

        } while (!input.toLowerCase().equals("q") );
        
        System.out.print("You're done, congrats bro!");
    }
}
