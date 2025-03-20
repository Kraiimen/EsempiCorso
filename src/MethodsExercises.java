public class MethodsExercises {
    public static void main(String[] args) {    
        
        //Esecuzione es. 1
        
        System.out.println("L'ultimo carattere in maiuscolo della stringa è " + lastChar("Ciao signore"));

        //Esecuzione es. 2

        String str1 = "Ciao";
        String str2 = "Buonasera";
        String str3 = "Signore";

        System.out.println("La stringa più piccola tra le tre è :" + getShorterString(str1, str2, str3));

        //Esecuzione es. 3

        String[] str = {",","zione", "ciaone", "Cavolo sono la piu lunga"};

        System.out.println(getLongerString(str));

        //Esecuzione es. 4

        int x1 = 5;
        int x2 = 6;
        swithNum(x1, x2);
        System.out.println("X ha il valore " + x1 + "mentre y ha il valore" + x2);

        //Esecuzione es. 5
        Int[] random = new Int[5];
        Random dice = new Random();

        // for(int i = 0; i < random.length; i++) {
        //     random[i] = dice.nextInt(10);
        //     System.out.println(random[i] + " ");
        // }

        Int maxNum = maxArrayNum(random);
        System.out.println("\nIl numero piu grande dell'array è: " + maxNum);
        

        //String str; è una dichiarazione
        //String str = "ciao"; è un'inizializzazione
        //
    }

    // 1) creare una funzione che prende in input una stringa che mi ritorna il suo ultimo carattere in maiuscolo

    public static char lastChar(String str) {
        String upper = str.toUpperCase(); //dichiara una varibile di tipo String col nome lower che contiene str in minuscolo
        char last = upper.charAt(upper.length()-1); //Dichiara una variabile di tipo char col nome last che contiene l'ultimo carattere di str

        return last;

    }

    // 2) creare una funzione che prende in input tre stringhe e mi ritorna la più piccola delle tre.
    // Se ad essere le più piccole sono in più di una, me ne ritrorna una qualsiasi delle più piccole.

    //public static "tipo di danto di ritorno" "nome" () {}
    public static String getShorterString(String str1, String str2, String str3) {
        if(str1.length() <= str2.length() && str1.length() <= str3.length()) {
            return str1;
        } else if(str2.length() <= str1.length() && str2.length() <= str3.length()) {
            return str2;
        } else {
            return str3;
        }
    }
    // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.

    public static String getLongerString(String [] array) {
        if(array.length == 0) {
            return "";
        }
        String stringaPiuLunga = array[i]; //aggiorna la stringa piu lunga se troviamo una stringa piu lunga.

            for(int i = 0; i < array.length; i++) {
                if(array[i].length() > stringaPiuLunga.length()) {
                    stringaPiuLunga = array[i];
                }
            }

            return stringaPiuLunga;
    }
   
    // 4) Creare una funzione che scambia i valori di due numeri interi.

    public static void switchNum(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    // 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.

    public static Int maxArrayNum(int[] numbers) {
        int maxNum = 0;
        for(Int i = 0; i < number.length; i++) {
            if(numbers[i] > manNum) {
                maxNum = numbers[i];
            }
        }
    }

    // 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1.



    // 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti.



    // 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti.
    
    
}


