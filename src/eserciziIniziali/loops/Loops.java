import java.io.*;

public class Loops {
	public static void main(String[] args){
        Console console = System.console();

        // for(int i = 0; i <= 100; ++i){
        //     if(i%2 == 1)
        //     {
        //         System.out.println(i);
        //     }
        // }

        // for(int i = 1; i <= 100; i += 2){
        //     System.out.println(i);
        // }

        /*
        String answer;
        do{
            System.out.println("inserisci una risposta di tipo 'yes' o 'no'");
            answer = console.readLine();
            if(!(answer.equals("yes") || answer.equals("no"))){
                System.out.println("devi rispondere 'yes' o 'no'");
            }
        }while(!(answer.equals("yes") || answer.equals("no")));

        System.out.println("dammi un numero qualsiasi");
        String ns = console.readLine();

        int n = Integer.parseInt(ns);

        System.out.println(n + 1);

        for(int i = 0; i < 5; ++i){
            for(int j = 0; j < 5; ++j){
                System.out.printf("(i = %d; j = %d) ", i, j);
            }
            System.out.println();
        }
        int lunghezza = 5;
        for(int i = 0; i < lunghezza; ++i){
            for(int j = 0; j < lunghezza; ++j){
                if(i == j){
                    System.out.print("\\");
                }else if((i+j) == lunghezza-1){
                    System.out.print("/");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        //*/
	}	
}