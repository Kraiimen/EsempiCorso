import java.util.Random;

public class AssegnazioneCasata {
    public static void main(String[] array) {

        // Filippo  = corvonero
        // Carmine = serpeverde
        // Marta = tasso rosso
        // federico = Grifondoro
        
        String[] students = {"Vittorio Aquila,Corvonero", "Lorenzo Coretti,Tassorosso", "Nicolò Casertano,Grifondoro", "Marcello,Serpeverde",
                             "Ilario Palaia,Serpeverde", "Elvis La Fata,Corvonero","Regina Ghering,Serpeverde", "Luca Formica,Corvonero", "Davide Mazzitelli,Corvonero",
                             "Piero Scarcina,Grifondoro", "Emanuele Giustiniani,Serpeverde", "Gaspare Maione,Grifondoro", "Camilla Marchioro,Grifondoro", "Eugenio Manganelli,Tassorosso",
                             "Edoardo Bognanni,Corvonero", "Sabrina Salerno,Tassorosso", "Stefano Lorato,nopreferenza", "Alessio Basili,nopreferenza"};        
    }

    public static void assignment(String[] students) {

        Random dice = new Random(); 
        int gCounter = 1;
        int cCounter = 1;
        int tCounter = 1;
        int sCounter = 1;
      
        int studentsLeft = students.length - 1; 
        int max = studentsLeft * 4; 

        
    }
        
        
        
            
        
}

    //fare array con nomi
    //assegnare prefetti a 4 casate diverse
    //fare come se ci fossero 5 casate tutte da 5 studenti
    //preferenza: fai un altro array con i nomi delle varie case 


