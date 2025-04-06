package eserciziIniziali.conditionals;

//primi 100 numeri
//stampare Fizz se multiplo di 3, Buzz se multiplo di 5,
//fizzbuzz se multiplo di entrambi, altrimenti il numero
//*
public class FizzBuzz{
    public static void main(String[] args){
        for(int i = 1; i <= 100; ++i){
            boolean isNotDivisible = true;
            if(i % 3 == 0){
                System.out.print("Fizz");
                isNotDivisible = false;
            }
            if(i % 5 == 0){
                System.out.print("Buzz");
                isNotDivisible = false;
            }
            if(isNotDivisible){
                System.out.print(i);
            }
            System.out.println();
        }
        //*/
    }
}