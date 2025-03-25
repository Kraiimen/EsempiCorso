package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;

public class Account {
    private double balance;
    public int id;
    public LocalDate creationDate;

    public void printBalance(){
        System.out.printf("il tuo conto con in %d ha come saldo %f%n", id, balance);
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
