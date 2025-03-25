package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.accounting.Account;

public class Start {
    public static void main(String[] args){
        Account a = new Account();
        a.printBalance();
        a.deposit(100);
        a.printBalance();
        a.withdraw(60);
        a.printBalance();
    }
}
