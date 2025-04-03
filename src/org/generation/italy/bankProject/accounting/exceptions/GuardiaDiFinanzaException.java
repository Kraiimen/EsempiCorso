package org.generation.italy.bankProject.accounting.exceptions;

public class GuardiaDiFinanzaException extends RuntimeException {
    public GuardiaDiFinanzaException() {
        super("Sei stato beccato ed arrestato dagli sbirri");
    }
}
