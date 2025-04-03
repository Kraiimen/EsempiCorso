package ExceptionsExample;

public class ElvisException extends Exception {
    public ElvisException() {
        super("Errore: inserisci un valore minore di 100.000");
    }
}
