package org.generation.italy.bankProject.accounting.accounts;

import org.generation.italy.bankProject.accounting.Client;
import org.generation.italy.bankProject.accounting.movements.*; //tanto facevamo comunque l'import di tutte le classi una per una
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Account {
    //in un file java può essere presente solo una classe pubblica che deve essere chiamata come il file

    //ATTRIBUTI or FIELDS or VARIABILI DEGLI OGGETTI
    private static int lastId; //usando "static" ogni conto avrà il suo lastId
    protected double balance;
    private int id;
    private LocalDate creationDate;
    private ArrayList<Movement> movements;
    private Client client;
    // Quando il compilatore vede il nome di una classe si chiede "Questa classe viene da Java.lang?" ovvero il package base del linguaggio java
    // se questo non è vero, si chiede "è dello stesso package di questa classe?" quindi se in un file si vuole usare una classe che sta nello stesso package del file, non c'è bisogno di importarla
    // se non la trova nemmeno li controllerà la lista degli import a inizio file


    //COSTRUTTORI
    public Account(Client client){
        this.client = client;
        lastId++;
        id = lastId;
        creationDate = LocalDate.now();
        movements = new ArrayList<Movement>();
    }
    public Account(double balance, Client client) {
        this(client);
        balance = balance;
    }
    public Account(double balance, LocalDate creationDate, Client client) {
        this(balance, client);
        this.creationDate = creationDate;
    }

    //METODI - prima quelle importanti poi le getter o setter
    public void printBalance(){
        System.out.printf("il tuo conto con in %d ha come saldo %f%n", id, balance);
    }
    public abstract double deposit(double amount) throws ExcessiveDepositException, GuardiaDiFinanzaException;

    public abstract double withdraw(double amount) throws InvalidAmountException;

    public double getTotalDeposits() {
        double total = 0;

        for (Movement m : movements) {
            total += m.getAmount();
        }
        return total;
    }
    /*      //quando movements era ancora un ArrayList senza le generics
    public double getTotalDeposits() {
        double total = 0;
        if(doesMovementsContainsOnlyMovementTypes()){
            return -1;
        }
        for(Movement movement : (ArrayList<Movement>) movements){
            if(movement.getType() == MovementType.DEPOSIT){
                total += movement.getAmount();
            }
        }
        return total;
    }
    //*/

    //Somma dei movimenti superiori ad una soglia passata in input,
    //di un tipo passato da input, in un range di date, passate in input,
    public double totalMovements(double lowerBound, MovementType type, LocalDate start, LocalDate end){
        if(doesMovementsContainsOnlyMovementTypes() == false) {
            return 0;
        }
        double total = 0;

        for(Movement m : movementss){
            boolean isCorrectType = m.getType() == type;
            boolean isValidAmount = m.getAmount() >= lowerBound;

            LocalDate date = m.getOperationTime().toLocalDate();
            boolean isValidDate = date.isAfter(start) && date.isBefore(end);

            if(isCorrectType && isValidAmount && isValidDate){
                total += m.getAmount();
            }
        }
        return total;
    }

    protected void addMovement(Movement m){
        movements.add(m);
    }
    public boolean isCreatedAfter(LocalDate start){
        return creationDate.isAfter(start);
    }
    public boolean isCreatedBefore(LocalDate end){
        return creationDate.isBefore(end);
    }

    public boolean isCreatedInRange(LocalDate start, LocalDate end){
        return isCreatedAfter(start) && isCreatedBefore(end);
    }

    // /------GETTER & SETTER-----/
    public double getBalance(){
        return balance;
    }
    public void setBalance(double newBalance){
        if(newBalance > 0){
            balance = newBalance;
        }
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Movement> getMovements() {
        return movements;
    }

    public Client getClient() {
        return client;
    }
}


//lo stato di una classe è l'insieme delle sue variabili
//una variabile è privata se non vogliamo che il resto del programma sappia che esiste perché la vogliamo modificare come vogliamo
//quindi le variabili degli oggetti (lo stato della classe) dovrebbero di norma sempre essere private