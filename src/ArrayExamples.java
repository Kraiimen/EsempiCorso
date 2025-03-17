public class ArrayExamples {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        // int numbers2[] = new int [5];
        // int x = 10;
        // int[] numbers3 = new int[x];
        // System.out.println(numbers[0]);
        // System.out.println(numbers[4]);
        // System.out.println(numbers);
        // numbers[1] = 100;
        // numbers[4] = 200;
        // for(int i = 0; i < numbers.length; i++) {
        //     System.out.println("posizione: " + i + "valore: " + numbers[i]);
        // }
        // for(int n: numbers) {
        //     System.out.println(n);
        // }
        //volgio inserire dentro l'array numbers i quadrati dei numeri da 1 a 5
        for(int i = 0; i < numbers.length ; i++) {
            numbers[i] = (i + 1)*(i + 1);
        }
        for(int n : numbers) {
            System.out.println(n);
        }
        //calcolare e stampare tutti i valori che sono nell'Array numbers.
        int sum = 0;
        for(int i = 0; i < numbers.length ; i++) {
            sum = sum + numbers[i];
        }

        int max = numbers[0];

        for(int i = 1; i < numbers.length; i++) {
            if(numbers[i] > max) {
                max = numbers[i];
            }
        }

        //stampa tutti i numeri pari nell'array

        int counter = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                counter++;
            }
        }
        System.out.println(counter);

        int z = 4;
        int countValue = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == z){
                countValue++;
            }
        }
        System.out.println(countValue);

        //verifica se i numeri nell'array sono ordinati in maniera crescente;
        boolean sorted = true;
        for(int i = 1; i < numbers.length; i++) {
            if(numbers[i] < numbers[i-1]){
                sorted = false;
                break;
            }
        }
        if(sorted) {
            System.out.println("l'array è ordinato");
        }else {
            System.out.println("l'array non è ordinato");
        }

        //ciclo for che mi stampa tutti gli elementi dell'array sulla stessa riga

        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " "); 
        }

        //crea un array di 5 elementi che contenga gli stessi valori dell'array number ma al contrario

        int[] reverse = new int[numbers.length];
        for(int i = 0; i < reverse.length; i++) {
            reverse[i] = numbers[numbers.length-1-i];
            System.out.print(reverse[i] + " ");
        }
        //la variabile i va da 0 a number.length-1, cioè 4.   0  1  2  3  4 
        //l'espressione numbers.length-1-i
        System.out.print("\n");

        //tecnica dei due indici/puntatori

        for(int f = numbers.length-1, r = 0; r < numbers.length; f--, r++) {
            numbers[r] = reverse[f];

        }
        
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " "); 
        }

        //inverti l'array numbers sovrascrivendolo

        for(int f = numbers.length-1, r = 0; r < f; f--, r++) {
            int temp = numbers[r];
            numbers[r] = numbers[f];
            numbers[f] = temp;
        }
    }
}