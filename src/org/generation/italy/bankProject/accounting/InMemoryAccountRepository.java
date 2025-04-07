package org.generation.italy.bankProject.accounting;

import org.generation.italy.bankProject.accounting.accountType.CaymanAccount;
import org.generation.italy.bankProject.accounting.accountType.GoldAccount;
import org.generation.italy.bankProject.accounting.accountType.ItalianAccount;
import org.generation.italy.bankProject.accounting.accountType.Account;

import java.time.LocalDate;
import java.util.*;

public class InMemoryAccountRepository implements AccountRepository {
    private static int idCounter = 1;
    private static Map<Integer, Account> accounts = new HashMap<>();
    static {
        InMemoryClientRepository clientRepository = new InMemoryClientRepository();
        Client c1234 = clientRepository.getByClientCode("1234");
        Client c5678 = clientRepository.getByClientCode("5678");
        accounts.put(idCounter++, new CaymanAccount(1000).withId(idCounter).withOwner(c1234));
        accounts.put(idCounter++, new GoldAccount(2000).withId(idCounter).withOwner(c1234));
        accounts.put(idCounter++, new CaymanAccount(3000, LocalDate.of(2023, 1, 1), "1234").withId(idCounter).withOwner(c5678));
        accounts.put(idCounter++, new GoldAccount(4000).withId(idCounter).withOwner(c5678));
        accounts.put(idCounter++, new ItalianAccount(5000).withId(idCounter).withOwner(c5678));
    }
    @Override
    public int saveAccount(Account a) throws DataException {
        a.setId(idCounter++);
        if (accounts.containsKey(a.getId())) {
            throw new DataException("Account with this ID already exists");
        }
        accounts.put(a.getId(), a);
        return a.getId();
    }

    @Override
    public Iterable<Account> getAll() throws DataException {
        return new HashSet<>(accounts.values());
    }

    @Override
    public void upDateAccount(Account a) throws DataException {
        if (accounts.containsKey(a.getId())) {
            accounts.put(a.getId(), a);
        } else {
            throw new DataException("Account not found");
        }
    }

    @Override
    public boolean deleteAccount(int id) {
        if (accounts.containsKey(id)) {
            accounts.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<Account> getAllMoreActiveThan(int numMovements) {
        Set<Account> result = new HashSet<>();
        for (Account account : accounts.values()) {
            if (account.getNumMovements() > numMovements) {
                result.add(account);
            }
        }
        return result;
    }

    @Override
    public Set<Account> getByClientCode(String code) {
        Set<Account> result = new HashSet<>();
        for (Account account : accounts.values()) {
            if (account.getOwnerClientCode().equals(code)) {
                result.add(account);
            }
        }
        return result;
    }

    @Override
    public Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end) {
        Set<Account> result = new HashSet<>();
        for (Account account : accounts.values()) {
            if (account.getBalance() >= balance && account.getCreationDate().isAfter(start) && account.getCreationDate().isBefore(end)) {
                result.add(account);
            }
        }
        return result;
    }

    @Override
    public Account getAccountById(int id) {
        return accounts.get(id);
    }
}
