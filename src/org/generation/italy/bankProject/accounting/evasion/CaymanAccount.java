package org.generation.italy.bankProject.accounting.evasion;

import org.generation.italy.bankProject.accounting.Account;

import java.time.LocalDate;

public class CaymanAccount extends Account {
    private String secretCode;

    public CaymanAccount(){
//        super();  non necessario, viene invocato comunque
//        super(10_000);
//        secretCode = "xxx";
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
    public double deposit(double amt){
        evadeTax();
        balance += amt;
        return balance;
    }
//    public void temp(){                   ESEMPIO DI DIFFERENZA FRA FINAL PRIMITIVA E FINAL PER UN OGGETTO
//        final int[] nums ={1,2,3,4,5};    UN METODO FINAL PUO' ESSERE EREDITATO MA NON OVERRIDATO
//        nums[0] = 25;                     UNA CLASSE FINAL NON PUO' ESSERE EREDITATA
//        nums = new int[4];
//        final int n = 3;
//    }




}
