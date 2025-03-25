package org.generation.italy.bankProject.startup;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;

public class Start {
    public static void main(String[] args) {
        Account x = new Account(2); // creiamo un oggetto di tipo Account
        x.printBalance(); // se printassimo il valore di balance, che non è stato inizializzato nella classe uscirebbe 0.00
        x.deposit(100);
        x.printBalance();
        x.withdraw(60);
        x.printBalance();
        Movement m1 = new Movement(100.0, x.getBalance(), LocalDateTime.now(), MovementType.DEPOSIT);
        x.printBalance();

    }
}