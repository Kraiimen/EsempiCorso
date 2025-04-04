import java.io.Console;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Ess {
    public static void main(String[] args) {
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
    }
}
