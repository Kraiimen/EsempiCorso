package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Account {
    //------------------FIELDS--------------------
    private static int lastId;
    private double balance;
    private int id;
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
        System.out.printf("il tuo conto con in %d ha come saldo %f%n", id, balance);
    }

    public double deposit(double amount){
        Movement m = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        movements.add(m);
        balance += amount;
        return balance;
    }
    public double withdraw(double amount){
        if((balance - amount) >= 0){
            Movement m = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
            movements.add(m);
            balance -= amount;
        }
        return balance;
    }

    //Somma dei movimenti superiori ad una soglia passata in input,
    //di un tipo passato da input, in un range di date, passate in input,
    public double totalMovements(double lowerBound, MovementType type, LocalDate start, LocalDate end){
        if(doesMovementsContainsOnlyMovementTypes() == false) {
            return 0;
        }
        double total = 0;

        for(Object obj : movements){
            Movement movement = (Movement)obj;

            boolean isCorrectType = movement.getType() == type;
            boolean isValidAmount = movement.getAmount() >= lowerBound;

            LocalDate date = movement.getOperationTime().toLocalDate();
            boolean isValidDate = date.isAfter(start) && date.isBefore(end);

            if(isCorrectType && isValidAmount && isValidDate){
                total += movement.getAmount();
            }
        }
        return total;
    }

    public double totalDeposits(){
        double total = 0;
        if(doesMovementsContainsOnlyMovementTypes()){
            //è meglio fare così, ma usa i generics
//            for(Movement movement : (ArrayList<Movement>) movements){
//                if(movement.getType() == MovementType.DEPOSIT){
//                    total += movement.getAmount();
//                }
//            }
            for(Object obj : movements){
                Movement movement = (Movement)obj;
                if(movement.getType() == MovementType.DEPOSIT){
                    total += movement.getAmount();
                }
            }
        }
        return total;
    }

    private boolean doesMovementsContainsOnlyMovementTypes(){
        for(Object obj : movements){
            if(obj.getClass() != Movement.class){
                return false;
            }
        }
        return true;
    }

    //---------------GETTER & SETTER-----------------
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

}

