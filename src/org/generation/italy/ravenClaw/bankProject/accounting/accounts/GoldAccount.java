package org.generation.italy.ravenClaw.bankProject.accounting.accounts;

import org.generation.italy.ravenClaw.bankProject.accounting.Account;
import org.generation.italy.ravenClaw.bankProject.accounting.Movement;
import org.generation.italy.ravenClaw.bankProject.accounting.MovementType;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GoldAccount extends Account {
    private static final int DEPOSIT_TO_BONUS = 10;
    private static final int GOLD_BONUS = 1;
    private int nDeposit = 0;


    public GoldAccount(double balance){
        super(balance);
    }

    @Override
    public double deposit(double amount){

        if(amount <= 0 ) {
            return getBalance();
        } else {
            Movement move = new Movement(amount,getBalance(), LocalDateTime.now(), MovementType.DEPOSIT);
            getMovements().add(move);
            nDeposit++;
            setBalance(getBalance() + amount);
            if(nDeposit % DEPOSIT_TO_BONUS == 0 ){
                setBalance(getBalance() + GOLD_BONUS );
            }
            return getBalance();
        }
    }


}
