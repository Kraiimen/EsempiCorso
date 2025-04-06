package eserciziIniziali.arrays;

public class ArrayExercises {
    public static void main(String[] args){
        int[] numbers = new int[5];
        for(int i = 0; i < numbers.length; ++i){
            numbers[i] = (i+1) * (i+1);
        }
        /*
        ------------------------------------GIA' FATTI-------------------------------------
        // Esercizio 1: Creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato
        // Esercizio 2: Calcolare e stampare il valore della somma di tutti i numeri contenuti nell'array
        // Esercizio 3: Calcolare e stampare il valore minimo contenuto nell'Array
        // Esercizio 4: Calcolare il valore medio dei numeri contenuti nell'array (somma dei valori/numero di valori -- sarà un double)
        // Esercizio 5: Calcolare e stampare il numero di multipli di due che esistono all'interno dell'array
        // Esercizio 6: Dato un valore arbitrario (es int x = 4) calcolare e stampare il numero di volte in cui l'array contiene il valore x
        // Esercizio 7: Invertire l'array
        ------------------------------------GIA' FATTI-------------------------------------
        //*/

        // Esercizio 8: Dato un numero arbitrario (es int z = 8) verificare quante volte succede nell'array che ci siano due numeri consecutivi la cui somma fa z
        //(COME L'HO SCRITTO IO) dato un int x, capire quante volte 2 numeri consecutivi nell'array danno come somma x
        int x = 13;
        int counter = 0;
        for(int i = 0; i < numbers.length-1; ++i){
            if(numbers[i] + numbers[i+1] == x){
                counter++;
            }
        }
        System.out.println(counter);

        // Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la cui somma è maggiore di 12
        //(COME L'HO SCRITTO IO) verificare se esiste almeno un caso in cui 3 numeri consecutivi nell'array hanno somma maggiore di 12
        boolean condition = false;
        for(int i = 0; i < numbers.length-2; ++i){
            if(numbers[i] + numbers[i+1] + numbers[i+2] > 12){
                condition = true;
                break;
            }
        }
        if(condition){
            System.out.println("succede");
        }else{
            System.out.println("non succede");
        }

        // Esercizio 10: Trovare il numero che appare più volte nell'array -es [2, 7, 12, 7, 2] - se ci sono più valori che appaiono lo stesso numero di volte basta che il programma stampi uno di questi numeri
        //(COME L'HO SCRITTO IO) stampare il numero con più occorrenze nell'array (a parità non ha importanza quale stampo)
        /*
        int[] occorrenze = new int[numbers.length];
        for(int i = 0; i < numbers.length; ++i){
            for(int j = i; j < numbers.length; ++j){
                if(numbers[i] == numbers[j]){
                    occorrenze[i]++;
                }
            }
        }
        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < occorrenze.length; ++i){
            if(max < occorrenze[i]){
                max = occorrenze[i];
                maxIndex = i;
            }
        }
        //*/

        int occorrenze = 1;
        int maxOccorrenze = 0;
        int maxIndex = 0;
        
        for(int i = 0; i < numbers.length; ++i){
            for(int j = i+1; j < numbers.length; ++j){
                if(numbers[i] == numbers[j]){
                    occorrenze++;
                }
            }
            if(maxOccorrenze < occorrenze){
                maxOccorrenze = occorrenze;
                maxIndex = i;
            }
        }
        
        System.out.println(numbers[maxIndex]);
    }
}