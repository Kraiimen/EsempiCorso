

public class MethodsExercises {
    public static void main (String[] args) {

        System.out.println(lastCharUpper("illussione"));  

        String str1 = "ciao bello";
        String str2 = "ciao bello tutto bene?";
        String str3 = "ciao bello, tutto bene? spero di si";
        System.out.println(mostLittle (str1, str2, str3)); 
          
        String[] stringLonger = {" S ", "Ciao", "Non vediamoci", "Buonasera", "Andiamo di là"};
        System.out.println("la stringa più lunga è: " + longerString(stringLonger)); 

        int a1 = 2;
        int b2 = 5;
        swapNumbers(a1, b2);
        System.out.println("Il valore di a è : " + a1 + " " + " Il valore di b è : " + b2); 
        
        int[] array = {1, 2, 3, 4, 5, 6, 7};   
        int counter = getMax(array);  
        System.out.println("Il valore più alto dell'array è " + counter); 

        int[] arraySum = {7, 5, 9, 2, 3};
        getSum(arraySum); 
        System.out.println("La somma dell'array è " + getSum(arraySum) + " ");   
        
        // String inputString2 = "SRTWRDTPLMNGHFGHF"; 
        // System.out.println(getVowels(inputString2)); 

        String getPalyndrome = "OSSO"; 
        System.out.println("La frase che hai messo è palindroma: " + palyndromeString(getPalyndrome)); 

    } 

     
    

    //1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
    public static char lastCharUpper(String word) {
        
        String upper = word.toUpperCase(); //defiisco un int che userò per la subString
        char last = upper.charAt(word.length() - 1); //definisco un char che prende l'ultimo carattere della stringa         
        return last; 
    }

    //2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
    public static String mostLittle(String str1, String str2, String str3) {

        if(str1.length() <= str2.length() && str1.length() <= str3.length()) {
            return str1; 
        } else if (str2.length() < str1.length() && str2.length() < str3.length()) {
            return str2;
        } else {
            return str3;
        }
    }

    //3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
    
    public static String longerString(String[] array) {

        String stringLonger = array[0];
        for(int i = 0; i < array.length; i++) {
            if(array[i].length() > stringLonger.length()) {
                stringLonger = array[i]; //Aggiorna con la stringa più lunga quando trova quella più corta
            }
        }
        return stringLonger; 
        
    }

    //4) creare una funzione che scambia i valori di due numeri interi
    
    public static void swapNumbers(int a, int b) {

        int temp = a;
        a = b;
        b = temp; 

        System.out.println("A: " + b); 
        System.out.println("B: " + a); 
         
    }

    //5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
    public static int getMax(int[] array) {

        if(array.length == 0) {
            return 0;                       //se non c'è ritorno, allora appuro che almeno una cella c'è
        } 

        for(int i = 0; i < array.length; i++) {  //se ci sono valori < di 1 ritorna 0
            if(array[i] < 1) {  
                return 0; 
            }    
        }

        int max = array[0]; 

        for(int i = 0; i < array.length; i++) {  //calcola max
            if(array[i] > max) {
                max = array[i]; 
            } 
        }

        return max;

    }

    //6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
    public static int getSum(int[] arraySum) {

        if(arraySum.length == 0) {
            return (-1);  
        } 

        int sum = 0; 

        if(arraySum.length != 0) {
            sum = arraySum[0] + (arraySum[0] + (arraySum.length - arraySum[0]));  
        } 
          
        return sum; 

    }

    //7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
    public static boolean getVowels(String inputString2) {
        
        char[] vowels = {'a', 'e', 'i', 'o', 'u'}; 
        char[] characters = inputString2.toLowerCase().toCharArray();
        for(int i = 0; i < characters.length; i++) {

            for(int iV = 0; iV < vowels.length; iV++) {
                if(characters[i] == vowels[iV]) {
                    if(characters.length > vowels.length && characters[i] == vowels[iV]) {
                    
                    }
                return false; 
            }  
                if(characters[i] != vowels[i]) {
                    if(characters.length > vowels.length && characters[i] != vowels[iV]) {

                    }
                    return true;
                }   
            }
        }
        return true;
    }

    //8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti
    public static boolean palyndromeString(String getPalyndrome) {

        boolean palyndromeStringTrue = true; 
        String stringWithoutSpaces = getPalyndrome.replaceAll("\\s", "");

        char[] charArray = stringWithoutSpaces.toLowerCase().toCharArray();
        //uso questo per far andare una variabile su e una variabile giù, mentre controllano
        for(int i = charArray.length-1, j = 0; j < i; j++, i--){
            if(charArray[i] != charArray[j]){
                palyndromeStringTrue = false;
                break;
            }
        }
        return palyndromeStringTrue;  
    }
}
