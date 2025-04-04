package org.generation.italy.bankProject.startup;

import org.generation.italy.bankProject.DbAccountRepository;
import org.generation.italy.bankProject.accounting.Bank;
import org.generation.italy.bankProject.accounting.FileAccountRepository;
import org.generation.italy.bankProject.accounting.MovementType;
import org.generation.italy.bankProject.accounting.accountType.GoldAccount;
import org.generation.italy.bankProject.accounting.accountType.ItalianAccount;
import org.generation.italy.bankProject.accounting.accountType.PlatinumAccount;

import java.time.LocalDate;

//Introdurre una classe cliente, un cliente ha un nome, un cognome, una data di nascita, un codice banca(string)
//un cliente deve avere dei conti
public class Start {

    public static void main(String[] args) {
        ItalianAccount it1 = new ItalianAccount(10000);
        it1.deposit(100);
        System.out.println();
        it1.printAllMovement();
        ItalianAccount it2 = new ItalianAccount(10000);
        it2.deposit(100);
        it2.printAllMovement();

        System.out.println();

        GoldAccount gold = new GoldAccount(10000);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.deposit(100);
//        gold.printByType(MovementType.DEPOSIT);

        PlatinumAccount pl = new PlatinumAccount(1000);
        pl.deposit(10);
        pl.deposit(10);
        pl.deposit(10);
        pl.deposit(10);
        pl.deposit(10);
        pl.deposit(10);
        pl.deposit(10);
        pl.deposit(10);
        pl.deposit(10);
        double deposit = pl.deposit(10);
        pl.printByType(MovementType.DEPOSIT);
        System.out.println(deposit);

//        pl.withdraw(100);
//        pl.withdraw(100);
//        pl.withdraw(100);
//        pl.withdraw(100);
//        pl.withdraw(100);
//        pl.withdraw(100);
//        pl.withdraw(100);
//        pl.withdraw(100);
//        pl.withdraw(100);
//        pl.withdraw(100);
//        pl.withdraw(100);
//        double withdraw = pl.withdraw(100);
//        pl.printByType(MovementType.WITHDRAWAL);
//        System.out.println(withdraw);
          Bank b = new Bank();
          FileAccountRepository fr = new FileAccountRepository();
          DbAccountRepository dr = new DbAccountRepository();
          b.loadAccounts(fr);












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
