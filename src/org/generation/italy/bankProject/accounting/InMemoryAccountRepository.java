package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;
import java.util.*;

public class InMemoryAccountRepository implements AccountRepository {

    public Map<Integer, Account> accounts = new HashMap<>(); //Creazione List per tutti i tipi di Account

    @Override
    public int saveAccount(Account a) throws DataException {
        if(accounts.containsKey(a.getId())){
            throw new DataException("L'account gia esiste");
        }
        accounts.put(a.getId(), a);
        return a.getId();
    }

    @Override
    public Collection<Account> getAll()  {
        Set<Account> sa = new HashSet<>(accounts.values());
        return sa;
    }

    @Override
    public void upDateAccount(Account a) throws DataException {
        if(accounts.containsKey(a.getId())){
            accounts.put(a.getId(), a);
        } else{
            throw new DataException("Account non trovato per l'update");
        }
    }

    @Override
    public boolean deleteAccount(int id) {
        if(accounts.containsKey(id)){
            accounts.remove(id); // Se elimina la chiave di conseguenza elimina il valore
            return true;
        }
        return false;
    }

    @Override
    public Set<Account> getAllMoreActiveThan(int numMovements) {
        Set<Account> sa = new HashSet<>();
        for(Account a : accounts.values()){
            if(a.getNumMovement() >= numMovements){
                sa.add(a); // ci aggiunge gli account con il numMovement messo nel parametro
            }
        }
        return sa;
    }

    @Override
    public Set<Account> getByClientCode(String clientCode) {
        Set<Account> sa = new HashSet<>();
        for(Account a : accounts.values()){
            if(a.getOwnerClientCode().equals(clientCode)){
                sa.add(a);
            }
        }
        return sa; // Return il nostro Hashset
    }

    @Override
    public Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end) {
        Set<Account> sa = new HashSet<>();
        for(Account a : accounts.values()){
            if(a.getBalance() >= balance && a.getDataIsInTheRange(start, end)){
                sa.add(a);
            }
        }
        return sa;
    }

    @Override
    public Account getAccountById(int id) {
        return accounts.get(id);
    }
}
