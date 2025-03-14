import java.util.Random;
import java.io.Console;
public class GuessTheNumber {
	public static void main(String[] args){
        /*
        Questo programma chiede al utente di indovinare il numero misterioso
        se l'utente azzecca dirà "bravo lo hai indovinato", se l'utente dice un numero più basso, il programma risponde dicendo "sbagliato, il numero è più grande" e vice versa con un numero più grande
        il programma deve anche tenere traccia del numero di tentativi

        */
        Random dice = new Random(); //crea un oggetto di tipo Random, che useremo per generare un numero casuale
        int n = dice.nextInt(10001); // inseriamo il numero Random in n
        Console console = System.console(); //Crea un oggetto di tipo Console, servirà in successivo per richiedere imput
        System.out.println("indovina il numero tra 0 e 10000");
        int N;
        int tentativi=0;
        do{
            String NI = console.readLine(); //crea la variabile NG (Numero inserito)
            N = Integer.parseInt(NI); //Passiamo il valore di Numero Inserito in N (Numero)
            if(N> 10000 || N<=0){ // Check che il numero sia in range
                System.out.println("ricorda che il numero è tra 0 e 10000");
            }else if(N == n && tentativi ==1){
                System.out.println("WOW al primo tentativo? impressionante");
            }else if(N == n && tentativi !=1){
                System.out.println("Hey hai indovinato! in " + tentativi + " tentativi!");
            }else if (N > n){
                System.out.println("no, il numero è più piccolo");
            }else{
                System.out.println("no, il numero è più grande");
            }
            tentativi++; // aumentiamo il numero di tentativi per ogni guess
        }while(N != n);
        tentativi =0;
    }
}
