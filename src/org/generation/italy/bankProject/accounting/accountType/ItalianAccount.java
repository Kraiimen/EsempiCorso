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
        tax = amount *0.1;
        amount *= 0.9;
        balance += amount;
        ItalianMovement move = new ItalianMovement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT, tax);
        movements.add(move);
        System.out.println("Grazie pezzente per la tassa " + tax + " bilancio " + balance);
        return balance;
    }

    public void printItalianMovement (){
        for(Object o: movements){
            ItalianMovement m1 = (ItalianMovement) o;
            System.out.println(m1);
        }
    }


}
