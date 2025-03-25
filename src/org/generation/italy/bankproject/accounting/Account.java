package org.generation.italy.bankproject.accounting;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
	//ATTRIBUTI o FIELDS o VARIABILI DEGLI OGGETTI
	private static int lastId;
	// Inizialmente lastId vale 0. Lo 'static' lo rende appartenente alla classe, e non agli oggetti.
	// Con lo static esiste una sola variabile lastId posseduta dalla classe e condivisa da tutti gli oggetti
	private double balance; // saldo
	private int id;
	private LocalDate creationDate;
	private ArrayList movements;   // ArrayList generics non specializzato, indirizzo all'array list con dentro null per ora

	// COSTRUTTORI
	// Costruttore di default, non è necessario creare esplicitamente il costruttore di default, il compiler lo creerebbe in automatico
	public Account() {
		// this(0);   se volessi invocare il secondo dal primo
		lastId++; // Il primo id del primo oggetto sarà 1, poi 2, 3, ecc.
		id = lastId;
		creationDate = LocalDate.now(); // Data della creazione del conto. Now è un metodo di una classe, un metodo statico della classe Localdate.
	}

	public Account(double balance) {
		this();  // Con il this evito di ripetere di nuovo le operazioni con l'id. Con this() chiamo il costruttore senza argomenti, per cui in automatico le stesse operazioni interne
//		lastId++;
//		id = lastId;
		this.balance = balance;
	}

	public Account(double balance, LocalDate creationDate) {
		this(balance); // Così setto la balance richiamando il secondo costruttore, che a sua volta richiama il primo impostando il giusto id
		this.creationDate = creationDate; // Questo sovrascrive il creationDate creato dal primo costruttore
	}


	// METODI
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

	private void doInternalOperation() {

	} // Funzione che ora non fa nulla, solo a mo' di esempio

	// GETTER E SETTER
	public double getBalance() {
		return balance;
	}

	public void setBalance(double newBalance) {
		if (newBalance < 0) {
			return;      // In questo modo non posso resettare la variabile balance a valori negativi
		}
		balance = newBalance;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate cr) {
		creationDate = cr;
	}


}