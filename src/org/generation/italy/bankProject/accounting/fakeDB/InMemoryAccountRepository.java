package org.generation.italy.bankProject.accounting.fakeDB;

import org.generation.italy.bankProject.accounting.accounts.Account;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.DataException;

import java.util.*;
import java.time.LocalDate;


public class InMemoryAccountRepository implements AccountRepository {

    private Map<Integer,Account> savedAccounts;


    public InMemoryAccountRepository(){
        savedAccounts = new HashMap<>();
    }
    public InMemoryAccountRepository(HashMap<Integer, Account> savedAccounts){
        this.savedAccounts = savedAccounts;
    }

    @Override
    public int saveAccount(Account a) throws DataException {
        savedAccounts.put(a.getId(),a);
        return savedAccounts.size();
    }

    @Override
    public ArrayList<Account> getAll() throws DataException {
        return new ArrayList<Account>(savedAccounts.values());
    }

    @Override
    public void upDateAccount(Account a) {
        Account temp = savedAccounts.get(a.getId());
        if(temp != null){
            savedAccounts.replace(a.getId(),temp);
        }
    }

    @Override
    public boolean deleteAccount(int id) {
        Account value = savedAccounts.remove(id);
        return value != null;
    }

    @Override
    public Set<Account> getAllMoreActiveThan(int numMovements) {
        Set<Account> accounts = new HashSet<>();
        for(Account a : savedAccounts.values()){
            if(a.getMovements().size() >= numMovements){
                accounts.add(a);
            }
        }
        return accounts;
    }

    @Override
    public Set<Account> getByClientCode(String clientCode) {
        Set<Account> accounts = new HashSet<>();
        for(Account a : savedAccounts.values()){
            if(a.getClient().getClientCode().equals(clientCode)){
                accounts.add(a);
            }
        }
        return accounts;
    }

    @Override
    public Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end) {
        Set<Account> accounts = new HashSet<>();
        for(Account a : savedAccounts.values()){
            if(a.getBalance() >= balance && a.isCreatedInRange(start,end)){
                accounts.add(a);
            }
        }
        return accounts;
    }

    @Override
    public Account getAccountById(int id) {
        return savedAccounts.get(id);
    }
}
