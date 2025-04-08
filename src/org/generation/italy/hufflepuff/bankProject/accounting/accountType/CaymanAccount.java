package org.generation.italy.hufflepuff.bankProject.accounting.accountType;

import org.generation.italy.hufflepuff.bankProject.accounting.exceptions.GuardiaDiFinanzaException;
import org.generation.italy.hufflepuff.bankProject.accounting.exceptions.InvalidAmountException;

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
    public CaymanAccount(double initialBalance, LocalDate initialDate, String secretCode){
        super(initialBalance, initialDate);
        this.secretCode = secretCode;
    }

    private void evadeTax()throws GuardiaDiFinanzaException {
        Random random = new Random();
        int j = random.nextInt(10);
        if(j == 9){
            throw new GuardiaDiFinanzaException();
        }
        System.out.println("evado le tasse con l'aiuto del commercialista Elvis");
    }

    @Override
    public double deposit(double amt)throws GuardiaDiFinanzaException {
        evadeTax();
        balance += amt;
        return balance;
    }


    @Override
    public double withdraw(double amount) throws InvalidAmountException, GuardiaDiFinanzaException {
        checkAmountForWithdraw(amount);
        evadeTax();
        balance -= amount;
        return balance;
    }

//    public void temp(){                   ESEMPIO DI DIFFERENZA FRA FINAL PRIMITIVA E FINAL PER UN OGGETTO
//        final int[] nums ={1,2,3,4,5};    UN METODO FINAL PUO' ESSERE EREDITATO MA NON OVERRIDATO
//        nums[0] = 25;                     UNA CLASSE FINAL NON PUO' ESSERE EREDITATA
//        nums = new int[4];
//        final int n = 3;
//    }
}
