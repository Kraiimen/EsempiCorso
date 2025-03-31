// creare un programma che chiede di inserire un numero
// creare due variabili 
// creare una somma fra le due variabili


import java.io.Console;


public class Calcolatrice {
    public static void main(String[] args) {
        int n;
        int m;
        String answer;
        Console console = System.console();
        System.out.println("dammi un qualsiasi numero");
        answer = console.readLine(); //quando voglio prendere un input dall'utente
        n = Integer.parseInt(answer);
        System.out.println("chiedimi l'operazione +, -, *, /");
        String userChoice = console.readLine();
        System.out.println ("dammi un altro numero");
        answer = console.readLine();
        m = Integer.parseInt(answer); 
        



        



        if ( userChoice.equals("+") ) { 
            console = System.console();
            answer = console.readLine();
            n = Integer.parseInt(answer);

        }
        


        // System.out.println("dammi un qualsiasi numero");
        // Console console = System.console();
        // String answer = console.readLine();
        // n = Integer.parseInt(answer);
        
        // System.out.println("dammi un altro numero");
        // console = System.console();
        // answer = console.readLine();
        // m = Integer.parseInt(answer);
        
        // System.out.println("chiedimi la moltiplicazione");
        // int s = n * m;
        // System.out.println(s);

        









    }
}