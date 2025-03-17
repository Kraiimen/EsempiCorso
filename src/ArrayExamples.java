public class ArrayExamples {
    public static void main(String[] args) {

        // int numbers2[] = new int[5]; //another way to initialise an array
        // int x = 10;
        // int[] numbers3 = new int[x];
        // System.out.println(numbers[3]);
        // System.out.println(numbers[4]);
        // System.out.println(numbers);

        // numbers[2] = 100; //initialise the second element with a value of 100
        // numbers[4] = 200;

        // for (int i = 0; i < numbers.length; i++) {
        // System.out.println(numbers[i]);
        // }

        // for (int n : numbers) { // foreach
        // System.out.println(n);
        // }

        // inserire dentro l'array numberi i quadrati dei numeri da 1 a 5

        // int[] numbers = new int[5]; // array contains 5 integers
        // for (int i = 0; i < numbers.length; i++)
        // numbers[i] = (int) Math.pow(i + 1, 2);

        // // calcola e stampa la somma di tutti i valori che sono nell'array numbers
        // int sum = 0;
        // for (int i = 0; i < numbers.length; i++) {
        // sum += numbers[i];
        // }
        // System.out.println(sum);

        int[] numbersToMax = new int[10];
        int maxNumber = numbersToMax[0];

        for (int i = 1; i < numbersToMax.length; i++) {
            if (numbersToMax[i] > maxNumber) {
                maxNumber = numbersToMax[i];
            }
        }
        System.out.println(maxNumber);

    }

}
