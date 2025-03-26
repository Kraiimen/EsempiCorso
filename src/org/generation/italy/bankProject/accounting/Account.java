package org.generation.italy.bankProject.accounting; // sta dchiarando a quale package appartiene

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Account { //la visibilità di default vuol dire visibile all'interno del suo package
    // in un file java può essere presente solo una classe pubblica che deve essere chiamata come il file
    // private = visibile solo nella classe che lo definisce (utilizzando prettamente per le variabili) private != cybersecurity

    //ATTRIBUTI - FIELDS - VARIABILI DEGLI OGGETTI
    private static int lastId; // prima quelle static e poi quella instances. serve assegnare a ogni id che creo un id differenza. deve essere statica altrimenti si resetta a 0
    public double balance;// la sua balance
    private int id; // il suo identificativo
    private LocalDate creationDate; // caratteristica che da la data di creazione
    private ArrayList movements; // lista dei movimenti fatti del conto corrente
    // Quando il compilatore vede il nome di una classe si chiede "Questa classe viene da Java.lang?" ovvero il package base del linguaggio java
    // se questo non è vero, si chiede "è dello stesso package di questa classe?" quindi se in un file si vuole usare una classe che sta nello stesso package del file, non c'è bisogno di importarla
    // se non la trova nemmeno li controllerà la lista degli import all' inizio file


    // COSTRUTTORI
    public Account(){ // è un costruttore
       lastId++;
       id = lastId;
       // this(0);
       creationDate = LocalDate.now(); // è un metodo statico, chiamato sulla classe
       movements = new ArrayList();
    }
    public Account(double initialBalance){
        this();
        //questo this è un'invocazione del costruttore di questa Classe che non prendono argomenti ovvero Account(sopra, non ha parametri di input
        balance = initialBalance; //account è il nome di tutti e due i costruttori, ma li differenzierò perchè avranno parametri diversi
    }
    public Account(double initialBalance, LocalDate creationDate){
        this(initialBalance);
        this.creationDate = creationDate;
    }
    // costruttore di default(non necessario crearlo in quanto in assenza di costruttori di una classe, il compilatore usa quello di default),
    //non c'è il tipo di ritorno perchè il costruttore ritorna SEMPRE  l'indirizzo dell'oggetto. si deve chiamare come la class
    // il costruttore va sull'heap e mi colloca la memoria per contenere l'oggetto e mi restituisce l'indirizzo
    // Inizializza a valori di default le variabili dell'oggetto


    // FUNZIONI - prima quelle importanti poi le getter o le setter
    public void printBalance(){
        System.out.println("Durante questa esecuzione di printBalance this è uguale a " + this);
        System.out.printf("Il conto con id %d ha come saldo %f%n", this.id, this.balance);
    }
    // esegue la funzione printf , da la stringa il %d ci finisce l'id che è un intero, %f mette la double balance e la %n mette a capo
    // id e balance sono variabili di questo oggetto,(per esempio x)
    // in un costruttore o in un metodo, this indica l'oggetto in cui sto lavorando con quel metodo
    public double deposit(double amount){ // deposito
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        // Creo un oggetto di tipo movement chiamandolo move, mettendo in input tutti gli argomenti, affidandoci al file della classe movement
        movements.add(move); // stiamo aggiungendo questo nuovo oggetto (move) a movements
        balance += amount;
        return balance;
    }
    public double withdraw(double amount){ // prelievo
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDROWAL);
        doInternalOperation();
        movements.add(move);
        // viene creato un oggetto di tipo movement che registra il tipo di movimento e aggiunge alla lista il tipo di movimento
        // questo tipo di movimento viene messo dentro alla lista di array 'movements'
        // add è un metodo per aggiungere il movement nella lista dei movements (aggiungere questa funzione nella lista array)
        balance -= amount;
        return balance;
    }
    private void doInternalOperation(){

    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double newBalance){
        if (newBalance < 0){ // se il balance è minore di 0 ritorna nulla
            return; // funzione terminata
        }
        balance = newBalance;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    //questo this, il campo creation date sul campo in cui lo sto creando
    public double getSumDeposits(){
        double sum = 0;
//        Object o1 = movements.get(0);
//        Movement m1 = (Movement)o1;
        //Movement m1 = (Movement)movements.get(0); // questo metodo prende il primo elemento dell'array list
        // cast forzato, il compilatore non si fida che dentro l'array ci siano solo movements. mettendo Movement dentro le parentesi
        // forzando il compilatore a leggere soltanto i tipi movements.
        // m1 è un indirizzo del movimento di tipo Movement
        for(int i = 0; i < movements.size(); i++){
            Object ob = movements.get(i);
            Movement m = (Movement)ob;
            if(m.getType() == MovementType.DEPOSIT){
                sum += m.getAmount();
            }
        }// abbiamo trasformato array movements in un tipo object generico, e poi castarlo in movements
        // controlla nell'if se nella lista degli array ci sono dei depositi. gettype DEPOSIT è i valore dei tipi di movimento
        //aggiunge il valore del deposito alla somma di sum se il tipo di movimento è DEPOSIT
        return sum;
    }
    // voglio un metodo che mi dia la somma delle cifre relative a movimenti di un tipo che gli passo in input(deposit o withdrawn)
    // questi movimenti di cui avrò la somma devono essere compresi in un range di date che passo in input
    //a questa funzione passerò un valore double che sarà la soglia sotto la quale non voglio vedere i movimenti
    // double sum = c.getTotalAmountFor(MovementType.WITHDRAWAL, LocalDate.of(2025,1,15), LocalDate.of(2025,2,20), 200.0)
    public double getTotalAmountFor(MovementType type, LocalDate start, LocalDate end, double lowerBound){
        double totalAmount = 0;
        for(Object ob : movements){
            Movement m = (Movement)ob;
            LocalDate movementDate = m.getOperationTime().toLocalDate();
            // nel movement che abbiamo registrato dobbiamo compararlo con quello che immetiamo
            boolean isInRange = movementDate.isAfter(start) && movementDate.isBefore();
            if(m.getType() == type && isInRange && m.getAmount() >= lowerBound){
                totalAmount += m.getAmount();
            }
        }
        return totalAmount;
    }
}

// lo stato di una classe è l'insieme delle sue variabili
// una variabile pubblica è private se non vogliamo che il resto del programma sappia Che esiste. perchè la vogliamo modificare come vogliamo
// quindi le variabili degli oggetti (lo stato della classe) dovrebbero di norma essere sempreprivate