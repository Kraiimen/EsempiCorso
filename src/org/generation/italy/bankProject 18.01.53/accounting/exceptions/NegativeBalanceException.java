package org.generation.italy.bankProject.accounting.bankProject.accounting.exceptions;

public class NegativeBalanceException extends RuntimeException {
    public NegativeBalanceException(String message) {
        super(message);
    }
}
