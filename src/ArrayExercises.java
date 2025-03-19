public class ArrayExercises {
     public static void main(String[] args){
         
         // Esercizio 1: Creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato
         int[] numbers = new int[5];
         for(int i = 0 ; i < numbers.length ; i++){
             numbers[i]= (i+1)*(i+1);
         }
 
         // Esercizio 2: Calcolare e stampare il valore della somma di tutti i numeri contenuti nell'array
         int sum = 0;
         for(int i = 0 ; i < numbers.length ; i++){
             sum = sum + numbers[i];
         }
         System.out.println(sum);
 
         // Esercizio 3: Calcolare e stampare il valore minimo contenuto nell'Array
         int minVal = numbers[0];
         for(int i = 0 ; i < numbers.length ; i ++){
             if(numbers [i] < minVal){
                 minVal = numbers[i];
             }
         }
         System.out.println(minVal);
 
         // Esercizio 4: Calcolare il valore medio dei numeri contenuti nell'array (somma dei valori/numero di valori -- sarà un double)
         int totSum = 0;
         for(int i = 0 ; i < numbers.length ; i++){
             totSum = totSum + numbers[i];
         }
         double avgVal = (double)sum / numbers.length;
         System.out.println(avgVal);
 
         // Esercizio 5: Calcolare e stampare il numero di multipli di due che esistono all'interno dell'array
         int multiple = 0;
         for(int i = 0 ; i < numbers.length ; i++){
             if(numbers[i] % 2 == 0){
                 multiple++;
             }
         }
         System.out.println(multiple);
 
         // Esercizio 6: Dato un valore arbitrario (es int x = 4) calcolare e stampare il numero di volte in cui l'array contiene il valore x
         int count = 0;
         int x = 4;
         for(int i = 0 ; i < numbers.length; i ++){
             if(numbers[i] == x){
                 count++;
             }
         }
         System.out.println(count);
 
         // Esercizio 7: Invertire l'array
         for(int f = 0 , r = numbers.length - 1; f < r ; f++ , r--){
             int temp = numbers[f];
             numbers[f] = numbers[r];
             numbers[r] = temp;
         }
         for(int i = 0 ; i < numbers.length ; i++){
             System.out.print(numbers[i] + " ");
         }
 
 
         // Esercizio 8: Dato un numero arbitrario (es int z = 8) verificare quante volte succede nell'array che ci siano due numeri consecutivi la cui somma fa z
         int[] numbers2 = {2, 6, 2, 3, 5, 7, 1};
         int z = 8;
         int sumZ = 0;
         for(int i = 1 ; i < numbers2.length ; i++){
             if((numbers2[i] + numbers2[i-1]) == z){
                 sumZ ++;
             }
         }
         System.out.println(sumZ);
 
         // Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la cui somma è maggiore di 12
         int anotherSum;
         boolean moreThanTwelve = false;
         for(int i = 2 ; i < numbers2.length ; i++){
             if((numbers2[i] + numbers2[i-1] + numbers2[i-2]) > 12){
                 moreThanTwelve = true;
                 break;
             }
         }
         if (moreThanTwelve = false){
             System.out.println("Non ci sono tre numeri consecutivi la cui somma è maggiore di 12.");
         } else {
             System.out.println("Ci sono tre numeri consecutivi la cui somma è maggiore di 12.");
         }
 
         // Esercizio 10: Trovare il numero che appare più volte nell'array -es [2, 7, 12, 7, 2] - se ci sono più valori che appaiono lo stesso numero di volte basta che il programma stampi uno di questi numeri
         int[] numbers3 = {2, 7, 12, 7, 2};
         int repeatedNumber = 0;
         int maxRep = 0;
         for(int i = 0 ; i < numbers3.length ; i++){
             int counter = 0;
             for(int f = i ; f < numbers.length ; f++){
                 if(numbers3[i] == numbers3[f]){
                     counter++;
                 } 
                  if (counter > maxRep){
                         maxRep = counter;
                         repeatedNumber = numbers3[i];
                     }
             }
         }
         System.out.println("Il numero maggiore è " + repeatedNumber);
 
     }
 }