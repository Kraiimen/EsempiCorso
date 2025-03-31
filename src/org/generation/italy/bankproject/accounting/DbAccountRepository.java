package org.generation.italy.bankproject.accounting;

import java.util.ArrayList;

public class DbAccountRepository implements AccountRepository{

    @Override
    public int saveAccount(Account a) {
        System.out.println("Esecuzione del metodo saveAccount nel file DbAccountRepository");
        return a.getId();
    }

    @Override
    public ArrayList<Account> getAll() {
        System.out.println("Esecuzione del metodo getAll nel file DbAccountRepository");
        return new ArrayList<>();
    }

    @Override
    public void updateAccount(Account a) {
        System.out.println("Esecuzione del metodo updateAccount nel file DbAccountRepository");
    }
}
