package org.generation.italy.hufflepuff.bankProject.accounting;

import org.generation.italy.hufflepuff.bankProject.accounting.accountType.Account;
import org.generation.italy.hufflepuff.bankProject.accounting.exceptions.NegativeBalanceException;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    public void manageAccount(Account account){
        if(account.getBalance() < 10) {
            System.out.println("Sei un barbone, ma oggi sei fortunato");
            try {
                account.setBalance(100);
            } catch (NegativeBalanceException e) {
                // non verra' mai lanciata perche' l amount e' 100, positivo
            }
            System.out.println("Ti abbiamo regalato 100€");
        }
        if(account.getBalance() < 1000){
            account.deposit(200);
            System.out.println("Your balance was under 1000€. We deposited a small amount of money on your account :)");
            System.out.println("Your new balance is: " + account.getBalance());
        }else if(account.getBalance() > 2000){
            account.withdraw(500);
            System.out.println("Your balance was over 2000€. We took a small amount of money from your account :)");
            System.out.println("Your new balance is: " + account.getBalance());
        }else{
            System.out.println("Your balance is: " + account.getBalance());
        }

    }
    public void manageAccount(Account account, double barbonAmount) throws NegativeBalanceException {
        if(account.getBalance() < 10) {
            System.out.println("Sei un barbone, ma oggi sei fortunato");
            account.setBalance(barbonAmount);
            System.out.println("Ti abbiamo regalato 100€");
        }
        if(account.getBalance() < 1000){
            account.deposit(200);
            System.out.println("Your balance was under 1000€. We deposited a small amount of money on your account :)");
            System.out.println("Your new balance is: " + account.getBalance());
        }else if(account.getBalance() > 2000){
            account.withdraw(500);
            System.out.println("Your balance was over 2000€. We took a small amount of money from your account :)");
            System.out.println("Your new balance is: " + account.getBalance());
        }else{
            System.out.println("Your balance is: " + account.getBalance());
        }

    }
    public void loadAccounts(AccountRepository repository){
        accounts = repository.getAll();
    }
}


