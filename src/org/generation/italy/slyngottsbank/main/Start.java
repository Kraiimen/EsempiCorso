package org.generation.italy.slyngottsbank.main;

import org.generation.italy.slyngottsbank.accounts.AccountItaly;

import java.time.LocalDate;

public class Start {
    public static void main(String[] args){
        AccountItaly ita1 = new AccountItaly(1000, LocalDate.now());
        ita1.printBalance();
        ita1.deposit(100);
        ita1.printBalance();

        ita1.withdraw(600);
        ita1.printBalance();
        ita1.printMovement();
    }
}
