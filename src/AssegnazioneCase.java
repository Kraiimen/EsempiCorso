//creare array con i nomi associati alle preferenze.
// creare 4 array, 1 per casa
//distribuire gli studenti nelle case

public class AssegnazioneCase{
    public static void main (String[] args){
        //Array studenti e prefetti
        String[] studenti = {"Ilario Palaia,Serpeverde" , "Elvis La Fata,Corvonero" , "Regina Ghering,Serpeverde" , "Luca Formica,Corvonero" , "Davide Mazzitelli,Corvonero" , "Piero Scarcina,Grifondoro" , "Vittorio Aquila,Corvonero" , "Emanuele Giustiniani,Serpeverde" , "Gaspare Maione,Grifondoro" , "Camilla Marchioro,Grifondoro" , "Eugenio Manganelli,Tassorosso" , "Edoardo Bognanni,Corvonero" , "Lorenzo Coretti,Tassorosso" , "Sabrina Salerno,Tassorosso" , "Marcello Coppolino,Serpeverde" , "Stefano Lorato,Tassorosso" , "Nicolò Casertano,Tassorosso" , "Alessio Basili,Grifondoro"};

        String[] prefetti = {"Marta Petruzzelli,Tassorosso" , " Carmine Erario,Serpeverde" , "Filippo Aresu,Corvonero" , "Federico De Simone,Grifondoro"};

        //Array case
        String[] grifondoro = new String [6];
        String[] serpeverde = new String [6];
        String[] tassorosso = new String [6];
        String[] corvonero = new String [6];

        //split studenti secondo preferenze       
        String s1 = studenti[0];   //stringa per lo split 
        int gdCounter = 0; //counter per grifondoro
        int svCounter = 0; //counter serpeverde
        int trCounter = 0;
        int cnCounter = 0;
        
        
        for (int i = 0; i < studenti.length; i++){
            
            s1 = studenti[i];
            String[] sTokens = s1.split(",");           //sTokens[0] = nome, sTokens[1] = preferenza
            if (sTokens[1].equals("Grifondoro") && gdCounter < 5){
                grifondoro[gdCounter] = sTokens[0];           
                gdCounter++;
            } 
            else if (sTokens[1].equals("Serpeverde") && svCounter < 5){
                serpeverde[svCounter] = sToken[0];
                svCounter++;
            }
            else if (sToken[1].equals("Tassorosso") && trCounter < 5){
                tassorosso[trCounter] = sToken[0];
                trCounter++;
            }
            else if (sToken[1].equals("corvonero") && cnCounter < 5){
                corvonero[cnCounter] = sToken[0];
                cnCounter++;
            }
        }
        
    }
}
