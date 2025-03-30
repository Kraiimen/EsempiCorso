package org.generation.italy.bankProject.accounting.accounts;

import org.generation.italy.bankProject.accounting.*;
import java.time.*;

public class ItalianAccount extends Account {
    private static final double TAXES = 0.1;

    //  /--CONSTRUCTORS--/

    public ItalianAccount() {
    }

    public ItalianAccount(double initialBalance) {
        super(initialBalance);
    }

    public ItalianAccount(double initialBalance, LocalDate initialDate) {
        super(initialBalance, initialDate);
    }

    // /--METHODS--/

    @Override
    public double deposit(double amount) {
        double tax = amount * TAXES;
        amount -= tax;

        ItalianMovement move = new ItalianMovement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT, tax);
        addMovement(move);
        balance += amount;
        System.out.println("Grazie di aver dato il 10% della spesa per coprire le tasse del movimento");
        return balance;
    }

    @Override
    public double withdraw(double amount) {
        ItalianMovement move = new ItalianMovement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        addMovement(move);
        balance -= amount;
        return balance;
    }

    // /--GETTER--/
    public double getTaxes(){
        return TAXES;
    }
}

