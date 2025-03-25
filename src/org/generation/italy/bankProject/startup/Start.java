package org.generation.italy.bankProject.startup;

import java.time.LocalDate;
import org.generation.italy.bankProject.accounting.Account;

public class Start {
    public static void main(String[] args) {
        Account x = new Account(2, 1, LocalDate.now()); //creiamo l oggetto x tramite  il costruttore che alloca la memoria e tramite i parametri l inizializza
        x.deposit(100);// aggiungiamo tramite il metodo .deposit 110
        x.printBalance();// quando printiamo in questa riga il balance è 100
        x.withdraw(60.0);// usiamo il metodo.withdraw per i prelievi 60
        x.printBalance();// in questo caso tramite printBalance
        x.setBalance(10000);
        x.printBalance();
    }
}
