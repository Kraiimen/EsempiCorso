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
        
    }
}