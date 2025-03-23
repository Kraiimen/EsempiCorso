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

    public static int freeSpace(String[] array){    //funzione per controllare se è disponibile una posizione all'interno della casa
        for(int i=1; i<array.length; i++){
            if(array[i]==null){
                return i;
            }
        }
        return 0;
    }
    public static void outputTextLine(String s){   //funzione per stampare carattere per carattere una stringa
        for(int i=0; i<s.length(); i++){
            System.out.print(s.charAt(i));
            delay();
        }
        System.out.println();
    }

    public static void delay(){                   //funzione utilizzata per inserire un tempo di attesa nella stampa dei caratteri di outputTextLine
        try{
            Thread.sleep(50);                     //attende 50 millisecondi
        }catch(InterruptedException e){

        }
    }
    public static void outHat(){                                      //funzione per stampare il cappello magico
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
        int addSize = 0;
        int addStudentsSize = 0;
        boolean correctInput = false;

        //assegnazione dei prefetti
        gryffindor[0]= students[3][0];
        slytherin[0]= students[0][0];
        ravenclaw[0]= students[1][0];
        hufflepuff[0]= students[2][0];
        
        outputTextLine("I PREFETTI SONO STATI ASSEGNATI ALLE 4 CASE!");

        //ciclo scelta
        for(int i=4; i<firstPhaseStudents+addStudentsSize; i++){
            outputTextLine("CHE VENGA IL PROSSIMO!");
            //se è già stato scelto lo studente
            while(!choice){                             
                randomNumber = r.nextInt(4,firstPhaseStudents+addStudentsSize);
                if(students[randomNumber][1]==null){
                    choice=true;
                }
            }
            choice=false; //studente scelto non presente nelle casate

            //scelta preferenza
            outputTextLine(students[randomNumber][0]+"! VIENI PURE!");
            System.out.println("Dove ti piacerebbe andare?");
            do{ //chiede un input tra 0,1,2,3
                System.out.println("Gryffindor: 0\t Slytherin: 1\t Ravenclaw: 2\t Hufflepuff: 3\t");
                preference = console.readLine();
                if(preference.equals("0") || preference.equals("1") || preference.equals("2") || preference.equals("3")){         //se l'input è diverso da 0,1,2,3 il ciclo si ripete, altrimenti finisce impostando correctInput a true
                    correctInput=true;
                }
            }while(!correctInput);
            correctInput=false; //assegna false per verificare l'input nella prossima iterazione

            pref = Integer.parseInt(preference);//prende l'input e lo inserisce in pref

            //ciclo per vedere se lo studente è da inserire o meno nella casa scelta, se esce 1 allora s'inserisce nella casa che ha scelto, altrimenti una a caso
            randomHouse = r.nextInt(4);
            if(randomHouse!=1){
                pref = r.nextInt(4);                  //ritira il dado
            }
            while(!inHouse){
                //serie di if per controllare la preferenza scelta e se possibile inserirlo all'interno della casata
                if(pref==0 && gryffindor[gryffindor.length-lastStudents+addSize]==null){
                    freeIndex = freeSpace(gryffindor);
                    if(freeIndex!=0){
                        gryffindor[freeIndex] = students[randomNumber][0];   //dentro lo spazio libero inserisce lo studente
                        students[randomNumber][1] = "Gryffindor";
                        inHouse=true;
                    }
                }
                if(pref==1 && slytherin[slytherin.length-lastStudents+addSize]==null){
                    freeIndex = freeSpace(slytherin);
                    if(freeIndex!=0){
                        slytherin[freeIndex] = students[randomNumber][0];   
                        students[randomNumber][1] = "Slytherin";
                        inHouse=true;
                    }
                }
                if(pref==2 && ravenclaw[ravenclaw.length-lastStudents+addSize]==null){
                    freeIndex = freeSpace(ravenclaw);
                    if(freeIndex!=0){
                        ravenclaw[freeIndex] = students[randomNumber][0];   
                        students[randomNumber][1] = "Ravenclaw";
                        inHouse=true;
                    }
                }
                if(pref==3 && hufflepuff[hufflepuff.length-lastStudents+addSize]==null){
                    freeIndex = freeSpace(hufflepuff);
                    if(freeIndex!=0){
                        hufflepuff[freeIndex] = students[randomNumber][0];   
                        students[randomNumber][1] = "Hufflepuff";
                        inHouse=true;
                    }
                }
                pref = r.nextInt(4);
            }
            //aggiunge iterazioni al for in base al numero di studenti ancora da assegnare, quando le case sono a pari numero di studenti
            if(i==firstPhaseStudents-1){
                addSize++;
                addStudentsSize=lastStudents;
            }
            inHouse=false;
            System.out.println();
            outputTextLine("Benvenuto in "+(students[randomNumber][1])+"!");
        }
        //stampa finale del cappello + la lista delle case
        outHat();
        System.out.println("\n");
        outputHouses(gryffindor, slytherin, ravenclaw, hufflepuff);
    }
}