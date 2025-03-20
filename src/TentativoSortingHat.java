import java.util.Random;
public class TentativoSortingHat{
    public static void main(String[] args){
        String[] students = {"Ilario Palaia" , "Elvis La Fata" , "Regina Ghering" , "Luca Formica" , "Davide Mazzitelli" , "Piero Scarcina" , "Vittorio Aquila" , "Emanuele Giustiniani" , "Gaspare Maione" , "Camilla Marchioro" , "Eugenio Manganelli" , "Edoardo Bognanni" , "Lorenzo Coretti" , "Sabrina Salerno" , "Marcello Coppolino" , "Stefano Lorato" , "Nicolò Casertano" , "Alessio Basili"};
        Random random = new Random(); // attivo il random per l'assegnazione 
        boolean[] usato = new boolean[students.length]; // creato una array booleana che controlla se nei nomi sono già stati sorteggiati
        int studentsCount = 0; // conta gli studenti sorteggiati

        //GRIFINDOR
        String[] griffindor = new String[4]; // creo una array di stringhe per la casata di griffindor
        

        //SLYTHERIN
        String[] slytherin = new String[4];
       

        //HUFFLEPUFF
        String[] hufflepuff = new String[5];
       

        // RAVENCLAW
        String[] ravenclaw = new String[5];

        //griff

        for(int i = 0; i < griffindor.length; i++){ // inizia il ciclo for i griffindor
            int grifCount; // contatore array del grifondoro
            do{
                grifCount = random.nextInt(students.length); //finchè non trova un nome non usato, randomizza la scelta e continua il ciclo
            } while (usato[grifCount]); //mette i nomi scelti per la casata come usati 
            griffindor[i] = students[grifCount]; // array di studenti(quelli di grifondoro) sono messi in grifondoro
            usato[grifCount] = true; // mette i nomi usati nella casata come usati
        }
        System.out.println("\nNella casata dei Grifondoro, il Prefetto sarà \n... \nFederico De Simone!" + "\n" + "\nGli studenti assegnati a Grifondoro sono: " + "\n");
        for (String studentiGrif : griffindor){ //loop for each
            System.out.println(studentiGrif + " "); // mi legge i nomi degli studenti uno ad uno 
        }

        //slyth
        
        for(int i = 0; i < slytherin.length; i++){ // inizia il ciclo for i griffindor
            int slyCount; // conta i griffoni
            do{
                slyCount = random.nextInt(students.length); // ripete finchè non trova un nome non usato
            } while (usato[slyCount]); 
            slytherin[i] = students[slyCount]; // assegno nome
            usato[slyCount] = true; // ascegna nomi come usati
        }
        System.out.println("\nNella casata dei Serpeverde, il Prefetto sarà \n... \nCarmine Erario!" + "\n" + "\nGli studenti assegnati a Serpeverde sono: " + "\n");
        for (String studentiSly : slytherin){
            System.out.println(studentiSly + " ");
        }

        //huffle

        for(int i = 0; i < hufflepuff.length; i++){ // inizia il ciclo for i griffindor
            int huffCount; // conta i griffoni
            do{
                huffCount = random.nextInt(students.length); // ripete finchè non trova un nome non usato
            } while (usato[huffCount]); 
            hufflepuff[i] = students[huffCount]; // assegno nome
            usato[huffCount] = true; // ascegna nomi come usati
        }
        System.out.println("\nNella casata dei Tassorosso, il Prefetto sarà \n... \nMarta Petruzzelli!" + "\n" + "\nGli studenti assegnati a Tassorosso sono: " + "\n");
        for (String studentiHuff : hufflepuff){
            System.out.println(studentiHuff + " ");
        }

        // raven

        for(int i = 0; i < ravenclaw.length; i++){ // inizia il ciclo for i griffindor
            int ravenCount; // conta i griffoni
            do{
                ravenCount = random.nextInt(students.length); // ripete finchè non trova un nome non usato
            } while (usato[ravenCount]); 
            ravenclaw[i] = students[ravenCount]; // assegno nome
            usato[ravenCount] = true; // ascegna nomi come usati
        }
        System.out.println("\nNella casata dei Corvonero, il Prefetto sarà \n... \nFilippo Aresu!" + "\n" + "\nGli studenti assegnati a Corvonero sono: " + "\n");
        for (String studentiRaven : ravenclaw){
            System.out.println(studentiRaven + " ");
        }


        // PRIMO TENTATIVO 
        // for (int i = 0; i < griffindor.length; i++ ){  // un circolo for per assegnare le persone a caso nella'array del grifondoro
        //     int pick = random.nextInt(students.length); // prende casualmente dalla lista degli studenti
        //     griffindor[i] = students[pick]; // nell'array dei grifondoro veranno assegnati gli studenti randomici 
        // }
        // System.out.println("\nNella casata dei Grifondoro, il Prefetto sarà \n... \nFederico De Simone!" + "\n" + "\nGli studenti di Grifondoro sono... ");
        // for (String studenti : griffindor){
        //     System.out.println(studenti + " ");
        // }


        // // ALTRIMENTI 
        // System.out.println("Ogni casata ha un prefetto" + "\nGriffondoro ha Federico De Simore" + "\n" + "\nSerpeverde ha Carmine Erario" + "\n" + "\nTassorosso ha Marta Petruzzelli" + "\n" + "\n e in fine \n Corvonero ha Filippo Aresu!" + "\n" + "\n e ora gli studenti... ");
        // String[] casate = {"Grifondoro" , "Serpeverde" , "Tassorosso" , "Corvonero"}; // array casate
        // for (int i = 0; i < students.length; i++ ){ // ciclo for per gli studenti
        //     int pick = random.nextInt(casate.length); // pick è la variabile del randomico array delle casate
        //     System.out.println("\n" + students[i] + "\nVerrà assegnat* a.. " + "\n" + casate[pick]); // stampo
        // }
        
    }
}
