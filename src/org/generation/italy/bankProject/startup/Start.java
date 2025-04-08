package org.generation.italy.bankProject.startup;


import org.generation.italy.bankProject.accounting.Client;
import org.generation.italy.bankProject.accounting.accounts.*;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.ExcessiveDepositException;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.GuardiaDiFinanzaException;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.InvalidAmountException;
import org.generation.italy.bankProject.accounting.fakeDB.InMemoryAccountRepository;
import org.generation.italy.bankProject.accounting.fakeDB.InMemoryClientRepository;
import org.generation.italy.bankProject.accounting.movements.Movement;
import org.generation.italy.bankProject.accounting.movements.MovementType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Start {

    public static void main(String[] args) {
        //*
        Random r = new Random();

        Client client1 = new Client("Emanuele","Giustiniani", LocalDate.of(2001,2,24));
        Client client2 = new Client("Francesco","Totti", LocalDate.of(1976,9,27));
        Client client3 = new Client("George","Foreman", LocalDate.of(1949,1,10));
        //cayman accounts
        Account cay1 = new CaymanAccount(client1);
        Account cay2 = new CaymanAccount(1000,client1);
        Account cay3 = new CaymanAccount(1000,LocalDate.now(),"1234",client1);
        //ita accounts
        Account ita1 = new ItalianAccount(client2);
        Account ita2 = new ItalianAccount(100_000,client2);
        Account ita3 = new ItalianAccount(100_000,LocalDate.now(),client2);
        //gold accounts
        Account gold1 = new GoldAccount(client2);
        Account gold2 = new GoldAccount(100_000,client2);
        Account gold3 = new GoldAccount(100_00,LocalDate.now(),client2);
        Account gold4 = new GoldAccount(50_000,LocalDate.now(),client3);
        //plat accounts
        Account plat1 = new PlatinumAccount(100_000_000,LocalDate.now(),client1);
        Account plat2 = new PlatinumAccount(1_000_000, LocalDate.now(),client2);
        Account plat3 = new PlatinumAccount(client2);
        Account plat4 = new PlatinumAccount(250_000, LocalDate.now(), client3);
        //associa gli account ai clienti
        client1.addAccounts(List.of(cay1, cay2, cay3, plat1));
        client2.addAccounts(List.of(ita1, ita2, ita3, gold1, gold2, gold3, plat2, plat3));
        client3.addAccounts(List.of(gold4, plat4));
        //creazione istanze inmemoryaccount/inmemoryclient repository
        InMemoryClientRepository clientRepository = new InMemoryClientRepository();
        InMemoryAccountRepository accountRepository = new InMemoryAccountRepository();
        //aggiunta al fakedb di accounts e clients
        clientRepository.saveClients(List.of(client1, client2, client3));
        accountRepository.saveAccounts(List.of(cay1, cay2, cay3, ita1, ita2, ita3, gold1, gold2, gold3, gold4, plat1, plat2, plat3, plat4));

        try{
            for(Account a : InMemoryAccountRepository.getSavedAccounts().values()){
                a.deposit(r.nextInt(10_000));
            }
        } catch (ExcessiveDepositException e) {
            System.out.println(e.getMessage());
        } catch (GuardiaDiFinanzaException e){
            System.out.println(e.getMessage());
        }
        try {
            for(Account a : InMemoryAccountRepository.getSavedAccounts().values()){
                a.withdraw(r.nextInt(10_000));
            }
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
        //*/
    }
}

// Devono esistere 3 tipi di conto: il conto Cayman, il conto Italiano e il conto Gold. Nessuna delle 3 deve essere figlia delle altre due
// Il metodo deposita deve essere diverso per tutte e tre.
// Il conto Cayman evade le tasse e non registra il movimento
// Il conto italiano quando fa un deposito paga il 10% di tasse come spese di registrazione del movimento. Deve printare "Grazie di aver dato il 10% della spesa per coprire le tasse del movimento". Quindi alla fine deposito solo il 90%.
// Il movimento ha una classe base che già esiste. Il conto italiano ha una lista di movimenti italiani che registreranno quanto hai pagato di tasse per un determinato movimento.
// Il conto gold ogni volta che fai un deposito controlla quanti movimenti hai fatto e per ogni 10 depositi fatti ti regala 1€
// Ci sarà un quarto tipo di conto, il conto Platino. Si comporta come il conto gold ma ti regala 10€ ogni 10 movimenti e lo fa sia per quando ritiri che quando depositi.
// Platinum: Ogni 10 depositi ti regala 10€. Ogni 10 withdraw maggiori di 100€ ti regala 10€.
// Creare una classe Bank che ha un metodo che si chiama gestisciConto() che deve poter ricevere in input qualsiasi conto e ne stamperà il saldo. Se il saldo è minore di 1000€ ci deposita sopra 200€ (eseguendo il deposito specifico di quel conto). Se il saldo è maggiore di 2000€ ritira 500€
