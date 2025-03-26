package org.generation.italy.bankProject.accounting;

import java.time.LocalDateTime;


public class Movement {
    private double amount;//VARIABILI
    private double currentBalance;
    private LocalDateTime operationTime;
    private MovementType type;


    //creerò il secondo costruttore custom
    public Movement(double amount, double balance, LocalDateTime operationTime, MovementType type) {//PARAMETRO DI INPUT DEL COSTRUTTORE, LE VARIABILI DI UN OGGETTO
        // SONO VISIBILI A TUTTI I SUOI METODI
        this.amount = amount;//THIS è un puntatore che indica l'oggetto che stiamo costruendo
        this.currentBalance = currentBalance;
        this.operationTime = operationTime;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public MovementType getType() {
        return type;
    }

}



//GETTER:Il getter è un metodo che permette di leggere (o ottenere) il valore di una variabile privata di una classe.
//SETTER:Il setter è un metodo che permette di impostare (o modificare) il valore di una variabile privata di una classe.