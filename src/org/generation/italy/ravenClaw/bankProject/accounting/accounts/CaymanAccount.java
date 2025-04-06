package org.generation.italy.ravenClaw.bankProject.accounting.accounts;

import org.generation.italy.ravenClaw.bankProject.accounting.Account;
import org.generation.italy.ravenClaw.bankProject.accounting.exceptions.CarmineException;

import java.time.LocalDate;
import java.util.Random;

public class CaymanAccount extends Account {
    private String secretCode;

    public CaymanAccount(){
        this(10_000);
    }
    public CaymanAccount(double initialBalance){
        super(initialBalance);
        secretCode = "xxx";
    }

    private void evadeTax() throws CarmineException{
        Random dice = new Random();
        if(dice.nextInt(10) == 0){
            throw new CarmineException();
        }
        System.out.println("evado le tasse con l'aiuto del commercialista Elvis");
    }
    @Override
    public double deposit(double amt) throws CarmineException{
        evadeTax();
        setBalance(getBalance() + amt);
        return getBalance();
    }
}