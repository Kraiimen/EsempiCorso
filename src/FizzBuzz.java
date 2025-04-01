// stampa i primi numeri da 1 a 100
// se il numero è multiplo di 3 stampa Fizz 
// se il numero è multiplo di 5 stampa Buzz 
// se è multiplo di entrambi stampa FizzBuzz
// altrimenti stampa numero normale
public class FizzBuzz {
    public static void main(String[] args){
        for(int i = 1; i < 101; i++){
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
             } else if (i % 3 == 0) {
                    System.out.println("Fizz");
             } else if (i % 5 == 0) {
                    System.out.println("Buzz");
             } else {
                    System.out.println(i);
             }
             
            
    
        }


    }

}
