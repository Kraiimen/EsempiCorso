package org.generation.italy.bankProject.accounting;

import java.time.*;
import java.util.ArrayList;

public class Movement {
    //-------------------FIELDS---------------------
    private double amount;
    private double currentBalance;
    private LocalDateTime operationTime;
    private MovementType type;

    //-----------------COSTRUTTORE------------------
    public Movement(double amount, double balance, LocalDateTime operationTime, MovementType type){
        this.amount = amount;
        currentBalance = balance;
        this.operationTime = operationTime;
        this.type = type;
    }

    //---------------GETTER & SETTER-----------------
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }
    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }

    public MovementType getType() {
        return type;
    }
    public void setType(MovementType type) {

        this.type = type;
    }
}
