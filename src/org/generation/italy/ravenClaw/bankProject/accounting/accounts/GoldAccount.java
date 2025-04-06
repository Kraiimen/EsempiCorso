package org.generation.italy.ravenClaw.bankProject.accounting.accounts;

import org.generation.italy.ravenClaw.bankProject.accounting.Account;
import org.generation.italy.ravenClaw.bankProject.accounting.Movement;
import org.generation.italy.ravenClaw.bankProject.accounting.MovementType;
import org.generation.italy.ravenClaw.bankProject.accounting.exceptions.ExcessiveDepositException;
import org.generation.italy.ravenClaw.bankProject.accounting.exceptions.InvalidAmountException;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GoldAccount extends Account {
    private static final int DEPOSIT_TO_BONUS = 10;
    private static final int GOLD_BONUS = 1;
    private int nDeposit = 0;


    public GoldAccount(double balance, String ownerCode){
        super(balance,ownerCode);
    }

    @Override
    public double deposit(double amount) throws ExcessiveDepositException,InvalidAmountException {

        isAmountValid(amount);
        isDepositTooBig(amount);

        Movement move = new Movement(amount, getBalance(), LocalDateTime.now(), MovementType.DEPOSIT);
        getMovements().add(move);
        nDeposit++;
        setBalance(getBalance() + amount);
        if (nDeposit % DEPOSIT_TO_BONUS == 0) {
            setBalance(getBalance() + GOLD_BONUS);
        }
        return getBalance();
    }
//    @Override
//    public void temp() {
//
//    }

}