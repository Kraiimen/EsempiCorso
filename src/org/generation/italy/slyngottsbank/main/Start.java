package org.generation.italy.slyngottsbank.main;

import org.generation.italy.slyngottsbank.accountmanagement.Bank;
import org.generation.italy.slyngottsbank.accountmanagement.Client;
import org.generation.italy.slyngottsbank.accounts.AccountCayman;
import org.generation.italy.slyngottsbank.accounts.AccountGold;
import org.generation.italy.slyngottsbank.accounts.AccountItaly;
import org.generation.italy.slyngottsbank.exceptions.ExcessiveDepositException;
import org.generation.italy.slyngottsbank.exceptions.InvalidAmountException;
import org.generation.italy.slyngottsbank.exceptions.PoliceException;
import org.generation.italy.slyngottsbank.repositories.InMemoryClientRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Start {
    public static void main(String[] args) {
        InMemoryClientRepository clientRepo = new InMemoryClientRepository();

        Client c1 = new Client("abc123","Mazzitelli", "Vincenzo", LocalDate.of(1987,9,18));
        Client c2 = new Client("abj924","Mazzitelli", "Vincenzo", LocalDate.of(1987,9,18));
        Client c3 = new Client("abe325","Mazzitelli", "Vincenzo", LocalDate.of(1987,9,18));

        clientRepo.addClient(c1);
        clientRepo.addClient(c2);
        clientRepo.addClient(c3);
        Client client = clientRepo.getByClientCode("abc123");
        System.out.println(client);
        c1.addNewAccount(new AccountCayman(1000));
        c1.addNewAccount(new AccountCayman(-1000));
        c1.addNewAccount(new AccountCayman(0));
        c2.addNewAccount(new AccountCayman(500));
        c2.addNewAccount(new AccountCayman(-200));
        c3.addNewAccount(new AccountCayman(1000));
        Set<Client> clientsByAccountNum = clientRepo.getByNumAccounts(2);
        System.out.println(clientsByAccountNum);
        Set<Client> clientsByTotalBalance = clientRepo.getByTotalBalance(1000);
        System.out.println(clientsByTotalBalance);
    }
}
