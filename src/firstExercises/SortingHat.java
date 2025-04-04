package firstExercises;

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

        String[] houseNames = {"Gryffindor", "Slytherin", "Ravenclaw", "Hufflepuff"};
        int[] hCounter = {1, 1, 1, 1};

        // int grCounter = 1;
        // int slCounter = 1;
        // int rvCounter = 1;
        // int hpCounter = 1;

        int extraStudents = students.length % houseNames.length;
        int reducedHouseSize = (students.length + 4) / houseNames.length;
        int houseSize = extraStudents != 0 ? reducedHouseSize + 1 : reducedHouseSize;
        String[][] houses = new String[houseNames.length][houseSize];

        houses[0][0] = "Federico De Simone";
        houses[1][0] = "Carmine Erario";
        houses[2][0] = "Filippo Aresu";
        houses[3][0] = "Marta Petruzzelli";

        for (int i = 0; i < students.length; i++){
            String name = students[i][0];
            String housePreference = students[i][1];
            int hIndex = -1;

            if (!housePreference.isEmpty() && isLucky(dice)) {
                for (int j = 0; j < houseNames.length; j++) {
                    if (houseNames[j].equals(housePreference) && hCounter[j] < reducedHouseSize) {
                        hIndex = j;
                        break;
                    }
                }
            }

            if (hIndex == -1) {
                hIndex = getAvailableRandomHouse(hCounter, dice, houseNames, houseSize, reducedHouseSize);
            }

            if (hCounter[hIndex] < houseSize) {
                switch(hIndex){
                    case 0:
                        houses[0][hCounter[0]] = name;
                        hCounter[0]++;
                        break;
                    case 1:
                        houses[1][hCounter[1]] = name;
                        hCounter[1]++;
                        break;
                    case 2:
                        houses[2][hCounter[2]] = name;
                        hCounter[2]++;
                        break;
                    case 3:
                        houses[3][hCounter[3]] = name;
                        hCounter[3]++;
                        break;
                }
            } else {
                System.out.println("Casa piena: " + houses[hIndex]);
            }
            // System.out.println("hCounter: Gryffindor=" + hCounter[0] + " Slytherin=" + hCounter[1] + " Ravenclaw=" + hCounter[2] + " Hufflepuff=" + hCounter[3]);
        }
 
        // for (int i = 0; i < students.length; i++){
        //     for (int j = 0; j < 2; j++){
        //         System.out.print(students[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < houses.length; i++) {
            System.out.println(houseNames[i] + ":");
            switch (i) {
                case 0:
                    printStudents(houses[0]);
                    break;
                case 1:
                    printStudents(houses[1]);
                    break;
                case 2:
                    printStudents(houses[2]);
                    break;
                case 3:
                    printStudents(houses[3]);
                    break;
            }
        }

    }

    public static boolean isLucky(Random dice){
        return dice.nextInt(4) == 0;
    }

    public static int getAvailableRandomHouse(int[] hCounter, Random dice, String[] houseNames, int houseSize, int reducedHouseSize){

        boolean allFull = true;
        int hIndex = -1;

        for (int j = 0; j < houseNames.length; j++) {
            if (hCounter[j] < reducedHouseSize) {
                allFull = false;
                break;
            } 
        }
        if(allFull){
            do {
                hIndex = dice.nextInt(houseNames.length);  
            } while (hCounter[hIndex] >= houseSize);
        } else {
            do {
                hIndex = dice.nextInt(houseNames.length);  
            } while (hCounter[hIndex] >= reducedHouseSize);
        }

        return hIndex;

    }

    public static void printStudents(String[] house) {
        for (String student : house) {
            if (student != null) {
                System.out.printf("|    " + student + "     ");
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