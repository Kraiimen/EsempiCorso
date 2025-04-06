package org.generation.italy.bankProject.accounting;

import org.generation.italy.bankProject.accounting.accounts.Account;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    private static String lastClientCode;
    private String clientCode;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Map<Integer, Account> accounts;

    public Client(String firstName, String lastName, LocalDate birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        accounts = new HashMap<>();
        clientCode = generateClientCode();
    }
    public Client(String firstName, String lastName, LocalDate birthDate, Map<Integer, Account> accounts){
        this(firstName, lastName, birthDate);
        this.accounts = accounts;
    }


    private String generateClientCode(){
        if(lastClientCode == null){
            lastClientCode = "1";
            return lastClientCode;
        }
        Integer id = Integer.parseInt(lastClientCode);
        id++;
        lastClientCode = id.toString();
        return lastClientCode;
    }
//    Questo metodo fa la stessa cosa di quello sopra, ma utilizzando l'operatore ternario
//    private String generateClientCode(){
//        lastClientCode = lastClientCode == null ? "1" : Integer.valueOf(Integer.parseInt(lastClientCode)+1).toString();
//        return lastClientCode;
//    }

    public boolean addAccount(Account a){
        return accounts.put(a.getId(), a) == null;
    }
    public void addAccounts(List<Account> accounts){
        for(Account a : accounts){
            addAccount(a);
        }
    }


    //   /--GETTER & SETTER--/

    public String getClientCode() {
        return clientCode;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }
}
