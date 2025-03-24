public class BidimensionalArrays {
    public static void main(String[] args){
        int[][] matrix = new int[4][6];
        int[][] matrix2 = {
            {3, 4, 1, 24, 56, 36},
            {24, 7, 11, 36, 35, 78},
            {11, 3, 35, 77, 86, 99},
            {3, 43, 21, 20, 10, 11}
        };
        System.out.println(matrix2[2][3]); // stampa 77

        for(int i = 0; i < matrix2.length; i++){ // sta prendendo la lunghezza delle colonne
            System.out.print("["); // metto una quadra prima delle colonne
            for(int z = 0; z < matrix2[i].length; z++){ // cicla la lunghezza delle righe
                System.out.printf("%5d", matrix2[i][z]); //facciamo print f con un formato, d sta per digit
            }
            System.out.println("  ]"); // metto la quadra che chiude le colonne
        }
        int[][] jagged = new int[10][];
        for(int i = 0; i < jagged.length; i++){
            jagged[i] = new int[i+1]; // crea un jagged tutti 0, ogni riga è un intero di dimensione i
        }
        for(int i = 0; i < jagged.length; i++){
            System.out.print("[");
            for(int z = 0; z < jagged[i].length; z++){
                System.out.printf("%5d", jagged[i][z]);
            }
            System.out.println("  ]");
        }
    }
    public static int findMax(int[][] matrix){
        int max = matrix[0][0];
        for(int i = 0; i < matrix.length; i++){
            for(int f = 0; f < matrix[i].length; f++){
                if(matrix[i][f] > max){
                    max = matrix[i][f];
                }
            }
        }
        return max;
    }
}
    