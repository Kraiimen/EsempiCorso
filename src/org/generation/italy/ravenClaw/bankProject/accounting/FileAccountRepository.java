package org.generation.italy.ravenClaw.bankProject.accounting;



import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class FileAccountRepository implements AccountRepository {

    private HashMap<Integer, Account> accountHashMap = new HashMap<>();

    @Override
    public int saveAccount(Account a) {
        accountHashMap.put(a.getId(), a);
        return a.getId();

    }

    @Override
    public ArrayList<Account> getAll() {return (ArrayList<Account>)accountHashMap.values();

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
