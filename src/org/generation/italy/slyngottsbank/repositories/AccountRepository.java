package org.generation.italy.slyngottsbank.repositories;

import org.generation.italy.slyngottsbank.accounts.Account;
import org.generation.italy.slyngottsbank.exceptions.DataException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public interface AccountRepository {

    int saveAccount(Account a) throws DataException;
    ArrayList<Account> getAll() throws DataException;//<> Questo ArrayList non lavora più con object, ma con oggetti di classe Account
    void updateAccount(Account a);
    boolean deleteAccount(int id);
    Set<Account> getAllMoreActiveThan(int numMovements);
    Set<Account> getByClientCode(String clientCode);
    Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end);
    Account getAccountByClientCode(String clientCode);

}