package org.generation.italy.bankProject.accounting.exceptions;

public class DataException extends RuntimeException {
    public DataException(String message, Throwable cause) {
        super(message,cause);
    }
    public DataException(String message){
      super(message);
    }
}
