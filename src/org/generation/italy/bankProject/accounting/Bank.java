package org.generation.italy.bankProject.accounting;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    public void manageAccount(Account account){
        if(account.balance < 1000){
            account.deposit(200);
            System.out.println("Your balance was under 1000€. We deposited a small amount of money on your account :)");
            System.out.println("Your new balance is: " + account.balance);
        }else if(account.balance > 2000){
            account.withdraw(500);
            System.out.println("Your balance was over 2000€. We took a small amount of money from your account :)");
            System.out.println("Your new balance is: " + account.balance);
        }else{
            System.out.println("Your balance is: " + account.balance);
        }

    }
    public void loadAccounts(AccountRepository repository){
        accounts = repository.getAll();
    }
}


