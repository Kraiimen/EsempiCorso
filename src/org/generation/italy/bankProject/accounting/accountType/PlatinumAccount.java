package org.generation.italy.bankProject.accounting.accountType;

import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;
import org.generation.italy.bankProject.accounting.exceptions.InvalidAmountException;

import java.time.LocalDateTime;

public class PlatinumAccount extends GoldAccount {

    public PlatinumAccount(double initialBalance){
        super(initialBalance);
    }

    @Override
    public double withdraw(double amount){
        try {
            checkAmountForWithdraw(amount);
            balance -= amount;
            int withdrawalCounter = 1;
            for (Object obj : movements) {
                Movement m1 = (Movement) obj;
                if ((m1.getType() == MovementType.WITHDRAWAL) && (amount >= 100)) {
                    withdrawalCounter++;
                }
            }
            System.out.println(withdrawalCounter);
            if (withdrawalCounter % 10 == 0) {
                balance += 10;
                System.out.println("Bonus");
            }
            Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
            movements.add(move);
        } catch(InvalidAmountException e){
            System.out.println("Error: " + e.getMessage());
        }
        return balance;
    }

}
