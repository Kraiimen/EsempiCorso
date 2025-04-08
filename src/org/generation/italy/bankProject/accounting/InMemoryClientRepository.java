package org.generation.italy.bankProject.accounting;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InMemoryClientRepository implements ClientRepository {
    private Map<String, Client> clientMap = new HashMap<>();

    @Override
    public Client getByClientCode(String clientCode) {
        if(clientMap.containsKey(clientCode)) {
            return clientMap.get(clientCode);
        }
        return null;
    }

    @Override
    public Set<Client> getByNumAccounts(int numAccounts) {
        return Set.of();
    }

    @Override
    public Set<Client> getByTotalBalance(double balance) {
        return Set.of();
    }

    @Override
    public Set<Client> getAllTaxEvaders() {
        return Set.of();
    }

    public void addToClientMap(Client client){
        clientMap.put(client.getClientCode(), client);
    }
}
