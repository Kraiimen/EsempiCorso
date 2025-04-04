package org.generation.italy.bankProject.accounting;

import org.generation.italy.bankProject.accounting.exceptions.NegativeBalanceException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

// Quando il compilatore vede il nome di una classe si chiede "Questa classe viene da Java.lang?" ovvero il package base del linguaggio java
// se questo non è vero, si chiede "è dello stesso package di questa classe?" quindi se in un file si vuole usare una classe che sta nello stesso package del file, non c'è bisogno di importarla
// se non la trova nemmeno li controllerà la lista degli import ad inizio file, infine andrà in errore
public class Account {
    private static int lastId;
    private double balance;
    private int id;
    private LocalDate creationDate;
    private ArrayList movements;


    //COSTRUTTORI
    public Account(){
        lastId++;
        id = lastId;
        creationDate = LocalDate.now();
    } //Costruttore di default che viene creato in automatico quando non creiamo nessun costruttore custom
    public Account(double balance){
        this(); //anziché ripetere ciò che fa il primo costruttore per incrementare l'id invoco
        //lastId++;
        this.balance = balance;
        //id = lastId;
    }
    public Account(double initialBalance, LocalDate creationDate){
        this(initialBalance);
        this.creationDate = creationDate;
    }

    //METODI
    public void printBalance(){
        System.out.printf("Il conto con id %d ha come saldo %f%n", id, balance);
    }

    public double deposit(double amount){
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        balance += amount;
        //movements.add(move);
        return balance;
    }

    public double withdraw(double amount) {
        double balancebefore = this.balance;
        try {
            if (balance < amount) {
                throw new NegativeBalanceException();
            }
            balance -= amount;
            Movement withdraw = new Movement(amount, balancebefore, LocalDateTime.now(), MovementType.WITHDRAWAL);
            return balance;
        } catch (NegativeBalanceException e) {
            System.out.println("Errore :" + e.getMessage());
            return balance;
        }
    }

        public void setBalance(double newBalance) {
                if (newBalance <= 0) {
                    System.out.println("Un conto non può essere settato ad un balance negativo");
                    return;
                }

                balance = newBalance; // Assegna il nuovo saldo

        }


        public double getBalance(){
        //avevamo un conto bancario la cui singola cifra indicata 1 euro ed ora indica 1 centesimo dunque
        //facciamo / 100 per far in modo che il print euro.cent avvenga correttamente (es 100 centesimi = 1.00 euro)
        return balance;

    }
//    public double getSumDeposit() {
//        double sum = 0;
//        for(int i = 0; i < movements.size(); i++){
//            Object ob = movements.get(i);
//            Movement m = (Movement)ob;
//            if(m.getType() == MovementType.DEPOSIT) {
//                sum += m.getAmount();
//            }
//
//        }
//        return sum;
//    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate CD) {
        creationDate = CD;
    }
    public int getId(){return id;}


    //un arraylist è una struttura dati simile all'array, potremmo definirla "Più intelligente" in quanto tale
    //implementa molte più operazioni, a differenza di un array l'arraylist per esempio si ridimensiona in automatico
    //

}
