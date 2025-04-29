import java.io.Console;
public class MetodiEsercizi {
    public static void main(String[] args) {
    
        verificaNumero(3);
        verificaPari(3);
        verificaIngresso(17);


        int[] somma =  {1, 2, 3, 4, 5};
        System.out.println("La somma è " + arraySum(somma));

        int[] max = {6,4,3,2,8};
        System.out.println("il massimo " + finMax(max));

        int [] most = {6,5,4,6,6,7};
        System.out.println("il numero" + counterTime(most));

        int [] palin = {1, 2, 3, 2, 1};
        System.out.println("il numero è palindrome?" + isPali(palin));

        int [] most1 = {1, 2, 3, 2, 1, 1, 1};
        System.out.println("il numero con piu frequenza è  " + isMost(most1));

        
    }


    public static void verificaNumero(int numero){
        if(numero > 0){
            System.out.println("il numero"+ numero + " è positivo");
        }    
        else if(numero < 0){
                System.out.println("il numero" + numero + "è negativo");
        } else {
            System.out.print("il numero" + numero + "è uguale");
        }
    }

    public static void verificaPari(int numero1){
        if(numero1 % 2 == 0){
            System.out.println("Il numero è pari");
        } else {
            System.out.println("Il numero è dispari");
        }
    }
 
    public static void verificaIngresso(int numero2){
        if(numero2 > 80){
            System.out.println("Sei vecchio");
        } else if(numero2 > 18){
            System.out.println(" puoi entrare");
        } else {
            System.out.println("non puoi entrare ");
        }
    }

    public static int arraySum(int[]array){
        int somma = 0;
        for(int i = 0; i < array.length;i++){
        somma += array[i];
        }
        return somma;
    }  

    public static int finMax(int[] array1){
        int max = array1[0];
        for(int i = 0; i < array1.length;i++){
            if(array1[i] > max){
                max = array1[i];
            }
       } return max;
   }

    public static int counterTime(int[] array3){
        int counter= 0;
        int x = 6;
        for(int z = 0 ; z < array3.length; z++){
            if(array3[z] == x){
            counter++;
            }
        } return counter;
    }


    public static boolean isPali(int[] array4){
        boolean èPali = true;
        for(int i = 0, f = array4.length-1; i < f ; i++, f--){
            if(array4[i] != array4[f]){
                return false;
            } 
        } return true;

    }

    public static int isMost(int[] array5){
        int counter1= 0;
        int mostrip = 0;
        int masRip = 0;

        for(int z = 0 ; z < array5.length; z++){
            for(int j = 0 ; j < array5.length; j++){
                if(array5[z] == array5[j]){
                    counter1++;
                } 
                if(counter1 > masRip){
                    masRip = mostrip;
                    mostrip = array5[z];
                }
            } 
        } return mostrip;

    }




}


