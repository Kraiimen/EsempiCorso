
//errore guardare nella main


//il programma sulla base di una lista di studenti e delle loro preferenze assegna loro una casata di Harry Potter
//assegnera una loro casa preferita sulla base di una probabilità altrimenti verra messo casualmente in una delle 4 case
//il programma notificherà l assegnazione di uno studente in una casa
//il programma stampera una tabella con le 4 case con i relativi studenti
import java.util.Random;
import java.util.Arrays;

public class SortingHatProcedural{//static, mi permette di usare la variabile in qualunque parte del programma
    private static final String [] HOUSE_NAMES = {"Gryffindor","Hufflepuff","Slytherin","Ravenclaw"};
    
    private static final int GRYFF_POS = 0;
    private static final int HUF_POS = 1;
    private static final int SLY_POS = 2;
    private static final int RAVE_POS = 3;
    private static final String[] PREFECTS = {"Federico De Simone", "Marta Petruzzelli", "Carmine Erario", "Filippo Aresu"};
    
    private static final String STUDENTS[][] = { //final ->l indirizzo in memoria dell array non cambiera, è una costante quindi lo scriviamo in maiuscolo
            {"Ilario Vasco Palaia",HOUSE_NAMES[SLY_POS]},
            {"Elvis La fata",HOUSE_NAMES[RAVE_POS]},
            {"Regina Ghering",HOUSE_NAMES[SLY_POS]},
            {"Luca Formica",HOUSE_NAMES[RAVE_POS]},
            {"Davide Mazzitelli",HOUSE_NAMES[RAVE_POS]},
            {"Piero Scarcina",HOUSE_NAMES[GRYFF_POS]},
            {"Vittorio Aquila",HOUSE_NAMES[RAVE_POS]},
            {"Emanuele Giustiniani",HOUSE_NAMES[SLY_POS]},
            {"Gaspare Maione",HOUSE_NAMES[GRYFF_POS]},
            {"Camilla Marchioro",HOUSE_NAMES[GRYFF_POS]},
            {"Eugenio Manganelli",HOUSE_NAMES[HUF_POS]},
            {"Edoardo Bognanni",HOUSE_NAMES[RAVE_POS]},
            {"Lorenzo Coretti",HOUSE_NAMES[HUF_POS]},
            {"Sabrina Salerno",HOUSE_NAMES[HUF_POS]},
            {"Marcello Coppolino",HOUSE_NAMES[SLY_POS]},
            {"Stefano Pio Lorato",HOUSE_NAMES[GRYFF_POS]},
            {"Nicolo Casertano",HOUSE_NAMES[GRYFF_POS]},
            {"Alessio Basili",HOUSE_NAMES[RAVE_POS]}
        };


  
    //crea un array di contatori che terrà traccia del numero degli elementi inseriti in ciascuna casata
    private static final int [] COUNTERS = new int [4];//tiene traccia degli studenti inseriti in ogni caso
    

    // crea un oggetto random
    private static final Random DICE = new Random();

    private static final int EXTRA_STUDENTS = STUDENTS.length % HOUSE_NAMES.length;
    private static final boolean HAS_EXTRA_STUDENTS = EXTRA_STUDENTS != 0;
    private static final int HOUSE_SIZE = (STUDENTS.length+4)/4 + (HAS_EXTRA_STUDENTS ? 1 : 0);
    //crea un array contenente 4 array di grandezza 6
    private static final String [][] HOUSES =new String [4][HOUSE_SIZE];
    //il numeri di studenti che creerebbe 4 case della stessa dimensione 
    private static final int PERFECT_CLASS_SIZE = STUDENTS.length/4*4;


