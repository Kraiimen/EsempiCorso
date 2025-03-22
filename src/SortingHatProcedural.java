import java.util.Arrays;
import java.util.Random;

// Il programma lavora sulla lista di tutti gli studenti del corso,
// Per assegnare ogni studente ad una delle 4 casate di harry potter.
// Per l'assegnazione dello studente terrà conto della preferenza dello studente per una probabilità extra del 25%
// Nel caso in cui lo studente non entri nella casa preferita verrà assegnato a una casa random tra le 4
// Il programma ad ogni assegnazione stamperà una riga per notificare l'assegnazione
// Il programma terminerà stampando una tabella con le 4 case e i relativi studenti

public class SortingHatProcedural {
	private static final String[] HOUSE_NAMES = {"Gryffindor", "Hufflepuff", "Slytherin", "Ravenclaw"};
	private static final int GRYF_POSE = 0;
	private static final int HUFF_POSE = 1;
	private static final int SLYT_POSE = 2;
	private static final int RAVE_POSE = 3;

	private static final String[] PREFECTS = {"Federico De Simone", "Marta Petruzzelli", "Carmine Erario", "Filippo Aresu"};
	private static final String STUDENTS[][] = {  // private così che sia visibile solo in questa classe, ma static per essere visibile in tutto il file
            {"Ilario Vasco Palaia", HOUSE_NAMES[SLYT_POSE]},
            {"Elvis La fata", HOUSE_NAMES[RAVE_POSE]},
            {"Regina Ghering", HOUSE_NAMES[SLYT_POSE]},
            {"Luca Formica", HOUSE_NAMES[RAVE_POSE]},
            {"Davide Mazzitelli", HOUSE_NAMES[RAVE_POSE]},
            {"Piero Scarcina", HOUSE_NAMES[GRYF_POSE]},
            {"Vittorio Aquila", HOUSE_NAMES[RAVE_POSE]},
            {"Emanuele Giustiniani", HOUSE_NAMES[SLYT_POSE]},
            {"Gaspare Maione", HOUSE_NAMES[GRYF_POSE]},
            {"Camilla Marchioro", HOUSE_NAMES[GRYF_POSE]},
            {"Eugenio Manganelli", HOUSE_NAMES[HUFF_POSE]},
            {"Edoardo Bognanni", HOUSE_NAMES[RAVE_POSE]},
            {"Lorenzo Coretti", HOUSE_NAMES[HUFF_POSE]},
            {"Sabrina Salerno", HOUSE_NAMES[HUFF_POSE]},
            {"Marcello Coppolino", HOUSE_NAMES[SLYT_POSE]},
            {"Stefano Pio Lorato", HOUSE_NAMES[GRYF_POSE]},
            {"Nicolo Casertano", HOUSE_NAMES[GRYF_POSE]},
            {"Alessio Basili", HOUSE_NAMES[RAVE_POSE]}
    };

	// Numero di studenti che creerebbe 4 case di identica dimensione
	private static final int PERFECT_CLASS_SIZE = STUDENTS.length / 4 * 4;
	private static final int EXTRA_STUDENTS = STUDENTS.length % HOUSE_NAMES.length;
	private static final boolean HAS_EXTRA_STUDENTS = (EXTRA_STUDENTS != 0);  // Questa booleana mi dice se ho studenti extra o meno
	private static final int[] COUNTERS = new int[4]; // Questo array tiene traccia degli studenti messi per ogni casa, quindi ad esempio [0] corrisponderà Grifondoro
	private static final int HOUSE_SIZE = (STUDENTS.length + 4) / 4 + (HAS_EXTRA_STUDENTS ? 1 : 0);
	private static final String[][] HOUSES = new String[4][HOUSE_SIZE];
	private static final Random DICE = new Random(); // creo un oggetto DICE di tipo Random

	public static void main(String[] args) {
		randomize();
		//for (String[] s : STUDENTS) { // Controllo se ha randomizzato
		//	System.out.println(Arrays.toString(s)); // Arrays è una classe con funzioni utili per lavorare sugli array
		// }

		assignPrefects(); // Assegno i 4 prefetti

		for (int i = 0; i < PERFECT_CLASS_SIZE; i++) {    //Essendo un int dividendo per 4 e moltiplicando per 4 e tolgo lo scarto (Es. 22/4 = 5)

			String studentName = STUDENTS[i][0];
			String favoriteHouse = STUDENTS[i][1]; // Vedo quale sia la casa preferita dello studente in questione
			
			assignToDestination(studentName, favoriteHouse, false);
		}
		for (int i = PERFECT_CLASS_SIZE; i < PERFECT_CLASS_SIZE + EXTRA_STUDENTS; i++) {
			assignToDestination(STUDENTS[i][0], STUDENTS[i][1], true);
		}
		for (int c : COUNTERS) {
			System.out.println(c);
		}
		printFinalHouses();
	}

