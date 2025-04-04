package org.generation.italy.bankProject.accounting.centralbank;

import org.generation.italy.bankProject.accounting.AccountRepository;
import org.generation.italy.bankProject.accounting.DataException;
import org.generation.italy.bankProject.accounting.accounts.Account;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.ExcessiveDepositException;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.GuardiaDiFinanzaException;
import org.generation.italy.bankProject.accounting.exceptions.accountExceptions.InvalidAmountException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class Bank implements AccountRepository {
    private static final double MIN_BALANCE = 1000;
    private static final double MAX_BALANCE = 2000;
    private static final double BUFF_BALANCE = 200;
    private static final double NERF_BALANCE = 500;
    private ArrayList<Account> bankAccounts;

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

    @Override
    public int saveAccount(Account a) throws DataException {
        return 0;
    }

    @Override
    public ArrayList<Account> getAll() throws DataException {
        return null;
    }

    @Override
    public void upDateAccount(Account a) {

    }

    @Override
    public boolean deleteAccount(int id) {
        return false;
    }

    @Override
    public Set<Account> getAllMoreActiveThan(int numMovements) {
        return Set.of();
    }

    @Override
    public Set<Account> getByClientId(int clientId) {
        return Set.of();
    }

    @Override
    public Set<Account> getByBalanceAndDateRange(double balance, LocalDate start, LocalDate end) {
        return Set.of();
    }

    @Override
    public Account getAccountById(int id) {
        return null;
    }
}
