package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.accounting.*;

import java.time.LocalDateTime;

public class Start {
    public static void main(String[] args) {
        Account x = new Account(); // creiamo un oggetto di tipo Account
        x.printBalance(); // se printassimo il valore di balance, che non è stato inizializzato nella classe uscirebbe 0.00
        x.deposit(100); // andiamo ad aggiungere 100 al bilancio usando la funzione deposit
        x.printBalance(); // adesso che il valore è stato modificato se printiamo uscirà 100
        x.withdraw(60); // adesso invece ritiriamo 60 con la funzione withdraw
        x.printBalance(); // e printassimo il nuovo bilandio sarà 100-60
//        System.out.println(x.bal/100);
//        x.bal += 10_000;
        x.setBalance(100);
        Account y = new Account();
        Movement m1 = new Movement(100.0, 100000.0, LocalDateTime.now(), MovementType.DEPOSIT);
        Movement m2 = new Movement(100.0, 100000.0, LocalDateTime.now(), MovementType.WITHDRAWAL);
    }
}