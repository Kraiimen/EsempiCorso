package org.generation.italy.bankProject.accounting;

import java.util.Set;

public interface ClientRepository {
    Client getByClientCode(String clientCode);
    Set<Client> getByNumAccounts(int numAccounts);
    Set<Client> getByTotalBalance(double balance);
    Set<Client> getAllTaxEvaders();
}
