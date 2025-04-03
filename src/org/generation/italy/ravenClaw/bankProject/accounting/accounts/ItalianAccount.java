package org.generation.italy.ravenClaw.bankProject.accounting.accounts;

import org.generation.italy.ravenClaw.bankProject.accounting.Account;
import org.generation.italy.ravenClaw.bankProject.accounting.Movement;
import org.generation.italy.ravenClaw.bankProject.accounting.MovementType;
import org.generation.italy.ravenClaw.bankProject.accounting.exceptions.ExcessiveDepositException;
import org.generation.italy.ravenClaw.bankProject.accounting.movements.ItalianMovement;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ItalianAccount extends Account {
    private static final double TAXES = 0.1;

    public ItalianAccount(double balance){
        super(balance);
    }

    @Override
    public double deposit(double amount) throws ExcessiveDepositException {

        if (amount > 100_000) {
            throw new ExcessiveDepositException();
        }
        double tax = calculateTaxes(amount);
        double amountAfterTax = amount - tax;
        setBalance(getBalance() + amountAfterTax);
        System.out.println("Grazie per aver pagato il 10% di tasse per il ponte sullo stretto");
        getMovements().add(new ItalianMovement(amountAfterTax, getBalance(), LocalDateTime.now(), MovementType.DEPOSIT, tax));

        return getBalance();
    }

    private double calculateTaxes(double amount){
        return amount *= TAXES;
    }


}
