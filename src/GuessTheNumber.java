import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {

        Random dice = new Random();
        int n = dice.nextInt(100_001); // Genera un numero casuale tra 0 e 100.000
        int nUtente = 0; // Simuliamo un tentativo iniziale
        int tentativi = 0;

        System.out.println("Gioco 'Indovina il Numero' iniziato.");
        System.out.println("Il numero misterioso è stato generato. Simuliamo i tentativi...");

        do {
            nUtente = dice.nextInt(100_001); // Simuliamo una scelta casuale dell'utente
            tentativi++;

            if (nUtente < n) {
                System.out.println(nUtente + " è troppo piccolo.");
            } else if (nUtente > n) {
                System.out.println(nUtente + " è troppo grande.");
            }

        } while (nUtente != n);

        System.out.println("Il numero misterioso era" + n + ".");
        System.out.println("Numero di tentativi:" + tentativi);
    }
}


 //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta
        //se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero è più piccolo"
        //Caso inverso della seconda riga
        //Il programma tiene conto del numero dei tentativi e li riporti a fine del processo il numero di tentativi.