	private static void assignToDestination(String studentName, String favoriteHouse, boolean fullCapacity) {
		boolean houseHasSpace = hasRoom(favoriteHouse, fullCapacity); //false perché inizialmente non vogliamo lavorare in full capacity
		int luck = DICE.nextInt(4);
		if (luck == 0 && houseHasSpace) {
			assignStudentToHouse(studentName, favoriteHouse);
			System.out.println(studentName + " ..... " + favoriteHouse + " come da sua preferenza");
		} else {
			String destination = getRandomAvailableHouse(fullCapacity);
			if (destination == null) {
				System.out.println("Errore logico, tutte le case risultano occupate al massimo, terminiamo il programma");
				return; // Quando ritorna (return) la main il programma termina
			}
			assignStudentToHouse(studentName, destination);
		}
	}

	public static void randomize() {
		// Faccio uno shuffle che per 100 volte prende 2 studenti a caso nell'array e li scambia
		for (int i = 0; i < 100; i++) {
			int n1 = DICE.nextInt(STUDENTS.length);
			int n2;
			do { 
				n2 = DICE.nextInt(STUDENTS.length);
			} while (n2 == n1);  // Continua ad estrarre n2 finché non sarà diverso da n1, evitando di scambiare uno studente con sé stesso
			
			String[] temp = STUDENTS[n1];
			STUDENTS[n1] = STUDENTS[n2];
			STUDENTS[n2] = temp; //Così ho scambiato posizione di nome e preferenza di 2 studenti
		}
	}

	private static boolean hasRoom(String houseName, boolean fullCapacity) {
		int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName); // Crea momentaneamente una lista a partire da quell'array e chiede alla lista in che posizione contiene la parola houseName
		int size = getEvenHouseSize();  //se HAS_EXTRA_STUDENTS è vero mi darà 1 (- 1) se no mi darà 0 (- 0)
		if (fullCapacity) {
			return COUNTERS[housePos] < HOUSE_SIZE; // Se siamo in fullCapacity vado avanti e mi ritorna true
		} else {
			return COUNTERS[housePos] < size;  //Quando non siamo in fullCapacity mi ritorna false e così riempio prima tutte le case fino a 5 studenti
		}
	}

	//Funzione che assega ad uno studente una casa a cui daremo un nome
	private static void assignStudentToHouse(String studentName, String houseName) {
		int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName);  // Posizione della casa nell'array delle case a partire dal suo nome
		int studentPos = COUNTERS[housePos];  // Il contatore che traccia la posizione dello studente nella casa
		HOUSES[housePos][studentPos] = studentName; 
		COUNTERS[housePos]++;
	}

	private static void assignPrefects() { // Vado ad assegnare i 4 prefetti alle 4 case prescelte
		for (int i = 0; i < PREFECTS.length; i++) {
			HOUSES[i][0] = PREFECTS[i];
			COUNTERS[i]++;
		}
	}

	private static String getRandomAvailableHouse(boolean fullCapacity) {
		String[] hs = new String[HOUSES.length];
		int numAvail = 0;
		int size = fullCapacity ? HOUSE_SIZE : getEvenHouseSize();

		for (int i = 0; i < COUNTERS.length; i++) {
			if (COUNTERS[i] < size) {
				hs[numAvail] = HOUSE_NAMES[i];
				numAvail++;
			}
		}
		if (numAvail == 0) {
			return null;
		}
		return hs[DICE.nextInt(numAvail)];
	}

	// Prendo la dimensione massima. Ci sono studenti extra? Sì, sottraggo 1, altrimenti 0
	private static int getEvenHouseSize () {
		return HOUSE_SIZE - (HAS_EXTRA_STUDENTS ? 1 : 0);
	}

	private static void printFinalHouses () {
		String outputFormat = "%-25s%-25s%-25s%-25s%n";
		System.out.printf(outputFormat, HOUSE_NAMES[0], HOUSE_NAMES[1], HOUSE_NAMES[2], HOUSE_NAMES[3]);
		for (int i = 0; i < HOUSE_SIZE; i++) {
			System.out.printf(outputFormat, HOUSES[0][i], HOUSES[1][i], HOUSES[2][i], HOUSES[3][i]);
		}
	}

}