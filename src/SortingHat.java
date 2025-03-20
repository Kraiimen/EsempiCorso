import java.util.Random;
import java.util.Arrays;

public class SortingHat {
    public static void main (String[] args){
        Random dice = new Random();

        String[][] students = {
                                {"Ilario palaia", "Slytherin"},
                                {"Elvis La Fata", "Ravenclaw"},
                                {"Regina Ghering", "Slytherin"},
                                {"Luca Formica", "Ravenclaw"},
                                {"Davide Mazzitelli", "Ravenclaw"},
                                {"Piero Scarcina", "Gryffindor"},
                                {"Vittorio Aquila", "Ravenclaw"},
                                {"Emanuele Giustiniani", "Slytherin"},
                                {"Gaspare Maione", "Gryffindor"},
                                {"Camilla Marchioro", "Gryffindor"},
                                {"Eugenio Manganelli", "Hufflepuff"},
                                {"Edoardo Bognanni", "Ravenclaw"},
                                {"Lorenzo Coretti", "Hufflepuff"},
                                {"Sabrina Salerno", "Hufflepuff"},
                                {"Marcello Coppolino", "Slytherin"},
                                {"Stefano Lorato", "Gryffindor"},
                                {"Nicolò Casertano", "Gryffindor"},
                                {"Alessio Basili", "Ravenclaw"}
                            };

        randomize(students, dice);

        for(String[] s : students){
            System.out.println(Arrays.toString(s));
        }

        String[] houses = {"Gryffindor", "Slytherin", "Ravenclaw", "Hufflepuff"};
        int[] hCounter = {1, 1, 1, 1};

        // int grCounter = 1;
        // int slCounter = 1;
        // int rvCounter = 1;
        // int hpCounter = 1;

        String[] gryffindor = new String[6];
        String[] slytherin = new String[6];
        String[] ravenclaw = new String[6];
        String[] hufflepuff = new String[6];

        gryffindor[0] = "Federico De Simone";
        slytherin[0] = "Carmine Erario";
        ravenclaw[0] = "Filippo Aresu";
        hufflepuff[0] = "Marta Petruzzelli";

        for (int i = 0; i < students.length; i++){
            String name = students[i][0];
            String housePreference = students[i][1];
            int hIndex = -1;

            if (!housePreference.isEmpty() && preference(dice)) {
                for (int j = 0; j < houses.length; j++) {
                    if (houses[j].equals(housePreference) && hCounter[j] < 5) {
                        hIndex = j;
                        break;
                    }
                }
            }

            if (hIndex == -1) {
                hIndex = getAvailableHouse(hCounter, dice, houses);
            }

            if (hCounter[hIndex] < 6) {
                switch(hIndex){
                    case 0:
                        gryffindor[hCounter[0]] = name;
                        hCounter[0]++;
                        break;
                    case 1:
                        slytherin[hCounter[1]] = name;
                        hCounter[1]++;
                        break;
                    case 2:
                        ravenclaw[hCounter[2]] = name;
                        hCounter[2]++;
                        break;
                    case 3:
                        hufflepuff[hCounter[3]] = name;
                        hCounter[3]++;
                        break;
                }
            } else {
                System.out.println("Casa piena: " + houses[hIndex]);
            }
            // System.out.println("hCounter: Gryffindor=" + hCounter[0] + " Slytherin=" + hCounter[1] + " Ravenclaw=" + hCounter[2] + " Hufflepuff=" + hCounter[3]);
        }
 
        // for (int i = 0; i < students.length; i++){
        //     for (int j = 0; j < 2; j++)
                
        //         System.out.print(students[i][j]+" ");
                
        //       System.out.println();
        // }

        for (int i = 0; i < houses.length; i++) {
            System.out.println(houses[i] + ":");
            switch (i) {
                case 0:
                    printStudents(gryffindor);
                    break;
                case 1:
                    printStudents(slytherin);
                    break;
                case 2:
                    printStudents(ravenclaw);
                    break;
                case 3:
                    printStudents(hufflepuff);
                    break;
            }
        }

    }

    public static boolean preference(Random dice){
        return dice.nextInt(4) == 3;
    }

    public static int getAvailableHouse(int[] hCounter, Random dice, String[] houses){

        boolean allFull = true;
        int hIndex;

        for (int j = 0; j < houses.length; j++) {
            if (hCounter[j] < 5) {
                allFull = false;
                break;
            } 
        }
        if(allFull){
            do {
                hIndex = dice.nextInt(houses.length);  
            } while (hCounter[hIndex] >= 6);
        } else {
            do {
                hIndex = dice.nextInt(houses.length);  
            } while (hCounter[hIndex] >= 5);
        }

        return hIndex;

    }

    public static void printStudents(String[] house) {
        for (String student : house) {
            if (student != null) {
                System.out.printf("|    " + student + "  |");
            }
        }
        System.out.println();
    }

    public static void randomize(String[][] students, Random dice){
        for(int i = 0; i < 100; i++){
            int n1 = dice.nextInt(students.length);
            int n2;
            do{
                n2 = dice.nextInt(students.length);
            } while (n2 == n1);
            String[] temp = students[n1];
            students[n1] = students[n2];
            students[n2] = temp;
        }
    }
}