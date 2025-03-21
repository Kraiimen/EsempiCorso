import java.io.Console; 
public class Methods {
    public static void main(String[] args) {
        // Console console = System.console(); //permetto di leggere la risposta

        // System.out.print("Dammi un numero -> "); 
        // String input1 = console.readLine(); 
        // int x1 = Integer.parseInt(input1); 
        // System.out.println();
        // System.out.print("Dammi un numero -> ");
        // String input2 = console.readLine(); 
        // int x2 = Integer.parseInt(input2);

        int x1 = readInteger(); 
        int x2 = readInteger(); 

        System.out.println("La somma dei due numeri è -> " + (x1 + x2));  
        
        int result = sum(x1, x2); 
        System.out.println("La somma dei due numeri è " + result); 
        printSum(x1, x2); 
        sum(x1, x2); //se non c'è una variabile che la riceve, non cambia nulla invocare sum
        greet();
        int lunghezza = greetWithName("Nicolò");
        System.out.println(lunghezza);
        lunghezza = greetWithName("Marta");
        System.out.println(lunghezza);
        printinTitleCase("Ciao come Stai? Spero TUtto bENE");

    }
        // posso scriverlo meglio, così    

    public static int readInteger() {
        Console console = System.console();

        System.out.print("Dammi un numero -> "); 
        String input = console.readLine(); 
        int x = Integer.parseInt(input); 
        return x; 
    }

    public static int sum(int x, int y) {
        int z = x + y;
        return z;
    }

    public static void greet() {
        System.out.println("E' un piacere conoscerti");
    }

    public static void printSum(int x, int y){ // uso una funzione per non scrivere righe e righe 
        int z = x + y;
        System.out.println(z); 
    }

    // una funzione è un blocco di codice riutilizzabile

    public static int greetWithName(String name) {
        System.out.println("E' un piacere conoscerti " + name);
        int lunghezza = name.length(); // per le stringhe .length è una funzione e va tra due parentesi
        // len conta i caratteri della stringa, quindi la sua lunghezza    
        return lunghezza;  
    }
    
    public static boolean isEven(int x) { //ritorna true se un numero int datogli in input è pari
        // if(x % 2 == 0) {
        //     return true; 
        // } else {             //finchè non metto else non posso ritornare niente, 
        //     return false;    //ha bisogno di sapere cosa succede in tutti i casi
        // }                    
        return x % 2 == 0; // modo elegante per scrivere questa funzione
    }

    public static void printLenAndUppercaseLowercase(String sentence) {
        int len = sentence.length();
        System.out.println(len);
        String lower = sentence.toLowerCase();
        System.out.println(lower);
        String upper = sentence.toUpperCase();
        System.out.println(upper);
    }

    public static String getLonger (String s1 , String s2) {
        // if(s1.length() > s2.length()) {
        //     return s1;
        // } else {
        //     return s2;
        // } 
        
        return s1.length() > s2.length() ? s1 : s2; 

        // return s1.lenght() > s2.lenght() ? s1 : s1.lenght() < s2.lenght() ? s2 : "sono della stessa lunghezza";
    }

    public static void printinTitleCase (String name) {
        System.out.println(name.length()); //stampa la length della stringa
        String upper = name.toUpperCase(); 
        // System.out.println(name); // le stringhe sono immutabili, non è possibile cambiare una stringa, 
                                     // quindi in questo caso l'ultimo name rimarrà in minuscolo perchè,
                                     // .toUpperCase coinvolge solo la stringa di prima.
        String lower = name.toLowerCase();        
        char first = name.charAt(0); //prende il primo carattere della stringa
        char firstUpper = Character.toUpperCase(first); //questo è un metodo statico della classe character (riconoscibile per la C maiuscola)
        String subString = lower.substring(1); 
        String result = firstUpper + subString;
        System.out.println(result);  
    }

    //metodo statico: metodo che chiamo direttamente su una classe, normalmente li chiami sugli oggetti



}



