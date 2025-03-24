import java.util.Arrays;
import java.util.Random;
import java.util.prefs.PreferenceChangeListener;

public class SortingHat2 {  
 
   private static final String[] HOUSE_NAMES = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
   private static final int GRYFF_POSE = 0;//Le variabili che ci indicano le posizioni della case nell'array
   private static final int HUFF_POSE = 1;//Referenzio gli elementi dell'array utilizzando una variabile 1,2,3.
   private static final int RAVEN_POSE = 2;//Dichiariamo costanti statiche
   private static final int SLY_POSE = 3;
   
    public static final String STUDENTS[][] = {  //Creazione array bidimensionale students
   
    {"Ilario Vasco Palaia",HOUSE_NAMES[SLY_POSE]},
    {"Elvis La fata",HOUSE_NAMES[RAVEN_POSE]},//Array di Array di stringhe
    {"Regina Ghering",HOUSE_NAMES[GRYFF_POSE]},
    {"Luca Formica",HOUSE_NAMES[RAVEN_POSE]},
    {"Davide Mazzitelli",HOUSE_NAMES[RAVEN_POSE]},
    {"Piero Scarcina",HOUSE_NAMES[GRYFF_POSE]},
    {"Vittorio Aquila",HOUSE_NAMES[RAVEN_POSE]},
    {"Emanuele Giustiniani",HOUSE_NAMES[SLY_POSE]},
    {"Gaspare Maione",HOUSE_NAMES[GRYFF_POSE]},
    {"Camilla Marchioro",HOUSE_NAMES[GRYFF_POSE]},
    {"Eugenio Manganelli",HOUSE_NAMES[HUFF_POSE]},
    {"Edoardo Bognanni",HOUSE_NAMES[RAVEN_POSE]},
    {"Lorenzo Coretti",HOUSE_NAMES[HUFF_POSE]},
    {"Sabrina Salerno",HOUSE_NAMES[HUFF_POSE]},
    {"Marcello Coppolino",HOUSE_NAMES[SLY_POSE]},
    {"Stefano Pio Lorato",HOUSE_NAMES[GRYFF_POSE]},
    {"Nicolo Casertano",HOUSE_NAMES[GRYFF_POSE]},
    {"Alessio Basili",HOUSE_NAMES[RAVEN_POSE]},};

    private static final int EXTRA_STUDENTS = STUDENTS.length % HOUSES.length;
    public static final boolean HAS_EXTRA_STUDENTS = EXTRA_STUDENTS != 0;
    private static int[] COUNTERS = new int[4];//Tiene traccia del numero di studenti messi in ogni casa
    private static final int HOUSE_SIZE = (STUDENTS.length + 4)/4 + [HAS_EXTRA_STUDENTS ? 1 : 0];
    private static final String[][] HOUSES = new String[4][HOUSE_SIZE];//Array di Array di stringhe


    private static final Random DICE = new Random();//Classe che genera numeri casuali ma va importato, ed è un oggetto DICE di tipo RANDOM

    public static void main(String[] args) {
        

        randomize();//Funzione che richiamo poi nella main
        // for(String[] s : STUDENTS){
        //     System.out.println(Arrays.toString(s));//Stampa l'array di stringhe (convertendolo)
        assignPrefects();//Assegno i prefetti

        for(int i = 0; i < (STUDENTS.length+4)/4 * 4; i++){
            int luck = DICE.nextInt(4);
            String studentName = STUDENTS[i][0];
            String favouriteHouse = STUDENTS[i][1];
            assignToDestination(studentName, favouriteHouse, HAS_EXTRA_STUDENTS);
                    }
                    assingStudentHouse(studentName, destination);
                 }
                
            

            //TODO: il resto del programma

    
            private static void assignToDestination(String studentName, String favouriteHOuse, boolean fullCapacity){
                booelan is = houseHasSpace = hasRoom(favouriteHouse, fullCapacity);
            if(luck == 0 && houseHasSpace){
                assignStudentToHouse(favouriteHouse , studentName);
                System.out.println(studentName + " ----- " + favouriteHouse + "come da sua preferenza");
                 } else {
                    String destination = getRandomAvailableHouse(false);
                    if(destination == null){
                        System.out.println("ERRORE LOGICO TUTTE LE CASE RISULTANO OCCUPATE AL MASSIMO, IL PROGRAMMA SI CHIUDERA'");
                        return;}
            }
        public static void randomize(){//Metodo che non restituisce nulla
            for(int i = 0; i < 100; i++){//Ciclo for che si ripete 100 volte
                int n1 = DICE.nextInt(STUDENTS.length);//Numero casuale generato da 0 a 17
                int n2;
                do{
                    n2 = DICE.nextInt(STUDENTS.length);
                } while(n2 == n1);//Ciclo che si ripete finchè n1 e n2 non sono uguali
                String[] temp = STUDENTS[n1];//Dichiariamo un array di stringhe "temp" n1 e n2 sono le posizioni dell'array all'interno dell'array students
                STUDENTS[n1] = STUDENTS[n2];//Scambio di posizione
                STUDENTS[n2] = temp;//Scambio di posizione

            }
    }

        private static boolean hasRoom(String houseName, boolean fullCapacity){ //Metodo che restituisce un booleano
            int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName); //Posizione della casa
            int size = getEvenHouseSize();
            if(fullCapacity){
                return COUNTERS[housePos] < HOUSE_SIZE;//Restituisce vero se il contatore della casa è minore della dimensione della casa
            } else {
                return COUNTERS[housePos] < size;//La dimensione della casa risulta inferiore di 1 nel caso in cui ci siano studenti in più
            }
        }
            
        //funzione che assegna uno studente a una casa a cui diamo il nome
        private static void assignStudentToHouse(String studentName, String houseName){//Metodo che non restituisce nulla
            int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName);//Posizione della casa dell array partendo dal suo nome
            int studentPos = COUNTERS[housePos];//Il contatore degli studenti della casa che coincide con la posizione dello studente
            HOUSES[housePos][studentPos] = studentName;//Assegna lo studente alla casa
            COUNTERS[housePos]++;//Incrementa il contatore degli studenti della casa

}


        private static void assignPrefects(){//Prima di assegnare gli studenti alle case assegno i prefetti uno per ogni casa
        for(int i = 0; i < PPREFECTS.length; i++) {
        HOUSES[i][0] = PREFECTS[i];
        COUNTERS[i]++;
    }


    }
        public static String getRandomAvailableHouse(boolean fullCapacity){
            String[] hs = new String[HOUSES.length];
            int numAvail = 0;
            int size = fullCapacity ? HOUSE_SIZE : getEvenHouseSize();
            for(int i = 0; i < COUNTERS.length; i++){
                if(COUNTERS[i] < HOUSE_SIZE){
                hs[numAvail] = HOUSE_NAMES[i];
                numAvail++;
                 }
        }
        if(numAvail == 0){ 
            return null;
        }
        return hs[DICE.nextInt(numAvail)];
       
        }


         private static int getEvenHouseSize(){
              return HOUSE_SIZE - (HAS_EXTRA_STUDENTS ? 1 : 0);
         }
        

        }
    

    
    }    
     
