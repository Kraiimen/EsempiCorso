import java.io.Console;
public class FunctionsEx {
    public static int readInt (){
        Console console = System.console();
        return Integer.parseInt(console.readLine("Inserisci un numero: "));
    }
    public static String readString (){
        Console console = System.console();
        return console.readLine("Inserisci una frase: ");
    }
    public static int[] readIntArray (){
        Console console = System.console();
        int numbersLen = Integer.parseInt(console.readLine("Quanti numeri vuoi inseirire? "));
        int[] numbers = new int[numbersLen];
        
        for(int i=0;i<numbersLen;i++){
            numbers[i] = Integer.parseInt(console.readLine("Inserisci un numero: "));
        }
        return numbers;
    }
    public static String[] readStringArray (){
        Console console = System.console();
        int numbersLen = Integer.parseInt(console.readLine("Quante frasi vuoi inseirire? "));
        String[] sentences = new String[numbersLen];
        
        for(int i=0;i<numbersLen;i++){
            sentences[i] = console.readLine("Inserisci una frase: ");
        }
        return sentences;
    }
    public static boolean isIntArrayNull(int[] num){
        for (int i = 0; i < num.length; i++) {
            if(num[i]!=0){
                return false;
            }
        }
        return true;
    }
    public static boolean isStringArrayNull(String[] sentences){
        for (int i = 0; i < sentences.length; i++) {
            if(!sentences[i].equals("")){
                return false;
            }
        }
        return true;
    }
    public static boolean isStringNull(String sentence){
        if(!sentence.equals("")){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Console console = System.console();
        int es = Integer.parseInt(console.readLine("Che eserizzio vuoi attivare? "));
        switch (es) {
            case 1:
                // 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
                System.out.println("Eccoti l' ultimo carattere in maiuscolo"+getLastCharUpper(readString()));
                break;
            case 2:
                // 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
                System.out.println("la piu piccola delle tre frasi è: "+getShortestIn3(readString(),readString(),readString()));
                break;
            case 3:
                // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
                System.out.println("la stringa piu' lunga dell array è: "+getLongestInArray(readStringArray()));
                break;
            case 4:
                // 4) creare una funzione che scambia i valori di due numeri interi
                System.out.println("Questo esercizzio non richiede di fornire un Output, quindi ecco un piccolo disegno di un bambino che reagisce ad un altro bambino che si è fatto male (╯°□°）(╯︵ ┻)");
                break;
            case 5:
                // 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
                System.out.println("Il numero più grande è: " + getMaxInArray(readIntArray()));
                break;
            case 6:
                // 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
                System.out.println("La somma del array è: " + sumArray(readIntArray()));
                break;
            case 7:
                // 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti 
                if (doesItHaveVowels(readString())) {
                    System.out.println("Si, ci sono vocali");
                } else {
                    System.out.println("No, non ci sono vocali");
                }
                break;
            case 8:
                // 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti  
                if (isItPalindrome(readString())) {
                    System.out.println("Si, è palindromo");
                } else {
                    System.out.println("No, non è palindromo");
                }
                break;
        
            default:
                break;
        }
    }
    // 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
    public static char getLastCharUpper (String sentence){
        if(isStringNull(sentence)){
            System.err.println("inserisci un valore");
        }
        return Character.toUpperCase(sentence.charAt(sentence.length()-1));
    }
    // 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
    public static String getShortestIn3 (String sentence1,String sentence2,String sentence3){
        if(isStringNull(sentence1)){
            System.err.println("inserisci un valore");
        }
        if(isStringNull(sentence2)){
            System.err.println("inserisci un valore");
        }
        if(isStringNull(sentence3)){
            System.err.println("inserisci un valore");
        }
        if(sentence1.length()<sentence2.length() &&sentence1.length()<sentence3.length()){
            return sentence1;
        }else if(sentence2.length()<sentence3.length()){
            return sentence2;
        }else{
            return sentence3;
        }
    }
    // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
    public static String getLongestInArray (String[] sentences){
        if(isStringArrayNull(sentences)){
            System.err.println("inserisci un valore");
        }
        String maxLeng = "";
        for(int i =0; i<sentences.length;i++){
            if(maxLeng.length()<sentences[i].length()){
                maxLeng = sentences[i];
            }
        }
        return maxLeng;
    }
    // 4) creare una funzione che scambia i valori di due numeri interi
    public static void swapNums (int num1,int num2){
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
    // 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
    public static int getMaxInArray (int[] numbers){
        if(isIntArrayNull(numbers)){
            System.err.println("inserisci un valore");
        }
        int maxNum =0;
        if(numbers.length ==0){
            return 0;
        }
        for(int i =0; i<numbers.length;i++){
            if(maxNum<numbers[i]){
                maxNum = numbers[i];
            }
        }
        return maxNum;
    }
    // 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
    public static int sumArray (int[] numbers){
        if(isIntArrayNull(numbers)){
            System.err.println("inserisci un valore");
        }
        int sum =0;
        if(numbers.length ==0){
            return -1;
        }
        for(int i =0; i<numbers.length;i++){
            sum += numbers[i];
        }
        return sum;
    }
    // 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
    public static boolean doesItHaveVowels (String sentence){
        if(isStringNull(sentence)){
            System.err.println("inserisci un valore");
        }
        sentence = sentence.toLowerCase();
        for(int i =0; i<sentence.length();i++){
            char c = sentence.charAt(i);
            if(c== 'a'||c== 'e'||c== 'i'||c== 'o'||c== 'u'){
                return true;
            }
        }
        return false;
    }
    // 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti
    public static boolean isItPalindrome (String sentence){
        if(isStringNull(sentence)){
            System.err.println("inserisci un valore");
        }else
        sentence = sentence.toLowerCase();
        sentence = sentence.replace(" ", "");  // Removes all spaces

        for(int f =0, r = sentence.length()-1; f<r ;f++,r--){
            char charF = sentence.charAt(f);
            char charR = sentence.charAt(r);
            if(charF != charR){
                return false;
            }
        }
        return true;
    }
}
