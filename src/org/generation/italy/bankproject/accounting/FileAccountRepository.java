package org.generation.italy.bankproject.accounting;

import java.util.ArrayList;

public class FileAccountRepository implements AccountRepository{

    @Override
    public int saveAccount(Account a) {
        System.out.println("Esecuzione del metodo saveAccount nel file FileAccountRepository");
        return a.getId();
    }

    @Override
    public ArrayList<Account> getAll() {
        System.out.println("Esecuzione del metodo getAll nel file FileAccountRepository");
        ArrayList<Account> all = new ArrayList<>(); // Non sono obbligato a mettere Account anche a destra
        return all;
    }

    @Override
    public void updateAccount(Account a) {
        System.out.println("Esecuzione del metodo updateAccount nel file FileAccountRepository");
    }

}
