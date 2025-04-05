package org.generation.italy.bankProject.accounting;

import org.generation.italy.bankProject.accounting.exceptions.NegativeBalanceException;

import java.util.ArrayList;


// voglio che per quanto riguarda il metodo withdraw , per i tutti i conti tranne gold account, non si possa ritirare piu' del saldo,
// e se si prova a farlo, lanciare un eccezione di tipo InvalidAmountException
// per quanto riguarda i deposit tutti i conti tranne il cayman non possono depositare piu' di 100000 euro, se lo fanno lanciare un eccezione di tipo ExcessiveDepositException
// il famoso metodo evadeTax ha una possibilita' su 10 di fallire con un eccezione di tipo GuardiaDiFinanzaException
//






public class Bank {
    private ArrayList<Account> accounts;
    public void manageAccount(Account account){
        if(account.getBalance() < 10) {
            System.out.println("Sei un barbone, ma oggi sei fortunato");
            try {
                account.setBalance(100);
            } catch (NegativeBalanceException e) {
                // non verra' mai lanciata perche' l amount e' 100, positivo
            }
            System.out.println("Ti abbiamo regalato 100€");
        }
        if(account.balance < 1000){
            account.deposit(200);
            System.out.println("Your balance was under 1000€. We deposited a small amount of money on your account :)");
            System.out.println("Your new balance is: " + account.balance);
        }else if(account.balance > 2000){
            account.withdraw(500);
            System.out.println("Your balance was over 2000€. We took a small amount of money from your account :)");
            System.out.println("Your new balance is: " + account.balance);
        }else{
            System.out.println("Your balance is: " + account.balance);
        }

    }
    public void manageAccount(Account account, double barbonAmount) throws NegativeBalanceException {
        if(account.getBalance() < 10) {
            System.out.println("Sei un barbone, ma oggi sei fortunato");
            account.setBalance(barbonAmount);
            System.out.println("Ti abbiamo regalato 100€");
        }
        if(account.balance < 1000){
            account.deposit(200);
            System.out.println("Your balance was under 1000€. We deposited a small amount of money on your account :)");
            System.out.println("Your new balance is: " + account.balance);
        }else if(account.balance > 2000){
            account.withdraw(500);
            System.out.println("Your balance was over 2000€. We took a small amount of money from your account :)");
            System.out.println("Your new balance is: " + account.balance);
        }else{
            System.out.println("Your balance is: " + account.balance);
        }

    }
    public void loadAccounts(AccountRepository repository){
//        accounts = repository.getAll();
    }
}


