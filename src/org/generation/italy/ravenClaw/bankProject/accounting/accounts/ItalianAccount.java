package org.generation.italy.ravenClaw.bankProject.accounting.accounts;

import org.generation.italy.ravenClaw.bankProject.accounting.Account;
import org.generation.italy.ravenClaw.bankProject.accounting.Movement;
import org.generation.italy.ravenClaw.bankProject.accounting.MovementType;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ItalianAccount extends Account {
    private static final double TAXES = 0.1;
    private ArrayList taxesMovement = new ArrayList();

    public ItalianAccount(double balance){
        super(balance);
    }

    @Override
    public double deposit(double amount){
        double tax = calculateTaxes(amount);
        double amountAfterTax = amount - tax;
        Movement move = new Movement(amountAfterTax, getBalance(), LocalDateTime.now(), MovementType.DEPOSIT);
        getMovements().add(move);
        setBalance(getBalance() + amountAfterTax);
        System.out.println("Grazie per aver pagato il 10% di tasse per il ponte sullo stretto");
        taxesMovement.add(new Movement(tax, getBalance(), LocalDateTime.now(), MovementType.TAX));
        return getBalance();
    }
    private double calculateTaxes(double amount){
        return amount *= TAXES;
    }


}
