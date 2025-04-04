package org.generation.italy.slyngottsbank.accountmanagement;

import org.generation.italy.slyngottsbank.accounts.Account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client  {
    private String clientCode;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private List<Account> accounts;
    //Scegli come il client ha i propri conti

    public Client(String clientCode, String lastName, String firstName, LocalDate birthDate) {
        this.clientCode = clientCode;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        accounts = new ArrayList<>();
    }

    public void addNewAccount(Account account){
        accounts.add(account);
    }

    public double getTotalBalance(){
        double sum = 0;
        for (Account account : accounts){
            sum += account.getBalance();
        }
        return sum;
    }

    public int getNumAccounts(){
        return accounts.size();
    }

    public String getClientCode(){
        return clientCode;
    }
    @Override
    public String toString(){
        return "ClientCode: " + clientCode + " | Fullname: " + lastName + " " + firstName + " | Date of birth: " + birthDate;
    }


}
