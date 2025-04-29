
public class Methods2 {
    public static void main(String[] args) {

        System.out.println("L'ultimo carattere in maiuscolo è " + lastChar("Ciao Stronzi")+ ""); //1) Esrecizio

        String shorter = getShortStringer("giovannisecondo" , "giovanni","giovanniterzo"); //2)  Esercizio
        System.out.println("La stringa piu corta è " + shorter);
     

        String[] str ={"", ",","zione", "ciaone", "Cavolo sono la piu lunga"};  // 3) Esercizio
        System.out.println("La stringa piu lunga è " + longerString(str));


        swapNumbers(10 , 5); // 4) esercizio

        int [] massimo = {1,2,3,4,5,6,7};//6 esercizio
        System.out.println("il numero massimo di questo array è " + findMax(massimo));



        int [] somma = {1,2,3,4,5,6,7}; //6 esercizio
        System.out.println("il numero massimo di questo array è " + arraySum(somma));

        String vocali = "zzzql"; // 7 esercizio
        boolean risultato = controlloVocali(vocali);
        System.out.println("Nella stringa non ci sono vocali?   " + risultato);


        String palindromo = "jhon";
        boolean risultato2 =  Methods2.isPalindrome(palindromo);
        System.out.println("La stringa è palindroma : " + risultato2);

        int numero = 3;
        System.out.println("Il numero è pari   " + isPari(numero));

        String nome = "Stefano";
        System.out.println("Ciao mi chiamo  " + saluta(nome));

        int calcolo = calcolaAreaRettangolo(53, 31);
        System.out.println("Il calcolo del rettangolo  " + (calcolo));

        int maggiore = trovaMaggiore(10, 4, 8);
        System.out.println("Il numero maggiore è  " + (maggiore));

        String inverita = invertiStringa("Stefano");
        System.out.println("La stringa" +  inverita);

       int numeros = calcolaFattoriale(6);
       System.out.println("Il fattoriale   " +  numeros);

       String nome1 = "Stefano";
       String nomeInvertito = invertiStringa(nome);
       System.out.println("Nome invertito: " + nomeInvertito);


       int[] numeriPari = {1,3,6,8,10,12};
       System.out.println("i numeri pari sono " + contaNumeriPari(numeriPari));


    }    

    // 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo

    public static char lastChar(String str){

        String upper = str.toUpperCase(); // Dichiara una varabile di tipo String col nome upper che contiene str in maiuscolo
        char last = upper.charAt(str.length()-1); // Dichiara una variabile di tipo char col nome last che contiene l 'ultimo caratterer di str'
        return last;
    } 

    // 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre  Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
   
    public static String getShortStringer(String s1,String s2,String s3){
        String minStr = s1; // Inizialmente supponiamo che la prima stringa sia la più piccola

        
        if (s2.length() < minStr.length()) {// Confronto la lunghezza di s2 con la stringa minore corrente
            minStr = s2;
        }
        if (s3.length() < minStr.length()) {// Confronto la lunghezza di s3 con la stringa minore corrente
            minStr = s3;
        }
        return minStr;// Ritorna una delle stringhe più piccole
    }


   // 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe. 
    
   public static String longerString(String[] array){
        if(array.length == 0){
            return "";
        } 
        String stringaPiuLunga = array[0]; // Dichiaro la varaibile string con la prima stringa piu lunga
        
        for (int i = 1; i < array.length; i++) {
            if (array[i].length() > stringaPiuLunga.length()) {
                stringaPiuLunga = array[i]; // Aggiorna la stringa più lunga se troviamo una stringa più lunga
            }
        }

        return stringaPiuLunga;
    }



   // 4) creare una funzione che scambia i valori di due numeri interi
    public static void swapNumbers(int a , int b){
        int temp = a;
        a = b;
        b = temp;

        System.out.println("Dopo lo scambio: a = " + a + ", b = " + b);
    }

   //  5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
    
   public static int findMax(int[] numeri){

       int max = numeri[0]; //

        for (int i = 0; i < numeri.length; i++){
         if(numeri[i]> max){
            max = numeri[i];
          }
       }    return max; 
    }

   // 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
     
   public static int arraySum (int[] numeri1){
      if (numeri1.length == 0) {
        return -1; // Restituisce -1 se l'array è vuoto
      }
    
      int somma = 0; // Variabile per memorizzare la somma
    
      // Itera su tutti gli elementi dell'array
      for (int i = 0; i < numeri1.length; i++) {
        somma += numeri1[i]; // Aggiunge ogni elemento alla somma
      }
    
       return somma;
    }

    // 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
    
     public static boolean controlloVocali(String str){
        str = str.toUpperCase();

        for(int i = 0; i < str.length(); i++){
            char currentchar = str.charAt(i);
            if( currentchar == 'A' || currentchar == 'E' || currentchar == 'I' ||currentchar == 'O' || currentchar == 'U'){
                return false;
            }
        } 
        
        return true;
    
    }
    // 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti 

    public static boolean isPalindrome(String str){
         str = str.toLowerCase();
        for(int start= 0 , end = str.length()-1 ; start < end; start++ , end--){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }    
        } 
        return true;
    } 

    public static boolean isPari(int numero) {
        // Un numero è pari se il resto della divisione per 2 è 0
        return numero % 2 == 0;
    }
    

    public static String saluta(String nome){
    
        return nome;
    }
    

    public static int calcolaAreaRettangolo(int base, int altezza) {
        return base * altezza;
    }


    public static int trovaMaggiore(int a, int b, int c) {
        int maggiore = a; // Inizialmente assumiamo che 'a' sia il maggiore
    
        // Verifichiamo se 'b' è maggiore di 'maggiore'
        if (b > maggiore) {
            maggiore = b;
        }
        
        // Verifichiamo se 'c' è maggiore di 'maggiore'
        if (c > maggiore) {
            maggiore = c;
        }
        
        // Restituiamo il numero più grande
        return maggiore;
    }



    //Funzione per invertire il nome

    public static String invertiStringa(String str) {
        String temp = "";
        // Ciclo per invertire la stringa
        for (int i = str.length() - 1; i >= 0; i--) {
            temp += str.charAt(i); // Aggiunge ogni carattere dall'ultimo al primo
        }
        return temp;
    }




    public static int calcolaFattoriale(int numero) {
        int fattoriale = 1; // Il fattoriale di 0 o 1 è 1
        for (int i = 2; i <= numero; i++) {
            fattoriale *= i; // Moltiplica il valore corrente del fattoriale per i
        }
        return fattoriale; // Restituisce il fattoriale calcolato
    }

    public static int contaNumeriPari(int[] numeri) {
        int counter= 0;
        for(int i = 0; i < numeri.length; i++){
            if(numeri[i] % 2 == 0){
                counter++;
            }
        } return counter;
    }


}       



      
    




