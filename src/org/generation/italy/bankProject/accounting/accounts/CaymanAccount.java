package org.generation.italy.bankProject.accounting.accounts;

import java.time.LocalDate;

public class CaymanAccount extends Account {
    private String secretCode;

    public CaymanAccount(){
        this(10_000);
    }
    public CaymanAccount(double initialBalance){
        super(initialBalance);
        secretCode = "xxx";
    }
    public CaymanAccount(double initialBalance, LocalDate initialDate, String secretCode){
        super(initialBalance, initialDate);
        this.secretCode = secretCode;
    }

    private void evadeTax(){
       System.out.println("evado le tasse con l'aiuto del commercialista Elvis");
    }

    @Override
    public double withdraw(double amount) {
        balance -= amount;
        return balance;
    }

    @Override
    public double deposit(double amt){
        evadeTax();
        setBalance(getBalance() + amt);
        return getBalance();
    }
}
