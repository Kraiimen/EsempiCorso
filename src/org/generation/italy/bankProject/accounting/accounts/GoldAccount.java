package org.generation.italy.bankProject.accounting.accounts;

import org.generation.italy.bankProject.accounting.*;

import java.time.*;

public class GoldAccount extends Account {
    private int totDeposits;
    private static final int BONUS_GOLD = 1;


    // /--CONSTRUCTORS--/
    public GoldAccount() {
    }

    public GoldAccount(double initialBalance) {
        super(initialBalance);
    }

    public GoldAccount(double initialBalance, LocalDate initialDate) {
        super(initialBalance, initialDate);
    }

    // /--METHODS--/
    @Override
    public double deposit(double amount){
        totDeposits++;
        if(totDeposits % 10 == 0){
            Movement bonus = new Movement(BONUS_GOLD, balance, LocalDateTime.now(), MovementType.BONUS);
            addMovement(bonus);
        }
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        addMovement(move);
        balance += amount;
        return balance;
    }
    @Override
    public double withdraw(double amount) {
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        addMovement(move);
        balance -= amount;
        return balance;
    }

    // /--GETTER & SETTER--/
    public int getTotDeposits() {
        return totDeposits;
    }
    public void setTotDeposits(int totDeposits) {
        this.totDeposits = totDeposits;
    }
    public int getBonusGold(){
        return BONUS_GOLD;
    }
}
