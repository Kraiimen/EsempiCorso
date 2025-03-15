public class FizzBuzz{
    public static void main(String[] args){
        //primi 100 numeri
        //stampare Fizz se multiplo di 3, Buzz se multiplo di 5,
        //fizzbuzz se multiplo di entrambi, altrimenti il numero
        //*
        for(int i = 1; i <= 100; ++i){
            boolean isNotDivisible = true;
            if(i%3 == 0){
                System.out.print("fizz");
                isNotDivisible = false;
            }
            if(i%5 == 0){
                System.out.print("buzz");
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