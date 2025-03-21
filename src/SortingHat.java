import java.util.Random;
import java.io.Console;

public class SortingHat {

    //funzione per mandare in output una grafica delle case
    public static void outputHouses(String[] gryffindor, String[] slytherin, String[] ravenclaw, String[] hufflepuff){
        System.out.printf("%-15s  %-15s  %-15s  %-15s %n","Gryffindor:","Slytherin:","Ravenclaw:","Hufflepuff:");
        for(int i=0; i<6; i++){
            System.out.printf("%-15s  %-15s  %-15s  %-15s %n",(gryffindor[i]),(slytherin[i]),(ravenclaw[i]),(hufflepuff[i]));
        }
    }

    public static int freeSpace(String[] array){
        for(int i=1; i<6; i++){
            if(array[i]==null){
                return i;
            }
        }
        return 0;
    }
    public static void outHat(){
        System.out.println("            .\n"+
                        "           /:\\\r\n" + 
                        "          /;:.\\\r\n" + 
                        "         //;:. \\     \r\n" + 
                        "        ///;:.. \\\r\n" + 
                        "  __--\"////;:... \\\"--__\r\n" + 
                        "--__   \"--_____--\"   __--\r\n" + 
                        "    \"\"\"--_______--\"\"\"\r\n" + 
                        "");
    }




