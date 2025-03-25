public class RipassoPersonale {
    static int global = 100; // inizializzato una variabile statica intera global, visibile in tutte le funzioni di questa classe
    public static void main(String[] args){
        int x = 10;
        f1(x); // invoco la funzione assieme all'argomento della funzione
        int g = 22;
        System.out.println("All'interno di main: " + x); // stampa 10 non varia il valore di x
        System.out.println(global); // stampa 101
        int[] numeri = {1 , 2 , 3}; 
        System.out.println(numeri[0]); // stamperà 1
        f2(numeri);
        System.out.println(numeri[0]); // stamperà 100, perchè abbiamo modificato il valore della cella, non l'indirizzo
        Integer i1 = 10; // boxing, il compilatore crea un oggetto di tipo integer e ci inserisce la primativa
        Integer i2 = 20;//Integer.valueOf(i : 20); // fa la stessa cosa della linea sopra
        swap(i1 , i2);
        System.out.println(i1); // stampa 10, gli oggetti non si possono cambiare gli indirizzi
        System.out.println (numeri[1] + numeri[2]);
        String s1 = "pippo";
        String s2 = "pluto";
        swapStrings(s1 , s2);
        System.out.println(s1);
    }

    public static void f1(int z){ // nuova funzione, ha x come parametro, z è una copia di x
        z += 3; // incremento x di 3 è la stessa cosa di scrivere x = x + 3
        System.out.println("All'interno di f1: " + z); // stampa per prima essendo evocata nella main, stampa 13
        System.out.println(global); // stampa per prima, valore 100
        global++; // incrementa di 1 il valore di global
    }
    public static void f2(int[] ns){ // è una copia ma non dell'array, è dell'indirizzo dell'array
        ns[0] = 100; // modifichiamo il valore della prima cella assegnandogli un nuovo valore 100
        ns = new int[]{1000 , 2000, 3000, 4000}; // cambiamo l'indirizzo 
        ns[0] = 200;
    }
    public static void swap(Integer z1 , Integer z2){ // sono copie di indirizzi
    // gli integer non sono modificabili
        //z1.intValue(100);
        Integer temp = z1; // si sono scambiati gli indirizzi
        z1 = z2;
        z2 = temp;
        // stiamo cambiano le copie, non gli indirizzi originali 
    }
    public static void trySwap(int[] ns1 , int[] ns2){
        int temp = 0;
        ns1 = ns2;
        ns1[0] = temp;
    }
    public static void swapStrings(String s1, String s2){
        // non è possibile fare questo. s1[0] = "x"; stamperebbe xippo perchè indica il primo carattere
        // le stringhe non sono modificabili
        String temp = s2;
        s1 = s2;
        s2 = temp;
    }
}