public class ObjectsArray {
    public static void main(String[] args) {
        
        String[] as = new String[5];
        //stampare maiuscola prima stringa.
        //System.out.println(as[0].toUpperCase());
        String[] students = {"Vittorio Aquila,ravenclaw", "Lorenzo Coretti,ravenclaw", "Carmine Erario", "Filippo Aresu", "Federico De Simone", "Marta Petruzelli", "Nicolo Casertano", "Piero Scarcina", "Stefano Pio Lorato", "Sabrina Salerno", "Regina Ghering", "Gaspare Maione", "Ilario Palaia", "Marcello Coppolino", "Camilla Marchioro", "Eugenio Manganelli", "Elvis La Fata", "Davide Mazzitelli", "Alessio Basili", "Federica Distasi", "Ayoub Karia"}; //gli array sarà composto dagli elementi che stanno dentro alle graffe
        System.out.println(students[0].toUpperCase());

        String[] griffindor = new String [6];
        int grCounter = 0;
        griffindor[grCounter] = "Emanuele Giustiniani";
        grCounter++;
        String s1 = students[0];
        System.out.println(s1);
        String[] sTokens = s1.split(",");
        System.out.println(sTokens[0]);
        System.out.println(sTokens[1]);
 
    }
}