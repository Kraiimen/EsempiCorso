package org.generation.italy.hufflepuff.bankProject.accounting;

import org.generation.italy.hufflepuff.bankProject.accounting.accountType.Account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

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
    public Account getAccountById(int id) throws DataException {
        return null;
    }
}
