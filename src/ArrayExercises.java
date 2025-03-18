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

        int sum=0;                                                          //crea una variabile "sum" per contenere la somma dei valori dell'array
        double average;                                                     //crea una variabile "average" per contenere il risultato della media dei valori dell'array
        int min = 0;                                                        //crea una variabile "min" per contenere il valore più basso dell'array
        int multiple2= 0;                                                   //crea una variabile "multiple2" per contenere il numero dei valori pari dell'array
        int x=4;                                                            //crea una variabile "x" per confrontare il suo contenuto con i valori dell'array
        int countx=0;                                                       //crea una variabile "counterx" per contare il numero di valori dell'array uguali al contenuto di x
        int z=8;                                                            //crea una variabile "z" e la inizializza
        boolean state1= true;                                               //crea una variabile boolean "state1" e la imposta a true
        int[] array = new int[5];                                           //crea un array d'interi, di nome "array" con una dimensione pari a 5
        int countSumZ=0;                                                    //crea una variabile intera per contare il numero di coppie di valori con somma uguale a z
        int maxRepeatedNumber=1;                                            //crea una variabile intera per contenere il numero di volte in cui un valore viene ripetuto
        int countNumbers=1;                                                 //crea una variabile intera per contare il numero di valori che vengono ripetuti nell'array
        int cell=0;                                                         //crea una variabile intera per contenere il valore ripetuto più volte nellàarray


        //ciclo esercizi 1,2,3,5,6
        for(int i=0; i < array.length ; i++){
            array[i] = (i+1)*(i+1);
            sum+=array[i];
            if(state1){
                min=array[i];
                state1=false;
            }
            if(array[i]<min){
                min=array[i];
            }
            if(array[i]%2==0){
                multiple2++;
            }
            if(array[i]==x){
                countx++;
            }
        }

        //ciclo esercizio 7
        for(int i=0, j=array.length-1; i<j; i++, j--){
            int temp=array[j];
            array[j]=array[i];
            array[i]=temp;
        }

        //ciclo esercizio 8
        for(int i=0; i<array.length-1; i++){                     
            if(array[i]+array[i+1]==z){
            countSumZ++;
            }
        }

        //ciclo esercizio 9
        for(int i=0; i<array.length-2;i++){
            if(array[i]+array[i+1]+array[i+2]>12){
                System.out.println("3 numeri consecutivi danno come somma un numero maggiore di 12");
                break;
            }else{
                System.out.println("3 numeri consecutivi non danno come somma un numero maggiore di 12");
            }
        }

        //ciclo esercizio 10
        for(int i=0; i<array.length; i++){
            if(maxRepeatedNumber<countNumbers){
                maxRepeatedNumber=countNumbers;
                cell=array[i-1];
                countNumbers=1;
            }
            for(int j=i+1; j<array.length; j++){
                if(array[i]==array[j]){
                    countNumbers++;
                }
            }
        }
        if(maxRepeatedNumber==1){
            System.out.println("Nessun numero nell'array viene ripetuto");
        }else{
            System.out.println("il numero con maggiori ripetizioni nell'array è: "+cell+" che si ripete: "+maxRepeatedNumber+" volte");
        }
        
        //output dei valori
        average = sum/array.length;
        System.out.println("somma valori: "+sum);
        System.out.println("media: "+average);
        System.out.println("valore minimo: "+ min);
        System.out.println("multipli di 2 presenti nell'array: "+multiple2);
        System.out.println("il valore x è presente "+countx+" volte");
        System.out.println("due numeri consecutivi che danno come somma "+z+": "+ countSumZ);









    }
}