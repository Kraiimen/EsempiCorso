package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;

public class Account {  //la visibilità di default vuol dire visibile all'interno del suo package
    //in un file java può essere presente solo una classe pubblica che deve essere chiamata come il file
    //private = visibile solo nella classe che lo definisce (utilizzato prettamente per le variabili) private != cybersecurity
    public double bal;
    private int id;
    // Quando il compilatore vede il nome di una classe si chiede "Questa classe viene da Java.lang?" ovvero il package base del linguaggio java
    // se questo non è vero, si chiede "è dello stesso package di questa classe?" quindi se in un file si vuole usare una classe che sta nello stesso package del file, non c'è bisogno di importarla
    // se non la trova nemmeno li controllerà la lista degli import ad inizio file
    private LocalDate creationDate;

    public Account(){

    } //invoco il costruttore (non necessario crearlo in quanto in assenza di costruttori in una classe il compilatore usa quello di default)
    // non c'è il tipo di ritorno perché il costruttore ritorna SEMPRE l'indirizzo dell'oggetto
    //il costruttore va sull' heap e mi alloca la memoria per contenere l'oggetto e inizializza le variabili dell'oggetto con i valori di default poi mi restituisce l'indirizzo
    //Inzializza a valori di default le variabili dell'oggetto

    public void printBalance(){
        System.out.printf("Il conto con id %d ha come saldo %f%n", id, bal);
    }

    public double deposit(double amount){
        bal += amount;
        return bal;
    }
    public double withdraw(double amount){
        doInternalOperation();
        bal -= amount;
        return bal;
    }
    private void doInternalOperation(){

    }
    public double getBalance(){
        return bal / 100;
    }
    public void setBalance(double newBalance){
        if(newBalance <= 0){
            return;
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


//lo stato di una classe è l'insieme delle sue variabili
//una variabile è privata se non vogliamo che il resto del programma sappia che esiste perché la vogliamo modificare come vogliamo
//quindi le variabili degli oggetti (lo stato della classe) dovrebbero di norma sempre essere private
