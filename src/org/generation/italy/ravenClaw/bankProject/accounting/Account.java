package org.generation.italy.ravenClaw.bankProject.accounting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Account {


    //ATTRIBUTI or FIELDS or VARIABILI DEGLI OGGETTI
    private static int lastId;
    private double balanceee;
    private int id;
    private LocalDate creationDate;
    private ArrayList movements;



    //COSTRUTTORI
    public Account(double balance) {
        lastId++;
        id = lastId;
        this.balanceee = balance;
        creationDate = LocalDate.now();
        movements = new ArrayList();
    }


    //FUNZIONI - prima quelle importanti poi le getter o setter
    public void printBalance() {
        System.out.println("durante questa esecuzione di printBalance this è uguale a " + this);
        System.out.printf("Il conto con id %d ha come saldo %f%n", this.id, this.balanceee);
    }

    public abstract double deposit(double amount);

    public double withdraw(double amount) {
        Movement move = new Movement(amount, balanceee, LocalDateTime.now(), MovementType.WITHDRAWAL);
        movements.add(move);
        balanceee -= amount;
        return balanceee;
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
        return balanceee;
    }

    public void setBalance(double newBalance) {
        if (newBalance <= 0) {
            return;
        }
        balanceee = newBalance;
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

//voglio un metodo che mi dia la somma delle cifre relative a movimenti di un tipo che gli passo in input (deposit o withdrawal)
//questi movimenti di cui avrò la somma devono essere compresi in un range di date che passo in input
//a questa funzione passerò un valore double che sarà la soglia sotto la quale non voglio vedere i movimenti
//double sum = c.getTotalAmountFor(MovementType.WITHDRAWAL , LocalDate.of(2025,1,15) , LocalDate.of(2025,2,20) , 200.0)



//lo stato di una classe è l'insieme delle sue variabili
//una variabile è privata se non vogliamo che il resto del programma sappia che esiste perché la vogliamo modificare come vogliamo
//quindi le variabili degli oggetti (lo stato della classe) dovrebbero di norma sempre essere private