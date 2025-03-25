package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;

public class Account {
    public double balance;
    private int id;
    private LocalDate creationDate;
    //le classi si scrivono la con la maiuscola

    public Account() { //non c'è la specificazione del tipo di ritorno ("double", "void", ecc)

    } //un costruttore si deve chiamare esattamente come la classe

    public void printBalance() {  //vogli stampare una stringa con un numero (%d) e poi un parametro con la virgola (%f)

        System.out.printf("Il conto con ID %d ha come saldo %f%n", id, balance);

    }

    public double deposit(double amount) {
        balance += amount;
        return balance; 
    }

    public double withdraw(double amount) {
        balance -= amount;
        return balance; 
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate cr) {
        creationDate = cr;
    }

    //un "array list" è una struttura dati simile all'array, più intelligente e che mi dà più servizi
    //una delle principali feature è che si "autoridimensiona", se gli dò 101 elementi, e gli dò il limite di 100, lui ne crea un altro che
    //tenga il resto.
}
