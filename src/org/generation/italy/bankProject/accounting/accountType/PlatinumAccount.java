package org.generation.italy.bankProject.accounting.accountType;

import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;

import java.time.LocalDateTime;

public class PlatinumAccount extends GoldAccount {

    public PlatinumAccount(double initialBalance){
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
        System.out.println(depositCounter);
        if(depositCounter % 10 == 0){
            balance +=10;
            System.out.println("Bonus");
        }
        return balance;
    }

    @Override
    public double withdraw(double amount){
        balance -= amount;
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        movements.add(move);

        int withdrawalCounter = 0;
        for(int i = 0; i < movements.size(); i++){
            if((move.getType() == MovementType.WITHDRAWAL) && (amount >= 100)){
                withdrawalCounter++;
            }
        }
        System.out.println(withdrawalCounter);
        if(withdrawalCounter % 10 == 0){
            balance +=10;
            System.out.println("Bonus");
        }
        return balance;
    }

}
