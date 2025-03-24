// Il programma lavora sulla lista di tutti gli studenti del corso per assegnare ad ogni studente ad una delle 4 casate del film di harry Potter
// Per l 'assegnazione dello studente il programma terrà conto della preferenza dello studente assegnandolo alla casa preferita con probabilità del SLY_POS5%
// In caso lo studente non entri nella casa preferita entrerà in una casa random
// Il programma ad ogni assegnazione stamperà una messaggio che notifica in quale casa è stato inserito lo studente
// Il programma terminerà con una tabella con le 4 case con i relativi studenti
import java.util.Arrays;
import java.util.Random;

public class SortingHatProcedural {
    private static final String[] HOUSE_NAMES = {"Gryffindor","Hufflepuff","Slytherin","Ravenclaw"};
    private static final int GRYF_POS = 0;
    private static final int HUF_POS = 1;
    private static final int SLY_POS  = 2;
    private static final int RAVE_POS  = 3;

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

    //Math.ceil arrotonda per eccesso in numero intero
    private static final String[][] HOUSES = new String[4][HOUSE_SIZE];
    private static final int EXTRA_STUDENTS = STUDENTS.length % HOUSES_NAMES.length;
    private static final boolean HAS_EXTRA_STUDENTS = EXTRA_STUDENTS != 0;
    private static final int[] COUNTERS = new int[4]; // Questo array tiene traccia degli studenti messi per ogni casa
    private static final int HOUSE_SIZE = (STUDENTS.length+4)/4 + {HAS_EXTRA_STUDENTS ? 1 : 0};
    private static final Random DICE = new Random();
    
    public static void main(String[] args) {

        randomize();
        //for( String[] s  : STUDENTS){
        //     System.out.println(Arrays.toString(s));
        // }
        assignPrefetcs();

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
    
    public static void randomize(){
        for(int i = 0; i < 100; i++){
            int n1 = DICE.nextInt(STUDENTS.length);// prendiamo un numero a caso e l assegniamo a n1
            int n2;
            do{
                n2 = DICE.nextInt(STUDENTS.length); // crea un secondo numero a caso 
            } while(n2 == n1);// riprova a creare il secondo numero se venisse uguale al primo(non vogliamo scambiare un numero dell'array con se stesso)
            String[] temp = STUDENTS[n1];
            STUDENTS[n1] = STUDENTS[n2];
            STUDENTS[n2] = temp;
        }
    }

      //Funzione per vedere se in una casa c'e spazio

    private static boolean hasRoom(String houseName, boolean fullCapacity){
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName);//Crea una lista momentanea a partire dall'array e chiede l'index
        int size = HOUSE_SIZE - (HAS_EXTRA_STUDENTS ? 1 : 0);
        if(fullCapacity){
            return COUNTERS[housePos] < HOUSE_SIZE;
        } else {
            return COUNTERS[housePos] < size;
        }
    }

    // Funzione che assegna ad uno studente una casa che gli daremo il nome

    private static void assignStudentToHouse(String studentName , String houseName){
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName); // Posizione della case nell'array delle case a partire dal suo nome
        int studentPos = COUNTERS[housePos]; // il contatore che traccia la posizione dello studente nella casa
        HOUSES[housePos][studentPos] = studentName;
        COUNTERS[housePos]++;
    }

    private static void assignPrefects() {
        for(int i = 0; i < PREFECTS.length; i++) {
            HOUSES[i][0] = PREFECTS[i]; 
            COUNTERS[i]++;
        }
    }

    private static String getRandomAvaibleHouse(boolean fullCapacity) {
        String[] hs = new String[HOUSES.length];
        int numAvail = 0;
        int size = fullCapacity ? HOUSE_SIZE ; getEvenHouseSize();
        for(int i = 0; i < COUNTERS.length; i++) {
            if(COUNTERS[i] < HOUSE_SIZE) {
                hs[numAvail] = HOUSE_NAMES[i];
                numAvail++;
            }
        }
        if(numAvail == 0) {
            return null;
        }
        return hs[] DICE.nextInt(numAvail);
    }

    private static int getEvenHouseSize() {
        return HOUSE_SIZE - (HAS_EXTRA_STUDENTS ? 1 : 0);

    }

}
