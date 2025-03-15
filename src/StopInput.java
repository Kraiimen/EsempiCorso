//importa la libreria per l'utilizzo di Console
import java.io.Console;

public class StopInput {
    public static void main(String[] args) {
        //inizializza le variabili "input"(contenitore della stringa inserita da tastiera) e "max"(intero dentro il quale andrà il numero massimo inserito)
        String input;                                                 
        int max = 0;

        Console console = System.console();                                                //crea un oggetto di nome "console" e di classe Console

        //inizio ciclo do while
        do{
            //richiesta numero o lettera q, da inserire da tastiera
            System.out.println("premere   q   se si desidera terminare il programma!");
            System.out.println("Inserire un numero: ");

            
            input = console.readLine();                    //utilizzo del metodo readLine() per leggere la stringa inserita ed inserirla nella variabile input
            if(!input.equals("q")){                        //condizione necessaria a capire se la stringa inserita contiene un qualcosa di diverso da "q"
                int num = Integer.parseInt(input);         //inizializzazione di "num" all'interno del quale viene inserita la stringa numerica convertita in intero

                //se il numero inserito è maggiore di quello inserito in precedenza, allora diventa lui quello più grande
                if(num > max){
                    max = num;
                }
            }
        }while(!input.equals("q"));            //il tutto continua fino a quando non viene inserito "q" da tastiera
        System.out.println(max);
    }
}