// Il programma lavora sulla lista di tutti gli studenti del corso per assegnare ad ogni studente ad una delle 4 casate del film di harry Potter
// Per l 'assegnazione dello studente il programma terrà conto della preferenza dello studente assegnandolo alla casa preferita con probabilità del SLY_POS5%
// In caso lo studente non entri nella casa preferita entrerà in una casa random
// Il programma ad ogni assegnazione stamperà una messaggio che notifica in quale casa è stato inserito lo studente
// Il programma terminerà con una tabella con le 4 case con i relativi studenti
import java.util.Arrays;
import java.util.Random;

public class SortingHatProcedural {

    private static final String[] HOUSE_NAMES = {"Gryffindor","Hufflepuff","Slytherin","Ravenclaw"};

    //numero correlato alla posizione delle case
    private static final int GRYF_POS = 0;
    private static final int HUF_POS = 1;
    private static final int SLY_POS  = 2;
    private static final int RAVE_POS  = 3;

    private static final String[] PREFECTS = {"Federico De Simone","Marta Petruzzelli","Carmine Erario","Filippo Aresu"};

    //creazione dell'array STUDENTS
    private static final String STUDENTS[][] = {  

            {"Ilario Vasco Palaia",HOUSE_NAMES[SLY_POS]},
            {"Elvis La fata",HOUSE_NAMES[RAVE_POS]},
            {"Regina Ghering",HOUSE_NAMES[SLY_POS]},
            {"Luca Formica",HOUSE_NAMES[RAVE_POS]},
            {"Davide Mazzitelli",HOUSE_NAMES[RAVE_POS]},
            {"Piero Scarcina",HOUSE_NAMES[GRYF_POS]},git 
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
    //numero di studenti che creerebbe 4 case della stessa dimensione (nel nostro caso 20)
    private static final int PERFECT_CLASS_SIZE = STUDENTS.length/4 *4;  

    private static final int EXTRA_STUDENTS = STUDENTS.length % HOUSE_NAMES.length;

    //mi dice se ho degli extra oppure no  
    private static final boolean HAS_EXTRA_STUDENTS = EXTRA_STUDENTS != 0;  

    // Questo array tiene traccia del numero di studenti messi in ogni casa
    private static final int[] COUNTERS = new int[4]; 

    //la dimensione della casa sarà quella perfetta ma ci aggiungo 1 nel caso ci sia un extra student
    private static final int HOUSE_SIZE = (STUDENTS.length + 4)/4 + (HAS_EXTRA_STUDENTS ? 1 : 0); 
    
    //nuovo array di array per le houses
    private static final String[][] HOUSES = new String[4][HOUSE_SIZE];

    //creiamo un oggetto DICE di tipo Random
    private static final Random DICE = new Random(); 

    public static void main(String[] args) {

        randomize();
        //for( String[] s  : STUDENTS){
        //     System.out.println(Arrays.toString(s));
        // }
        assignPrefects();

        //dopo aver fatto la funzione randomize assegno gli studenti fino ad avere tutte un numero uguale
        for(int i = 0; i < PERFECT_CLASS_SIZE; i++) {  
            //lanciamo il dado per gli studenti fortunati e altri                     
            String studentName = STUDENTS[i][0];
            String favouriteHouse = STUDENTS[i][1];
            //tiene conto che la dimensione può essere ridotta
            assignToDestination(studentName, favouriteHouse, false); 
        }
        for(int i = PERFECT_CLASS_SIZE; i < PERFECT_CLASS_SIZE + EXTRA_STUDENTS; i++) {
            assignToDestination(STUDENTS[i][0], STUDENTS[i][1], true);
        }
        for(int c : COUNTERS) {
            System.out.println(c); 
        } 
        printFinalHouses(); 
    }

    private static void assignToDestination(String studentName, String favouriteHouse, boolean fullcapacity) {
        boolean houseHasSpace = hasRoom(favouriteHouse, fullcapacity);
        int luck = DICE.nextInt(4);
        if(luck == 0 && houseHasSpace) { 
            //assegniamo gli studenti alle case
            assignStudentToHouse(studentName ,favouriteHouse);
            System.out.println(studentName + " ... " + favouriteHouse + " come da sua preferenza"); 
        } else {
            String destination = getRandomAvailableHouse(fullcapacity);  
            if(destination == null) {
                System.out.println("ERRORE LOGICO: tutte le case risultano occupate al massimo. Terminiamo il programma");
                return; 
            }
            assignStudentToHouse(studentName, destination); 
        }

    }

    public static void randomize(){ //come secondo blocco vado a creare una funzione randomize
        for(int i = 0; i < 100; i++){ //i < 100 perchè facciamo il ciclo 100 volte
            int n1 = DICE.nextInt(STUDENTS.length);// prendiamo un numero randomico nel range di STUDENTS.length e lo assegniamo a n1
            int n2; 
            do{         //il "do while" la prima volta la prima volta va senza condizione
                n2 = DICE.nextInt(STUDENTS.length); //crea un secondo numero randomico 
            } while(n2 == n1); //riprova a creare il secondo numero se venisse uguale al primo(non vogliamo scambiare un numero dell'array con se stesso)
            String[] temp = STUDENTS[n1]; //dichiariamo un array di stringhe "temp". n1 e n2 sono le posizioni degli studenti all'interno dell'array STUDENTS
            STUDENTS[n1] = STUDENTS[n2];
            STUDENTS[n2] = temp; 
        }
    }

      //Funzione per vedere se in una casa c'e spazio

    private static boolean hasRoom(String houseName, boolean fullCapacity){ 
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName);//Crea una lista momentanea a partire dall'array e chiede l'index
        int size = getEvenHouseSize();  

        if(fullCapacity){
            return COUNTERS[housePos] < HOUSE_SIZE; //se siamo in fullCapacity vado avanti e mi ritorna se il numero di studenti è minore dello spazio nella casa
        } else {
            return COUNTERS[housePos] < size; //la dimensione della casa risulta inferiore di 1 nel caso in cui il numero di studenti non si divida con il numero delle case 
        }
    }

