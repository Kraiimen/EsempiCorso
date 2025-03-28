package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Account extends Object{  //extends object è implicito
    //la visibilità di default vuol dire visibile all'interno del suo package
    //in un file java può essere presente solo una classe pubblica che deve essere chiamata come il file
    //private = visibile solo nella classe che lo definisce (utilizzato prettamente per le variabili) private != cybersecurity


    //ATTRIBUTI or FIELDS or VARIABILI DEGLI OGGETTI
    private static int lastId; //usando "static" ogni conto avrà il suo lastId
    protected double balance;
    private int id;
    private LocalDate creationDate;
    protected ArrayList movements;
    // Quando il compilatore vede il nome di una classe si chiede "Questa classe viene da Java.lang?" ovvero il package base del linguaggio java
    // se questo non è vero, si chiede "è dello stesso package di questa classe?" quindi se in un file si vuole usare una classe che sta nello stesso package del file, non c'è bisogno di importarla
    // se non la trova nemmeno li controllerà la lista degli import a inizio file


    //COSTRUTTORI
    public Account() {
        lastId++;
        id = lastId;
//        this(0);
        creationDate = LocalDate.now();
        movements = new ArrayList();
    }
    public Account(double initialBalance) {
//        lastId++;
//        id = lastId;
        this();
        balance = initialBalance;  //Account è il nome di tutti e due i costruttori, ma li differenzierò perché avranno parametri diversi
    }
    public Account(double initialBalance, LocalDate creationDate) {
        this(initialBalance);
        this.creationDate = creationDate;
    }
    //invoco il costruttore (non necessario crearlo in quanto in assenza di costruttori in una classe il compilatore usa quello di default)
    // non c'è il tipo di ritorno perché il costruttore ritorna SEMPRE l'indirizzo dell'oggetto
    //il costruttore va sull' heap e mi alloca la memoria per contenere l'oggetto e inizializza le variabili dell'oggetto con i valori di default poi mi restituisce l'indirizzo
    //Inizializza a valori di default le variabili dell'oggetto


    //FUNZIONI - prima quelle importanti poi le getter o setter
    public void printBalance(){
        System.out.println("durante questa esecuzione di printBalance this è uguale a " +this);
        System.out.printf("Il conto con id %d ha come saldo %f%n", this.id, this.balance);
    }
    public abstract double deposit(double amount);

    public double withdraw(double amount){
        doInternalOperation();
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        movements.add(move);
        balance -= amount;
        return balance;
    }
    private void doInternalOperation(){

    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double newBalance){
        if(newBalance <= 0){
            return;
        }
        balance = newBalance;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public double getSumDeposits(){
        double sum = 0;
//        movements.add(0,"pippo");
//        Object o1 = movements.get(0);
//        Movement m1 = (Movement)o1;
        for(int i = 0 ; i < movements.size() ; i++) {
            Object ob = movements.get(i);
            Movement m = (Movement)ob;
//            Movement m2 = (Movement)movements.get(i);
            if(m.getType() == MovementType.DEPOSIT) {
                sum += m.getAmount();
//                sum = sum + m.getAmount();

            }
        }
        return sum;
    }
}