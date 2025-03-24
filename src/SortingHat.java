import java.util.Random;

public class SortingHat {
    //questo metodo serve solamente a far scrivere il discorso del cappello
    public static void sortingHatSpeach() throws InterruptedException{
        System.out.println("Forse pensate che non son bello,");
        Thread.sleep(500);
        System.out.println("ma non giudicate da quel che vedete");
        Thread.sleep(500);
        System.out.println("io ve lo giuro che mi scappello");
        Thread.sleep(500);
        System.out.println("se uno più bello ne troverete.");
        Thread.sleep(500);
        System.out.println("Potete tenervi le vostre bombette");
        Thread.sleep(500);
        System.out.println("i vostri cilindri lucidi e alteri,");
        Thread.sleep(500);
        System.out.println("son io quello che al posto vi mette");
        Thread.sleep(500);
        System.out.println("e al mio confronto gli altri son zeri.");
        Thread.sleep(500);
        System.out.println("Non c'è pensiero che nascondiate");
        Thread.sleep(500);
        System.out.println("che il mio potere non sappia vedere,");
        Thread.sleep(500);
        System.out.println("quindi indossatemi ed ascoltate");
        Thread.sleep(500);
        System.out.println("qual è la casa in cui rimanere.");
        Thread.sleep(500);
        System.out.println("È forse Grifondoro la vostra via,");
        Thread.sleep(500);
        System.out.println("culla dei coraggiosi di cuore:");
        Thread.sleep(500);
        System.out.println("audacia, fegato, cavalleria");
        Thread.sleep(500);
        System.out.println("fan di quel luogo uno splendore.");
        Thread.sleep(500);
        System.out.println("O forse è a Tassorosso la vostra vita,");
        Thread.sleep(500);
        System.out.println("dove chi alberga è giusto e leale:");
        Thread.sleep(500);
        System.out.println("qui la pazienza regna infinita");
        Thread.sleep(500);
        System.out.println("e il duro lavoro non è innaturale.");
        Thread.sleep(500);
        System.out.println("Oppure Corvonero, il vecchio e il saggio,");
        Thread.sleep(500);
        System.out.println("se siete svegli e pronti di mente,");
        Thread.sleep(500);
        System.out.println("ragione e sapienza qui trovan linguaggio");
        Thread.sleep(500);
        System.out.println("che si confà a simile gente.");
        Thread.sleep(500);
        System.out.println("O forse a Serpeverde, ragazzi miei,");
        Thread.sleep(500);
        System.out.println("oi troverete gli amici migliori");
        Thread.sleep(500);
        System.out.println("quei tipi astuti e affatto babbei");
        Thread.sleep(500);
        System.out.println("che qui raggiungono fini ed onori!");
        Thread.sleep(500);
        System.out.println("Venite dunque senza paure");
        Thread.sleep(500);
        System.out.println("E mettetemi in capo all'istante");
        Thread.sleep(500);
        System.out.println("Con me sarete in mani sicure");
        Thread.sleep(500);
        System.out.println("Perché io sono un Cappello Parlante!");
        Thread.sleep(500);
        
    }
    // questo metodo serve solamente a trasformare la casa da un numero identificativo a un effettivo valore leggibile dal utente
    public static String announce(int s) {
        switch (s) {
            case 1: return "\033[33m"+"Grifondoro!"+"\033[0m";
            case 2: return "\033[31m"+"Tassorosso!"+"\033[0m";
            case 3: return "\033[34m"+"Corvonero!"+"\033[0m";
            case 4: return "\033[32m"+"Serpeverde!"+"\033[0m";
            default: return "Errore";
        }
    }
    // genera un id della casa randomico tra 1 e 4
    public static int getRandomHouse(Random dice) {
        return dice.nextInt(4) + 1;  // randomizza la casa scelta
    }
    // questo metodo assegna la casa avendo in imput il valore identificativo della casa e tutti i dati sulle varie case
    public static boolean assignHouse(String name, int house, String[] grifondoro, int[] grifCont,String[] tassorosso, int[] tassCount, String[] corvonero, int[] corvCount, String[] serpeverde, int[] serpCount) {
        int g = grifCont[0], t = tassCount[0], c = corvCount[0], s = serpCount[0];// trasporto il numero di membri delle casate in delle varibili anziché degli array
        boolean hasFour = (g == 4 || t == 4 || c == 4 || s == 4); // controllo se tra le varie case ce ne sono con 4 membri

    switch (house) {
        /*
         *  controlla se la casata ha posto, e se (non ci sono casate da 4 o se la casata stessa è quasi piena) se tutto ciò passa
         *  controlla se la casa è piena per ovvi motivi
         *  controlla se ci sono casate da 4, per evitare di avere casate da 6 se ci sono ancora casate da 4 per avere una disposizione più uniforme
         *  infine controlla se la csa stessa è a 4 per cercare di avere prima tutte case da 4 poi da 5 e infine a 6
        */
        case 1: if (g < 6 && (!hasFour || g < 5)) { 
            grifondoro[g++] = name; 
            grifCont[0] = g; return true; 
        } break; 
        case 2: if (t < 6 && (!hasFour || t < 5)) { 
            tassorosso[t++] = name; 
            tassCount[0] = t; return true; 
        } break;
        case 3: if (c < 6 && (!hasFour || c < 5)) { 
            corvonero[c++] = name; 
            corvCount[0] = c; return true; 
        } break;
        case 4: if (s < 6 && (!hasFour || s < 5)) { 
            serpeverde[s++] = name; 
            serpCount[0] = s; return true; 
        } break;
    }
    return false; // non c'è spazzio nella casa
    }
    // questo metodo serve per printare la lista delle case 
    public static void anounceHouseLenght(String[] grifNames ,String[] tassoNames, String[] corvoNames, String[] serpeNames, int longestName){
        int rows = Math.max(Math.max(grifNames.length, tassoNames.length), Math.max(corvoNames.length, serpeNames.length));
        System.out.printf("%-30s %-30s %-30s %-30s%n ", "\033[33m"+"Grifondoro"+"\033[0m","\033[31m"+"Tasso Rosso"+"\033[0m","\033[34m"+"Corvo nero"+"\033[0m","\033[32m"+"Serpe verde"+"\033[0m");
        System.out.println();
        for (int i = 0; i < rows; i++) {
            String colGrif = (i<grifNames.length)? grifNames[i]:"";
            String colTass = (i<tassoNames.length)? tassoNames[i]:"";
            String colCorv = (i<corvoNames.length)? corvoNames[i]:"";
            String colSerp = (i<serpeNames.length)? serpeNames[i]:"";
            colGrif = colGrif==null ? "---" : colGrif;
            colTass = colTass==null ? "---" : colTass;
            colCorv = colCorv==null ? "---" : colCorv;
            colSerp = colSerp==null ? "---" : colSerp;
            
            System.out.printf("%-30s %-30s %-30s %-30s%n", 
            "\033[33m"+colGrif+"\033[0m",
            "\033[31m"+colTass+"\033[0m",
            "\033[34m"+colCorv+"\033[0m",
            "\033[32m"+colSerp+"\033[0m");
        }
    }
    
