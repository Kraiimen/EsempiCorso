package org.generation.italy.bankProject;


import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.AccountRepository;
import org.generation.italy.bankProject.accounting.DataException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class DbAccountRepository implements AccountRepository {
    @Override
    public int saveAccount(Account a) {
        System.out.println("Invocazione di saveAccount nella classe DbAccountRepository");
        return a.getId();
    }

    @Override
    public ArrayList<Account> getAll() {
        System.out.println("Invocazione di getAll nella classe DbAccountRepository");
        return new ArrayList<>();
    }

    @Override
    public void upDateAccount(Account a) {
        System.out.println("Invocazione di upDateAccount in DbAccountRepository");

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
