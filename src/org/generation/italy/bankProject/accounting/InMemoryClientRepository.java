package org.generation.italy.bankProject.accounting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InMemoryClientRepository implements ClientRepository {
    private static final Map<String, Client> clients = new HashMap<>();
    static {
        clients.put("1234", new Client("1234", "Rossi", "Mario", "01/01/1980"));
        clients.put("5678", new Client("5678", "Verdi", "Luigi", "02/02/1990"));
        clients.put("9101", new Client("9101", "Bianchi", "Anna", "03/03/1985"));
    }
    @Override
    public Client getByClientCode(String clientCode) {
        return clients.get(clientCode);
    }

    @Override
    public Set<Client> getByNumAccounts(int numAccounts) {
         Set<Client> result = new HashSet<>();
         for (Client client : clients.values()) {
             if (client.getNumAccounts() >= numAccounts) {
                 result.add(client);
             }
         }
         return result;
    }

    @Override
    public Set<Client> getByTotalBalance(double balance) {
        Set<Client> result = new HashSet<>();
        for (Client client : clients.values()) {
            if (client.getTotalBalance() >= balance) {
                result.add(client);
            }
        }
        return result;
    }

    @Override
    public Set<Client> getAllTaxEvaders() {
        Set<Client> result = new HashSet<>();
        for (Client client : clients.values()) {
            if (client.isTaxEvader()) { // Assuming tax evasion threshold
                result.add(client);
            }
        }
        return result;
    }
}
