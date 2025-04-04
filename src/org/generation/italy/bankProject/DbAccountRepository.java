package org.generation.italy.bankProject;


import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.AccountRepository;
import org.generation.italy.bankProject.accounting.DataException;

import java.sql.SQLException;
import java.util.ArrayList;

public class DbAccountRepository implements AccountRepository {
    @Override
    public int saveAccount(Account a) throws DataException {
        try {
            System.out.println("Invocazione di saveAccount nella classe DbAccountRepository");
            if(Math.random() < 0.5) {
                throw new SQLException("In realtà non sto andando sul database");
            }
            return a.getId();
        } catch (SQLException e) {
            throw new DataException("Errore nel salvataggio dell'account su database ", e);
        }

    }

    @Override
    public ArrayList<Account> getAll() throws DataException {
        System.out.println("Invocazione di getAll nella classe DbAccountRepository");
        if(Math.random() < 0.5) {
            try {
                throw new SQLException("In realtà non sto andando sul database");
            } catch (SQLException e) {
                throw new DataException("Errore nel report degli account", e);
            }
        }
        return new ArrayList<>();
    }

    @Override
    public void upDateAccount(Account a) {
        System.out.println("Invocazione di upDateAccount in DbAccountRepository");

    }
}
