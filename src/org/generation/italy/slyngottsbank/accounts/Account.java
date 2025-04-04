package org.generation.italy.slyngottsbank.accounts;

import org.generation.italy.slyngottsbank.exceptions.ExcessiveDepositException;
import org.generation.italy.slyngottsbank.exceptions.InvalidAmountException;
import org.generation.italy.slyngottsbank.exceptions.PoliceException;
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
    protected ArrayList movements;

    // COSTRUTTORI
    public Account() {
        lastId++;
        id = lastId;
        creationDate = LocalDate.now();
        movements = new ArrayList();
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
        System.out.printf("Il conto %s con id %d ha come saldo %.2f%n", getAccountName(), id, balance);
    }

    //    public  double deposit(double amount){
//        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
//        movements.add(move);
//        balance += amount;
//        return balance;
//    }
    public abstract void deposit(double amount) throws ExcessiveDepositException, PoliceException;

    public void withdraw(double amount) throws InvalidAmountException {
        checkWithdrawAmount(amount);
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        movements.add(move);
        balance -= amount;
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

    public void printMovement() {
        for (Object ob : movements) {
            Movement obj = (Movement) ob;
            System.out.print(obj);
        }
    }

    public abstract String getAccountName();

    protected void checkWithdrawAmount(double amount) throws InvalidAmountException {
        if (amount > balance) {
            throw new InvalidAmountException();
        }
    }

    protected void checkDepositAmount(double amount) throws ExcessiveDepositException {
        if (amount > 100000) {
            throw new ExcessiveDepositException();
        }
    }
}
