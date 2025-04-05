package org.generation.italy.bankProject.accounting.fakedb;
import org.generation.italy.bankProject.accounting.Client;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.DataException;

import java.util.ArrayList;
import java.util.Set;

public interface ClientRepository {
    public abstract String saveClient(Client c) throws DataException;
    public abstract void upDateClient(Client c);
    public abstract boolean deleteClient(String clientCode);
    public abstract ArrayList<Client> getAll() throws DataException;
    public abstract Client getByClientCode(String clientCode);
    public abstract Set<Client> getByNumAccounts(int numAccounts);
    public abstract Set<Client> getByTotalBalance(double balance);
    public abstract Set<Client> getAllTaxEvaders();
}
