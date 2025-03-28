package org.generation.italy.bankProject.accounting;

//import java.time.LocalDateTime;

import java.time.*;
public class Movement {
    protected static int lastId;
    private double amount;
    private double currentBalance;
    private LocalDateTime operationTime;
    private MovementType type;

    //costruttore
    public Movement(double amount, double currentBalance, LocalDateTime operationTime, MovementType type) {
        //this è un puntatore che indica l'oggetto che stiamo creando (this.amount)
        this.amount = amount;
        this.currentBalance = currentBalance;
        this.operationTime = operationTime;
        this.type = type;
        ++lastId;
    }
    public double getAmount() {
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