// il programma lavora sulla lista di tutti gli studenti del corso per assegnare a ogni studente ad una delle 4 casate film di Harry Potter
// per l'assegnazione dello studente il programma terrà conto della prefernza dello studente assegnandolo alla casata con una probabilità del 25%
// in caso lo studente non entri nella casa preferita entrerà in una casa random
// il programma ad ogni assegnazione stamperà un messaggio che notifica in quale casa è stato inserito lo studente 
// il programma terminerà stampando una tabella con le 4 case con i relativi studenti
import java.util.Random;

public class SortingHatProcedural{
    public static final String[] HOUSE_NAMES = {"Gryffindor" , "Hufflepuff" , "Slytherin" , "Ravenclaw"}; // array per il nome delle casate
    private static final int GRY_POS = 0; // referenziato uno dei nomi delle house names per tenergli traccia più facilmente anzi che 0 1 2 3
    private static final int HUF_POS = 1;
    private static final int SLY_POS = 2;
    private static final int RAVE_POS = 3;
    
    private static final String[] PREFECTS ={"Federico De Simone" , "Marta Petruzzelli" , "Carmine Erario" , "filippo Aresu"}; 
    // creazione array dei prefetti
    private static final String STUDENTS[][] = { // le costanti si scrivono tutte in maiusc, è un array di array
            {"Ilario Vasco Palaia", HOUSE_NAMES[SLY_POS]}, // è un array di array di stringhe
            {"Elvis La fata", HOUSE_NAMES[RAVE_POS]},
            {"Regina Ghering",HOUSE_NAMES[SLY_POS]},
            {"Luca Formica", HOUSE_NAMES[RAVE_POS]},
            {"Davide Mazzitelli", HOUSE_NAMES[RAVE_POS]},
            {"Piero Scarcina", HOUSE_NAMES[GRY_POS]},
            {"Vittorio Aquila", HOUSE_NAMES[RAVE_POS]},
            {"Emanuele Giustiniani", HOUSE_NAMES[2]},
            {"Gaspare Maione", HOUSE_NAMES[GRY_POS]},
            {"Camilla Marchioro", HOUSE_NAMES[GRY_POS]},
            {"Eugenio Manganelli",HOUSE_NAMES[HUF_POS]},
            {"Edoardo Bognanni",HOUSE_NAMES[RAVE_POS]},
            {"Lorenzo Coretti", HOUSE_NAMES[HUF_POS]},
            {"Sabrina Salerno",HOUSE_NAMES[HUF_POS]},
            {"Marcello Coppolino", HOUSE_NAMES[SLY_POS]},
            {"Stefano Pio Lorato", HOUSE_NAMES[GRY_POS]},
            {"Nicolò Casertano", HOUSE_NAMES[GRY_POS]},
            {"Alessio Basili", HOUSE_NAMES[RAVE_POS]}
        };
    private static final int PERFECT_CLASS_SIZE = STUDENTS.length/4*4; // numero di studenti che crea 4 case della stessa identica dimensione
    private static final int EXTRA_STUDENTS = STUDENTS.length % HOUSES.length;
    private static final boolean HAS_EXTRA_STUDENTS = EXTRA_STUDENTS !=0; // una booleana che dice se ci sono studenti extra o no
    private static final int[] COUNTERS = new int[4]; // tiene traccia di quanti studenti vengono messi per ogni casa
    private static final int HOUSE_SIZE = ((STUDENTS.length+4)/4) + {HAS_EXTRA_STUDENTS ? 1 : 0}; 
    private static final String[][] HOUSES = new String[4][HOUSE_SIZE]; // array delle casate, 4 sono quanti elementi sono e hanno come dimensione HOUSE SIZE 
    
    private static final Random DICE = new Random(); // costante statica creando un oggetto dice di tipo random 
    
    public static void main(String[] args){
        randomize();
        // for(String[] s : STUDENTS){
        //     System.out.println(Arrays.toString(s)); // mi da una rappresentazione carina di un array
        // }
        assignPrefects();
        for(int i = 0; i < PERFECT_CLASS_SIZE; i++){ // un ciclo lista studenti +4(prefetti) divisi per 4 casate x 4 
            String studentName = STUDENTS[i][0]; // questa indica la sua preferenza di casa
            String favouriteHouse = STUDENTS[i][1];
            assignToDestination(studentName , favouriteHouse , false);
        }
        for(int i = PERFECT_CLASS_SIZE; i < PERFECT_CLASS_SIZE + EXTRA_STUDENTS ; i++){
            assignToDestination(STUDENTS[i][0] , STUDENTS[i][1] , true);
        }
        for(int c : COUNTERS){
            System.out.println(c);
        }
        // TO DO il resto del programma 
    }
    private static void assignToDestination(String studentName , String favouriteHouse , boolean fullCapacity){
        boolean houseHasSpace = hasRoom(favouriteHouse , fullCapacity);
        int luck = dice.nextInt(4); // rolla un dado se esce 4 esce la preferenza dello studente
        if(luck == 0 && houseHasSpace){
            assignStudentToHouse(studentName , favouriteHouse);
            System.out.println(studentName + " ... " + favouriteHouse + " Come da sua preferenza");
        } else{
            String destination = getRandomAvailableHouse(fullCapacity);
            if(destination == null){
                System.out.println("ERRORE LOGICO: tutte le case risultano occupate al massimo. termino il programma");
                return;
            }
            assignStudentToHouse(studentName , destination);
        }
    } 

