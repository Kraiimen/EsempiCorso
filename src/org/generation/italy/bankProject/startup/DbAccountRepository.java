package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.AccountRepository;

import java.util.ArrayList;

public class DbAccountRepository implements AccountRepository {

    @Override
    public int saveAccount(Account a) {
        System.out.println("Invocazione di saveaAccount nella classe DbAccountRepository");
        return a.getId();
    }

    @Override
    public ArrayList<Account> getAll() {
        System.out.println("Invocazione di getAll nella classe DbAccountRepository");
        return new ArrayList<>();
    }

    @Override
    public void updateAccount() {
        System.out.println("Invocazione di updateAccount nella classe DbAccountRepository");
    }
}
