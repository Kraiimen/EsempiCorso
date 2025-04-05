package org.generation.italy.bankProject.accounting.fakedb;

import org.generation.italy.bankProject.accounting.Client;
import org.generation.italy.bankProject.accounting.accounts.Account;
import org.generation.italy.bankProject.accounting.accounts.CaymanAccount;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.DataException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InMemoryClientRepository implements ClientRepository {
    private Map<String, Client> savedClients;

    @Override
    public String saveClient(Client c) throws DataException {
        savedClients.put(c.getClientCode(), c);
        return c.getClientCode();
    }

    @Override
    public void upDateClient(Client c) {
        Client temp = savedClients.get(c.getClientCode());
        if(temp != null){
            savedClients.replace(c.getClientCode(), c);
        }
    }

    @Override
    public boolean deleteClient(String clientCode) {
       return savedClients.remove(clientCode) != null;
    }

    @Override
    public ArrayList<Client> getAll() throws DataException {
        return new ArrayList<Client>(savedClients.values());
    }

    @Override
    public Client getByClientCode(String clientCode) {
       return  savedClients.get(clientCode);
    }

    @Override
    public Set<Client> getByNumAccounts(int numAccounts) {
        Set<Client> clients = new HashSet<>();
        for(Client c : savedClients.values()){
            if(c.getAccounts().size() >= numAccounts){
                clients.add(c);
            }
        }
        return clients;
    }

    @Override
    public Set<Client> getByTotalBalance(double balance) {
        Set<Client> clients = new HashSet<>();
        for (Client c : savedClients.values()) {
            double totalBalance=0;
            for(Account a : c.getAccounts().values()){
                totalBalance += a.getBalance();
            }
            if(totalBalance > balance){
                clients.add(c);
            }
        }
        return clients;
    }

    @Override
    public Set<Client> getAllTaxEvaders() {
        Set<Client> clients = new HashSet<>();
        for(Client c : savedClients.values()){
            for(Account a : c.getAccounts().values()){
                if(a instanceof CaymanAccount){
                    clients.add(c);
                    break;
                }
            }
        }
        return clients;
    }
}
