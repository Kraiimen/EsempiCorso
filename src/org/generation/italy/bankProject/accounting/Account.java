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
        this.id=lastId;
        this.creationDate = LocalDate.now();
        this.movements = new ArrayList();
    }
    public Account(double initialBalance){
        this(); //chiama il costruttore che non prende argomenti
//      lastId++;
//      this.id=lastId;
        this.balance = initialBalance;
    }
    public Account(double initialBalance, LocalDate creationDate){
        this(initialBalance);
        this.creationDate = creationDate;
    }

    public void printBalance(){
        System.out.printf("Il conto con id %d ha come saldo %f%n", id, balance);
    }

    public double deposit(double amount){
        Movement move = new Movement(amount,this.balance, LocalDateTime.now(),MovementType.DEPOSIT);
        movements.add(move);
        this.balance += amount;
        return balance;
    }
    public double withdraw(double amount){
        Movement move = new Movement(amount, this.balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        movements.add(move);
        doInternalOperation();
        this.balance -= amount;
        return this.balance;
    }
    private void doInternalOperation(){}

    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double newBalance){
        if(newBalance <= 0){
            return;
        }
        this.balance = newBalance;
    }

    public int getId(){
        return id;
    }

    public void setCreationDate(LocalDate creationDate){
        this.creationDate = creationDate;
    }
    public double getSumDeposits(){
        double sum=0;
        for(int i=0; i< movements.size(); i++){
            Object ob = movements.get(i);
            Movement m = (Movement)ob;
            if(m.getType() == MovementType.DEPOSIT){
                sum+= m.getAmount();
            }
        }
        return sum;
    }
    //metodo che ritorna la somma delle cifre relative a movimenti di un tipo che gli passa in input
    //i movimenti devono essere compresi in un range di 2 date
    //passo un double in input
    //considera solo i movimenti che hanno un amount maggiore al double in input
    //double sum = c.getTotalAmountFor(MovementType.WITHDRAW, LocalDate.of(2025,1,15), LocalDate.of(2025,2,20), 200.0);
    public double getTotalAmountFor(MovementType type, LocalDate start, LocalDate end, double lowerBound){
        double totalAmount=0;
        for(Object ob : movements){
            Movement m = (Movement)ob;
            LocalDate movementDate = m.getOperationTime().toLocalDate();
            boolean isInRange =movementDate.isAfter(start) && movementDate.isBefore(start);
            if(m.getType() == type && isInRange && m.getAmount()>=lowerBound){
                totalAmount+=m.getAmount();
            }
        }
        return totalAmount;
    }
}