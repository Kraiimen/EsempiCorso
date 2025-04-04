package org.generation.italy.bankProject.accounting.startup;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.AccountRepository;
import org.generation.italy.bankProject.accounting.exceptions.DataException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class FileAccountRepository implements AccountRepository {
    @Override
    public int saveAccount(Account a) {
        System.out.println("Esecuzione del metodo SaveAccount nella classe FileAccountRepository");
        return a.getId();
    }

    @Override
    public ArrayList<Account> getAll() throws DataException {
        System.out.println("Esecuzione del metodo getAll nel FileAccountRepository");
        if((Math.random() < 0.5)){
            throw new DataException("In realtà non sto andando sul database");
        }
        return new ArrayList<Account>();
    }

    @Override
    public void updateAccount() {
        System.out.println("Esecuzione del metodo updateAccount nel FileAccountRepository");
    }
}
