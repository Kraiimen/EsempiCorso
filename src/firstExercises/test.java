package firstExercises;

public class test{
    public static void main(String[] args){
        int n1 = 18;
        int n2 = 4;

        int division = n1/n2 * 4;
        System.out.println(division);

        int[] numbers = {1, 2, 3};
        f1(numbers);
        System.out.println(numbers[0]);
        System.out.println();

        Integer i1 = 10; // gli oggetti di classe integer una volta creati sono immutabili come le stringhe
        Integer i2 = 20;
        swap(i1, i2);
        System.out.println(i1);

        String s1 = "pippo";
        String s2 = "pluto";
        swapString(s1, s2);
        System.out.println(s1);

        int[][] matrix = {
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18},
            {19, 20, 21, 22, 23, 24}
        };
        
        for(int i = 0; i < matrix.length; i++){
            System.out.print("[");
            for(int j = 0; j < matrix[i].length; j++){
                System.out.printf("%5d", matrix[i][j]);
            }
            System.out.println("    ]");
        }
    }

    public static void f1(int[] ns){
        ns[0] = 100;
        ns = new int[]{1000, 2000, 3000};
        System.out.println(ns[0]);
    }

    public static void swap (Integer z1, Integer z2){
        Integer temp = z1;
        z1 = z2;
        z2 = temp;
    }

    public static void swapString(String s1, String s2){
        String temp = s1;
        s1 = s2;
        s2 = temp;
    }


}