package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.accounts.CaymanAccount;
import org.generation.italy.bankProject.accounting.accounts.GoldAccount;
import org.generation.italy.bankProject.accounting.accounts.ItalianAccount;
import org.generation.italy.bankProject.accounting.accounts.PlatinumAccount;
import org.generation.italy.bankProject.accounting.exceptions.CarmineException;
import org.generation.italy.bankProject.accounting.exceptions.ExcessiveDepositException;
import org.generation.italy.bankProject.accounting.exceptions.InvalidAmountException;


public class Start {
//FIXME https://www.youtube.com/watch?v=xvFZjo5PgG0
    public static void main(String[] args) {
//        Account x = new GoldAccount(100);
//        try {
//            x.temp();
//        } catch (ExcessiveDepositException e) {
//            throw new RuntimeException(e);
//        }
        try {
            PlatinumAccount pa = new PlatinumAccount(1000);
            CaymanAccount ca = new CaymanAccount(1000);
            ItalianAccount ia = new ItalianAccount(1000);
            GoldAccount ga = new GoldAccount(1000);
            ia.deposit(200_000);
            ga.withdraw(1200);
            pa.withdraw(1400);
            for (int i = 0; i < 20; i++) {
                ca.deposit(200_000);
            }
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ExcessiveDepositException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CarmineException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void handleAccount(Account x) {
        try {
            x.deposit(100);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
// STEP 1
// Devono esistere 3 tipi di conto: il conto Cayman, il conto Italiano e il conto Gold. Nessuna delle 3 deve essere figlia delle altre due
// Il metodo deposita deve essere diverso per tutte e tre.
// Il conto Cayman evade le tasse e non registra il movimento
// Il conto italiano quando fa un deposito paga il 10% di tasse come spese di registrazione del movimento. Deve printare "Grazie di aver dato il 10% della spesa per coprire le tasse del movimento". Quindi alla fine deposito solo il 90%.
// Il movimento ha una classe base che già esiste. Il conto italiano ha una lista di movimenti italiani che registreranno quanto hai pagato di tasse per un determinato movimento.
// Il conto gold ogni volta che fai un deposito controlla quanti movimenti hai fatto e per ogni 10 depositi fatti ti regala 1€
// Ci sarà un quarto tipo di conto, il conto Platino. Si comporta come il conto gold ma ti regala 10€ ogni 10 movimenti e lo fa sia per quando ritiri che quando depositi.
// Platinum: Ogni 10 depositi ti regala 10€. Ogni 10 withdraw maggiori di 100€ ti regala 10€.
// Creare una classe Bank che ha un metodo che si chiama gestisciConto() che deve poter ricevere in input qualsiasi conto e ne stamperà il saldo. Se il saldo è minore di 1000€ ci deposita sopra 200€ (eseguendo il deposito specifico di quel conto). Se il saldo è maggiore di 2000€ ritira 500€

// STEP 2
// voglio che per quanto riguarda il metodo withdraw, per i tutti i conti tranne gold account, non si possa ritirare piu' del saldo,
// e se si prova a farlo, lanciare un eccezione di tipo InvalidAmountException
// per quanto riguarda i deposit tutti i conti tranne il cayman non possono depositare piu' di 100000 euro, se lo fanno lanciare un eccezione di tipo ExcessiveDepositException
// il famoso metodo evadeTax ha una possibilita' su 10 di fallire con un eccezione di tipo GuardiaDiFinanzaException
