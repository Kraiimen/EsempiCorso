
import java.io.Console;

// Un programma che all'avvio chieda un numero 
// poi chiede un altro numero o Q per smettere di inserire (e cosi via finché non viene inserito Q)
// Alla fine il programma stampa il numero più grande ricevuto

public class QLeaving {

    public static void main(String[] args) {
        Console console = System.console();
        String input = "";
        int numeroPiuGrande = 0;


                 while (!input.equals("Q")) {
                    input = console.readLine("Inserisci un numero: \n");
                    if(input.equals("Q")) {
                        System.out.println(numeroPiuGrande);
                        break;
                    }
                    int inputInt = Integer.parseInt(input);
                    
                    if(inputInt > numeroPiuGrande) {
                        numeroPiuGrande = inputInt;
                    }
                  }
                 
 }
 
}
