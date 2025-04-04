package org.generation.italy.slyngottsbank.accounts;

import org.generation.italy.slyngottsbank.exceptions.ExcessiveDepositException;
import org.generation.italy.slyngottsbank.exceptions.InvalidAmountException;
import org.generation.italy.slyngottsbank.movements.Movement;
import org.generation.italy.slyngottsbank.movements.MovementType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountPlatinum extends AccountGold {
    private int depositCounter;
    private int withdrawCounter;

    public AccountPlatinum(double initialBalance, LocalDate creationDate) {
        super(initialBalance, creationDate);
    }

    @Override
    public void deposit(double amount) throws ExcessiveDepositException {
        checkDepositAmount(amount);
        depositCounter++;
        balance += amount;
        Movement movePlatinum = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        movements.add(movePlatinum);
        if (depositCounter % 10 == 0) {
            balance += 10;
        }
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {
        checkWithdrawAmount(amount);
        if (amount >= 100) {
            withdrawCounter++;
        }
        if (withdrawCounter % 10 == 0) {
            balance += 10;
        }
        Movement movePlatinum = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        movements.add(movePlatinum);
        balance -= amount;
    }

    @Override
    public String getAccountName() {
        return "Platinum";
    }


}
