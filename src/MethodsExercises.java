public class MethodsExercises {
    public static void main(String[] args) {
        // Esercizio 1
        System.out.println("\nL'ultimo carattere in maiuscolo della stringa è '"+ lastChar("Ciao")+"'");

        // Esercizio 2
        String str1 = "Ciao";
        String str2 = "Mela";
        String str3 = "Buonasera";

        System.out.println("\nLa stringa più piccola tra le tre è: \"" + getShorterString(str1, str2, str3)+"\"");  

        // Esercizio 3
        String strings[] = {"Arrivederci", "Mela", "Ciao"};
        System.out.println("\nLa stringa più lunga nell'array è: \""+getLongerString(strings)+"\"");

        // Esercizio 4
        swapNumbers(2, 3);

        // Esercizio 5
        int positiveNumbers[] = {1,3,4,5,2,1};
        System.out.println("\nIl numero più grande nell'array di interi positivi è: "+getPositiveMaxValue(positiveNumbers));

        // Esercizio 6
        int intNumbers[] = {1,1,1,1,1};
        System.out.println("\nLa somma dei numeri interi dell'array è: "+sumArray(intNumbers));

        // Esercizio 7
        String vowelsStr = "AbCd";
        System.out.println("\nLa stringa non contiene vocali: "+checkVowels(vowelsStr));

        // Esercizio 8
        System.out.println("\nLa stringa è palindroma? "+isPalindrome("Anna"));

    }

    // 1) Creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo

        public static char lastChar(String str){
            // String upper = str.toUpperCase(); // Dichiara una variabile di tipo String col nome upper che contiente str in minuscolo
            // char last = upper.charAt(upper.length() - 1); // Dichiara una variabile di tipo char col nome last che contiene l'ultimo carattere di str

            // return last; // Ritorna l'ultimo carattere

            return Character.toUpperCase(str.charAt(str.length() - 1)); // Versione compatta
        }

    // 2) Creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. 
    //    Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole

        public static String getShorterString(String str1, String str2, String str3){
            // Se la stringa str1 è la più piccola
            if(str1.length() <= str2.length() && str1.length() <= str3.length()) {
                return str1;
            } 
            // Se la stringa str2 è la più piccola
            else if (str2.length() < str1.length() && str2.length() < str3.length()){
                return str2;
            } 
            // Se la stringa str3 è la più piccola
            else{
                return str3;
            }
        }
    
    // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. 
    //    Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.

        public static String getLongerString(String arr[]){
            // Se l'array è vuoto ritorniamo una stringa vuota
            if(arr.length == 0){
                return "";
            }

            // Altrimenti vediamo qual è la stringa più lunga
            String longerStr = arr[0];

            for (int i = 0; i < arr.length; i++) {
                if(arr[i].length() > longerStr.length()){
                    longerStr = arr[i];
                }
            }

            return longerStr;
        }

    // 4) Creare una funzione che scambia i valori di due numeri interi

        // Il metodo scambia i valori delle COPIE degli argomenti che passiamo
        public static void swapNumbers(int a, int b){
            int temp = a;
            a = b;
            b = temp;
        }

    // 5) Creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. 
    //    Se l array e' vuoto restituisce 0

        public static int getPositiveMaxValue(int arr[]){
            // Se l'array è vuoto ritorniamo 0
            if(arr.length == 0){
                return 0;
            }

            // Altrimenti calciamo il numero max
            int max = arr[0];

            // Se l'array ha un numero non positivo ritorna 0
            for (int i : arr) {
                if(i <= 0){
                    return 0;
                }
            }
            
            // Controlliamo il max
            for (int i : arr) {
                if(i > max){
                    max = i;
                }
            }

            return max;
        }

    // 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. 
    //    Se l array e' vuoto mi restituisce -1

        public static int sumArray(int arr[]){
            if (arr.length == 0) {
                return -1;
            }

            int sum = 0;
            for (int i : arr) {
                sum += i;
            }

            return sum;
        }

    // 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana
    //    true se la stringa non contiene vocali, false altrimenti

        public static boolean checkVowels(String str){
            boolean hasNotVowels = true;

            for (int i = 0; i < str.length() - 1; i++) {
                String lowerStr = str.toLowerCase(); // Per una migliore leggibilità uso una variabile per contenere la stringa tutta minuscola

                // Se è uguale ad una delle vocali settiamo hasNotVowels su false
                if(lowerStr.charAt(i) == 'a' || lowerStr.charAt(i) == 'e' || lowerStr.charAt(i) == 'i' 
                   || lowerStr.charAt(i) == 'o' || lowerStr.charAt(i) == 'u'){

                    hasNotVowels = false;
                    break;
                }
            }

            return hasNotVowels;
        }
        
    // 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana 
    //    true se la stringa e' palindroma, false altrimenti

        public static boolean isPalindrome(String str){
            // Se la stringa è vuota ritorniamo false
            if(str.equals("")){
                return false;
            }

            // Altrimenti controlliamo se è palindroma
            str = str.toLowerCase(); // Per evitare problemi durante il controllo uso la stringa in minuscolo

            // Se troviamo una lettera diversa, non è palindroma, quindi usciamo direttamente dal ciclo
            for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }
            }

            return true;
        }
    
}
