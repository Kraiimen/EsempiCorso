import java.io.Console;
import java.util.Random;

public class SortingHat {
	public static void main(String[] args) {
		int nbHouses = 4; //numero delle Casate
		String[] houses = {"Gryffindor!", "Slytherin!", "Hufflepuff!", "Ravenclaw!"}; // Nomi casate
		String[] prefects = {"De Simone Federico", "Erario Carmine", "Petruzzelli Marta", "Aresu Filippo"}; // 4 prefetti
		String[] students = {"Scarcina Piero", "Casertano Nicolò", "Ghering Regina", "Mazzitelli Davide", "Salerno Sabrina", "Aquila Vittorio", "Coretti Lorenzo", "Marchioro Camilla", "Giustiniani Emanuele", "Maione Gaspare", "Manganelli Eugenio", "Bognanni Edoardo", "Lorato Stefano Pio", "La Fata Elvis", "Coppolino Marcello", "Palaia Ilario Vasco", "Basili Alessio", "Formica Luca"};
		int[] preferences = {0, 0, 1, 3, 2, 3, 2, 0, 1, 0, 2, 3, 0, 3, 1, 1, 4, 3}; // 0 Gryff, 1 Slyth, 2 Huffle, 3 Raven, 4 nessuna scelta

		String[][] assignments = new String[nbHouses][6]; // Matrice studenti, memorizza gli studenti assegnati a ciascuna casata
		int[] studentsByHouse = {1, 1, 1, 1}; // 1 prefetto per ogni Casata già assegnato, tengo traccia degli studenti assegnati
		boolean[] assigned = new boolean[18]; // Traccia studenti già assegnati

		Random draw = new Random(); // Random per estrazione casuale
		Console console = System.console();  // Per andare avanti con gli eventi da console
		if (console == null) {
			return;
		}

		// INIZIA L'EVENTO

		hatPresentation(console); //Il cappello canta la filastrocca

		console.readLine(); // mando avanti il programma di volta in volta con un input qualsiasi da console

		//I prefetti vengono annunciati
		System.out.println("It's time to announce the 4 prefects of the 4 Houses");
		for (int i = 0; i < nbHouses; i++) {
			console.readLine();
			System.out.println(prefects[i] + ", you'll be the prefect of... " + houses[i]);
			assignments[i][0] = prefects[i];
		}

		// Assegnamo i primi 16 studenti dei restanti 18
		int assignedCount = 0;
		while (assignedCount < 16) {
			int i = draw.nextInt(18);
			if (!assigned[i]) {
				String studentName = students[i];
				int firstAttempt = draw.nextInt(nbHouses); //Primo tentativo casuale
				int finalHouse = (firstAttempt == preferences[i]) ? firstAttempt : draw.nextInt(nbHouses); //Se il primo tentativo non assegna la casa preferita si fa il secondo

				if (studentsByHouse[finalHouse] < 5) {
					assignments[finalHouse][studentsByHouse[finalHouse]] = studentName;
					studentsByHouse[finalHouse]++;
					assigned[i] = true;
					assignedCount++;
					console.readLine();
					System.out.println(studentName + " you'll be in... " + houses[finalHouse]);
				}
			}
		}

		for (int i = 0; i < 18; i++) {
			if (!assigned[i]) {
				String studentName = students[i];
				int firstAttempt = draw.nextInt(nbHouses);
				int finalHouse = (firstAttempt == preferences[i]) ? firstAttempt : draw.nextInt(nbHouses);

				if (studentsByHouse[finalHouse] < 6) {
					assignments[finalHouse][studentsByHouse[finalHouse]] = studentName;
					studentsByHouse[finalHouse]++;
					assigned[i] = true;
					console.readLine();
					System.out.println(studentName + " you'll be in... " + houses[finalHouse]);
				}
			}
		}
	
		System.out.println("Final recap of the draw: ");
		for (int i = 0; i < nbHouses; i++) {
			console.readLine();
			System.out.print(houses[i] + ": " + assignments[i][0] + ", ");
			for (int j = 1; j < studentsByHouse[i]; j++) {
				System.out.print(assignments[i][j] + ", ");
			}
			System.out.println();
		}
	}




	public static void hatPresentation(Console console) {

		// Il Cappello Parlante introduce l'evento con una filastrocca presa dal libro
		System.out.println("Oh, you may not think I'm pretty,\nBut don't judge on what you see,\nI'll eat myself if you can find");
		System.out.println("A smarter hat than me.\nYou can keep your bowlers black,\nYour top hats sleek and tall,");
		System.out.println("For I'm the Hogwarts Sorting Hat\nAnd I can cap them all.\nThere's nothing hidden in your head");
		System.out.println("The Sorting Hat can't see,\nSo try me on and I will tell you\nWhere you ought to be.");
		console.readLine();  //Premo un tasto per andare avanti con l'evento, ogni volta
		System.out.println("You might belong in Gryffindor,\nWhere dwell the brave at heart,\nTheir daring, nerve and chivalry");
		System.out.println("Set Gryffindors apart;\n");
		console.readLine();
		System.out.println("You might belong in Hufflepuff,\nWhere they are just and loyal,");
		System.out.println("Those patient Hufflepuffs are true\nAnd unafraid of toil;\n");
		console.readLine();
		System.out.println("Or yet in wise old Ravenclaw,");
		System.out.println("If you've a ready mind,\nWhere those of wit and learning,\nWill always find their kind;");
		console.readLine();
		System.out.println("Or perhaps in Slytherin\nYou'll make your real friends,\nThose cunning folk use any means");
		System.out.println("To achieve their ends.\n");
		console.readLine();
		System.out.println("So put me on! Don't be afraid!\nAnd don't get in a flap!");
		System.out.println("You're in safe hands (though I have none)\nFor I'm a Thinking Cap!");
	}
}
