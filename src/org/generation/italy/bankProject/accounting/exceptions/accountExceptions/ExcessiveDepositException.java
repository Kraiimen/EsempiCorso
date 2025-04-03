package org.generation.italy.bankProject.accounting.exceptions.accountExceptions;

public class ExcessiveDepositException extends Exception {
    public ExcessiveDepositException() {
        super("Non puoi depositare più di 100000 euro");
    }
}
