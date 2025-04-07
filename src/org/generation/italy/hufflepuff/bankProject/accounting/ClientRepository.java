package org.generation.italy.hufflepuff.bankProject.accounting;

import org.generation.italy.hufflepuff.bankProject.accounting.Client;

import java.util.Set;

public interface ClientRepository {
    org.generation.italy.bankProject.accounting.Client getByClientCode(String clientCode);
    Set<org.generation.italy.bankProject.accounting.Client> getByNumAccounts(int numAccounts);
    Set<org.generation.italy.bankProject.accounting.Client> getByTotalBalance(double balance);
    Set<Client> getAllTaxEvaders();
}
