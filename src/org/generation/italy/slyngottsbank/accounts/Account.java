package org.generation.italy.slyngottsbank.accounts;

import org.generation.italy.slyngottsbank.movements.Movement;
import org.generation.italy.slyngottsbank.movements.MovementType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Account {
    protected static int lastId;
    protected double balance;
    protected int id;
    protected LocalDate creationDate;
    protected ArrayList<Movement> movements;

    // COSTRUTTORI
    public Account() {
        lastId++;
        id = lastId;
        creationDate = LocalDate.now();
        movements = new ArrayList<Movement>();
    }

    public Account(double initialBalance) {
        this();
        balance = initialBalance;
    }

    public Account(double initialBalance, LocalDate creationDate) {
        this(initialBalance);
        this.creationDate = creationDate;
    }

    // METODI
    public void printBalance() {
        System.out.printf("Il conto con id %d ha come saldo %f%n", this.id, this.balance);
    }

    public abstract double deposit(double amount);

    public double withdraw(double amount) {
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        movements.add(move);
        balance -= amount;
        return balance;
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

    public double getSumDeposits() {
        double sum = 0;

        for (Movement movement : movements) {
            if (movement.getType() == MovementType.DEPOSIT) {
                sum += movement.getAmount();
            }
        }
        return sum;
    }

    public double getTotalAmountFor(MovementType type, LocalDate start, LocalDate end, double lowerBound) {
        double totalAmount = 0;
        for (Movement movement : movements) {
            LocalDate movementDate = movement.getOperationTime().toLocalDate();
            boolean isInRange = movementDate.isAfter(start) && movementDate.isBefore(end);
            if (movement.getType() == type && isInRange && movement.getAmount() >= lowerBound) {
                totalAmount += movement.getAmount();
            }
        }
        return totalAmount;
    }

    public void printMovement() {
        for (Movement movement : movements) {
            System.out.print(movement.getAmount());
        }
    }

}
