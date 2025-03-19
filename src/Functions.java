import java.io.Console;
public class Functions {
    
    public static void main(String[] args) {
        int val1 = ReadInt();
        int val2 = ReadInt();
        System.out.println("La somma dei due numeri è: " + (val1+val2));
    }
    public static int ReadInt(){
        Console console = System.console();
        String input = console.readLine("inserisci un numero: ");
        return Integer.parseInt(input);

    }
    
}
