//Un programma che all'avvio chieda un numero, poi chiede un altro numero o Q per smettere di inserire (e cosi via finché non viene inserito Q)
//Alla fine il programma stampa il numero più grande ricevuto
import java.io.Console;

public class ExitOnQ {
    public static void main(String[] args) {
        Console console = System.console();
    
    String n;
    int max = 0;
   
    System.out.println("digita un numero:");
    do{
        n = console.readLine();

        if(!n.equals("Q")){
            System.out.println("inserire un altro numero o digitare Q");
            if(Integer.parseInt(n)>max){
                max = Integer.parseInt(n);
            }
        }
    

     } while (!n.equals("Q"));   

       System.out.println("Numero maggiore e " + max);
   
        
       
    }
}