    public static void main(String[] args) {
        outHat();
        String[] gryffindor = new String[6];
        String[] slytherin = new String[6];
        String[] ravenclaw = new String[6];
        String[] hufflepuff = new String[6];
        String[][] students = {{"Carmine","Slytherin"},{"Filippo","Ravenclaw"},{"Marta","Hufflepuff"},{"Federico","Gryffindor"},{"Emanuele",null},{"Alessio",null},{"Camilla",null},{"Davide",null}
        ,{"Edoardo",null},{"Elvis",null},{"Eugenio",null},{"Gaspare",null},{"Ilario",null},{"Lorenzo",null},{"Luca",null},{"Marcello",null},{"Nicolò",null},{"Piero",null},{"Regina",null}
        ,{"Sabrina",null},{"Stefano",null},{"Vittorio",null}};

        Random r = new Random(); //creazione oggetto random
        int randomNumber=0;      //variabile che conterrà il numero casuale
        Console console = System.console();        //oggetto per l'input
        boolean choice = false;
        String preference;
        int pref;
        boolean inHouse = false;
        int freeIndex;
        int randomHouse;
        int lastStudents = 2;
        int firstPhaseStudents=students.length-lastStudents;

        
        //assegnazione dei prefetti
        gryffindor[0]= students[3][0];
        slytherin[0]= students[0][0];
        ravenclaw[0]= students[1][0];
        hufflepuff[0]= students[2][0];
        
        //stampa delle case con i prefetti appena inseriti
        System.out.println("I PREFETTI SONO STATI ASSEGNATI ALLE 4 CASE!\n");
        outputHouses(gryffindor, slytherin, ravenclaw, hufflepuff);


        //ciclo scelta
        for(int i=4; i<firstPhaseStudents; i++){
            System.out.println("CHE VENGA IL PROSSIMO!");
            //se è già stato scelto lo studente
            while(!choice){                             
                randomNumber = r.nextInt(4,firstPhaseStudents);
                if(students[randomNumber][1]==null){
                    choice=true;
                }
            }
            choice=false; //studente scelto non presente nelle casate


            //scelta preferenza
            System.out.println(students[randomNumber][0]+"!   VIENI PURE!");
            System.out.println("Dove ti piacerebbe andare?");
            System.out.println("Gryffindor: 0\t Slytherin: 1\t Ravenclaw: 2\t Hufflepuff: 3\t");
            preference = console.readLine();
            pref = Integer.parseInt(preference);

            //ciclo per vedere se lo studente è da inserire o meno nella casa scelta, se esce 1 allora s'inserisce nella casa che ha scelto, altrimenti una a caso
            randomHouse = r.nextInt(4);
            if(randomHouse!=1){
                pref = r.nextInt(4);                  //ritira il dado
            }
            while(!inHouse){
                //serie di if per controllare la preferenza scelta e se possibile inserirlo all'interno della casata
                if(pref==0 && gryffindor[gryffindor.length-lastStudents]==null){
                    freeIndex = freeSpace(gryffindor);
                    if(freeIndex!=0){
                        gryffindor[freeIndex] = students[randomNumber][0];   //dentro lo spazio libero inserisce lo studente
                        students[randomNumber][1] = "Gryffindor";
                        inHouse=true;
                    }
                }
                if(pref==1 && slytherin[slytherin.length-lastStudents]==null){
                    freeIndex = freeSpace(slytherin);
                    if(freeIndex!=0){
                        slytherin[freeIndex] = students[randomNumber][0];   //dentro lo spazio libero inserisce lo studente
                        students[randomNumber][1] = "Slytherin";
                        inHouse=true;
                    }
                }
                if(pref==2 && ravenclaw[ravenclaw.length-lastStudents]==null){
                    freeIndex = freeSpace(ravenclaw);
                    if(freeIndex!=0){
                        ravenclaw[freeIndex] = students[randomNumber][0];   //dentro lo spazio libero inserisce lo studente
                        students[randomNumber][1] = "Ravenclaw";
                        inHouse=true;
                    }
                }
                if(pref==3 && hufflepuff[hufflepuff.length-lastStudents]==null){
                    freeIndex = freeSpace(hufflepuff);
                    if(freeIndex!=0){
                        hufflepuff[freeIndex] = students[randomNumber][0];   //dentro lo spazio libero inserisce lo studente
                        students[randomNumber][1] = "Hufflepuff";
                        inHouse=true;
                    }
                }
                pref = r.nextInt(4);
            }
            inHouse=false;
            System.out.println();
            System.out.println((students[randomNumber][1])+"!!!!!!!!!!!!!!!"+"\n");
        }

        //ultimi due
        for(int i=0; i<lastStudents; i++){
            System.out.println("\n"+students[firstPhaseStudents+i][0]+"!   VIENI PURE!");
            System.out.println("Dove ti piacerebbe andare?");
            System.out.println("Gryffindor: 0\t Slytherin: 1\t Ravenclaw: 2\t Hufflepuff: 3\t");
            preference = console.readLine();
            pref = Integer.parseInt(preference);

            //ciclo per vedere se lo studente è da inserire o meno nella casa scelta, se esce 1 allora s'inserisce nella casa che ha scelto, altrimenti una a caso
            randomHouse = r.nextInt(4);
            if(randomHouse!=1){
            pref = r.nextInt(4);                  //ritira il dado
            }
            while(!inHouse){
                if(pref==0 && gryffindor[gryffindor.length-1]==null){
                    students[firstPhaseStudents+i][1] = "Gryffindor";
                    gryffindor[gryffindor.length-1] = students[firstPhaseStudents+i][0];
                    inHouse=true;
                }
                if(pref==1 && slytherin[slytherin.length-1]==null){
                    students[firstPhaseStudents+i][1] = "Slytherin";
                    slytherin[slytherin.length-1] = students[firstPhaseStudents+i][0];
                    inHouse=true;
                }
                if(pref==2 && ravenclaw[ravenclaw.length-1]==null){
                    students[firstPhaseStudents+i][1] = "Ravenclaw";
                    ravenclaw[ravenclaw.length-1] = students[firstPhaseStudents+i][0];
                    inHouse=true;
                }
                if(pref==3 && hufflepuff[hufflepuff.length-1]==null){
                    students[firstPhaseStudents+i][1] = "Hufflepuff";
                    hufflepuff[hufflepuff.length-1] = students[firstPhaseStudents+i][0];
                    inHouse=true;
                }
                pref=r.nextInt(4);
            }
            inHouse=false;
            System.out.println();
            System.out.println((students[firstPhaseStudents+i][1])+"!!!!!!!!!!!!!!!"+"\n");
        } 
        outHat();
        System.out.println("\n");
        outputHouses(gryffindor, slytherin, ravenclaw, hufflepuff);
    }
}
    



















