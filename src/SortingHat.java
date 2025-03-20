import java.util.Random;

public class SortingHat {
    
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
        switch (house) {
            case 1: if (grifCont[0] < 6) { grifondoro[grifCont[0]++] = name; return true; } break;
            case 2: if (tassCount[0] < 6) { tassorosso[tassCount[0]++] = name; return true; } break;
            case 3: if (corvCount[0] < 6) { corvonero[corvCount[0]++] = name; return true; } break;
            case 4: if (serpCount[0] < 6) { serpeverde[serpCount[0]++] = name; return true; } break;
        }
        return false;  // non c'è spazzio nella casa
    }

    public static void anounceHouseLenght(String[] grifNames ,String[] tassoNames, String[] corvoNames, String[] serpeNames){
        System.out.println("Grifondoro");
        for (int i = 0; i<grifNames.length && grifNames[i]!=null ; i++) {
            System.out.println(grifNames[i]);
        }
        System.out.println("Tasso rosso");
        for (int i = 0;i<tassoNames.length && tassoNames[i]!=null ; i++) {
            System.out.println(tassoNames[i]);
        }
        System.out.println("Corvo nero");
        for (int i = 0;i<corvoNames.length && corvoNames[i]!=null; i++) {
            System.out.println(corvoNames[i]);
        }
        System.out.println("Serpe verde");
        for (int i = 0;i<serpeNames.length && serpeNames[i]!=null; i++) {
            System.out.println(serpeNames[i]);
        }
    }

    public static void main(String[] args) {
        String[] names = new String[]{"Alessio Basili","Camilla Marchioro","Carmine Erario","Davide Mazzitelli","Edoardo Bognanni","Elvis La fata","Emanuele Giusiniani","Eugenio Manganelli","Federico De Simone","Filippo Aresu","Gaspare Maione","Ilario Vasco Palaia","lorenzo Coretti","Luca Formica","Marcello Coppolino","Marta Petruzzelli","Nicolò Casertano","Piero Scarcina","Regina Ghering","Sabrina Salrno","Stefano Pio Lorato","Vittorio Aquila" };
        int[] preferences = new int[]{
            0, // Alessio Basili (nessuna preferenza)
            1, // Camilla Marchioro (Grifondoro)
            4, // Carmine Erario (Serpeverde)
            3, // Davide Mazzitelli (Corvonero)
            3, // Edoardo Bognanni (Corvonero)
            3, // Elvis La Fata (Corvonero)
            4, // Emanuele Giusiniani (Serpeverde)
            2, // Eugenio Manganelli (Tassorosso)
            3, // Federico De Simone (Corvonero)
            3, // Filippo Aresu (Corvonero)
            1, // Gaspare Maione (Grifondoro)
            4, // Ilario Vasco Palaia (Serpeverde)
            2, // Lorenzo Coretti (Tassorosso)
            3, // Luca Formica (Corvonero)
            4, // Marcello Coppolino (Serpeverde)
            4, // Marta Petruzzelli (Serpeverde)
            0, // Nicolò Casertano (nessuna preferenza)
            1, // Piero Scarcina (Grifondoro)
            4, // Regina Ghering (Serpeverde)
            2, // Sabrina Salrno (Tassorosso)
            0, // Stefano Pio Lorato (nessuna preferenza)
            3  // Vittorio Aquila (Corvonero)
        };
        String[] grifondoro = new String[6];
        int[] grifCont = {0};

        String[] tassorosso = new String[6];
        int[] tassCount = {0};

        String[] corvonero = new String[6];
        int[] corvCount = {0};

        String[] serpeverde = new String[6];
        int[] serpCount = {0};

        Random dice = new Random();

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

        }
        System.out.println();
        anounceHouseLenght(grifondoro,tassorosso,corvonero,serpeverde);

    }
}
