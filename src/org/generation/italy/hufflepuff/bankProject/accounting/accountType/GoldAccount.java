package org.generation.italy.hufflepuff.bankProject.accounting.accountType;

import org.generation.italy.hufflepuff.bankProject.accounting.Movement;
import org.generation.italy.hufflepuff.bankProject.accounting.MovementType;
import org.generation.italy.hufflepuff.bankProject.accounting.exceptions.ExcessiveDepositException;

import java.time.LocalDateTime;

public class GoldAccount extends Account {
    protected int bonus;
    public GoldAccount(double initialBalance){
            super(initialBalance);
            bonus = 1;
    }

    public double deposit(double amount) throws ExcessiveDepositException {

        checkAmountForDeposit(amount);
        balance += amount;
        int depositCount = 1;
        for (Object o : movements) {
            Movement m = (Movement) o;
            if (m.getType() == MovementType.DEPOSIT) {
                depositCount++;
            }
        }
        if (depositCount % 10 == 0) {
            balance += bonus;
        }
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        movements.add(move);
        return balance;
    }

    @Override
    public double withdraw(double amount) {
        balance -= amount;
        return balance;
    }
}
