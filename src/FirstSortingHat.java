import java.util.Random;
public class FirstSortingHat{
    public static void main(String[] args){

        String[] Gryffindor = new String[6];
        String[] Slytherin = new String[6];
        String[] Ravenclaw = new String[6];
        String[] Hufflepuff = new String[6];
        
        Gryffindor[0] = "Federico De Simone";
        Slytherin[0] = "Carmine Erario";
        Ravenclaw[0] = "Filippo Aresu";
        Hufflepuff[0] = "Marta Petruzzelli";

        int grCounter = 1;
        int slCounter = 1;
        int raCounter = 1;
        int huCounter = 1;


        String[][] students = { {"Ilario Palaia" , "Slytherin"},
                                {"Elvis La Fata" , "Ravenclaw"},
                                {"Regina Ghering" , "Slytherin"},
                                {"Luca Formica" , "Ravenclaw"},
                                {"Davide Mazzitelli" , "Ravenclaw"},
                                {"Piero Scarcina" , "Gryffindor"},
                                {"Vittorio Aquila" , "Ravenclaw"},
                                {"Emanuele Giustiniani" , "Slytherin"},
                                {"Gaspare Maione" , "Gryffindor"},
                                {"Camilla Marchioro" , "Gryffindor"},
                                {"Eugenio Manganelli" , "Hufflepuff"},
                                {"Edoardo Bognanni" , "Ravenclaw"},
                                {"Lorenzo Coretti" , "Hufflepuff"},
                                {"Sabrina Salerno" , "Hufflepuff"},
                                {"Marcello Coppolino" , "Slytherin"},
                                {"Nicolò Casertano" , "Gryffindor"},
                                {"Stefano Lorato" , "Gryffindor"},
                                {"Alessio Basili" , "No preference"},
                            };


        //devo randomizzare l'ordine degli studenti, faccio un giro di scambi
        // for(int i = 0 ; i < students.length ; i++){
        //     Random dice = new Random();
        //     int n = dice.nextInt(students.length);
        //     String temp1 = students[i][0];
        //     String temp2 = students[i][1];
        //     students[i][0] = students[n][0];
        //     students[i][1] = students[n][1];
        //     students[n][0] = temp1;
        //     students[n][1] = temp2;
        // }

        randomize(students);



        for(int i = 0 ; i < 16 ; i++){
            String houseSorted = sortInHouse(students[i][1]);

            if(houseSorted.equals("Gryffindor") && (grCounter < (Gryffindor.length - 1))){
                Gryffindor[grCounter] = students[i][0];
                grCounter++;
                System.out.println(students[i][0] + "..." + houseSorted);
            } else if(houseSorted.equals("Slytherin") && (slCounter < (Slytherin.length -1))){
                Slytherin[slCounter] = students[i][0];
                slCounter++;
                System.out.println(students[i][0] + "..." + houseSorted);
            } else if(houseSorted.equals("Ravenclaw") && (raCounter < (Ravenclaw.length-1))){
                Ravenclaw[raCounter] = students[i][0];
                raCounter++;
                System.out.println(students[i][0] + "..." + houseSorted);
            } else if(houseSorted.equals("Hufflepuff") && (huCounter < (Hufflepuff.length-1))){
                Hufflepuff[huCounter] = students[i][0];
                huCounter ++;
                System.out.println(students[i][0] + "..." + houseSorted);
            } else{
                i--;
            };
        }

        for(int i = 16 ; i < students.length ; i++){
            String houseSorted = sortInHouse(students[i][1]);

            if(houseSorted.equals("Gryffindor") && (grCounter < Gryffindor.length)){
                Gryffindor[grCounter] = students[i][0];
                grCounter++;
                System.out.println(students[i][0] + "..." + houseSorted);
            } else if(houseSorted.equals("Slytherin") && (slCounter < Slytherin.length)){
                Slytherin[slCounter] = students[i][0];
                slCounter++;
                System.out.println(students[i][0] + "..." + houseSorted);
            } else if(houseSorted.equals("Ravenclaw") && (raCounter < Ravenclaw.length)){
                Ravenclaw[raCounter] = students[i][0];
                raCounter++;
                System.out.println(students[i][0] + "..." + houseSorted);
            } else if(houseSorted.equals("Hufflepuff") && (huCounter < Hufflepuff.length)){
                Hufflepuff[huCounter] = students[i][0];
                huCounter ++;
                System.out.println(students[i][0] + "..." + houseSorted);
            } else{
                i--;
            };
        }
        
        System.out.println("Gli studenti di Grifondoro sono:");
        for(int j = 0 ; j < Gryffindor.length ; j++){
            System.out.println(Gryffindor[j]);
        }

        System.out.println("Gli studenti di Serpeverde sono:");
        for(int j = 0 ; j < Slytherin.length ; j++){
            System.out.println(Slytherin[j]);
        }

        System.out.println("Gli studenti di Corvonero sono:");
        for(int j = 0 ; j < Ravenclaw.length ; j++){
            System.out.println(Ravenclaw[j]);
        }

        System.out.println("Gli studenti di Tassorosso sono:");
        for(int j = 0 ; j < Hufflepuff.length ; j++){
            System.out.println(Hufflepuff[j]);
        }
    }

    public static String sortInHouse(String preference){
        Random dice = new Random();
        int x = dice.nextInt(4);
        String houseSorted = "Not sorted";
        if(!preference.equals("No preference") && x == 0){
            houseSorted = preference;
        } else{
            x = dice.nextInt(4);
            if(x == 0){
                houseSorted = "Gryffindor";
            } else if(x == 1){
                houseSorted = "Slytherin";
            } else if(x == 2){
                houseSorted = "Ravenclaw";
            } else{
                houseSorted = "Hufflepuff";
            }
        }
        return houseSorted;
    }

    public static void randomize(String[][] arr){
        String temp1 = " ";
        String temp2 = " ";
        int j = 0;
        int z = 1;
        for(int i = 0 ; i < arr.length ; i++){
                Random dice = new Random();
                int n = dice.nextInt(arr.length);
                temp1 = arr[i][j];
                temp2 = arr[i][z];
                arr[i][j] = arr[n][j];
                arr[i][z] = arr[n][z];
                arr[n][j] = temp1;
                arr[n][z] = temp2;
        }
    }
    
    
}