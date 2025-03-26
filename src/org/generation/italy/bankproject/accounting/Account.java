package org.generation.italy.bankproject.accounting;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
		movements = new ArrayList(); // Ogni volta che utilizzo il costruttore per creare un account verrà creata una lista di movimenti dell'account
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
//		System.out.println("Durante questa esecuzione di printBalance this è uguale a " + this);   Per dimostrare che il valore di this alla chiamata coincide con l'indirizzo dell'oggetto con cui ho chiamato la funzione
		System.out.printf("Il conto con id %d ha come saldo %f%n", this.id, this.balance); // il this non è obbligatorio, ma comunque è implicito, perché è un puntatore all'oggetto su cui chiamo il metodo
	}

	public double deposit(double amount) {
		Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT); // Creo un nuovo oggetto di tipo Movement
		movements.add(move); // Registro la 'mossa' move nell'ArrayList, per ora non usiamo le generics.
		balance += amount;
		return balance;
	}

	public double withdraw(double amount) {
		Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
		movements.add(move);
		balance -= amount;
		return balance;
	}

	// Voglio fare un metodo che mi dica il totale delle somme dei depositi
	// I depositi posso prenderli dall'arraylist, per cui nessun input è necessario
	public double getSumDeposits() {
		double sum = 0;
//		movements.add(0, "Pippo");  //Per vedere che mettendo una Stringa dentro l'arraylist senza generics e castando forzatamente m1 mando il programma in crash
		// Non mi serve sapere la posizione in cui mi trovo nell'arraylist, per cui posso usare un for each, ma non usando le generics ho un problema
		// Per prendere gli elementi dall'arraylist esiste un metodo get, che però
//		Movement m1 = movements.get(0); // Così prenderei ciò che sta nell'arraylist, ma non usando i generics lui pensa che conterrà Object, una classe di Java da cui tutte le classi ereditano, tutte le classi sono discendenti da Objet, una sorta di oggetto di base
		// Non mi fa assegnare ciò che è dentro all'arraylist a m1 perché il compiler non è certo che dentro ci sia un Movement
		// Fare ciò sarebbe corretto ma non avendo utilizzato i generics il compiler si oppone
		// Il compiler vorrebbe questo di giù
//		Object m1 = movements.get(0); // facendo così se m1 è visto come Object però non posso utilizzare i metodi di Movement
		// Farò quindi un cast forzato come giù
//		Movement m1 = (Movement)movements.get(0); // Cast forzato a Movement della stringa "Pipopo" memorizzata alla posizione 0 dell'arraylist in modo da poter utilizzare ciò che sta nell'arraylist
		for(int i = 0; i < movements.size(); i++){
			Object ob = movements.get(i);
			Movement m = (Movement)ob;
			if (m.getType() == MovementType.DEPOSIT) {
				sum += m.getAmount(); //Se l'if è rispettato vado a sommare al totale l'amount dell'oggetto Movement
			}
		}
		return sum;
	}

	// Voglio un metodo che mi dia la somma delle cifre relative a movimenti (operazioni) di un tipo che gli passo in input (deposit o withdrawal), i movimenti devono essere compresi in un range di Date cge gli passo in input
	// Alla funzione devo passare un valore double che sarà la soglia sotto la quale non voglio vedere i movimenti
	//double sum = c.getTotalAmountFor(MovementType.WITHDRAWAL, localDate.of(2025,1,15), LocalDateof(2025,2,20), double 200.0)
	public double getTotalAmountFor(MovementType type, LocalDate start, LocalDate end, double lowerBound) {
		double totalAmount = 0;
		for (Object ob : movements) {
			Movement m = (Movement)ob;  // Cast dell'Object a Movement
			LocalDate movementDate = m.getOperationTime().toLocalDate();
			boolean isInRange = movementDate.isAfter(start) && movementDate.isBefore(end);
			if(m.getType() == type && isInRange && m.getAmount() >= lowerBound) {
				totalAmount += m.getAmount();
			}
		}
		return totalAmount;
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

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;                  // In un metodo il this significa il campo creationDate del metodo che sto costruendo
	}


}