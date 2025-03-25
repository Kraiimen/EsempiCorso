package org.generation.italy.bankProject.accounting;

import java.time.LocalDateTime;

public class Movement {
    private double amount;
    private double currentBalance;
    private LocalDateTime operationTime;
    private MovementType type;

    public Movement(double amount, double currentBalance, LocalDateTime operationTime, MovementType type){
        this.amount = amount;
        this.currentBalance = currentBalance;
        this.operationTime = operationTime;
        this.type = type;
    }

    public double getAmount(){
        return amount;
    }

    public double getCurrentBalance(){
        return currentBalance;
    }

    public LocalDateTime getOperationTime(){
        return operationTime;
    }

    public MovementType getType(){
        return type;
    }
}