    public static int getLongestInArray (String[] sentences){
        String maxLeng = "";
        for(int i =0; i<sentences.length;i++){
            if(maxLeng.length()<sentences[i].length()){
                maxLeng = sentences[i];
            }
        }
        return maxLeng.length();
    }
    public static void main(String[] args )throws InterruptedException {
        System.out.println("\033[0m"); // resetto il colore del testo
        String[] hat = {
            "\033[2m"+"\033[33m"+"        _____",
            "\033[2m"+"\033[33m"+"       /     \\",
            "\033[2m"+"\033[33m"+"      /       \\",
            "\033[2m"+"\033[33m"+"     /         \\",
            "\033[2m"+"\033[33m"+"    /           \\",
            "\033[2m"+"\033[33m"+"   /  /\\     /\\  \\",
            "\033[2m"+"\033[33m"+"  /  /  \\   /  \\  \\",
            "\033[2m"+"\033[33m"+" /__/____\\_/____\\__\\"+"\033[0m",
        }; 
        
        for (String line : hat) {
            System.out.println(line);
        }// printo un immaginina del cappello parlante
        sortingHatSpeach(); //richiamo la funzione che printa il discorso del cappello parlante
        String[] names = new String[]{"Alessio Basili","Camilla Marchioro","Davide Mazzitelli","Edoardo Bognanni","Elvis La fata","Emanuele Giusiniani","Eugenio Manganelli","Gaspare Maione","Ilario Vasco Palaia","lorenzo Coretti","Luca Formica","Marcello Coppolino","Nicolò Casertano","Piero Scarcina","Regina Ghering","Sabrina Salrno","Stefano Pio Lorato","Vittorio Aquila" };
        int[] preferences = new int[]{
            0, // Alessio Basili (nessuna preferenza)
            1, // Camilla Marchioro (Grifondoro)
            3, // Davide Mazzitelli (Corvonero)
            3, // Edoardo Bognanni (Corvonero)
            3, // Elvis La Fata (Corvonero)
            4, // Emanuele Giusiniani (Serpeverde)
            2, // Eugenio Manganelli (Tassorosso)
            1, // Gaspare Maione (Grifondoro)
            4, // Ilario Vasco Palaia (Serpeverde)
            2, // Lorenzo Coretti (Tassorosso)
            3, // Luca Formica (Corvonero)
            4, // Marcello Coppolino (Serpeverde)
            0, // Nicolò Casertano (nessuna preferenza)
            1, // Piero Scarcina (Grifondoro)
            4, // Regina Ghering (Serpeverde)
            2, // Sabrina Salrno (Tassorosso)
            1, // Stefano Pio Lorato (Grifondoro)
            3  // Vittorio Aquila (Corvonero)
        };
        String[] grifondoro = new String[6]; //array che contiene i nomi di chi appartiene a questa casata
        int[] grifCont = {1}; //array che contiene una sola casella, che contiene il numero di membri della casata
        grifondoro[0] = "Federico De simone"; // faccio in modo che il primo membro della casata è il prefetto
        String[] tassorosso = new String[6];
        int[] tassCount = {1};
        tassorosso[0] = "Marta Petruzzelli";
        String[] corvonero = new String[6];
        int[] corvCount = {1};
        corvonero[0] ="Filippo Aresu";
        String[] serpeverde = new String[6];
        int[] serpCount = {1};
        serpeverde[0] = "Carmine Erario";
        Random dice = new Random(); // mi dichiaro il dado per le varie implementazioni del random nel main
        
        Thread.sleep(1000); // aspetto 1 secondo prima di dichiarare i sorteggi dopo che il cappello finisce di fare il suo discorso
        for (int i = 0; i < names.length; i++) { //scrollo gli array nomi e preferenze
            int house; // questa variabile prenderà il valore della casata in cui lo studente di i verrà inserito
            if (dice.nextInt(5) + 1 == 5) {  // 20% chance che il capello ti dia il beneficio del dubbio
                house = preferences[i] != 0 ? preferences[i] : getRandomHouse(dice); // se lo studente ha una preferenza do la sua preferenza come casata, sennò richiamo il metodo randomhouse
            } else {  // se non riceve la benedizzione del cappello, viene sorteggiato a random
                house = getRandomHouse(dice);
            }

            // controllo che la casa sia effettivamente NON piena passando il valore della casa in cui dovrebbe andare, gli array di ogni casa non sapendo in quale sarebbe andato, e il numero di studenti già presenti nelle case
            while (!assignHouse(names[i], house, grifondoro, grifCont, tassorosso, tassCount, corvonero, corvCount, serpeverde, serpCount)) { 
                house = getRandomHouse(dice);
            }
            // qui sotto viene printato il risultato del sorteggio con un delay per evitare che vengano detti tutti insieme
            System.out.println("Oh... " + names[i] + " hmm.... dove metterti.... ");
            Thread.sleep(1000);
            System.out.println(announce(house));
            Thread.sleep(1000);


        }
        // qui sotto printa i valori delle case e poi resetta il colore del testo
        Thread.sleep(2000);
        System.out.println();
        anounceHouseLenght(grifondoro,tassorosso,corvonero,serpeverde, getLongestInArray(names) );
        System.out.println("\033[0m");
    }
}
