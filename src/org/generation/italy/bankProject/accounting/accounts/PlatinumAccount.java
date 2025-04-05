package org.generation.italy.bankProject.accounting.accounts;

import org.generation.italy.bankProject.accounting.*;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.ExcessiveDepositException;
import org.generation.italy.bankProject.accounting.movements.Movement;
import org.generation.italy.bankProject.accounting.movements.MovementType;

import java.time.*;

public class PlatinumAccount extends GoldAccount{
    private static final int BONUS_PLATINUM = 10;
    private int totalWithdrawOver100;


    // /--CONSTRUCTORS--/
    public PlatinumAccount(Client client) {
        super(client);
    }

    public PlatinumAccount(double initialBalance, Client client) {
        super(initialBalance, client);
    }

    public PlatinumAccount(double initialBalance, LocalDate initialDate, Client client) {
        super(initialBalance, initialDate, client);
    }

    // /--METHODS--/
    @Override
    public double deposit(double amount) throws ExcessiveDepositException {
        if (amount > 100_000) {
            throw new ExcessiveDepositException();
        }
        setTotDeposits(getTotDeposits()+1); //totDeposits++
        if(getTotDeposits() % 10 == 0){
            Movement bonus = new Movement(BONUS_PLATINUM, balance, LocalDateTime.now(), MovementType.BONUS);
            addMovement(bonus);
        }
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        addMovement(move);
        balance += amount;
        return balance;
    }
    @Override
    public double withdraw(double amount){
        //totalWithdrawOver100 = amount > 100 ? ++totalWithdrawOver100 : totalWithdrawOver100;
        if(amount>100){
            totalWithdrawOver100++;
        }
        if(totalWithdrawOver100 % 10 == 0){
            Movement bonus = new Movement(BONUS_PLATINUM, balance, LocalDateTime.now(), MovementType.BONUS);
            addMovement(bonus);
        }
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        addMovement(move);
        balance -= amount;
        return balance;
    }

    // /--GETTER & SETTER--/
    public int getBonusPlatinum(){
        return BONUS_PLATINUM;
    }

}
