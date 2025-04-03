package org.generation.italy.slyngottsbank.accounts;

import org.generation.italy.slyngottsbank.movements.Movement;
import org.generation.italy.slyngottsbank.movements.MovementType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountGold extends Account{
    private int depositCounter;

    public AccountGold(double initialBalance, LocalDate creationDate){
        super(initialBalance, creationDate);
    }

    @Override
    public void deposit(double amount){
        balance += amount;
        Movement moveGold = new Movement(amount,balance,LocalDateTime.now(), MovementType.DEPOSIT);
        movements.add(moveGold);
        depositCounter++;
        if (depositCounter % 10 == 0){
            balance += 1;
        }

    }

    @Override
    public String getAccountName(){
        return "Gold";
    }


}
