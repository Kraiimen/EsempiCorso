import java.io.Console;
import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.*;

public class Ess {
    public static void main(String[] args) {

        //Calcolare la somma dei numeri da 1 a 100 utilizzando un ciclo "for":
        //Contare il numero di occorrenze di un elemento in un array di stringhe:
        //Stampare i caratteri di una stringa uno alla volta utilizzando un ciclo "for":
        //Stampare i numeri pari da 1 a 20 utilizzando un ciclo "for":
        //Scrivi un programma Java che verifichi se un numero è compreso tra 10 e 20 (estremi inclusi)
        //Stampare i quadrati dei numeri da 1 a 10 utilizzando un ciclo "for"
        //Creare un metodo statico che converte una temperatura da Celsius a Fahrenheit. (modificato)
        //Invertire gli elementi di un array

//        int num = 15;
//        if(num >= 10 && num <=20 ){
//            System.out.println("è presente");
//        }else{
//            System.out.println("non è presente");
//        }


//        String nome = "Elvis";
//        for(int i=0;i<nome.length();i++){
//            System.out.println(nome.charAt(i));
//        }

//        int sum =0;
//        for(int i = 1; i<= 100;i++){
//            sum+= i;
//        }
//        System.out.println(sum);

//        String[] names = {"pippo", "pino", "giacomino", "pino"};
//        int counter = 0;
//        for(int i = 0; i<names.length; i++){
//            for(int j = 0; j<names.length; j++){
//                if(names[i] == names[j]){
//                    counter++;
//                }
//            }
//            System.out.println("La parola: "+names[i]+" è presente nell'array: "+counter+" volte");
//            counter = 0;
//        }


//        for(int i =0; i<=20;i++){
//            if(i % 2 == 0){
//                System.out.println(i);
//            }
//        }
        //Esercizio 1
        // String colore = "Verde";
        // //finchè si lavora con i primitivi utilizzi == , altrimenti si utilizza equals
        // if( colore.equals("Verde") ) {
        //     System.out.println("è " + colore + " puoi passare");
        // }else if(colore.equals("Giallo")) {
        //     System.out.println("è " + colore + "puoi passare ma fai attenzione");
        // }else if(colore.equals("Rosso")) {
        //     System.out.println("Stop");
        //}

        //Esercizio 2 
        //Verifica se il numero è pari o dispari
        // Scanner input = new Scanner(System.in);
        // System.out.println("Dammi un numero");
        // int numero = Integer.parseInt(input.nextLine());
        // if (numero % 2 == 0 ) {
        //     System.out.println("è pari");
        // }else {
        //     System.out.println("è dispari");
        // }

        // Esercizio 3 
        // Prendi 2 numeri da console se sono uguali allora mi stampi che sono uguali ,se il primo è maggiore dimmi che il primo è maggiore
        // altrimenti se il secondo è maggiore stampa il secondo è maggiore
        // Scanner input = new Scanner(System.in);
        // int a;
        // int b;
        // String c;

        // do {
        //     System.out.println("Dammi 2 numeri");
        // a = Integer.parseInt(input.nextLine());
        // b = Integer.parseInt(input.nextLine());
        //     if(a == b) {
        //         System.out.println("i due numeri sono uguali");
        //     }else if(a > b){
        //         System.out.println("Il primo è maggiore");
        //     }else if(b > a){
        //         System.out.println("il secondo è maggiore");
        //     }
        //     System.out.println("Vuoi continuare?");
        //     c = input.nextLine();
        // }while(c.equals("Yes"));

        // Esercizio 4 Semaforo dinamico
        // Scanner input = new Scanner(System.in);
        // String risposta = "";
        // do {
        //     System.out.println("Di che colore è il semaforo?");
        //     String semaforo = input.nextLine();
        //     if(semaforo.equals("Verde")){
        //         System.out.println("puoi passare");
        //     }else if(semaforo.equals("Giallo")){
        //         System.out.println("Muoviti lumaca");
        //     }else if(semaforo.equals("Rosso")){
        //         System.out.println("vai sciolt fammi sapere come va");
        //     }else{
        //         System.out.println("è un semaforo sveglia , scegli tra Verde,Giallo o Rosso");
        //     }
        //     System.out.println("Vuoi continuare?");
        //     risposta = input.nextLine();
        // }while(risposta.equals("Si"));

        // Esercizio 5
        // Chiedi all'utente un numero e conta fino a quel numero
        // Scanner input = new Scanner(System.in);
        // System.out.println("Dammi un numero è conterò fin ad esso");
        // int numero = Integer.parseInt(input.nextLine());
        // for(int i = numero; i >= 1 ; i--) {
        //     System.out.println(i);
        // }

        //Esercizio 6 
        //dichiarami un vettore di 10 nominativi, poi chiedi all'utente di inserire un nome da cercare nella lista, se il nome c'è stampalo
        //ed indica anche la posizione in cui si trova all'interno del vettore , se non c'è chiedigli di inserire un altro nome da cercare. 
        // Successivamente , chiedi all'utente se vuole continuare a cercare un altro nome

        // Scanner input = new Scanner(System.in);
        // String[] utenti = {"Alfredo", "Monica", "Antonio", "Antonella", "Maurizio", "Mario", "Claudia", "Pippo", "Pino", "Pedro" };
        // String nome;
        // String risposta = "";
        // boolean trovato = false; 

        // do{
        //     System.out.println("Dammi un nome è controllero se fa parte della lista");
        //     nome = input.nextLine();
        //     for(int i = 0 ; i < utenti.length ; i++ ) {
        //         String s = utenti[i];
        //         if (s.equals(nome)) {
        //             System.out.println(nome +" è presente ed è in posizione " + i);
        //             trovato=true;
        //         }

        //     }

        //     if (trovato == false) {
        //         System.out.println("Non c'è");
        //     }
        //     System.out.println("Riprovi?");
        //     risposta = input.nextLine();
        // }while(risposta.equals("Yes"));


        //Esercizio 7, rendi dinamico l'inserimento dei nomi dell'esercizio 6 
        // Scanner input = new Scanner(System.in);
        // String[] utenti = new String[10];
        // System.out.println("Dammi 10 nomi");
        // boolean trovato = false;

        // for(int i = 0; i < utenti.length ; i++) {
        //     System.out.println("Dammi il " +(i+1) + "° nome");
        //     utenti[i] = input.nextLine(); 
        //     }
        // System.out.println("Bene, ora dammi un nome da cercare nella lista");
        // String cercaNome = input.nextLine();
        // for (int y = 0 ; y < utenti.length ; y++) {
        //     if(utenti[y].equals(cercaNome)) {
        //         System.out.println("il nome è presente ed è alla posizione " + y);
        //         trovato = true;

        //     }
        // }
        // if (trovato == false) {
        //     System.out.println("il nome non c'è");
        // }
        // Exercise 1:
        // Write a program that asks the user for a number and prints whether it is even or odd.
        // Scanner input = new Scanner (System.in);
        // System.out.println("Give me a number and i'll tell you if it's even or odd ");
        // int i = Integer.parseInt(input.nextLine());
        // if(i % 2 == 0){
        //     System.out.println("it's even");
        // }else System.out.println("it's odd");


        // Exercise 2:
        // Write a program that asks the user for their age and determines if they are old enough to drive (minimum age: 18).
        // Scanner input = new Scanner (System.in);
        // System.out.println("How old are you?");
        // int i = input.nextInt();
        // if(i >= 18){
        //     System.out.println("You can drive");
        // }else System.out.println("You can't drive");

        // Exercise 3:
        // Write a program that asks the user for three numbers and prints the largest one.
        // Scanner input = new Scanner(System.in);
        // System.out.println("Give me 3 numbers and i shall tell you the biggest");
        // int number1 = input.nextInt();
        // int number2 = input.nextInt();
        // int number3 = input.nextInt();
        // int max;
        // if(number1 > number2 && number1 > number3  ){
        //     max = number1;
        // }else if (number2 > number3){
        //     max = number2;
        // }else {
        //     max = number3;
        // }
        // System.out.println("The biggest number is " + max);

        // Exercise 1:
        // Write a program that prints all numbers from 1 to 10 using a for loop.
        // int x;
        // for(int i = 1 ; i <= 10 ; i++){
        //     x =  i;
        //     System.out.println(x);
        // }


        // Exercise 2:
        // Write a program that asks the user to enter numbers until they enter 0, then prints the total sum of the numbers entered.
        // Scanner input = new Scanner(System.in);
        // int sum;
        // int total = 0;
        // System.out.println("Give me as many numbers as you want and i shall give you the sum until you type 0");
        // do {
        //     sum = input.nextInt();
        //     total = total+sum;
        // }while (sum != 0);
        // System.out.println("The sum is " + total);


        // Exercise 3:
        // Print the multiplication table of 5 (from 5×1 to 5×10) using a while loop.
        // int base = 5;
        // int i = 1;
        // while(i <= 10) {
        //     System.out.println(base*i);
        //     i++;
        // }

        // Exercise 1:
        // Ask the user for their name and print a welcome message.
        // Scanner input = new Scanner(System.in);
        // System.out.println("What's your name?");
        // String nome = input.nextLine();
        // System.out.println("Welcome " + nome);

        // Exercise 2:
        // Ask the user for two numbers and print their sum.
        // Scanner input = new Scanner(System.in);
        // System.out.println("Gimme 2 numbers and i shall do the sum for you");
        // int a = input.nextInt();
        // int b = input.nextInt();
        // int sum = a+b;
        // System.out.println(sum);

        // Exercise 3:
        // Ask the user for a word and print it in reverse.
        // Scanner input = new Scanner(System.in);
        // System.out.println("i'll reverse a word for you");
        // String word = input.nextLine();
        // String reversedWord = new StringBuilder(word).reverse().toString();
        // System.out.println(reversedWord);

        // Exercise 1:
        // Declare an array of 5 integers and print all its elements.
        // int[] numbers= {1,2,3,4,5};
        // for(int i = 0 ; i < numbers.length ; i++){
        // int stamp = numbers[i];
        // System.out.println(stamp);
        // }

        // Exercise 2:
        // Ask the user to enter 5 numbers and store them in an array. Then, calculate the average of the numbers entered.
//         Scanner input = new Scanner(System.in);
//         double sum = 0;
//         double result = 0;
//         System.out.println("Give me 5 numbers for the array");
//         int[] numbers = new int[5];
//         for(int i = 0 ; i < numbers.length ; i++){
//             numbers[i] = input.nextInt();
//             for (int x = 0 ; x < numbers.length ; x++) {
//                 sum = sum + numbers[x];
//             }
//         } result = (sum/numbers.length);
//         System.out.println(result);

        // Exercise 3:
        // Declare an array of numbers and find the largest number in it.
//         int[] numbers = {1,2,3,4,5,6,7,8,9,10};
//         int max = 0;
//         for(int i = 0 ; i < numbers.length ; i++){
//             if (numbers[i] > max) {
//                 max = numbers[i];
//             }
//         }
//         System.out.println(max);

//          Esercizio 1
        //Crea un array di numeri interi, ad esempio {2, 4, 6, 8, 10}.

        //Usa un ciclo for-each per sommare tutti i numeri.

        //Stampa il risultato.

        // int[] numeri = {2,5,8,11,76};
        // int sum = 0 ;
        // for(int i : numeri ) {
        //     sum += i;
        // }
        // System.out.println(sum);

        // Esercizio 3: Trova il numero massimo in un array
        // Scrivi un programma che trovi il numero più grande in un array di interi.

        // Suggerimento
        // Crea un array con alcuni numeri, ad esempio {15, 7, 22, 3, 9}.
        // Inizializza una variabile max con il primo numero dell'array.
        // Usa un ciclo for-each per confrontare ogni numero con max e aggiornare max se il numero è più grande.
        // Stampa il massimo trovato.

        // int[] numeri = {15 , 7, 22, 3, 9};
        // int max = 0;
        // for(int i : numeri){
        //     if ( max < i){
        //          max = i;
        //     }
        // }
        // System.out.println(max);

        //Esercizio sulle Variabili
        //Descrizione:
        //Dichiara tre variabili: un numero intero, un numero decimale e una stringa. Stampa il loro valore.

        // int i = 5;
        // double d = 4.4;
        // String s = "Ciao";

        //Esercizio su if-else
        //Descrizione:
        //Dato un numero, verifica se è positivo, negativo o zero e stampa un messaggio corrispondente.

        // int numero = -2;
        // if ( numero >= 1) {
        //     System.out.println("il " + numero + " è positivo");
        // } else if (numero <= -1) {
        //     System.out.println("il " + numero + " è negativo");
        // } else if (numero == 0) {
        //     System.out.println("il " + numero + " è neutro");
        // }

        //Esercizio sui Cicli (for)
        //Descrizione:
        //Stampa i numeri da 1 a 5 usando un ciclo for.

        // for(int i = 1; i <= 5 ; i++){
        //     System.out.println(i);
        // }

        //4️⃣ Esercizio sugli Array 📦
        //Descrizione:
        //Dichiarare un array di 5 numeri e stamparli tutti.

        // int[] numeri = new int[5];
        // for(int i = 0 ; i< numeri.length ; i++){
        //     numeri[i] = i;
        //     System.out.println(numeri[i]);
        // }

        // Esercizio: Calcola la media dei numeri in un array 📊
        // Descrizione:

        // Crea un array di numeri interi con 5 valori.
        // Calcola la somma di tutti gli elementi.
        // Trova la media (somma divisa per il numero di elementi).
        // Stampa il risultato.
        // int sum = 0;
        // int media = 0;
        // int[] numeri = new int[10];
        // for(int i = 0; i < numeri.length ; i++){
        //     numeri[i] = i;
        //     sum += numeri[i];
        // }
        // media = sum/numeri.length;
        // System.out.println(media);

        // 1️⃣ Basic Array Manipulation
        // Write a Java program that:
        // Creates an array of 5 integers
        // Assigns values to each element
        // Prints each value using a loop

        // int[] numbers = {5,6,7,8,9};
        // for (int i = 0; i < numbers.length ; i++) {
        //     // numbers[i] = numbers[i];
        //     System.out.println(numbers[i]);
        // }

        // 2️⃣ Find the Largest Element
        // Write a Java program that finds and prints the largest number in an array of integers.

        // int[] numbers = {4,22,86,111,1};
        // int max = 1;
        // for(int i = 0; i< numbers.length; i++){
        //     if(max < numbers[i]) {
        //         max = numbers[i];
        //     }
        // }
        // System.out.println(max);

        // 3️⃣ Reverse an Array
        // Write a Java program that reverses an array in-place.

        // int[] array = {2,4,6,8,10};
        // for(int i = array.length-1 ; i >= 0 ; i--){
        //     System.out.println(array[i]);
        // }

        // 4️⃣ Sum of Array Elements
        // Write a Java program that calculates the sum of all elements in an array.

        // int[] numbers = {2,4,6,8,10};
        // int sum = 0;
        // for(int i = 0; i < numbers.length; i++){
        //     sum+= numbers[i];
        // }
        // System.out.println(sum);


        // 5️⃣ Convert the Sum Exercise to Use a Method
        // Modify Exercise 4 so that the sum calculation happens inside a method called sumArray().


        // int[] numbers = {2,4,8,10,12,222};
        // System.out.println(sumArray(numbers));

        //} <-- della main

        // public static int sumArray(int[] numbers){
        //     // int[] numbers = new int[5];  NON NECESSARIA ERRORE 104
        //     int sum = 0;
        //     for(int i = 0; i < numbers.length; i++){
        //         sum+= numbers[i];
        //     }
        //     return sum;
        // }
        // int[] abc = {22,66,11,5,909};
        // // System.out.println(findMin(abc));
        // System.out.println(findMax(abc));

        //} sempre la main

        // 6️⃣ Find Minimum and Maximum Using Methods
        // Write a Java program that uses two methods:

        // findMin(int[] arr) → returns the smallest value

        // findMax(int[] arr) → returns the largest value

        // public static int findMin(int[] array){
        //     Integer min = Integer.MAX_VALUE;
        //     for(int i = 0 ; i < array.length ; i++){
        //         if(array[i] < min) {
        //             min = array[i];
        //         }
        //     }
        //     return min;
        // }

        // public static int findMax(int[] array){
        //     int max = 0;
        //     for(int i = 0 ; i < array.length ; i++){
        //         if(array[i] > max) {
        //             max = array[i];
        //         }
        //     }
        //     return max;
        // }
        // int[] total = {2,345,32,76,11};
        // System.out.println(sumArray(total));
        // }
        // // Sum of Array Elements Using a Method
        // // Modify an existing program so that the sum calculation happens inside a method called sumArray(int[] numbers).
        // public static int sumArray(int[] nums){
        //     int sum = 0;
        //     for(int i = 0; i < nums.length; i++){
        //         sum += nums[i];
        //     }
        //     return sum;
        // }
//    int[] test = {11,56,123,77,11};
//    int fragola = 56;
//    int limone = 4444;
//    System.out.println(contains(test, fragola));
//    System.out.println(contains(test, limone));
//    }
//    // Check if a Number Exists in an Array Using a Method
//    // Write a Java program with a method contains(int[] arr, int num) that checks if a given number exists in an array.
//    // The method should return true if the number is found, and false otherwise.
//    public static boolean contains(int[] array, int num){
//        for(int i = 0 ; i < array.length ; i++){
//            if (num == array[i]) {
//                return  true;
//            }
//        }
//        return false;
//    }

//    int jonathan = 52;
//    int marco = 52;
//    int bucchino = 666;
//    System.out.println(giveSomma(jonathan,bucchino));
//
//    }
////    Esercizio 1: Somma di due numeri
////    Scrivi un metodo chiamato somma che accetta due numeri interi come parametri e restituisce la loro somma.
//    public static int giveSomma(int y ,int x){
//        int c = y+x;
//        return c;
//    }
//        int jonathan = 104;
//        pari_o_dispari(jonathan);
//    }
////    Esercizio 2: Verifica pari o dispari
////    Scrivi un metodo chiamato pari_o_dispari che accetta un numero intero come parametro e restituisce "Pari"
////    se il numero è pari, altrimenti "Dispari".
//    public static void pari_o_dispari(int a){
//        if(a % 2 == 0) {
//            System.out.println("è pari");
//        }else{
//            System.out.println("è dispari");
//        }
//    }
//        String nome = ("Eugenio");
//        wName(nome);
//    }
////    1. Basic Method
////👉 Write a method greet that takes a name as input and prints "Hello, [name]!"
//    public static void wName(String a){
//        System.out.println("Hello " + a);
//    }
//        int num1 = 4;
//        int num2 = 2;
//        System.out.println(add_numbers(num1,num2));
//    }
////    2. Sum of Two Numbers
////👉 Write a method add_numbers that takes two numbers as input and returns their sum.
//    public static int add_numbers(int a , int b){
//        int c;
//        c = a+b;
//        return c;
//    }
//        int even = 2;
//        int odd = 3;
//        System.out.println(is_even(even));
//        System.out.println(is_even(odd));
//    }
////    3. Check Even or Odd
////👉 Write a method is_even that takes an integer and returns True if it's even, otherwise False.
//    public static boolean is_even(int a){
//        if(a % 2 == 0){
//            return true;
//        }else{
//            return false;
//        }
//    }
//        int a = 2;
//        int b = 3;
//        int c = 4;
//        System.out.println(find_max(a,b,c));
//      }
////      4. Find the Maximum
////    👉 Write a method find_max that takes three numbers and returns the largest.
//    public static int find_max(int a, int b, int c){
//        if(a > b && a > c){
//            return a;
//        }else if (b > a && b > c){
//            return b;
//        }else{
//            return c;
//        }
//    }
//        String nome = "otto";
//        System.out.println(isPalindrome(nome));
//      }
////      👉 Write a method is_palindrome that checks if a given string is a palindrome (reads the same forward and backward).
//    public static boolean isPalindrome(String s){
//        boolean isPalindrome = false;
//        int lenght = s.length();
//        for(int i = 0 , j = lenght - 1 ; i < j ; i++ , j--){
//            if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
//                isPalindrome = true;
//            }else{
//                return false;
//            }
//
//        }
//        return isPalindrome;
//    }
//        ArrayList<String> names = new ArrayList<>();
//        names.add("Marco");
//        names.add("Eugenio");
//        names.add("Pippo");
//        names.add("Pino");
//        names.add("Paolo");
//        System.out.println(names);

//        ArrayList<Integer> interi = new ArrayList<>();
//        interi.add(1);
//        interi.add(2);
//        interi.add(3);
//        interi.add(4);
//        System.out.println(interi);

//                                     🏁 Recap Exercises (Up to Methods)
//        1. Basic Variable and Data Type Exercise
//        Declare variables of the following types: int, double, char, and String.
//
//        Assign a value to each variable and print them.
//        int num = 1;
//        double num2 = 2;
//        char c = 'c';
//        String s = "Hello";

//        2. Arithmetic Operations
//        Write a program that takes two integers as input and prints the result
//        of adding, subtracting, multiplying, and dividing the numbers.

//          int a = 10;
//          int b = 5;
//          int c = a+b;
//          int c1 = a-b;
//          int c2 = a*b;
//          int c3 = a/b);

//        Write a program that checks if a number is positive, negative, or zero.
//        Task: Ask the user for a number and display a message:
//        "The number is positive", "The number is negative", or "The number is zero" depending on the input.

//        Scanner input = new Scanner(System.in);
//        System.out.println("Give me a number i'll tell you if it's positive, negative or 0");
//        int a = input.nextInt();
//        if(a > 0){
//            System.out.println(a + " it's positive");
//        }else if (a < 0){
//            System.out.println(a + " it's negative");
//        }else{
//            System.out.println(a + " è 0");
//        }

//        5. For Loop
//        Write a program that prints numbers from 1 to 10.

//        for(int a = 0; a <= 10 ; a++){
//            System.out.println(a);
//        }

//        Task: Use a for loop to print all numbers from 1 to 100 that are divisible by 3.
//        for(int num = 0; num <= 100; num++){
//            if(num % 3 == 0){
//                System.out.println("divisible by 3 babe");
//            }else{
//                System.out.println(num);
//            }
//        }

//        Write a program that asks the user for a number and sums all integers from 1 to that number using a while loop.
//        Scanner input = new Scanner(System.in);
//        int a = input.nextInt();
//        int start = 0;
//        while(start < a) {
//            start++;
//            System.out.println(start);

//        Task: Using a while loop, sum all the numbers between 1 and 100.
//        int limit = 100;
//        int start = 1;
//        int sum = 0;
//        while(start<=limit){
//            sum+= start;
//            start++;
//        }
//        System.out.println(sum);

//
//        7. Array Basics
//        Declare an array of 5 integers, assign values to each element, and print all elements.
//
//        Task: Create an array of 5 string names and print each name on a new line.

//        int[] array = {2,4,6,8,10};
//        for(int i = 0; i< array.length; i++){
//            System.out.println(array[i]);
//        }

//        String[] names = {"pippo" , "pino" , "aldo", "giovanni" , "giacomo"};
//        for(int i = 0; i< names.length; i++) {
//            System.out.println(names[i]);
//        }

//        8. Array Operations
//        Write a program that finds the largest and smallest number in an array of integers.
//        Task: Given an array of 10 integers, find and print the largest and smallest values.

//        int[] nums = {2,4,6,8,10};
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i< nums.length; i++){
//            if(nums[i] < min){
//                min = nums[i];
//            }
//            if(nums[i] > max){
//                max = nums[i];
//            }
//        }
//        System.out.println("il minore è " + min + " il maggiore è " + max);

//        9. Array and Loop Combination
//        Write a program that calculates the average of all numbers in an array.

//        int[] nums = {2,4,6,8,10};
//        int sum = 0;
//        int tot = 0;
//        for(int i = 0;i< nums.length; i++){
//            sum+=nums[i];
//        }
//        tot = sum/nums.length;
//        System.out.println(tot);

//        10. Basic Input/Output
//        Write a program that takes a string input from the user and prints "Hello, <name>!".
//        Task: Take the user’s first and last name and print a greeting using both names.

//        Scanner input = new Scanner(System.in);
//        System.out.println("What's your name?");
//        String nome = input.next();
//        System.out.println("what about your surname?");
//        String cognome = input.next();
//        System.out.println("Hello " + nome +" "+ cognome + "!");

//    }
//    Exercises:
//    Here are some practice exercises to work on:
//    Create a method that multiplies two numbers and returns the result.
//    Write a method that takes an integer and returns whether it is even or odd (as a string: "Even" or "Odd").
//    Create a method that calculates the factorial of a number (e.g., 5! = 5 * 4 * 3 * 2 * 1).
//    Write a method that takes two strings as parameters and prints them in reverse order.

//    public int multi(int a , int b){
//        int c=a*b;
//        return c;
//    }
//    public void isEvenOirIsOdd(int a){
//    if(a % 2 == 0 ){
//        System.out.println("it is even");
//    }else{
//        System.out.println("it is odd");
//    }
//    public int andonio(int a){
//    int factorial = 1;
//    for(int i = 1;i <= a ;i++){
//        factorial *= i;
//    }
//    return factorial;


        // Esercizio 1.1 – Somma di due numeri
        // Scrivi un programma che:
        // - Dichiari due variabili int, le inizializzi con valori a tua scelta.
        // - Calcoli la loro somma.
        // - Stampi il risultato con un messaggio tipo: "La somma di 5 e 7 è 12"
//        int a =1;
//        int b =2;
//        int c=a+b;
//        System.out.println("the sum between " +a+" "+"and"+" "+b+" is " +c);

        // Exercise 1.2 – Area and Perimeter of a Rectangle
// Write a program that:
// - Declares two `double` variables: `length` and `width`
// - Calculates the area (length * width) and the perimeter (2 * (length + width))
// - Prints both results in a clear sentence like:
//   "The area is 20.0 and the perimeter is 18.0"
//        double lenght = 10.5;
//        double width = 5.5;
//        double area = lenght*width;
//        double perimeter = ((lenght+width)*2);
//        System.out.println("The area is:" + area + " The perimeter is: " + perimeter);

        // Exercise 1.3 – Temperature Converter
// Write a program that:
// - Asks the user to input a temperature in Celsius.
// - Converts it to Fahrenheit using the formula: Fahrenheit = (Celsius * 9/5) + 32
// - Prints the result in a clear format like: "25.0 Celsius is 77.0 Fahrenheit"
//        Scanner input = new Scanner(System.in);
//        System.out.println("Celsius to Fahrenheit converter : please give me a temperature");
//        double celsius = input.nextDouble();
//        double fahrenheit = ((celsius * 9)/5) + 32;
//        System.out.println("The temperature is: "+ fahrenheit);

        // Exercise 2.1 – Even or Odd
// Write a program that:
// - Asks the user to input an integer.
// - Checks whether the number is even or odd using an `if-else` statement.
// - Prints the result: "The number 4 is even" or "The number 7 is odd".
//        Scanner input = new Scanner(System.in);
//        System.out.println("Give me a number");
//        int num= input.nextInt();
//        if(num % 2 == 0){
//            System.out.println("it's even");
//        }else{
//            System.out.println("it's odd");
//        }

        // Write a program that:
// - Asks the user to input a number (representing a grade between 0 and 100).
// - Uses `if-else` statements to check the grade and print a corresponding message:
//   - If the grade is 90 or above, print: "Excellent"
//   - If the grade is between 80 and 89, print: "Good"
//   - If the grade is between 70 and 79, print: "Average"
//   - If the grade is below 70, print: "Fail"
//        Scanner input = new Scanner(System.in);
//        System.out.println("Give me the grade of the x student");
//        int grade = input.nextInt();
//        if(grade>100){
//            System.out.println("Give me a proper grade");
//        }else if(grade >= 90 && grade <= 100){
//            System.out.println("Eggcellent");
//        }else if(grade >= 80 && grade <= 89){
//            System.out.println("Good");
//        }else if(grade >= 70 && grade <= 79){
//            System.out.println("Avarage");
//        }else{
//            System.out.println("Fail");
//        }

        // Exercise 2.3 – Number Comparison
// Write a program that:
// - Asks the user to input two integers.
// - Compares the two integers and prints the larger one, or if they are equal, print: "The numbers are equal."
//        Scanner input = new Scanner(System.in);
//        System.out.println("give me 2 numbers");
//        int a = input.nextInt();
//        int b = input.nextInt();
//        if(a>b){
//            System.out.println(a);
//        }else if(b>a){
//            System.out.println(b);
//        }else{
//            System.out.println("equals");
//        }

        // Exercise 3.1 – Print Numbers 1 to 10
// Write a program that:
// - Uses a `for` loop to print the numbers from 1 to 10, each on a new line.
//        for(int i = 1; i<=10; i++){
//            System.out.println(i);
//        }

        // Exercise 3.2 – Sum of Numbers
// Write a program that:
// - Uses a `for` loop to calculate the sum of the numbers from 1 to 100.
// - Prints the result: "The sum of numbers from 1 to 100 is: 5050"
//        int sum = 0;
//        for(int i = 1;i<=100;i++){
//            sum += i;
//        }
//        System.out.println(sum);

        // Exercise 3.3 – Reverse Countdown
// Write a program that:
// - Asks the user to enter a positive number (e.g. 5)
// - Uses a `while` loop to count down from that number to 0
// - Prints each number on a new line
//        Scanner input=new Scanner(System.in);
//        int a = input.nextInt();
//        while(a>=0){
//            System.out.println(a);
//            a--;
//        }

        // Exercise 3.4 – Password Retry
// Write a program that:
// - Has a predefined password, e.g., "bootcamp".
// - Asks the user to enter the password.
// - If the password is incorrect, it asks again (loop).
// - Once the correct password is entered, print: "Access granted!"
//        Scanner input = new Scanner(System.in);
//        String password = "password";
//        System.out.println("Insert password");
//        String userpsw = input.nextLine();
//        while(!userpsw.equals(password)){
//            System.out.println("Retry");
//            userpsw = input.nextLine();
//        }
//        System.out.println("Access Granted");

        // Exercise 3.5 – Guess the Number (do-while)
// Write a program that:
// - Has a secret number (e.g., 7)
// - Uses a `do-while` loop to keep asking the user to guess the number
// - If the guess is wrong, print "Try again"
// - If the guess is correct, print "Correct!" and exit the loop
//        Scanner input = new Scanner(System.in);
//        Random random = new Random();
//        int secret = random.nextInt(11);
//        System.out.println("Guess the number within 10");
//        int guess = input.nextInt();
//        do{guess = input.nextInt();
//            System.out.println("Try again");
//        }while(secret != guess);
//        System.out.println("Well done");

        // Exercise 3.6 – Print Shopping List (for-each loop)
// Write a program that:
// - Has an array of Strings with items like: {"Milk", "Bread", "Eggs", "Cheese"}
// - Uses a `for-each` loop to print each item in the shopping list, one per line
//        String[] shoppinglist = {"Milk","Bread","Eggs","Cheese"};
//        for(String item : shoppinglist){
//            System.out.println(item);
//        }

        // Exercise 4.1 – Array Initialization and Print
// Write a program that:
// - Creates an array of 5 integers: {1, 2, 3, 4, 5}
// - Prints each element in the array using a `for` loop
//        int[] nums = {1,2,3,4,5};
//        for(int i = 0 ; i< nums.length; i++){
//            System.out.println(nums[i]);
//        }

        // Exercise 4.2 – Find the Maximum in an Array
// Write a program that:
// - Creates an array of integers: {10, 20, 35, 50, 5}
// - Finds and prints the maximum value in the array
//        int[] nums = {10,20,35,50,5};
//        int max = nums[0];
//        for(int i = 0 ; i< nums.length; i++){
//            if(max < nums[i]){
//                max = nums[i];
//            }
//        }
//        System.out.println(max);

        // Exercise 4.3 – Reverse an Array
// Write a program that:
// - Asks the user to input 5 integers.
// - Store these integers in an array.
// - Reverse the array and print the reversed version.
//        Scanner input = new Scanner(System.in);
//        System.out.println("give me 5 numbers");
//        int[] nums = new int[5];
//        for(int i = nums.length-1;i >= 0;i--){
//            nums[i] = input.nextInt();
//        }
//        for(int i = 0; i< nums.length; i++){
//            System.out.println(nums[i]);
//        }

        // Exercise 4.4 – Sum of All Elements in an Array
// Write a program that:
// - Creates an array of integers: {1, 2, 3, 4, 5, 6}
// - Calculates and prints the sum of all the elements in the array
//        int[] nums = {1,2,3,4,5,6};
//        int sum = 0;
//        for(int i = 0 ; i< nums.length; i++){
//            sum+= nums[i];
//        }
//        System.out.println(sum);

        // Exercise 5.1 – Concatenate Two Strings
// Write a program that:
// - Takes two strings as input from the user.
// - Concatenates them and prints the result.
//        Scanner input = new Scanner(System.in);
//        String first = input.nextLine();
//        String second = input.nextLine();
//        String cFinal = first.concat(second);
//        System.out.println(cFinal);

        // Exercise 5.2 – String Length and Character at Specific Index
// Write a program that:
// - Takes a string input from the user.
// - Prints the length of the string.
// - Prints the character at the 3rd index (remember, indexing starts at 0).
//        Scanner input = new Scanner(System.in);
//        String userString = input.nextLine();
//        System.out.println(userString.length());
//        System.out.println(userString.charAt(2));

        // Exercise 5.3 – Substring and String Comparison
// Write a program that:
// - Takes a string input from the user.
// - Extracts and prints the substring starting from index 2 to index 5 (inclusive).
// - Compares the input string with a hardcoded string "hello" and prints if they are equal or not.
//        Scanner input = new Scanner(System.in);
//        String toCompare = "Hello";
//        String userString = input.nextLine();
//        String extract = userString.substring(0, 5);  // Adjusted to include index 5
//        if (extract.toLowerCase().equals(toCompare.toLowerCase())){
//            System.out.println("Equals indeed");
//        }else{
//            System.out.println("Nope");
//        }

//        1. Day of the Week (Easy)
//                Goal: Use switch to print the day name based on a number (1–7).
//
//                Task:
//        Write a program that takes an integer input (1 to 7) and prints the corresponding day of the week.
//        If the input is not between 1 and 7, print "Invalid day".
//        int dayWeek = 4;
//        switch(4){
//            case 1:
//                System.out.println(" 1 Monday");
//                break;
//            case 2:
//                System.out.println("2 : Tuesday");
//                break;
//            case 3:
//                System.out.println("3 : Wednesday");
//                break;
//            case 4:
//                System.out.println("4 : Thursday");
//                break;
//            case 5:
//                System.out.println("5 : Friday");
//            default:
//                System.out.println("Weekend");
//        }
//        2. Simple Calculator (Beginner-Intermediate)
//        Goal: Use switch to perform operations.
//
//                Task:
//        Ask the user to input two numbers and an operator (+, -, *, /). Use switch to perform the correct operation and print the result.
//        Scanner input = new Scanner(System.in);
//        int a = input.nextInt();
//        int b = input.nextInt();
//        input.nextLine();
//        String operator = input.nextLine();
//
//        switch (operator){
//            case "+":
//                System.out.println(a+b);
//                break;
//            case "-":
//                System.out.println(a-b);
//                break;
//            case "*":
//                System.out.println(a*b);
//                break;
//            case "/":
//                System.out.println(a/b);
//                break;
//            default:
//                System.out.println("invalid operation");
//        }
//        Chiedere a un utente di inserire una parola. La parola verrà inserita all'interno di una lista.
//        Ripetere questo procedimento finché l'utente non scrive nulla e preme soltanto invio.
//        Stampare la lista di parole.
//        Scanner input = new Scanner(System.in);
//        String word;
//        ArrayList<String> words = new ArrayList<>();
//
//        do {
//            System.out.println("dammi del testo");
//            word = input.nextLine();
//            if(!word.isEmpty()){
//                words.add(word);
//            }
//        }while (!word.isEmpty());
//        System.out.println(words);
//        do {
//            System.out.println("dammi del testo da rimuovere");
//            word = input.nextLine();
//            if(words.contains(word)){
//                words.remove(word);
//                System.out.println(word + "removed");
//            }else{
//                System.out.println(word + "non è presente");
//            }
//        }while (!word.isEmpty());
//        System.out.println(words);
//          Scanner input = new Scanner(System.in);
//          Map<String,Integer> inventory = new HashMap<>();
//          while (true) {
//              System.out.println("dammi info");
//              String nomefrutto = input.nextLine();
//              if (nomefrutto.isEmpty()){
//                  break;
//              }
//              Integer amount = input.nextInt();
//              input.nextLine();
//              inventory.put(nomefrutto, amount);
//          }
//          for (Map.Entry<String,Integer> entry : inventory.entrySet()){
//              System.out.println(entry.getKey() +  ":" + entry.getValue());
//          }
//        System.out.println(inventory.containsKey("mela"));
//        📗 Level: Beginner to Intermediate
//        (★☆☆☆☆) Declare an int variable named age and assign it the value 25. Print it.
//        int age = 25;
//        System.out.println(age);
//        (★☆☆☆☆) Create a double variable for a product price and a String for its name. Print a sentence like: The price of Bread is 2.5.
//        String name = "bread";
//        int price = 2;
//        System.out.println(name +"costs "+price);
//        (★☆☆☆☆) Declare int a = 10, int b = 20. Swap their values using a third variable.
//        int a = 10;
//        int b = 20;
//        int temp;
//        temp=a;
//        a=b;
//        b=temp;
//        (★★☆☆☆) Convert a temperature from Celsius to Fahrenheit: F = C * 9/5 + 32.
//        int celsius = 50;
//        int fahrenheit = celsius * 9/5 + 32;
//        (★★☆☆☆) Create 3 variables: name, age, isStudent. Print a sentence like: "Alice is 21 years old. Student? true"
//        String name = "Alice";
//        int age = 18;
//        boolean isStudent = true;
//        System.out.println(name + "is" + age + "Student?" + isStudent);
//        (★★☆☆☆) Use constants: declare a final double PI = 3.14159 and calculate the area of a circle.
//        final double PI = 3.14159;
//        non mi ricordo la formula...
//        (★★★☆☆) Format a double to show only 2 decimal places when printing (e.g., 2.34567 → 2.35).
//        Double nums = 2.342342;
//        da rivedere
//        (★★★☆☆) Create a program that takes 3 numbers (hardcoded), adds them, and finds the average.
//        hardcoded? help
//        (★★★★☆) Calculate the BMI: weight / (height * height) where weight is in kg and height in meters.
//        double weight = 102.5;
//        double height = 190.4;
//        double bmi = weight/(height*height);;

//        (★★★★★) Build a simple “currency converter” (hardcoded): convert EUR to USD using a variable exchange rate.
//        hardcoded again ?!
//        🔀 Java Exercises – If Statements
//📗 Level: Beginner to Intermediate
//        (★☆☆☆☆) Check if a number is positive. If yes, print "Positive".
//        int a = 112;
//        if(a % 2 == 0 ) {
//            System.out.println("is positive");
//        }
//        (★☆☆☆☆) Check if someone is old enough to vote (age >= 18).
//        int age = 21;
//        if(age >= 18){
//            System.out.println("is an adult");
//        }
//        (★☆☆☆☆) Determine if a number is even or odd using %.
//        int num1= 112;
//        if(num1 % 2 == 0){
//            System.out.println("is even");
//        }else {
//            System.out.println("is odd");
//        }
//        (★★☆☆☆) Compare two integers and print which one is larger (or if they’re equal).
//        int a = 10;
//        int b = 22;
//        if(a > b){
//            System.out.println(a + "is bigger");
//        }else if (a == b){
//            System.out.println("equals");
//        }else{
//            System.out.println(b + "is bigger");
//        }
//        (★★☆☆☆) Create a simple login check: if username == "admin" and password == "1234", print "Welcome".
//        String username = "admin";
//        String password = "1234";
//        if(username.equals("admin") && password.equals("1234")){
//            System.out.println("Welcome");
//        }else{
//            System.out.println("access denied");
//        }
//        (★★★☆☆) Grade checker: use if-else to print letter grades (A, B, C…) based on a score (0–100).

//        (★★★☆☆) Check if a number is divisible by both 3 and 5 (FizzBuzz-style logic).
//        (★★★★☆) Compare three numbers and print the largest one.
//        (★★★★☆) Create a basic discount system: if total > 100, apply 10% discount, else 5%.
//        (★★★★★) Simulate a traffic light system using a String variable ("green", "yellow", "red") and print appropriate actions (e.g., "Go", "Slow down", "Stop").
//        li ignoro che so farli
//        🔁 Java Exercises – Loops (for, while, do-while)
//📗 Level: Beginner to Intermediate
//        (★☆☆☆☆) Use a for loop to print numbers from 1 to 10.
//        for(int i = 1 ; i <=10 ; i++){
//            System.out.println(i);
//        }
//        (★☆☆☆☆) Use a while loop to count down from 5 to 1.
//        int i = 5;
//        while(i>1){
//            i--;
//            System.out.println(i);
//        }
//        (★☆☆☆☆) Print the first 10 even numbers using a for loop.
//        for(int i = 0; i<20;i++){
//            if (i%2 == 0){
//                System.out.println(i);
//            }
//        }
//        (★★☆☆☆) Calculate the sum of numbers from 1 to 100 using a loop.
//        int sum;
//        for(int i = 1;i < 100;i++ ){
//            sum+= i;
//        }
//        System.out.println(sum);
//        (★★☆☆☆) Print a multiplication table for number 5 (e.g., 5 × 1 = 5 … 5 × 10 = 50).
//        int tot = 5;
//        for(int i = 1;i <=10 ;i++){
//            tot = tot*i;
//        }
//        (★★★☆☆) Use a do-while loop to prompt a number input until the user enters a positive number (simulate with hardcoded values for now).
//        Scanner input = new Scanner(System.in);
//        int userinput;
//        do {
//            userinput = input.nextInt();
//            }while(userinput < 0);
//        }
//        (★★★☆☆) Find the factorial of a number using a loop (e.g., 5! = 5×4×3×2×1).
//        (★★★★☆) Use a loop to reverse an integer (e.g., 1234 → 4321).
//        Array? non è ancora il topic
//        (★★★★☆) Print all prime numbers from 1 to 50.
//        for(int i = 0; i <=50 ; i++) {
//            if(!(i%2 == 0) && !(i%3 == 0)){
//                System.out.println(i);
//            }
//        }
//        (★★★★★) Print a simple pyramid of * using nested loops:
//        for(int i = 0 ; i< 3 ; i++){
//            System.out.println("*");
//            for(int j = 0 ; j<2;j++){
//                System.out.println("*");
//                for(int k = 0 ; k<1;k++){
//                    System.out.println("*");
//                }
//            }
//        }non va pace cosi
//        📗 Level: Beginner to Intermediate
//        (★☆☆☆☆) Create a method sayHello() that prints "Hello World!".
//        (★☆☆☆☆) Write a method addNumbers(int a, int b) that returns the sum.
//        (★☆☆☆☆) Create a method isEven(int number) that returns true if the number is even.
//        (★★☆☆☆) Write a method greetUser(String name) that prints "Hello, [name]!".
//        (★★☆☆☆) Create a method max(int a, int b) that returns the larger of two numbers.
//        (★★★☆☆) Write a method calculateAreaOfCircle(double radius) using the formula Area = PI * r².
//        (★★★☆☆) Make a method factorial(int n) that calculates factorial recursively (calls itself!).
//        (★★★★☆) Write a method isPrime(int number) that returns true if the number is prime.
//        (★★★★☆) Create a method reverseString(String s) that returns the string reversed.
//        (★★★★★) Create a method drawPyramid(int height) that draws a * pyramid of custom height (reuse your knowledge from loops!).
//    }
//    void sayHello(){
//        System.out.println("Hello World");
//    }
//    int addnumers(int a , int b){
//        int c = a+b;
//        return c;
//    }
//    void isEven(int a){
//        if(a%2 == 0){
//            System.out.println("is even");
//        }
//    }
//    void greetUser(String name){
//        System.out.println("Hello, " + name);
//    }
//    int maxNum(int a,int b){
//        if(a > b){
//            System.out.println(a);
//        }else if (b > a){
//            System.out.println(b);
//        }else{
//            System.out.println("equals");
//        }
//    }
//    double calculateArea(double radius){
//        double pi = 3.14;
//        double area = pi * (radius*radius);
//        return area;
//    }
//    boolean isPrime(int n){
//        if(!(n%2 ==0) && !(n%3 == 0)){
//            return true;
//        }else{
//            return false;
//        }
//    }
//    String reverseString(String word){
//        StringBuilder sb = new StringBuilder(word);
//        return sb.reverse().toString();
//    }
//        Arrays
//        (★☆☆☆☆) Create an array of 5 integers and print each element using a for loop.
//        int[] array = {1,2,3,4,5};
//        for(int i = 0 ; i< array.length ; i++){
//            System.out.println(array[i]);
//        }
//        (★☆☆☆☆) Find the sum of all elements in an integer array.
//        int[] nums = {2,4,6,8,10};
//        int sum;
//        for(int i = 0;i < nums.length;i++){
//            sum += nums[i];
//        }
//        (★☆☆☆☆) Find the maximum value in an integer array.
//        int[] nums = {1,5,2,7,11,4};
//        int max;
//        for(int i = 0 ; i<nums.length;i++){
//            if(nums[i] > max){
//                max = nums[i];
//            }
//        }
//
//        (★★☆☆☆) Check if an array contains a specific value (e.g., search for number 5).
//        int[] nums = {1,5,8,11,22};
//        int checknum = 5;
//        for(int i = 0 ; i<nums.length;i++){
//            if (checknum == nums[i]){
//                System.out.println(true);
//            }
//        }
//        (★★★☆☆) Reverse an array without using extra libraries.
//        int[] nums = {1, 3, 6, 9, 11};
//        int[] numreverse = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            numreverse[i] = nums[nums.length - 1 - i];
//        }
//        for (int num : numreverse) {
//            System.out.print(num + " ");
//        }
//        (★★★☆☆) Sort an array manually (e.g., bubble sort, basic version).
//        int[] nums = {33,11,4,1,56};
//        Arrays.sort(nums);
//        int[] sorted = new int {nums.length};
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = 0; j < nums.length - i - 1; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    // Swap nums[j] and nums[j+1]
//                    int temp = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = temp;
//                }
//            }
//        }
//        (★★★★☆) Count how many times a specific number appears in an array.
//        int [] nums = {1,5,5,22,5};
//        int counter = 0;
//        for(int i = 0 ; i < nums.length;i++){
//            if(nums[i] == 5){
//                counter++;
//            }
//        }
//        System.out.println(counter);
//        (★★★★☆) Find and print only the even numbers from an array.
//        int[] nums = {2,55,100,1232,19,24};
//        for(int i = 0 ; i < nums.length ; i++){
//            if(nums[i] % 2 == 0){
//                System.out.println(nums[i] +"is Even");
//            }else{
//                System.out.println(nums[i] + "is odd");
//            }
//        }
//        (★★★★★) Merge two arrays into a third one (append all elements).
//        int[] nums = {1,2,3};
//        int[] nums2 = {3,2,1};
//        int[] tot = new int[nums.length + nums2.length];
//        for(int i = 0;i < nums.length ; i++){
//            tot[i] = nums[i];
//        }
//        for(int i = nums.length; i < tot.length; i++ ){
//            tot[i] = nums2[i - nums.length];
//        }
//        for(int numbers : tot){
//            System.out.println(numbers + " ");
//        }
//        🧹 Exception Handling Exercises (Java) 1. (★)
//        Write a simple try-catch block that tries to divide 10 by 0, and catches the ArithmeticException.
//                Print "Cannot divide by zero".
//        try{
//            int c = 5/0;
//        } catch (ArithmeticException e) {
//            System.out.println("cannot divde by 0");
//        }
//        2. (★)
//        Create a method that parses an integer from a String.
//        Use try-catch to handle the case where the string is not a number (like "hello").
//                If it fails, print "Invalid number".
//        try{
//            String s = "Hello";
//            int num = Integer.parseInt(s);
//        } catch (Exception e) {
//            System.out.println("invalid number");
//        }
//        3. (★★)
//        Write a method that reads an element from an array by index.
//        Use try-catch to handle ArrayIndexOutOfBoundsException and print "Invalid index" if the index is wrong.
//        int[] nums = new int [5];
//        try{
//            System.out.println(nums[12]);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("invalid index");
//        }
//        4. (★★)
//        Use a finally block after a try-catch.
//        Print "Finished trying" inside the finally, no matter if an exception happened or not.
//        try{
//            int a = 2+2;
//        } catch (Exception e) {
//            System.out.println("invalid math");
//        }finally {
//            System.out.println("finished trying");
//        }
//
//        6. (★★★)
//        Create your own custom exception class called TooSmallException.
//        If a given number is less than 10, throw this exception.
//        7. (★★★)
//        Write a method that asks the user for a number (simulate input with a String).
//        If the number is negative, throw a RuntimeException saying "Negative numbers not allowed".
//        8. (★★★★)
//        Catch multiple exceptions in one try block:
//        First try to divide two numbers, then access an array index.
//        Catch both ArithmeticException and ArrayIndexOutOfBoundsException separately.
//        9. (★★★★)
//        Create a program that keeps asking for a valid integer until the user gives it (simulate with strings).
//        Use a while(true) loop and try-catch inside.
//        10. (★★★★★)
//        Write a method that reads a file (simulate with a String filename and a fake "if" check).
//                If the file is "missing.txt", throw a FileNotFoundException.
//                Catch it and print "File not found", otherwise print "File loaded".
      }
      //(★★☆☆☆) Create a method doubleArray(int[] arr) that returns a new array with each value doubled.
//    int[] doubleArray(int[] arr){
//        int[] temp = new int[arr.length];
//        for(int i = 0 ; i < arr.length; i++){
//            temp[i] =arr[i] * 2;
//        }
//        return temp;
//    }
//    5. (★★★)
//        Create a method divide(int a, int b) that divides two numbers.
//        If b == 0, throw an IllegalArgumentException yourself using throw new IllegalArgumentException("Divider cannot be zero");.

//    static int divide(int a, int b) {
//        if (b == 0) {
//            throw new IllegalArgumentException("Divider cannot be zero");
//        }else {
//            return a / b;
//        }
    }
//
}
