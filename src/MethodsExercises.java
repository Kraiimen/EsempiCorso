// 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
// 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
// 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
// 4) creare una funzione che scambia i valori di due numeri interi
// 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
// 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
// 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
// 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti
public class MethodsExercises{
    public static void main(String [] args){
        //1
        char firstExercises = getLastUpperCase("Cane"); 
        System.out.println(firstExercises);
        //2
        String shortestString = getShorterString("cane", "cerbiatto", "stringa");
        System.out.println(shortestString);
        //3
        String [] groupOfString = {"cavallo", "elicottero", "lunghissimoooo"};
        String longerString2 = getLongerStringFromArray(groupOfString);
        System.out.println(longerString2);
        //4 è impossibile scambiare due numeri int tramite metodo 
        int x = 5;
        int y = 6;
        //quando invoco il metodo, la funzione crea una variabile sua per ogni argomento passato che copiera il valore dell'argomento.
        swapNumbers(x,y); //x e y sono gli argomenti delle funzioni, gli argomenti e i parametri non sono la stessa cosa, non sono la stessa variabile
        System.out.println("x: " + x + " y: " + y); //x e y non si scambiano, dentro al metodo usiamo delle copie dei valori di x e y, non le vere variabili x e y

        //5
        int [] vuoto = {};
        int [] numbers = {1,5,8,3,4};
        int max = getMaxFromArray(vuoto);
        System.out.println(max);
        max = getMaxFromArray(numbers);
        System.out.println(max);
        //6
        int sum = getSumFromArray(vuoto);
        System.out.println(sum);
        sum = getSumFromArray(numbers);
        System.out.println(sum);
        //7
        String name = "Fabio";
        boolean hasNoVowel = isNoVowelString(name);
        System.out.println(hasNoVowel);
        //8
        String palindrome = "alula";
        System.out.println(isPalindrome(palindrome));
        

    }




// 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
    public static char getLastUpperCase(String text){
        int posLastChar = text.length() - 1;
        return Character.toUpperCase(text.charAt(posLastChar));
    }
// 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
    public static String getShorterString(String s1, String s2, String s3){
        if (s1.length() < s2.length()){
            if(s1.length() < s3.length()){
                return s1;
            } else{
                return s3;
            }
        } else{
            if(s2.length() < s3.length()){
                return s2;
            } else{
                return s3;
            }
        }
    }
    // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
    public static String getLongerStringFromArray(String[] arrayOfString){
        String longerString = arrayOfString[0];
        for (int i =1; i < arrayOfString.length; i++){
            if(longerString.length() < arrayOfString[i].length()){
                longerString = arrayOfString[i];
            }
        }
        return longerString;
    }
    // 4) creare una funzione che scambia i valori di due numeri interi
    public static void swapNumbers(int a, int b){ //a e b parametri della funzione
        int temp = a;
        a = b;
        b = temp;
        // int [] swapArray = {a,b};
        // return swapArray;

    }
    // 5)creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
    public static int getMaxFromArray(int[] arrNum){
            int maxNum = 0;
            for(int i = 0; i < arrNum.length ; i++){
                if(maxNum < arrNum[i]){
                    maxNum = arrNum[i];
                }
            }
            return maxNum;
            
    }
    // 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
    public static int getSumFromArray(int [] arrNum){
        if(arrNum.length == 0){
            return -1;
        }
        int sum = 0;
        for( int i = 0; i < arrNum.length; i++){
            sum += arrNum[i];
        }
        return sum;
    }
    // 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
    public static boolean isNoVowelString(String sentence){
        char [] vowels = {'a','A','e','E','i', 'I', 'o', 'O', 'u', 'U'};
        
        for (int i = 0; i < sentence.length(); i++){
            for(int y = 0; y < vowels.length; y++)
                if(sentence.charAt(i) == vowels[y]){
                    //System.out.println("dance");
                    return false;
                }
        }
        return true;
    }
    // 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti
    // es otto
    public static boolean isPalindrome(String input){
        for(int i = 0, s = input.length() - 1; i < s ; i++, s--){
            if(input.charAt(i) != input.charAt(s)){
                return false;
            }
        }
        return true;
    }
}