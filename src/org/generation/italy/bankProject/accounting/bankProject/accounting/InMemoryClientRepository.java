package org.generation.italy.bankProject.accounting.bankProject.accounting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class InMemoryClientRepository implements ClientRepository {

    private static HashMap<String, Client> clientHashMap = new HashMap<>();


    @Override
    public Client getByClientCode(String clientCode) {
        return clientHashMap.get(clientCode);
    }

    @Override
    public Set<Client> getByNumAccounts(int numAccounts) {
        Set<Client> clientByNumAccounts = new HashSet<>();
        for(Client c: clientHashMap.values()){
            if(c.getNumAccounts() == numAccounts){
                clientByNumAccounts.add(c);
            }
        }
        return clientByNumAccounts;
    }

    @Override
    public Set<Client> getByTotalBalance(double balance) {
        Set<Client> clientByBalance = new HashSet<>();
        for(Client c: clientHashMap.values()){
            if(c.getTotalBalance() >= balance){
                clientByBalance.add(c);
            }
        }
        return clientByBalance;
    }

    @Override
    public Set<Client> getAllTaxEvaders() {
        Set<Client> taxEvaders = new HashSet<>();
        for(Client c: clientHashMap.values()){
            if(c.isTaxEvader()){
                taxEvaders.add(c);
            }
        }
        return taxEvaders;
    }

}
