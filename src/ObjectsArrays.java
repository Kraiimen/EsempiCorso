import java.util.Random;
public class ObjectsArrays{
    public static void main(String[] args){
       
        //String[] students = {"Vittorio Aquila,gryffindor", "Lorenzo Coretti,ravenclaw"};
        //String[] gryffindor = new String [6];
        //int grCounter = 0;
        //gryffindor[grCounter] = "Emanuele Giustiniani";
        //grCounter ++;
        //String s1 = students[0];
        //System.out.println (s1);
        //String[] sTokens = s1.split(",");


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
            3  //Vittorio Aquila (Corvonero)
        };


        /* String[] gryffindor = new String [5];
        gryffindor[0] = "Piero Scarcina";
        gryffindor[1] = "Gaspare Maione";
        gryffindor[2] = "camilla Marchioro";
        gryffinfor[3] = "Stefano Lorato";
        gryffindor[4] = "Federico De Simone";

        String[] slytherin = new String [5];
        slytherin[0] = "Carmine Erario";
        slytherin[1] = "Ilario Palaia";
        slytherin[2] = "Regina Ghering";
        slytherin[3] = "Emanuele Giustiniani";
        slytherin[4] = "Marcello Coppolino";
       
        String[] ravenclaw  = new String [6];
        ravenclaw[0] = "Elvis La Fata";
        ravenclaw[1] = "Luca Formica";
        ravenclaw[2] = "Davide Mazzitelli";
        ravenclaw[3] = "Vittorio Aquila";
        ravenclaw[4] = "Edoardo Bognanni";
        ravenclaw[5] = "Filippo Aresu";

        String[] hufflepuff  = new String [6];
        hufflepuff[0] = "Eugenio Manganelli";
        hufflepuff[1] = "Lorenzo Coretti";
        hufflepuff[2] = "Sabrina Salerno";
        hufflepuff[3] = "Marta Petruzzelli";
        hufflepuff[4] = "Nicolò Casertano";
        hufflepuff[5] = "Alessio Basili"; */




        Random dice = new Random();
        int counterg = 0;
        int counters = 0;
        int counterr = 0;
        int counterh = 0;

        String[] gryffindor = new String [6];
        String[] slytherin = new String [6];
        String[] ravenclaw  = new String [6];
        String[] hufflepuff  = new String [6];
        for(int i = 0; i <preferences.length ; i++){
            if(dice.nextInt(4)== 1){
                if(preferences[i] == 1){
                    gryffindor[counterg] = names[i];
                    counterg++;                        
                } else if(preferences[i] == 4){
                    slytherin[counters] = names[i];
                    counters++;

                } else if(preferences[i] == 3){
                    ravenclaw[counterr] = names[i];
                        counterr++;

                }else if(preferences[i] == 2){
                    hufflepuff[counterh] = names[i];
                    counterh++;

                }else { 

                }
            }

        }

        for(int i = 0; i <gryffindor.length; i++){
            System.out.println("casata gryffindor  " + gryffindor[i]);
    

        }

        for(int i = 0; i <slytherin.length; i++){
            System.out.println("casata slytherin " + slytherin[i]);

        }
        
        
        for(int i = 0; i <ravenclaw.length; i++){
            System.out.println("casata ravenclaw " + ravenclaw[i]);    
            
        }
        for(int i = 0; i <hufflepuff.length; i++){
            System.out.println("casata hufflepuff  " + hufflepuff[i]); 
        }

    }
}

        







 





       