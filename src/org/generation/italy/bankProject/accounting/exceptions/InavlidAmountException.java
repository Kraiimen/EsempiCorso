package org.generation.italy.bankProject.accounting.exceptions;

public class InavlidAmountException extends Exception {
    public InavlidAmountException(){

        super("Il prelievo ha superato di gran lunga il saldo attuale");
    }

}
