import java.util.Random;
public class ArrayExercises{
    public static void main(String[] args){
        //riverso un array con il metodo dei 2 indici
        //quando s>i fermi il ciclo
        //
        int []num = {0,1,2,3,4};
        for (int i = 0, s = num.length-1; i < s; i++, s--){
            int temp = num[i];
            num[i] = num[s];
            num[s] = temp;
        }
        for(int n : num){
            System.out.print(n + " ");
        }
        System.out.println("");
        //creo un array rovesciato del precedente array 
        int[] reverseNum = new int [num.length];
        for(int i = 0; i < num.length; i++){
            reverseNum[i] = num[num.length-1-i];
        }
        for(int n : reverseNum){
            System.out.print(n + " ");
        }


        // dato un numero arbitrario int z = 8, verificare quante volte succede nell rray che ci sono 2 numeri consecutivi nell array in cui la somma è uguale a z
        // verificare che nell'array non esistano 3 numeri consecuitivi la cui somma è maggiore di 12
        // Esercizio 10: Trovare il numero che appare più volte nell'array -es [2, 7, 12, 7, 2] - se ci sono più valori che appaiono lo stesso numero di volte basta che il programma stampi uno di questi numeri

        int z = 4;
        int counterZ = 0;
        int [] numbers = {1, 7, 4, 7, 1, 3, 2, 3, 5, 6};

        for(int i = 1; i< numbers.length ; i++){
            if((numbers[i] + numbers[i-1]) == z){
                counterZ++;
            }

        }
        System.out.println("\nNell'array abbiamo in " + counterZ + " casi la situazione in cui la somma dei 2 numeri consecutivi n è uguale a z");
        // -----
        int checkValue = 12;
        boolean isLargerValue = false;
        int [] numbers2 = {1, 1, 4, 4, 6, 7, 2, 2, 7, 6, 0, 7, 0, 6, 7, 2, 0, 6, 0, 7};
        for(int i = 2; i< numbers.length ; i++){
            if((numbers2[i] + numbers2[i-1]+ numbers2[i-2])  > checkValue ){
                isLargerValue = true;
                break;
            }
        }
        if(isLargerValue){
            System.out.println("c'è almeno un gruppo di 3 numeri consecutivi la cui somma è maggiore di 12");
        }else{
            System.out.println("Non c'è almeno un gruppo di 3 numeri consecutivi la cui somma è maggiore di 12");
        }
        // Esercizio 10: Trovare il numero che appare più volte nell'array -es [2, 7, 12, 7, 2] - se ci sono più valori che appaiono lo stesso numero di volte basta che il programma stampi uno di questi numeri
        //Creo array di interi e lo inizializzo con numeri casuali 
        //creo una variabile che conterra il valore del numero che appare piu spesso
        //creo un counter che conterà il numero di volte che appare il numero modale (ossia il numero che appare piu spesso)
        //creo un ciclo che parte da 0 e si ferma raggiunto length
        //al suo interno mi salvo il valore il valore alla posizione iesima
        //creo un altro ciclo inner che itera gli elementi partendo da i+1 a fino a length escluso
        //e controllo quante volte il valore alla posizione iesima è presente nell'array per farlo usero un altro counter all interno del ciclo inner
        //se il counter interno è maggiore del counter esterno, aggiornare il counter esterno

        int[] numbers3 = new int [10];
        Random dice = new Random();
        for(int i = 0; i < numbers3.length; i++){
            numbers3[i]= dice.nextInt(10); //numeri casuali da 0 a 9
        }
        int counterOutside = 0;//counter esterno che sara aggiornato se un numero è presente piu volte del precedente
        int modalValue = numbers3[0]; //conterra il valore modale
        for(int i = 0; i < numbers3.length; i++ ){
            int counterInner = 0;
            //int valueI = numbers3[i];
            for(int y = i; y < numbers3.length; y++){
                if(numbers3[i] == numbers3[y]){
                    counterInner ++;
                }
            }
            if(counterOutside < counterInner){
                modalValue = numbers3[i];
                counterOutside = counterInner;
            }
        }
        System.out.println("Numeri array casuale:");
        for(int i = 0; i < numbers3.length; i++){
            System.out.print(numbers3[i] + " "); //numeri casuali da 0 a 9
        }
        System.out.println("\nIl numero più presente dell'array compare "+ counterOutside + " volte ed è "+ modalValue);
    }
}