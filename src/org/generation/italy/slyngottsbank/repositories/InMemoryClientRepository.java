package org.generation.italy.slyngottsbank.repositories;

import org.generation.italy.slyngottsbank.accountmanagement.Client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InMemoryClientRepository implements ClientRepository{
    private List<Client> clientList = new ArrayList<>();
    @Override
    public Client getByClientCode(String clientCode) {
        for(Client c : clientList){
            if(c.getClientCode().equals(clientCode)){
                return c;
            }
        }
        return null;
    }

    @Override
    public Set<Client> getByNumAccounts(int numAccounts) {
        Set<Client> temp = new HashSet<>();
        for(Client client : clientList){
            if(client.getNumAccounts() >= numAccounts){
                temp.add(client);
            }
        }
        return temp;
    }

    @Override
    public Set<Client> getByTotalBalance(double balance) {
        Set<Client> temp = new HashSet<>();
        for(Client client : clientList){
            if(client.getTotalBalance() >= balance){
                temp.add(client);
            }
        }

        return temp;
    }

    @Override
    public Set<Client> getAllTaxEvaders() {
        return Set.of();
    }

    public void addClient(Client client){
        clientList.add(client);
    }
}
