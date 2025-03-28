package org.generation.italy.ravenClaw.bankProject.startup;

import org.generation.italy.ravenClaw.bankProject.accounting.*;

import java.time.LocalDateTime;


public class Start {

    public static void main(String[] args) {
        Account x = new Account(); // creiamo un oggetto di tipo Account
        x.printBalance(); // se printassimo il valore di balance, che non è stato inizializzato nella classe uscirebbe 0.00
        x.deposit(100); // andiamo ad aggiungere 100 al bilancio usando la funzione deposit
        x.printBalance(); // adesso che il valore è stato modificato se printiamo uscirà 100
        x.withdraw(60); // adesso invece ritiriamo 60 con la funzione withdraw 
        x.printBalance(); // e printassimo il nuovo bilandio sarà 100-60
//        System.out.println(x.bal / 100);
//        x.bal = x.bal + 100_00;         }operazioni possibili solo in caso di variabile public, da evitare.
//        x.bal = 100000000;
        x.setBalance(100);
//        Account y = new Account(1000);
        Movement m1 = new Movement(100.0, 10000.0, LocalDateTime.now(), MovementType.DEPOSIT);
        Movement m2 = new Movement(100.0, 10000.0, LocalDateTime.now(), MovementType.WITHDRAWAL);
//        Account z = new Account(10000);
//        System.out.println("l'indirizzo di z è " + z);
//        Account w = new Account (20000);
//        System.out.println("l'indirizzo di w è " + w);
//        System.out.println("sto per chiamare printBalance su z facendo z.printBalance");
//        z.printBalance();
//        System.out.println("sto per chiamare printBalance su w facendo w.printBalance");
//        w.printBalance();
        double depositSum = x.getSumDeposits();
        System.out.println(depositSum);
        CaymanAccount ca = new CaymanAccount();
        double newBalance = ca.deposit(3000);
        ca.printBalance();
        ca.withdraw(50);
        ca.printBalance();
        ca.deposit(1000);
    }
}

// Devono esistere 3 tipi di conto: il conto Cayman, il conto Italiano e il conto Gold. Nessuna delle 3 deve essere figlia delle altre due
// Il metodo deposita deve essere diverso per tutte e tre.
// Il conto Cayman evade le tasse e non registra il movimento
// Il conto italiano quando fa un deposito paga il 10% di tasse come spese di registrazione del movimento. Deve printare "Grazie di aver dato il 10% della spesa per coprire le tasse del movimento". Quindi alla fine deposito solo il 90%.
// Il movimento ha una classe base che già esiste. Il conto italiano ha una lista di movimenti italiani che registreranno quanto hai pagato di tasse per un determinato movimento.
// Il conto gold ogni volta che fai un deposito controlla quanti movimenti hai fatto e per ogni 10 depositi fatti ti regala 1€
// Ci sarà un quarto tipo di conto, il conto Platino. Si comporta come il conto gold ma ti regala 10€ ogni 10 movimenti e lo fa sia per quando ritiri che quando depositi.
// Platinum: Ogni 10 depositi ti regala 10€. Ogni 10 withdraw maggiori di 100€ ti regala 10€.
// Creare una classe Bank che ha un metodo che si chiama gestisciConto() che deve poter ricevere in input qualsiasi conto e ne stamperà il saldo. Se il saldo è minore di 1000€ ci deposita sopra 200€ (eseguendo il deposito specifico di quel conto). Se il saldo è maggiore di 2000€ ritira 500€
