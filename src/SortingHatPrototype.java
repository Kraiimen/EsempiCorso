public class SortingHatPrototype {
    public static void main(String[] args) {

        String[] as = new String[17];
        String[] students = {"Vittorio Aquila", "Lorenzo Coretti", "Nicolo Casertano", "Piero Scarcina", "Stefano Pio Lorato", "Sabrina Salerno", "Regina Ghering", "Gaspare Maione", "Ilario Palaia", "Marcello Coppolino", "Camilla Marchioro", "Eugenio Manganelli", "Elvis La Fata", "Davide Mazzitelli", "Alessio Basili", "Emanuele Giustiniani", "Edoardo Bognanni", "Luca Formica"};
        String[] sTokens = {"ravenclaw", "hufflepuff", "gryffindor", "gryffindor", "gryffindor", "hufflepuff", "slytherin", "gryffindor", "slytherin", "slytherin", "gryffindor", "hufflepuff", "ravenclaw", "ravenclaw", "...", "slytherin", "ravenclaw", "ravenclaw"};

        String name = students[0];
        String house = sTokens[0];

        //String[] sTokens = name.split(",");
        
        String[] griffindor = new String [6];
        int grCounter = 0;
        griffindor[grCounter] = "Federico De Simone";
        grCounter++;

        String[] ravenclaw = new String [6];
        int rvCounter = 0;
        ravenclaw[grCounter] = "Filippo Aresu";
        rvCounter++;

        String[] hufflepuff = new String [6];
        int hfCounter = 0;
        hufflepuff[grCounter] = "Marta Petruzzelli";
        hfCounter++;

        String[] slytherin = new String [6];
        int slCounter = 0;
        slytherin[grCounter] = "Carmine Erario";
        slCounter++;


        for(int i = 0; i < students.length; i++) {
            sTokens = name.split(",");
            if(sTokens.length < 3) {
            name = sTokens[0].toUpperCase();
            house = sTokens[1].toUpperCase();
            }
        }
        
        //System.out.println(students[0].toUpperCase());
        // String s1 = students[0];
        // System.out.println(s1);
        // String[] sTokens = s1.split(",");
        // System.out.println(sTokens[0]);
        // System.out.println(sTokens[1]);
    }
}