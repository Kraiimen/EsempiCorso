package org.generation.italy.slyngottsbank.exceptions;

public class PoliceException extends RuntimeException {
    public PoliceException() {
        super("Stop: sei stato beccato!");
    }

    public PoliceException(String message) {
        super(message);
    }
}
