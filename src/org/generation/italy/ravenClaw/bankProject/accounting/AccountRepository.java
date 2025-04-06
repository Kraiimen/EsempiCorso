package org.generation.italy.ravenClaw.bankProject.accounting;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public interface AccountRepository {

     int saveAccount(Account a);
     ArrayList<Account> getAll();//<> Questo ArrayList non lavora più con object, ma con oggetti di classe Account
     void upDateAccount(Account a);
     boolean deleteAccount(int id);
     Set<Account> getAllMoreActiveThan(int numMovements);
     Set<Account> getByClientCode(String clientCode);
     Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end);
     Account getAccountById(int id);

}
