public class ArrayExamples {
    public static void main(String[] args) {
        int[] numbers = new int[5]; 
        // int numbers2[] = new int[5]; //le quadre dell'array possono essere inserite sia nel nome della variabile che nel tipo in java. 
        //                              //sul tipo son più comuni.
        // int x = 10;
        // int[] numbers3 = new int[x];
        //  System.out.println(numbers[1]);
        //  System.out.println(numbers[4]);
        //  System.out.println(numbers);
        //  numbers[1] = 100;
        //  numbers[4] = 200;
        //  for(int i = 0; i < numbers.length; i++) {
        //     System.out.println("posizione: " + i + " valore: " + numbers[i]);
        // }   //introduzione al ciclo foreach
        // for(int n: numbers)  {
        //    System.out.println(n);
        // }


        //inserisci dentro l'array numbers i quadrati dei numeri da 1 a 5
    
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (i + 1)*(i + 1);
        }
        for(int n : numbers) {
            System.out.println(n);
        }
          //calcolare e stampare la somma di tutti i valori che sono nell'array numbers.
         int sum = 0;
        for(int j = 0; j < numbers.length; j++) {
            sum += numbers[j];
            
        }
        System.out.println("la somma degli array è: " + sum);
        
        //Trova il massimo numero in un array
        int biggestNumber = 0;
        for(int n: numbers) {
            if(n > biggestNumber) {
                biggestNumber = n;
                
            }
            
        }


        //Stampa il numero di numeri pari all'interno dell'array
        int counter = 0;
        for(int n: numbers) {
            if(n % 2 == 0) {
                counter++;
            }
        }
        System.out.println(counter);


        //Stampa il numero di volte che il numero z è contenuto nell'array numbers
        int counter2 = 0;
        int z = 4;
         for(int n:numbers) {
            if(n == z ) {
            counter2++;
            }

        }
        //Verifica se i numeri sono ordinati in ordine crescente se non è cosi stampa "l'array non è in ordine crescente"
       
        for(int i = 1; i < numbers.length; i++) {
            if(numbers[i] < numbers[i-1]) { 
                System.out.println("l'array non è in ordine crescente");
                break;
            }
        }
        //fai un ciclo for che stampi gli elementi dell'array sulla stessa riga
        for(int n:numbers) {
            System.out.print(n + " ");
        }
        //"voglio del codice che crea un array di 5 elementi che contenga gli stessi valori dell'array numbers ma al contrario"
        System.out.println(); //linea di spazio dall'esercizio precedente
        int[] reversedArray = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            reversedArray[i] = numbers[numbers.length-1-i];
            System.out.print(reversedArray[i] + " ");

        }
        //stesso esercizio di sopra ma mostrato con due indici
        for(int f = numbers.length-1,  r = 0; r < numbers.length; f--, r++) {
            numbers[r] = reversedArray[f];

        }
        //inverti l'array numbers sovrascrivendolo
        for (int f = numbers.length -1, r = 0; r < numbers.length; f--,r++) {
            int temp = numbers[r];
            numbers[r] = numbers[f];
            numbers[f] = temp;
            if(r < f) {
                break;
            }
                
        }
        
        
    }

}
