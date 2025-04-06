package org.generation.italy.ravenClaw.bankProject.accounting;

import org.generation.italy.ravenClaw.bankProject.accounting.exceptions.CarmineException;
import org.generation.italy.ravenClaw.bankProject.accounting.exceptions.ExcessiveDepositException;
import org.generation.italy.ravenClaw.bankProject.accounting.exceptions.InvalidAmountException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Account {


    //ATTRIBUTI or FIELDS or VARIABILI DEGLI OGGETTI
    private static int lastId;
    private double balance;
    private int id;
    private LocalDate creationDate;
    private ArrayList movements;
    private String ownerCode;



    //COSTRUTTORI
    public Account(double balance, String ownerCode) {
        lastId++;
        id = lastId;
        this.balance = balance;
        creationDate = LocalDate.now();
        movements = new ArrayList();
        this.ownerCode = ownerCode;

    }


    //FUNZIONI - prima quelle importanti poi le getter o setter
    public void printBalance() {
        System.out.println("durante questa esecuzione di printBalance this è uguale a " + this);
        System.out.printf("Il conto con id %d ha come saldo %f%n", this.id, this.balance);
    }

    public abstract double deposit(double amount) throws Exception;

    public double withdraw(double amount) throws InvalidAmountException {
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        movements.add(move);
        balance -= amount;
        return balance;
    }

    public double getSumDeposits() {
        double sum = 0;
        for (int i = 0; i < movements.size(); i++) {
            Object ob = movements.get(i);
            Movement m = (Movement) ob;
            if (m.getType() == MovementType.DEPOSIT) {
                sum += m.getAmount();
            }
        }
        return sum;
    }
    public double getTotalAmountFor(MovementType type, LocalDate start, LocalDate end, double lowerBound) {
        double totalAmount = 0;
        for (Object ob : movements) {
            Movement m = (Movement) ob;
            LocalDate movementDate = m.getOperationTime().toLocalDate();
            boolean isInRange = movementDate.isAfter(start) && movementDate.isBefore(end);
            if (m.getType() == type && isInRange && m.getAmount() >= lowerBound) {
                totalAmount += m.getAmount();
            }
        }
        return totalAmount;
    }

    public void isAmountValid(double amount ) throws InvalidAmountException {
        if(amount <= 0 ) {
            throw new InvalidAmountException("Error: dammi un numero positivo");
        }

    }
    public void isDepositTooBig(double amount) throws ExcessiveDepositException{
        if(amount > 100_000){
            throw new ExcessiveDepositException();
        }
    }
    public void areThereFunds(double amount) throws InvalidAmountException{
        if(getBalance() < amount){
            throw new InvalidAmountException("Il tuo bilancio è minore di quanto stai provando a ritirare");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        if (newBalance <= 0) {
            return;
        }
        balance = newBalance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public ArrayList getMovements() {
        return movements;
    }
//    protected void temp() throws ExcessiveDepositException{
//    }
    public int getNumberOfMovements(){
        return movements.size();
    }
    public int getId(){
        return id;
    }

    public String getOwnerCode() {
        return ownerCode;
    }
}