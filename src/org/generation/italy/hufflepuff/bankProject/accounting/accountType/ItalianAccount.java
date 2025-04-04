
package org.generation.italy.hufflepuff.bankProject.accounting.accountType;

import org.generation.italy.hufflepuff.bankProject.accounting.ItalianMovement;
import org.generation.italy.hufflepuff.bankProject.accounting.MovementType;
import org.generation.italy.hufflepuff.bankProject.accounting.exceptions.ExcessiveDepositException;
import org.generation.italy.hufflepuff.bankProject.accounting.exceptions.InvalidAmountException;

import java.time.LocalDateTime;

public class ItalianAccount extends Account {
    private double tax;

    public ItalianAccount(double initialBalance){
        super(initialBalance);
    }

    @Override
    public double deposit(double amount)throws ExcessiveDepositException {

        checkAmountForDeposit(amount);
        tax = 0.1;
        double taxedAmount = amount * tax;
        amount -= taxedAmount;
        ItalianMovement move = new ItalianMovement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT, taxedAmount);
        movements.add(move);
        balance += amount;
        System.out.println("Grazie pezzente per la tassa di " + taxedAmount + "€. Il tuo bilancio ora è di " + balance + "€.");
        return balance;
    }

    @Override
    public double withdraw(double amount) throws InvalidAmountException {

        checkAmountForWithdraw(amount);//Prima questo, se questo funziona non lancia l'errore ed esegue il withdraw.
        tax = 0;
        double taxedAmount = amount * tax;
        double newAmount = amount - taxedAmount;
        ItalianMovement move = new ItalianMovement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL, taxedAmount);
        movements.add(move);
        balance -= amount;

        return balance;
    }

    @Override
    public void printAllMovement (){
        for(Object obj: movements){
            ItalianMovement m1 = (ItalianMovement) obj;
            System.out.println(m1);
        }
    }


}