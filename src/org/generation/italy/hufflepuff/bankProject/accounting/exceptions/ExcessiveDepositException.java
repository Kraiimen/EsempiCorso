package org.generation.italy.hufflepuff.bankProject.accounting.exceptions;

public class ExcessiveDepositException extends RuntimeException {
    public ExcessiveDepositException() {
        super("Hai superato il limite di deposito!");
    }
}
