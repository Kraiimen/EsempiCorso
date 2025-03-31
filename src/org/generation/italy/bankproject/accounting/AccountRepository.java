package org.generation.italy.bankproject.accounting;

import java.util.ArrayList;

public interface AccountRepository {

    // I metodi delle interfacce hanno le keyword abstract e public di default, per cui non le metteremo
    int saveAccount(Account a);
    ArrayList<Account> getAll(); // Con il diamantino <> l'ArrayList non lavora più con Object, ma tipo in questo caso si specializzato in oggetti di tipo Account
    void updateAccount(Account a);

}
