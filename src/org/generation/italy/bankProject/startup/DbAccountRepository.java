package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.AccountRepository;

public class DbAccountRepository {
    public class DbAccountRepository implements AccountRepository {
        @Override
        public int saveAccount(Account a) {
            System.out.println("Invocazione di save Account ");
        }
    }
}
