

public class ArrayExercises {
    public static void main(String[] args) {
        //Esercizio 1: Creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato

        //int[] squareNumbers = new int[5];
        //for(int i = 0; i < squareNumbers.length-1; i++) {squareNumbers[i] = (i+1) * (i+1);
        //}

        //Esercizio 1.5 assegna all'array il quadrato di un qualsiasi numero all'interno di un array

        // for(int es2 = 0; es2 < squareNumbers.length-1; es2++) {
        //     squareNumbers[es2] = squareNumbers[es2] * squareNumbers[es2];
        //     System.out.println(squareNumbers[es2]); //Check
        // }
        


        
        //Esercizio 2: Calcolare e stampare il valore della somma di tutti i numeri contenuti nell'array

        // int sum = 0;
        // for (int es2 = 0; es2 < 5; es2++) {
        //     sum += squareNumbers[es2];
        // }
        // System.out.println(sum);




        //Esercizio 3: Calcolare e stampare il valore minimo contenuto nell'array




        
        //Esercizio 4: Calcolare il valore medio dei numeri contenuti nell'array(somma dei valori/numero di valori -- sarà un double)

        // double[] array4 = {5.0,7.0,9.0,12.0,15.0};
        // double sum = 0;
        // for(int es4 = 0; es4 < array4.length; es4++) {
        //     sum += array4[es4];
        // }
        // double valoreMedio = sum/array4.length;
        // System.out.println(valoreMedio);


        //Esercizio 5: Calcolare e stampare il numero di multipli di due che esistono all'interno dell'array




        //Esercizio 6: Dato un valore arbitrario es(int x = 4) calcolare e stampare il numero di volte in cui l'array contiene il valore x




        //Esercizio 7: Crea un codice che inverte un array

        // int[] array7 = {1,2,3,4,5,6,7,8,9,10};
        // for(int es7 = 0, es7_1 = array7.length-1; es7 < es7_1; es7_1--, es7++) {
        //      int storeValue = array7[es7_1];
        //      array7[es7_1] = array7[es7];
        //      array7[es7] = storeValue;
             
        // }
        //     for(int b = 0; b < array7.length; b++) {
        //         System.out.println(array7[b]);
        //     }
            
        //Esercizio 8: Dato un numero arbitrario es.(int z = 4), 
        //verificare quante volte succede nell'array che ci siano due numeri consecuitivi la cui somma fa z

        // int[] array8 = {2,2,1,2,2,1,2,2};
        // int z = 4;
        // int counter = 0;
        // for(int es8 = 0; es8 < array8.length -1; es8++) {
        //     if(array8[es8] + array8[es8+1] == z) {
        //         counter++;
        //     }    
        // }
        // System.out.println(counter); 

        //Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la cui somma è maggiore di 12

        // int[] array9 = {0,2,6,6,2,1,1,3};
        // boolean check = true;
        // for(int es9 = 0; es9 < array9.length-2; es9++) {
        //     if(array9[es9] + array9[es9+1] + array9[es9+2] < 12) {
        //         System.out.println("nessuna somma di 3 valori consecutivi supera 12");
        //         check = false;
        //         break;
        //     }
        // }
        // if(check == true) {
        //     System.out.println("la somma di 3 numeri consecutivi è maggiore di 12");
        // }


        //Esercizio 10: Trovare il numero che appare più volte nell'array [2, 7 , 12, 7 , 2] - se i due valori più comuni appaiono lo stesso numero di volte stamparne solo 1.

        int[] array10 = {2,7,12,7,2};
        int counter = 0;
        int maxCount = 0;
        outer:for(int es10 = 0; es10 < array10.length; es10++) {
            boolean check10 = true;
            for(int es10_2 = 0; es10_2 < array10.length; es10_2++) {
                if(array10[es10] == array10[es10_2]) {
                    counter++;
                    
                    System.out.println(array10[es10_2]);
                    // break outer;
                    if(counter > maxCount){
                        maxCount = counter;
                    }

                    break;
                }
            }
        }

        //ESERCIZIO 11 ORDINA UN ARRAY IN ORDINE CRESCENTE CON IL BUBBLE SORT
        int[] array11 = {555,3,11,76,99,123,155};
        boolean swapped;

        for(int i = 0; i < array11.length-1; i++){
            //swapped = false;
            //for(int j = 0; j < array11.length; j++){
                if(array11[i] > array11[i+1]){
                    int temp = array11[i];
                    array11[i] = array11[i+1];
                    array11[i+1] = temp;
                }
            }
        for (int es11 = 0; es11 < array11.length-1; es11++){
            System.out.print(array11[es11] + " ");
        }

        //}
    }
}

