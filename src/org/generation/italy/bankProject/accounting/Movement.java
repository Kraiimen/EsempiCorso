package org.generation.italy.bankProject.accounting;

      // import java.time.LocalDateTime; quando incotri una classe dateTime
import java.time.*;// quando incontri una classe che non rincosci vai a cercare nella classe time, usa le stesse prestazioni

public class Movement {
    // 1) Variabili di istanza dell'oggetto e sono visibili in tutta la classe, chiamati anche attributi e field.
    private double amount;
    private double currentBalance;
    private LocalDateTime operationTime;
    private MovementType type;

    // 2) Definizione del costruttore con rispettivi parametri

    public Movement(double amount, double  currentBalance,LocalDateTime operationTime,MovementType type) {
        this.amount = amount; // altra variabile amount che prende l assegnazione di am;
        this.currentBalance = currentBalance;
        this.operationTime = operationTime;
        this.type = type;

    // 3) FUNZIONI - prima quell importanti
    }
    public double getAmount(double amount){
        return amount;
    }
    public double getCurrentBalance() {
        return currentBalance;
    }
    public LocalDateTime getOperationTime() {
        return operationTime;
    }
    public MovementType getType() {
        return type;
    }

}
