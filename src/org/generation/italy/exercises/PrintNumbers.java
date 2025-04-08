package org.generation.italy.exercises;

public class PrintNumbers {
    public static void main (String[] args){

        // for( int i = 1 ; i < 100 ; i++ ) { 
        //     if (i % 3 == 0 && i % 5 == 0){
        //         System.out.println("fizzbuzz");
        //     } else if (i % 3 == 0){
        //         System.out.println("fizz");
        //     } else if (i % 5 == 0){
        //         System.out.println("buzz");
        //     } else {
        //         System.out.println(i);
        //     }
        // }

        int i = 1;
        String kw;
        do {
            if (i % 15 == 0){
                kw = "fizzbuzz";    
            } else if (i % 3 == 0){
                kw = "fizz";    
            } else if (i % 5 == 0){
                kw = "buzz";     
            } else {
                kw = String.valueOf(i);
            } 
            System.out.println(kw);
            i ++;
        } while (i < 100);
    }
}
