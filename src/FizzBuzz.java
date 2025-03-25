public class FizzBuzz {
    public static void main(String[] args){
        
        //da 0 a 100
        //se il numero è un multiplo di 3, deve stampare fizz
        //se multiplo di 5, buzz
        //se multiplo di 3 e di 5, fizzBuzz
        //se nessuna di queste cose, il numero

        String str = null;

        // for(int i=0; i<=100; i++){
        //     if(i % 5 == 0){
        //         if(i % 3 == 0){
        //             str = "FizzBuzz";
        //         } else {
        //             str = "Buzz";
        //         }
        //     }
        //     else if(i % 3 == 0){
        //         if(i % 5 == 0){
        //             str = "FizzBuzz";
        //         } else {
        //             str = "Fizz";
        //         }           
        //     }
        //     else{
        //         str = String.valueOf(i);
        //     }

        //     System.out.println(str);
        // }

        // for(int i=0; i<=100; i++){
        //     if(i % 5 == 0 && i % 3 == 0){
        //         str = "FizzBuzz";
        //     }
        //     else if(i % 5 == 0){
        //         str = "Buzz";
        //     }
        //     else if(i % 3 == 0){
        //         str = "Fizz";         
        //     }
        //     else{
        //         str = String.valueOf(i);
        //     }

        //     System.out.println(str);
        // }

        for(int i=0; i<=100; i++){
            
            if(i % 15 == 0){
                str = "FizzBuzz";
            }
            else if(i % 5 == 0){
                str = "Buzz";
            }
            else if(i % 3 == 0){
                str = "Fizz";         
            }
            else{
                str = String.valueOf(i);
            }

            System.out.println(str);
        }
    }
}
