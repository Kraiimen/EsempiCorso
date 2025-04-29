import java.util.Random;
// creare un array con 21 stringhe  con nomi dei ragazzi
// creare 4 array per ogni casa con 6 posti
// prima assegnare i prefetti per ogni casa
// poi distribuire gli altri nome alle case
public class QuattroCase {
    public static void main(String[] args) {

        String[] prefetti = {"Marta Petruzzelli","Carmine Erario","Filippo Aresu","Federico De Simone"};   

        String[] studentiPreferenze = {"Ilario Palaia","Serpeverde","Elvis La Fata", "Corvonero",
            "Regina Ghering" ,"Serpeverde","Ayoub Karia" , "Corvonero",
            "Luca Formica","Corvonero", "Davide MAzzitelli", "Corvonero",
            "Piero Scarcina","Grifondoro", "Vittorio Aquila", "Corvonero",
            "Emanuele Giustiniani","Serpeverde","Gaspare Maione", "Grifondoro",
            "Camilla Marchioro", "Grifondoro","Eugenio Manganelli","Tassorosso",
            "Edoardo Bognanni","Corvonero", "Lorenzo Coretti","Tassorosso",
            "Sabrina Salerno","Tassorosso ","Marcello Coppolino","Serpeverde",
            "Stefano Lorato" , "Grifondoro","Nicolò Casertano" ,"Tassorosso",
            "Alessio Basili", "Corvonero","Federica Distas", "Sempreverde"};
        // Creo array per le 4 case
        String[] grifoNdoro = new String[6];
        String[] serpeVerde= new String[6];
        String[] corvoNero= new String[6];
        String[] tassoRosso = new String[6];
        // Scambio delle stringhe e 

        Random dice = new Random();
        for(int i= 0; i<100; i++){
            int n1 = dice.nextInt(studentiPreferenze.length); // prende un numero a caso fino alla lunghezza dell array degli studenti
            if(n1 % 2 != 0){ // il resto deve essere diverso da 0 per essere dispari
                n1--; // in caso fosse pari rimuoviamo uno
            }
            int n2;
            do {
                n2 = dice.nextInt(studentiPreferenze.length);
                if(n2 % 2 != 0){
                    n2--;
                }
            } while(n1 == n2); // continua  il ciclo do while se n2 fosse uguale a n1
            String tempStudent = studentiPreferenze[n1];  // cambiamo la posizione studente con temp student
            String tempPref    = studentiPreferenze[n1+1]; // visto che non è bidimensionale lo abbiamo fatto due volte e cambiamo la posizione della prefenza con prefer
            studentiPreferenze[n1] = studentiPreferenze[n2]; // poi li invertiamo con n2
            studentiPreferenze[n1 + 1] = studentiPreferenze[n2 + 1];// con la prefernza
            studentiPreferenze[n2] = tempStudent; // alla fine ci scambia un nome ccon un nome
            studentiPreferenze[n2+1] = tempPref;  // ci scambia con la preferenza con un altra

        }   
        

        //Inserimento Prefetti nella array delle case

        grifoNdoro[0] = prefetti[3]; 
        serpeVerde[0] = prefetti[2]; 
        corvoNero [0] = prefetti[1];  
        tassoRosso[0] = prefetti[0]; 

        for (int i = 0; i < studentiPreferenze.length; i+= 2)  {
            String studente = studentiPreferenze[i];
            String preferenze = studentiPreferenze[i + 1];

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
        }  

        System.out.println("Gli studentiPreferenze di Grifondoro: ");
        for (String s : grifoNdoro) {
            if (s != null)
                System.out.println(s);
        }

        System.out.println("\n Gli studentiPreferenze di Serpeverde: ");
        for (String s : serpeVerde) {
            if (s != null)
                System.out.println(s);
        }

        System.out.println("\nGli Studenti di Corvonero: ");
        for (String s : corvoNero) {
            if (s != null)
                System.out.println(s);
        }

        System.out.println("\nGli Studenti di Tassorosso: ");
        for (String s : tassoRosso) {
            if (s != null)
                System.out.println(s);
        }
        
    }     

}


