package org.generation.italy.bankproject.accounting;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    public void manageAccoount(Account account){
        if(account.getBalance() < 1000){
            account.deposit(200);
        }
    }
    public void loadAccounts(AccountRepository repository){
        accounts = repository.getAll();
    }
}
