package org.generation.italy.bankproject.startup;

import org.generation.italy.bankproject.accounting.Account;
import org.generation.italy.bankproject.accounting.Movement;
import org.generation.italy.bankproject.accounting.MovementType;

import java.time.LocalDateTime;

public class Start {
	public static void main(String[] args) {
		Account x = new Account(); // Sto creando un oggetto di tipo Account di nome x
		x.printBalance();
		x.deposit(100);
		x.printBalance();
		x.withdraw(60);
		x.printBalance();

		// Se e variabili in Account fossero pubbliche potrei fare tranquillamente cose del tipo:
		// System.out.println(x.balance);
		// x.balance = x.balance + 100;
		// Inoltre se cambio il nome di balance in bal nella classe ad esempio dovrei andare a cambiarne il nome
		// ovunque, mentre se fosse privata non avrei questo problema

		Movement m1 = new Movement(100, 10000, LocalDateTime.now(), MovementType.DEPOSIT); // Sto creando un movimento tramite un costruttore Movement
		Movement m2 = new Movement(100, 10000, LocalDateTime.now(), MovementType.WITHDRAWAL);
		// Se vuoi copiare una riga giù metti il segno sulla riga e poi cmd + d

	}
}
// Quando uso new sto invocando un COSTRUTTORE, una pseudo funzione, che fa un'azione come una funzione.
// Il ruolo del costruttore è quello di creare (stanziare) un oggetto.
// Lo abbiamo usato in passato