package excercises;

import java.util.Random;

//FUNZIONA MA MANCA IL CONTROLLO PER LE DUE CASE CHE AVRANNO UNA PERSONA IN PIU'

public class SortingHat {
    public static void main(String[] args) {
        
        // Case con prefetti prestabiliti
        String gryffindor[] = {"Federico De Simone", null, null, null, null, null};
        String slytherin[] = {"Carmine Erario", null, null, null, null, null};
        String ravenclaw[] = {"Filippo Aresu", null, null, null, null, null};
        String hufflepuff[] = {"Marta Petruzzelli", null, null, null, null, null};

        // Contatori/Indici per gli array delle case
        int iG = 1, iS = 1, iR = 1, iH = 1;

        // Array degli studenti con Nome, Preferenza
        String students[][] = {
            {"Ilario Vasco Palaia","Slytherin"},
            {"Elvis La fata","Ravenclaw"},
            {"Regina Ghering","Slytherin"},
            {"Luca Formica","Ravenclaw"},
            {"Davide Mazzitelli","Ravenclaw"},
            {"Piero Scarcina","Gryffindor"},
            {"Vittorio Aquila","Ravenclaw"},
            {"Emanuele Giustiniani","Slytherin"},
            {"Gaspare Maione","Gryffindor"},
            {"Camilla Marchioro","Gryffindor"},
            {"Eugenio Manganelli","Hufflepuff"},
            {"Edoardo Bognanni","Ravenclaw"},
            {"Lorenzo Coretti","Hufflepuff"},
            {"Sabrina Salerno","Hufflepuff"},
            {"Marcello Coppolino","Slytherin"},
            {"Stefano Pio Lorato",null},
            {"Nicolo Casertano",null},
            {"Alessio Basili",null}
        };
        
        while (!isStudentsEmpty(students)) {
            for(int i = 0; i < students.length; i++){
                

                int randomStudent = 0;
                
                do{
                    randomStudent = getRandomStudent();
                } while (students[randomStudent] == null);

                int randomHouse = getRandomHouse();
                
                // Se lo studente è fortunato, controlliamo se la sua casa preferita è libera
                if (checkChance() && students[randomStudent][1] != null) {
                    String preferredHouse = students[randomStudent][1];
                    
                    if(preferredHouse.equals("Gryffindor")){
                        iG = checkHouseStudentsNumber(gryffindor);
                        
                        if (iG != 6) {
                            gryffindor[iG] = students[randomStudent][0];
                            students[randomStudent][0] = null;
                        }
                    }
                    else if(preferredHouse.equals("Slytherin")){
                    iS = checkHouseStudentsNumber(slytherin);
                        if (iS != 6) {
                            slytherin[iS] = students[randomStudent][0];
                            students[randomStudent][0] = null;
                        }
                    }
                    else if(preferredHouse.equals("Ravenclaw")){
                        iR = checkHouseStudentsNumber(ravenclaw);
                        if (iR != 6) {
                            ravenclaw[iR] = students[randomStudent][0];
                            students[randomStudent][0] = null;
                        }
                    }
                    else {
                        iH = checkHouseStudentsNumber(hufflepuff);
                        if (iH != 6) {
                            hufflepuff[iH] = students[randomStudent][0];
                            students[randomStudent][0] = null;
                        }
                    }
                }
                else {
                    String house = getHouseName(randomHouse);
                    if(house.equals("Gryffindor")){
                        iG = checkHouseStudentsNumber(gryffindor);
                        
                        if (iG != 6) {
                            gryffindor[iG] = students[randomStudent][0];
                            students[randomStudent][0] = null;
                        }
                    }
                    else if(house.equals("Slytherin")){
                        iS = checkHouseStudentsNumber(slytherin);

                        if (iS != 6) {
                            slytherin[iS] = students[randomStudent][0];
                            students[randomStudent][0] = null;
                        }
                    }
                    else if(house.equals("Ravenclaw")){
                        iR = checkHouseStudentsNumber(ravenclaw);
                        if (iR != 6) {
                            ravenclaw[iR] = students[randomStudent][0];
                            students[randomStudent][0] = null;
                        }
                    }
                    else {
                        iH = checkHouseStudentsNumber(hufflepuff);
                        if (iH != 6) {
                            hufflepuff[iH] = students[randomStudent][0];
                            students[randomStudent][0] = null;
                        }
                    }
                }         
            }
        }


        // STAMPE
        System.out.println("\nGryffindor: ");
        for (int j = 0; j < gryffindor.length; j++) {
            if (gryffindor[j] != null)
                System.out.println("- "+gryffindor[j]);
        }
        System.out.println("\nSlytherin: ");
        for (int j = 0; j < slytherin.length; j++) {
            if (slytherin[j] != null)
                System.out.println("- "+slytherin[j]);
        }
        System.out.println("\nRavenclaw: ");
        for (int j = 0; j < ravenclaw.length; j++) {
            if (ravenclaw[j] != null)
                System.out.println("- "+ravenclaw[j]);
        }
        System.out.println("\nHufflepuff: ");
        for (int j = 0; j < hufflepuff.length; j++) {
            if (hufflepuff[j] != null)
                System.out.println("- "+hufflepuff[j]);
        } 
    }

    /* ----------------- METODI DOPO IL MAIN ----------------- */

    // Metodo per estrarre studente casuale
    public static int getRandomStudent(){
        Random random = new Random();

        return random.nextInt(18);
    }

    // Metodo per calcolare probabilità della casa
    public static int getRandomHouse(){
        Random random = new Random();

        return random.nextInt(5);
    }

    // Se il metodo ritorna true, valutiamo la preferenza come possibiltà
    public static boolean checkChance(){
        int numberToGet = getRandomHouse();
        int chance = getRandomHouse();

        if(chance == numberToGet){
            return true;
        }

        return false;
    }

    public static int checkHouseStudentsNumber(String arr[]){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == null){
                return i;
            }
        }

        return 6;
    }

    public static String getHouseName(int n){
        String str = null;

        if (n == 0) {
            str = "Gryffindor";
        }
        else if (n == 1){
            str = "Slytherin";
        } 
        else if (n == 2){
            str = "Ravenclaw";
        }
        else {
            str = "Hufflepuff";
        }

        return str;
    }

    public static boolean isStudentsEmpty(String arr[][]){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][0] != null) {
                return false;
            }
        }

        return true;
    }
}
