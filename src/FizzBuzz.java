public class FizzBuzz {
    public static void main(String[] args) {

    // stampa i primi numeri da 1 a 100
    //se il numero è multiplo di 3 anzi che quello stampa fizz
    // se è un multiplo di 5 stampa buzz
    // se è multiplo sia di 3 sia di 5 stampa fizzbuzz
    // altrimenti stampa il numero normale
    
        for(int i =1 ; i < 100 ; i++){    // Ci stampa tutti i numeri fino a 100
            if(i % 3 == 0 && i % 5 == 0){    
                System.out.println("fizzbuzz");
            } else if (i % 5 == 0){
                System.out.println("buzz");
            } else if (i % 3 == 0 ){
                System.out.println("fizz");
            } else {
                System.out.println(i);
            }
        
        }

    }


}