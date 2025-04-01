public class HouseSorting {
    public static void main(String[] args) {
        String[] student = {"Ilario Palaia, Serpeverde" , "Elvis La Fata, Corvonero" , "Regina Ghering, Serpeverde" , 
        "Luca Formica, Corvonero" , "Davide MAzzitelli, Corvonero" , 
        "Piero Scarcina, Grifondoro" , "Vittorio Aquila, Corvonero" , 
        "Emanuele Giustiniani , Serpeverde" , "Gaspare Maione, Grifondoro" ,
        "Camilla Marchioro, Grifondoro" , "Eugenio Manganelli, Tassorosso" , 
        "Edoardo Bognanni, Corvonero" , "Lorenzo Coretti, Tassorosso" , "Sabrina Salerno, Tassorosso" , 
        "Marcello Coppolino, Serpeverde", "Stefano Lorato, Grifondoro" , "Nicolò Casertano, Tassorosso" , 
        "Alessio Basili, Grifondoro"}; 
        int counterGrifondoro = 0;
        int counterSerpeverde = 0; 
        int counterCorvonero = 0;
        int counterTassorosso = 0;
        for (int i = 0; i < student.length; i++){
            String[] parts = student[i].split(", "); // Divide nome e casa;
            String casa = parts[1]; // La casa è la seconda parte della stringa;
            if(casa.equals("Grifondoro")){
                counterGrifondoro++;
            } else if (casa.equals("Serpeverde")) {
                    counterSerpeverde++;
            } else if (casa.equals("Corvonero")) {
                    counterCorvonero++;
            } else if (casa.equals("Tassorosso")) {
                counterTassorosso++;
            }
        } 
        System.out.println("Grifondoro: " + counterGrifondoro);
        System.out.println("Serpeverde: " + counterSerpeverde);
        System.out.println("Corvonero: " + counterCorvonero);
        System.out.println("Tassorosso: " + counterTassorosso);

        String[] grifondoro = new String[counterGrifondoro];
        String[] serpeverde = new String[counterSerpeverde];
        String[] corvonero = new String[counterCorvonero];
        String[] tassorosso = new String[counterTassorosso];

        //Variabili per tenere traccia degli indici per ogni casa
        int indexGrifondoro = 0;
        int indexSerpeverde = 0;
        int indexCorvonero = 0;
        int indexTassorosso = 0;

        

    }
} 