package org.generation.italy.slyngottsbank.exceptions;

public class ExcessiveDepositException extends RuntimeException {
    public ExcessiveDepositException() {
        super("Errore: non puoi depositare più di 100.000 euro");
    }

    public ExcessiveDepositException(String message) {
        super(message);
    }


}
