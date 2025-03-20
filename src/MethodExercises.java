//1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
//2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
//3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
//4) creare una funzione che scambia i valori di due numeri interi
//5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
//6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
//7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
//8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti   

public class MethodExercises{
    public static void main(String[] args){

     //es1
    char last = printInTitleCase("cane");
    System.out.println(last);

    //es2 
    System.out.println(getsmallsString("gatti", "leopardo" , "gatto"));        
    //es3
    String[] str = {"",",","zione","ciaone","cavolo sono la piu lunga"};
    System.out.println("la stringa piu lunga " + longerStringer(str)); 
    //es4
    int x1 = 5;
    int x2 = 6;
    swapNumbers(x1, x2);
    System.out.println("x ha il valore " + x1 + " mentre y ha il valore " + x2);
    //es5
    int[] random = { 1, 6, 3, 8, 0};
    int maxNumber = maxNum(random);
    System.out.println("il numero piu grande dell array e: " + maxNumber);
    //es6
    int[] arraySum = {1, 5, 8, 4, 6};
    System.out.println("la somma del array e: " + sumArray(arraySum));
    //es7
    System.out.println("il booelano e: " + searchVowels("gatto"));

    //es8
    System.out.println("il booelano e: " + reverse("anna"));

        
    }
    public static char printInTitleCase (String name){

        name.length();
        char last = name.charAt(3);
        char lastUpper = Character.toUpperCase(last);
       
        return lastUpper;
        }
    

   //2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole 
   public static String getsmallsString(String s1 ,String s2, String s3){
    String small = "";

    if(s1.length() <= s2.length() && s1.length()<= s3.length()){
        small = s1;

    }
    else if(s2.length() <= s1.length() && s2.length() <= s3.length()){
        small = s2;
    } 
    else{

        small = s3;
    }
     return small;
    }

     
    //3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
    public static String longerStringer(String[] array){
        if(array.length == 0){
            return"";
        }
        String stringaPiuLunga = array [0]; // Dichiaro la variabile string con la prima stringa
        
        for(int i = 1; i < array.length; i++){
            if(array[i].length () > stringaPiuLunga.length()){
                stringaPiuLunga = array[i]; //Aggiorna la stringa piu lunga 
            }
        }
        return stringaPiuLunga;
    }


    //4) creare una funzione che scambia i valori di due numeri interi
    public static void swapNumbers (int a , int b){
        


        int temp = a;
        a = b;
        b = temp;
        // return x +"" + y;
    }   
        
    //5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.

    public static int maxNum(int[] array){
        int max = 0;
        
        if(array.length > 0){
            for(int i = 0; i <array.length ; i++){
                if(array[i] > max ){
                    max = array[i];
                }
            } 
        } 
            return max;
    }

    //6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1

    public static int sumArray(int[] array){
        int max = 0;
        
        if(array.length > 0){
            for(int i = 0; i <array.length ; i++){
                max = max + array[i];
            } 
        } else{ 
            max = -1;
        }
            return max;
    }
    //7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti

    public static boolean searchVowels(String word ){
        
        boolean verify  = false;
        for(int i = 0; i <word.length() ; i++){
                if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u'){
                    verify = true;
                }
            } 
        return verify;    
    }
    //8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti   

    public static boolean reverse (String word ){

        boolean check = false;
        String letters= ""; 
       
        for(int i = word.length()-1; i >= 0 ; i--){
            letters = letters + word.charAt(i); 
                if(word.equals(letters)){
                    check = true;
            }
        }
        return check;
    }
}

 

