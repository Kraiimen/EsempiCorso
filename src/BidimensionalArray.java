



public class BidimensionalArray {
    public static void main(String[] args) {
        int[][] matrix = new int[4][6];
        int[][] matrix2 = {
            {3,4,1,24,56,36},
            {24,7,11,36,35,78},
            {11,3,35,77,124,99},
            {3,43,21,20,10,11}
        };
        int maxNumb = findMax(matrix2);
        System.out.println(maxNumb);
        printArray(matrix2);
        
    }
    public static int findMax(int[][] numbers) {
        int maxNumb = numbers[0][0];
        for(int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length ; j++) {
                if(numbers[i][j] > maxNumb) {
                    maxNumb = numbers[i][j];
                }

            }
        }
        return maxNumb;
    }

    public static void printArray(int[][] jagged) {
        for(int i = 0; i < jagged.length; i++) {
            System.out.println();
            System.out.print("[");
            for(int z = 0; z < jagged[i].length; z++) {
                System.out.printf("%5d", jagged[i][z]);
            }
            
            System.out.print("    ]");
        }
    }
    






}


