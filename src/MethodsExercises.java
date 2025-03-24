import java.util.Random;
public class MethodsExercises{
    public static void main(String[] args){
        //es 1
        System.out.println(getLastToUpperCase("AAAAA"));

        //es2
        System.out.println(getShortest("BBB", "BB", "BBBB"));

        //es3
        String[] stringList = {"pippo", "paperino", "topolino", "minnie", "pluto"};
        System.out.println(getLongest(stringList));

        //es4
        int x = 3;
        int y = 4;
        swapNum(x , y);
        System.out.println(x);
        System.out.println(y);

        //es5
        int[] random = new int[7];
        Random dice = new Random();

        for(int i = 0 ; i < random.length ; i++){
            random[i] = dice.nextInt(100);
            System.out.print(random[i] + " ");
        }
        System.out.println();

        System.out.println(getMax(random));

        //es6
        System.out.println(sumArray(random));

        //Arrays vuoti
        int[] empty = new int[0];
        System.out.println(getMax(empty));
        System.out.println(sumArray(empty));

        //es7
        System.out.println(haveNotVowels("BCDFG"));
        System.out.println(haveNotVowels("ciao"));

        //es8
        System.out.println(isPalindrome("aaaaaaaaaaa"));
        System.out.println(isPalindrome("anna"));
        System.out.println(isPalindrome("asdfg"));

        

    }
    // 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
    
    public static char getLastToUpperCase(String s){
        char last = s.charAt((s.length())-1);
        char lastLower = Character.toUpperCase(last);
        return lastLower;
    }

    // 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre.
    // Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole

    public static String getShortest(String s1, String s2, String s3){
        String shortS = s1;
        if(s2.length() < shortS.length()){
            shortS = s2;
        }
        if(s3.length() < shortS.length()){
            shortS = s3;
        }
        return shortS;
    }

    // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array.
    // Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.

    public static String getLongest(String[] strings){
        if(strings.length == 0){
            return "";
        }
        
        String longestS = strings[0];
        for(int i = 1 ; i < strings.length ; i++){
            if(strings[i].length() > longestS.length()){
                longestS = strings[i];
            }
        }
        
        return longestS;
    }

    // 4) creare una funzione che scambia i valori di due numeri interi

    public static void swapNum(int x , int y){
        int temp = x;
        x = y;
        y = temp;
    }

    // 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo.
    // Se l array e' vuoto restituisce 0.

    public static int getMax(int[] numbers){
        int maxVal = 0;
        for(int i = 1 ; i < numbers.length; i++){
            if(numbers[i] > maxVal){
                maxVal = numbers[i];
            }           
        }
        return maxVal;
    }

    // 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma.
    // Se l array e' vuoto mi restituisce -1
    
     public static int sumArray(int[] numbers){
        if(numbers.length == 0){
            return -1;
        }
        int sum = 0;
        for(int i = 0 ; i < numbers.length ; i++){
            sum = numbers[i] + sum;
        }
        
        return sum;
     }

    // 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali,false altrimenti

    public static boolean haveNotVowels(String s){
        int vowelCounter = 0;
        String sLow = s.toLowerCase();
        for(int i = 0; i < sLow.length() ; i++){
            if(sLow.charAt(i)==('a') || sLow.charAt(i) ==('e') || sLow.charAt(i)==('i') || sLow.charAt(i) ==('o') || sLow.charAt(i)==('u')){
                vowelCounter++;
            }
        }
        return vowelCounter == 0;
    }

    // 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti

    public static boolean isPalindrome(String s){
        boolean isPalindrome;
        for(int f = 0, r = s.length() - 1 ; f < r ; f++ , r--){
            if(Character.toLowerCase(s.charAt(f)) == Character.toLowerCase(s.charAt(r))){
                isPalindrome = true;
            } else{
                return false;
            }
        }
        return true;
    }
}