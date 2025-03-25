package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.accounting.Account;

public class Start {

    public static void main(String[] args) {
        Account x = new Account();//Creo oggetto di tipo Account, NEW è il costruttore, per avere un oggetto
        //in java bisogna passare per forza dal costruttore.
        x.printBalance();//Il valore di balance non inizializzato stamperà 0
        x.deposit(100);//aggiungo 100 al bilancio usando la funzione deposit
        x.printBalance();//adesso stamperà 100
        x.withdraw(60);//adesso ritiro 60 con la funzione withdraw
        x.printBalance();//Se stampo il bilancio sarà 100 - 60
        //System.out.println(x.bal / 100);
        //x.bal = x.bal + 100_00;//100 centesimi = 1eur, per i soldi genericamente si usa il decimale Double
        //Operazioni possibili solo con classe public. Incapsulare quindi vuol dire che apporto un cambiamento,
        //senza dover andare a modificare tutte le classi
        x.setBalance = (100);

    }
}
