package org.generation.italy.bankProject.accounting;

import org.generation.italy.bankProject.accounting.accounts.Account;

import java.util.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class InMemoryAccountRepository implements AccountRepository {

    private Set<Account> savedAccounts;

    @Override
    public int saveAccount(Account a) throws DataException {
        savedAccounts.add(a);
        return savedAccounts.size();
    }

    @Override
    public ArrayList<Account> getAll() throws DataException {
        ArrayList<Account> accounts = new ArrayList<Account>();
        for(Account i : savedAccounts){
            accounts.add(i);
        }
        return accounts;
    }

    @Override
    public void upDateAccount(Account a) {
//        savedAccounts.get
    }

    @Override
    public boolean deleteAccount(int id) {
        return false;
    }

    @Override
    public Set<Account> getAllMoreActiveThan(int numMovements) {
        return Set.of();
    }

    @Override
    public Set<Account> getByClientId(int clientId) {
        return Set.of();
    }

    @Override
    public Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end) {
        return Set.of();
    }

    @Override
    public Account getAccountById(int id) {
        return null;
    }
}
