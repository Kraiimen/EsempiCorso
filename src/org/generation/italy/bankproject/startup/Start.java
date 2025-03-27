package org.generation.italy.bankproject.startup;

import org.generation.italy.bankproject.accounting.Account;
import org.generation.italy.bankproject.accounting.evasion.CaymanAccount;
import org.generation.italy.bankproject.accounting.Movement;
import org.generation.italy.bankproject.accounting.MovementType;

import java.time.LocalDateTime;

public class Start {
	public static void main(String[] args) {
		Account x = new Account(); // Sto creando un oggetto di tipo Account di nome x
		x.printBalance();
		x.deposit(200);
		x.deposit(100);  // Secondo deposito
		x.printBalance();
		x.withdraw(60);
		x.printBalance();

		// Se e variabili in Account fossero pubbliche potrei fare tranquillamente cose del tipo:
		// System.out.println(x.balance);
		// x.balance = x.balance + 100;
		// Inoltre se cambio il nome di balance in bal nella classe ad esempio dovrei andare a cambiarne il nome
		// ovunque, mentre se fosse privata non avrei questo problema

		x.setBalance(100);

		Movement m1 = new Movement(100, 10000, LocalDateTime.now(), MovementType.DEPOSIT); // Sto creando un movimento tramite un costruttore Movement
		Movement m2 = new Movement(100, 10000, LocalDateTime.now(), MovementType.WITHDRAWAL);
		Movement m3 = new Movement(200, 10000, LocalDateTime.now(), MovementType.DEPOSIT);      //Questi non li sto utilizzando
		Account z = new Account(10000);
//		System.out.println("L'indirizzo di z è " + z);    Per stampare l'indirizzo dell'oggetto e dimostrare che this abbia lo stesso indirizzo quando chiamo la funzione sull'oggetto
		Account w = new Account(20000);
//		System.out.println("L'indirizzo di w è " + w);
//		System.out.println(z.balance);  Posso chiamarle solo con balance public
//		System.out.println(w.balance);
//		System.out.println("Sto per chiamare printBalance su z facendo z.printBalance");
		z.printBalance();
//		System.out.println("Sto per chiamare printBalance su w facendo w.printBalance");
		w.printBalance();
		// Se vuoi copiare una riga giù metti il segno sulla riga e poi cmd + d

		double depositSum = x.getSumDeposits();
		System.out.println("Il totale depositato è: " + depositSum);
		CaymanAccount ca = new CaymanAccount();   // Finchè non costruisco un costruttore in CaymanAccount potrò usare solo quello di default, perché i costruttori non vengono ereditati
		double newBalance = ca.deposit(3000);
		ca.printBalance();
		ca.withdraw(50);
		ca.printBalance();

	}
}
// Quando uso new sto invocando un COSTRUTTORE, una pseudo funzione, che fa un'azione come una funzione.
// Il ruolo del costruttore è quello di creare (stanziare) un oggetto.
// Lo abbiamo usato in passato