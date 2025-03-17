public class ArrayExamples {
    public static void main(String[] args) {
        int numbers[] = new int[5];

        //Traccia esercizio 1: Voglio inserire dentro l'array numbers i quadrati dei numeri da 1 a 5

        //Inseriamo nell'array numbers[] i numeri interi da 1 alla lunghezza dell'array (5 in questo caso)
        //E calcoliamo il quadrato di ogni valore e lo sostituiamo nell'array numbers[]
        System.out.println("\nQuadrati dei numeri in numbers[]:");
        for(int i=0; i<numbers.length; i++){
            // numbers[i] = i+1; // Valori da 1 alla lunghezza dell'array
            // numbers[i] *= i+1; // Quadrati dei valori 

            numbers[i] = (i+1)*(i+1); // Abbreviazione di quello fatto sopra
            System.out.println("- numbers["+i+"]: "+numbers[i]);
        }

        //Traccia esercizio 2: Calcolare e stampare la somma di tutti i valori all'interno dell'array numbers[]

        int sum = 0; // Variabile che conterrà il valore della somma

        System.out.print("\nSomma dei valori in numbers[]: ");
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i]; // La somma è uguale al valore della somma + il valore nell'array a quella posizione
        } 
        System.out.println(sum);
    }
}
