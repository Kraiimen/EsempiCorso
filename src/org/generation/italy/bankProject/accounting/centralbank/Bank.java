package org.generation.italy.bankProject.accounting.centralbank;

import org.generation.italy.bankProject.accounting.accounts.Account;

import java.util.ArrayList;

public class Bank {
    private static final double MIN_BALANCE = 1000;
    private static final double MAX_BALANCE = 2000;
    private static final double BUFF_BALANCE = 200;
    private static final double NERF_BALANCE = 500;
    private ArrayList bankAccounts;

    // /-CONSTRUCTORS--/
    public Bank(){
        bankAccounts = new ArrayList();
    }
    // /--METHODS--/
    public void addAccount(Account a){
        bankAccounts.add(a);
    }

    public void manageAccounts(Account a){
        System.out.println("Saldo Precedente del conto: "+ a.getBalance());

        if(a.getBalance()<MIN_BALANCE){
            a.deposit(BUFF_BALANCE);
        }
        if(a.getBalance()>MAX_BALANCE){
            a.withdraw(NERF_BALANCE);
        }

        System.out.println("Saldo Attuale del conto: "+ a.getBalance());
    }
}
