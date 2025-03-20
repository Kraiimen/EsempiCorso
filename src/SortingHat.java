import java.util.Random;

public class SortingHat {
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
    public static String announce(int s) {
        switch (s) {
            case 1: return "Grifondoro!";
            case 2: return "Tassorosso!";
            case 3: return "Corvonero!";
            case 4: return "Serpeverde!";
            default: return "Errore";
        }
    }

    public static int getRandomHouse(Random dice) {
        return dice.nextInt(4) + 1;  // randomizza la casa scelta
    }

    public static boolean assignHouse(String name, int house, String[] grifondoro, int[] grifCont,String[] tassorosso, int[] tassCount, String[] corvonero, int[] corvCount, String[] serpeverde, int[] serpCount) {
        int g = grifCont[0], t = tassCount[0], c = corvCount[0], s = serpCount[0];
        boolean hasFour = (g == 4 || t == 4 || c == 4 || s == 4);

    switch (house) {
        case 1: if (g < 6 && (!hasFour || g < 5)) { grifondoro[g++] = name; grifCont[0] = g; return true; } break;
        case 2: if (t < 6 && (!hasFour || t < 5)) { tassorosso[t++] = name; tassCount[0] = t; return true; } break;
        case 3: if (c < 6 && (!hasFour || c < 5)) { corvonero[c++] = name; corvCount[0] = c; return true; } break;
        case 4: if (s < 6 && (!hasFour || s < 5)) { serpeverde[s++] = name; serpCount[0] = s; return true; } break;
    }
    return false; // non c'è spazzio nella casa
    }

    public static void anounceHouseLenght(String[] grifNames ,String[] tassoNames, String[] corvoNames, String[] serpeNames){
        System.out.println();
        System.out.println("Grifondoro");
        for (int i = 0; i<grifNames.length && grifNames[i]!=null ; i++) {
            System.out.println(grifNames[i]);
        }
        System.out.println();
        System.out.println("Tasso rosso");
        for (int i = 0;i<tassoNames.length && tassoNames[i]!=null ; i++) {
            System.out.println(tassoNames[i]);
        }
        System.out.println();
        System.out.println("Corvo nero");
        for (int i = 0;i<corvoNames.length && corvoNames[i]!=null; i++) {
            System.out.println(corvoNames[i]);
        }
        System.out.println();
        System.out.println("Serpe verde");
        for (int i = 0;i<serpeNames.length && serpeNames[i]!=null; i++) {
            System.out.println(serpeNames[i]);
        }
    }

    public static void main(String[] args )throws InterruptedException {
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
        String[] grifondoro = new String[6];
        int[] grifCont = {1};
        grifondoro[0] = "Prefetto: Federico De simone";
        String[] tassorosso = new String[6];
        int[] tassCount = {1};
        tassorosso[0] = "Prefetta: Marta Petruzzelli";
        String[] corvonero = new String[6];
        int[] corvCount = {1};
        corvonero[0] ="Prefetto: Filippo Aresu";
        String[] serpeverde = new String[6];
        int[] serpCount = {1};
        serpeverde[0] = "Prefetto: Carmine Erario";
        Random dice = new Random();
        sortingHatSpeach();
        Thread.sleep(1000);
        for (int i = 0; i < names.length; i++) {
            int house;
            if (dice.nextInt(5) + 1 == 5) {  // 20% chance che il capello ti dia il beneficio del dubbio
                house = preferences[i] != 0 ? preferences[i] : getRandomHouse(dice);
            } else {  // se non riceve la benedizzione del cappello, viene sorteggiato a random
                house = getRandomHouse(dice);
            }

            // controllo che la casa sia effettivamente NON piena
            while (!assignHouse(names[i], house, grifondoro, grifCont, tassorosso, tassCount, corvonero, corvCount, serpeverde, serpCount)) {
                house = getRandomHouse(dice);
            }

            System.out.println("Oh... " + names[i] + " hmm.... dove metterti.... ");
            System.out.println(announce(house));
            Thread.sleep(1000);

        }
        System.out.println();
        anounceHouseLenght(grifondoro,tassorosso,corvonero,serpeverde);

    }
}
