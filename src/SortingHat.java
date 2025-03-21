import java.util.Random;
import java.util.Arrays;

public class SortingHat {
    private static final String[] HOUSE_NAMES = new String[]{"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
    private static final int GRYF_POS = 0;
    private static final int HUF_POS = 1;
    private static final int RAVE_POS  = 2;
    private static final int SLY_POS  = 3;

    private static final String[][] PREFECTS_WITH_PREFERENCES = new String[][]{
            {"Federico De Simone", HOUSE_NAMES[SLY_POS]},
            {"Marta Petruzzelli", HOUSE_NAMES[HUF_POS]},
            {"Filippo Aresu", HOUSE_NAMES[RAVE_POS]},
            {"Carmine Erario", HOUSE_NAMES[SLY_POS]}
    };

    private static final int STUD_POS = 0;
    private static final int PREF_POS = 1;
    private static final String STUDENTS_WITH_PREFERENCES[][] = {
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
    
    private static final int HOUSE_SIZE = (int)Math.ceil((STUDENTS_WITH_PREFERENCES.length + PREFECTS_WITH_PREFERENCES.length) / (double)HOUSE_NAMES.length); //Math.ceil arrotonda per eccesso in numero intero (+1 è il nome della casa)
    private static final String[][] HOUSES = new String[HOUSE_NAMES.length][HOUSE_SIZE];

    private static final int[] COUNTERS = new int[HOUSE_NAMES.length]; // Questo array tiene traccia degli studenti messi per ogni casa
    private static final Random DICE = new Random();

    private static final int COLUMN_SPACES  = 22;

    public static void main(String[] args) throws InterruptedException {
        sortHouses(true);

        printHousesInColumns();
    }

	public static void sortHouses(boolean isPrefectsSortingRigged) throws InterruptedException {
        //houses = addHousesName(houses);      //aggiunge i nomi delle case

        //-------------------AGGIUNGO I PREFETTI coff coff CASUALMENTE coff coff--------------------
        if(isPrefectsSortingRigged){
            riggedSortPrefects();
        }else{
            //random sort of prefects with preferences
        }
        
        //-------------------METTO GLI STUDENTI IN ORDINE CASUALE--------------------
        randomizer();

        //----FACCIO IL SORT DI UN SOTTO-ARRAY DEGLI STUDENTI (senza i prefetti e l'ultimo studente di ogni casa)----
        sortStudents(1, HOUSE_SIZE-1);      //start = 1 perchè i prefetti ci sono già, end = HOUSE_SIZE-1 perchè non metto l'ultimo studente
        
        //-----------FACCIO IL SORT DI UN SOTTO-ARRAY DEGLI STUDENTI (solo ultimo studente di ogni casa)-------------
        sortStudents(HOUSE_SIZE-1, HOUSE_SIZE);
    }

    public static void riggedSortPrefects(){
        HOUSES[GRYF_POS][0] = PREFECTS_WITH_PREFERENCES[GRYF_POS][STUD_POS];
        HOUSES[HUF_POS][0] = PREFECTS_WITH_PREFERENCES[HUF_POS][STUD_POS];
        HOUSES[RAVE_POS][0] = PREFECTS_WITH_PREFERENCES[RAVE_POS][STUD_POS];
        HOUSES[SLY_POS][0] = PREFECTS_WITH_PREFERENCES[SLY_POS][STUD_POS];
        for(int i = 0; i < COUNTERS.length; ++i){
            COUNTERS[i]++;
        }
    }

    public static void randomizer(){
        for(int i = 0; i < 10000; ++i){
            int randomNumber1 = DICE.nextInt(STUDENTS_WITH_PREFERENCES.length);
            int randomNumber2 = DICE.nextInt(STUDENTS_WITH_PREFERENCES.length);

            String[] array = STUDENTS_WITH_PREFERENCES[randomNumber1];
            STUDENTS_WITH_PREFERENCES[randomNumber1] = STUDENTS_WITH_PREFERENCES[randomNumber2];
            STUDENTS_WITH_PREFERENCES[randomNumber2] = array;
        }
    }

    public static void sortStudents(int startPosition, int endPosition) throws InterruptedException {
        int start = (startPosition-1) * HOUSES.length;

        int endIndex = STUDENTS_WITH_PREFERENCES.length - ((endPosition-1) * HOUSES.length);
        endIndex = endIndex < 0 ? 0 : endIndex;

        for(int i = start; i < STUDENTS_WITH_PREFERENCES.length - endIndex; ++i){
            int chosenHouse = 0;

            boolean isPreferenceChecked = false;
            boolean canSort = false;

            while(canSort == false){
                chosenHouse = DICE.nextInt(4);

                boolean isHouseFull = COUNTERS[chosenHouse] == endPosition;

                boolean isPreference = STUDENTS_WITH_PREFERENCES[i][PREF_POS].toUpperCase().equals(HOUSE_NAMES[chosenHouse].toUpperCase());

                if(isHouseFull){
                    canSort = false;
                }else {
                    canSort = true;
                    if(isPreferenceChecked == false && isPreference == false){
                        canSort = false;
                        isPreferenceChecked = true;
                    }
                }
                if(canSort){
                    HOUSES[chosenHouse][COUNTERS[chosenHouse]] = STUDENTS_WITH_PREFERENCES[i][STUD_POS];
                    COUNTERS[chosenHouse]++;
                    printSortingCall(STUDENTS_WITH_PREFERENCES[i][STUD_POS], chosenHouse);
                }
            }
        }
    }

    //--------------------------------STAMPA DELLE CASE IN COLONNE----------------------------
    public static void printHousesInColumns(){
        StringBuilder textToPrint = new StringBuilder();
        textToPrint.append("\n");
        textToPrint.append(printHousesNamesInColumns());
        textToPrint.append(printHousesStudentsInColumns());
        textToPrint.append("\n");

        System.out.print(textToPrint);
    }
    public static StringBuilder printHousesNamesInColumns(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < HOUSE_NAMES.length; ++i){
            sb.append(HOUSE_NAMES[i]);
                
            int blankSpaces = COLUMN_SPACES - HOUSE_NAMES[i].length();
            for(int k = 0; k < blankSpaces; ++k){
                sb.append(" ");
            }
        }
        sb.append("\n");
        return sb;
    }
    public static StringBuilder printHousesStudentsInColumns(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < HOUSES[0].length; ++i){
            for(int j = 0; j < HOUSES.length; ++j){
                //25 spazzi
                String nameToPrint = HOUSES[j][i] == null ? "" : HOUSES[j][i];
                sb.append(nameToPrint);
                
                int blankSpaces = HOUSES[j][i] == null ? COLUMN_SPACES : COLUMN_SPACES - HOUSES[j][i].length();
                for(int k = 0; k < blankSpaces; ++k){
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb;
    }
    //-------------------------------------------------------------------------------------------------

    /*
    public static void printSortingCall(String studente, int chosenHouseIndex){
        System.out.print(studente);

        boolean hasTimePassed = false;

        for(int i = 0; i < 3; ++i){
            long time = System.nanoTime();
            System.out.print("  .  ");
            while(hasTimePassed == false){
                hasTimePassed = System.nanoTime() > time + 1_000_000_000;   // 1_000_000_000 == 1 secondo
            }
            hasTimePassed = false;
        }
        
        System.out.print(HOUSE_NAMES[chosenHouseIndex]);
        System.out.println();
    }
    //*/

    //*
    public static void printSortingCall(String studente, int chosenHouseIndex) throws InterruptedException {
        System.out.print(studente);
        Thread.sleep(1000);          //aspetto 1 secondo

        for(int i = 0; i < 3; ++i){
            System.out.print("  .  ");
            Thread.sleep(1000);      //aspetto 1 secondo
        }
        
        System.out.print(HOUSE_NAMES[chosenHouseIndex]);
        System.out.println();
        Thread.sleep(200);           //aspetto 1/5 secondo
    }
    //*/
}