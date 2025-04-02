package org.generation.italy.bankProject.accounting;

import java.util.ArrayList;

public interface AccountRepository {


    int saveAccount(Account a);
    ArrayList<Account> getAll();
    void updateAccount();
}
