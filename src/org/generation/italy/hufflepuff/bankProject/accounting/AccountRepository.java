package org.generation.italy.hufflepuff.bankProject.accounting;

import org.generation.italy.hufflepuff.bankProject.accounting.accountType.Account;

import java.util.ArrayList;

public interface AccountRepository {

     int saveAccount(Account a);
     ArrayList<Account> getAll();//<> Questo ArrayList non lavora più con object, ma con oggetti di classe Account
     void upDateAccount(Account a);
}
