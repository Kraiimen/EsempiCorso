package org.generation.italy.slyngottsbank.movements;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movement {
    private double amount;
    private double currentBalance;
    private LocalDateTime operationTime;
    private MovementType type;
    private static int lastId = 0;
    private int id;


    // COSTRUTTORE
    public Movement(double amount, double currentBalance, LocalDateTime operationTime, MovementType type) {
        this.amount = amount;
        this.currentBalance = currentBalance;
        this.operationTime = operationTime;
        this.type = type;
        lastId++;
        id = lastId;
    }


    // GETTERS
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

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return "N. transazione " + id + ": €" + amount + " " + operationTime.format(formatter) + " " + type + "\n";
    }
}

