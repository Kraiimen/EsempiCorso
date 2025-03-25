public class ArrayProve {
    public static void main(String[] args) {

        // 1) Fai la somma dell'array

        int sum = 0;
        int[] array = {1, 2, 3, 4, 5};

        for(int i = 0 ; i < array.length; i++){
            sum = sum + array[i];
        }
        System.out.println(sum);

       // 2) Cerca il massimo ell'array

       int[] array2 = {10, 4, 20, 7, 15};
       int max = 0;

       for(int i = 0 ; i< array.length; i++){
          if(array2[i] > max){
            max = array2[i];
           }
        }
        System.out.println(max);

       // 3) Descrizione: Dato un array di numeri interi, conta quante volte un numero specificato (ad esempio, 5) appare nell'array.

       int[] array3 = {1, 5, 7, 5, 3, 5, 2};  // errore corretto attenzione alla denominazione degli array
       int numero = 5;
       int counter= 0;

       for(int i = 0 ; i < array3.length; i++){
            if(array3[i] == numero){
            counter++;
            }
        }
        System.out.println("il numero 5 è contenuto " + counter + ".");

        ///4)Descrizione: Dato un array di numeri interi, calcola la media dei numeri presenti nell'array.
    
        int[] array4 = {1, 2, 3, 4, 5};
        int somma = 0;
        int media = array4[0];

        for(int i = 0 ; i < array4.length; i++){
            somma = somma + array4[i];
        }
        media = somma / array4.length;
        System.out.println("La media dell' array è  " + media + ".");   


       // 5) Esercizio : Verifica se un array è ordinato in ordine crescente
       // Descrizione: Dato un array di numeri interi, verifica se gli elementi sono ordinati in ordine crescente (ogni elemento deve essere maggiore o uguale al precedente).

       int[] array5 = {1, 2, 3, 4, 5};
       boolean crescente = true;

       for(int i = 0 ; i < array4.length-1; i++){
          if(array5[i] > array5[i+1]){
            crescente = false;
            break;
          }
        } if(!crescente){ // oppure potremmo scrivere crescente == false
            System.out.println("I numeri non sono ordinati in ordine crescente");
        } else {
            System.out.println("I numeri sono ordinati in ordine crescente");
        }


        // 6) Esercizio : Invertire gli elementi di un array
        //Descrizione: Dato un array di numeri interi, inverti l'ordine degli elementi nell'array.
        //Obiettivo: Stampare l'array con gli elementi invertiti (in questo caso, [5, 4, 3, 2, 1]).
          
        int[] array6 = {1,2,3,4,5};
        int[] array7 = new int [array6.length];

        for(int i = 0 ; i < array6.length; i++){
            array7 [i]= array6[array6.length-1-i];
            System.out.print(array7[i] + " ");
            }


         System.out.println(); // per creare uno spazio vuoto

         // Secondo metodo per invertire l 'array' USANDO SOLO UN ARRAY
         
        for(int l = array6.length-1, f= 0; f < l ; l-- , f++){
            int temp = array6[f];
            array6 [f] = array6 [l];
            array6 [l] = temp;
        } for (int b = 0 ; b < array6.length; b++){
            System.out.print(array6[b] + " ");
        }

        //Esercizio 7: Contare quanti numeri sono pari in un array
        //Descrizione: Dato un array di numeri interi, conta quanti numeri pari ci sono nell'array.

        int[] array8 = {1, 2, 3, 4, 5, 6, 7 ,8 ,9 ,10};
        int counter7 = 0;
        for(int i = 0 ; i < array8.length; i++){
            if(array8[i]  % 2 == 0){
                counter7++;
            }
        }
        System.out.println("Il conteggio dei numeri pari è uguale " + counter7);

        

        //Esercizio 8: Trova l'indice di un elemento in un array
        //Descrizione: Dato un array di numeri interi e un numero specifico, trova l'indice del numero nell'array.

        int[] array9 = {10, 20, 30, 40};
        int numero1 = 30;
        for(int i = 0 ; i < array9.length; i++){
            if(array9[i] == numero1) {  // Confronta l'elemento dell'array con numero1
            System.out.println("L'indice di " + numero1 + " è: " + i);
            break;

            }
        }  
        
        //Esercizio 9: Unire due array in uno nuovo
        // Descrizione: Dati due array di numeri interi, uniscili in un nuovo array.

       int[] array10 = {1, 2, 3};
       int[] array11 = {4, 5, 6};
       int[] array12 = new int [array10.length + array11.length];
       
       for (int i = 0; i < array10.length; i++) {
        array12[i] = array10[i]; // aggiungiamo l array 10 in quell dodici
       }

       // Copiamo i valori di array11 in array12 (partendo dalla fine di array10)
       for (int i = 0; i < array11.length; i++) {
        array12[array10.length + i] = array11[i];
       }

       // Stampa tutti gli elementi di array12
       for (int b = 0; b < array12.length; b++) {
        System.out.print(array12[b] + ", ");
       }
  
       //Esercizio 10: Trovare il secondo numero più grande in un array
       //Descrizione: Dato un array di numeri interi, trova il secondo numero più grande.
       //Obiettivo: Stampare il secondo numero più grande nell'array (in questo caso, 45)
 
       int[] array13 = {10, 20, 4, 45, 99};
       int maxi = Integer.MIN_VALUE;  // Inizializza maxi al valore più basso possibile
       int maxi2 = Integer.MIN_VALUE; // Inizializza maxi2 al valore più basso possibile

       // Ciclo per trovare il massimo e il secondo massimo
       for(int i = 0; i < array13.length; i++) {
           if(array13[i] > maxi) {
               // Se l'elemento corrente è maggiore di maxi, aggiorna maxi e maxi2
               maxi2 = maxi;  // Il secondo massimo diventa il vecchio massimo
               maxi = array13[i];  // Maxi diventa il nuovo massimo
           } else if(array13[i] > maxi2 && array13[i] != maxi) {
               // Se l'elemento corrente è maggiore di maxi2 e diverso da maxi, aggiorna maxi2
               maxi2 = array13[i];
           }
       }

       // Stampa il massimo e il secondo massimo
       System.out.println("Il massimo è: " + maxi);
       System.out.println("Il secondo massimo è: " + maxi2);


    }
}
