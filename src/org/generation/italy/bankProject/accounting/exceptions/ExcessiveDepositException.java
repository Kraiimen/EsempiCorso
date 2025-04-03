package org.generation.italy.bankProject.accounting.exceptions;

public class ExcessiveDepositException extends RuntimeException {
    public ExcessiveDepositException() {
        super("Hai superato il limite di deposito!");
    }
}
