package org.generation.italy.slyngottsbank.exceptions;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException() {
        super("Errore: stai tentando di ritirare più del tuo saldo");
    }

    public InvalidAmountException(String message) {
        super(message);
    }
}
