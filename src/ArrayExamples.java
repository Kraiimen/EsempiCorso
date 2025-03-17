//inserire in numbers i quadrati dei primi 5 numeri
//calcola e stampa la somma di tutti i valori dell'array numbers
//trovare il max nell'array
//stampa il numero di numeri pari presenti nell'array
//conta il numero di 4 presenti nell'array
//verifica se i valori sono in ordine crescente
public class ArrayExamples {
    public static void main(String[] args) {
        int[] numbers = new int[5];                                //crea un array di tipo intero
        int sum=0;                                                 //crea una variabile per contenere la somma dei valori dell'array
        int max=0;                                                 //crea una variabile max che conterrà il numero massimo
        boolean state = true;                                      //crea una variabile boolean e la imposta a true
        int counter=0;                                             //crea una variabile intera come contatore dei numeri pari
        int CounterOf4=0;                                          //crea una variabile intera come contatore dei valori uguali a 4
        boolean sorted = true;                                     //crea una variabile boolean e la imposta a true

        //ciclo for per controllare ogni valore dell'array
        for(int n=0; n< numbers.length ; n++){
            numbers[n] = (n+1)*(n+1);                              //dentro ogni cella dell'array inserisco il quadrato del numero
            sum += numbers[n];                                     //esegue la somma dei valori dell'array (valore per valore)

            //prende il primo numero dell'array e lo imposta come valore massimo
            if(state){
                max = numbers[n];
                state = false;                                     //imposta la variabile a false in modo tale da non ripetere l'if
            }

            //controlla se il valore nella cella è maggiore del valore massimo e lo imposta come massimo
            if(numbers[n] >= max){
                max = numbers[n];
            }else{
                sorted=false;
            }
            if(numbers[n]%2==0){                                   //conta i numeri pari
                counter++;
            }
            if(numbers[n]==4){                                     //conta i valori uguali a 4
                CounterOf4++;
            }
            System.out.println(numbers[n]);                        //stampa l'array
        }
        System.out.println("numero massimo: "+ max);               //stampa il massimo
        System.out.println("somma: "+ sum);                        //stampa la somma
        System.out.println("numero di valori pari: "+ counter);    //stampa il numero di valori pari

        //stampa una stringa che spiega se l'array è in ordine crescente o meno a seconda del valore di boolean "sorted"
        if(sorted){
            System.out.println("l'array è in ordine crescente");
        }else{
            System.out.println("l'array non è in ordine crescente");
        }

        //ciclo for per stampare gli elementi sulla stessa riga
        for(int i : numbers){
            System.out.print(i+ " ");
        }

        //crea un altro array di 5 elementi che contenga gli stessi valori dell'array number ma al contrario
        int[] reverse = new int[numbers.length];
        int j=0;
        for(int i = 0; i < numbers.length ; i++){
            reverse[i] = numbers[numbers.length-1-i];
        }
        System.out.println("\n");                                   //stampa "a capo" per ordinare meglio l'output


        //stampa l'array reverse
        for(int i : reverse){
            System.out.print(i+ " ");
        }

        //tecnica dei due indici
        for(int f = numbers.length-1, r=0; r< numbers.length; f--, r++){
            numbers[r]=reverse[f];
        }
        
        //inverte numbers
        for(int f = numbers.length-1, r=0; r < f; f--, r++){
            int temp = numbers[r];
            numbers[r]=numbers[f];
            numbers[f]= temp;
        }
        
    }
}