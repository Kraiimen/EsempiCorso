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
    public static void main(String[] args) {
        Console console = System.console();
        int es = Integer.parseInt(console.readLine("Che eserizzio vuoi attivare? "));
        switch (es) {
            case 1:
                System.out.println("Eccoti l' ultimo carattere in maiuscolo"+lastCharUpper(readString()));
                break;
            case 2:
                System.out.println("la piu piccola delle tre frasi è: "+shortest3(readString(),readString(),readString()));
                break;
            case 3:
                System.out.println("la stringa piu' lunga dell array è: "+shortest3(readStringArray()));
                break;
            case 4:
                System.out.println("Questo esercizzio è anchora in costruzzione");
                break;
            case 5:
                System.out.println("Il numero più grande è: " + maxInArray(readIntArray()));
                break;
            case 6:
                System.out.println("La somma del array è: " + sumArray(readIntArray()));
                break;
            case 7:
                if (doesItHaveVowels(readString())) {
                    System.out.println("Si, ci sono vocali");
                } else {
                    System.out.println("No, non ci sono vocali");
                }
                break;
            case 8:
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
    public static char lastCharUpper (String sentence){
        return Character.toUpperCase(sentence.charAt(sentence.length()-1));
    }
    // 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
    public static String shortest3 (String sentence1,String sentence2,String sentence3){
        if(sentence1.length()<sentence2.length() &&sentence1.length()<sentence3.length()){
            return sentence1;
        }else if(sentence2.length()<sentence3.length()){
            return sentence2;
        }else{
            return sentence3;
        }
    }
    // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
    public static String shortest3 (String[] sentences){
        String maxLeng = "";
        for(int i =0; i<sentences.length;i++){
            if(maxLeng.length()<sentences[i].length()){
                maxLeng = sentences[i];
            }
        }
        return maxLeng;
    }
    // 4) creare una funzione che scambia i valori di due numeri interi

    // 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
    public static int maxInArray (int[] numbers){
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
        for(int i =0; i<sentence.length();i++){
            char c = sentence.charAt(i);
            if(c== 'a' ||c== 'A'||c== 'e' ||c== 'E'||c== 'i' ||c== 'I'||c== 'o' ||c== 'O'||c== 'u' ||c== 'U'){
                return false;
            }
        }
        return true;
    }
    // 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti
    public static boolean isItPalindrome (String sentence){
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
