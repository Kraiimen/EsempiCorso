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
        @Override
        public double deposit(double amount) {
            balance += amount;
            Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
            movements.add(move);
            for (int i = 0; i < movements.size(); i++) {
                if ((movements.size() % 10 == 0) && (move.getType() == MovementType.DEPOSIT)) {
                    balance += 0.1;
                }
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
