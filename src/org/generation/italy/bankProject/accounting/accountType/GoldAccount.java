package org.generation.italy.bankProject.accounting.accountType;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.ItalianMovement;
import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;

import java.time.LocalDateTime;

public class GoldAccount extends Account {

    public GoldAccount(double initialBalance){
            super(initialBalance);
        }


    public double deposit(double amount) {
        balance += amount;
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        movements.add(move);

        // Conta quanti depositi sono stati fatti fino ad ora
        int depositCount = 0;
        for (Object o  : movements) {
            Movement m = (Movement) o;
            if (m.getType() == MovementType.DEPOSIT) {
                depositCount++;
            }
        }
        // Ogni 10 depositi, aggiungi 1 al saldo
        if (depositCount % 10 == 0) {
            balance += 1;
        }

        return balance;
    }

    public void printGoldMovement () {
        for (Object o : movements) {
            Movement m1 = (Movement) o;
            System.out.println(m1);
        }
    }
}
