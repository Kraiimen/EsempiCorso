package org.generation.italy.bankProject.accounting.accountType;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;

import java.time.LocalDateTime;

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
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        movements.add(move);
        System.out.println("Grazie pezzente" + " tassa " + tax + " bilancio " + balance);
        movements.add(tax);
        return balance;
    }
    public void printItalianMovement (){
        for(Object o: movements){
            Movement m1 = (Movement) o;

        }
    }


}
