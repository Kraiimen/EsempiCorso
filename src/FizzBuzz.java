public class FizzBuzz {
    public static void main(String[] args) {


//   voglio un programma che stampa i primi 100 numero, però
// -se il numero è un multiplo di 3, deve stampare fizz
// -se il numero è un multiplo di 5, deve stampare buzz
// -se il numero è un multiplo sia di 3 che di 5, deve stampare fizzbuzz
// -se no, stampa il numero

        for( int i = 0 ; i < 100 ; i++ ) {
            if (( i % 3 == 0) && (i % 5 == 0)){
                System.out.println("FIZZBUZZ");
            } else if (i % 3 == 0){
                System.out.println("FIZZ");
            }else if (i % 5 == 0){
                System.out.println("BUZZ");
            } else System.out.println(i);
        }
    }
}