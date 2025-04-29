public class ArrayExamples{
    public static void main(String[] args){

        int[] numbers = new int[5]; //new keyword per creare oggetti, il professore preferisce in questo modo
        // int numbers2[] = new int [5]; //stessa cosa
        ////java quando crea un array inizializza ogni cella al suo interno con il valore di default del tipo, nel caso degli interi è 0
         ////il primo elemento di un array sta all'indice 0 e l'ultimo alla sua lunghezza-1, in questo caso 4
        // System.out.println(numbers[0]);
        // System.out.println(numbers[4]);
         ////System.out.println(numbers[5]); errore in fase di compilazione IndexOutOfBounds
        // System.out.println(numbers); //ci stampera l indirizzo in memoria in esadecimale e il tipo dell oggetto.
        // numbers[1] = 100;
        // numbers[4] = 200;
        // for (int i = 0; i < numbers.length; i++){
        //     System.out.println(numbers[i]);
        // }
        //for each 
        // for(int n : numbers){
        //         System.out.println(n);
        // }
        

        //Inseriamo dentro numbers i quadrati dei numeri da 1 a 5 
        for(int i = 0; i < numbers.length;i++){
            
            numbers[i] = (i+1)*(i+1);

        }
        for(int element : numbers){
            System.out.println(element);
        }
        //cacolare e stampare la somma tutti i valori array numbers
        int sum = 0;
        for(int element : numbers){
            sum += element;
        }
        System.out.println("La somma è: "+ sum);


        //trovare il massimo all interno di un array
        int max = numbers[0];
        for(int i = 1; i < numbers.length ;i++){

            if(numbers[i] > max){
                max = numbers[i];
            }
        }
        System.out.println("Il massimo è: " + max);


        // calcolare e stampare il numero di numeri pari
        int counter = 0;
        for (int x : numbers){
            if(x % 2 == 0){
                counter ++;
            }
        }
        System.out.println("Il numero di numeri pari in numbers è: "+ counter);
        //il numero di volte in cui z è contenuto nell array
        int z = 4;
        int counterZ = 0;
        for (int y : numbers){
            if(y == z){
                counterZ++;
            }
        }
        System.out.println("Ci sono "+ counterZ + " volte " + z);

        //codice che verifica se i numeri dell array sono ordinati in modo crescente
        boolean isSorted = true;
        for (int i = 1; i < numbers.length; i++){
            if(numbers[i-1] > numbers[i]){
                isSorted = false;
                break;
            }
        }
        System.out.println(isSorted);
        //ciclo for che mi stampa i numeri uno accanto all'altro 
        for(int n : numbers){
            System.out.print(n + " ");
        }
        // creare un altro array di 5 elementi che contenga gli stessi valori dell'array numbers ma al contrario
        //tecnica dei 2 indici semplificata guardare lezione 4 obsidian
        int[] reverseNumbers = new int[numbers.length];
        int reverseIndex = numbers.length -1;
        for(int i = 0; i < numbers.length; i ++){

            reverseNumbers[reverseIndex] = numbers[i];
            reverseIndex --;
        }
        System.out.print("\nArray rovesciato: ");
        for(int n : reverseNumbers){
            System.out.print(n + " ");
        }
        // inverti numbers, tecnica dei 2 indici
        for(int i = 0, r = numbers.length-1; i < r; i ++, r--){
            int temp = numbers[i];
            numbers[i] = numbers[r];
            numbers[r] = temp;
            
        }
        System.out.println("");
        for(int n : numbers){
            System.out.print(n + " ");
        }
    }

}