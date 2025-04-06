package org.generation.italy.bankProject.accounting;

import java.util.HashSet;
import java.util.Set;

public class InMemoryClientRepository implements ClientRepository {

    private HashSet<Client> clientHashSet = new HashSet<>();



//    @Override
//    public Client getByClientCode(String clientCode) {
//        return clientHashSet.contains();
//    }

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
