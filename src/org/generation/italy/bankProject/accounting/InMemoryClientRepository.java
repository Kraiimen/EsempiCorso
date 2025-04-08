package org.generation.italy.bankProject.accounting;

import java.util.*;

public class InMemoryClientRepository implements ClientRepository {
    private Map<String, Client> clients = new HashMap<>();

    @Override
    public Client getByClientCode(String clientCode) {
        return clients.get(clientCode);
    }

    @Override
    public Set<Client> getByNumAccounts(int numAccounts) {
        Set<Client> sc = new HashSet<>();
        for(Client c : clients.values()){
            if(c.getNumAccounts() >= numAccounts){
                sc.add(c);
            }
        }
        return sc;
    }

    @Override
    public Set<Client> getByTotalBalance(double balance) {
        Set<Client> sc = new HashSet<>();
        for(Client c : clients.values()){
            if(c.getTotal() >= balance){
                sc.add(c);
            }
        }
        return sc;
    }

    @Override
    public Set<Client> getAllTaxEvaders() {
        Set<Client> sc = new HashSet<>();
        for(Client c : clients.values()){
            if(c.isTaxEvader()){
                sc.add(c);
            }
        }
        return sc;
    }
}
