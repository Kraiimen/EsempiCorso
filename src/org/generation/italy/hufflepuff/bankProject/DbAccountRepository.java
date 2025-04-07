package org.generation.italy.hufflepuff.bankProject;


import org.generation.italy.hufflepuff.bankProject.accounting.DataException;
import org.generation.italy.hufflepuff.bankProject.accounting.accountType.Account;
import org.generation.italy.hufflepuff.bankProject.accounting.AccountRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class DbAccountRepository implements AccountRepository {

    @Override
    public int saveAccount(Account a) throws DataException {
        return a.getId();
    }

    @Override
    public ArrayList<Account> getAll() {
        System.out.println("Invocazione di getAll nella classe DbAccountRepository");
        return new ArrayList<>();
    }

    @Override
    public void upDateAccount(Account a) throws DataException {

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
