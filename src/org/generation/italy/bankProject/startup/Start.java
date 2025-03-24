package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.accounting.Account;

public class Start {
    public static void main(String[] args) {
        Account x = new Account(); // creiamo un oggetto di tipo Account
        x.printBalance(); // se printassimo il valore di balance, che non è stato inizializzato nella classe uscirebbe 0.00
        x.deposit(100);
        x.printBalance();
        x.withdraw(60);
        x.printBalance();
    }
}
