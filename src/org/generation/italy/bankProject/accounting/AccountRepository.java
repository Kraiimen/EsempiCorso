package org.generation.italy.bankProject.accounting;

import org.generation.italy.bankProject.accounting.accounts.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface AccountRepository {

     int saveAccount(Account a) throws DataException;
     ArrayList<Account> getAll() throws DataException;//<> Questo ArrayList non lavora più con object, ma con oggetti di classe Account
     void upDateAccount(Account a);
     boolean deleteAccount(int id);
     Set<Account> getAllMoreActiveThan(int numMovements);
     Set<Account> getByClientId(int clientId);
     Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end);
     Account getAccountById(int id);

}
