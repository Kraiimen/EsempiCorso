import java.io.Console;
import java.util.Queue;

public class Methods {
    public static void main(String[] args) {

        //Tipo   //Variabile     =  Assegnazione varaibile console()
        // Console console = System.console(); 

        // System.out.print("Dammi un numero >  ");
        // String input1 =console.readLine();
        // int x1 = Integer.parseInt(input1);
        // System.out.print("Dammi un numero >  ");
        // String input2 =console.readLine();
        // int x2 = Integer.parseInt(input2);


        int x1 = readInteger();  // Stiamo richiamando la funzione ReadInteger
        int x2 = readInteger();



        System.out.println("La somma dei due numeri  " + (x1 + x2));

        int result = sum(x1 , x2);
        System.out.println("La somma dei due numeri  " + result);

        printSum(x1, x2);

        int risultato =  multiplication(x1 ,x2);
        System.out.println("La moltiplicazione dei due numeri  " + risultato);



        greet();
        int lunghezza = greetWithName("Stefano");
        System.out.println(lunghezza);
        lunghezza = greetWithName("Marta");
        System.out.println(lunghezza);
        

        boolean pari = isEven(1);
        System.out.println("E' pari: " + pari);

        printLenAndUpperCaseLowerCase("Come Stai?");


        String longer = getLonger("giovannisecondo" , "giovanni");{
            System.out.println(longer);
        }

    }


    
    // Ogni funzioni hanno le propie varaiabili
    // le funzione devono essere scritte sempre al di fuori della main
    // visibile a tutto il programma, dichiarazione del tipo int e il nome della funzione 

    public static int readInteger(){ // è un blocco di codice riutilizzabile per richimare ed esguirà un attività

        Console console = System.console(); 

        System.out.print("Dammi un numero >  ");
        String input = console.readLine();
        int x = Integer.parseInt(input);
        return x;
    }



    public static int sum(int x , int y){  // è una funzione sia input che ouput per creare la somma
        int z = x + y;
        return z;
    }


    public static void printSum(int x , int y){
        int z = x +y;
        System.out.println(z);
    }
    
    public static int multiplication (int x , int y){
        int s = x * y;
        return s;
    }

    // quello che segue è la definzione della funzione greet
    public static void greet(){ 
        System.out.println("è un piacere conoscerti");
    }

    public static int greetWithName(String name){ // 
        System.out.println("è un piacere conoscerti " + name);
        int len = name.length(); 
        return len;

    }

    public static boolean isEven(int z){
        // if(z % 2 == 0){
        //     return true;
        // } else {
        //     return false;
        // }
        return z % 2 == 0; // se x è pari ritorna vero, se no ritorna false.
    }
   
     
    public static void printLenAndUpperCaseLowerCase(String sentence){
        int len = sentence.length();
        System.out.println(len);
        String lower = sentence.toLowerCase();
        System.out.println(lower);
        String upper = sentence.toUpperCase();
        System.out.println(upper);

    }

    public static String getLonger(String s1 , String s2){
        // if(s1.length() > s2.length()){
        //     return s1;
        // } else {
        //     return s2;
        // }
        return s1.length() > s2.length() ? s1  : s2;  // se s1 è piu lunga di s2 ? ci stampa s1 altrimenti se è falso s2 è un simil booleano.
    }

    
}
