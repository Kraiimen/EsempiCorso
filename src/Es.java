    //Creare una funzione che crea un array di 10 interi e si assicura che i suoi elementi siano 0101010101 e lo ritorni al chiamante. Fatto
public class Es {
    public static void main(String[] args) {

        int[] result = returnArray(10);
        
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }   
    }

    public static int[] returnArray(int n) {
        int[] array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = i % 2;
        }

        return array;   
    }
} 

    //Dato un array di stringhe con 22 righe, dividerlo il più equamente possibile in 4 array. 