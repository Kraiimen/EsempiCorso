package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InMemoryAccountRepository implements AccountRepository {
    private HashSet<Account> accountHashSet = new HashSet<>();

    @Override
    public int saveAccount(Account a) throws DataException {
        accountHashSet.add(a);
        return a.getId();
    }

    @Override
    public HashSet<Account> getAll() throws DataException {
        return accountHashSet;
    }

    @Override
    public void upDateAccount(Account a) {
        System.out.println("non mi va di farlo");
    }

    @Override
    public boolean deleteAccount(int id) {

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
    public Account getAccountById(int id) throws NullPointerException{
            if(accountHashSet.contains(id)){
                for(Account i : accountHashSet){
                    if(i.getId() == id){
                        return i;
                    }
                }
            }
            throw new NullPointerException(); //QUESTA è UN ECCEZIONE GENERICA DA SOSTITUIRE
    }

}
