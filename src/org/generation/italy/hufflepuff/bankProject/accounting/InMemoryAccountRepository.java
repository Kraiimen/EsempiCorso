package org.generation.italy.hufflepuff.bankProject.accounting;

import org.generation.italy.hufflepuff.bankProject.accounting.AccountRepository;
import org.generation.italy.hufflepuff.bankProject.accounting.DataException;
import org.generation.italy.hufflepuff.bankProject.accounting.accountType.Account;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InMemoryAccountRepository implements AccountRepository {
    private static Map<Integer, Account> accounts = new HashMap<>();

    @Override
    public int saveAccount(Account a) throws DataException {
        if (accounts.containsKey(a.getId())) {
            throw new DataException("Account with this ID already exists");
        }
        accounts.put(a.getId(), a);
        return a.getId();
    }

    @Override
    public Iterable<Account> getAll() throws DataException {
        return new HashSet<>(accounts.values());
    }

    @Override
    public void upDateAccount(Account a) throws DataException {
        if (accounts.containsKey(a.getId())) {
            accounts.put(a.getId(), a);
        } else {
            throw new DataException("Account not found");
        }
    }

    @Override
    public boolean deleteAccount(int id) throws DataException {
        if(accounts.containsKey(id)){
            accounts.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<Account> getAllMoreActiveThan(int numMovements) throws DataException {
        Set<Account> allMoreActiveThanAccounts = new HashSet<Account>();
        for(Account a : accounts.values()){
            if(a.getMovements().size() >= numMovements){
                allMoreActiveThanAccounts.add(a);
            }
        }
        return allMoreActiveThanAccounts;
    }

    @Override
    public Set<Account> getByClientCode(String clientCode) throws DataException {
        Set<Account> accByClientCode = new HashSet<>();
        
        return accByClientCode;
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
