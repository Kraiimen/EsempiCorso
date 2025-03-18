public class ArrayExercises {
    public static void main(String[] args){
        
        // Esercizio 1: Creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato
        // int[] arrayPrimi = new int[5] ;
        // int i = 0;
        // for (i=0 ; i < arrayPrimi.length ; i++) {
        //     arrayPrimi [i] = (i + 1 ) * ( i + 1 );
        //     System.out.println(arrayPrimi[i]);
        // }
        

    

         // Esercizio 2: Calcolare e stampare il valore della somma di tutti i numeri contenuti nell'array
        // int[] somma = new int[5];
        // int totale = 0; 
        // for (int i = 0 ; i < somma.length ; i++) {
        //     somma[i] = 0+i;
        //     totale = somma[i] + totale;
        // }
        // System.out.println(totale);

        // Esercizio 3: Calcolare e stampare il valore minimo contenuto nell'Array
        // int[] min = new int[5];
        // int minValue = min.length+1;
        // for (int i = 0 ; i < min.length ; i++) {
        //     min[i] = i;
        // }
        // for (int i = 0 ; i < min.length ; i++) {
        //     if(min[i]< minValue) {
        //         minValue = min[i];
        //     }
            
        // }
        // System.out.println(minValue);
        
        

        // Esercizio 4: Calcolare il valore medio dei numeri contenuti nell'array (somma dei valori/numero di valori -- sarà un double)
        // int[] medio = new int[5];
        // double temp = 0;
        // for(int i = 0 ; i < medio.length ; i++) {
        //     medio[i] = i+10;
        //  }
        //  for(int i = 0 ; i < medio.length ; i++) {
        //     temp = temp+medio[i];
            
        //  }
        //  temp = temp/5;
        //  System.out.println(temp);

        // Esercizio 5: Calcolare e stampare il numero di multipli di due che esistono all'interno dell'array
        // int[] multipli = new int[5];
        // for(int i = 0 ; i < multipli.length ; i++) {
        //    int risultato = multipli[i]+i;
        //    if (risultato %2==0){
        //         System.out.println(risultato);
        //    }
           
        // }

        // Esercizio 6: Dato un valore arbitrario (es int x = 4) calcolare e stampare il numero di volte in cui l'array contiene il valore x
        // int[] numero = { 3, 7, 29, 4, 4} ;
        // int x = 4; 
        // int counter = 0;
        // for(int i = 0 ; i < numero.length ; i++) {
        //     if(x == numero[i]) {
        //         counter++;               
        //     }
        // }
        // System.out.println("il numero di volte che x compare nell'array è " + counter);

        // Esercizio 7: Invertire l'array
        
        int[] vet1 = {7, 3, 11,17,18};
        System.out.println(vet1[0]);
        System.out.println(vet1[vet1.length-1]);

        // Esercizio 8: Dato un numero arbitrario (es int z = 8) verificare quante volte succede nell'array che ci siano due numeri consecutivi la cui somma fa z

        // Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la cui somma è maggiore di 12

        // Esercizio 10: Trovare il numero che appare più volte nell'array -es [2, 7, 12, 7, 2] - se ci sono più valori che appaiono lo stesso numero di volte basta che il programma stampi uno di questi numeri
    }
} 


