public class FizzBuzz {
    public static void main (String[] args) {
        //stampa i primi numeri da 1 a 100, se il numero è 
        //multiplo di 3 stampa fizz, se è un multiplo di 5 stampa buzz, 
        //se è sia di 3 sia di 5 stampa fizzbuzz
        
        int y;
        for(y = 1; y < 101; y++) {
            if(y % 3 == 0) {
                System.out.println( y + "  fizz");
            } else if(y % 5 == 0) {
                System.out.println(y + "  buzz");
            }
            if (y % 3 == 0 && y % 5 == 0) {
                System.out.println(y + "  fizzbuzz");
            }
            
        }

    }
    
}
