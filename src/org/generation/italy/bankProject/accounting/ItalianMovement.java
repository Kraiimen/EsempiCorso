package org.generation.italy.bankProject.accounting;

import java.time.LocalDateTime;

public class ItalianMovement extends Movement{

    private double paidTaxes;

    // /--CONSTRUCTORS--/

    public ItalianMovement(double amount, double currentBalance, LocalDateTime operationTime, MovementType type){
        super(amount, currentBalance,  operationTime, type);
    }
    public ItalianMovement(double amount, double currentBalance, LocalDateTime operationTime, MovementType type, double paidTaxes){
        super(amount, currentBalance,  operationTime, type);
        this.paidTaxes = paidTaxes;
    }

    // /--GETTER & SETTER--/

    public double getPaidTaxes() {
        return paidTaxes;
    }

    private void setPaidTaxes(double paidTaxes) {
        this.paidTaxes = paidTaxes;
    }
}
