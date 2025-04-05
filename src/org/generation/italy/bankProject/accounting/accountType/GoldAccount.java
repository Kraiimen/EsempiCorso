package org.generation.italy.bankProject.accounting.accountType;

import org.generation.italy.bankProject.accounting.Account;

import java.time.LocalDateTime;

public class GoldAccount extends Account {

    public GoldAccount(double initialBalance){
        super(initialBalance);
    }

    @Override
    public double deposit(double amount) {
        balance += amount;
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        movements.add(move);
        int depositCounter = 0;
        for(int i = 0; i < movements.size(); i++){
            if(move.getType() == MovementType.DEPOSIT){
                depositCounter++;
            }
        }
        if(depositCounter % 10 == 0){
            balance +=1;
        }
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
