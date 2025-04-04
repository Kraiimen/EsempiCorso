package org.generation.italy.bankProject.accounting.accountType;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.ItalianMovement;
import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;
import org.generation.italy.bankProject.accounting.exceptions.ExcessiveDepositException;

import java.time.LocalDateTime;

public class GoldAccount extends Account {
    protected int bonus;
    public GoldAccount(double initialBalance){
            super(initialBalance);
            bonus = 1;
    }


    public double deposit(double amount) throws ExcessiveDepositException{

        checkAmountForDeposit(amount);
        balance += amount;
        // Conta quanti depositi sono stati fatti fino ad ora
        int depositCount = 1;
        for (Object o : movements) {
            Movement m = (Movement) o;
            if (m.getType() == MovementType.DEPOSIT) {
                depositCount++;
            }
        }
        // Ogni 10 depositi, aggiungi 1 al saldo
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

    public void printGoldMovement () {
        for (Object o : movements) {
            Movement m1 = (Movement) o;
            System.out.println(m1);
        }
    }
}
