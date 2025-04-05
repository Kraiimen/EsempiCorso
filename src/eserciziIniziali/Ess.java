package eserciziIniziali;

public class Ess {
    public static void main(String[] args){
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
            

        
       

    
    }
}