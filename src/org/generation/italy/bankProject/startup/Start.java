package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.accounting.Account;
import org.generation.italy.bankProject.accounting.Movement;
import org.generation.italy.bankProject.accounting.MovementType;

import java.time.LocalDateTime;

public class Start {

    public static void main(String[] args) {
        Account x = new Account();//Creo oggetto x di tipo Account, new Account è l' invocazione del costruttore, per avere un oggetto
        //in java bisogna passare per forza dal costruttore.
        x.printBalance();//Il valore di balance non inizializzato stamperà 0 //Chiedo ALL'OGGETTO X di eseguire il METODO printBalance();
        x.deposit(100);//aggiungo 100 al bilancio usando la funzione deposit
        x.printBalance();//adesso stamperà 100
        x.withdraw(60);//adesso ritiro 60 con la funzione withdraw
        x.printBalance();//Se stampo il bilancio sarà 100 - 60
        //System.out.println(x.bal / 100);
        //x.bal = x.bal + 100_00;//100 centesimi = 1eur, per i soldi genericamente si usa il decimale float, bigdecimal,
        //Operazioni possibili solo con classe public. Incapsulare quindi vuol dire che apporto un cambiamento,
        //senza dover andare a modificare tutte le classi
        x.setBalance(100);
        Account y = new Account(1000);
        Movement m1 = new Movement(100.0, 10000.0, LocalDateTime.now(), MovementType.DEPOSIT);
        Movement m2 = new Movement(100.0, 10000.0, LocalDateTime.now(), MovementType.WITHDRAWAL);
        Account z = new Account(100000.0);
        System.out.println("L'indirizzo di z è " + z);
        Account w = new Account(200000.0);
        System.out.println("L'indirizzo di w è " + w);
        System.out.println("Sto per chiamare printBalance su z facendo z.printBalance");
        System.out.println("Sto per chiamare printBalance su w facendo w.printBalance");

        z.printBalance();//Andiamo ad eseguire il metodo printBalance della classe account e lavorerà con gli attributi di Account
        w.printBalance();


    }
}
