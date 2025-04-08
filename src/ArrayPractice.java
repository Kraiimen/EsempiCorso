import java.util.Random;
public class ArrayPractice{
    
    public static int maxxFrequency = 0;
    
    public static void main (String[] args){
        Random DICE = new Random();

        int[] ogArray = new int [10];
        for ( int i = 0; i < ogArray.length; i++){
            ogArray[i] = DICE.nextInt(100);
            System.out.print(ogArray[i] + " ");
        }

        int TripleArray [][] = {
                                {1,2,3},
                                {4,5,6},
                                {7,8,9}};
        
        
        int goodSum = sumArray(ogArray);
        System.out.println ("\n" + goodSum);
        
        int minMaxValue = minMax(ogArray);
        System.out.println(minMaxValue);
        
        int x1 = frequency(1 , ogArray);
        System.out.println(x1);

        int sumDouble = sumArrayDouble (TripleArray);
        System.out.println(sumDouble);

        int maxValue = findMax(TripleArray);
        System.out.println(maxValue);

        // int maxFrequency = findMaxFrequency(ogArray);
        // System.out.println(maxFrequency);
        findMaxFrequency(ogArray);
        System.out.println(maxxFrequency);
    }
    //crea una funzione che somma tutti gli elementi di un array, la ritorna e la stampa
    public static int sumArray (int[] array){
        int finalSum = 0;
        for (int i = 0; i < array.length; i++){
            finalSum +=  array[i];
        }
        return finalSum;
    }
    

    //crea una funzione che trovi il valore massimo o minimo di un array

    public static int minMax (int[] array){
        int minValue = array[0];
        int maxValue = array[0];
            
        for (int i = 0; i < array.length; i++){
            if (array[i] > maxValue){
                    maxValue = array[i];
            }
            if (array[i] < minValue){
                minValue = array[i];
            }
        }
        // return maxValue;
        return minValue;
    }

    //crea una funzione che calcoli la frequenza un determinato numero appare in un array e la ritorni

    public static int frequency (int x, int[] array){
        int counter = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] == x){
                counter ++;
            }
        }
        return counter;
    }

    //Scrivi una funzione che prenda in input una matrice (array bidimensionale) di numeri interi e restituisca la somma di tutti i suoi elementi.

    public static int sumArrayDouble (int [][] array){
        int sumTotal = 0;
            
        for(int i = 0; i < array.length ; i++){
            for (int z = 0; z < array[i].length; z++){
                sumTotal += array[i][z];
            }
        }
        return sumTotal;
    }
    
    //Scrivi una funzione che trovi il valore massimo presente in una matrice di numeri interi.

    public static int findMax (int [][] array){
        int maxValue = array[0][0]; //in caso ci siano dei negativi

        for (int i = 0; i < array.length; i++){
            for (int z = 0; z < array[i].length; z++){
                if (array[i][z] > maxValue){
                    maxValue = array [i][z];
                }
            }
        }
        return maxValue;
    }

    //crea una funzione che trovi il numero che appare più volte in un array e quante volte appare
    public static void findMaxFrequency (int [] array){
        int maxFrequencyTot = 0;
        int maxFrequencyTemp = 0;
        
        for (int i = 0; i < array.length; i++){
            maxFrequencyTemp = 0;
            for (int z = 0; z < array.length; z++){
                if(array[i] == array[z]){
                    maxFrequencyTemp++;
                    if(maxFrequencyTemp > maxFrequencyTot){
                        maxFrequencyTot = maxFrequencyTemp;
                    }                   
                }
            }
        }
        maxxFrequency = maxFrequencyTot;
    }

}