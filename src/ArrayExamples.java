public class ArrayExamples {
    public static void main(String[] args) {
         int[] numbers = new int[5]; // 1 metodo più usato
        // int numbers2[] = new int[5]; // 2 metodo per dichiarare l 'array
        // int x = 10;
        // int[] numbers3 = new int[x];
        // System.out.println(numbers[0]); // equivale a 0
        // System.out.println(numbers[4]); // equivale a 4 perche si partee semptre dallo zero
        // System.out.println(numbers);
        // numbers[1] = 100;
        // numbers[4] = 200;

        // for (int i = 0; i < numbers.length; i++) {
        //     System.out.println("Posizione: " +   i  + " Valore " + numbers[i]); 
        // }
        // for (int n : numbers){    // Secondo metodo per visualizzare l array
        //     System.out.println(n);
        // } 

    //    numbers[0] = 1;
    //    numbers[1] = 2*2;
    //    numbers[2] = 3*3;   
    //    numbers[3] = 4*4;
    //    numbers[4]= 5*5
        // serve per calcolare le potenza per ogni numero dell array corrispondente all
       for (int i = 0 ; i < numbers.length; i++){
           numbers[i] = (i+1)*(i+1);
           System.out.println(numbers[i]);
       }   
       for( int n : numbers){
          System.out.println(n);
       }

       // calcolare e stampare la somma di tutti i valori che sono nell array numbers

       int sum = 0;
       for (int i = 0 ; i < numbers.length; i++){
           sum = sum + numbers[i];
          System.out.println(sum);
       }
      // calcolare e stampare il massimo di tutti i valori

         int max = numbers[0];
         for (int i = numbers[1] ; i < numbers.length; i++){
            if(numbers[i] > max){
                max = numbers[i];
                System.out.println(max);
            }
        }

        // calcolare e stampare il numero dei numeri pari nell array
       int counter = 0;
       for(int i = 0 ; i < numbers.length; i++){
            if( numbers[i] % 2 ==0){
                counter++; // aumento ill contatore del pari
            }

       }
      
        System.out.println(counter);

         // in questo studio vediamo quante volte il 4 è presnete nell'array
        int z = 4;
        int countValue= 0;
        for(int i = 0 ; i < numbers.length; i++){
            if(numbers[i] == z)
              countValue++;
        }
        System.out.println(countValue);

        // Verfichiamo se il numero dell array sono oridnate in ordine crescente
        boolean sorted = true;
        for(int i = 1 ; i < numbers.length; i++){
            if(numbers[i] < numbers[i-1]){  // si legge da destra se il numero precedente[i-1] è minore del numero davanti [numbers I]
                sorted=false;  // se non è maggiore del precedente sorted == false
                break; // se sorted è false chiudi il programma non è ordinato
            }

        }
        if(sorted){
            System.out.println("l'array è ordinato");
        } else{
            System.out.println("l'array non è ordinato");
        }

        // voglio fare un ciclo for che stampa gli elementi dell array sulla stessa riga
        for(int i = 0 ; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }

        // crea un altro array di 5 elementi che contegna gli stessi valori dell arrray number ma al contrario
        int [] reverse = new int[numbers.length]; // abbiamo dato il valore del numero length
        for(int i = 0 ; i < reverse.length; i++){
            reverse[i] = numbers[numbers.length-1-i]; // prende l array 
            System.out.println(reverse[i]+ " ");
        }

        // tecnica dei due indici/ puntatori
        for ( int f = numbers.length - 1,  r =0; r < numbers.length; f-- , r++){
        numbers[r]= reverse[f];
        }


        // scambio simmetrico dell array numbers sovrascrivendolo
        for ( int f = numbers.length - 1,  r =0; r < f ; f-- , r++){
            int temp = numbers[r]; // temp è assegnato al valore di r nell array cioè 0
            numbers[r]= numbers[f]; // poi in number 0 gli assegno 4
            numbers[f] = temp; // in F salviamo quello che abbiamo salvato in temp
            System.out.println(temp);
        }    
       


    }

}
