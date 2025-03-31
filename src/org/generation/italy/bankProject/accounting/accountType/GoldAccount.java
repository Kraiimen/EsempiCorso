package org.generation.italy.bankProject.accounting.accountType;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.ItalianMovement;
import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;

import java.time.LocalDateTime;

public class GoldAccount extends Account {
    protected int bonus;

    public GoldAccount(double initialBalance){
        super(initialBalance);
        bonus = 1;
    }

    @Override
    public double deposit(double amount) {
        balance += amount;

        int depositCounter = 1;

        for(Object obj : movements){
            Movement m1 = (Movement) obj;
            if(m1.getType() == MovementType.DEPOSIT){
                depositCounter++;
            }
        }
        System.out.println(depositCounter);
        if(depositCounter % 10 == 0){
            balance +=bonus;
            System.out.println("Bonus");
        }
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        movements.add(move);

        return balance;
    }

    @Override
    public double withdraw(double amount){
        balance -= amount;
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        movements.add(move);
        return balance;
    }

}
