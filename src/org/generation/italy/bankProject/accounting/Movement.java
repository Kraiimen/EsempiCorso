package org.generation.italy.bankProject.accounting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedData = operationTime.format(formatter);

        return String.format("------------------\n" +
                             "TYPE: %-10s\n" +
                             "AMOUNT: %.2f€\n" +
                             "DATA: %s\n" +
                             "------------------",
                             type, amount, formattedData);
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
