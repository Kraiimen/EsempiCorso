import java.util.Random;

public class ArrayExercises {
    public static void main(String[] args){

        // stampo gli argomenti del programma
        
        for(String s : args){
            System.out.println(s);
        }

        // Esercizio 1: Creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato

        int[] numbers = new int[5];

        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = (i + 1)*(i + 1);
        }
        for(int n : numbers){
            System.out.println(n);
        }

        // Esercizio 2: Calcolare e stampare il valore della somma di tutti i numeri contenuti nell'array

        int sum = 0;
        for(int i = 0 ; i < numbers.length ; i++){
            sum = sum + numbers[i];
        }

        // Esercizio 3: Calcolare e stampare il valore minimo contenuto nell'Array

        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            if(numbers[i] < min){
                min = numbers[i];
            }
        }

        // Esercizio 4: Calcolare il valore medio dei numeri contenuti nell'array (somma dei valori/numero di valori -- sarà un double)

        double middleValue = 0.0;
        int sum2 = 0;
        for (int i = 0; i < numbers.length; i++){
            sum2 += numbers[i];
            middleValue = sum2 / numbers.length;
        }
        System.out.println("la media dei valori è " + middleValue);

        // Esercizio 5: Calcolare e stampare il numero di multipli di due che esistono all'interno dell'array

        int evenNumbers = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] % 2 == 0){
                evenNumbers ++;
            }
        }
        System.out.println("il numero di numeri divisibili per due presenti nell'array è " + evenNumbers);

        // Esercizio 6: Dato un valore arbitrario (es int x = 4) calcolare e stampare il numero di volte in cui l'array contiene il valore x

        int x = 4;
        int counterX = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == x){
                counterX ++;
            }
        }
        System.out.println("il valore 4 compare " + counterX + " volte nell'array");

        // Esercizio 7: Invertire l'array

        for (int j = numbers.length-1, i = 0; i < numbers.length / 2; j--, i++){
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
            // int temp = numbers[i];
            // numbers[i] = numbers[numbers.length - i - 1];
            // numbers[numbers.length - i - 1] = temp;
        }
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
        
        System.out.print("\n");

        // Esercizio 8: Dato un numero arbitrario (es int z = 8) verificare quante volte succede nell'array che ci siano due numeri consecutivi la cui somma fa z

        int[] random = new int[5];
        Random dice = new Random();
        
        for(int i = 0; i < random.length; i++){
            random[i] = dice.nextInt(8);
            System.out.print(random[i] + " ");
        }

        int z = 8;
        int counterZ = 0;
        for (int i = 0; i < random.length-1; i++){
            if (random[i] + random[i + 1] == z) {
                counterZ ++;
            }
        }
        System.out.println("\n" + counterZ + " coppie di valori consecutivi hanno come somma 8");

        // Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la cui somma è maggiore di 12

        boolean verifySum = true;
        for(int i = 0; i < numbers.length-2; i++){
            if (numbers[i] + numbers[i + 1] + numbers[i + 2] > 12) {
                verifySum = false;
                break;
            }
        }

        if (verifySum) {
            System.out.println("non sono presenti 3 numeri consecutivi la cui somma è maggriore di 12");
        } else {
            System.out.println("sono presenti 3 numeri consecutivi la cui somma è maggriore di 12");
        }

        // Esercizio 10: Trovare il numero che appare più volte nell'array -es [2, 7, 12, 7, 2] - se ci sono più valori che appaiono lo stesso numero di volte basta che il programma stampi uno di questi numeri

        int[] repetition;
        repetition  = new int[] {1, 7, 12, 7, 2};
        
        int maxNum = repetition[0];
        int maxCounter = 0;
        
        for(int i = 0; i < repetition.length; i++){
            int newCounter = 0;
            for (int j = 0; j < repetition.length; j++){
                if (repetition[i] == repetition [j]){
                    newCounter ++;
                }
            }
            if (newCounter > maxCounter){
                maxCounter = newCounter;
                maxNum = repetition[i];
            }
        }

        System.out.print("il numero che compare più volte è " + maxNum);

    }
} 


