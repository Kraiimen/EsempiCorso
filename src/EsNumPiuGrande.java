// Traccia esercizio 3:
// Un programma che all'avvio chieda un numero, 
// poi chiede un altro numero o Q per smettere di inserire 
// (e cosi via finché non viene inserito Q)
// Alla fine il programma stampa il numero più grande ricevuto
import java.io.Console;


public class EsNumPiuGrande{

    public static void main(String[] args){
        String exitChar = "q"; //carattere di uscita
        String userAnswer = null; 
        Console console = System.console(); //oggetto che utilizzeremo per prendere gli input dall utente
        System.out.print("Scrivi un numero: ");
        String primoInput = console.readLine();
        int nPiuGrande = Integer.parseInt(primoInput);
        

        do{
            System.out.print("Inserisci un altro numero o \"q\" per uscire: ");
            userAnswer = console.readLine();
            if (userAnswer.equals(exitChar)){ 
                //System.out.println("OI");
                break; //esce dal do-while quando eseguita
            }else{
                int n2 = Integer.parseInt(userAnswer);
                if(nPiuGrande < n2){
                    nPiuGrande = n2;
                }
            }
        }while(!userAnswer.equals(exitChar));
        System.out.println("Il numero piu grande che hai messo è: "+ nPiuGrande);
        
    }
}