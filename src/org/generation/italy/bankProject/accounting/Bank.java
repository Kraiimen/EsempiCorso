package org.generation.italy.bankProject.accounting;

import org.generation.italy.bankProject.accounting.exceptions.DataException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private ArrayList<Account> accounts;
    public void manageAccoount(Account account){
        if(account.getBalance() < 1000){
            account.deposit(200);
        }
    }
    public void loadAccounts(AccountRepository repository) throws DataException {
        accounts = (ArrayList<Account>) repository.getAll();
    }
}
