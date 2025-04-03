package org.generation.italy.fantasykingdom;

public class InvalidAttackException extends RuntimeException {
    public InvalidAttackException() {
        super("Error: attack is invalid");
    }

    public InvalidAttackException(String message) {
        super(message);
    }
}
