import java.io.Console;

public class Loops {
    public static void main(String[] args) {
        Console console = System.console(); 
        for( int i = 0 ; i < 10 ; i++ ) { //esegue una volta sola la prima espressione all'inizio del ciclo, 
        //valuta l'espressione centrale andando a stampare 0, 
        //terminato esegue il terzo slot e stamperà dall'1 al 9 perché 10 non è minore di 10 e il ciclo termina
            System.out.println(i);
        }
        System.out.println(x:"ciclo terminato");
        // fare ciclo for che stampa i numeri dispari da 1 a 100 compreso
        //for( int i = 1 ; i < 101 ; i++ ) {
          //  if(i % 2 != 0){
            //    System.out.println(i);
          //  } //se il resto della divisione è 0 i numeri sono pari
        }
        for(int i = 1; i < 100; i += 2) { // i -= 5 stampa tutti i numeri da 100 a 0 multipli di 5
            System.out.println(i);
        }

        int y = 100;
        while( y > 0){ //intanto che y è maggiore di 0 noi stampiamo y
            System.out.println(y);
            y -= 5;
        }
        int z = 100;
        do {
            System.out.println(z);
            z -= 5;
        } while (z > 0);

        //altro esempio do while
        String answer;
        do {
            System.out.println("inserisci una risposta di tipo Yes or No");
            String answer = console.readLine();
            if(!answer.equals ("Yes") && !answer.equals ("No")) {
                System.out.println("Ti ho detto di rispondere Yes or No");
            }
        } while (!answer.equals ("Yes") && !answer.equals ("No"));
        System.out.println("dammi un numero qualsiasi");
        String ns = console.readLine();
        int n = Integer.parseInt(ns); //passami in intero la stringa ns
        System.out.println(n + 1);


    }
}
