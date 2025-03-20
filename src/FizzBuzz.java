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


// stampa i primi numeri da 1 a 100
// se il numero è multiplo di 3 stampa Fizz 
// se il numero è multiplo di 5 stampa Buzz 
// se è multiplo di entrambi stampa FizzBuzz
// altrimenti stampa numero normale

public class FizzBuzz{
    public static void main(String [] args){
        
        int i; 
        for(i = 1; i <= 100; i++){ 
            
            if (i % 5 == 0 && i % 3 ==0){
                System.out.println("FizzBuzz");
            }
            else if(i % 5==0){
                System.out.println("Buzz");
            }
            else if(i % 3 ==0){
                System.out.println("Fizz");
            }
            else{
                System.out.println(i);
            }
          
      
        }



    }
}  
       

  
    
    


    
