package org.generation.italy.bankProject.accounting;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AccountRepository {

     int saveAccount(Account a) throws DataException;
     Iterable<Account> getAll() throws DataException;//<> Questo ArrayList non lavora più con object, ma con oggetti di classe Account
     void upDateAccount(Account a);
}
