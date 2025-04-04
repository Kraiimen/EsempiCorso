package org.generation.italy.slyngottsbank.accountmanagement;

import org.generation.italy.slyngottsbank.accounts.Account;

public class Bank  {
    public static void checkAndAdjustBalanceAccount(Account account) {

        if (account.getBalance() <= 1000) {
            account.deposit(200);
        } else if (account.getBalance() >= 2000) {
            account.withdraw(500);
        }
    }


}
