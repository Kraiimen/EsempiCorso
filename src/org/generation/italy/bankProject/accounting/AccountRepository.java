package org.generation.italy.bankProject.accounting;

import org.generation.italy.bankProject.accounting.exceptions.DataException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AccountRepository {


    int saveAccount(Account a) throws DataException;
    Iterable<Account> getAll() throws DataException;
    void updateAccount();
}
