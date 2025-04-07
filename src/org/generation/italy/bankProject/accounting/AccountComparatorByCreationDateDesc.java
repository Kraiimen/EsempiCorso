package org.generation.italy.bankProject.accounting;

import java.util.Comparator;

public class AccountComparatorByCreationDateDesc implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return o2.getCreationDate().compareTo(o1.getCreationDate());
    }
}
