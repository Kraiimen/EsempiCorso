package org.generation.italy.bankProject.accounting.fakeDB;

import org.generation.italy.bankProject.accounting.accounts.Account;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.DataException;

import java.util.*;
import java.time.LocalDate;


public class InMemoryAccountRepository implements AccountRepository {

    private static Map<Integer,Account> savedAccounts = new HashMap<>();

    //Si potrebbe creare una copia static dei metodi per renderli statici come logicamente dovrebbero essere, però sarebbe una zozzeria
    //perchè avresti dei metodi non statici che richiamano i metodi statici per poter comunque implementare l'interfaccia, ma usarli staticamente come ha senso fare.

    @Override
    public int saveAccount(Account a) throws DataException {
        savedAccounts.put(a.getId(),a);
        return savedAccounts.size();
    }
    public void saveAccounts(List<Account> accounts){
        for(Account a : accounts){
            saveAccount(a);
        }
    }
    @Override
    public  ArrayList<Account> getAll() throws DataException {
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

    public static Map<Integer, Account> getSavedAccounts() {
        return savedAccounts;
    }
}
