public class ArrayExercises {
    public static void main(String[] args){
        // Esercizio 1: Creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato
        // int[] numbers = new int[5];
        // for (i = 0; i < numbers.length; i++){
        //     numbers[i] = (i + 1) * (i + 1);
        // }
       
        // // Esercizio 2: Calcolare e stampare il valore della somma di tutti i numeri contenuti nell'array
        //     int sum = 0
        //     for (i = 0; i < numbers.length; i++){
        //         sum = sum + numbers [i];
        //     }
        //      System.out.println( sum );
       
        // // Esercizio 3: Calcolare e stampare il valore minimo contenuto nell'Array
        // int min = numbers[0];
        // for (i = 0; i < numbers.length; i++){
        //     if numbers[i] < min{
        //         min = numbers[i];
        //     }
        // }
        // System.out.println ( min )

        // // Esercizio 4: Calcolare il valore medio dei numeri contenuti nell'array (somma dei valori/numero di valori -- sarà un double)
        // int sum = 0
        // for (i = 0; i < numbers.length; i++){
        //    sum = sum + numbers[i];
        // }
        // double media = sum / numbers.length;
        
        // // Esercizio 5: Calcolare e stampare il numero di multipli di due che esistono all'interno dell'array
        // int multipli = 0
        // for (i = 0; i < numbers.length; i++){
        //     if (numbers [i] % 2 == 0){
        //         multipli ++;
        //     }
        // }


        // // Esercizio 6: Dato un valore arbitrario (es int x = 4) calcolare e stampare il numero di volte in cui l'array contiene il valore x
        // int x = 4; 
        // int counter = 0;
        // for (i = 0; i < numbers.length; i++){
        //     if (numbers[i] == x){
        //         counter ++;
        //     }
        // }
        // System.out.println( counter )
        // // Esercizio 7: Invertire l'array
        // int[] reverse = new int [numbers.length];
        // for (i = 0; i < numbers.length; i++){
        //     reverse [i] = numbers [numbers.length -1 -i];
        //  }

        


        // Esercizio 8: Dato un numero arbitrario (es int z = 8) verificare quante volte succede nell'array che ci siano due numeri consecutivi 
        // la cui somma fa z
            int z = 8;
            int counter = 0;
            int numbers[] = {2,3,4,4,5,6};
       
            for (int i = 0; i < numbers.length - 1; i++){
            if (numbers [i] + numbers[i + 1] == z){
                counter ++;
                }
            }
            System.out.println("Nell'array ci sono due numeri consecutivi la cui somma è 4 " + counter + " volte" );


        // Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la cui somma è maggiore di 12
            boolean consecutivi = true;
           
            for (int i = 0; i < numbers.length - 2; i++){
            if(numbers[i] + numbers[i + 1] + numbers [i + 2] > 12){
                consecutivi = false;
                break;
                }
            }
            System.out.println ( consecutivi );

        // Esercizio 10: Trovare il numero che appare più volte nell'array -es [2, 7, 12, 7, 2] - 
        // se ci sono più valori che appaiono lo stesso numero di volte basta che il programma stampi uno di questi numeri
            int numbersNew[] = {2,7,12,7,2};
            
       
      
    }
}