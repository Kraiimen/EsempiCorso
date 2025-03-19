import java.io.Console; // io sta per input output
public class Methods{
    public static void main(String[] args){





        int num1 = readInteger(); // invochiamo la funzione readInteger che assegna il valore di num  a num1
        int num2 = readInteger(); 

        //System.ou.println("La somma dei due numeri è: " + num1+num2) //stampa num1 e num 2 come stringa -> errore di logico -> lo fa perche a concatenare parte da sinistra 
        //System.ou.println("La somma dei due numeri è: " + (num1+num2)); //necessario per fare correttamente la somma di num1 e num 2
        System.out.println("La somma dei due numeri è: " + sum(num1, num2)); 
        printSum(num1, num2);
        int lengthName = greetAndReturnLenName("Fabio");
        System.out.println("Il tuo nome è lungo " + lengthName + " caratteri");
        int number = 7;
        boolean isEven = isNumberEven(number);
        if(isEven){
            System.out.println(number + " è pari");
        }else{
            System.out.println(number + " è dispari");
        }
        printLenAndUpperCaseLowerCase("Tutto bene?");
        System.out.println(getLonger("cavallo matto", "frase"));
        printInTitleCase("aBgewKhduwhd");


    }
//quell0 che segue è la definizione della funzione readInteger, affinche il suo codice venga eseguito devo invocarla
    public static int readInteger(){ 
        Console console = System.console(); //chiamiamo il metodo console di system
        String input = console.readLine("Dammi un numero > ");
        int num = Integer.parseInt(input);
        return num;
    }
    public static int sum(int x, int y){
        int sum = x + y;
        return sum;
    }
    public static void printSum(int x, int y){
        System.out.println("La somma dei due numeri è: " + sum(x, y)); 
    }
    public static int greetAndReturnLenName(String name){
        System.out.println("Ciao "+ name);
        int len = name.length(); // il metofo length ci ritorna la lunghezza della stringa che la invoca
        return len;


    }
    public static boolean isNumberEven(int num){
    //     if(num % 2 == 0){
    //         return true;
    //     }
    //     return false;
    // }
    return num % 2 == 0; //lo posso fare in quanto il risultato di questa espressione ci ritorna un valore booleano
    }
    //Ricevi in input una stringa e stampi la sua lunghezza 
    public static void printLenAndUpperCaseLowerCase(String sentence){
        System.out.println("La frase è lunga: " + sentence.length() + " caratteri");
        String lower = sentence.toLowerCase();
        System.out.println(lower);
        String upper = sentence.toUpperCase();
        System.out.println(upper);


    }
    // ci ritorna la stringa piu lunga
    public static String getLonger(String first, String second){
        // if(first.length() > second.length()){
        //     return first;
        // }else{
        //     return second;
        // }

        // Operatore ternario
        //                 CONDIZIONE            SE TRUE  SE FALSE                       
        return first.length() > second.length() ? first : second;
    }
    // 
    public static void printInTitleCase(String name){
        // System.out.println(name.toUpperCase()); // to uppercase ci ritorna una nuova stringa, non modifica la string name
        // System.out.println(name);// name non cambia
        String upper = name.toUpperCase();
        String lower = name.toLowerCase();
        char first = name.charAt(0); // salviamo il primo carattere della stringa nel char first
        //java è un linguaggio ad oggetti non completamente/puramente ad oggetti perche ci sono le primitive
        //Character la versione ad oggetti dei char, java ha anche una versione ad oggetti delle primitive
        // queste classi vengono dette anche classi wrapper, in quanto "avvolgono/contengono" la primitiva
        char firstUpper = Character.toUpperCase(first); // chiamo il metodo direttamente nella classe
        //per ottenere la substring di una stringa si puo usare il metodo substring
        String subString = lower.substring(1);
        String result = firstUpper + subString; //concatenazione fra char e string
        System.out.println(result);


    }

}