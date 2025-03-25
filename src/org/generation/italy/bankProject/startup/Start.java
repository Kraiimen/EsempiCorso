package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;

import java.time.LocalDateTime;

public class Start {
    public static void main(String[] args) {
        Account x = new Account(); //creiamo un oggetto di tipo account.
        x.printBalance(); //se printassimo il valore del bilancio, che non è stato inizializzato nella classe uscirebbe 0.00.
        x.deposit(100); //andiamo ad aggiungere 100 al bilancio usando la funzione deposit.
        x.printBalance(); //adesso che il valore è stato modificato se printiamo uscirà 100.
        x.withdraw(60); //adesso invece ritiriamo 60 con la funzione withdraw.
        x.printBalance(); //e printiamo il nuovo bilancio sarà 100-60 = 40.
        x.setBalance(100);
        Account y = new Account(1000);
        Movement m1 = new Movement(10_000.0, LocalDateTime.now(), MovementType.DEPOSIT);
        Movement m2 = new Movement(10_000.0, LocalDateTime.now(), MovementType.WITHDRAWAL);
    }
}