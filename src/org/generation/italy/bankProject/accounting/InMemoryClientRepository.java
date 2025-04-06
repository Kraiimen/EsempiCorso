package org.generation.italy.bankProject.accounting;

import java.util.Set;

public class InMemoryClientRepository implements ClientRepository {

    @Override
    public Client getByClientCode(String clientCode) {

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
}
