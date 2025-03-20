// Il programma lavora sulla lista di tutti gli studenti del corso per assegnare ad ogni studente ad una delle 4 casate del film di harry Potter
// Per l 'assegnazione dello studente il programma terrà conto della preferenza dello studente assegnandolo alla casa preferita con probabilità del SLY_POS5%
// In caso lo studente non entri nella casa preferita entrerà in una casa random
// Il programma ad ogni assegnazione stamperà una messaggio che notifica in quale casa è stato inserito lo studente
// Il programma terminerà con una tabella con le 4 case con i relativi studenti
import java.util.Arrays;
import java.util.Random;

public class SortingHatProcedural {
    // Array per i nomi delle case
    private static final String[] HOUSE_NAMES = {"Gryffindor","Hufflepuff","Slytherin","Ravenclaw"};

    // Costanti per la posizione delle case nell'array
    private static final int GRYF_POS = 0;
    private static final int HUF_POS = 1;
    private static final int SLY_POS  = 2;
    private static final int RAVE_POS  = 3;

    // Array per il nome degli studenti e la loro preferenza di casa
    private static final String STUDENTS[][] = {
            {"Ilario Vasco Palaia",HOUSE_NAMES[SLY_POS]},
            {"Elvis La fata",HOUSE_NAMES[RAVE_POS]},
            {"Regina Ghering",HOUSE_NAMES[SLY_POS]},
            {"Luca Formica",HOUSE_NAMES[RAVE_POS]},
            {"Davide Mazzitelli",HOUSE_NAMES[RAVE_POS]},
            {"Piero Scarcina",HOUSE_NAMES[GRYF_POS]},
            {"Vittorio Aquila",HOUSE_NAMES[RAVE_POS]},
            {"Emanuele Giustiniani",HOUSE_NAMES[SLY_POS]},
            {"Gaspare Maione",HOUSE_NAMES[GRYF_POS]},
            {"Camilla Marchioro",HOUSE_NAMES[GRYF_POS]},
            {"Eugenio Manganelli",HOUSE_NAMES[HUF_POS]},
            {"Edoardo Bognanni",HOUSE_NAMES[RAVE_POS]},
            {"Lorenzo Coretti",HOUSE_NAMES[HUF_POS]},
            {"Sabrina Salerno",HOUSE_NAMES[HUF_POS]},
            {"Marcello Coppolino",HOUSE_NAMES[SLY_POS]},
            {"Stefano Pio Lorato", HOUSE_NAMES[GRYF_POS]},
            {"Nicolo Casertano",HOUSE_NAMES[GRYF_POS]},
            {"Alessio Basili",HOUSE_NAMES[RAVE_POS]}
    };

    // Costante per la dimensione massima della casa (numero di persone)
    private static final int HOUSE_SIZE = (int) Math.ceil((STUDENTS.length+4) /4 );

    // Array delle quattro case
    private static final String[][] HOUSES = new String[4][HOUSE_SIZE];

    // Array dei contatori del numero degli studenti nelle case
    private static final int[] COUNTERS = new int[4];

    // Oggetto DICE della classe Random
    private static final Random DICE = new Random();

    /* ----- MAIN ----- */
    public static void main(String[] args) {

        randomize();
        //for( String[] s  : STUDENTS){
        //     System.out.println(Arrays.toString(s));
        // }

        for(int i = 0; i < (STUDENTS.length+4)/4*4; i++){
            int luck = DICE.nextInt(4);  

            String studentName = STUDENTS[i][0];
            String favouriteHouse = STUDENTS[i][1];

            boolean houseHasSpace = hasRoom(favouriteHouse, false);

            if(luck == 0 && houseHasSpace){
                assignStudentToHouse(studentName ,favouriteHouse);
                System.out.println(studentName + " ... " + favouriteHouse + " come da sua preferenza"); 
            }
        }
    
        //TODO il resto del programma
    }

    /* ----- FINE MAIN ----- */

    // Metodo per la randomizzazione dell'array degli studenti
    public static void randomize(){
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

        // Se fullCapcity è true allora lavoriamo con la dimensione massima dell'array
        if(fullCapacity){
            return COUNTERS[housePos] < HOUSE_SIZE;
        } 
        // Altrimenti lo limitiamo
        else {
            return COUNTERS[housePos] < HOUSE_SIZE - 1;
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

}
