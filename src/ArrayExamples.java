import java.lang.Math;
public class ArrayExamples{
    public static void main(String[] args){
        int[] numbers = new int[5];
        // int numbers2[] = new int[5];
        // int x = 10;
        // int[] numbers3 = new int[x];
        // System.out.println(numbers[0]);
        // System.out.println(numbers[4]);
        // System.out.println(numbers);
        // numbers[1] = 100;
        // numbers[4] = 200;
        // for(int i = 0 ; i < numbers.length ; i++){
        //     System.out.println("Posizione: " + i + " Valore: " + numbers[i]);
        // }
        // for(int n : numbers){
        //     System.out.println(n);
        // }
        //voglio inserire dentro l'array numbers i quadrati dei numeri da 1 a 5
        // numbers[0] = 1;
        // numbers[1] = 2*2;
        // numbers[2] = 3*3;
        // numbers[3] = 4*4;
        // numbers[4] = 5*5;
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = (i + 1)*(i + 1);
        }
        for(int n : numbers){
            System.out.println(n);
        }
        //calcolare e stampare la somma di tutti i valori che sono nell'Array numbers.
        int sum = 0;
        for(int i = 0 ; i < numbers.length ; i++){
            sum = sum + numbers[i];
        }
        int max = numbers[0];
        for(int i = 1 ; i < numbers.length ; i++ ){
            if(numbers[i] > max){
                max = numbers[i];
            }
        }
        int counter = 0;
        for(int i = 1 ; i < numbers.length ; i++ ){
            if(numbers[i] % 2 == 0){
                counter ++;
            }
        }
        System.out.println(counter);
        
        int z = 4;
        int countValue = 0;
        for(int i = 0 ; i < numbers.length ; i++){
            if(numbers[i] == z){
                countValue ++;
            }
        }

        //verifica se i numeri nell'array sono ordinati in ordine crescente
        boolean sorted = true;
        for(int i = 1 ; i < numbers.length ; i++){
              if (numbers[i] < numbers[i-1]){
                sorted = false;
                break;
              }
        }
        if(sorted){
            System.out.println("L'array è ordinato");
        } else {
            System.out.println("L'array non è ordinato");
        }

        //voglio fare un ciclo for che mi stampa gli elementi dell'array separati da spazi
        //voglio del codice che crei un altro array di cinque elementi che contenta gli stessi
        //valori dell'array numbers ma al contrario
        for(int n : numbers){
            System.out.print(n + " ");
        }
        int [] reverse = new int [numbers.length];
        for(int i = 0 ; i < reverse.length ; i++){
            reverse[i] = numbers[numbers.length - 1 -i];
        }
        for(int n : reverse){
            System.out.print(n + " ");
        }

        //tecnica dei due indici
        for(int f = numbers.length - 1 , r = 0 ; r < numbers.length ; f-- , r ++){
            numbers[r] = reverse[f];
        }
         for(int n : numbers){
            System.out.print(n + " ");
        }

        //inverti l'array numbers sovrascrivendolo
        for(int f = numbers.length - 1 , r = 0 ; r < f ; f-- , r++){
            int temp = numbers[r];
            numbers[r] = numbers[f];
            numbers[f] = temp;
        }
        
    }
}