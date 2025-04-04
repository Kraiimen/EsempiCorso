package org.generation.italy.slyngottsbank.accounts;

import org.generation.italy.slyngottsbank.exceptions.InvalidAmountException;
import org.generation.italy.slyngottsbank.exceptions.PoliceException;

import java.time.LocalDate;
import java.util.Random;
 @Deprecated
public class AccountCayman extends Account {
    private String secretCode;


    public AccountCayman() {
        this(10_000);
    }

    public AccountCayman(double initialBalance) {
        super(initialBalance);
        secretCode = "xxx";
    }

    public AccountCayman(double initialBalance, LocalDate initialDate, String secretCode) {
        super(initialBalance, initialDate);
        this.secretCode = secretCode;
    }

    private void evadeTax() throws PoliceException {
        taxEvasionFailure();
        System.out.println("evado le tasse con l'aiuto del commercialista Elvis");
    }


//    @Override
//    public double deposit(double amt){
//        evadeTax();
//        balance += amt;
//        return balance;
//    }

    @Override
    public void deposit(double amount) throws PoliceException{
        evadeTax();
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {
        checkWithdrawAmount(amount);
        balance -= amount;
    }

    @Override
    public String getAccountName() {
        return "Cayman";
    }

    private void taxEvasionFailure() throws PoliceException {
        Random random = new Random();
        boolean isCaught = random.nextDouble(1) <= 0.1;

        if (isCaught) {
            throw new PoliceException();
        }
    }
}
