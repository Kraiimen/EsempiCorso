package org.generation.italy.bankProject.accounting;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

public class DbAccountRepository implements AccountRepository {
    @Override
    public int saveAccount(Account a) throws DataException {
        try {
            System.out.println("Invocazione di saveAccount nella classe DbAccountRepository");
            if(Math.random() < 0.5) {
                throw new SQLException("In realtà non sto andando sul database");
            }
            return a.getId();
        } catch (SQLException e) {
            throw new DataException("Errore nel salvataggio dell'account su database ", e);
        }

    }

    @Override
    public ArrayList<Account> getAll() throws DataException {
        System.out.println("Invocazione di getAll nella classe DbAccountRepository");
        if(Math.random() < 0.5) {
            try {
                throw new SQLException("In realtà non sto andando sul database");
            } catch (SQLException e) {
                throw new DataException("Errore nel report degli account", e);
            }
        }
        return new ArrayList<>();
    }

    @Override
    public void upDateAccount(Account a) {
        System.out.println("Invocazione di upDateAccount in DbAccountRepository");

    }

    @Override
    public boolean deleteAccount(int id) throws DataException {
        return false;
    }

    @Override
    public Set<Account> getAllMoreActiveThan(int numMovements) throws DataException {
        return Set.of();
    }

    @Override
    public Set<Account> getByClientCode(String clientCode) throws DataException {
        return Set.of();
    }

    @Override
    public Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end) throws DataException {
        return Set.of();
    }

    @Override
    public Optional<Account> getAccountById(int id) throws DataException {
        return Optional.empty();
    }

    @Override
    public Iterable<Account> getAllOrderedByBalance() throws DataException {
        return null;
    }

    @Override
    public Iterable<Account> getAllByCreationDateDesc() throws DataException {
        return null;
    }
}
