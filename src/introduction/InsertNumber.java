package introduction;

import java.io.Console;

public class InsertNumber {
    public static void main(String[] args) {
        Console console = System.console();

        // voglio il programma parta e ti dica "dammi un numero", tu gli dici il numero
        // il programma dice "dammi un altro numero o scrivi "q" per smettere" e avanti
        // cosi, finche non scrivi q.
        // quando scrivi q
        // ti risponde con il numero piu grande che gli hai dato

        String ns;
        String ns2;
        int x;
        int maxVal = 0;
        System.out.println("Dammi un numero");
        ns = console.readLine();
        x = Integer.parseInt(ns);
        // numbers.add(x);
        do {
            System.out.println("Dammi un'altro numero o scrivi q");
            ns2 = console.readLine();
            if (!ns2.equals("q")) {
                x = Integer.parseInt(ns2);
                if (x > maxVal) {
                    maxVal = x;
                }
            }
        } while (!ns2.equals("q"));
        System.out.print("Il valore massimo inserito è " + maxVal);
    }
}