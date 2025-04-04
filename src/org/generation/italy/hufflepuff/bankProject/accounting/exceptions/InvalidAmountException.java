package org.generation.italy.hufflepuff.bankProject.accounting.exceptions;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException() {
        super("Hai superato il limite di prelievo del tuo saldo!");
    }
}
