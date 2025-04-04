package org.generation.italy.hufflepuff.bankProject.accounting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItalianMovement extends Movement {
    private double tax;

    public ItalianMovement(double amount, double currentBalance, LocalDateTime operationTime, MovementType type, double tax){
        super(amount, currentBalance, operationTime, type);
        this.tax = tax;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedData = getOperationTime().format(formatter);
        return "ID: " + getId() +"\nMovement amount: "+ getAmount() + "\nYour balance: " + "\nOperation time: "
                + formattedData + "\nMovement Type: " + getType() + "\nTax for this movement: " + tax;
    }
}
