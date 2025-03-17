

public class ArrayExercises {
    public static void main(String[] args) {
        //Esercizio 1: Creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato



        
        //Esercizio 2: Calcolare e stampare il valore della somma di tutti i numeri contenuti nell'array




        //Esercizio 3: Calcolare e stampare il valore minimo contenuto nell'array



        
        //Esercizio 4: Calcolare il valore medio dei numeri contenuti nell'array(somma dei valori/numero di valori -- sarà un double)
        // double[] array4 = {5.0,7.0,9.0,12.0,15.0};
        // double sum = 0;
        // for(int i = 0; i < array4.length; i++) {
        //     sum += array4[i];
        // }
        // double valoreMedio = sum/array4.length;
        // System.out.println(valoreMedio);

        //Esercizio 5: Calcolare e stampare il numero di multipli di due che esistono all'interno dell'array





        //Esercizio 6: Dato un valore arbitrario es(int x = 4) calcolare e stampare il numero di volte in cui l'array contiene il valore x





        //Esercizio 7: Crea un codice che inverte un array

        // int[] array7 = {1,2,3,4,5,6,7,8,9,10}
        // for(int i = 0, r = array7.length-1; i < r; r--, i++) {
        //      int storeValue = array7[r];
        //      array7[r] = array7[i];
        //      array7[i] = storeValue;
             
        // }
        //     for(int b = 0; b < array7.length; b++) {
        //         System.out.println(array7[b]);
        //     }
            
        //Esercizio 8: Dato un numero arbitrario es.(int z = 4), 
        //verificare quante volte succede nell'array che ci siano due numeri consecuitivi la cui somma fa z

        int[] array8 = {2,2,1,2,2,1,2,2};
        int z = 4;
        int counter = 0;
        for(int i = 0; i < array8.length -1; i++) {
            if(array8[i] + array8[i+1] == z) {
                counter++;
            }    
        }
        //System.out.println(counter); //Counter per check, non fa parte della consegna


        //Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la cui somma è maggiore di 12

        // int[] array9 = {0,2,6,6,2,1,1,3};
        // boolean check = true;
        // for(int i = 0; i < array9.length-2; i++) {
        //     if(array9[i] + array9[i+1] + array9[i+2] < 12) {
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
        outer:for(int i = 0; i < array10.length; i++) {
            boolean check = true;
            for(int j = 0; i < array10.length; i++) {
                if(array10[i] == array10[j]) {
                    System.out.println(array10[j]);
                    // break outer;
                    check = false;
                    break;

                }
                
            }
            if(check == false) {
                break;
            }
        }
    }

}

