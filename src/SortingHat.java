import java.io.Console;
import java.util.Random;

public class SortingHat {

	private static final Console CONSOLE = System.console(); // Per andare avanti con gli eventi da CONSOLE
	private static final Random DRAW = new Random(); // Random per estrazione casuale
	private static final int NB_HOUSES = 4; //numero delle Casate
	private static final int GRYF_POS = 0;
	private static final int SLYT_POS = 1;
	private static final int HUFF_POS = 2;
	private static final int RAVE_POS = 3;
	private static final String[] HOUSES = {"Gryffindor!", "Slytherin!", "Hufflepuff!", "Ravenclaw!"}; // Nomi casate
	private static final String[] PREFECTS = {"De Simone Federico", "Erario Carmine", "Petruzzelli Marta", "Aresu Filippo"}; // 4 prefetti
	private static final String[] STUDENTS = {"Scarcina Piero", "Casertano Nicolò", "Ghering Regina", "Mazzitelli Davide", "Salerno Sabrina", "Aquila Vittorio", "Coretti Lorenzo", "Marchioro Camilla", "Giustiniani Emanuele", "Maione Gaspare", "Manganelli Eugenio", "Bognanni Edoardo", "Lorato Stefano Pio", "La Fata Elvis", "Coppolino Marcello", "Palaia Ilario Vasco", "Basili Alessio", "Formica Luca"};
	private static final int[] PREFERENCES = {GRYF_POS, GRYF_POS, SLYT_POS, RAVE_POS, HUFF_POS, RAVE_POS, HUFF_POS, GRYF_POS, SLYT_POS, GRYF_POS, HUFF_POS, RAVE_POS, GRYF_POS, RAVE_POS, SLYT_POS, SLYT_POS, RAVE_POS, RAVE_POS}; // 0 Gryff, 1 Slyth, 2 Huffle, 3 Raven, 4 nessuna scelta
	private static final String[][] ASSIGNMENTS = new String[NB_HOUSES][6]; // Matrice studenti, memorizza gli studenti assegnati a ciascuna casata
	private static final int[] STUDENTS_BY_HOUSE = {1, 1, 1, 1}; // 1 prefetto per ogni Casata già assegnato, tengo traccia degli studenti assegnati
	private static final boolean[] ASSIGNED = new boolean[18]; // Traccia studenti già assegnati

	public static void main(String[] args) {
		// I tempi di esecuzione saranno gestiti dall'utente, che potrà, tramite input (es. INVIO), mandare avanti l'evento fino alla conslusione
		
		// INIZIA L'EVENTO
		hatPresentation(); //Il cappello canta la filastrocca
		CONSOLE.readLine(); // mando avanti il programma di volta in volta con un input qualsiasi da CONSOLE
		
		//I prefetti vengono annunciati
		assignPrefects();

		// Assegnamo i primi 16 studenti dei restanti 18
		assignStudents();
		
		// Assegnamo i restanti studenti
		assignLastStudents();
		
		// Facciamo un recap finale in tabella
		recapHouses();
	}




	public static void hatPresentation() {

		// Il Cappello Parlante introduce l'evento con una filastrocca presa dal libro
		System.out.println("Oh, you may not think I'm pretty,\nBut don't judge on what you see,\nI'll eat myself if you can find");
		System.out.println("A smarter hat than me.\nYou can keep your bowlers black,\nYour top hats sleek and tall,");
		System.out.println("For I'm the Hogwarts Sorting Hat\nAnd I can cap them all.\nThere's nothing hidden in your head");
		System.out.println("The Sorting Hat can't see,\nSo try me on and I will tell you\nWhere you ought to be.");
		CONSOLE.readLine();  //Premo un tasto per andare avanti con l'evento, ogni volta
		System.out.println("You might belong in Gryffindor,\nWhere dwell the brave at heart,\nTheir daring, nerve and chivalry");
		System.out.println("Set Gryffindors apart;\n");
		CONSOLE.readLine();
		System.out.println("You might belong in Hufflepuff,\nWhere they are just and loyal,");
		System.out.println("Those patient Hufflepuffs are true\nAnd unafraid of toil;\n");
		CONSOLE.readLine();
		System.out.println("Or yet in wise old Ravenclaw,");
		System.out.println("If you've a ready mind,\nWhere those of wit and learning,\nWill always find their kind;");
		CONSOLE.readLine();
		System.out.println("Or perhaps in Slytherin\nYou'll make your real friends,\nThose cunning folk use any means");
		System.out.println("To achieve their ends.\n");
		CONSOLE.readLine();
		System.out.println("So put me on! Don't be afraid!\nAnd don't get in a flap!");
		System.out.println("You're in safe hands (though I have none)\nFor I'm a Thinking Cap!");
	}

	public static void assignPrefects() {
		System.out.println("It's time to announce the 4 PREFECTS of the 4 Houses");
		for (int i = 0; i < NB_HOUSES; i++) {
			CONSOLE.readLine();
			System.out.println(PREFECTS[i] + ", you'll be the prefect of... " + HOUSES[i]);
			ASSIGNMENTS[i][0] = PREFECTS[i];
		}
	}

	public static void assignStudents() {
		int AssignedCount = 0;
		while (AssignedCount < 16) {
			int i = DRAW.nextInt(18);
			if (!ASSIGNED[i]) {
				String studentName = STUDENTS[i];
				int firstAttempt = DRAW.nextInt(NB_HOUSES); //Primo tentativo casuale
				int finalHouse = (firstAttempt == PREFERENCES[i]) ? firstAttempt : DRAW.nextInt(NB_HOUSES); //Se il primo tentativo non assegna la casa preferita si fa il secondo

				if (STUDENTS_BY_HOUSE[finalHouse] < 5) {
					ASSIGNMENTS[finalHouse][STUDENTS_BY_HOUSE[finalHouse]] = studentName;
					STUDENTS_BY_HOUSE[finalHouse]++;
					ASSIGNED[i] = true;
					AssignedCount++;
					CONSOLE.readLine();
					System.out.println(studentName + " you'll be in... " + HOUSES[finalHouse]);
				}
			}
		}
	}

	public static void assignLastStudents() {
		for (int i = 0; i < 18; i++) {
			if (!ASSIGNED[i]) {
				String studentName = STUDENTS[i];
				int firstAttempt = DRAW.nextInt(NB_HOUSES);
				int finalHouse = (firstAttempt == PREFERENCES[i]) ? firstAttempt : DRAW.nextInt(NB_HOUSES);

				if (STUDENTS_BY_HOUSE[finalHouse] < 6) {
					ASSIGNMENTS[finalHouse][STUDENTS_BY_HOUSE[finalHouse]] = studentName;
					STUDENTS_BY_HOUSE[finalHouse]++;
					ASSIGNED[i] = true;
					CONSOLE.readLine();
					System.out.println(studentName + " you'll be in... " + HOUSES[finalHouse]);
				}
			}
		}
	}

	public static void recapHouses() {
		System.out.println("Final recap of the DRAW: ");
		CONSOLE.readLine();
		String outputFormat = "%-22s%-22s%-22s%-22s%n";
		System.out.printf(outputFormat, HOUSES[0], HOUSES[1], HOUSES[2], HOUSES[3]);
		for (int i = 0; i < 6; i++) {
			System.out.printf(outputFormat, ASSIGNMENTS[0][i], ASSIGNMENTS[1][i], ASSIGNMENTS[2][i], ASSIGNMENTS[3][i]);
		}
	}
}
