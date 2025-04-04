package org.generation.italy.bankProject.accounting.startup;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.AccountRepository;
import org.generation.italy.bankProject.accounting.exceptions.DataException;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbAccountRepository implements AccountRepository {

    @Override
    public int saveAccount(Account a) throws DataException {
        try {
            System.out.println("Invocazione di saveaAccount nella classe DbAccountRepository");
            if((Math.random() < 0.5)){
                throw new SQLException("In realtà non sto andando sul database");
            }
            return a.getId();
        } catch (SQLException e) {
            throw new DataException("Errore nel salvataggio dell'account su database", e);
        }

    }

    @Override
    public ArrayList<Account> getAll() throws DataException {
        System.out.println("Invocazione di getAll nella classe DbAccountRepository");
        if(Math.random() < 0.5) {
            throw new DataException("In realtà non sto andando su un database");
        }
        return new ArrayList<>();
    }

    @Override
    public void updateAccount() {
        System.out.println("Invocazione di updateAccount nella classe DbAccountRepository");
    }
}
