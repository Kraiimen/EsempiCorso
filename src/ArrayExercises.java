public class ArrayExercises {
    public static void main(String[] args){
// es 1: creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato
// es 2 calcolare e stampare il valore della somma di tutti i numeri dell'array 
// es 3 calcolare e stampare il valore minimo contenuto nell'array
// es 4 calcolare il valore medio contenuti  nell'array (somma dei valori, sarà un double)
// es 5 calcolare e stampare il numero di multipli di 2 che esistono all'interno dall'array (multipli di due)
// es 6 dato un valore arbitrario(int x = 4) calcolare e stampare il numero di volte in cui l'array contiene il valore di x
// es 7 creare un codice che inverta l'array

// es 8 dato un numero arbitrario (int z = 8) verificare quante volte nell'array succede che ne''array ci sono due numeri consecutivi in cui la somma fa z
// es 9 verificare che nell'array non esistano 3 numeri consecutivi la cui somma è maggiore di 12
// es 10 trovare il numero in cui appare più volte nell'array (2, 7, 12, 2, 7) va bene anche uno dei due

// ESERCIZIO 1 creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato
        System.out.println("Esercizio 1: ");
        int [] array1 = new int [5]; // creo una array che chiamo numbers di 5 interi
        for (int i = 0; i < array1.length ; i++) { //creo un ciclo, creando un intero di valore 0 di nome i, inizio iniziando da 1 all'ultimo, + 1 
            array1[i] = (i + 1)* (i + 1); // array 1 è assegnato a i e sta a array+1 x array+1 quindi è array al quadrato
        }
        for (int n : array1){ // i : è for each 
            System.out.println(n); // stampa ogni array al quadrato
        }

// ESERCIZIO 2 calcolare e stampare il valore della somma di tutti i numeri dell'array 
        System.out.println("\nEsercizio 2: ");
        int somma = 0; // creo una variabile intera con valore 0
        for(int i = 0; i < array1.length; i++){ // creo un ciclo delle array
            somma = somma + array1[i]; //somma equivale a valore della somma + aarray assegnato a i
        }
        System.out.println("La somma di tutti i numeri dell'array è: " + somma); // stampo la somma 

// ESERCIZIO 3 calcolare e stampare il valore minimo contenuto nell'array
        System.out.println("\nEsercizio 3: ");
        int min = array1[0]; // assegno variabile min al primo array
        for(int i = 0; i < array1.length; i++){ // inizio ciclo
            if (array1[i] < min){ // se l'array è minore del primo
                min = array1[i]; // allora l'array i è il nuovo minimo dell'array
            }
        }
        System.out.println("Il valore minimo è: " + min);

// ESERCIZIO 4 calcolare il valore medio contenuti  nell'array (somma dei valori, sarà un double)
        System.out.println("\nEsercizio 4: ");
        double[] array2 = {1.0, 2.0, 3.0, 4.0, 5.0};
        double som = 0; // dichiaro e inizializzo dell'array con 5 valori
        for (double numero : array2){ // ciclo for - each per calcolare la somma di tutti gli elementi
            som += numero; 
        }
        double valMedio = som/array2.length; //la media si ottiene dividendo gli elementi dell'array
        System.out.println("\nla somma è " + som);
        System.out.println("la media è " + valMedio);

// ESERCIZIO 5 calcolare e stampare il numero di multipli di 2 che esistono all'interno dall'array (multipli di due)   
        System.out.println("\nEsercizio 5: ");
        int count = 0; // contatore dei multipli di 2
        System.out.println("I multipli di 2 sono: ");
        for(int i = 0; i < array1.length; i++){
            if (array1[i] % 2 == 0 ){ // controlla se è multiplo di 2 
                System.out.println(array1[i] + " ");
                count++;  //stampa il numero e incrementa il contatore
            }
        }    
        System.out.println("\nNumero totale di multipli di 2: " + count);

// ESERCIZIO 6 dato un valore arbitrario(int x = 4) calcolare e stampare il numero di volte in cui l'array contiene il valore di x
        System.out.println("\nEsercizio 6: ");
        int x = 4; // assegno il valore di 4 alla nuova variabile 
        int coun = 0; // dichiaro una variabile per contare le numero di volte che c'è il valore di x
        System.out.println("Le numero di volte in cui l'array contiene il valore di 4 è: ");
        for(int i = 0; i < array1.length; i++){
            if (array1[i] == 4){ // se array è uguale a 4 allora aggiunge 1 al conto 
                coun++;
            }
        } 
        System.out.println(coun);

// ESERCIZIO 7 creare un codice che inverta l'array
        System.out.println("\nEsercizio 7");
        System.out.println("\nArray inverso: ");
        int[] reverse = new int[array1.length]; // creo una nuova array che chiamo reverse dell'array già esistente
        for (int i = 0; i < array1.length; i++){ // creo un ciclo con l'interezza dell'array nome reverse
            reverse[i] = array1[array1.length-1-i]; // copia i valori dell'array originale ma in ordine inverso 
            System.out.println(reverse[i]); // stampo all'interno del for il reverse
        }
// ESERCIZIO 8 dato un numero arbitrario (int z = 8) 
// verificare quante volte nell'array succede che nell'array 
// ci sono due numeri consecutivi in cui la somma fa z
        System.out.println("\nEsercizio 8");
        int array3[] = {2,4,4,3,5};
        int z = 8; // dichiaro una variabile di nome z con valore 8
        int counter = 0; // creo una variabile per contare il numero di volte in cui ci sta la somma di z
        
        // Esercizio 1: Creare un array di 5 interi e inizializzarlo con i primi numeri da 1 a 5 al quadrato
        
        int[] numbers = new int[5];
            
        for(int i = 0 ; i < numbers.length ; i++){
                numbers[i]= (i+1)*(i+1);
        }
        System.out.println("Le volte che la somma di due numeri consecutivi fa 8 è: " + counter);
    }
}