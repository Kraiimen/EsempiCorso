package org.generation.italy.exercises;

import java.io.Console;
import java.util.Random;
// static appartiene alla classe e non all'istanza della classe

public class MySortingHatProcedural {
    private static final String SUSPENCE[] = {
                         "Ah, che mente affascinante! So esattamente dove collocarti...",
                         "Vedo dentro di te grandi qualità... la tua strada è chiara per me!",
                         "Ambizione, coraggio, saggezza o lealtà? Io so cosa ti definisce meglio!",
                         "Oh, che scelta interessante... ma ora so esattamente dove tu appartieni!",
                         "Non c'è alcun dubbio, il tuo destino è segnato... benvenuto nella tua nuova casa!"
                        };

    public static final String[] HOUSE_NAMES = {"Gryffindor", "Slytherin", "Ravenclaw", "HufflePuff"};
    public static final int[] COUNTER = new int[HOUSE_NAMES.length];

    private static final int GRYF_POS = 0;
    private static final int SLY_POS  = 1;
    private static final int RAVE_POS  = 2;
    private static final int HUF_POS = 3;

    private static final String[] PREFECTS = {"Federico De Simone","Carmine Erario","Filippo Aresu", "Marta Petruzzelli"};

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

    public static final int PERFECT_CLASS_SIZE = (STUDENTS.length / HOUSE_NAMES.length) * HOUSE_NAMES.length;
    public static final int EXTRA_STUDENTS = STUDENTS.length % HOUSE_NAMES.length;
    public static final boolean HAS_EXTRA_STUDENTS = EXTRA_STUDENTS != 0;
    public static final int HOUSE_SIZE = (STUDENTS.length + PREFECTS.length) / HOUSE_NAMES.length + (HAS_EXTRA_STUDENTS ? 1 : 0);
    public static final String[][] HOUSES = new String[HOUSE_NAMES.length][HOUSE_SIZE];

    private static final Random DICE = new Random();
    public static void main(String[] args){

        System.out.println("SUSPENCE.length = " + SUSPENCE.length);
        System.out.println("numero di studenti = " + STUDENTS.length);
        System.out.println("numero di case = " + HOUSE_NAMES.length);
        System.out.println("numero di prefetti = " + PREFECTS.length);
        System.out.println("dimensione delle case = " + HOUSE_SIZE);
        System.out.println("numero di persone in classe senza extra = " + PERFECT_CLASS_SIZE);

        randomize();

        // for(String[] s : STUDENTS){
        //     System.out.println(Arrays.toString(s));
        // }

        assignPrefects();

        for(int i = 0; i < PERFECT_CLASS_SIZE; i++){
            String studentName = STUDENTS[i][0];
            String favouriteHouse = STUDENTS[i][1];
            System.out.println(i);
            assignStudentToDestination(studentName, favouriteHouse, false);
        }
        for(int i = PERFECT_CLASS_SIZE; i < PERFECT_CLASS_SIZE + EXTRA_STUDENTS; i++){
            String studentName = STUDENTS[i][0];
            String favouriteHouse = STUDENTS[i][1];
            assignStudentToDestination(studentName, favouriteHouse, true);
        }

        printFinalHouses();
    }

    public static void randomize(){
        for(int i = 0; i < 100; i++){
            int n1 = DICE.nextInt(STUDENTS.length);
            int n2;
            do{
                n2 = DICE.nextInt(STUDENTS.length);
            } while (n1 == n2);
            String[] temp = STUDENTS[n1];
            STUDENTS[n1] = STUDENTS[n2];
            STUDENTS[n2] = temp;
        }
    }

    public static void assignPrefects(){
        for(int i = 0; i < PREFECTS.length; i++){
            HOUSES[i][0] = PREFECTS[i];
            COUNTER[i]++;
        }
    }

    public static void assignStudentToDestination(String studentName, String favouriteHouse, boolean fullCapacity){
        boolean houseHasSpace = hasRoom(favouriteHouse, fullCapacity);
        int luck = DICE.nextInt(4);

        if (luck == 0 && houseHasSpace){
            assignStudentToHouse(studentName, favouriteHouse);
            printStudentDestination(studentName, favouriteHouse, true);
            waitForReturn();
        } else {
            String destination = getRandomAvailableHouse(fullCapacity);
            if(destination == null){
                System.out.println("Error: No houses available");
                System.exit(0);
            } 
            assignStudentToHouse(studentName, destination);
            printStudentDestination(studentName, destination, false);
            waitForReturn();
        }
    }

    public static boolean hasRoom(String houseName, boolean fullCapacity){
        int housePos = 0;
        for(int i = 0; i < HOUSE_NAMES.length; i++){
            if(houseName.equals(HOUSE_NAMES[i])){
                housePos = i;
                break;
            }
        }

        int size = getReducedHouseSize();

        if(fullCapacity){
            return COUNTER[housePos] < HOUSE_SIZE;
        } else {
            return COUNTER[housePos] < size;
        }
    }

    public static int getReducedHouseSize(){
        return HOUSE_SIZE - (HAS_EXTRA_STUDENTS ? 1 : 0); 
    }

    public static void assignStudentToHouse(String studentName, String houseName){
        int housePos = 0;
        for(int i = 0; i < HOUSE_NAMES.length; i++){
            if(houseName.equals(HOUSE_NAMES[i])){
                housePos = i;
                break;
            }
        }
        int studentPos = COUNTER[housePos];

        HOUSES[housePos][studentPos] = studentName;
        COUNTER[housePos]++;
    }

    public static String getRandomAvailableHouse(boolean fullCapacity){
        String[] availableHouses = new String[HOUSE_NAMES.length]; 
        int numAvailable = 0;
        int size = fullCapacity ? HOUSE_SIZE : getReducedHouseSize();
        for(int i = 0; i < COUNTER.length; i++){
            if(COUNTER[i] < size){
                availableHouses[numAvailable] = HOUSE_NAMES[i];
                numAvailable ++;
            }
        }

        if(numAvailable == 0){
            return null;
        }

        return availableHouses[DICE.nextInt(numAvailable)];
    }

    public static void printStudentDestination(String studentName, String houseName, boolean wasLucky){
        System.out.println("\n"+studentName + "...");
        delay(1000);
        System.out.println(SUSPENCE[DICE.nextInt(SUSPENCE.length)]);
        delay(1500);
        if (wasLucky) {
            System.out.println(houseName.toUpperCase()+", come da sua preferenza!");
        } else {
            System.out.println(houseName.toUpperCase()+" !");
        }
    }

    public static void delay(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            
        }
    }

    private static void waitForReturn(){
        Console console = System.console();
        console.readLine(); // invio
    } 

    public static void printFinalHouses(){
        String outputFormat = "%-25s%-25s%-25s%-25s%n";
        System.out.println();
        System.out.printf(outputFormat, HOUSE_NAMES[0], HOUSE_NAMES[1], HOUSE_NAMES[2], HOUSE_NAMES[3]);
        for(int i = 0; i < HOUSE_SIZE; i++){
            System.out.printf(outputFormat, emptyIfNull(HOUSES[0][i]), emptyIfNull(HOUSES[1][i]),  emptyIfNull(HOUSES[2][i]),  emptyIfNull(HOUSES[3][i]));
        }
    }

    public static String emptyIfNull(String str){
        return str == null ? "" : str; 
    }
}
