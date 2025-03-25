package org.generation.italy.bankproject.startup;

import java.time.LocalDate;
import org.generation.italy.bankproject.accounting.Account;


public class Start {
    public static void main(String[] args) {
        Account x = new Account(2,1,LocalDate.now()); // creiamo un oggetto di tipo Account
        x.printBalance(); // se printassimo il valore di balance, che non è stato inizializzato nella classe uscirebbe 0.00
        x.deposit(100); // andiamo ad aggiungere 100 al bilancio usando la funzione deposit
        x.printBalance(); // adesso che il valore è stato modificato se printiamo uscirà 100
        x.withdraw(60); // adesso invece ritiriamo 60 con la funzione withdraw 
        x.printBalance(); // e printassimo il nuovo bilandio sarà 100-60
        Account x1 = new Account(200000,2,LocalDate.now());
        x1.printBalance();
   }
}