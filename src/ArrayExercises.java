import java.util.Random;

public class ArrayExercises {
    public static void main(String[] args){
        
        // 1) Esercizio : Creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato
        int[] number = new int[5];
        // number[0] = 1;
        // number[1] = 2*2;
        // number[2] = 3*3;
        // number[3] = 4*4;
        // number[4] = 5*5;
        for(int i = 0; i < number.length; i++){
           number[i]= (i+1)*(i+1);
            System.out.println(number[i]);
           }
         // per ciacun numero in number ,ad ogni escuzione n va avanti  
        for(int n : number){
            System.out.println(n);

        }


        // 2) Esercizio: Calcolare e stampare il valore della somma di tutti i numeri contenuti nell'array

        int sum = 0;
        for( int i = 0; i < number.length; i++){ // incrementa di uno i per ogni iterazione  per incrementare i+=
             sum = sum + number[i];
        }
             System.out.println(sum);

        // 3) Esercizio : Calcolare e stampare il valore minimo contenuto nell'Array
         
         int[] numMin = {5,4,3,2,1};
         int min = numMin[0];
         for(int i = 1; i < numMin.length; i++){
            if(numMin[i] < min){
                min = numMin[i];
            }
         }
         System.out.println(min);


        // 4) Esercizio : Calcolare il valore medio dei numeri contenuti nell'array (somma dei valori/numero di valori -- sarà un double)

         double media = 0;
         int somma = 0;
        for( int i = 0; i < number.length; i++){
            somma = somma + number[i];
        }
        media = somma / number.length;
        System.out.println(media);

        // 5) Esercizio : Calcolare e stampare il numero di multipli di due che esistono all'interno dell'array

        int counter = 0;
        
        for( int i = 0; i < number.length; i++){
            if(number[i] % 2 == 0){
               counter++;
            }
        }
        System.out.println("Numero di multipli di 2: " + counter);


        //6)  Esercizio: Dato un valore arbitrario (es int x = 4) calcolare e stampare il numero di volte in cui l'array contiene il valore x

        int x = 4;
        int countValue = 0;

        for( int i = 0; i < number.length; i++){
            if(number[i] == x){
                countValue++; // ogni volta che un numero è uguale a x incremnta di uno 
            }
        }
        System.out.println("x appare: " + countValue);



        // 7) Esercizio : Invertire l'array

        int[] reversal = new int [number.length]; // creazione dell array intero , dandogli solo la stessa dimensione dell array number 

         for (int i = 0 ; i < number.length; i++){
            reversal[i] = number[number.length-1-i];// 1 4 9 16 25  number ripendiamo l arrey dichiarato, number.length-1(equivale all ultimo elemento dell array e lo sottrarremo a i che aumento di 1 per ogni iterazione)
            System.out.print(reversal[i] + " "); //     25 16 9 4 1                                       
         }

         for(int e = number.length-1 , s=0; s < e; e-- , s++){
            int tempo = number[e];
            number[e] = number[s];
            number[s] = tempo;
           } for(int b = 0; b < number.length; b++){
            System.out.print(number[b] + " ");
           }
         


        // Esercizio: Dato un numero arbitrario (es int z = 8) verificare quante volte succede nell'array che ci siano due numeri consecutivi la cui somma fa z
        
        int[] array8 = {4,4,2,3,4,4,2,4,4,2,2};
        int z = 8;
        int consecutivo = 0;
        for( int i = 0; i < array8.length-1; i++){
            if(array8[i] + array8[i+1] == z){ // somma per calcolare due numeri consecutivi
                consecutivo++;
            }  
        }
        System.out.println("Il numero di coppie consecutive la cui somma è " + z + " è: " + consecutivo);

        // Esercizio 9: Verificare che nell'array non esistono tre numeri consecutivi la cui somma è maggiore di 12

        int[] array9 = {1,2,3,4,5,6,7,8,9,10};
        boolean treNumeri = false;
        int xp = 12;
        int counter2 = 0;

        for( int i = 0; i < array9.length-2; i++){
            if(array9[i] + array9[i+1] + array9[i+2] > xp){
                treNumeri = true;
                System.out.println("Questi sono i 3 numeri: " + array9[i] + ", " + array9[i+1] + ", " + array9[i+2] + " sono maggiori di 12");
                counter2++;
            } 
        }
        
        if(treNumeri == false){
            System.out.println("nell array non ci sono tre numeri consecutivi la cui somma è 12");
        } else {
            System.out.println("Il numero delle triadi:"+ counter);
        }
        
        
        // Esercizio 10: Trovare il numero che appare più volte nell'array -es [2, 7, 12, 7, 2] - se ci sono più valori che appaiono lo stesso numero di volte basta che il programma stampi uno di questi numeri
        
         
        int[] array10 = {2, 7, 12, 7, 2};
        int numRipetuti= 0; // quante volte appare il numer
        int maxRecap= 0;
        int counter3 = 0;
    // Facciam due cicli for per confronatre lo stesso array e contare gli stessi 
        for(int i = 0 ; i < array10.length; i++){
            for(int j = 0 ; j < array10.length; j++){
                if(array10[i] == array10[j]){
                    counter3++;
                }
                if(counter3 > maxRecap){
                    maxRecap= numRipetuti;
                    numRipetuti= array10[i];
                }

            }
        }       
         System.out.println("Il numero che viene ripetuto è: " + numRipetuti + " ed è stato ripetuto" + counter3);
 
       
     


    }
}