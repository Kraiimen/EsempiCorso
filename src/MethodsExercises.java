import java.util.Random;

public class MethodsExercises {
    public static void main (String[] args){

        // esecuzione es 1

        char last = lastChar("questa è una frase");
        System.out.println(last);

        // esecuzione es 2

        String shortStr = getShortestStr("plutossdds", "paperino", "batman");
        System.out.println("La stringa più corta delle 3 è: " +shortStr);

        // esecuzione es 3

        String[] strArray = {"ciao", "abc", "12", "arcobaleno", "gattino"};
        String longStr = longestStr(strArray);
        System.out.println("La stringa più grande dell'array è: " + longStr);

        // esecuzione es 4

        int x1 = 5;
        int x2 = 6;
        switchNum(x1, x2);
        System.out.println("X ha il valore " + x1 + " mentre y ha il valore " + x2);

        // esecuzione es 5

        int[] random = {1, 6, 3, 8, 0};
        // Random dice = new Random();
        
        // for(int i = 0; i < random.length; i++){
        //     random[i] = dice.nextInt(10);
        //     System.out.print(random[i] + " ");
        // }

        int maxNum = maxArrayNum(random);
        System.out.println("\nIl numero più grande dell'array è: " + maxNum);

        // esecuzione es 6
        
        int sum = arraySum(random);
        System.out.println(sum);

        // esecuzione es 7

        boolean noVowels = hasVowels("AOEDU");
        System.out.println(noVowels);

        // esecuzione es 8 

        boolean checkPalindromo = palindromo("I topi non avevAno niPoti");
        System.out.println(checkPalindromo);

    }

    // 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo

    public static char lastChar (String word){

        int len = word.length();
        return word.toUpperCase().charAt(len-1);
        
    }

    // 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
    
    public static String getShortestStr (String s1, String s2, String s3){

        if (s1.length() < s2.length() && s1.length() < s3.length()){
            return s1;
        } else if (s2.length() < s3.length()){
            return s2;
        } else {
            return s3;
        }

    }
    
    // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
    
    public static String longestStr (String[] strArray){

        if(strArray.length == 0){
            return "";
        }

        String max = strArray[0];
        for(int i = 1; i < strArray.length; i++){
            if(strArray[i].length() > max.length()){
                max = strArray[i];
            }
        }
        return max;

    }
    
    // 4) creare una funzione che scambia i valori di due numeri interi

    public static void switchNum (int x, int y){

        int temp = x;
        x = y;
        y = temp;

    }

    // 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.

    public static int maxArrayNum (int[] numbers){

        int maxNum = 0;

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] > maxNum){
                maxNum = numbers[i];
            }
        }

        return maxNum;

    }

    // 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1

    public static int arraySum (int[] numbers){

        int sum = 0;
        if(numbers.length == 0){
            sum = -1;
        }

        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
            
        if (sum == 0){
            sum = -1;
        }
        
        return sum;

    }

    // 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti

    public static boolean hasVowels (String sentence){
        
        boolean noVowels = true;
        
        char[] charArray = sentence.toLowerCase().toCharArray();
        for (int i = 0; i < charArray.length; i++){
            if (charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u'){
                noVowels = false;
                break;
            }
        }

        return noVowels;
    }

    // 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti

    public static boolean palindromo (String sentence){

        boolean checkPalindromo = true;

        String stringWithoutSpaces = sentence.replaceAll("\\s", "");

        char[] charArray = stringWithoutSpaces.toLowerCase().toCharArray();
        for(int i = charArray.length-1, j = 0; j < i; j++, i--){
            if(charArray[i] != charArray[j]){
                checkPalindromo = false;
                break;
            }
        }

        return checkPalindromo;
    }

}