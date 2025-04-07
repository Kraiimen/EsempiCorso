package org.generation.italy.hufflepuff.bankProject.accounting;

import org.generation.italy.hufflepuff.bankProject.accounting.Client;
import org.generation.italy.hufflepuff.bankProject.accounting.accountType.Account;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InMemoryClientRepository implements ClientRepository{
    private static Map<String, Client> clients = new HashMap<>();

    @Override
    public Client getByClientCode(String clientCode) {
        return clients.get(clientCode);
    }

    @Override
    public Set<Client> getByNumAccounts(int numAccounts) {
        Set<Client> clientsByNumAccounts = new HashSet<>();
        for(Client c : clients.values()){
            if(c.getNumAccounts() >= numAccounts){
                clientsByNumAccounts.add(c);
            }
        }
        return clientsByNumAccounts;
    }

    @Override
    public Set<Client> getByTotalBalance(double balance) {
        Set<Client> clientsByBalance = new HashSet<>();
        for(Client c : clients.values()){
            if(c.getTotalBalance() >= balance){
                clientsByBalance.add(c);
            }
        }
        return clientsByBalance;
    }

    @Override
    public Set<Client> getAllTaxEvaders() {
        Set<Client> taxEvaders = new HashSet<>();
        for(Client c : clients.values()){
            if(c.isTaxEvaders()){
                taxEvaders.add(c);
            }
        }
        return taxEvaders;
    }
}
