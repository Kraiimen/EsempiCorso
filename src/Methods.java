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
        sum(x1 , x2); // se non c'è una variabile che la riceve, non cambia nulla invocando sum
        // String mancoPerIdea = sum(3 , 4); questo risulterebbe in un errore perchè la funzione dichiara di essere un intero e la stiamo cercando di convertire in una stringa
        greet();
        int lunghezza = greetWithName("Sabrina"); // esegue la funzione e gli ritorna alla main dandogli valore int
        System.out.println(lunghezza);
        lunghezza = greetWithName("Marta");
        System.out.println(lunghezza);
        boolean even = isEven(7);
        System.out.println(even);
        printLenAndUpperCaseLowerCase("Tutto bene?");
        String longer = getLonger("Pierino" , "Pluto");
        printInTitleCase("pAPeRiNo");
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
        int len = name.length(); // la lunghezza del nome 
        return len;
    }

    public static boolean isEven(int x){ // variabili e parametri in una funzione esistono solo in quella funzione
        // if(x % 2 == 0){
        //     return true;
        // } else{
        //     return false;
        // }
        return x % 2 == 0; // se x è pari ritorna vera, se no ritorna falsa
    }

    public static void printLenAndUpperCaseLowerCase (String sentence){
        int len = sentence.length(); // lunghezza della stringa 
        System.out.println(len);
        String lower = sentence.toLowerCase();
        System.out.println(lower);
        String upper = sentence.toUpperCase();
        System.out.println(upper);
    }

    public static String getLonger (String s1 , String s2){
        // if(s1.length() > s2.length()){
        //     return s1;
        // } else{
        //     return s2;
        // }
        return s1.length() > s2.length() ? s1 : s2; // Operatore ternario (Lavora su 3 elementi) il ? segue un'espressione booleana 
    }

    public static void printInTitleCase (String name){
        System.out.println(name.length()); //stampa quello che ritorna della funzione length eseguita sulla stringa name, .length non è un metodo statico
        System.out.println(name.toUpperCase()); // ritorna e crea e stampa una nuova stringa con la funzione upper case sulla stringa name
        String upper = name.toUpperCase();
        String lower = name.toLowerCase();
        char first = name.charAt(0); // prende il primo carattere della stringa
        char firstUpper = Character.toUpperCase(first); //metodo statico di character che prende l'input first 
        String subString = lower.substring(1);
        String result = firstUpper + subString;
        System.out.println(result);
        // le stringhe in java sono immutabili

    } 
}
