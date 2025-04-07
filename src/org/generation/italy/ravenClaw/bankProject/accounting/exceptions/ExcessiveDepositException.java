package org.generation.italy.ravenClaw.bankProject.accounting.exceptions;

public class ExcessiveDepositException extends Exception {
    public ExcessiveDepositException() {
        super("Array of money is out of bounds");
    }
}
