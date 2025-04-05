package org.generation.italy.bankProject.accounting;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class InMemoryElvisClientRepository implements ClientRepository {

    private static final Map<String, Client> clients = new HashMap<>();
    static {
        clients.put("1234", new Client("1234", "Rossi", "Mario", "01/01/1980"));
        clients.put("5678", new Client("5678", "Verdi", "Luigi", "02/02/1990"));
        clients.put("9101", new Client("9101", "Bianchi", "Anna", "03/03/1985"));
    }

    @Override
    public Optional<Client> getByClientCode(String clientCode) {
        return Optional.ofNullable(clients.get(clientCode));
    }

    @Override
    public Set<Client> getByNumAccounts(int numAccounts) {
        return clients.values().stream()
                .filter(client -> client.getNumAccounts() >= numAccounts)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Client> getByTotalBalance(double balance) {
        return clients.values().stream()
                .filter(client -> client.getTotalBalance() >= balance)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Client> getAllTaxEvaders() {
        return clients.values().stream()
                .filter(Client::isTaxEvader)
                .collect(Collectors.toSet());
    }
}
