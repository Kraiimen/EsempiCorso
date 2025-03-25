import java.util.Random;

public class SortingHat {
   private static int[] housepos = {2,2,2,2};
    public static void main(String[] args) {


        
        String[][] students = {
            {"Piero Scarcina", "Gryffindor"},
            {"Gaspare Maione", "Gryffindor"},
            {"Camilla Marchioro", "Gryffindor"},
            {"Elvis La Fata", "Ravenclaw"},
            {"Luca Formica", "Ravenclaw"},
            {"Davide Mazzitelli", "Ravenclaw"},
            {"Vittorio Aquila", "Ravenclaw"},
            {"Edoardo Bognanni", "Ravenclaw"},
            {"Eugenio Manganelli", "Hufflepuff"},
            {"Lorenzo Coretti", "Hufflepuff"},
            {"Sabrina Salerno", "Hufflepuff"},
            {"Ilario Palaia", "Slytherin"},
            {"Regina Ghering", "Slytherin"},
            {"Emanuele Giustiniani", "Slytherin"},
            {"Marcello Coppolino", "Slytherin"},
            {"Stefano Pio Lorato", "Gryffindor"},
            {"Nicolò Casertano", "Gryffindor"},
            {"Alessio Basili", "Ravenclaw"}
        };
        fisherYates(students);

        String[][] houses = new String[4][students.length/4 +3];
        houses[0][0] = "Gryffindor";
        houses[1][0] = "Ravenclaw";
        houses[2][0] = "Hufflepuff";
        houses[3][0] = "Slytherin";

        houses[0][1] = "Federico De simone";
        houses[1][1] = "Filippo Aresu";
        houses[2][1] = "Marta Petruzzelli";
        houses[3][1] = "Carmine Erario";

        luckyStudents(students, houses);
        testremainingStudents(students, houses);


        System.out.println("--------");

        for (int i = 0; i < houses[0].length; i++) {
            System.out.println (houses[0][i] + "     |     " + houses[1][i] + "     |     "  + houses[2][i] + "     |     " + houses[3][i]);
            
        }
    }

    public static void fisherYates(String[][] students) { 
       
        Random random = new Random();
        for(int i = students.length-1; i > 0; i--)  {
            int randomizer = random.nextInt(i+1);

            String[] temp = students[i];
            students[i] = students[randomizer];
            students[randomizer] = temp;

        }
    }


    public static void luckyStudents(String [][] students, String[][] houses) {
        Random dice4 = new Random();
    
        for(int i = 0; i < students.length; i++) {
        
            for(int j = 0; j < houses.length; j++) {
                int luck = dice4.nextInt(4);
                if(students[i][1].equals(houses[j][0]) && luck == 0 && housepos[j] < houses[j].length) {
                    houses[j][housepos[j]] = students[i][0];
                    students[i][0] = "MOVED";
                    housepos[j]++;
                }
            }
        }
    }

    //  public static void remainingStudents(String students[][], String[][] houses) 
    //     for (int i = 0; i < students.length; i++) {
    //         if(!students[i][0].equals("MOVED")) {
    //             for(int j = 0; j < houses[0].length; j++) {
    //                 if(housepos[j] < houses[j].length){

    //                     houses[j][housepos[j]] = students[i][0];
    //                     students[i][0] = "MOVED";
    //                     housepos[j]++;
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    // }

    
    public static void testremainingStudents(String students[][], String[][] houses) {
        int currentHouse = 0; 
        for (int i = 0; i < students.length; i++) {
            if (!students[i][0].equals("MOVED")) {  
                while (housepos[currentHouse] >= houses[currentHouse].length) {
                    currentHouse += 1 % 4; //il % 4 mi serve a non passare oltre il limite delle current house
                }
                houses[currentHouse][housepos[currentHouse]] = students[i][0];
                students[i][0] = "MOVED";
                housepos[currentHouse]++;  
                currentHouse = (currentHouse + 1) % 4;  
            }
        }
    }
    
    
    




}