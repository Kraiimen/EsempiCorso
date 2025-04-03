package org.generation.italy.ravenClaw.bankProject.accounting;

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



    //COSTRUTTORI
    public Account(double balance) {
        lastId++;
        id = lastId;
        this.balance = balance;
        creationDate = LocalDate.now();
        movements = new ArrayList();
    }


    //FUNZIONI - prima quelle importanti poi le getter o setter
    public void printBalance() {
        System.out.println("durante questa esecuzione di printBalance this è uguale a " + this);
        System.out.printf("Il conto con id %d ha come saldo %f%n", this.id, this.balance);
    }

    public abstract double deposit(double amount);


    public double withdraw (double amount) {

        try {
            if (amount > balance) {
                throw new InvalidAmountException("Non hai tutti sti soldi, ti dò quei pochi spicci che hai");
            }
            Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
            movements.add(move);
            balance -= amount;

        } catch (InvalidAmountException e){
            System.out.println("Error: "+ e.getMessage());
            Movement move = new Movement(balance, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
            movements.add(move);
            balance -= balance;
        }
        return balance;
    }

    public double getSumDeposits() {
        double sum = 0;
//        movements.add(0,"pippo");
//        Object o1 = movements.get(0);
//        Movement m1 = (Movement)o1;
        for (int i = 0; i < movements.size(); i++) {
            Object ob = movements.get(i);
            Movement m = (Movement) ob;
//            Movement m2 = (Movement)movements.get(i);
            if (m.getType() == MovementType.DEPOSIT) {
                sum += m.getAmount();
//                sum = sum + m.getAmount();

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
}