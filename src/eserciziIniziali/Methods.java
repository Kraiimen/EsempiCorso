package eserciziIniziali;

import java.io.Console;
public class Methods{
    public static void main(String[] args){
        // Console console = System.console();// .console è una funzione la variabile ha ol nome console, C è nome classe e c è il nome

        // System.out.println("Dammi un numero > ");
        // String input1 = console.readLine(); // creo stringa di nome input e deve leggere la console
        // int x1 = Integer.parseInt(input1);
        // System.out.println("Dammi il secondo numero > ");
        // String input2 = console.readLine();
        // int x2 = Integer.parseInt(input2);

        int x1 = readInteger();
        int x2 = readInteger();

        System.out.println("La somma dei due numeri è " + (x1 + x2));
        int result = sum(x1 , x2);
        System.out.println("la somma dei due numeri è " + result);

        printSum(x1 , x2);
        sum(x1 , x2); //se non c'è una variabile che la riceve, non cambia nulla invocando sum

        int nameLength = greetWithName("Sabrina");
        System.out.println(nameLength);

        boolean checkEven = isEven(5);
        System.out.println(checkEven);

        printLenAndUpperCaseLowerCase("Ciao coMe Stai?");

        String longer = getLonger("12345678", "a2345678");
        System.out.println(longer);

        printInTitleCase("marta");
        
    }


    public static int readInteger(){ // è UN BLOCCO DI CODICE Riutilizzabile a mio piacimento
        // è una funzione intero che legge l'input e converte in int
        // nelle tonde ci sarebbe un imput che serve alla macchina 
        // ma ad alcune non serve mettere nulla dentro
        // nelle {} c'è il body della funzione
        Console console = System.console();
        System.out.println("Dammi un numero intero > ");
        String input = console.readLine();
        int x = Integer.parseInt(input); //legge dall'input un numero e la trasforma in un intero
        return x; // e la fa ritornare come numero intero

    }

    public static int sum(int x, int y){ // int: mi torna un intero
    // funzione che prenderà x e y e farà una somma
        int z = x + y;
        return z;

    }

    // quello che segue è la definizione della funzione greet
    public static void greet(){ 
        // la keyword public significa che la funzione sarà visibile in tutto il programma
        System.out.println("è un piacere conoscerti!"); 
    }

    public static void printSum(int x , int y){
        int z = x + y;
        System.out.println(z);
    }

    public static int greetWithName(String name){
        System.out.println("è un piacere conoscerti " + name);
        int len = name.length();
        return len;
    }

    public static boolean isEven(int number){
        
        // if(number % 2 == 0){
        //     return true;
        // }else{
        //     return false;
        // } 

        return number % 2 == 0; // il risultato di questa espressione è già una booleana se number % 2 == 0 è vero dà true, se no dà false
    }

     public static void printLenAndUpperCaseLowerCase (String sentence){

        int len = sentence.length();
        System.out.println(sentence + " è lungo " + len + " caratteri.");
        System.out.println(sentence.toLowerCase() + " " + sentence.toUpperCase());

    }

    public static String getLonger (String str1, String str2){

        // if(str1.length() > str2.length()){ // se sono uguali ritorna il secondo valore dell'espressione
        //     return str1;
        // }else{
        //     return str2;
        // }

        return str1.length() > str2.length() ? str1 : str2;

    }

    public static void printInTitleCase (String name){
        System.out.println(name.length());
        System.out.println(name.toUpperCase().charAt(0) + name.substring(1));  
        
        String lower = name.toLowerCase();
        char first = name.charAt(0);                    // .charAt prende solo il carattere indicato
        char firstUpper = Character.toUpperCase(first);
        String subString = lower.substring(1);          // .substring ti crea una sottostringa a partire dall'indice indicato
        String result = firstUpper + subString;
        System.out.println(result);
    }

}