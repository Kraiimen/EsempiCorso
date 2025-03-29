
public class Esercizi {
    public static void main(String[] args){
//        Crea un array di numeri interi, ad esempio {2, 4, 6, 8, 10}
//        Usa un ciclo for-each per sommare tutti i numeri.
//                Stampa il risultato.
        int[] numeri = {2, 4, 6, 8, 10}; // creo un array di interi
        int somma = 0; // inizializzo un intero per la somma
        for(int i : numeri){ // inizializzo un ciclo for each dell'array
            somma += i; // a ogni numero dell'array si aggiunge alla variabile somma
        }
        System.out.println("la somma di tutti i numeri di questo array è: " + somma); // stampa somma

//        Esercizio 2: Conta le vocali in una stringa
//        Scrivi un programma che conti quante vocali (a, e, i, o, u) ci sono in una stringa.
//                Suggerimento
//        Chiedi all'utente di inserire una parola o frase.
//        Converti la stringa in un array di caratteri con .toCharArray().
//        Usa un ciclo for-each per controllare ogni carattere e contare le vocali.
//        Stampa il numero totale di vocali trovate.

        String[] vocali = {"a", "e", "i", "o", "u"};
        int conto = 0;
        for(String i : vocali){
            char[] converto = i.toCharArray(); // creo un array di char e converto i in un array di char
            conto++; // il conto sale a sogni carattere
        }
        System.out.println("Conto le vocali di questo array di stringhe: " + conto);

//                Esercizio 3: Trova il numero massimo in un array
//        Scrivi un programma che trovi il numero più grande in un array di interi.
//        Suggerimento
//        Crea un array con alcuni numeri, ad esempio {15, 7, 22, 3, 9}.
//        Inizializza una variabile max con il primo numero dell'array.
//        Usa un ciclo for-each per confrontare ogni numero con max e aggiornare max se il numero è più grande.
//                Stampa il massimo trovato.
        int[] numeroGrande = {15, 7, 22, 3, 9};
        int max = numeroGrande[0];
        for( int i : numeroGrande){
            if(i > max){
                max = i;
            }
        }
        System.out.println("Il numero più grande di questo array è: " + max);

//        Dichiara tre variabili: un numero intero, un numero decimale e una stringa. Stampa il loro valore.
        int x = 20;
        double y = 10.0;
        String lettera = "Lettera!";
        System.out.println("il numero x è: " + x);
        System.out.println(" il numero decimale y è: " + y);
        System.out.println(lettera);

        // Dato un numero, verifica se è positivo, negativo o zero e stampa un messaggio corrispondente.
        int negativo = 20;
        if(negativo > 0){
            System.out.println("il numero è positivo");
        } else if(negativo == 0){
            System.out.println("il numero è 0");
        }else{
            System.out.println("il numero è negativo");
        }

        // Stampa i numeri da 1 a 5 usando un ciclo for.
        System.out.println("stampo i numeri dall'1 al 5: ");
        for(int i = 1; i <= 5; i++){
            System.out.println(i);
        }

        //Dichiarare un array di 5 numeri e stamparli tutti.
        System.out.println("nell'array ci sono: ");
        int[] num = new int[5];
        for(int i = 0; i < num.length; i++){
            num[i] = 50 + i;
        System.out.println(num[i]);
        }

        // Crea un array di numeri interi con 5 valori.
        // Calcola la somma di tutti gli elementi.
        // Trova la media (somma divisa per il numero di elementi).
        // Stampa il risultato.
        System.out.println("L'array contiene:");
        int[] media = new int[5];
        for(int i = 0; i < media.length; i++){
            media[i] = i;
            System.out.println(media[i]);
        }
        System.out.println("La media di questo array è: ");
        int add = 0;
        for(int i : media){
            add = add + i;
        }
        add = add/5;
        System.out.println(add);

        // TRIS creare un array di array 3 x 3
        // deve stampare un camp vuoto, immetti una coordinata e mette la x
        char tris[][] = new char[3][3];
            
    }
}

