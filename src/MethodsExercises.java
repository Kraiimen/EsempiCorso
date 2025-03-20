
// 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti
public class MethodsExercises {
    public static void main(String[] args) {
        System.out.println(lastLetterUC("ciccio"));
        String smallestOf3 = smallestString("Gino", "Lorenzo", "Gino");
        System.out.println(smallestOf3);
        String[] arrayWords = {"Banana", "CC", "VERY BIG ORANGE", "CCC", };
        int[] arrayNumbers = {5,13,4,7,21,3,5,6};
        System.out.println(longestString(arrayWords));
        switchValue(3,5);
        System.out.println(maxNumbArray(arrayNumbers));
        System.out.println(checkVowels(arrayWords));
        System.out.println(isPalindrome("ITOPINONAVEVANONIPOTI"));
        boolean[] result = checkVowels(arrayWords);

        //
        for(int i = 0; i < result.length; i++) {
            System.out.println(arrayWords[i] + " contiene delle vocali?: " + result[i]);
        }

        //
        

    }
    // 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
                                    //ESERCIZIO 1
    public static char lastLetterUC(String word) { //Creo metodo che prende in input una stringa e da in output un char
        char lastLetter = word.charAt(word.length()-1); //Ottengo dalla stringa in input l'ultima lettera e la trasformo in char.
        lastLetter = Character.toUpperCase(lastLetter); //Trasformo l'ultima lettere in uppercase
               return lastLetter; //Ritorno il risultato
    }

    //2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. 
    //   Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
                                    //ESERCIZIO 2
    public static String smallestString(String string1, String string2, String string3) {
        if(string1.length() > string2.length()) {
            if(string2.length() > string3.length()) {
                return string3;
            } else {
                return string2;
            }
        }
        else if(string1.length() < string3.length()) {
            return string1;
        } else {
            return string3;
        }
    }
    
        // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. 
        //    Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
    public static String longestString(String[] words) {
        String longestString = words[0];
        for (int i = 1; i < words.length-1; i++) {
            
            if(words[i].length() > words[i+1].length()) {
                longestString = words[i];
            }
            else{
                longestString = words[i+1];
            }
        }
        return longestString;
    }
    
    // 4) creare una funzione che scambia i valori di due numeri interi
    public static void switchValue(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a adesso vale " + a + " b adesso vale " + b);
    }
     
    // 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. 
    //    Se l array e' vuoto restituisce 0.

    public static int maxNumbArray(int[] numbers) {
        int maxNumber = 0;
        for(int i = 1; i < numbers.length -1 ; i++) {
            if(maxNumber < numbers[i]) {
                maxNumber = numbers[i];
            }        
        }
        return maxNumber;
    }
   // 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
   
    public static int sumArray(int[] numbers) {
        int sumValue = 0;
        if(numbers == null || numbers.length == 0 ) { 
            return -1;
        }

        for(int i = 0; i < numbers.length; i++) {
            sumValue += numbers[i];
        }
        return sumValue;
    }
    

    // 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
    public static boolean checkVowels(String word) {
        boolean check = false;
        for (int i = 0; i < word.length(); i++) {
            char lowercase = Character.toLowerCase(word.charAt(i)); 
            if(lowercase == 'a' || lowercase == 'e' || lowercase == 'i' || lowercase == 'o' || lowercase == 'u'){
                check = false;
            }
        }
            
        return check;
    }
    // 7.1) creare una funzione che riceve in input un array di stringhe e mi restituisce un array di booleane
    //false se non contengono vocali, true se le contengono
    public static boolean[] checkVowels(String[] word) {
        if(word == null || word.length == 0 ) {
            //exception
        }
        boolean[] vowels = new boolean[word.length];
        
        for(int i = 0; i < word.length; i++) {
            
            for(int j = 0; j < word[i].length()-1; j++) {
                char c = Character.toLowerCase(word[i].charAt(j));
                if(word[i].toLowerCase().charAt(j) == 'a' || word[i].toLowerCase().charAt(j) == 'e'|| word[i].toLowerCase().charAt(j) == 'i'|| word[i].toLowerCase().charAt(j) == 'o' || word[i].toLowerCase().charAt(j) == 'u') {
                    vowels[i] = true;
                    
                }

            }

        }
        return vowels;
    }


    //8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti

    public static boolean isPalindrome(String word) {
        boolean check = false;
        for(int i = 0, j = word.length()-1; i < j; i++, j--) {
            if(word.charAt(i) == word.charAt(j)) {
                check = true;
            }
        }


        return check;
    }
}
    