    public static void main(String [] args){
        randomize();
        // for(String [] s : STUDENTS){//Arrays classe che ci da funzioni utili per lavorare con gli array
        //     System.out.println(Arrays.toString(s));
        // }
        assignPrefects();
        for (int i = 0; i < PERFECT_CLASS_SIZE ; i++){
            String studentName = STUDENTS[i][0];
            String favouriteHouse = STUDENTS[i][1];
            assignToDestination(studentName, favouriteHouse, false); //il false tiene conto della dimensione ridotta

        }
        for(int i = PERFECT_CLASS_SIZE; i < PERFECT_CLASS_SIZE + EXTRA_STUDENTS; i++){
            assignToDestination(STUDENTS[i][0], STUDENTS[i][1], true); //true perche lavoriamo in full capacity 
        }
        // for (int c : COUNTERS){
        //     System.out.println(c);
        // }
        printFinalHouses();
    }
    private static void assignToDestination(String studentName, String favouriteHouse, boolean fullCapacity){
        int luck = DICE.nextInt(4);
        boolean houseHasSpace = hasRoom(favouriteHouse, fullCapacity);
        if (luck == 0 && houseHasSpace){
            assignStudentToHouse(studentName, favouriteHouse);
            System.out.println(studentName + " ... " + favouriteHouse + " come da sua preferenza");
        }else {
            String destination = getRandomAvailableHouse(fullCapacity);
            if (destination == null){ //se destination null terminiamo il programma
                System.out.println("Errore logico tutte le case risultano occupate al massimo, terminiamo il programma");
                return; //ritornerà la main, se la main ritorna termina il programma
            }
            assignStudentToHouse(studentName, destination);
        }
    }
    public static void randomize(){ // non prende input nulla perche students è static
        //per 100 volte scambio 2 studenti a caso
        for(int i = 0; i < 100; i++){
            int n1 = DICE.nextInt(STUDENTS.length);
            int n2;
            do{
                n2 = DICE.nextInt(STUDENTS.length); //evitiamo che capiti lo stesso studente nella stessa iterazione
            } while(n1==n2);
            String [] temp = STUDENTS[n1]; //passiamo l'array alla posizione n1
            STUDENTS[n1] = STUDENTS[n2];
            STUDENTS[n2] = temp;
            
        }
    }
    //mi dice se una casata ha spazio libero, la boolean segnalera se useo una dimensione limitata o reale
    private static boolean hasRoom(String houseName, boolean fullCapacity){
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName); //crea momentaneamente una lista che usa il metodo index of per vedere a che indice sta il valore houseName
        int size = getEvenHouseSize();

        if (fullCapacity){
            return COUNTERS[housePos] < HOUSE_SIZE; //6 posti
        } else {
            return COUNTERS[housePos] < size; // array 5 posti bloccati se has_extra è true
        }

    }
    //funzione che assegna uno studente a una casa sulla base delle sue preferenze
    private static void assignStudentToHouse(String studentName, String houseName){
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName); //crea momentaneamente una lista che usa il metodo index of per vedere a che indice sta il valore houseName
        int studentPos = COUNTERS[housePos];//da la prima posizione libera
        HOUSES[housePos][studentPos] = studentName; // va a infilare lo studente nella casa housepos nella posizione studentpos
        COUNTERS[housePos]++;
    }
    private static void assignPrefects(){
        for(int i = 0; i < PREFECTS.length; i++){
            HOUSES[i][0] = PREFECTS[i];
            COUNTERS[i]++;
        }
    }
    private static String getRandomAvailableHouse(boolean fullCapacity){
        String [] hs = new String [HOUSES.length];
        //conta il numero delle case disponibili
        int numAvail = 0;
        int size = fullCapacity? HOUSE_SIZE : getEvenHouseSize();
        for(int i = 0; i < COUNTERS.length; i++){
            if(COUNTERS[i] < size){
                //se le case hanno spazio le mettiamo nell array hs
                hs[numAvail] = HOUSE_NAMES[i];
                numAvail++;
            }
        }
        if(numAvail  == 0){
            return null; //ritorna null se non ci sono case disponibili
        }
        //ritorna una casa sorteggiata tra le disponibili
        return hs[DICE.nextInt(numAvail)];
    }
    private static int getEvenHouseSize(){
        return HOUSE_SIZE - (HAS_EXTRA_STUDENTS ? 1 : 0);
    }
    private static void printFinalHouses(){
        String outputFormat = "%-25s%-25s%-25s%-25s%n"; //-indenta a sinistra, 25 per dedicare caratteri a ciascuna stringa passata
        System.out.printf(outputFormat, HOUSE_NAMES[0], HOUSE_NAMES[1], HOUSE_NAMES[2], HOUSE_NAMES[3]);
        for (int i = 0; i < HOUSE_SIZE; i++){
            System.out.printf(outputFormat, HOUSES[0][i], HOUSES[1][i], HOUSES[2][i], HOUSES[3][i]);
        }
    }
}