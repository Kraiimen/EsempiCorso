import java.util.Random;
import java.io.Console;

public class PrintNumbers {
    public static void main (String[] args){
        
        // for( int i = 1 ; i < 100 ; i++ ) { //nel secondo slot sto dicendo dove terminare il ciclo
        //     if (i % 3 == 0 && i % 5 == 0){
        //         System.out.println("fizzbuzz");
        //     } else if (i % 3 == 0){
        //         System.out.println("fizz");
        //     } else if (i % 5 == 0){
        //         System.out.println("buzz");
        //     } else {
        //         System.out.println(i);
        //     }
        // }

        int i = 1;
        do {
            if (i % 3 == 0 && i % 5 == 0){
                System.out.println("fizzbuzz");
            } else if (i % 3 == 0){
                System.out.println("fizz");
            } else if (i % 5 == 0){
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
            i ++;
        } while (i < 100);
    }
}
