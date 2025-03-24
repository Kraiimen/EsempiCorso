public class BidimensionalArray {
    public static void main(String[] args) {
        int[][] matrix = new int[4][6];
        int[][] matrix2 = {
                { 2, 11, 28, 5, 3, 9 },
                { 4, 8, 12, 4, 7, 3 },
                { 6, 2, 9, 0, 25, 38 },
                { 3, 43, 21, 20, 10, 11 }

        };
        System.out.println(matrix2[2][4]);
        for (int i = 0; i < matrix2.length; i++) {
            System.out.print("[");
            for (int z = 0; z < matrix2[i].length; z++) {
                System.out.printf("%10d", matrix2[i][z]); // 5 slots, digits=interi
            }
            System.out.print("  ]");
            System.out.println();
        }

        System.err.println(findMaxValue(matrix2));

        int[][] jaggedArray = new int[10][];  //jagged array diagonale
        for (int i = 0; i < jaggedArray.length; i++) {
            jaggedArray[i] = new int[i+1];
        }
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.print("[");
            for (int z = 0; z < jaggedArray[i].length; z++) {
                System.out.printf("%5d", jaggedArray[i][z]); 
            }
            System.out.print("  ]");
            System.out.println();
        }

    }

    public static int findMaxValue(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int z = 0; z < array[i].length; z++) {
                if (array[i][z] > max) {
                    max = array[i][z];
                }
            }
        }
        return max;
    }
}
