package org.generation.italy.bankProject.accounting.exceptions;

public class NegativeBalanceException extends Exception {

    public NegativeBalanceException() {

        super("Il saldo non può essere negativo");
    }
    
    public NegativeBalanceException(String message) {
        super(message);
    }

}
