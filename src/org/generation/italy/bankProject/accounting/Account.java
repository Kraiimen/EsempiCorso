package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        movements = new ArrayList();
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
        System.out.printf("Il conto con id %d ha come saldo %f%n", id, balance); // va in memoria all'indirizzo dell'oggetto su cui è stato chiamato e cerca l'id di quell'oggetto
    }

    public void printMovements(){
        for(int i = 0; i < movements.size(); i++) {
            Movement m = (Movement)movements.get(i);
            System.out.println(m);
        }
    }

    public double deposit(double amount){
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        movements.add(move);
        balance += amount;
        return balance;
    }

    public double withdraw(double amount){
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        movements.add(move);
        balance -= amount;
        return balance;
    }

    public double getDepositSum(){ // non passo nulla negli imput perché le informazioni dell'array list sono già nella classe
        double sum = 0;
        for(int i = 0; i < movements.size(); i++){
            Object ob = movements.get(i);
            Movement m = (Movement)ob;
            if(m.getType() == MovementType.DEPOSIT){ // con == perché esiste un solo oggetto di tipo deposit in memoria e io controllo se è quello. io chiedo se l'indirizzo del tipo del movimento è lo stesso indirizzo dell'oggetto deposit
                sum += m.getAmount();
            }
        }
        return sum;
    }

    public double getTotalAmountFor(MovementType type, LocalDate start, LocalDate end, double lowerBound){
        double totalAmount = 0;
        for(Object ob : movements){
            Movement m = (Movement)ob;
            LocalDate movementDate = m.getOperationTime().toLocalDate();
            boolean isInRange = movementDate.isAfter(start) && movementDate.isBefore(end);
            if(m.getType() == type && isInRange && m.getAmount() >= lowerBound){
                totalAmount += m.getAmount();
            }
        }
        return totalAmount;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate){
        this.creationDate = creationDate;
    }

    public double getBalance(){
        return balance;
    }

}