import java.io.Console;

public class QStop {
    public static void main(String[] args) {

        Console console = System.console();

        String ns = null; 
        // String stop = "Q"; 
        int number = 0; 
        int max = 0, i = 0; 
 
        do { 
            
            if(i == 0) {
                
                System.out.println("Dammi un numero: "); 
                ns = console.readLine();
            } else { 
                
                System.out.println("Dammi un numero e premi Q per terminare");   
                ns = console.readLine();

                if (ns.equals("Q")) { 
                    System.out.println("Hai terminato");  
                    System.out.println("Il numero più grande è " + max); 
                }                 
            }

            number = Integer.parseInt(ns);

            if(number > max){
                max = number;
            }

            i++;                       
        } while (!ns.equals("Q")); 
                              
    }
    
// // Esercizio 3
// // Dammi un numero
// // Dammi un numero e scrivi q per smettere
// // Va avanti finché non gli dai q
// // Alla fine ti da il numero più grande che gli hai dato 

}
    

