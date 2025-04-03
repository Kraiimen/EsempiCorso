package org.generation.italy.ravenClaw.bankProject.accounting.accounts;

import org.generation.italy.ravenClaw.bankProject.accounting.Account;
import org.generation.italy.ravenClaw.bankProject.accounting.Movement;
import org.generation.italy.ravenClaw.bankProject.accounting.MovementType;
import org.generation.italy.ravenClaw.bankProject.accounting.exceptions.ExcessiveDepositException;
import org.generation.italy.ravenClaw.bankProject.accounting.exceptions.InvalidAmountException;

import java.time.LocalDateTime;

public class PlatinumAccount extends Account {
    private static final int DEPOSIT_TO_BONUS = 10;
    private static final int PLATINUM_WITHDRAW_TO_BONUS = 10;
    private static final int PLATINUM_MOVEMENT_BONUS = 10;
    private static final int MOVEMENT_TO_BONUS = 10;
    private static final int PLATINUM_WITHDRAW_BONUS = 10;
    private static final int PLATINUM_DEPOSIT_BONUS = 10;
    private static final int MINIMUM_AMOUNT_WITHDRAW_TO_BONUS = 100;
    private int nDeposit = 0;
    private int nWithdraw = 0;


    public PlatinumAccount(double balance){
        super(balance);
    }

    @Override
    public double deposit(double amount) throws ExcessiveDepositException, InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException("Error: dammi un numero positivo");
        }
        if(amount > 100_000){
            throw new ExcessiveDepositException();
        }
        Movement move = new Movement(amount, getBalance(), LocalDateTime.now(), MovementType.DEPOSIT);
        getMovements().add(move);
        giveBonus();
        nDeposit++;
        setBalance(getBalance() + amount);
        if (nDeposit % DEPOSIT_TO_BONUS == 0) {
            setBalance(getBalance() + PLATINUM_DEPOSIT_BONUS);
        }
        return getBalance();
    }


    @Override
    public double withdraw(double amount) throws InvalidAmountException {
        if(amount < 0 ){
            throw new InvalidAmountException("Inserisci un importo positivo");
        }
        if(getBalance() < amount){
            throw new InvalidAmountException("Il tuo bilancio è minore di quanto stai provando a ritirare");
        }
        Movement move = new Movement(amount, getBalance(), LocalDateTime.now(), MovementType.WITHDRAWAL);
        setBalance(getBalance() - amount);
        getMovements().add(move);
        giveBonus();
        if(amount > MINIMUM_AMOUNT_WITHDRAW_TO_BONUS ){
            nWithdraw++;
            if(nWithdraw % PLATINUM_WITHDRAW_TO_BONUS == 0){
                setBalance(getBalance() + PLATINUM_WITHDRAW_BONUS);
            }
        }
        return getBalance();
    }
    public void giveBonus(){
        if(getMovements().size() % MOVEMENT_TO_BONUS == 0){
            setBalance(getBalance() + PLATINUM_MOVEMENT_BONUS);
        }
    }
}