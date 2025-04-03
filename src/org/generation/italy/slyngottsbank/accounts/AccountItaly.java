package org.generation.italy.slyngottsbank.accounts;

import org.generation.italy.slyngottsbank.movements.Movement;
import org.generation.italy.slyngottsbank.movements.MovementType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountItaly extends Account {

    final double TAX_PERCENTAGE = 0.1;


    public AccountItaly(double initialBalance, LocalDate creationDate) {
        super(initialBalance, creationDate);

    }

    @Override
    public void deposit(double amount) {
        balance += amount * (1 - TAX_PERCENTAGE);
        Movement moveIta = new Movement(amount * (1 - TAX_PERCENTAGE), balance, LocalDateTime.now(), MovementType.DEPOSIT);
        movements.add(moveIta);
        System.out.println("Grazie di aver pagato le tasse :)");
    }

    @Override
    public String getAccountName() {
        return "Italy";
    }

}
