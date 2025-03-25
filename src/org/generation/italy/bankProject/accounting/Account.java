package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
    private static int lastId;
    private double bal;
    private int id;
    // Quando il compilatore vede il nome di una classe si chiede "Questa classe viene da Java.lang?" ovvero il package base del linguaggio java
    // se questo non è vero, si chiede "è dello stesso package di questa classe?" quindi se in un file si vuole usare una classe che sta nello stesso package del file, non c'è bisogno di importarla
    // se non la trova nemmeno li controllerà la lista degli import ad inizio file
    private LocalDate creationDate;
    private ArrayList movements;


    public Account(){
        lastId++;
        this.id=lastId;
        this.creationDate = LocalDate.now();
    }
    public Account(double initialBalance){
        this(); //chiama il costruttore che non prende argomenti
//      lastId++;
//      this.id=lastId;
        this.bal = initialBalance;
    }
    public Account(double initialBalance, LocalDate creationDate){
        this(initialBalance);
        this.creationDate = creationDate;
    }

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
        return bal/100;
    }
    public void setBalance(double newBalance){
        if(newBalance <= 0){
            return;
        }
        bal = newBalance;
    }
    public void setCreationDate(LocalDate cr){
        creationDate = cr;
    }
}