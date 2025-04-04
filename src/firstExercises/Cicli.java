package firstExercises;

public class Cicli {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int max = 1;
        int somma = 0;
        for (int numero : array)
            System.out.println(numero);


        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            somma += array[i];
        }
        System.out.println(max);
        System.out.println(somma);

        int[][] array1 = {
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6},
                {6, 5, 4, 3, 2, 1},
        };
        int sum = 0;
        for (int i = 0; i < array1.length; i++) {
            System.out.println("( ");
            for (int z = 0; z < array1[i].length; z++) {
                sum += array1[i][z];
                System.out.printf("%7d", array1[i][z]);
            }
        }   System.out.println(" )");
         System.out.println("La somma dell'array bidimensionale è " + sum) ;



    }
}

