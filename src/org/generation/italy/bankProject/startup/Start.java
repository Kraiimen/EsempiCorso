package org.generation.italy.bankProject.startup;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;


public class Start {
    public static void main(String[] args) {
        Account x = new Account(28.0, LocalDate.now()); //creiamo l oggetto x tramite  il costruttore che alloca la memoria e tramite i parametri l inizializza
        x.deposit(100);// aggiungiamo tramite il metodo .deposit 110
        x.printBalance();// quando printiamo in questa riga il balance è 100
        x.withdraw(60.0);// usiamo il metodo.withdraw per i prelievi 60
        x.printBalance();// in questo caso tramite printBalance
        x.setBalance(10000);
        x.printBalance();

        Movement m1 = new Movement(100.0,10000.0, LocalDateTime.now(), MovementType.DEPOSIT);
        Movement m2 = new Movement(100.0,10000.0, LocalDateTime.now(), MovementType.WITHDRAWAL);
        m1.getAmount(1000);
        m1.getOperationTime();
        m1.getType();

    }
}
