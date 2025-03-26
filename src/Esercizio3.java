import java.io.Console;

public class Esercizio3 {
    public static void main(String[] args) {
        int i ;
        int max = 0 ;
        String input = "";
        Console console = System.console();
        do {
        input = console.readLine("Dammi un numero o premi Q per terminare ") ;
        if (!input.equals("Q")) {
            i = Integer.parseInt(input);
            if (i > max) {
                max = i;
            }
        } 

        } while (!input.equals("Q")) ;
        System.out.println("il numero più grande è " + max );

    }
    
}
// Un programma che all'avvio chieda un numero
// poi chiede un altro numero o Q per smettere di inserire (e cosi via finché non viene inserito Q)
// Alla fine il programma stampa il numero più grande ricevuto