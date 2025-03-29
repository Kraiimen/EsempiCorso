package org.generation.italy.bankProject.accounting;

//import java.time.LocalDateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Movement {
    protected static int mvId;
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
        ++mvId;
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

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedData = getOperationTime().format(formatter);
        return "ID: " + mvId + "\nMovement amount: "+ getAmount() + "\nYour new balance: " + getCurrentBalance() + "\nOperation time: "
                + formattedData + "\nMovement Type: " + getType();
    }


}