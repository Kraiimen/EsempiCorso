public class ArrayBidimensionalProve {
    public static void main(String[] args) {
        int[][] matrix2 = {

            {3, 4, 1, 24, 56, 36},
            {24, 7, 11, 36, 35, 78},
            {11, 3, 35, 77, 86, 99},
            {3, 43, 21, 20, 10, 11}
        };

        for(int z = 0 ; z < matrix2.length; z++){
            System.out.println("[ ");
                for(int e = 0; e < matrix2[z].length; e++){
                    System.out.printf("%5d", matrix2[z][e]);
                
                }   
                System.out.println(" ]");
        }
    }
}