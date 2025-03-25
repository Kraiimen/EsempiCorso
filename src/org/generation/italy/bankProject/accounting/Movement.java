package org.generation.italy.bankProject.accounting;

//import java.time.LocalDateTime;

import java.time.*;

public class Movement {

    //public static final String WITHDRAWAL = "WITHDRAWAL";
    //public static final String DEPOSIT = "DEPOSIT"; le usavo prima di Enum.
    private double amount;
    private double currentBalance;
    private LocalDateTime operationTime;
    private MovementType type;

    //costruttore.
    public Movement(double amount, double currentBalance, LocalDateTime operationTime, MovementType t) {
        this.amount = amount;
        this.currentBalance = currentBalance;
        this.operationTime = operationTime;
        this.type = type;
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
