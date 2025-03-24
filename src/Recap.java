public class Recap {

    public static void main(String[] args) {
        // Primitivi --> byte, short, int, long, boolean, float, double, char
        // Non importa dal sistema operativo o altri fattori, in ordine la dimensione è: 
        // 1 byte, 2 byte, 4 byte, 8 byte, 1 bit, 4 byte, 8 byte, 2 byte
        // 1 byte = 8 bit
        // (Dipende dall'implementazione della VM (Virtual Machine))  

        // Referenziali --> String

        /* VARIABILI */
        int number; // Dichiarazione
        number = 5; // Assegnazione di un nuovo valore

        int number2 = 2; // Dichiarazione e inizializzazione --> ovvero la creo e gli do un valore iniziale
        double numberDouble = 2.0;
        float numberFloat = 2.0f;
        char c = 'a';
        boolean isTrue = true;
        
        String str = "adhuh";
        String str2 = str;

        String strUpper = str.toUpperCase();
        /* -------- */

        /* COSTANTI */
        final int NUMBER_3 = 3;
        // number3 = 5; NON SI PUO' FARE
        /* -------- */

        // method1(); // Invocazione del metodo

        // String returnStr = returnString();
        // System.out.println(returnStr);

        // int a = 5;
        // int b = 6;

        // int sum = sum(a, b);
        // System.out.println("Somma: "+sum);

        /* CAST ESPLICITO */
        double d = 4.0;
        float f = (float) d;
        int i = (int) d;

        /* CAST IMPLICITO */
        short s = 2;
        int i2 = s;


        int[] arr = new int[10]; // arr = [0,0,0,12,0,0,0,0,0,0]

        arr[3] = 12;

        int p = 3;
        arr[p] = 12;
    }

    // void è la keyword che indica che il metodo non ritornerà nulla
    public static void method1(){
        System.out.println("method1");
    }

    // String è il tipo di ritorno del dato
    public static String returnString(){
        return "returnString";
    }


    public static int sum(int a, int b){
        return (a + b);
    }

    /* CONVENZIONI */
    // Le classi iniziano con la maiuscola (Pascal case) --> es. Recap, Prova, Loops
    // Le variabili iniziano con la minuscola (Camel case) --> es. number, houseSize
    // Le costanti sono in maiuscolo (Snake case) --> es. NUMBER, HOUSE_SIZE
    // I metodi iniziano con la minuscola e terminano con le tonde (Camel case), ed esprimono azioni --> es. getSize(), setNumber()
    // I nomi delle booleane devono essere una domanda --> es. isBig, hasStudents, canRun, hasRoom
    /* ----------- */

    /* MODIFICATORI DI ACCESSO */
    // public --> visibile a tutto il programma
    // protected --> visibile solo nello stesso pacchetto + classi ereditate
    // default --> visibile solo nello stesso pacchetto
    // private --> visibile solo nella stessa classe
    /* ----------------------- */

    /* KEYWORDS */
    // static "collega" il metodo o l'attributo alla classe --> es. System.console();
    // final dichiara una costante (non si può cambiare successivamente) --> es. final NUMBER = 2
    /* -------- */
}
