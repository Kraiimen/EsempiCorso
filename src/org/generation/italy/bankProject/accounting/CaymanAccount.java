package org.generation.italy.bankProject.accounting;

import org.generation.italy.bankProject.accounting.exceptions.NegativeBalanceException;

import java.time.LocalDate;

public class CaymanAccount extends Account{
    private String secretCode;

    public CaymanAccount(){
//        super(10_000);
//        secretCode = "xxx";
        this(10_000);
    }
    public CaymanAccount(double balance){
        super(balance);
        secretCode = "xxx";
    }
    public CaymanAccount(double balance, LocalDate creationDate,String secretCode){
        super(balance,creationDate);
        this.secretCode = secretCode;
    }




    public void evadeTax(){
        System.out.println("Evado le tasse con l'aiuto del commercialista Elvis");
    }

    @Override
    public double deposit(double amt)  {

            evadeTax();
            setBalance(getBalance() + amt);

        return getBalance();
    }
}
