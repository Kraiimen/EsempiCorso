public class MethodsExs {

    public static void main(String[] args) {
        // char last = getLastCharacter("Hello you");
        // System.out.println(last);

        // System.out.println(getShortestString("hey you", "hey everyone", "bye bye"));

        // String[] test = new String[] { "hey you", "hey everyone", "bye bye" };
        // System.out.println(getLongestStringFromArray(test));

        // int[] numberz = new int[] { 1, 13, 56, 24, 8, 13 };
        // System.out.println(getMaxValue(numberz));
        // System.out.println(getSum(numberz));

        String stringCheck = "hi";
        System.out.println(containsVowels(stringCheck));
        
        IntObj a = new IntObj(3);
        IntObj b = new IntObj(4);
        swapNumbers(a, b);
        System.out.println(a + " " + b);

    }

    // 1. creare una funzione che prende in input una stringa e mi ritorna il suo
    // ultimo carattere in maiuscolo

    public static char getLastCharacter(String sentence) {
        char lastChar = sentence.charAt(sentence.length() - 1);
        lastChar = Character.toUpperCase(lastChar);
        return lastChar;
    }

    // 2. creare una funzione che prende in input tre stringhe e mi ritorna la piu
    // piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne
    // ritorna una qualsiasi delle piu' piccole
    public static String getShortestString(String s1, String s2, String s3) {
        String result = "";
        if (s1.length() <= s2.length() && s1.length() <= s3.length()) {
            return result = s1;
        } else if (s2.length() <= s1.length() && s2.length() <= s3.length()) {
            return result = s2;
        } else {
            return result = s3;
        }
    }

    // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna
    // la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una
    // qualsiasi delle piu' lunghe

    public static String getLongestStringFromArray(String[] strings) {
        if (strings.length == 0) {
            return "";
        }
        String longestString = strings[0];
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > longestString.length()) {
                longestString = strings[i];
            }
        }
        return longestString;
    }

    // 4) creare una funzione che scambia i valori di due numeri interi
    public static void swapNumbers(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a equals " + a + ", b equals " + b);
    }

    // 4.1) creare una funzione che scambia i valori di due numeri interi stavolta
    // per davvero (by Luna)
    public static void swapNumbers(IntObj a, IntObj b) {
        int tmp = a.value;
        a.value = b.value;
        b.value = tmp;
    }

    // 5) creare una funzione che riceve in input un array di numeri interi positivi
    // e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0

    public static int getMaxValue(int[] numbers) {
        int maxValue = numbers[0];
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        for (int number : numbers) {
            if (number > maxValue) {
                maxValue = number;
            }
        }
        return maxValue;
    }
    // 6) creare una funzione che riceve in input un array di numeri interi e mi
    // restituisce la loro somma. Se l array e' vuoto mi restituisce -1

    public static int getSum(int[] numbers) {
        int sum = 0;
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
    // 7) creare una funzione che riceve in input una stringa e mi restituisce una
    // booleana true se la stringa contiene vocali, false altrimenti

    public static boolean containsVowels(String s) {
        char[] vowels = new char[] { 'a', 'o', 'u', 'i', 'e' };
        for (int i = 0; i < s.length(); i++) {
            for (char vowel : vowels) {
                if (s.charAt(i) == vowel) {
                    return true;
                }
            }
        }
        return false;
    }

    // 8) creare una funzione che riceve in input una stringa e mi restituisce una
    // booleana true se la stringa e' palindroma, false altrimenti

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}