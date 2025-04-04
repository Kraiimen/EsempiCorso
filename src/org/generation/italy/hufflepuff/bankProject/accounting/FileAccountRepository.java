package org.generation.italy.hufflepuff.bankProject.accounting;

import org.generation.italy.hufflepuff.bankProject.accounting.accountType.Account;

import java.util.ArrayList;

public class FileAccountRepository implements AccountRepository {

    @Override
    public int saveAccount(Account a) {
        System.out.println("Esecuzione del metodo SaveAccount nella classe FileAccountRepository");
        return a.getId();

    }

    @Override
    public ArrayList<Account> getAll() {
        System.out.println("Esecuzione del metodo getAll nel FileAccountRepository");
        ArrayList<Account> all = new ArrayList<>();
        return all;
    }

    @Override
    public void upDateAccount(Account a) {
        System.out.println("Esecuzione del metodo upDate nel FileAccountRepository");
    }
}