    // Funzione che assegna ad uno studente una casa che gli daremo il nome

    private static void assignStudentToHouse(String studentName , String houseName){
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName); // Posizione della case nell'array delle case a partire dal suo nome
        int studentPos = COUNTERS[housePos]; // il contatore che traccia la posizione dello studente nella casa
        HOUSES[housePos][studentPos] = studentName;
        COUNTERS[housePos]++;
    }

    private static void assignPrefects() { //prima di assegnare gli studenti alle case assegneremo i 4 prefetti, uno per ogni casa
        for(int i = 0; i < PREFECTS.length; i++) {
            HOUSES[i][0] = PREFECTS[i]; 
            COUNTERS[i]++; 
        }
    }

    private static String getRandomAvailableHouse(boolean fullCapacity) {
        String[] hs = new String[HOUSES.length];         
        //conta quante case sto trovando disponibili
        int numAvail = 0; 
        int size = fullCapacity ? HOUSE_SIZE : getEvenHouseSize();
        for(int i = 0; i < COUNTERS.length; i++) {
            if(COUNTERS[i] < size) { 
                hs[numAvail] = HOUSE_NAMES[i]; 
                numAvail++; 
            }
        }
        if(numAvail == 0) {
            return null; 
        }
        return hs[DICE.nextInt(numAvail)];
    }

    private static int getEvenHouseSize() {
        //prendo la dimensione massima. Ci sono studenti extra? Sì, sottraggo 1, altrimenti 0
        return HOUSE_SIZE - (HAS_EXTRA_STUDENTS ? 1 : 0); 
    }

    private static void printFinalHouses() {
        //il simbolo % legge il formato e poi vanno le variabili in ordine di come le vogliamo
        String outputFormat = "%-25s%-25s%-25s%-25s%n";  
        System.out.printf(outputFormat, HOUSE_NAMES[0], HOUSE_NAMES[1], HOUSE_NAMES[2], HOUSE_NAMES[3]); 
        for(int i = 0; i < HOUSE_SIZE; i++) {
            System.out.printf(outputFormat, HOUSES[0][i], HOUSES[1][i],  HOUSES[2][i],  HOUSES[3][i]); 
        }
    }
}
