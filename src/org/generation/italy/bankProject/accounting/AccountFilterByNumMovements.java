package org.generation.italy.bankProject.accounting;

import java.util.function.Predicate;

public class AccountFilterByNumMovements implements Predicate<Account> {
    private int numMovements;


    public AccountFilterByNumMovements(int numMovements){
        this.numMovements = numMovements;
    }

    @Override
    public boolean test(Account account) {
        return account.getNumMovements() >= numMovements;
    }
}