    public static void randomize(){ //comando per mischiare l'ordine della lista degli studenti per renderlo più fair
        for(int i = 0; i < 100; i++){ //ciclo for per 100 volte
            int n1 = DICE.nextInt(STUDENTS.length); // assegno uno stundente randomico a n1
            int n2; // creo una variabile int nome n2
            do{ // creo un ciclo
                n2 = DICE.nextInt(STUDENTS.length); // ascegna uno studente randomico a n2
            } while(n2 == n1); // ma se n2 è uguale a n1, ricrea n2 e lo rifà finchè ne trova uno diverso da n1
            String[] temp = STUDENTS[n1]; // n1 equivale alla posizione dello studente nella stringa students e viene messo in un array di stringhe temp
            STUDENTS[n1] = STUDENTS[n2]; // n2 ora si sposta nella posizione di n1 ( cambia valore)
            STUDENTS[n2] = temp; // n1 che era nel temp ora si sposta nel n2 (n1 ora ha il valore di n2)
        }
    } 
    //funione per vedere se c'è spazio 
    private static boolean hasRoom(String houseName , boolean fullCapacity){ // boolean per controllare se la casa ha spazio. la fullcapacity deve segnalare se deve usare una capienza simolata o quella vera
        int housePos = Attays.asList(HOUSE_NAMES).indexOf(houseName); // crea una lista temporanea di house names
        int size = getEvenHouseSize();
        
        if(fullCapacity){
            return COUNTERS[housePos] < HOUSE_SIZE; // ritorna una booleana true se la casa ha spazio
        } else {
            return COUNTERS[housePos] < size; // la dimensione della casa risulterà onferiore di 1 nel caso in cui il numero di studenti non si divida con il numero delle case 
        }
    }
    // funzione che assegna uno studente una casa 
    private static void assignStudentToHouse(String studentName , String houseName){
        int housePos = Attays.asList(HOUSE_NAMES).indexOf(houseName); // posizione della casa nell'array delle case a partire dal suo nome
        int studentPos = COUNTERS[housePos]; // contatore che tiene traccia quanti studenti che esistono in questa casa
        HOUSES[housePos][studentPos] = studentName; // 
        COUNTERS[housePos]++; // incrementa il numero 
    }
    private static void assignPrefects(){
        for(int i = 0; i < PREFECTS.length; i ++){
            HOUSES[i][0] = PREFECTS[i]; // ogni prefetto viene assegnata alla casa corrispondente 0 0 1 1 etc
            COUNTER[i]++; 
        }
    }
    private static String getRandomAvailableHouse(boolean fullCapacity) {
        String[] hs = new String[HOUSES.length];
        int numAvail = 0;
        int size = fullCapacity ? HOUSE_SIZE : getEvenHouseSize();
        for(int i = 0; i < COUNTERS.length; i++){
            if(COUNTERS[i] < size){
                hs[numAvail] =HOUSE_NAMES[i];
                numAvail++; 
            }
        }
        if(numAvail == 0){
            return null;
        }
        return hs[DICE.nextInt(numAvail)];
    }

    private static int getEvenHouseSize(){
        // prendo la dimensione massima. ci sono strumenti extra? si, sottraggo 1 altrimenti 0 
        return HOUSE_SIZE - (HAS_EXTRA_STUDENTS ? 1 : 0);
    }

    private static void printFinalHouse(){
        // a quanto pare esce a tabella così 
        String outputFormat = "%-20s%-20s%-20s%-20s%n";
        System.out.printf(outputFormat , HOUSE_NAMES[0] , HOUSE_NAMES[1] , HOUSE_NAMES[2] , HOUSE_NAMES[3]);
        for(int i = 0; i < HOUSE_SIZE; i++){
            System.out.printf(outputFormat , HOUSES[0][i] , HOUSES[1][i] , HOUSES[2][i] , HOUSES[3][i]);
        }
    }

}   