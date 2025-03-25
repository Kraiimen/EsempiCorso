package org.generation.italy.bankproject.accounting;

import java.time.LocalDateTime;

public class Movement {
    // public static final String WITHDRAWAL = "WITHDRAWAL";
    // public static final String DEPOSIT = "DEPOSIT"
    private double amount;
    private double currentBalance;
    private LocalDateTime operationTime; // LocalDateTime è un oggetto che mi permette di usare date compreso giorno e ora
    // private String operationType;
    // per scrivere withdrawal quando è un prelievo e deposit quando è un deposito
    /* Una stringa è troppo generica per fare quello che volevo fare sopra, basterebbe usare una maiuscola invece di una minuscola e avrei degli errori.
    Sarebbe meglio ad esempio una booleana avendo solo due valori possibili. Oppure posso crearmi due costanti Stringa, come fatto su,
    riducendo il rischio di fare errori. Ma è ancora un'operazione 'fragile'.
    Capita spesso che in un programma ci sia un tipo di variabile che abbia solo pochi valori possibili, es una variabile con valori possibili
    nord, est, sud e ovest, ecc. In linguaggi primitivi facevo questo con le costanti, come fatto sopra, ma con Java posso creare un ENUM. */
    private MovementType type; //enum

    // costruttore
    public Movement(double amount, double balance, LocalDateTime operationTime, MovementType type) {
        this.amount = amount; // con la keyword this posso chiamare il parametro del costruttore uguale alla variabile che deve inizializzare
        this.currentBalance = balance;    // quando creo un oggetto della classe Movement uso il costruttore per settare l'oggetto con i dati che gli passo
        this.operationTime = operationTime;
        this.type = type;
    }

    // Non serve un setter perché si tratta di prelievi e depositi, non devo cambiare nessun dato
    // Avendo tutte variabili private e non avendo un setter gli oggetti di tipo Movement saranno immutabili
    // Creo invece un getter per ogni variabile

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
