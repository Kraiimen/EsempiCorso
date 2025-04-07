package excercises;

import java.util.Random;

public class ArrayExercises {
    public static void main(String[] args){
        
        // Esercizio 1: Creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato
        // Esercizio 2: Calcolare e stampare il valore della somma di tutti i numeri contenuti nell'array
        // Esercizio 3: Calcolare e stampare il valore minimo contenuto nell'Array
        // Esercizio 4: Calcolare il valore medio dei numeri contenuti nell'array (somma dei valori/numero di valori -- sarà un double)
        // Esercizio 5: Calcolare e stampare il numero di multipli di due che esistono all'interno dell'array
        // Esercizio 6: Dato un valore arbitrario (es int x = 4) calcolare e stampare il numero di volte in cui l'array contiene il valore x
        // Esercizio 7: Invertire l'array


        // Esercizio 8: Dato un numero arbitrario (es int z = 8) verificare quante volte succede nell'array che ci siano due numeri consecutivi la cui somma fa z

            Random random = new Random(); // Il random è stato aggiunto per rendere l'inizializzazione dell'array casuale
            
            int numbers[] = new int[5]; // Array che conterrà i numeri casuali
            int z = 8; // Numero arbitrario
            int zSumCount = 0; // Contatore per il numero di coppie di numeri consecutivi la cui somma è uguale a z
            
            // Inizializziamo l'array con numeri randomici da 0 a 5
            for(int i = 0; i < numbers.length; i++){
                int randomNumber = random.nextInt(6);
                numbers[i] = randomNumber;
            }
            
            // Ciclo per il controllo della somma di coppie di numeri
            for (int i = 0; i < numbers.length - 1; i++) {
                // Se la somma dei due numeri consecutivi è uguale a z
                if(numbers[i] + numbers[i+1] == z){
                    zSumCount++; // Aumentiamo il contatore per stampare quante volte succede
                }
            }

            // Stampiamo i valori dell'array
            System.out.print("Array: ");
            for (int i : numbers) {
                System.out.print(i + " ");
            }
            
            // Stampiamo quante volte la somma di due numeri consecutivi è uguale a z
            System.out.println("\n- Nell'array la somma di due numeri consecutivi, la cui somma fa "+z+", accade "+zSumCount+" volte.");


        // Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la cui somma è maggiore di 12
            
            boolean threeNumbers = false; // Variabile per sapere se ci sono o meno i 3 numeri consecutivi

            for (int i = 1; i < numbers.length - 1; i++) {
                // Se la somma di 3 numeri consecutivi è maggiore di 12
                if(numbers[i-1] + numbers[i] + numbers[i+1] > 12){
                    threeNumbers = true; // Impostiamo la variabile a vero
                        
                    // Se la variabile è vera, quindi ci sono i 3 numeri consecutivi la cui somma è maggiore di 12
                    if (threeNumbers) {
                        // Stampiamo i 3 numeri consecutivi per confermare che la loro somma è maggiore di 12
                        System.out.println("- Nell'array la somma dei numeri consecutivi ["+numbers[i-1]+", "+numbers[i]+", "+numbers[i+1]+"] è maggiore di 12");
                    }
                }
            }

            // Se non ci sono 3 numeri consecutivi la cui somma è maggiore di 12
            if(!threeNumbers){
                System.out.println("- Nell'array non ci sono tre numeri consecutivi la cui somma è maggiore di 12");
            }

        // Esercizio 10: Trovare il numero che appare più volte nell'array -es [2, 7, 12, 7, 2] - se ci sono più valori che appaiono lo stesso numero di volte basta che il programma stampi uno di questi numeri
            
            int numbersCount[] = new int[5]; // Array per contenere i valori di quante volte un numero compare nell'array

            // Ciclo per calcolare quante volte i valori appaiono nell'array
            for (int i = 0; i < numbers.length; i++) {
                int count = 0; // Il contatore si resetta ad ogni ciclo

                for (int j = 0; j < numbers.length; j++) {
                    // Se il numero appare più volte
                    if(numbers[i] == numbers[j]){
                        count++; // Il contatore aumenta
                    }
                }

                numbersCount[i] = count; // Inseriamo il valore finale del numero di questo ciclo all'interno dell'array
            }

            int max = numbersCount[0]; // Variabile per il calcolo del numero che si ripete più volte
            int frequentNumber = -1; // Variabile per poi stampare il primo numero trovato che si ripete almeno una volta

            // Ciclo per il calcolo del numero che si ripete più volte
            for (int i = 1; i < numbersCount.length; i++) {

                // Se il numero di ripetizioni è diverso da 1 ed è maggiore o uguale del max
                if(numbersCount[i] != 1 && numbersCount[i] > max){
                    max = numbersCount[i]; // Aggiorniamo il max 
                    frequentNumber = numbers[i]; // Salviamo il numero che si ripete più volte
                }
            }

            // Se la variabile ha un valore diverso dall'inizializzazione
            if(frequentNumber != -1){
                System.out.println("- Il numero "+frequentNumber+" appare più volte nell'array");
            }  
            // Altrimenti la variabile contiene il valore di inizilizzazione, ovvero non ci sono numeri che si ripetono più di una volta
            else {
                System.out.println("- Non ci sono numeri che appaiono più volte nell'array");
            }
    }
}