package personal;

import java.io.Console;
import java.util.ArrayList;

public class TryCatchExercise {
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<>();
        Console console = System.console();
        boolean isIndexOk = false;

        for(int i = 0; i < 5 ; i++) {
            numbers.add(readInt());
        }

        System.out.print("Dammi un indice dell'ArrayList dove hai appena messo i numeri: ");
        do {
            int ns = readInt();
            try {
                System.out.println("Il numero alla posizione che hai chiesto è " + numbers.get(ns));
                isIndexOk = true;
            } catch(IndexOutOfBoundsException ie) {
                System.out.println("AOOOOOO l'hai appena fatto e mi hai dato un numero troppo grande!!!");
            }
        } while(!isIndexOk);
    }

    public static int readInt(){
        Console console = System.console();
        boolean isNumber = false;
        int ns = 0;
        do {
            try {
                System.out.print("Dammi un numero: ");
                ns = Integer.parseInt(console.readLine());
                isNumber = true;
            } catch(NumberFormatException ne) {
                System.out.println("Ti ho detto un numero AO");
            }
        } while(!isNumber);
        return ns;
    }
}
