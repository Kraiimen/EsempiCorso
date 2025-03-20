import java.util.Random;
//Il programma lavora sulla lista di tutti gli studenti del corso e per assegnare ad ogni studente ad una delle 4 casate del film di Harry Potter
//
//
//Il programma ad ogni assegnazione stamperà 1 riga per notificare l'utente
//Il programma terminerà con una tabella con le 4 case con i relativi studenti.

public class SortingHatProcedura {
    private static final String[] HOUSE_NAMES = {"Gryffindor", "Hufflepuff", "Slytherin", "Ravenclaw"};

    private static final String STUDENTS[][] = {
                                                        //array di array di stringhe.
            {"Ilario Vasco Palaia",HOUSE_NAMES[2]},
            {"Elvis La fata",HOUSE_NAMES[3]},
            {"Regina Ghering",HOUSE_NAMES[2]},
            {"Luca Formica",HOUSE_NAMES[3]},
            {"Davide Mazzitelli",HOUSE_NAMES[3]},
            {"Piero Scarcina",HOUSE_NAMES[0]},
            {"Vittorio Aquila",HOUSE_NAMES[3]},
            {"Emanuele Giustiniani",HOUSE_NAMES[2]},
            {"Gaspare Maione",HOUSE_NAMES[0]},
            {"Camilla Marchioro",HOUSE_NAMES[0]},
            {"Eugenio Manganelli",HOUSE_NAMES[1]},
            {"Edoardo Bognanni",HOUSE_NAMES[3]},
            {"Lorenzo Coretti",HOUSE_NAMES[1]},
            {"Sabrina Salerno",HOUSE_NAMES[1]},
            {"Marcello Coppolino",HOUSE_NAMES[2]},
            {"Stefano Pio Lorato",HOUSE_NAMES[0]},
            {"Nicolo Casertano",HOUSE_NAMES[0]},
            {"Alessio Basili",HOUSE_NAMES[3]}
        };

    private static final int GRYF_POSE = 0;
    private static final int HUF_POSE = 1;
    private static final int SLY_POSE = 2;
    private static final int RAV_POSE = 3;

    private static final int HOUSE_SIZE = (int)Math.ceil((STUDENTS.length+4)/4);  //Math.ceil arrotonda per eccesso in numero intero.
    private static final String[][] HOUSES = new String[4][HOUSE_SIZE];
    private static final int[] COUNTERS = new int[4]; // Questo array tiene traccia di quanti studenti sono messi in ogni casa. 
    private static final Random DICE = new Random();

    public static void main(String[] args) {
        
        randomize();
        // for(String[] s : STUDENTS) {
        //     System.out.println(Arrays.toString(s));
        // }

        for(int i = 0; i < STUDENTS.length(+4)/4*4; i++) {
            int luck = DICE.nextInt(4);
            String studentName = STUDENTS[i][0];
            String favouriteHouse = STUDENTS[i][1];
            boolean houseHasSpace = hasRoom(favouriteHouse, false)
            if(luck == 0 && houseHasSpace) {
                assignStudentToHouse(studentName , favouriteHouse);
                System.out.println(studentName + " ... " + favouriteHouse + " come da sua preferenza");
            }
        }

            //TODO il resto del programma
    }

    public static void randomize() {
        for(int i = 0; i < 100; i++) {
            int n1 = DICE.nextInt(STUDENTS.length);
            int n2;
            do {
                n2 = DICE.nextInt(STUDENTS.length);
            } while(n2 == n1);
            String[] temp = STUDENTS[n1];
            STUDENTS[n1] = STUDENTS[n2];
            STUDENTS[n2] = temp;

        }

    }


    private static boolean hasRoom(String houseName, boolean fullcapacity) {
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName);
        if(fullCapacity) {
            return COUNTERS[housePos] < HOUSE_SIZE;
        } else {
            return COUNTERS[housePos] < HOUSE_SIZE-1;
        }
    }

    //Funzione che assegna uno studente a una casa che gli daremo il nome
    private static void assignStudentToHouse(String studentname , String houseName) {
        int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName);
        int studentPos = COUNTERS[housePos]
        HOUSES[housePos][studentPos] = studentName;
        COUNTERS[housePos]++;
    }
}