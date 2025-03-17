import java.util.Random;

public class ArrayExamples {
    public static void main (String[] args){
        // mettiamo che io voglia creare un array di interi a 5 posti
        // int[] numbers = new int[5]; // si può creare un array intero chiamato number
        /*int number[] = new int[5]; // oppure una array numbers con dentro interi
        int x =10;
        int[] numbers3 = new int[x]; // un array può essere inizializato con una varibile come lunghezza
        numbers[1] = 100;
        numbers[4] = 200;
         for(int i = 0; i<numbers3.length ;i++){ // per leggere un array bisogna usare un ciclo per farlo scorrere tutto mentre si stampa
            System.out.println(numbers3[i]);   
        } 
        for (int n : numbers) {
            System.out.println(n);
        }
            */
        // voglio andare ad inserire dentro l'array numbers, i quadrati dei primi 5 numeri
        // for(int i = 0; i<numbers.length ;i++){
        //     numbers[i]= (i+1)*(i+1);
        // }
        // calcolare e stampare la somma di tutti i valorei che sono nel array numbers
        // int S=0;
        // for(int i = 0; i<numbers.length ;i++){
        //     S=S+numbers[i];            
        // }
        // int M=0;
        // for(int i = 0; i<numbers.length ;i++){
        //     if(numbers[i] > M){
        //         M = numbers[i];
        //     }           
        // }
        //     Random dice = new Random(); 
        //     int[] numeri = new int[1000000];
        //     int Max=0; 
        //     for(int i = 0; i<numeri.length ;i++){
        //         numeri[i] = dice.nextInt(1000000);
        //         if(numeri[i] >= Max){
        //             Max = numeri[i];
        //         }           
        //     }
        //     System.out.println(Max);
        //     int z = 5;
        //     int count =0;
        //     for(int k=0; k<numbers.length;k++){
        //         if(numbers[k] == z){
        //             count++;
        //         }
        //     }
        //     System.out.println(count);
        // verifica se i numeri nel array sono ordinati in maniera crescente
        // Random dice = new Random();
        // boolean sorted = true;
        int[] number = new int[5];
        for(int i = 0; i<number.length ;i++){
            // number[i]= dice.nextInt(100);
            number[i]= i;
            System.out.println(number[i]);
        }
        // for(int k = 1; k<number.length ;k++){
        //     if(number[k]<number[k-1]){
        //         sorted = false;
        //         break;
        //     }
        // }
        // System.out.println(sorted);
        // for (int u : number) {
        //     System.out.print(u + " ");
        // }
        // int[] rebun = new int[number.length];
        // for (int f = 4,r=0; r<number.length;f--,r++){
        //     rebun[r] = number[f];
        //     System.out.println(rebun[r]);
        // }
        System.out.println("nuovo array");
        for (int r = number.length-1,f=0; f<r;f++,r--){
            int supp = number[r];
            number[r] = number[f];
            number[f] = supp;
        }        
        for (int i : number) {
            System.out.println(i);
        }
        
    }
    

}
