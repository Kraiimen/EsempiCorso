package org.generation.italy.hufflepuff.bankProject.accounting.accountType;

import org.generation.italy.hufflepuff.bankProject.accounting.Movement;
import org.generation.italy.hufflepuff.bankProject.accounting.MovementType;
import org.generation.italy.hufflepuff.bankProject.accounting.exceptions.ExcessiveDepositException;
import org.generation.italy.hufflepuff.bankProject.accounting.exceptions.InvalidAmountException;
import org.generation.italy.hufflepuff.bankProject.accounting.exceptions.NegativeBalanceException;

import java.time.LocalDate;
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
    public abstract double deposit(double amount)throws ExcessiveDepositException;

    public abstract double withdraw(double amount)throws InvalidAmountException;
    private void doInternalOperation(){

    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double newBalance) throws NegativeBalanceException {
        if(newBalance <= 0){
            throw  new NegativeBalanceException("Il saldo non può essere negativo");
        }
        balance = newBalance;
    }

    public int getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public double getSumDeposits(){
        double sum = 0;
        for(int i = 0 ; i < movements.size() ; i++) {
            Object ob = movements.get(i);
            Movement m = (Movement)ob;
//            Movement m2 = (Movement)movements.get(i);
            if(m.getType() == MovementType.DEPOSIT) {
                sum += m.getAmount();
            }
        }
        return sum;
    }
    //voglio un metodo che mi dia la somma delle cifre relative a movimenti di un tipo che gli passo in input (deposit o withdrawal)
    //questi movimenti di cui avrò la somma devono essere compresi in un range di date che passo in input
    //a questa funzione passerò un valore double che sarà la soglia sotto la quale non voglio vedere i movimenti
    //double sum = c.getTotalAmountFor(MovementType.WITHDRAWAL , LocalDate.of(2025,1,15) , LocalDate.of(2025,2,20) , 200.0)
    public double getTotalAmountFor(MovementType type, LocalDate start, LocalDate end, double lowerBound){
        double totalAmount = 0;
        for(Object ob : movements){
            Movement m = (Movement)ob;
            LocalDate movementDate = m.getOperationTime().toLocalDate();
            boolean isInRange = movementDate.isAfter(start) && movementDate.isBefore(end);
            if(m.getType() == type && isInRange && m.getAmount() >= lowerBound){
                totalAmount += m.getAmount();
            }
        }
        return totalAmount;
    }

    public void printAllMovement() {
        for (Object obj : movements) {
            Movement m1 = (Movement) obj;
            System.out.println(m1);
        }
    }

    public void printByType(MovementType type) {
        for (Object obj : movements) {
            Movement m1 = (Movement) obj;
            if(m1.getType() == type) {
                System.out.println("Account ID: " + id);
                System.out.println(m1);
            }
        }
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Account)){
            return false;
        }
        Account other = (Account)obj;
        return other.balance == this.balance;
    }
    public void checkAmountForWithdraw(double amount) throws InvalidAmountException {//scrivo throws perchè descrive la funzione
        if(amount > balance){
            throw new InvalidAmountException();//scrivo throw perchè questo è un comando
        }
    }
    public void checkAmountForDeposit(double amount) throws ExcessiveDepositException {
        if(amount > 100_000){
            throw new ExcessiveDepositException();
        }
    }

}


//lo stato di una classe è l'insieme delle sue variabili
//una variabile è privata se non vogliamo che il resto del programma sappia che esiste perché la vogliamo modificare come vogliamo
//quindi le variabili degli oggetti (lo stato della classe) dovrebbero di norma sempre essere private