public class MethodsEx{
    public static void main(String[] args){
        // 1 creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
        // 2 creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. 
        //      Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
        // 3 creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array.
        //       Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
        // 4 creare una funzione che prende in input due numeri interi e scambia i valori di due numeri interi
        // 5 creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. 
        //      Se l array e' vuoto restituisce 0.
        // 6 creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. 
        //      Se l array e' vuoto mi restituisce -1
        // 7 creare una funzione che riceve in input una stringa e mi restituisce una booleana true 
        //      se la stringa non contiene vocali, false altrimenti
        // 8 creare una funzione che riceve in input una stringa e mi restituisce una booleana true 
        //      se la stringa e' palindroma, false altrimenti

        // es 1
        // char ultima = lastChar("Lettera");
        // System.out.println(ultima); 
        // oppure
        System.out.println(MethodsEx.lastChar("Lettera")); 

        // es 2
        // String smollest = minoreDiTre("Sole " , "Cuore " , "Amore ");
        System.out.println(MethodsEx.minoreDiTre("Sole " , "Cuore " , "Amore ")); 

        // es 3 
        String[] stringa = {"medio" , "lungo" , "lunghissimo" , " 'lughissimissimo' "};
        System.out.println("La stringa più lunga è " + longestOfArray(stringa));

        // es 4
        int x1 = 5;
        int x2 = 6;
        switchNum(x1 , x2); // argomenti della funzione
        System.out.println("X ha il valore " + x1 + " mentre y ha il valore " + x2);

        // es 5
        int[] array = {3, 1, 2, 6, 8};

    }

    // ES 1 ultima lettera in maiuscolo
    public static char lastChar(String parola){
        System.out.println(parola); // abbiamo stampato la parola 
        char last = parola.charAt(parola.length()-1);
        char lastUpper = Character.toUpperCase(last);
        return lastUpper;
    }

    // ES 2 prende in input tre stringhe e ritorna la piu piccola delle tre.
    public static String minoreDiTre(String s1 , String s2 , String s3){
        System.out.println("\n" + s1 + s2 + s3);
        System.out.println("La più corta è: ");
        if(s1.length() <= s2.length() && s1.length() <= s3.length() ){
            return s1;
        } else if(s2.length() <= s1.length() && s2.length() <= s3.length()){
            return s2;
        } else {
            return s3;
        }      
    }

     // ES 3 prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array.
         //       Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
    public static String longestOfArray(String[] words){
        if (words.length == 0){
            return "";
        }
        String longestString = words[0];
        for (int i = 1; i < words.length-1;i++){
                if (words[i].length() > longestString.length()){ //words[i] è il valore del contenuto della cella ni. 
                  // . length è la lunghezza della stringa che sta nella cella i
                    longestString = words[i];
                }
        }
        return longestString;
    }

     // ES 4 creare una funzione che scambia i valori di due numeri interi
    public static void switchNum(int x, int y){
        int temp = x;
        x = y;
        y = temp;

    }

    // ES 5 riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. 
    // Se l array e' vuoto restituisce 0.
    public static int max(int[] numbers){
        if(numbers.length == 0){
            return 0;
        } 
        for (int i = 0; i < numbers.length-1; i++){
            if (numbers[i] <= 0){
                return 0
            }
        }
        int massimo = 0;
        for (int i = 0; i < numbers.length-1; i++){
            if(max)
        }
    }
}