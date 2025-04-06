package introduction;

import java.util.Random;

public class SortingHat {
    public static void main(String[] args) throws InterruptedException {
        String[] studentsToAssign = {"Ilario", "Elvis", "Regina",
                "Luca", "Davide", "Piero",
                "Vittorio", "Emanuele", "Gaspare", "Camilla", "Eugenio", "Edoardo", "Lorenzo", "Sabrina", "Marcello",
                "Stefano", "Nicolò", "Alessio"};
        int[] preferences = {0, 2, 0, 2, 2, 1, 2, 0, 1, 1, 3, 2, 3, 3, 0, -1, -1, -1};

        String[][] houses = new String[4][6]; // 4 case, ognuna 6 studenti

        // slytherin 0, gryff 1, raven 2, huff 3, none -1
        houses[0][0] = "Carmine";
        houses[1][0] = "Federico";
        houses[2][0] = "Filippo";
        houses[3][0] = "Marta"; // prefetti in posizione x=0 per ogni casa

        Random random = new Random(); // oggetto Random per tirare il dado
        for (int i = 0; i < studentsToAssign.length; i++) { // assegna ogni studente ad una casa
            while (true) { // all'infinito fino al break
                int houseRandom = random.nextInt(5); // dice a 5 facce, la quinta è la preferenza, aumenta la
                // probabilità da
                // 20 a 40%. genera un numero da 0 a 4
                if (houseRandom == 4) { // 4 corrisponde alla preferenza
                    if (preferences[i] == -1) { // preferenza non espressa
                        houseRandom = random.nextInt(4);
                    } else {
                        houseRandom = preferences[i];
                    }
                }
                if (!isHouseFull(houses[houseRandom])) { // controlla se la casa non è piena
                    int firstAvailableSpot = GetEmptyIndex(houses[houseRandom]);
                    houses[houseRandom][firstAvailableSpot] = studentsToAssign[i];
                    break; // fa uscire dal while perché lo studente è stato assegnato
                }
            }
        }
        for (int houseIndex = 0; houseIndex < houses.length; houseIndex++) {
            String houseName = getHouseName(houseIndex);
            System.out.println("The students in " + houseName + " are... ");
            Thread.sleep(2000);
            for (int studentIndex = 0; studentIndex < houses[houseIndex].length; studentIndex++) {
                if (houses[houseIndex][studentIndex] != null) {
                    System.out.print(houses[houseIndex][studentIndex] + " ");
                }
            }
            System.out.println();
        }

    }

    public static String getHouseName(int houseIndex) {
        if (houseIndex == 0) {
            return "Slytherin";
        }

        if (houseIndex == 1) {
            return "Gryffindor";
        }

        if (houseIndex == 2) {
            return "Ravenclaw";
        }

        if (houseIndex == 3) {
            return "Hufflepuff";
        }

        return "error";
    }

    public static Integer GetEmptyIndex(String[] array) {
        for (int i = 0; i < array.length; i++) {
            // System.out.println(array[i]);
            if (array[i] == null) {
                return i;
            }
        }
        return null;
    }

    public static boolean isHouseFull(String[] house) {
        int lastHousePlaceIndex = house.length - 1;
        if (house[lastHousePlaceIndex] == null) {
            return false;
        }
        return true;
    }
}
