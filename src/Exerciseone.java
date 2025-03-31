public class Exerciseone {
    public static void main(String[] args) {
//        esercizio 1
//        int[] interi = {1, 2, 3, 4, 5};
//        int somma = 0;
//        for (int pippo : interi) {
//            somma += pippo;
//        }
//        System.out.println("la somma è " + somma);
//
//        esercizio 2
//        String[] vocali = {"a", "e", "i", "o", "u"};
//        int counter = 0;
//
//        for (String i : vocali) {
//            char[] converto = i.toCharArray();
//            counter++;
//        }
//        System.out.println(counter);

//         esercizio 3
//        int[] interi = {1, 2, 3, 5, 4};
//        int max = 0;
//
//        for (int i : interi) {
//            if (max < i) {
//                max = i;
//            }
//        }
//        System.out.println(max);

//          esercizio 4
//        int x = 1000;
//        if(x > 0){
//            System.out.println("positivo");
//        } else if (x < 0){
//            System.out.println("negativo");
//        } else {
//            System.out.println("è zero");
//      }
        // esercizio 5
//        for(int i = 1; i <= 5; i++){
//            System.out.println(i);
//        }
        //esercizio 6
//        int[] array = {1, 2, 3, 4, 5};
//        for(int i = 0; i < array.length; i++){
//            System.out.println(array[i]);
//        }
        //esercizio 7
//        int[] numbers = new int[5];
//        for(int i = 0; i < numbers.length; i++){
//            numbers[i] = 1 + i;
//            System.out.println(numbers[i]);
//        }
        //esercizio 8
        int[] numbers = new int [10];
        for(int i = 0; i < numbers.length; i++){
            if(i % 2 == 0){
                numbers[i] = (int)Math.sqrt(i);
            } else{
                numbers[i] = i*i;
            }
            System.out.printf("%d ", numbers[i]);
        }
        //esercizio 9


//        int z = 11;
//        if(isEven(z)){
//            System.out.println(z);
//        }
    }
//    public static boolean isEven(int i){
//        if(i % 2 == 0){
//            return true;
//        } else{
//            return false;
//        }
//    }

}

