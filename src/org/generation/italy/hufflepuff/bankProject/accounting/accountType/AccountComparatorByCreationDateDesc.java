package org.generation.italy.hufflepuff.bankProject.accounting.accountType;

import java.util.Comparator;

public class AccountComparatorByCreationDateDesc implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return o2.getCreationDate().compareTo(o1.getCreationDate());
    }
}
