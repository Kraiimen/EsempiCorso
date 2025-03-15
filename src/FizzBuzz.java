// stampa i primi 100 numeri
public class FizzBuzz{
    public static void main(String[] args) {
        for(int i=0; i<101; i++){
            if(i%3 == 0 && i%5 == 0){                       // se il numero è un multiplo sia di 3 che di 5 stampa fizzbuzz
                System.out.println("fizzbuzz");
            }
            else if(i%3 == 0){                              // se il numero è un multiplo di 3 stampa fizz
                System.out.println("fizz");
            }
            else if(i%5 == 0){                              // se il numero è un multiplo di 5 stampa buzz
                System.out.println("buzz");
            }
            if(i%3 !=0 && i%5 != 0){                        // se il numero non è un multiplo di 3 e 5, allora stampa il numero
                System.out.println(i);
            }
        }
    }

}
    

