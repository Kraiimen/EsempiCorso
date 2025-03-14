import java.util.Random;
import java.io.Console;
public class GuessTheNumber {
	public static void main(String[] args){
        /*
        Questo programma chiede al utente di indovinare il numero misterioso
        se l'utente azzecca dirà "bravo lo hai indovinato", se l'utente dice un numero più basso, il programma risponde dicendo "sbagliato, il numero è più grande" e vice versa con un numero più grande
        il programma deve anche tenere traccia del numero di tentativi
        */
        Random dice = new Random();
        int n = dice.nextInt(10001);
        Console console = System.console();
        System.out.println("indovina il numero tra 0 e 10000");
        int N;
        int tentativi=0;
        do{
            String NI = console.readLine();
            N = Integer.parseInt(NI);
            if(N> 10000 || N<1){
                System.err.println("ricorda che è tra 0 e 10000");
            }else if(N == n && tentativi ==1){
                System.out.println("WOW al primo tentativo?");
                tentativi =0;
            }else if(N == n && tentativi !=1){
                System.out.println("Hey hai indovinato! in " + tentativi + " tentativi!");
                tentativi =0;
            }else if (N > n){
                System.out.println("no, il numero è più piccolo");
            }else{
                System.out.println("no, il numero è più grande");
            }
            tentativi++;
        }while(N != n);
        
    }
}