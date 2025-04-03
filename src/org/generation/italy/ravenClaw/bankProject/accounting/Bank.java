package org.generation.italy.ravenClaw.bankProject.accounting;

import org.generation.italy.ravenClaw.bankProject.accounting.accounts.*;

// voglio che per quanto riguarda il metodo withdraw , per i tutti i conti tranne gold account, non si possa ritirare piu' del saldo,
// e se si prova a farlo, lanciare un eccezione di tipo InvalidAmountException
// per quanto riguarda i deposit tutti i conti tranne il cayman non possono depositare piu' di 100000 euro, se lo fanno lanciare un eccezione di tipo ExcessiveDepositException
// il famoso metodo evadeTax ha una possibilita' su 10 di fallire con un eccezione di tipo GuardiaDiFinanzaException

public class Bank {
    private static final int MINIMUM_FOR_DEPOSIT =1000;
    private static final int MAX_BEFORE_WITHDRAW =2000;
    private static final int ACCOUNT_DEPOSIT_BONUS =200;
    private static final int ACCOUNT_DEPOSIT_MALUS =500;

    public void gestisciConto(Account account){
        if(account.getBalance() < MINIMUM_FOR_DEPOSIT){
            account.deposit(ACCOUNT_DEPOSIT_BONUS);
        }else if(account.getBalance()> MAX_BEFORE_WITHDRAW){
            account.withdraw(ACCOUNT_DEPOSIT_MALUS);
        }
        System.out.println("Il tuo saldo attuale è: " +  account.getBalance());
    }
    
}
