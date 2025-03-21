public class FizzBuzz {
    public static void main (String[] args){
        for (int i=1; i < 100; i++){ // ci stampa tutti i numeri fino a 100
            if(i % 3 == 0 && i % 5 == 0 ){ //se multiplo di 3 e 5 dice fizzbuzz
                System.out.println("FizzBuzz!"); 
            } else if ( i % 5 == 0) { //se multiplo di 5 dice buzz
                System.out.println("Buzz!"); 
            } else if ( i % 3 == 0) { //se multiplo di 3 dice fizz
                System.out.println ("Fizzz");
            } else { // il resto è normale
                System.out.println(i);
            }
        }
    }
}
