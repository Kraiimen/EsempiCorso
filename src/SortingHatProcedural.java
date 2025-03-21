import java.util.Arrays;
import java.util.Random;

public class SortingHatProcedural { // per prima cosa creo variabili statiche che mi aiuteranno a fare ordine
    private static final String[] HOUSE_NAMES = {"Griffindor", "Ravenclaw", "Hufflepuff", "Slytherin"}; 
    private static final int GRIFF_POS = 0;  //creo costanti che mi serviranno
    private static final int RAVEN_POS = 1;
    private static final int HUFF_POS = 2;
    private static final int SLYT_POS = 3; 

    private static final String STUDENTS[][] = { // faccio l'array e scambio i nomi delle casate con il nome di una variabile (cambiando il numero dentro [])
        
            {"Ilario Vasco Palaia",HOUSE_NAMES[3]},
            {"Elvis La fata",HOUSE_NAMES[1]},
            {"Regina Ghering",HOUSE_NAMES[3]},
            {"Luca Formica",HOUSE_NAMES[1]},
            {"Davide Mazzitelli",HOUSE_NAMES[1]},
            {"Piero Scarcina",HOUSE_NAMES[0]},
            {"Vittorio Aquila",HOUSE_NAMES[1]},
            {"Emanuele Giustiniani",HOUSE_NAMES[3]},
            {"Gaspare Maione",HOUSE_NAMES[0]},
            {"Camilla Marchioro",HOUSE_NAMES[0]},
            {"Eugenio Manganelli",HOUSE_NAMES[2]},
            {"Edoardo Bognanni",HOUSE_NAMES[1]},
            {"Lorenzo Coretti",HOUSE_NAMES[2]},
            {"Sabrina Salerno",HOUSE_NAMES[2]},
            {"Marcello Coppolino",HOUSE_NAMES[3]},
            {"Stefano Pio Lorato",HOUSE_NAMES[0]},
            {"Nicolò Casertano",HOUSE_NAMES[0]},
            {"Alessio Basili",HOUSE_NAMES[1]}
        
    }; 

    private static final int HOUSE_SIZE = (int)Math.ceil((STUDENTS.length + 4) / 4); //c'è una funzione che dà il numero int maggiore del primo numero di un double 
    private static final String[][] HOUSES = new String[4][HOUSE_SIZE]; //con due info faccio un array chiamato HOUSES che ha [numero di case][numero di posti per casa]
    private static final int[] COUNTER = new int[4]; //studenti per ogni casata
    private static final Random DICE = new Random(); //dado randomico
   
    public static void main(String[] args) {
        randomize();
        for(int i = 0; i < (STUDENTS.length + 4)/ 4 * 4; i++) { //facendo diviso 4 e per 4 riesco a calcolare ogni singola casata divisa allo stesso modo 
            
            int luck = DICE.nextInt(4);                         //prima lancio i fortunati 
            String studentName = STUDENTS[i][0];                
            String favouriteHouse = STUDENTS[i][1]; //l'1 è la posizione, se fosse 0 sarebbe il nome
            boolean houseHasSpace = hasRoom(favouriteHouse, false); 
            
            if(luck == 0 && houseHasSpace) {                    //se sei fortunato ti dò la casata preferita
                assignStudentToHouse(studentName, favouriteHouse);
                System.out.println(studentName + " ... " + favouriteHouse + "come da sua preferenza"); 
            } 

        }    
        //TODO il resto del programma 
    }

    public static void randomize() { //funzione per randomizzare 
        for(int i = 0; i < 100; i++) {
            int n1 = DICE.nextInt(STUDENTS.length);
            int n2; 
            do { 
                n2 = DICE.nextInt(STUDENTS.length); 
            } while (n2 == n1); 
            String[] temp = STUDENTS[n1]; 
            STUDENTS[n1] = STUDENTS[n2];
            STUDENTS[n2] = temp;            //questo crea un secondo numero casuale 
        }  
// riprova a creare il secondo numero se per sfortuna venisse uguale al primo(non vogliamo scambiare un elemtno con se stesso)     
    }

    private static boolean hasRoom(String houseName, boolean fullCapacity) {
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName);  //stiamo creando una lista temporanea, a cui possiamo chiedere la posizione del nome della casata
        if(fullCapacity) {
            return COUNTER[housePos] < HOUSE_SIZE; 
        } else {
            return COUNTER[housePos] < HOUSE_SIZE - 1; 
        }
    }

    private static void assignStudentToHouse(String studentName, String houseName) { //posizione della casa nell'array delle case a partire dal suo nome 
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName);  //copia momentanea
        int studentPos = COUNTER[housePos]; 
        HOUSES[housePos][studentPos] = studentName;  
        COUNTER[housePos]++; 
    }
}
