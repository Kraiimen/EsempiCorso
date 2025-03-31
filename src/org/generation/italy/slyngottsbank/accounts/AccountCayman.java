package org.generation.italy.slyngottsbank.accounts;

import java.time.LocalDate;

public class AccountCayman extends Account {
    private String secretCode;


    public AccountCayman(){
        this(10_000);
    }

    public AccountCayman(double initialBalance){
        super(initialBalance);
        secretCode = "xxx";
    }

    public AccountCayman(double initialBalance, LocalDate initialDate, String secretCode){
        super(initialBalance, initialDate);
        this.secretCode = secretCode;
    }

    private void evadeTax(){
        System.out.println("evado le tasse con l'aiuto del commercialista Elvis");
    }

//    @Override
//    public double deposit(double amt){
//        evadeTax();
//        balance += amt;
//        return balance;
//    }

    @Override
    public double deposit(double amount) {
        evadeTax();
        balance += amount;
        return amount;
    }
}
