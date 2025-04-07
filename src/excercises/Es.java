package excercises;

public class Es {
    public static void main(String[] args) {
        // Dato un array di stringhe con 22 stringhe, dividerlo il più equamente possibile in 4 array

        int[] pippo = returnArray(10);
        
        for(int i = 0; i < pippo.length; i++){
            System.out.print(pippo[i]);
        }

        int n = 6000000;
        // 0110
        // 0001
        if((n & 1) == 0){
            System.out.println("è pari");
        }
    }

    // Creare una funzione che crea un array di n interi e si assicura che i suoi elementi siano 0101010101 e lo ritorni al chiamante

    // n = 10
    // array --> 000000000
    // risultato --> 0101010101

    public static int[] returnArray(int n) {
        int[] array = new int[n];

        for(int i = 1; i < array.length; i+=2){
            array[i] = 1;
        }

        return array;
    }
}
