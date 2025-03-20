// il programma lavora sulla lista di tutti gli studenti del corso per assegnare a ogni studente ad una delle 4 casate film di Harry Potter
// per l'assegnazione dello studente il programma terrà conto della prefernza dello studente assegnandolo alla casata con una probabilità del 25%
// in caso lo studente non entri nella casa preferita entrerà in una casa random
// il programma ad ogni assegnazione stamperà un messaggio che notifica in quale casa è stato inserito lo studente 
// il programma terminerà stampando una tabella con le 4 case con i relativi studenti
import java.util.Random;

public class SortingHatProcedural{
    public static final String[] HOUSE_NAMES = {"Gryffindor" , "Hufflepuff" , "Slytherin" , "Ravenclaw"}; // array per il nome delle casate
    private static final int GRY_POS = 0;
    private static final int HUF_POS = 1;
    private static final int SLY_POS = 2;
    private static final int RAVE_POS = 3;
    
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

    private static final int HOUSE_SIZE = (int)Math.ceil((STUDENTS.length+4)/4);
    //mat.ceil arrotonda per eccesso in numero intero. questa è la dimensione di ogni casa +4 sono i prefetti, /4 sono gli studenti che vengono divisi in 4 case
    private static final String[][] HOUSES = new String[4][HOUSE_SIZE]; // array delle casate, 4 sono quanti elementi sono e hanno come dimensione HOUSE SIZE 
    private static final int[] COUNTERS = new int[4]; // tiene traccia di quanti studenti vengono messi per ogni casa
    private static final Random DICE = new Random();
    
    public static void main(String[] args){
        randomize();
        // for(String[] s : STUDENTS){
        //     System.out.println(Arrays.toString(s)); // mi da una rappresentazione carina di un array
        // }
        for(int i = 0; i < (STUDENTS.length+4)/4*4; i++){ // un ciclo lista studenti +4(prefetti) divisi per 4 casate x 4 
            int luck = dice.nextInt(4);// rolla un dado se esce 4 esce la preferenza dello studente
            String favouriteHouse = STUDENTS[i][1]; // questa indica la sua preferenza di casa
            String favouriteHouse = STUDENTS[i][1];
            boolean houseHasSpace = hasRoom(favouriteHouse , false);
            if(luck == 0 && houseHasSpace){
                assignStudentToHouse(STUDENTS[i][0] , favouriteHouse)
                System.out.println(STUDENTS[i][0] + " ... " + favouriteHouse + " Come da sua preferenza");
            }
        }

        // TO DO il resto del programma 
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
        if(fullCapacity){
            return COUNTERS[housePos] < HOUSE_SIZE; // ritorna una booleana true se la casa ha spazio
        } else {
            return COUNTERS[housePos] < HOUSE_SIZE-1; // ritorna una booleana false la casa non ha spazio
        }
    }
    // funzione che assegna uno studente una casa 
    private static void assignStudentToHouse(String studentName , String houseName){
        int housePos = Attays.asList(HOUSE_NAMES).indexOf(houseName); // posizione della casa nell'array delle case a partire dal suo nome
        int studentPos = COUNTERS[housePos]; // contatore che tiene traccia quanti studenti che esistono in questa casa
        HOUSES[housePos][studentPos] = studentName; // 
        COUNTERS[housePos]++; // incrementa il numero 
    }

}   