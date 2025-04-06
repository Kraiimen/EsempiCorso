package org.generation.italy.bankProject.accounting.exceptions.accountExceptions;

public class InvalidAmountException extends Exception {
    public InvalidAmountException() {
        super("Non puoi ritirare più del saldo");
    }
}
