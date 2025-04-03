package org.generation.italy.bankProject.accounting.exceptions;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException() {
        super("Hai superato il limite di prelievo del tuo saldo!");
    }
}
