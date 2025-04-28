// 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo

// 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
// 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti
public class FunzioniEsercizi{
    public static void main(String[] args){
    //String str = "Luca";
    //String str1 = "Pippo";
    //String str2 = "ape";
    //char lastUpper = stampaUltChar(str);
    //System.out.println(lastUpper);
        //public static char stampaUltChar (String str){
    //     char last = str.charAt(str.length() - 1);
    //     char lastUpper = Character.toUpperCase(last);
    //     return lastUpper;
    // }
    String str1 = "ciao";
    String str2 = "torrente";
    String str3 = "tormentone";
    String[] strs = new String[]{ str1, str2, str3 };
    String max = stampLongString(strs);
    int x = 1, y = 2;
    scambioValori(x , y);
    int[] numbers = new int[]{1,5,9,2,10,7};
    int maxInt = findMax(numbers);
    int sumInt = findSum(numbers);
    //System.out.println("L'ultimo carattere in minuscolo della stringa è" + lastChatr("Luca") +"" );
}
    // 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
    public static void lastChar(String str){
    
    }
  
    public static String getShorterString(String str1, String str2, String str3){
        if(str1.length() <= str2.length() && str1.length() <= str3.length()) {
            return str1;
        } else if ( str2.length() < str1.length() && str2.length() < str3.length()){
            return str2;
        } else {
            return str3;
        }
    }
// 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
   
    public static String stampLongString(String[] arraystr){
        String max = arraystr[0];
        for(int i = 0; i < arraystr.length; i++){
            if(max.length() < arraystr[i].length()){
                max = arraystr[i];
            }
        }
        System.out.println(max);
        return max;
    }
// 4) creare una funzione che scambia i valori di due numeri interi
    public static void scambioValori(int a , int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a : " + a + " b : " + b); 
    }
// 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
    public static int findMax( int[] numbers){
        int max = numbers[0];
        for(int i = 0; i < numbers.length; i++){
            if( numbers.length == 0 || numbers[i] == 0){
                System.out.println(0);
                return 0;
            } else{
                if(max < numbers[i]){
                max = numbers[i];
            }
            }
        }
        System.out.println(max);
        return max;
    }
// 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
    public static int findSum(int[] numbers){
        int somma = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers.length == 0 || numbers[i] == 0 || numbers[i] < 0){
                System.out.println(-1);
                return -1;
            } else{
                somma = somma + numbers[i];
            }
        }
        
        System.out.println(somma);
        return somma;

    }
}