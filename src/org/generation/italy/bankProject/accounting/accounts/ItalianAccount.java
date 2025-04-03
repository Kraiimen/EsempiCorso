package org.generation.italy.bankProject.accounting.accounts;

import org.generation.italy.bankProject.accounting.*;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.ExcessiveDepositException;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.InvalidAmountException;

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
    public double deposit(double amount) throws ExcessiveDepositException {
        if (amount > 100_000) {
            throw new ExcessiveDepositException();
        }
        double tax = amount * TAXES;
        amount -= tax;

        ItalianMovement move = new ItalianMovement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT, tax);
        addMovement(move);
        balance += amount;
        System.out.println("Grazie di aver dato il 10% della spesa per coprire le tasse del movimento");
        return balance;
    }

    @Override
    public double withdraw(double amount) throws InvalidAmountException {
        if(getBalance() < amount) {
            throw new InvalidAmountException();
        }
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

