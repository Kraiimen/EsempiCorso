package org.generation.italy.bankProject.accounting.accounts;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.MovementType;
import org.generation.italy.bankProject.accounting.accounts.ItalianMovement.ItalianMovement;
import org.generation.italy.bankProject.accounting.exceptions.ExcessiveDepositException;
import org.generation.italy.bankProject.accounting.exceptions.InvalidAmountException;


import java.time.LocalDateTime;

public class ItalianAccount extends Account {
    private static final double TAXES = 0.1;

    public ItalianAccount(double balance, String ownerCode) {
        super(balance, ownerCode);
    }

    @Override
    public double deposit(double amount) throws InvalidAmountException, ExcessiveDepositException {
        isAmountValid(amount);
        isDepositTooBig(amount);

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

