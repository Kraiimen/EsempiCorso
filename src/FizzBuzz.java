public class FizzBuzz {
    // stampa i primi numeri da 1 a 100, se il numero è multiplo di 3 anzi che quellos tampa fizz, se è un multiplodi 5 spama buzz, se è sia di 3 sia di 5 stampa fizzbuzz
    public static void main (String[] args){
        
        for (int i =0; i<=100; i++){
            if(i%3 ==0){
                if(i%5 ==0){
                    System.out.println("fizzBuzz");
                }else{
                System.out.println("fizz");
                }
            }else if(i%5 ==0){
                System.out.println("Buzz");
            }else{
                System.out.println(i);
            }
        }
    }
}
