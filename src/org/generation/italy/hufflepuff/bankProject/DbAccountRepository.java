package org.generation.italy.hufflepuff.bankProject;


import org.generation.italy.hufflepuff.bankProject.accounting.accountType.Account;
import org.generation.italy.hufflepuff.bankProject.accounting.AccountRepository;

import java.util.ArrayList;

public class DbAccountRepository implements AccountRepository {
    @Override
    public int saveAccount(Account a) {
        System.out.println("Invocazione di saveAccount nella classe DbAccountRepository");
        return a.getId();
    }

    @Override
    public ArrayList<Account> getAll() {
        System.out.println("Invocazione di getAll nella classe DbAccountRepository");
        return new ArrayList<>();
    }

    @Override
    public void upDateAccount(Account a) {
        System.out.println("Invocazione di upDateAccount in DbAccountRepository");

    }
}
