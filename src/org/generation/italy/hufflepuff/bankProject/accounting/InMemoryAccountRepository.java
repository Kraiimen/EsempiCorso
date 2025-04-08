package org.generation.italy.hufflepuff.bankProject.accounting;

import org.generation.italy.hufflepuff.bankProject.accounting.AccountRepository;
import org.generation.italy.hufflepuff.bankProject.accounting.DataException;
import org.generation.italy.hufflepuff.bankProject.accounting.accountType.Account;

import java.time.LocalDate;
import java.util.*;

public class InMemoryAccountRepository implements AccountRepository {
    private static int idCounter = 1;
    private static Map<Integer, Account> accounts = new HashMap<>();

    @Override
    public int saveAccount(Account a) throws DataException {
        a.setId(idCounter++);
        if (accounts.containsKey(a.getId())) {
            throw new DataException("Account with this ID already exists");
        }
        accounts.put(a.getId(), a);
        return a.getId();
    }

    @Override
    public Collection<Account> getAll() throws DataException {
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
        Set<Account> allMoreActiveThanAccounts = new HashSet<>();
        for(Account a : accounts.values()){
            if(a.getMovements().size() >= numMovements){
                allMoreActiveThanAccounts.add(a);
            }
        }
        return allMoreActiveThanAccounts;
    }

    @Override
    public Set<Account> getByClientCode(String clientCode) throws DataException {
        Set<Account> accountByClientCode = new HashSet<>();
        for(Account a : accounts.values()){
            if(a.getOwnerClientCode().equals(clientCode)){
                accountByClientCode.add(a);
            }
        }
        return accountByClientCode;
    }

    @Override
    public Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end) throws DataException {
        Set<Account> accountByBalanceAndDateRange = new HashSet<>();
        for(Account a : accounts.values()){
            boolean isInRange = a.getCreationDate().isAfter(start) && a.getCreationDate().isBefore(end);
            if(a.getBalance() > balance && isInRange){
                accountByBalanceAndDateRange.add(a);
            }
        }
        return accountByBalanceAndDateRange;
    }

    @Override
    public Account getAccountById(int id) throws DataException {
        return accounts.get(id);
    }
}
