package org.generation.italy.slyngottsbank.accounts;

import org.generation.italy.slyngottsbank.movements.Movement;
import org.generation.italy.slyngottsbank.movements.MovementType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ItalianAccount extends Account {

    final double TAX_PERCENTAGE;

    public ItalianAccount(double initialBalance, LocalDate creationDate) {
        super(initialBalance);
        TAX_PERCENTAGE = 0.1;

    }

    public double applyTax(double amount) {
        amount *= (1 - TAX_PERCENTAGE);
        return amount;
    }

    @Override
    public double deposit(double amount) {
        applyTax(amount);
        balance += amount;
        Movement italianMovement = new Movement(amount * (1 - TAX_PERCENTAGE), balance, LocalDateTime.now(), MovementType.DEPOSIT);
        movements.add(italianMovement);
        System.out.println("Thank you for donating 10% of your transaction to cover the movement tax");
        return balance;
    }

    public void trackTax(double amount) {


    }


}
