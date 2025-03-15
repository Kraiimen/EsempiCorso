import java.util.Random;
import java.io.Console;


public class GuessTheNumber {
    public static void main(String[] args) {
        Console console = System.console();
        Random dice = new Random();
        int n = dice.nextInt(100_001);
        int ourChoice;
        int tentativo = 0;
        //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta e: se azzecca stampa "bravo sei un genio"
        // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
        // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
        // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi
        do{
            System.out.println("Vediamo se riesci a indovinare il mio stupido numero");
            String ns = console.readLine();
            tentativo++;
            //System.out.println("Il mio numero segreto è " + n);
            ourChoice = Integer.parseInt(ns);
            if (n > ourChoice){
                System.out.println("Il numero che mi hai dato è troppo piccolo");
            }else if (n < ourChoice){
                System.out.println("Il numero che mi hai dato è troppo grande");
            }
        } while(ourChoice != n);
        System.out.println("Era ora umano, hai fatto "+ tentativo + " tentativi");
        
        for(int i = 1; i < 100; i++){
            //metodo esotico
                // if (i % 3 == 0){
                //     System.out.print("fizz");
                // }
                // if (i%5 == 0){
                //     System.out.print("buzz");
                // }
                // if (!(i%5 == 0) && !(i%3 == 0)){
                //     System.out.print(i);
                    
                // }
                // System.out.println("");
                //Metodo giusto
                if ((i%5 == 0) && (i%3 == 0)){
                    System.out.println("fizzbuzz");
                    
                }else if(i%3 == 0){
                    System.out.println("fizz");
                }else if (i%5 == 0){
                    System.out.println("buzz");
                }else {
                    System.out.println(i);
                }
            }
        }


    }
    //programma che stampa i primi 100 numeri se è un multiplo di 3 stampa fix se è un multiplo di 5 buzz se è un multiplo sia di 3 che di 5 fix buzz

