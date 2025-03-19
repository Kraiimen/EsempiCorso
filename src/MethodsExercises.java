public class MethodsExercises {
// 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
    public static char upLastChar(String s){
        char lastChar = Character.toUpperCase(s.charAt(s.length()-1));
        return lastChar;
    }
// 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
    public static String lesslongString(String s1,String s2,String s3){
        String lower = s1.length()<s2.length() ? s1 : s2;
        return lower.length() < s3.length() ? lower : s3;
    }
// 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
    public static String longerOfArray(String[] arrayOfStrings){
        if(arrayOfStrings.length==0){
            return "";
        }
        String longer=arrayOfStrings[0];
        for(int i=0; i<arrayOfStrings.length-1; i++){
            if(arrayOfStrings[i].length()>longer.length()){
                longer = arrayOfStrings[i];
            }
        }
        return longer;
    }
// 4) creare una funzione che scambia i valori di due numeri interi
    public static void switchValue(int a, int b){
        int temp = a;
        a=b;
        b=temp;
        System.out.println(a+" "+b);
    }
// 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
    public static int maxValueArray(int[] array){
        if(positiveArray(array)){
            if(array.length==0){
                return 0;
            }
            int max=array[0];
            for(int i=0; i<array.length-1; i++){
                if(array[i]>max){
                    max=array[i];
                }
            }
            return max;
        }
        return -1;                                        //torna un valore negativo per indicare che l'array è negativo
    }


    public static boolean positiveArray(int[] array){
        for(int i=0; i<array.length; i++){
            if(array[i]<0){
                return false;
            }
        }
        return true;
    }
// 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
    public static int sumIntArray(int[] array){
        if(array.length==0){
            return -1;
        }
        int sum = array[0];
        for(int i=0; i<array.length; i++){
            sum+=array[i];
        }
        return sum;
    }
// 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
    public static boolean arrayVocals(String s){
        String stringLower = s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            if(stringLower.charAt(i) == 'a' || stringLower.charAt(i) == 'e' || stringLower.charAt(i) == 'i' || stringLower.charAt(i) == 'o' || stringLower.charAt(i) == 'u'){
                return true;
            }
        }
        return false;
    }
// 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti
    public static boolean palindrome(String s){
        for(int i=0, j=s.length()-1; i<j ; i++, j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //ultimo char maiuscolo
        System.out.println("ultimo carattere stringa in maiuscolo: "+ (upLastChar("Ciao")));


        String s1 = "Paperino";
        String s2 = "Paperino";
        String s3 = "Paperinooooo";
        String s4 = "Paperinooooo";
        String s5 = "anna";

        //stringa più piccola
        System.out.println("La stringa più piccola tra: "+s1+" "+s2+" "+s3+" è: "+lesslongString(s1, s2, s3));

        //stringa più lunga
        String[] arrayOfStrings = {s1,s2,s3,s4};
        System.out.println("La stringa più lunga dell'array è: "+longerOfArray(arrayOfStrings));

        //scambio valori
        switchValue(1, 0);

        //valore massimo d'interi positivi
        int[] arrayPositiveInt = {1,2,3,4,5,6,7,8,8,7};
        int maxPosArray = maxValueArray(arrayPositiveInt);
        if(maxPosArray == 0){
            System.out.println("L'array è vuoto");
        }else if(maxPosArray==-1){
            System.out.println("L'array è negativo");
        }else{ 
            System.out.println("Nell'array di positivi, il valore massimo è: "+maxPosArray);
        }


        //somma dei valori int nell'array
        int sumInt = sumIntArray(arrayPositiveInt);
        if(sumInt==-1){
            System.out.println("l'array è vuoto");
        }else{
            System.out.println("la somma dei valori interi è: "+sumInt);
        }

        //presenza di vocali nell'array
        if(arrayVocals(s1)){
            System.out.println("la stringa "+s1+" contiene le vocali");
        }else{
            System.out.println("la stringa "+s1+" non contiene le vocali");
        }
        
        //stringa palindroma
        if(palindrome(s5)){
            System.out.println("la stringa "+s5+ " è palindroma!");
        }else{
            System.out.println("la stringa "+s5+ " non è palindroma!");
        }
    }
}
    

