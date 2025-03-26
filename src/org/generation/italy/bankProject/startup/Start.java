package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;

import java.time.LocalDateTime;


public class Start {

    public static void main(String[] args) {
        Account x = new Account(); // creiamo un oggetto di tipo Account , invocando il costruttore di default che e " new account()"
        x.printBalance(); // se printassimo il valore di balance, che non è stato inizializzato nella classe uscirebbe 0.00
        x.deposit(100); // andiamo ad aggiungere 100 al bilancio usando la funzione deposit
        x.printBalance(); // adesso che il valore è stato modificato se printiamo uscirà 100
        x.withdraw(60); // adesso invece ritiriamo 60 con la funzione withdraw 
        x.printBalance(); // e printassimo il nuovo bilandio sarà 100-60
//        System.out.println(x.bal / 100);
//        x.bal = x.bal + 100_00;         }operazioni possibili solo in caso di variabile public, da evitare.
//        x.bal = 100000000;
        x.setBalance(100);
//        Account y = new Account(1000);
        Movement m1 = new Movement(100.0, 10000.0, LocalDateTime.now(), MovementType.DEPOSIT);
        Movement m2 = new Movement(100.0, 10000.0, LocalDateTime.now(), MovementType.WITHDRAWAL);
//        Account z = new Account(10000);
//        System.out.println("l'indirizzo di z è " + z);
//        Account w = new Account (20000);
//        System.out.println("l'indirizzo di w è " + w);
//        System.out.println("sto per chiamare printBalance su z facendo z.printBalance");
//        z.printBalance();
//        System.out.println("sto per chiamare printBalance su w facendo w.printBalance");
//        w.printBalance();
        double depositSum = x.getSumDeposits();
        System.out.println(depositSum);
    }
}