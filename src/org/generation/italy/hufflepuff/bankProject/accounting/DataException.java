package org.generation.italy.hufflepuff.bankProject.accounting;

public class DataException extends Exception {
    public DataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataException(String message) {
        super(message);
    }
}
