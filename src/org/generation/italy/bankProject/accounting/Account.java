package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;

public class Account {
    private double balance;
    private int id;
    private LocalDate creationDate;

    public Account() {

    }
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
    private void doInternalOperation() {

    }
    public double getBalance() {
        return balance / 100;
    }
    public void setBalance(double newBalance) {
        if(newBalance <= 0) {
            return;
        }
        balance = newBalance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate cr) {
        creationDate = cr;
    }

    //un' "array list" è una struttura dati simile all'array, più intelligente e che mi dà più servizi. è un array sotto steroidi.
    //una delle principali feature è che si autoridimensiona, se gli dò 101 elementi,
}