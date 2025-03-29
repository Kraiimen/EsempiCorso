package org.generation.italy.bankProject.accounting.accountType;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;

import java.time.LocalDateTime;

public class PlatinumAccount extends Account {

        public PlatinumAccount(double initialBalance){
        super(initialBalance);
        }

        @Override
        public double deposit(double amount) {
            int depositCounter = 1;
            balance += amount;
            for (Object o : movements) {
                Movement m1 = (Movement) o;
                if (m1.getType() == MovementType.DEPOSIT) {
                    depositCounter++;
                }
            }
            if (depositCounter % 10 == 0) {
                balance += 10;
                System.out.println("Congratulazione hai ricevuto 10$ per i tuoi 10 depositi precendenti" );
            }
            Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
            movements.add(move);
            return balance;
        }

        @Override
        public double withdraw(double amount) {
            int withdrawCounter = 1;
            balance -= amount;
            for (Object o : movements) {
                Movement m2 = (Movement) o;
                if (m2.getType() == MovementType.WITHDRAWAL) {
                    withdrawCounter++;
                }
            }
            if (withdrawCounter % 10 == 0 && amount >= 100) {
                balance += 10;
                System.out.println("Congratulazione hai ricevuto 10$ per i tuoi 10 prelievi precendenti: " + balance);
            }
            Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
            movements.add(move);
            return balance;

        }
}
