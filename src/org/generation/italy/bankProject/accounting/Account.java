package org.generation.italy.bankProject.accounting;
import java.time.LocalDate;

// Quando il compilatore vede il nome di una classe si chiede "Questa classe viene da Java.lang?" ovvero il package base del linguaggio java
// se questo non è vero, si chiede "è dello stesso package di questa classe?" quindi se in un file si vuole usare una classe che sta nello stesso package del file, non c'è bisogno di importarla
// se non la trova nemmeno li controllerà la lista degli import ad inizio file

public class Account{
    private double bal;
    private int id;
    private LocalDate creationDate;

    public Account(double balance,int id , LocalDate creationDate){ //invoco il costruttore
        this.bal = bal;
        this.id= id;
        this.creationDate = creationDate;
    }

    public void printBalance(){
        System.out.printf("Il conto con id %d ha come saldo %f%n", id , bal);
    }

    public double deposit(double amount){
        bal += amount;
        return bal;
    }
    public double withdraw(double amount){
        bal -= amount;
        return bal;
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

    public LocalDate getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(LocalDate cr) {
        creationDate = cr;
    }

    // un "arraylist" è un oggetto che ha una strutture dati simile all'array,piu intelligente
    // una delle principali feature è che si autodimensiona,anche se la dimensione è 100 ,ma ci sono 101 si ridimensiona in auto


}