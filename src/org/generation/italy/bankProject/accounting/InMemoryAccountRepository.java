package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;
import java.util.*;

public class InMemoryAccountRepository implements AccountRepository {


    @Override
    public int saveAccount(Account a) throws DataException {
        return 0;
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
