import java.util.Scanner;

public class SommaFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        int n = scanner.nextInt();
        
        /*
        int somma = 0;
        for (int i = 1; i <= n; ) {
            somma += i;i++
        }
        */
    /*
        int somma = 0;
        int i = 1;
        while(i <= n){
            somma += i;

            i++;
        }
*/


                int somma = 0;
        int i = 1;
        do {
            somma += i;

            i++;
        }while(i <= n);
        
        System.out.println("La somma dei numeri da 1 a " + n + " è: " + somma);
        scanner.close();
    }
}
