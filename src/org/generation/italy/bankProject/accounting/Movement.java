package org.generation.italy.bankProject.accounting;

//import java.time.LocalDateTime;

import java.time.*;
public class Movement {

    private double amount;//variabile oggetti ammount
    private double currentBalance;
    private LocalDateTime operationTime;
    private MovementType type; // importato enum

    // costruttore
    public Movement(double amount, double currentBalance, LocalDateTime operationTime, MovementType type){
        this.amount = amount; // this assegna il parametro alla variabile amount dell'oggetto che stiamo costruendo
        this.currentBalance = currentBalance;
        this.operationTime = operationTime;
        this.type = type;
        // this è una keyword per dare lo stesso nome dei parametri che devo utilizzare. dentro il costruttore che sta creando un oggetto
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
