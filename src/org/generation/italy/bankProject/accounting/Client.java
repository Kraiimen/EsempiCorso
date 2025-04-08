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

    public String getClientCode() {
        return clientCode;
    }

    public ArrayList<Account> getOwnedAccounts() {
        return ownedAccounts;
    }

    @Override
    public String toString(){
        return clientCode + " - " + firstName + " - " + lastName;
    }
}
