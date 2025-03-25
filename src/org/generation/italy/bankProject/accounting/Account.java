package org.generation.italy.bankProject.accounting; // sta dchiarando a quale package appartiene

import java.time.LocalDate;
import java.util.ArrayList;

public class Account { //la visibilità di default vuol dire visibile all'interno del suo package
    // in un file java può essere presente solo una classe pubblica che deve essere chiamata come il file
    // private = visibile solo nella classe che lo definisce (utilizzando prettamente per le variabili) private != cybersecurity

    //ATTRIBUTI - FIELDS - VARIABILI DEGLI OGGETTI
    private static int lastId; // prima quelle static e poi quella instances. serve assegnare a ogni id che creo un id differenza. deve essere statica altrimenti si resetta a 0
    private double balance;// la sua balance
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
       //this(0);
        creationDate = LocalDate.now(); // è un metodo statico, chiamato sulla classe
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
        System.out.printf("Il conto con id %d ha come saldo %f%n", id, balance);
    }
    public double deposit(double amount){ // deposito
        balance += amount;
        return balance;
    }
    public double withdraw(double amount){ // prelievo
        doInternalOperation();
        balance -= amount;
        return balance;
    }
    private void doInternalOperation(){

    }
    public double getBalance(){
        return balance; // ritorna in euro, non centesimi
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
    public void setCreationDate(LocalDate cr) {
        creationDate = cr;
    }
}

// lo stato di una classe è l'insieme delle sue variabili
// una variabile pubblica è private se non vogliamo che il resto del programma sappia Che esiste. perchè la vogliamo modificare come vogliamo
// quindi le variabili degli oggetti (lo stato della classe) dovrebbero di norma essere sempreprivate