package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.DbAccountRepository;
import org.generation.italy.bankProject.accounting.*;
import org.generation.italy.bankProject.accounting.accountType.GoldAccount;
import org.generation.italy.bankProject.accounting.accountType.ItalianAccount;
import org.generation.italy.bankProject.accounting.accountType.PlatinumAccount;

import java.time.LocalDate;

//Introdurre una classe cliente, un cliente ha un nome, un cognome, una data di nascita, un codice banca(string)
//un cliente deve avere dei conti
public class Start {

    public static void main(String[] args) {
        AccountRepository accountRepo = new InMemoryAccountRepository();
        ClientRepository clientRepo = new InMemoryClientRepository();
        try {
            for ( var acc : accountRepo.getAll()) {
                System.out.println(acc);
            }

            System.out.println(clientRepo.getByClientCode("1234"));


        } catch (DataException e) {
            throw new RuntimeException(e);
        }

    }

}
