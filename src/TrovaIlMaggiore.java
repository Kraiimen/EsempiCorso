import java.io.Console;
public class TrovaIlMaggiore {
    public static void main(String [] args){
        
        // ORIGINALE 
        Console console = System.console();
        int max = Integer.MIN_VALUE; // minore minimo del int
        String risposta;
         do {
             System.out.println("Inserisci un numero o premi Q per terminare per favore :3");
             risposta = console.readLine(); // metto la console per leggere la risposta typed
             if (!risposta.equals("q")){ // risposta diversa da q
                 int n = Integer.parseInt(risposta); // converto la risposta in un numero intero
                 if (n > max){ // aggiungere una condizionale nal caso il numero inserito è maggiore del valore di max 
                    max = n; // cambio valore di max in n
                 }
             } else {
                 System.out.println("Il numero più alto che mi hai dato è " + max );
             }
         } while(!risposta.equals("q")); // quando il valore non è q continua


    }
    
}