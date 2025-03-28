package org.generation.italy.bankproject.startup;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.generation.italy.bankproject.accounting.Account;
import org.generation.italy.bankproject.accounting.Movement;
import org.generation.italy.bankproject.accounting.MovementType;


public class Start {
    public static void main(String[] args) {
        Account x = new Account(2,LocalDate.now()); // creiamo un oggetto di tipo Account
        x.printBalance(); // se printassimo il valore di balance, che non è stato inizializzato nella classe uscirebbe 0.00
        x.deposit(100); // andiamo ad aggiungere 100 al bilancio usando la funzione deposit
        x.printBalance(); // adesso che il valore è stato modificato se printiamo uscirà 100
        x.withdraw(60); // adesso invece ritiriamo 60 con la funzione withdraw 
        x.printBalance(); // e printassimo il nuovo bilandio sarà 100-60
        Account x1 = new Account(200000,LocalDate.now());
        x1.printBalance();
    //  x.bal = x.bal + 150; // operazione possibile solo in caso di classe public, utilizziamo classi private di base per evitare ste porcate
                             // questa tipologia di codice mi porterebbe a dover cambiare migliaia di linee di codice, con private mi basta cambiare
                             // i dati all'interno della classe principale per avere cambiamenti effettivi ovunque
        x.printBalance();
        x.setBalance(-5); //viene ignorato perchè non permettiamo che sia < di 0 nel set bal in account
        x.printBalance();
        double balancex = x.getBalance();
        x.printBalance();
        System.out.println(balancex);
        Movement m1 = new Movement(100.00, x.getBalance(), LocalDateTime.now(), MovementType.DEPOSIT);
//        double depositSum = x.getSumDeposit();
//        System.out.println(depositSum);
   }
}