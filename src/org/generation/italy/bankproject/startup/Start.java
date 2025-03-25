package org.generation.italy.bankproject.startup;

import org.generation.italy.bankproject.accounting.Account;

public class Start {
	public static void main(String[] args) {
		Account x = new Account();
		x.printBalance();
		x.deposit(100);
		x.printBalance();
		x.withdraw(60);
		x.printBalance();
	}
}