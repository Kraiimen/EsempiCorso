package org.generation.italy.bankProject.accounting;

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
        try {
            System.out.println("Esecuzione del metodo getAll nel FileAccountRepository");
            ArrayList<Account> all = new ArrayList<>();
            if(Math.random() < 0.5) {
                throw new IOException("In realtà non sto andando su un file");
            }
            return all;
        } catch(IOException e) {
            throw new DataException("Errore nel caricamento degli account da file ", e);
        }

    }

    @Override
    public void upDateAccount(Account a) {
        System.out.println("Esecuzione del metodo upDate nel FileAccountRepository");
    }
}
