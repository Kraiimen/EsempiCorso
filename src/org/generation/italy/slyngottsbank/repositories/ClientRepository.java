package org.generation.italy.slyngottsbank.repositories;

import org.generation.italy.slyngottsbank.accountmanagement.Client;

import java.util.Set;

public interface ClientRepository {
    Client getByClientCode(String clientCode);
    Set<Client> getByNumAccounts(int numAccounts);
    Set<Client> getByTotalBalance(double balance);
    Set<Client> getAllTaxEvaders();
}