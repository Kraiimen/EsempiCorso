package org.generation.italy.slyngottsbank.main;

import org.generation.italy.slyngottsbank.accountmanagement.Bank;
import org.generation.italy.slyngottsbank.accounts.AccountCayman;
import org.generation.italy.slyngottsbank.accounts.AccountItaly;
import org.generation.italy.slyngottsbank.exceptions.InvalidAmountException;

import java.time.LocalDate;

public class Start {
    public static void main(String[] args) {
        AccountItaly ita1 = new AccountItaly(1000, LocalDate.now());
        ita1.printBalance();
        ita1.deposit(100);
        ita1.printBalance();

        try {
            ita1.withdraw(6000);
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

//        ita1.printBalance();
//        ita1.printMovement();
//
//        AccountCayman cay1 = new AccountCayman(1000);
//        cay1.deposit(100);
//        cay1.printBalance();
//        cay1.printMovement();
//
//        Bank.checkAndAdjustBalanceAccount(ita1);
//        ita1.printBalance();
//
//        Bank.checkAndAdjustBalanceAccount(cay1);
//        cay1.printBalance();
//        cay1.deposit(2000);
//        Bank.checkAndAdjustBalanceAccount(cay1);
//        cay1.printBalance();


    }
}
