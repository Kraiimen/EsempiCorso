package org.generation.italy.ravenClaw.bankProject.accounting.accounts;

import org.generation.italy.ravenClaw.bankProject.accounting.Account;

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

    private void evadeTax(){
        System.out.println("evado le tasse con l'aiuto del commercialista Elvis");
    }
    @Override
    public double deposit(double amt){
        evadeTax();
        setBalance(getBalance() + amt);
        return getBalance();
    }
}