package org.generation.italy.bankProject.accounting;

import java.util.ArrayList;

public class FileAccountRepository implements AccountRepository{
    @Override
    public int saveAccount(Account a) {
        System.out.println("Esecuzione del metodo SaveAccount nella classe FileAccountRepository");
        return a.getId();
    }

    @Override
    public ArrayList<Account> getAll() {
        System.out.println("Esecuzione del metodo getAll nel FileAccountRepository");
        return new ArrayList<Account>();
    }

    @Override
    public void updateAccount() {
        System.out.println("Esecuzione del metodo updateAccount nel FileAccountRepository");
    }
}
