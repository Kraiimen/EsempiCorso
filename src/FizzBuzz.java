// stampa i primi numeri da 1 a 100
// se il numero è multiplo di 3 anzi che quello stampa fizz
// se è un multiplo di 5 stampa buzz
// se è multiplo sia di 3 sia di 5 stampa fizzbuzz
// altrimenti stampa il numero normale

public class CountTheNumber {
    public static void main(String[] args) {
        int n = 0;
        int cont = 100;
        int i = 0;
        for( i = 0 ; i < cont ; i++ ) { 
            //System.out.println(i);
            if(i %  3 == 0 && i % 5 == 0 ) {
            System.out.println("FizzBuzz");
            }
            else if(i %  3 == 0 ) {
            System.out.println("Fizz");
            }
            else if(i %  5 == 0 ) {
            System.out.println("Buzz");
            }

            else System.out.println(i);
        }
        System.out.println();


    }

}
