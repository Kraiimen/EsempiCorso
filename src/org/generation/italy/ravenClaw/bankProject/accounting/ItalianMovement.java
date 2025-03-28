package org.generation.italy.ravenClaw.bankProject.accounting;

import java.time.LocalDateTime;

public class ItalianMovement extends Movement {
    private double tax;

    public ItalianMovement(double amount, double currentBalance, LocalDateTime operationTime, MovementType type, double tax){
        super(amount, currentBalance, operationTime, type)
        this.tax = tax;
    }

    private double getTax(){ return tax; }
}
