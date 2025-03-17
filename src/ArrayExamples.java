
import javax.print.attribute.standard.NumberUpSupported;

public class ArrayExamples {
    public static void main(String[] args) {
        
        int[] numbers = new int [5];
        // int numbers2 [] = new int[5];
        // int x = 10;
        // int[] numbers3 = new int[x];
        // System.out.println(numbers[0]);
        // System.out.println(numbers[4]);
        // System.out.println(numbers[5]);

        // ci possiamo spostare da una posizione all'altra istantaneamente
        
        // numbers[1] = 100;
        // numbers[4] = 200;

        // for(int i = 0; i < 5; i++) {
        //     System.out.println("Posizione : " + i + " Valore: " + numbers[i]);
        // }
        // for(int n : numbers) {  // ciclo for each
        //     System.out.println(n);
        // }
        
        // voglio inserire nell'array numbers, i quarati dei primi 5 numeri


        for(int i = 0; i < NumberUpSupported.length; i++) {
            numbers[i] = (i + 1)*(i + 1);
        }
        for(int n : numbers) {
            System.out.println(n);
        }
        // calcolare e stampare la somma dei valori nell'array numbers
        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
            sum = sum + numbers[i]; //posso cambiare tutto quello che c'è dentro l'array
                                    // e avrò sempre la somma di ciò che c'è dentro
        }

    }        
}
