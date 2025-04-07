package org.generation.italy.bankProject.accounting;

import org.generation.italy.bankProject.accounting.accountType.Account;
import org.generation.italy.bankProject.accounting.accountType.CaymanAccount;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientCode, client.clientCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(clientCode);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientCode='" + clientCode + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    public int addAccount(Account account) {
        accounts.add(account);
        return accounts.size();
    }

    public String getClientCode() {
        return clientCode;
    }

    public int getNumAccounts() {
        return accounts.size();
    }

    public double getTotalBalance() {
        double total = 0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    public boolean isTaxEvader() {
        for (Account account : accounts) {
            if (account instanceof CaymanAccount) {
                return true;
            }
        }
        return false;
    }

}
