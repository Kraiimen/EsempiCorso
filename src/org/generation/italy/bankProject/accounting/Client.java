package org.generation.italy.bankProject.accounting;

import org.generation.italy.bankProject.accounting.accountType.CaymanAccount;
import org.generation.italy.bankProject.accounting.accountType.GoldAccount;
import org.generation.italy.bankProject.accounting.accountType.ItalianAccount;
import org.generation.italy.bankProject.accounting.accountType.PlatinumAccount;

import java.util.ArrayList;

public class Client {
    private String clientCode;
    private String lastName;
    private String firstName;
    private String birthDate;
    private ArrayList<Account> ownedAccounts;
    //Scegli come il client ha i propri conti


    public Client(String clientCode, String lastName, String firstName, String birthDate) {
        this.clientCode = clientCode;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        ownedAccounts = new ArrayList<>();
    }

    public void createItalianAccount(double amount){
        ItalianAccount it = new ItalianAccount(amount);
        ownedAccounts.add(it);
    }
    public void createGoldAccount(double amount){
        GoldAccount gd = new GoldAccount(amount);
        ownedAccounts.add(gd);
    }

    public void createPlatinumAccount(double amount){
        PlatinumAccount gd = new PlatinumAccount(amount);
        ownedAccounts.add(gd);
    }

    public void createCaymanAccount(double amount){
        CaymanAccount gd = new CaymanAccount(amount);
        ownedAccounts.add(gd);
    }

    @Override
    public boolean equals(Object obj){
        if((obj == null) || obj.getClass() != this.getClass()){
            return false;
        }
        Client other = (Client)obj;
        return this.clientCode.equals(other.clientCode);
    }

    @Override
    public int hashCode(){
        return clientCode.hashCode();
    }

    public ArrayList<Account> getOwnedAccounts() {
        return ownedAccounts;
    }
}
