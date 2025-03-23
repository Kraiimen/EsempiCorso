// 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
// 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
// 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
// 4) creare una funzione che scambia i valori di due numeri interi
// 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
// 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
// 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
// 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti

public class MethodsExercises {
    
    public static void main(String[] args) {
        
        //esercizio 1
        char lastUpper = lastChar("Cane");// ora sa che l'imput è la parola "cane" il tutto creato dopo il corpo della funzione char
        System.out.println(lastUpper);

        //esercizio 2
        String str = getShorterString("precipitevolissimevolmente" , "buonasera" , "rosso");
        System.out.println("la stringa più piccola è " + str); 

        //esercizio 3
        String[] array3 = new String[] {"ciao", "gatto", "lampione"};
        String s = getLongerString(array3); 
        System.out.println("la stringa più lunga è " + s);
        
        //esercizio 4

        //esercizio 5
        int[] array5 = new int[] {3, 2, 8, 6};
        int x = maxValue(array5);
        System.out.println("il valore massimo è " + x);
        





    }
    // 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
    public static char lastChar(String cane){
        char last = cane.charAt((cane.length() - 1));
        char lastUpper = Character.toUpperCase(last);
        return lastUpper; 
    }

    // 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
    public static String getShorterString(String s1, String s2, String s3){
        if (s1.length() <= s2.length() && s1.length() <= s3.length()){
            return s1;
        } else if (s2.length() < s1.length() && s2.length() < s3.length() ) {
            return s2; 
        } else { 
            return s3;
        }
    }
    // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
    public static String getLongerString (String[] array) {
        String longest = ""; 
        for( int i=0 ; i < array.length - 1; i++) {
            if(array[i].length() > array[i+1].length()){    // ciao one lunghezza 4, lampione lunghezza 8, gatto lunghezza 5;
                longest = array[i];
            } else {
                longest = array[i+1];
            } 

        }
        return longest; 
    }
    
    // 4) creare una funzione che scambia i valori di due numeri interi
    public static void changeNumbers (int x, int y) { //differenza fra parametri della funzione e argomenti
        int temp = x;
        x = y;
        y = temp; 
    }
    
    // 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
    public static int maxValue (int[] array){
        
        if ( array.length == 0 ){
            return 0; 
        } 
        
        for (int i=0; i < array.length; i++){ // se l'array è 3 1 2 6 8 
            if (array[i] <= 0 ){
                return 0;
            }                 
        }
        
        int max = array[0]; // in questo modo il massimo viene inizializzato con in primo elemento dell'array e iniziamo con l'idice "i" a 1 
        for (int i = 1; i < array.length -1; i++){
            if(array[i] > max) {
                max = array[i];
            }
        }

        return max;

    }


} 
