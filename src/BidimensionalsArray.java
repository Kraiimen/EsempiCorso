public class BidimensionalsArray {
    public static void main(String[] args) {

        int[][] matrix = new int [4][6];
        int[][] matrix2 = {
            {3, 4, 67, 45, 7, 2},
            {12, 3, 45, 5, 7, 8},
            {1, 23, 47, 1, 9, 9},
            {34, 57, 6, 8, 9, 1}
        };

        System.out.println(matrix2 [2][3]);

        for(int i = 0; i < matrix2.length; i++) {  //lunghezza di matrix2 è 4, perchè contiene 4 array.
           System.out.print("[");
           for(int z = 0; z < matrix2[i].length; z++) { //dato che le righe sono tutte uniforme mettere i, 1 ,2 non cambiava nulla.
                System.out.printf("%5d", matrix2[i][z]);
            }    
            System.out.println("]");
        }
        int[][] jagged = new int[10][];
        for(int i = 0; i < jagged.length; i++) {
            jagged[i] = new int[i+1];

        }
        for(int i = 0; i < jagged.length; i++) {  
           System.out.print("[");
           for(int z = 0; z < jagged[i].length; z++) { 
                System.out.printf("%5d", jagged[i][z]);
            }    
            System.out.println("]");
        }

    }
    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for(int i = 0; i < matrix.length; i++) {
            for(int f = 0; f < matrix[i].length; f++) {
                if(matrix[i][f] > max) {
                    max = matrix[i][f];
                }
            }
        }
        return max;
    }
}