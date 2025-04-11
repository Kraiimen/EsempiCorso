public class Exercises{  
    public static void main(String[] args){
        //esercizio 1
        char maiusc = lowerChar ("giacomo");
        System.out.println(maiusc);
        
        //esercizio 2
        String littleString = getSmallestString("pippo", "pollo", "giacomo");
        System.out.println(littleString);
        
        //esercizio 3
        String[] arrayList = {"Pippo", "pierino","anastasia"};
        String longLongString = longString (arrayList);
        System.out.println(longLongString);
        
        //esercizio 4
        exchange (3 , 10);

        //esercizio 5
        int [] arraynum = {2,3,4};
        int bigarray = max (arraynum);
        System.out.println(bigarray);
        
        //esercizio 6
        int [] arraysum = {};
        int sumarray = sum (arraysum);
        System.out.println(sumarray);
        
        //esercizio 7
        Boolean check = controlloVocali("giacomino");
        System.out.println(check);
        
        //esercizio 8
        boolean palindromo = controlloPalindromi ("anna");
        System.out.println(palindromo);
    }

// 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
   
    public static char lowerChar (String name){
        
        char last = name.charAt(name.length()-1);  //individuiamo l' ultimo char della stringa (length -1 perché si parte da 0)
        char lastUpper = Character.toUpperCase(last); //lo rendiamo in lowerCase
        
        return lastUpper;
    }

// 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
    
    public static String getSmallestString (String string1,String string2, String string3){
        if(string1.length() <= string2.length() && string1.length() <= string3.length()){
            return string1;
        }else if (string2.length() < string1.length() && string2.length() < string3.length()){
            return string2;
        }else{
            return string3;
        }
    }
    
// 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
//    public static String longString (String[] array){
//     String longestString = array [0];
//     for (int i = 0; i < array.length-1; i++){
//         if (array[i].length() > array[i + 1].length()){
//             longestString = array[i];        
//         }else{
//             longestString = array[i + 1];
//         }
//     }
//     return longestString;
//    }
public static String longString (String[] array){
    if (array.length == 0){
        return "";
    }
    String longestString = array [0];
    
    for (int i = 1; i < array.length; i++){
        if (longestString.length() < array[i].length()){
            longestString = array[i];
        }
    }
    return longestString;
   }
    

// 4) creare una funzione che scambia i valori di due numeri interi
   
    public static void exchange(int x, int y){ 
        int z = x;
        x = y;
        y = z;
        System.out.println(x + " " + y);
    }
// 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
   
    public static int max (int[] array2){
        int arraymax = 0;
        for (int i = 0; i < array2.length-1 ; i++){
            if (array2[i] < array2[i + 1]){
                arraymax = array2[i + 1];
            }
        }
        return arraymax;
    }

// 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
   
    public static int sum(int[] array3){
        int x = -1;
        if (array3.length == 0){
            return  x;
        }
        int arraysum = 0;
        for (int i = -1 ; i < array3.length -1 ; i++){
            arraysum += array3[i + 1];
        }
        return arraysum;
    }
// 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
   
    public static boolean controlloVocali(String stringa){
        boolean noVocali = true;
       
        String nuovaStringa = stringa.toLowerCase();
        
        for (int i = 0; i < nuovaStringa.length()-1; i++){
            char vocale = nuovaStringa.charAt(i);
            if (vocale == 'a'|| vocale =='e'|| vocale =='i'|| vocale =='o'|| vocale =='u'){
                noVocali = false;
                break;
            }
        }
        return noVocali;
    }

// 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti
    
    public static boolean controlloPalindromi(String stringa){
       
        String nuovaStringa = stringa.toLowerCase();

        for (int i = 0; i < nuovaStringa.length()-1; i++){
            if (stringa.charAt(i) != nuovaStringa.charAt(nuovaStringa.length()-1-i)){
                return false;  
            }
        }
        return true;

    }  
   
}