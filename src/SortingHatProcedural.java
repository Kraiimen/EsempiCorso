import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingHatProcedural {
    // Array per i nomi delle case
    private static final String[] HOUSE_NAMES = {"Gryffindor","Hufflepuff","Slytherin","Ravenclaw"};
    // Array per i prefetti (in ordine di corrispondenza delle loro case)
    private static final String[] PREFECTS = {"Federico De Simone","Marta Petruzzelli","Carmine Erario","Filippo Aresu"};

    // Costanti per la posizione delle case nell'array
    private static final int GRYF_POS = 0;
    private static final int HUF_POS = 1;
    private static final int SLY_POS  = 2;
    private static final int RAVE_POS  = 3;

    // Array per il nome degli studenti e la loro preferenza di casa
    private static final String STUDENTS[][] = {
            {"Ilario Vasco Palaia",         HOUSE_NAMES[SLY_POS]},
            {"Elvis La fata",               HOUSE_NAMES[RAVE_POS]},
            {"Regina Ghering",              HOUSE_NAMES[SLY_POS]},
            {"Luca Formica",                HOUSE_NAMES[RAVE_POS]},
            {"Davide Mazzitelli",           HOUSE_NAMES[RAVE_POS]},
            {"Piero Scarcina",              HOUSE_NAMES[GRYF_POS]},
            {"Vittorio Aquila",             HOUSE_NAMES[RAVE_POS]},
            {"Emanuele Giustiniani",        HOUSE_NAMES[SLY_POS]},
            {"Gaspare Maione",              HOUSE_NAMES[GRYF_POS]},
            {"Camilla Marchioro",           HOUSE_NAMES[GRYF_POS]},
            {"Eugenio Manganelli",          HOUSE_NAMES[HUF_POS]},
            {"Edoardo Bognanni",            HOUSE_NAMES[RAVE_POS]},
            {"Lorenzo Coretti",             HOUSE_NAMES[HUF_POS]},
            {"Sabrina Salerno",             HOUSE_NAMES[HUF_POS]},
            {"Marcello Coppolino",          HOUSE_NAMES[SLY_POS]},
            {"Stefano Pio Lorato",          HOUSE_NAMES[GRYF_POS]},
            {"Nicolo Casertano",            HOUSE_NAMES[GRYF_POS]},
            {"Alessio Basili",              HOUSE_NAMES[RAVE_POS]}
    };

    // Il numero di studenti che creerebbe 4 case della stessa dimensione
    private static final int PERFECT_CLASS_SIZE = STUDENTS.length / 4 * 4;

    // Costanti per gli extra students, se il resto è != 0 allora ci sono degli studenti extra
    private static final int EXTRA_STUDENTS = STUDENTS.length % HOUSE_NAMES.length;
    private static final boolean HAS_EXTRA_STUDENTS = EXTRA_STUDENTS != 0;

    // Costante per la dimensione massima della casa (numero di persone)
    private static final int HOUSE_SIZE = (STUDENTS.length + 4)/4 + (HAS_EXTRA_STUDENTS ? 1 : 0);

    // Array delle quattro case
    private static final String[][] HOUSES = new String[4][HOUSE_SIZE];

    // Array dei contatori del numero degli studenti nelle case
    private static final int[] COUNTERS = new int[4];

    // Oggetto DICE della classe Random
    private static final Random DICE = new Random();

    // 
    private static final Scanner scanner = new Scanner(System.in);

    // Array di frasi per la suspanse 
    private static final String suspense[] = {"Ah, che mente affascinante! So esattamente dove collocarti...",
                         "Vedo dentro di te grandi qualità... la tua strada è chiara per me!",
                         "Ambizione, coraggio, saggezza o lealtà? Io so cosa ti definisce meglio!",
                         "Oh, che scelta interessante... ma ora so esattamente dove tu appartieni!",
                         "Non c'è alcun dubbio, il tuo destino è segnato... benvenuto nella tua nuova casa!"};

    /* ----- MAIN ----- */
    public static void main(String[] args){
        // Randomizziamo l'array di studenti
        randomize();

        // Assegniamo i prefetti alle rispettive case
        assignPrefects();

        // Assegniamo gli studenti alle case
        for(int i = 0; i < PERFECT_CLASS_SIZE; i++){ 

            String studentName = STUDENTS[i][0];
            String favouriteHouse = STUDENTS[i][1];

            assignToDestination(studentName, favouriteHouse, false);
        }
        
        // Assegniamo gli studenti extra
        for(int i = PERFECT_CLASS_SIZE; i < PERFECT_CLASS_SIZE + EXTRA_STUDENTS; i++){
            assignToDestination(STUDENTS[i][0], STUDENTS[i][1], true);
        }

        printFinalHouses();
        scanner.close();
    }

    /* ----- FINE MAIN ----- */

    // Metodo principale per assegnare gli studenti alle case (main)
    private static void assignToDestination(String studentName, String favouriteHouse, boolean fullCapacity){
        int luck = DICE.nextInt(4); 
        boolean houseHasSpace = hasRoom(favouriteHouse, fullCapacity);

        if(luck == 0 && houseHasSpace){
            assignStudentToHouse(studentName, favouriteHouse);

            // System.out.println("\n"+studentName + "...");
            // delay(1500);

            // System.out.println(suspense[DICE.nextInt(5)]);
            // delay(2000);

            // System.out.println(favouriteHouse.toUpperCase() + " come da sua preferenza.");
            // scanner.nextLine();
        } else {
            String destination = getRandomAvailableHouse(fullCapacity);
            if(destination == null) {
                System.out.println("ERRORE LOGICO: tutte le case risultano occupate al massimo. Terminiamo il programma");
                return; 
            }
            assignStudentToHouse(studentName, destination);
        }
    }

    // Metodo per la randomizzazione dell'array degli studenti
    private static void randomize(){
        for(int i = 0; i < 100; i++){

            // Generiamo due numeri casuali non uguali
            int n1 = DICE.nextInt(STUDENTS.length);
            int n2;

            do{
                n2 = DICE.nextInt(STUDENTS.length); 
            } while(n2 == n1);

            // Scambiamo le variabili
            String[] temp = STUDENTS[n1];
            STUDENTS[n1] = STUDENTS[n2];
            STUDENTS[n2] = temp;
        }
    }

    // Metodo per controllare se dobbiamo lavorare con il limite di capacità o no
    private static boolean hasRoom(String houseName, boolean fullCapacity){
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName);
        int size = getEvenHouseSize();

        // Se fullCapcity è true allora lavoriamo con la dimensione massima dell'array
        if(fullCapacity){
            return COUNTERS[housePos] < HOUSE_SIZE;
        } 
        // Altrimenti lo limitiamo
        else {
            return COUNTERS[housePos] < size;
        }
    }

    // Metodo per assegnare lo studente ad una casa
    private static void assignStudentToHouse(String studentName , String houseName){
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName); 
        int studentPos = COUNTERS[housePos];

        // Copiamo il nome nella casa e aumentiamo il contatore di quella casa
        HOUSES[housePos][studentPos] = studentName;
        COUNTERS[housePos]++;
    }

    // Metodo per assegnare i prefetti alle loro case
    private static void assignPrefects(){
        for (int i = 0; i < PREFECTS.length; i++) {
            HOUSES[i][0] = PREFECTS[i];
            COUNTERS[i]++;
        }
    }
    
    // Metodo per pescare una casa libera per assegnare randomicamente gli studenti alle case
    private static String getRandomAvailableHouse(boolean fullCapacity){
        String hs[] = new String[HOUSES.length];
        int numAvail = 0; // Quante case sono disponibili
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

    // Metodo per calcolare la dimensione massima delle case se ci sono studenti extra
    private static int getEvenHouseSize() {
        return HOUSE_SIZE - (HAS_EXTRA_STUDENTS ? 1 : 0);
    }

    // Metodo per aggiungere suspance tra il nome e la casa scelta
    private static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Ripristina lo stato di interruzione
            System.err.println("Errore nel delay: " + e.getMessage());
        }
    }

    // Metodo per la stampa della tabella finale delle case
    private static void printFinalHouses(){
        String outputFormat = "| %-20s | %-20s | %-20s | %-20s |\n";

        System.out.println();
        System.out.printf(outputFormat, "GRYFFINDOR", "HUFFLEPUFF", "SLYTHERIN", "RAVENCLAW");

        for (int j = 0; j < HOUSE_SIZE; j++) {
            System.out.printf(outputFormat, 
                    formatNullString(HOUSES[0][j]), 
                    formatNullString(HOUSES[1][j]), 
                    formatNullString(HOUSES[2][j]), 
                    formatNullString(HOUSES[3][j]));
        }
    }

    // Metodo per sostituire null con una stringa vuota
    private static String formatNullString(String str){
        return (str == null) ? "" : str; 
    }
}
