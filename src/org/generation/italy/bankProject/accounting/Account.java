package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account {

    private static int lastId;
    private double balance;
    private int id;
    // Quando il compilatore vede il nome di una classe si chiede "Questa classe viene da Java.lang?" ovvero il package base del linguaggio java
    // se questo non è vero, si chiede "è dello stesso package di questa classe?" quindi se in un file si vuole usare una classe che sta nello stesso package del file, non c'è bisogno di importarla
    // se non la trova nemmeno li controllerà la lista degli import ad inizio file
    private LocalDate creationDate;
    private ArrayList movements;


    public Account(){
        lastId++;
        id = lastId;
        creationDate = LocalDate.now();
    }
    public Account(double balance){
        this();
        this.balance = balance;
    }

    public Account(double balance, LocalDate creationDate){
        this(balance);
        this.creationDate = creationDate;
    }

    public void printBalance(){
        System.out.printf("Il conto con id %d ha come saldo %f%n", id, balance);
    }

    public double deposit(double amount){
        balance += amount;
        return balance;
    }
    public double withdraw(double amount){
        balance -= amount;
        return balance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate cr){
        creationDate = cr;
    }

    public double getBalance(){
        return balance;
    }
}