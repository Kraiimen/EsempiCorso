package org.generation.italy.bankProject.accounting.centralbank;

import org.generation.italy.bankProject.accounting.accounts.Account;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.ExcessiveDepositException;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.GuardiaDiFinanzaException;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.InvalidAmountException;

import java.util.ArrayList;

public class Bank {
    private static final double MIN_BALANCE = 1000;
    private static final double MAX_BALANCE = 2000;
    private static final double BUFF_BALANCE = 200;
    private static final double NERF_BALANCE = 500;
    private ArrayList<Account> bankAccounts;    //da modificare, deve avere i fake DB

    // /-CONSTRUCTORS--/
    public Bank(){
        bankAccounts = new ArrayList<Account>();
    }

    // /--METHODS--/
    public void addAccount(Account a){
        bankAccounts.add(a);
    }

    public void manageAccounts(Account a){
        System.out.println("Saldo Precedente del conto: "+ a.getBalance());

        if(a.getBalance()<MIN_BALANCE){
            try {
                a.deposit(BUFF_BALANCE);
            } catch (ExcessiveDepositException e) {
                System.out.println(e.getMessage());
            } catch (GuardiaDiFinanzaException e){
                System.out.println(e.getMessage());
            }
        }
        if(a.getBalance()>MAX_BALANCE){
            try {
                a.withdraw(NERF_BALANCE);
            } catch (InvalidAmountException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Saldo Attuale del conto: "+ a.getBalance());
    }
}
