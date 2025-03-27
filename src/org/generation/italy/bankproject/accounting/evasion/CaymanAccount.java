package org.generation.italy.bankproject.accounting.evasion;

import org.generation.italy.bankproject.accounting.Account;

public class CaymanAccount extends Account {     // Avendo utilizzato extends ora la classe ha tutte le funzionalità della classe account, CaymanAccount è un Account

    public void evadeTax () {
        System.out.println(balance);   // Non posso stampare balance perché la classe la eredita ma non è visibile qui in quanto private nella sua classe, diventa visibile se in Account la rendo protected
        System.out.println(getBalance()); //In questo caso posso utilizzare il metodo perché ereditato, dovrò ovviamente utilizzarlo su un oggetto di classe CaymanAccount, che erediterà una balance, privata sì, ma presente
        Account x = new Account(1000);
        CaymanAccount z = new Account(1000);
//      System.out.println(x.balance);  // Non posso farlo perché l'oggetto x protected può vedere la variabile balance che ha ereditato, non quella di Account
        System.out.println(z.balance); // Qui si perché è riferito a un oggetto CaymanAccount
    }
}




