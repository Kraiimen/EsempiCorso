package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;
import java.util.*;

public class InMemoryAccountRepository implements AccountRepository {

    public Map<Integer,Account> accounts = new HashMap<>(); //Creazione List per tutti i tipi di Account

    @Override
    public int saveAccount(Account a) throws DataException {
        accounts.put(a.getId(), a);
        return a.getId();
    }

    @Override
    public List<Account> getAll() throws DataException {
        return List.of();
    }

    @Override
    public void upDateAccount(Account a) {

    }


    @Override
    public boolean deleteAccount(int id) {
        if(accounts.containsKey(id)){
            accounts.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<Account> getAllMoreActiveThan(int numMovements) {
        return Set.of();
    }

    @Override
    public Set<Account> getByClientCode(String clientCode) {
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
