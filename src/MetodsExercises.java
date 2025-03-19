public class MetodsExercises{
    public static void main(String[] args){
        System.out.println(getLowerLastChar("ossA") + "\n");

        System.out.println(getShortestOfThreeStrings("fame", "io", "molta") + "\n");
        
        System.out.println(getLongestString(new String[]{"fame", "io", "molta", "ciao"}) + "\n");

        //non scambia x e y
        Integer x = 5;
        Integer y = 10;
        fakeSwitchTwoNums(x, y);
        //System.out.println(x + "\n" + y + "\n");
        
        System.out.println(getMaxInt(new int[]{5, 7, 3, 2, 9, 6}) + "\n");

        System.out.println(sumInts(new int[]{5, 7, 3, 2, 9, 6}) + "\n");
        
        System.out.println(notHasVocals("crsmtp") + "\n");

        System.out.println(isPalindrome("oSsO") + "\n");
    }
    // 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
    public static char getLowerLastChar(String s){
        if(s == null){
            //throw exception
        }
        return Character.toLowerCase(s.charAt(s.length()-1));     //Se s è null fallisce
    }
    /*
    ----------------VERSIONE ALTERNATIVA (più facile ma meno performante)--------------------
    public static char lowerLastChar(String s){
        return s.toLowerCase().charAt(s.length());
    }
    //*/
        
    // 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
    /*
    ----------------VERSIONE ALTERNATIVA di ShortestOfThreeStrings (più complicata da scrivere, ma è esattamente la stessa cosa)--------------------
    public static String ShortestOfThreeStrings(String s1, String s2, String s3){
        return ShortestString(s1, sShortestString(s2, s3));
    }
    //*/
    public static String getShortestOfThreeStrings(String s1, String s2, String s3){
        String result = getShortestString(s1, s2);
        result = getShortestString(result, s3);
        return result;
    }
    public static String getShortestString(String s1, String s2){
        if(s1 == null || s2 == null){
            //throw exception
        }
        return s1.length() < s2.length() ? s1 : s2;
    }
    /*
    ----------------VERSIONE ALTERNATIVA di ShortestString (più semplice da scrivere, ma è esattamente la stessa cosa)--------------------
    public static String ShortestString(String s1, String s2){
        if(s1.length() < s2..length()){
            return s1;
        }
        return s2;
    }
    //*/
    /*
    ----------------VERSIONE ALTERNATIVA con un solo metodo (più semplice da scrivere)--------------------
    public static String ShortestOfThreeStrings(String s1, String s2, String s3){
        String result = s1;
        if(result.length() > s2.length()){
            result = s2;
        }
        if(result.length() > s3.length()){
            result = s3;
        }
        return result;
    }
    //*/
    
    // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
    //Guardare l'esercizio 2 per altri modi di farlo, visto che è praticamente uguale
    public static String getLongestString(String[] array){
        if(array == null || array.length == 0){
            //throw exception
        }

        String result = array[0];   //fallisce se l'array è null
        for(int i = 1; i < array.length; ++i){
            if(result.length() < array[i].length()){
                result = array[i];
            }
        }
        return result;
    }
    
    // 4) creare una funzione che scambia i valori di due numeri interi
    //non funziona perchè passa una copia dell'oggetto, e non l'oggetto stesso (no aliasing con i metodi in java) (tanto peggio se uso int invece di Integer)
    public static void fakeSwitchTwoNums(Integer x, Integer y){
        // if(x == null || y == null){
        //     //throw exception
        // }
        Integer n = x;
        x = y;
        y = n;
    }

    //tecnicamente non fa ciò che è stato richiesto, ma almeno restituisce i valori cambiati
    /*
    public static int[] switchTwoNums(int x, int y){
        return new int[] {y, x};
    }
    //*/

    // 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
    public static int getMaxInt(int[] array){
        if(array == null){
            //throw exception
        }
        int max = 0;
        for(int i = 0; i < array.length; ++i){
            if(max < array[i]){
                max = array[i];
            }
        }
        return max;
    }

    // 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
    public static int sumInts(int[] array){
        if(array == null){
            //throw exception
        }
        if(array.length == 0){
            return -1;
        }
        int sum = 0;
        for(int i = 0; i < array.length; ++i){
            sum += array[i];
        }
        return sum;
    }

    // 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
    public static boolean notHasVocals(String s){
        if(s == null){
            return true;
        }
        for(int i = 0; i < s.length(); ++i){
            char currentLetter = Character.toUpperCase(s.charAt(i)); //not case sensitive
            if(currentLetter == 'A' || currentLetter == 'E' || currentLetter == 'I' || currentLetter == 'O' || currentLetter == 'U'){
                return false;
            }
        }
        return true;
    }

    // 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti
    public static boolean isPalindrome(String s){
        if(s == null){
            //throw exception
        }
        for(int i = 0; i < s.length()/2; ++i){
            char currentLetter = Character.toUpperCase(s.charAt(i));
            char oppositeLetter = Character.toUpperCase(s.charAt(s.length()-i-1));
            if(currentLetter != oppositeLetter){    //not case sensitive
                return false;
            }
        }
        return true;
    }
    
}