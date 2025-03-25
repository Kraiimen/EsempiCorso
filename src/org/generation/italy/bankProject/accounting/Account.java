package org.generation.italy.bankProject.accounting; // sta dchiarando a quale package appartiene

import java.time.LocalDate;

public class Account { //la visibilità di default vuol dire visibile all'interno del suo package
    // in un file java può essere presente solo una classe pubblica che deve essere chiamata come il file
    // private = visibile solo nella classe che lo definisce (utilizzando prettamente per le variabili) private != cybersecurity
    private double bal;
    private int id;
    // Quando il compilatore vede il nome di una classe si chiede "Questa classe viene da Java.lang?" ovvero il package base del linguaggio java
    // se questo non è vero, si chiede "è dello stesso package di questa classe?" quindi se in un file si vuole usare una classe che sta nello stesso package del file, non c'è bisogno di importarla
    // se non la trova nemmeno li controllerà la lista degli import ad inizio file

    LocalDate creationDate; // caratteristica che da la data di creazione

    public Account(){

    } // costruttore di default(non necessario crearlo in quanto in assenza di costruttori di una classe, il compilatore usa quello di default),
    //non c'è il tipo di ritorno perchè il cosstruttore itorna SEMPRE  l'indirizzo dell'oggetto. si deve chiamare come la class
    // il costruttore va sull'heap e mi colloca la memoria per contenere l'oggetto e mi restituisce l'indirizzo
    // Inizializza a valori di default le variabili dell'oggetto

    public void printBalance(){
        System.out.printf("Il conto con id %d ha come saldo %f%n", id, bal);
    }

    public double deposit(double amount){ // deposito
        bal += amount;
        return bal;
    }
    public double withdraw(double amount){ // prelievo
        doInternalOperation();
        bal -= amount;
        return bal;
    }
    private void doInternalOperation(){

    }
    public double getBalance(){
        return bal / 100; // ritorna in euro, non centesimi
    }
    public void setBalance(double newBalance){
        if (newBalance <= 0){ // se il balance è minore di 0 ritorna nulla
            return; // funzione terminata
        }
        bal = newBalance;
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