import java.io.Console;

public class SimpleIf {
    public static void main(String[] args) { 

        // il programma stampa quale numero è maggiore
        // int n = 5;
        // int m = 8;
        // if(n > m){
        //     System.out.println("il numero: " + n + " è maggiore");
        // } else if( m > n){
        //     System.out.println("il numero: " + m + " è maggiore");
        // } else {
        //     System.out.println("i numeri sono uguali");
        // }


        Console console = System.console();
        String input = "";

        do {
            System.out.println("Inserisci un numero (o 'q' per uscire):");
            input = console.readLine();

            // Se l'utente inserisce 'q', esci dal ciclo
            if (input.equals("q")) {
                System.out.println("Uscita dal programma.");
                break; // Esce dal ciclo do-while
            }

            try {
                int numero = Integer.parseInt(input); // Converte l'input in un numero intero
                if (numero > 0) {
                    System.out.println("Il numero " + numero + " è positivo");
                } else if (numero < 0) {
                    System.out.println("Il numero " + numero + " è negativo");
                } else {
                    System.out.println("Il numero " + numero + " è uguale a 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input non valido! Inserisci un numero intero o 'q' per uscire.");
            }

        } while (!input.equals("q"));
    }
}