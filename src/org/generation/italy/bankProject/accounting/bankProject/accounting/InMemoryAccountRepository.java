package org.generation.italy.bankProject.accounting.bankProject.accounting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class InMemoryAccountRepository implements AccountRepository {
    private static HashMap<Integer, Account> accountHashMap = new HashMap<>();

    @Override
    public int saveAccount(Account a) {
        accountHashMap.put(a.getId(), a);
        return a.getId();

    }

    @Override
    public ArrayList<Account> getAll() {
        return (ArrayList<Account>)accountHashMap.values();

    }

    @Override
    public void upDateAccount(Account a) {
        accountHashMap.put(a.getId(), a);
    }

    @Override
    public boolean deleteAccount(int id) {
        return accountHashMap.remove(id) != null; //se rimuove ritorna true altrimenti false

    }

    @Override
    public Set<Account> getAllMoreActiveThan(int numMovements) {
        HashSet<Account> accountsByActivity = new HashSet<>();
        for(Account a : accountHashMap.values()){
            if(a.getNumberOfMovements() >= numMovements){
                accountsByActivity.add(a);
            }
        }
        return accountsByActivity;
    }

    @Override
    public Set<Account> getByClientCode(String clientCode) {
        Set<Account> accountsByClientCode = new HashSet<>();
        for(Account a: accountHashMap.values()){
            if(a.getOwnerCode().equals(clientCode)){
                accountsByClientCode.add(a);
            }
        }
        return accountsByClientCode;
    }

    @Override
    public Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end) {
        Set<Account> accountsByBalanceAndDateRange = new HashSet<>();
        for(Account a: accountHashMap.values()){
            if(a.getBalance() >= balance && (a.getCreationDate().isAfter(start) && a.getCreationDate().isBefore(end))){
                accountsByBalanceAndDateRange.add(a);
            }
        }
        return accountsByBalanceAndDateRange;
    }

    @Override
    public Account getAccountById(int id) {
        return accountHashMap.get(id);
    }
}
