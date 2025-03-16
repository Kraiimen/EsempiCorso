


public class GuessTheNumber {
    public static void main(String[] args) {
                                        //PROGRAMMA 1//
        // Random dice = new Random();
        // int n = dice.nextInt(100_001);
        // //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta e: se azzecca stampa "bravo sei un genio"
        // // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
        // // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
        // // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi
        // int numero = 0;
        // while(numero != n) {
            
        // Console console = System.console();
        // String input = console.readLine("Inserisci un numero \n");
        // numero = Integer.parseInt(input);
        // if(numero == n) {
        //     System.out.println("Bravo, sei un genio!");
        // }
        //    else if(numero < n) {
        //     System.out.println("Il numero che hai digitato è più piccolo del numero magico!");
        //    }
        //    else {
        //     System.out.println("il numero che hai digitato è maggiore del numero magico!");
        //    }

        // }
        //
      // stampa i primi numeri da 1 a 100, se il numero è multiplo di 3 anzi che quellos tampa fizz, 
      //se è un multiplo di 5 spama buzz, se è sia di 3 sia di 5 stampa fizzbuzz
                                    // PROGRAMMA 2 //

        for(int i = 1; i <= 100; i++) {
           

            if(i % 3 == 0 && i % 5 == 0 ){
                 System.out.println("fizzbuzz");
            }
            else if(i % 5 == 0) {
                 System.out.println("buzz");
            }
            else if(i % 3 == 0) {
                 System.out.println("fizz");    
            }
            else{
                 System.out.println(i);
            }
           
 

        }












        // for(int i = 1; i < 100; i++) {
        //     System.out.println(i);
            
        //     if(i % 3 == 0 && i % 5 == 0) {
        //         System.out.println("fizzbuzz");
        //     }
            
            
        //     if(i % 5 == 0) {
        //         System.out.println("buzz");
        //     }
        //     if(i % 3 == 0) {
        //         System.out.println("fizz");
        //     }
            
            
            // }
                                        //ESERCIZIO 3//
        //Dai un numero al programma finchè l'utente non specifica uno stop con Q 
        //Quando
            
        }
     
            
        }
    
    

