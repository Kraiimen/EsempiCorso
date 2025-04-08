package org.generation.italy.bankProject.accounting;

public class DataException extends RuntimeException {
    public DataException(String message, Throwable cause) {

        super(message, cause);
    }
    public DataException(String message){
        super(message);
    }
}
