package org.generation.italy.bankProject.accounting.fakedb;

import org.generation.italy.bankProject.accounting.accounts.Account;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.DataException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public interface AccountRepository {

     public abstract int saveAccount(Account a) throws DataException;
     public abstract ArrayList<Account> getAll() throws DataException;//<> Questo ArrayList non lavora più con object, ma con oggetti di classe Account
     public abstract void upDateAccount(Account a);
     public abstract boolean deleteAccount(int id);
     public abstract Set<Account> getAllMoreActiveThan(int numMovements);
     public abstract Set<Account> getByClientCode(String clientCode);
     public abstract Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end);
     public abstract Account getAccountById(int id);

}
