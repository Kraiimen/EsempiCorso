//Classe per tener conto della cronologia dei movimenti.
package org.generation.italy.bankproject.accounting;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Movement {
    //public static final String WITHDRAWAL = "WITHDRAWAL"; //public static sono soluzioni weakly typed in questo caso
    //public static final String DEPOSIT = "DEPOSIT";  //public static sono soluzioni weakly typed in questo caso

    private double amount;
    private double current;
    private LocalDateTime operationTime;
    private MovementType type; //Soluzione più strongly typed possibile per il nostro caso

    //avevamo pensato a una stringa, ma è weakly typed, ovvero troppo generale, il tipo di dato definisce il dominio
    //dei propri valori, essendo che le operazioni che andremo a fare son solo 2
    //private String operationType; //altra soluzione weakly typed


    //esempio di costruttore custom
    public Movement(Double amount, Double current, LocalDateTime operationTime, MovementType type) {
        this.amount = amount;
        this.current = current;
        this.operationTime = operationTime;
        this.type = type;
    }
    //MovementGetters
    public double getAmount() {
        return amount;
    }
    public double getCurrent() {
        return current;
    }
    public LocalDateTime getOperationTime() {
        return operationTime;
    }
    public MovementType getType() {
        return type;
    }
}



