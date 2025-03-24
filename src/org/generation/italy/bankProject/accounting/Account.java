package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;

public class Account {
    double balance;
    int id;
    LocalDate creationDate;

    public void printBalance() {
        System.out.printf("il conto con id %d ha come saldo %f%n", id, balance);
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }
    public double withdraw(double amount) {
        balance -= amount;
        return balance;
    }

}