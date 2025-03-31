package org.generation.italy.bankproject.accounting;

import java.util.ArrayList;

public interface AccountRepository {


    public int saveAccount(Account a);
    public ArrayList<Account> getAll();
    public void updateAccount();
}
