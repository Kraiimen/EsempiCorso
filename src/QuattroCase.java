
// creare un array con 21 stringhe  con nomi dei ragazzi
// creare 4 array per ogni casa con 6 posti
// prima assegnare i prefetti per ogni casa
// poi distribuire gli altri nome alle case
public class QuattroCase {
    public static void main(String[] args) {

        String[] prefetti = {"Marta Petruzzelli","Tassorosso","Carmine Erario", "Serpeverde","Filippo Aresu", "Corvonero","Federico De Simone" ,"Grifondoro"};   

        String[] studenti = {"Ilario Palaia","Serpeverde","Elvis La Fata", "Corvonero",
            "Regina Ghering" ,"Serpeverde","Ayoub Karia" , "Corvonero",
            "Luca Formica","Corvonero", "Davide MAzzitelli", "Corvonero",
            "Piero Scarcina","Grifondoro", "Vittorio Aquila", "Corvonero",
            "Emanuele Giustiniani","Serpeverde","Gaspare Maione", "Grifondoro",
            "Camilla Marchioro", "Grifondoro","Eugenio Manganelli","Tassorosso",
            "Edoardo Bognanni","Corvonero", "Lorenzo Coretti","Tassorosso",
            "Sabrina Salerno","Tassorosso ","Marcello Coppolino","Serpeverde",
            "Stefano Lorato" , "Grifondoro","Nicolò Casertano" ,"Tassorosso",
            "Alessio Basili", "Corvonero","Federica Distas", "Sempreverde"};

        String[] grifoNdoro = new String[6];
        String[] serpeVerde= new String[6];
        String[] corvoNero= new String[6];
        String[] tassoRosso = new String[5];

        //Inserimento Prefetti nella array delle case

        grifoNdoro[0] = prefetti[6]; 
        serpeVerde[0] = prefetti[2]; 
        corvoNero [0] = prefetti[4];  
        tassoRosso[0] = prefetti[0]; 
    
   


        for (int i = 0; i < studenti.length; i+= 2) {
            String studente = studenti[i];
            String preferenze = studenti[i + 1];

            // Assegna lo studente alla casa preferita
            if (preferenze.equals("Grifondoro")) {
                for (int j = 1; j < grifoNdoro.length; j++) {
                    if (grifoNdoro[j] == null) {
                        grifoNdoro[j] = studente;
                        break;
                    }
                }
            } else if (preferenze.equals("Serpeverde")) {
                for (int j = 1; j < serpeVerde.length; j++) {
                    if (serpeVerde[j] == null) {
                        serpeVerde[j] = studente;
                        break;
                    }
                }
            } else if (preferenze.equals("Corvonero")) {
                for (int j = 1; j < corvoNero.length; j++) {
                    if (corvoNero[j] == null) {
                        corvoNero[j] = studente;
                        break;
                    }
                }
            } else if (preferenze.equals("Tassorosso")) {
                for (int j = 1; j < tassoRosso.length; j++) {
                    if (tassoRosso[j] == null) {
                        tassoRosso[j] = studente;
                        break;
                    }
                }
            } 

        System.out.println("Gli studenti di Grifondoro: ");
        for (String s : grifoNdoro) {
            if(s != null) 
            System.out.println(s);
        }

        System.out.println("\n Gli studenti di Serpeverde: ");
        for (String s : serpeVerde) {
            if(s != null) 
            System.out.println(s);
        }

        System.out.println("\nGli Studenti di Corvonero: ");
        for (String s : corvoNero) {
            if(s != null)
            System.out.println(s);
        }

        System.out.println("\nGli Studenti di Tassorosso: ");
        for (String s : tassoRosso) {
            if(s != null) 
            System.out.println(s);
            }
        
        
        }
   }     

}


