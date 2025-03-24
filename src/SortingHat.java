import java.util.Random;
public class SortingHat{
    public static void main(String[] args){
        String[] students = new String[] {"Federico De Simone", "Carmine Erario","Regina Ghering", "Piero Scarcina", 
        "Camilla Marchioro","Emanuele Giustiniani", "Marcello Coppolino",
        "Eugenio Manganelli", "Davide Mazzitelli", "Ilario Palaia",
        "Gaspare Maione","Edoardo Bognanni", "Filippo Aresu",
        "Steefano Lorato","Nicolò Casertano","Sabrina Salerno",
        "Lorenzo Coretti","Vittorio Aquila","Marta Petruzzelli",
        "Luca Formica","Elvis La Fata", "Alessio Basili"};

        String[] hufflepuff = new String[6];
        String[] gryffindor = new String[6];
        String[] ravenclaw = new String[6];
        String[] slytherin= new String[6];
        Random sort = new Random();
       
        

        for(int i = 1; i < students.length; i++){
            int random = sort.nextInt(4) + 1;
            if(random == 1){
                addStudent(hufflepuff , students[i]);
            }
            else if(random == 2){
               addStudent(gryffindor , students[i]);
            }
            else if(random == 3){
               addStudent(ravenclaw , students[i]);
            }
            else if(random == 4){
               addStudent(slytherin , students[i]);
            }

        }
        gryffindor[0] = "Federico De Simone - Capo";
        hufflepuff[0] = "Marta Petruzzelli - Capo";
        slytherin[0] = "Carmine Erario - Capo";
        ravenclaw[0] = "Filippo Aresu - Capo";

        System.out.println ("---GRIFFYNDOR---");
        stampArray(gryffindor);
        System.out.println ("---HUFFLEPUFF---");
        stampArray(hufflepuff);
        System.out.println ("---SLYTHERIN---");
        stampArray(slytherin);
        System.out.println ("---REVENCLAW---");
        stampArray(ravenclaw);

    }
    public static void addStudent(String[] house, String student) {
        for (int i = 0; i < house.length; i++) {
            if (house[i] == null) {
                house[i] = student;
                break;
            }
        }
    }
    public static void stampArray(String[] casata){
        for(int i = 0; i < casata.length; i++){
            System.out.println(casata[i]);
        }
    }
     
}