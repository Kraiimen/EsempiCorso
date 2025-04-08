package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

public interface AccountRepository {

     int saveAccount(Account a) throws DataException;
     Collection<Account> getAll() throws DataException;//<> Questo ArrayList non lavora più con object, ma con oggetti di classe Account
     void upDateAccount(Account a) throws DataException;
     boolean deleteAccount(int id) throws DataException;;
     Set<Account> getAllMoreActiveThan(int numMovements) throws DataException;;
     Set<Account> getByClientCode(String clientCode) throws DataException;;
     Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end) throws DataException;;
     Account getAccountById(int id) throws DataException;;

}
