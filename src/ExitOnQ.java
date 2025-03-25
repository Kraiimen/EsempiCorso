// Un programma che all'avvio chieda un numero 
// poi chiede un altro numero o Q per smettere di inserire (e cosi via finché non viene inserito Q)
// Alla fine il programma stampa il numero più grande ricevuto

import java.io.Console;

public class ExitOnQ { 
    public static void main(String[] args){
        
        Console console = System.console();

        String str = null; //variabile che conterrà l'input dell'utente
        int number = 0; //variabile che conterrà il cast in int della stringa
        int max = 0, i = 0; //variabile per il numero più grande e variabile contatore i

        // Ciclo do-while per l'inserimento di almeno un numero
        // dopo aver iterato almeno una volta, dà la possibilità di terminare il programma
        do{ 
            //Se ci troviamo nella prima iterazione
            if(i == 0){
                //Mandiamo a schermo un output "Inserisci un numero: " e inseriamo l'input in str
                str = console.readLine("\nInserisci un numero: ");
            }

            //Se non siamo alla prima iterazione, diamo la possibilità di terminare il programma
            else {
                str = console.readLine("\nInserisci un numero (inserire Q per terminare il programma): ");

                //Se l'input dell'utente è la lettera Q, viene mandato a schermo l'output del numero più grande
                if(str.equals("Q")){
                    System.out.println("\nIl numero più grande inserito è: " + max);
                    System.out.println("Programma terminato.\n");
                }
            }
            
            //Converto la stringa in intero per effettuare il controllo del numero maggiore
            number = Integer.parseInt(str);

            if(number > max){
                max = number;
            }

            i++; //Incrementiamo il contatore delle iterazioni del ciclo
        } while (!str.equals("Q")); //Finché la stringa non è uguale a Q, il programma continua

    }
}