package org.generation.italy.bankproject.accounting.evasion;

import org.generation.italy.bankproject.accounting.Account;

import java.time.LocalDate;

public class CaymanAccount extends Account {     // Avendo utilizzato extends ora la classe ha tutte le funzionalità della classe account, CaymanAccount è un Account

    private String secretCode;


    public CaymanAccount() {
//        super();
//        super(1000); // Invoco il costruttore della classe madre che imposta una initial balance data da input
//        secretCode = "xxx";  // A questo punto posso personalizzare il costruttore
        this(10_000); // Invoco il secondo costruttore
    }
    // In alternativa posso fare come segue
    public CaymanAccount(double initialBalance) {
        super(initialBalance);
        secretCode = "xxx";
    }
    public CaymanAccount(double initialBalance, LocalDate initialDate, String secretCode) {
        super(initialBalance, initialDate); // Richiamo il costruttore di Account con 2 input di tipo double e LocalDate
        this.secretCode = secretCode;
    }



    private void evadeTax () {
//        System.out.println(balance);   // Non posso stampare balance perché la classe la eredita ma non è visibile qui in quanto private nella sua classe, diventa visibile se in Account la rendo protected
//        System.out.println(getBalance()); //In questo caso posso utilizzare il metodo perché ereditato, dovrò ovviamente utilizzarlo su un oggetto di classe CaymanAccount, che erediterà una balance, privata sì, ma presente
//        Account x = new Account(1000);
//        CaymanAccount z = new CaymanAccount();
//    System.out.println(x.balance);  // Non posso farlo perché l'oggetto x protected può vedere la variabile balance che ha ereditato, non quella di Account
//        System.out.println(z.balance); // Qui si perché è riferito a un oggetto CaymanAccount
        System.out.println("Evado le tasse con l'aiuto del commercialista Elvis");
    }


    // OVERRIDE, vado a creare una nuova funzione deposit al posto di quella ereditata da Account

    @Override
    public double deposit(double amt) {    // amt al posto di amount dell'originale, il nome dell'input non ha importanza per riconoscere una funzione come uguale a un'altra, è importante il tipo di input, il tipo di output, e il nome
        evadeTax();
        balance += amt;
        return balance;
    }

//    DIFFERENZA TRA FINAL PER PRIMITIVE E FINAL SU OGGETTI
//    public void temp() {
//        final int[] nums = {1, 2, 3, 4, 5};
//        nums[0] = 25;  // posso cambiare il valore delle variabili anche se ho usato final perché nums contiene la reference, ad essere final è la reference non le variabili. Non potrò cambiare l'indirizzo della reference
//        nums = new int[4]; questo invece non posso farlo
//        final int n = 3;
//        questa volta non posso cambiarlo, perchè NON è UN OGGETTO
//    }
}




