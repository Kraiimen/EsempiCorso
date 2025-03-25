public class BidimensionalArray {
    public static void main(String[] args) {

        int[][] matrix = new int[4][6]; 
        int[][] matrix2 = {
            {3, 4, 5, 6, 7, 8},
            {12, 23, 34, 45, 56},
            {234, 345, 456, 567, 678, 789},
            {1, 23, 3, 56, 73, 90}
        };

        System.out.println(matrix2[2][3]);
        for(int i = 0; i < matrix2.length; i++) {
            for(int z = 0; z < matrix2[i].length; z++) {
                System.out.printf("%5d", matrix2[i][z]); 
            }
            System.out.println("  ]"); 
        }
        int[][] jagged = new int[10][];
        for(int i = 0; i < jagged.length; i++) {
            jagged[i] = new int[i + 1]; 
        }
        for(int i = 0; i < jagged.length; i++) {
            for(int z = 0; z < jagged[i].length; z++) {
                System.out.printf("%5d", jagged[i][z]); 
            }
            System.out.println("  ]"); 
        }
    }

    public static int findMax(int[][] matrix) {
        int max = matrix[0][0]; 
        for(int i = 0; i < matrix.length; i++) {
            for(int f = 0; f < matrix[i].length; f++) {
                if(matrix[0][f] > max); 
                max = matrix[i][f]; 
            }
        }
        return max; 
    }
}
