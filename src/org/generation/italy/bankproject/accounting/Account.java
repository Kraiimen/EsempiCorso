package org.generation.italy.bankproject.accounting;

import java.time.LocalDate;

public class Account {
	double balance; // saldo
	int id;
	LocalDate creationDate;

	public void printBalance() {
		System.out.printf("Il conto con id %d ha come saldo %f%n", id, balance);
	}

	public double deposit(double amount) {
		balance += amount;
		return balance;
	}

	public double withdraw(double amount) {
		balance -= amount;
		return balance;
	}
}