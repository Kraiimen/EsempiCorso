package org.generation.italy.bankProject.accounting.accountType;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.ItalianMovement;
import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItalianAccount extends Account {
    private double tax;

    public ItalianAccount(double initialBalance){
        super(initialBalance);
    }

    @Override
    public double deposit(double amount){
        tax = 0.1;
        double taxedAmount = amount * tax;
        amount -= taxedAmount;
        ItalianMovement move = new ItalianMovement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT, taxedAmount);
        movements.add(move);
        balance += amount;
        System.out.println("Grazie pezzente per la tassa di " + taxedAmount + "€. Il tuo bilancio ora è di " + balance + "€.");
        return balance;
    }

    @Override
    public double withdraw(double amount){
        tax = 0;
        double taxedAmount = amount * tax;
        double newAmount = amount - taxedAmount;
        ItalianMovement move = new ItalianMovement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL, taxedAmount);
        movements.add(move);
        balance -= amount;
        return balance;
    }

    @Override
    public void printAllMovement (){
        for(Object obj: movements){
            ItalianMovement m1 = (ItalianMovement) obj;
            System.out.println(m1);
        }
    }


}
