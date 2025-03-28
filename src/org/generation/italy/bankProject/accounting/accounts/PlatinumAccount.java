package org.generation.italy.bankProject.accounting.accounts;

import org.generation.italy.bankProject.accounting.*;

import java.time.*;

public class PlatinumAccount extends GoldAccount{
    private static final int BONUS_PLATINUM = 10;
    private int totalWithdrawOver100;


    // /--CONSTRUCTORS--/
    public PlatinumAccount() {
    }

    public PlatinumAccount(double initialBalance) {
        super(initialBalance);
    }

    public PlatinumAccount(double initialBalance, LocalDate initialDate) {
        super(initialBalance, initialDate);
    }

    // /--METHODS--/
    @Override
    public double deposit(double amount){
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
