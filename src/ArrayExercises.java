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

        // Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la cui somma è maggiore di 12

        // Esercizio 10: Trovare il numero che appare più volte nell'array -es [2, 7, 12, 7, 2] - se ci sono più valori che appaiono lo stesso numero di volte basta che il programma stampi uno di questi numeri

        numbers[0] = 1;
        numbers[1] = 2*2;
        numbers[2] = 3*3;
        numbers[3] = 4*4;
        numbers[4] = 5*5;

        for(int i = 0; i< numbers.length-1; i++){
            numbers[i] = (i+1)*(i+1);
        }
        for(int n : numbers){
            System.out.println(n);
        }
        
        
        int sum=0;
        for(int i = 0; i < numbers.length; i++){
             sum = sum + numbers[i];
        }
        int min = numbers [0];
        for(int i =0; i < numbers.lenght; i++){
            if(numbers[i] > max){
                min = numbers[i];
            }
        int sum = 0
        double average = numbers [0];
        for(int i =0; i < numbers.lenght; i++){
            sum = sum + numbers[i];
            average = sum % 5 ;
        }
         }
          int sum = 0
        double average = numbers [0];
        for(int i =0; i < numbers.lenght; i++){
            sum = sum + numbers[i];
            average = sum % 5 ;
        }
      
        int counter = 0;
        for(int i =0; i < numbers.lenght; i++){
           if(numbers[i] 2 % ==0){
                counter++; 
           }
                
        }        
        int x = 4;
        int countvalue = 0;
        for(int i =0; i < numbers.lenght; i++){
            if(x == numbers [i]){
                countValue++;
            }   
        }       

    
        int[] reverse = int [numbers.length];
        for(int i =0; i < numbers.lenght; i++){
            reverse [i] = numbers [numbers.length-1-i];
            System.out.print(reverse[i] + " " );
        } 
        int counter = 0;
        int z = 3;
        for(int i =0; i < numbers.lenght-1; i++){ 
            numbers[i];
            if(z == (numbers[i]+numbers[i++])){
                counter++
            }    

        }
            int[] numbers = new int[5];
    numbers[0] = 1;
    numbers[1] = 2;
    numbers[2] = 3;
    numbers[3] = 4;
    numbers[4] = 5;


        int counter = 0;
        int z = 3;
        for(int i =0; i < (numbers.length-1); i++){ 
            if((numbers[i]+ numbers[i + 1]) == z){
                counter++;
            }    

        }

        System.out.println(counter);

// Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la cui somma è maggiore di 12
        
        int sum = 12;

        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2*2;
        numbers[2] = 3*3;
        numbers[3] = 4*4;
        numbers[4] = 5*5;

        
        for(int i =0; i < (numbers.length-2); i++){
            if((numbers[i]+ numbers[i + 1] + numbers[i + 2]) > 12){




            }      
        }


    }
}