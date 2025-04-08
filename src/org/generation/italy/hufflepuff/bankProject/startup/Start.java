package org.generation.italy.hufflepuff.bankProject.startup;

import org.generation.italy.hufflepuff.bankProject.DbAccountRepository;
import org.generation.italy.hufflepuff.bankProject.accounting.*;
import org.generation.italy.hufflepuff.bankProject.accounting.accountType.*;
import org.generation.italy.hufflepuff.bankProject.accounting.exceptions.ExcessiveDepositException;
import org.generation.italy.hufflepuff.bankProject.accounting.exceptions.GuardiaDiFinanzaException;
import org.generation.italy.hufflepuff.bankProject.accounting.exceptions.InvalidAmountException;


public class Start {

    public static void main(String[] args) {
        ItalianAccount it1 = new ItalianAccount(10000);
        GoldAccount gold = new GoldAccount(10000);
        PlatinumAccount pl = new PlatinumAccount(1000);
        CaymanAccount ca = new CaymanAccount(10000);
        double deposit = pl.deposit(10);
        pl.printByType(MovementType.DEPOSIT);
        System.out.println(deposit);
        Bank b = new Bank();
        FileAccountRepository fr = new FileAccountRepository();
        DbAccountRepository dr = new DbAccountRepository();
        try {
            b.loadAccounts(fr);
        } catch (DataException e) {
            System.out.println("Error: "+ e.getMessage());
        }

        try{
            pl.deposit(100_000);
        } catch (ExcessiveDepositException e ){
            System.out.println("Error: "+ e.getMessage());
        }

        try{
            pl.withdraw(200_000);
        } catch (InvalidAmountException e){
            System.out.println("Error: " + e.getMessage());
        }

        try{
            for(int i = 0; i < 100; i ++){
                ca.deposit(100);
            }
        } catch (GuardiaDiFinanzaException e){
            System.out.println("Error: " + e.getMessage());
        }

        try{
            ca.withdraw(100_001);
        } catch (InvalidAmountException | GuardiaDiFinanzaException e ){
            System.out.println("Error: " + e.getMessage());
        }

        AccountRepository ac = new InMemoryAccountRepository();

        try {
            ac.saveAccount(pl);
            ac.saveAccount(it1);
            ac.saveAccount(ca);
            System.out.println(ac.getAll());

        } catch (DataException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
