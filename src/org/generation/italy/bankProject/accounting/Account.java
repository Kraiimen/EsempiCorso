ckage org.generation.italy.bankProject.accounting;

import java.time.LocalDate;

public class Account {
    double balance;
    int id;
    // Quando il compilatore vede il nome di una classe si chiede "Questa classe viene da Java.lang?" ovvero il package base del linguaggio java
    // se questo non è vero, si chiede "è dello stesso package di questa classe?" quindi se in un file si vuole usare una classe che sta nello stesso package del file, non c'è bisogno di importarla
    // se non la trova nemmeno li controllerà la lista degli import ad inizio file
    LocalDate creationDate;

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
}