package org.generation.italy.bankProject.accounting.accountType;

import org.generation.italy.bankProject.accounting.Account;

public class Bank {
    public void gestisciConto(Account conto) {
        if (conto.getBalance() < 1000){
            conto.deposit(200);
            System.out.println("Il tuo conto è minore di 1000 la banca ti regala 200: " + conto.getBalance());
        } else if (conto.getBalance() > 2000) {
            conto.withdraw(500);
            System.out.println("Il tuo conte è supera  2000 la banca ti prelieva 500: " + conto.getBalance());
        }
    }

    public Account creatAccount(boolean isGold){
        if(isGold){
           return  new GoldAccount(1000);
        } else {
            return new ItalianAccount(1000);
        }
    }
}