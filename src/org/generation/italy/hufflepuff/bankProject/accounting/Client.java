package org.generation.italy.hufflepuff.bankProject.accounting;

import org.generation.italy.hufflepuff.bankProject.accounting.accountType.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private String clientCode;
    private String lastName;
    private String firstName;
    private String birthDate;
    private List<Account> accounts;

    public Client(String clientCode, String lastName, String firstName, String birthDate) {
        this.clientCode = clientCode;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.accounts = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (this.getClass() != obj.getClass())){
            return false ;
        }
        Client other = (Client)obj;
        return this.clientCode.equals(other.clientCode);
    }

    @Override
    public int hashCode() {
        return clientCode.hashCode();
    }

    public String getClientCode() {
        return clientCode;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
