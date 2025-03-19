public class ArrayExercises {
    public static void main(String[] args) {

        // Esercizio 1: Creare un array di 5 interi e inizializzarlo con i primi numeri
        // da 1 a 5 al quadrato

        // int[] numbers = new int[5];
        // for (int i = 0; i < numbers.length; i++) {
        // numbers[i] = (int) Math.pow(i + 1, 2);
        // System.out.print(numbers[i] + " ");
        // }

        // Esercizio 2: Calcolare e stampare il valore della somma di tutti i numeri
        // contenuti nell'array

        // int[] numbers = new int[] { 5, 6, 4, 7, 8, 1, 8 };
        // int sum = 0;
        // for (int i = 0; i < numbers.length; i++) {
        // sum += numbers[i];
        // }
        // System.out.println(sum);

        // Esercizio 3: Calcolare e stampare il valore minimo contenuto nell'Array

        // int[] numbers = new int[] { 5, 6, 4, 7, 8, 1, 8 };
        // int minValue = numbers[0];
        // for (int number : numbers) {
        // if (number < minValue) {
        // minValue = number;
        // }
        // }
        // System.out.println(minValue);

        // Esercizio 4: Calcolare il valore medio dei numeri contenuti nell'array
        // (somma dei valori/numero di valori -- sarà un double)

        // int[] numbers = new int[] { 5, 6, 4, 7, 8, 1, 8 };
        // double average = 0;
        // double sum = 0;
        // for (int number : numbers) {
        // sum += number;
        // }
        // average = sum / numbers.length;
        // System.out.println(average);

        // Esercizio 5: Calcolare e stampare il numero di multipli di due che esistono
        // all'interno dell'array

        // int[] numbers = new int[] { 5, 6, 4, 7, 8, 1, 8 };
        // int evenCounter = 0;
        // for (int number : numbers) {
        // if (number % 2 == 0) {
        // evenCounter++;
        // }
        // }
        // System.out.println(evenCounter);

        // Esercizio 6: Dato un valore arbitrario (es int x = 4) calcolare e stampare il
        // numero di volte in cui l'array contiene il valore x

        // int[] numbers = new int[] { 5, 6, 4, 7, 8, 1, 8 };
        // int x = 8;
        // int xCounter = 0;
        // for (int number : numbers) {
        // if (number == x)
        // xCounter++;
        // }
        // System.out.println(xCounter);

        // Esercizio 7: Invertire l'array

        // int[] numbers = new int[] { 5, 6, 4, 7, 8, 1, 8 };
        // int forwardIndex;
        // int backwardIndex;
        // for (forwardIndex = 0, backwardIndex = numbers.length
        // - 1; forwardIndex < backwardIndex; forwardIndex++, backwardIndex--) {

        // int tmp = numbers[forwardIndex];
        // numbers[forwardIndex] = numbers[backwardIndex];
        // numbers[backwardIndex] = tmp;
        // }
        // for (int num: numbers) {
        // System.out.println(num);
        // }

        // Esercizio 8: Dato un numero arbitrario (es int z = 8)
        // verificare quante volte succede nell'array che ci siano due numeri
        // consecutivi la cui somma fa z

        // int[] numbers = new int[] { 1, 5, 5, 2, 8 };
        // int numberToCheck = 10;
        // int counter = 0;
        // for (int i = 0; i < numbers.length - 1; i++) {
        // if (numbers[i] + numbers[i + 1] == numberToCheck) {
        // counter++;
        // }
        // }
        // System.out.println(counter);

        // Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la
        // cui somma è maggiore di 12

        // int[] numbers = new int[] { 1, 6, 5, 2, 8 };
        // int numberToCheck = 12;
        // for (int i = 0; i < numbers.length - 2; i++) {
        // if (numbers[i] + numbers[i + 1] +numbers[i+2]> numberToCheck) {
        // System.out.println(numbers[i]+"+"+numbers[i+1]+"+"+numbers[i+2]+">"+numberToCheck);
        // }
        // }

        // Esercizio 10: Trovare il numero che appare più volte
        // nell'array -es [2, 7, 12, 7, 2] - se ci sono più valori
        // che appaiono lo stesso numero di volte basta che il programma stampi uno di
        // questi numeri

        int[] numbers = new int[] { 2, 7, 12, 7, 2 };
        int popularNumber=0;
        int popularCounter=0;

        // va per ogni numero e inizializza il suo counter
        for (int i = 0; i < numbers.length; i++) {
            int currentCounter = 0;
            /*
             * va nuovamente per ogni numero,
             * comparandoli e aumentando il counter
             * ogni volta che trova una copia
             * dal numero indicato dal primo for
             */
            for (int number : numbers) {
                if (numbers[i] == number) {
                    currentCounter++;
                }
            }
            if (currentCounter > popularCounter) {
                popularCounter = currentCounter;
                popularNumber = numbers[i];
            }
        }
        System.out.println("The most frequent number is :" + popularNumber);
        
        //
    }
}