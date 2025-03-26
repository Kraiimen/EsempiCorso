import java.util.Arrays;
import java.util.Random;

public class SortingHatProcedural {

    private static final String[] HOUSE_NAMES = {"Gryffindor","Hufflepuff","Slytherin","Ravenclaw"};

    private static final int GRYF_POS = 0;
    private static final int HUF_POS = 1;
    private static final int SLY_POS  = 2;
    private static final int RAVE_POS  = 3;

    private static final String[] PREFECTS = {"Federico De Simone","Marta Petruzzelli","Carmine Erario","Filippo Aresu"};

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
    private static final int PERFECT_CLASS_SIZE = STUDENTS.length/4 *4;  

    private static final int EXTRA_STUDENTS = STUDENTS.length % HOUSE_NAMES.length;

    private static final boolean HAS_EXTRA_STUDENTS = EXTRA_STUDENTS != 0;  

    // Questo array tiene traccia del numero di studenti messi in ogni casa
    private static final int[] COUNTERS = new int[4]; 

    private static final int HOUSE_SIZE = (STUDENTS.length + 4)/4 + (HAS_EXTRA_STUDENTS ? 1 : 0); 
    
    private static final String[][] HOUSES = new String[4][HOUSE_SIZE];

    private static final Random DICE = new Random(); 

    public static void main(String[] args) {


        for(int i = 0; i < PERFECT_CLASS_SIZE; i++) {  
            assignToDestination(studentName, favouriteHouse, false); 
        }
        for(int i = PERFECT_CLASS_SIZE; i < PERFECT_CLASS_SIZE + EXTRA_STUDENTS; i++) {
            assignToDestination(STUDENTS[i][0], STUDENTS[i][1], true);
        }
        } 

        if(luck == 0 && houseHasSpace) { 
        } else {
            if(destination == null) {
        }

    }

            int n2; 
            STUDENTS[n1] = STUDENTS[n2];
            STUDENTS[n2] = temp; 
        }
    }

    private static boolean hasRoom(String houseName, boolean fullCapacity){ 
        int size = getEvenHouseSize();  

        if(fullCapacity){
        } else {
        }
    }

    private static void assignStudentToHouse(String studentName , String houseName){
    }

        for(int i = 0; i < PREFECTS.length; i++) {
            HOUSES[i][0] = PREFECTS[i]; 
            COUNTERS[i]++; 
        }
    }

    private static String getRandomAvailableHouse(boolean fullCapacity) {
        int size = fullCapacity ? HOUSE_SIZE : getEvenHouseSize();
        for(int i = 0; i < COUNTERS.length; i++) {
            if(COUNTERS[i] < size) { 
            }
        }
        if(numAvail == 0) {
            return null; 
        }
        return hs[DICE.nextInt(numAvail)];
    }

    private static int getEvenHouseSize() {
        return HOUSE_SIZE - (HAS_EXTRA_STUDENTS ? 1 : 0); 
    }

    private static void printFinalHouses() {
        String outputFormat = "%-25s%-25s%-25s%-25s%n";  
        System.out.printf(outputFormat, HOUSE_NAMES[0], HOUSE_NAMES[1], HOUSE_NAMES[2], HOUSE_NAMES[3]); 
        for(int i = 0; i < HOUSE_SIZE; i++) {
        }
    }
}