package org.generation.italy.bankProject.accounting;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

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

    @Override
    public boolean deleteAccount(int id) throws DataException {
        return false;
    }

    @Override
    public Set<Account> getAllMoreActiveThan(int numMovements) throws DataException {
        return Set.of();
    }

    @Override
    public Set<Account> getByClientCode(String clientCode) throws DataException {
        return Set.of();
    }

    @Override
    public Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end) throws DataException {
        return Set.of();
    }

    @Override
    public Optional<Account> getAccountById(int id) throws DataException {
        return Optional.empty();
    }

    @Override
    public Iterable<Account> getAllOrderedByBalance() throws DataException {
        return null;
    }

    @Override
    public Iterable<Account> getAllByCreationDateDesc() throws DataException {
        return null;
    }
}
