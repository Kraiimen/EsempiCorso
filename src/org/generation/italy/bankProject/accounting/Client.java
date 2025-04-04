package org.generation.italy.bankProject.accounting;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client {
    private String clientCode;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    //Scegli come il client ha i propri conti
    ArrayList<Account> ownedAccounts = new ArrayList<>();

    public Client(String clientCode, String lastName, String firstName, LocalDate birthDate) {
        this.clientCode = clientCode;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }
    public Client(String clientCode, String lastName, String firstName, LocalDate birthDate, Account oAccount) {
        this.clientCode = clientCode;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        ownedAccounts.add(oAccount);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Client)){
            return false;
        }
        Client other = (Client) obj;
        return other.clientCode.equals(this.clientCode);
    }

    @Override
    public int hashCode() {
        return clientCode.hashCode();
    }
}
