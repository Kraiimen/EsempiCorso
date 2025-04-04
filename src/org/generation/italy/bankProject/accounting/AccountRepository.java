package org.generation.italy.bankProject.accounting;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AccountRepository {

     int saveAccount(Account a) throws DataException;
     ArrayList<Account> getAll() throws DataException;//<> Questo ArrayList non lavora più con object, ma con oggetti di classe Account
     void upDateAccount(Account a);
}
