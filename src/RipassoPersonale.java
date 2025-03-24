public class RipassoPersonale { 
    
    static int global = 100;  //variabile statica che si chiama global di tipo intero.
    
    public static void main(String[] args) {

        int x = 11;
        f1 (x); 
        int p = 22;
        //f1(p);
        //f1(35);
        System.out.println("All'interno di main: " + x);
        System.out.println(global);
        int[] numbers = {1, 2, 3}; //sia dichiarazione che inizializzazione; dichiarazione a sinistra e inizializzazione a destra. Inoltre, dentro alla variabile numbers non c'è l'array; in linea generale questo vale per ogni oggetto; c'è l'inidirizzo di memoria che mi porta all'array 1, 2, 3. L'inidirizzo sarà di 32 o 64 bit, a seconda della VM che stai usando.
        int[] numbers2 = {4, 5, 6};
        System.out.println(numbers[0]);
        f2 (numbers);
        Integer i1 = 10; //boxing (avviene automaticamente); (crea un oggetto (una primitiva) di tipo Integere e ci ficca dentro 10).
        Integer i2 = Integer.valueOf(20);
        swap(i1, i2);
        System.out.println(i1);
        String s1 = "Pippo";
        String s2 = "Pluto";
        swapStrings(s1, s2);
        System.out.println(s1);
    }

    public static void f1(int z) {  //z clone di x
        z += 3;
        //x += 3; //x = x + 3;  stessa roba
        System.out.println("All'interno di f1: " + z);
        System.out.println(global);
        global++;
    }
    
    public static void f2(int[] ns) {
        ns[0] = 100;  //ho mmodificato il valore della cella 0 dandole il valore 100. Ho modificato la copia dell'indirizzo dell'array.
        //ns = new int[](1000, 2000, 3000, 4000); //adesso sto cambiando la copia dell'inidirizzo.
        //ns[0] = 200; //ns è una copia dell'indirizzo.
    }

    public static void swap(Integer z1, Integer z2) {
        //z1.setValue(100); //gli oggetti di classe integer, come le stringhe, sono immutabili.
        Integer temp = z1;
        z1 = z2;  //z1 e z2 non sono numeri interi, sono copie degli indirizzi, sono copie di i1 e i2.
        z2 = temp;
    }
    
    public static void trySwap(int[] ns1, int[] ns2) {
        ns1 = ns2;
        ns1[0] = 100;

    }

    public static void swapStrings(String s1, String s2) {
        //Non è possibile fare questo: s1[0] = 'x'; le stringhe non sono modificabili come gli integer.
        String temp = s1;
        s1 = s2;
        s2 = temp;
        System.out.println(s1);
    }

}