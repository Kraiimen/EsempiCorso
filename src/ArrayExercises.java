



public class ArrayExercises {
    public static void main(String[] args){
        
        // Esercizio 1: Creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato
        int[] numbers = new int[5];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (i + 1)*(i +1);
        }
        for(int n : numbers) {
            System.out.println(n); 
        }         
        System.out.println(" ");

        // Esercizio 2: Calcolare e stampare il valore della somma di tutti i numeri contenuti nell'array
        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            sum  = sum + numbers[i];             
        }
        System.out.println(sum);
        System.out.println(" "); 

        // Esercizio 3: Calcolare e stampare il valore minimo contenuto nell'Array
        int min = 0;
        for( int i = 0; i < numbers.length; i++) {
            min = numbers.length - (numbers.length - 1);            
        }
        System.out.println(min);
        System.out.println(" ");

        // Esercizio 4: Calcolare il valore medio dei numeri contenuti nell'array (somma dei valori/numero di valori -- sarà un double)        
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = (i + 1)*(i +1);            
        } 
        double media = sum / numbers.length; 
        System.out.println(media); 
        System.out.println(" ");

        // Esercizio 5: Calcolare e stampare il numero di multipli di 2 che esistono all'interno dell'array
        int multipli2 = 0;    
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                System.out.println(numbers[i]); 
            }    
        }
        System.out.println(" ");

        // Esercizio 6: Dato un valore arbitrario (es int x = 4) calcolare e stampare il numero di volte in cui l'array contiene il valore x
        int x = 4;
        int xTimes = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 4) {
                xTimes++;
                System.out.println(xTimes);
            }
        }
        System.out.println(" "); 

        // Esercizio 7: Invertire l'array       
        int[] reverse = new int[numbers.length]; 
        for(int i = 0; i < numbers.length; i++) {
            reverse[i] = numbers[numbers.length - 1 - i]; 
            System.out.println(reverse[i]);
        }
        System.out.println(" ");

        // Esercizio 8: Dato un numero arbitrario (es int z = 8) verificare quante volte succede nell'array che ci siano due numeri consecutivi la cui somma fa z
        int z = 8;
        int counterZ = 0;
        int i = 0;
        int[] zArrey = new int [numbers[i] + numbers[i + 1]];  
        for(int iZ = 0; iZ < zArrey.length; iZ++) { 
            if(numbers[i] + numbers[i + 1] == z) { 
                System.out.println(counterZ);
                counterZ++;                                
            } else {
                System.out.println("0");
                break;
            }
        }        
        System.out.println(" ");

        // Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la cui somma è maggiore di 12
        int sumT = 12; 
        boolean treFattori = true; 
        int[] tris = new int [numbers[i] + numbers[i + 1] + numbers[i + 2]];
        for(int iT = 0; iT < tris.length; iT++) { 
            if(numbers[i] + numbers[i + 1] + numbers[i + 2] == sumT) { 
                System.out.println(treFattori);  
                break;                             
            } else {
                System.out.println(!treFattori); 
                break;
            }   
        }
        System.out.println(" ");

        // Esercizio 10: Trovare il numero che appare più volte nell'array -es [2, 7, 12, 7, 2] - se ci sono più valori che appaiono lo stesso numero di volte basta che il programma stampi uno di questi numeri
        int numbersCount[] = new int[5]; // Array per contenere i valori di quante volte un numero compare nell'array

        // Ciclo per calcolare quante volte i valori appaiono nell'array
        for(int iZ = 0; iZ < numbers.length; iZ++) {
            int count = 0; // Il contatore si resetta ad ogni ciclo

            for (int j = 0; j < numbers.length; j++) {
                // Se il numero appare più volte
                if(numbers[iZ] == numbers[j]){
                    count++; // Il contatore aumenta
                }
            } 

            numbersCount[iZ] = count; // Inseriamo il valore finale del numero di questo ciclo all'interno dell'array
        }

        int max = numbersCount[0]; // Variabile per il calcolo del numero che si ripete più volte
        int frequentNumber = -1; // Variabile per poi stampare il primo numero trovato che si ripete almeno una volta

        // Ciclo per il calcolo del numero che si ripete più volte
        for (int iD = 1; iD < numbersCount.length; iD++) {

            // Se il numero di ripetizioni è diverso da 1 ed è maggiore o uguale del max
            if(numbersCount[iD] != 1 && numbersCount[iD] > max){
                max = numbersCount[iD]; // Aggiorniamo il max 
                frequentNumber = numbers[iD]; // Salviamo il numero che si ripete più volte
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
        // un for dentro un for con due contatori diversi, tipo "i" e "k", con il ciclo for normale 

    }
}