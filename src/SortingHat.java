import java.util.Random;
public class SortingHat{
    static int x = 3; //disponibile a tutte le funzioni di questa classe in quanto static, utile per la scrittura di programmi procedurali
    //problema, perchè la visibilità eccessiva può portare a modifiche non volute della variabile
    //generano problemi sopratutto su programmi di grandi dimensioni


    static final String [][] STUDENTS = {
    {"Ilario Palaia","Serpeverde"},
    {"Elvis La Fata","Corvonero"}, 
    {"Regina Ghering","Serpeverde"}, 
    {"Luca Formica" , "Corvonero"}, 
    {"Davide Mazzitelli","Corvonero"}, 
    {"Piero Scarcina" ,"Grifondoro"}, 
    {"Vittorio Aquila","Corvonero"},
    {"Emanuele Giustiniani","Serpeverde"},
    {"Gaspare Maione","Grifondoro"},
    {"Camilla Marchioro","Grifondoro"},
    {"Eugenio Manganelli","Tassorosso"},
    {"Edoardo Bognanni","Corvonero"},
    {"Lorenzo Coretti","Tassorosso"},
    {"Sabrina Salerno","Tassorosso"},
    {"Marcello Coppolino","Serpeverde"},
    {"Stefano Lorato", "Grifondoro"},
    {"Nicolò Casertano", "N"},
    {"Alessio Basili","N"}};
    static String[] grifonDoro = new String [6];
    static String[] corvoNero = new String [6];
    static String[] serpeVerde = new String [6];
    static String[] tassoRosso = new String [6];
    static int numPrefetti = 4;
    static final int[] COUNTERS = {1,1,1,1};
    static final Random dice = new Random();

    public static void main(String [] args){
        //programma non prende inpur dall utente
        //dado uno su 4 , poi successivo dado su 4
        // puntini dopo nome e poi 
        //dopo che assegna deve stampare
        //alla fine stampi un report in 4 colonne che elenchi gli studenti per le case
        
        
        //4 array che rappresentano le 4 case e mano a mano inserire dentro di essi gli alunni iterando l array principale
        //lancia un dado da uno a 4 per scegliere la casa
        //siamo 22, 4 case da 6 , rischio creare 3 case da 6  e uno da 4, una soluzione impostare un limite fittizio a 5 degli array e poi successivamente mettere gli alunni restanti
        // i prefetti devono finire in quattro case separate, potremmo dedicare una prima parte del programma solo a questo
        // randomizzare l array principale tenendo conto delle loro preferenze
        

        //soluzioni array delle preferenze con i nomi delle varie case e sincronizzarlo con quello degli studenti
        // creare un array bidimensionale
        // emanuele grifondoro
        // filippo corvonero




        grifonDoro[0] = "Federico De Simone";
        corvoNero[0] = "Filippo Aresu";
        serpeVerde[0] = "Carmine Erario";
        tassoRosso[0] = "Marta Petruzzelli";
        randomizeArray2D();
        assignStudent();
        printArray();

        
        
    }
    public static void assignStudent(){
        
        //se lancio primo dado 0 assegnalo alla casata preferita else lancia altro dado
        //secondo lancio 0 g 1 s 2 c 3 t
        int lengthSubArray = grifonDoro.length-1;
        //pos 0 counter grif, 1 serp, 2 corvonero, 3 tassorosso
        int maxCounters = (lengthSubArray * 4 )- numPrefetti; //dove il -4 sta per il numero dei prefetti
        for(int i = 0; i < STUDENTS.length; i++){ //arr.length restituisce il numero delle righe
            int n = dice.nextInt(4);
            String preference = STUDENTS[i][1];
            String name = STUDENTS[i][0];
            if (maxCounters <= i){
                lengthSubArray = grifonDoro.length;
            }
            if (n == 0 && hasSpace(preference, lengthSubArray)){
                if(preference.equals("Grifondoro")){
                    grifonDoro[COUNTERS[0]] = name;
                    COUNTERS[0]++;
                }else if(preference.equals("Serpeverde")){
                    serpeVerde[COUNTERS[1]] = name;
                    COUNTERS[1]++;
                    
                }else if(preference.equals("Corvonero")){
                    corvoNero[COUNTERS[2]] = name;
                    COUNTERS[2]++;
                }else {
                    tassoRosso[COUNTERS[3]] = name;
                    COUNTERS[3]++;
                }
                System.out.println("Era destino " + name + " è stato assegnato alla sua casata preferita al primo tentativo " + preference);
            }else{
                boolean assigned = false;
                do{
                    n = dice.nextInt(4);
                    if(n==0 && COUNTERS[0] < lengthSubArray ){
                        grifonDoro[COUNTERS[0]] = name;
                        COUNTERS[0]++;
                        assigned = true;
                    } else if(n==1 && COUNTERS[1] < lengthSubArray){
                        serpeVerde[COUNTERS[1]] = name;
                        COUNTERS[1]++;
                        assigned = true;
                    } else if (n==2 && COUNTERS[2] < lengthSubArray){
                        corvoNero[COUNTERS[2]] = name;
                        COUNTERS[2]++;
                        assigned = true;
                    }else if (n==3 && COUNTERS[3] < lengthSubArray) {
                        tassoRosso[COUNTERS[3]] = name;
                        COUNTERS[3]++;
                        assigned = true;
                    }
                } while(!assigned);
            }
        }
    }
    public static void randomizeArray2D(){
        int n1;
        int n2;
        for(int i = 0;i < 100; i++){
            n1 = dice.nextInt(STUDENTS.length);
            do{
                n2 = dice.nextInt(STUDENTS.length);
            } while(n1==n2);
            String [] temp = STUDENTS[n1];
            STUDENTS[n1] = STUDENTS[n2];
            STUDENTS[n2] = temp;
        }
    }
    public static boolean hasSpace (String preference, int lengthSubArray){
        if(preference.equals("Grifondoro") && COUNTERS[0] < lengthSubArray){
            return true;
        } else if(preference.equals("Serpeverde") && COUNTERS[1] < lengthSubArray){
            return true;
        } else if(preference.equals("Corvonero") && COUNTERS[2] < lengthSubArray){
            return true;
        } else if(preference.equals("Tassorosso") && COUNTERS[3] < lengthSubArray){
            return true;
        } else {
            return false;
        }
    }
    public static void printArray(){
        String s1= "Grifondoro";
        String s2 = "Serpeverde";
        String s3 = "Corvonero";
        String s4 = "Tassorosso";
        System.out.printf("%-20s|%-20s|%-20s|%-20s%n",s1,s2,s3,s4);
        for (int i = 0; i < grifonDoro.length; i++){
            System.out.printf("%-20s|%-20s|%-20s|%-20s%n",grifonDoro[i], serpeVerde[i], corvoNero[i], tassoRosso[i]);
        }
    }
}


    
    


