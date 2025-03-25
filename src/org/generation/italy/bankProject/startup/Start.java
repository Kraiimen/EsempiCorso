package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.accounting.Account;

public class Start {

    public static void main(String[] args) {
        Account x = new Account();//Creo oggetto di tipo Account
        x.printBalance();//Il valore di balance non inizializzato stamperà 0
        x.deposit(100);//aggiungo 100 al bilancio usando la funzione deposit
        x.printBalance();//adesso stamperà 100
        x.withdraw(60);//adesso ritiro 60 con la funzione whithdraw
        x.printBalance();//Se stampo il bilancio sarà 100 - 60


    }
}
