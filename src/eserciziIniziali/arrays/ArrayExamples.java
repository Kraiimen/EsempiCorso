package eserciziIniziali.arrays;

public class ArrayExamples{
    public static void main(String[] args){
        int[] numbers = new int[5]; // è un array di interi in grado di tenere 5 interi
        // int numbers2 [] = new int [5]; //  le [] servono per dichiarare l'array e dentro si dichiara la dimensione di essa
        // int x = 10;
        // int[] numbers3 = new int [x];

        // // java quando crea un array assegna di defaut un valore di numeri interi aka 0

        // System.out.println(numbers[0]);
        // System.out.println(numbers[4]);
        // System.out.println(numbers);
        
        // // se sfori la dimensione di un arrey java se ne accorge e ti dice l'errore 
        
        // numbers[1] = 100; // è il valore dell'array 2
        // numbers [4] = 200; // è il valore dell'array 5
        // for (int i = 0 ; i < numbers.length ; i++){ // inizio un ciclo, i parte da 0 e va fino all'erray
        
        // //  numbers.length ti dice la lunghezza di numbers, ++ aumenta di 1
        
        //     System.out.println("posizione: " + i + " valore: " + numbers [i]);
        // }
        // for(int n : numbers){ //per ogni intero n nella array numbers facciamo qualcosa a n
        //     System.out.println(n);
        // }

        //ESERCIZO
        // voglio inserire dentro l'array numbers i quadranti dei numeri da 1 a 5
        // numbers[0] = 1;
        // numbers[1] = 2*2;
        // numbers[2] = 3*3;
        // numbers[3] = 4*4;
        // numbers[4] = 5*5;

        for(int i = 0 ; i < numbers.length; i++ ){
            numbers[i] = (i + 1)*(i + 1);
        }
        for(int n : numbers){
            System.out.println(n);
        }
        //calcolare la somma di tutti i valori che sono nell'array numbers.
        int sum =0;
        for(int i = 0; i < numbers.length ; i++ ){
            sum = sum + numbers[i]; //inizialmente i vale 0, sum vale 0, sum equivale sum + numbers[1]
        }
        // mi creerò una variabile intera con nome max, inizializzo con il primo numbers dell'array
        // poi faccio un ciclo che parte dal secondo elemento dell'array fino alla fine dell'array 
        // per ogni valore dell'array, se il valore dell'array è maggiore del max aggiorno il valore del max 

        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            // se il numero in posizione i è maggiore di max, aggiornare il valore 
            if(numbers[i] > max){
                max = numbers[i]; // il numero più grande di max diventa il massimo
            }
        }
        System.out.println(max);

        // stampa il numero di numeri pari presenti nell'array
        int counter = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % 2 == 0){
                counter++;
            }
        }
        System.out.println(counter);

        // stampa quante volte il numero 4 compare nell'array
        int z = 4;
        int countValue = 0;
        for (int i = 0; i < numbers.length; i++){
            if(numbers[i] == z){
                countValue++;
            }
        }
        System.out.println(countValue);

        //verifica se i numeri dell'array sono ordinati in ordine crescente
        // immagina che l'array sia fatto così: 2, 7, 5, 8, 10
        boolean sorted = true;
        for(int i = 1; i < numbers.length; i++){ // metto l'array in numero crescente 
            if(numbers[i] < numbers[i-1]);{ // partendo dal secondo elemento va a paragonare con quello che sta prima. 
            // il numero in posizione i - 1 deve essere  minore del numbers i
                sorted = false; // se non avviene interrompe il ciclo se non sono in ordine, interrompendo il loop 
                break;
            }
        }
        if (sorted) {
            System.out.println("L'array è ordinato");
        } else {
            System.out.println("L'array non è ordinato");
        }

        // fai un ciclo for che stampi gli elementi dell'array sulla stessa riga
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }

        //voglio che il codice crei un altro array di 5 elementi che contenga 
        // gli stessi valori dell'array numbers ma al contrario
        int[] reverse = new int[numbers.length];
        for (int i = 0; i < reverse.length; i++){
            reverse[i] = numbers[numbers.length-1-i];
            System.out.println(reverse[i] + " ");
        }
        System.out.print("\n");

        //tecnica dei due indici
        for(int f = numbers.length-1, r = 0; r < numbers.length; f--, r++){
            numbers[r] = reverse[f];
        }
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }

        //inverti l'array numbers sovrascivendolo
        for (int f = numbers.length-1, r = 0; r < numbers.length; f--, r++){
            int temp = numbers[r]; // l'esempio dei 3 bicchieri
            numbers[r] = numbers[f];
            numbers[f] = temp;
        }
    }

}