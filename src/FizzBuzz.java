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
            }else{
                System.out.println(i);                      //altrimenti, se non è un multiplo di 5 e 3, stampa il numero
            }
        }
    }
}


    

