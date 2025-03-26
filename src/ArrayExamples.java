public class ArrayExamples {
    public static void main(String[] args) {
        int numbers[] = new int[5];

        // Traccia esercizio 1: Voglio inserire dentro l'array numbers i quadrati dei numeri da 1 a 5

        // Inseriamo nell'array numbers[] i numeri interi da 1 alla lunghezza dell'array (5 in questo caso)
        // E calcoliamo il quadrato di ogni valore e lo sostituiamo nell'array numbers[]
        System.out.println("\nQuadrati dei numeri in numbers[]:");
        for(int i=0; i<numbers.length; i++){
            // numbers[i] = i+1; // Valori da 1 alla lunghezza dell'array
            // numbers[i] *= i+1; // Quadrati dei valori 

            numbers[i] = (i+1)*(i+1); // Abbreviazione di quello fatto sopra
            System.out.println("- numbers["+i+"]: "+numbers[i]);
        }
        
        // Traccia esercizio 2: Calcolare e stampare la somma di tutti i valori all'interno dell'array numbers[]

        int sum = 0; // Variabile che conterrà il valore della somma

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i]; // La somma è uguale al valore della somma + il valore nell'array a quella posizione
        } 

        System.out.println("\nSomma dei valori in numbers[]: "+sum);

        // Traccia esercizio 3: Calcolare e stampare il numero più grande

        int max = numbers[0]; // Dichiariamo max e lo inizializziamo al primo valore dell'array numbers[]

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        } 

        System.out.println("\nMassimo tra i valori in numbers[]: "+max);

        //Traccia esercizio 4: Calcola e stampa il numero di numeri pari presenti nell'array
        int evenNumbers = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumbers++;
            }
        } 

        System.out.println("\nNumero di numeri pari in numbers[]: "+evenNumbers);

        //Traccia esercizio 5: Dichiara una variabile z e conta quanti valori in numbers[] sono uguali al valore di z
        int z = 4;
        int countValue = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == z) {
                countValue++;
            }
        } 

        System.out.println("\nNumero valori uguale a z in numbers[]: "+countValue);

        //Traccia esercizio 6: Verifica se numbers[] è ordinato in ordine crescente e stampa il risultato

        boolean isSorted = true;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i+1]) {
                isSorted = false;
                break;
            }
        } 

        System.out.println("\nI valori in numbers[] sono in ordine crescente: "+isSorted);

        //Traccia esercizio 7: Un ciclo for che mi stampi i valori su una riga separati da uno spazio

        System.out.print("\nValori in numbers[] su una riga: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        //Traccia esercizio 8: Voglio del codice che creai un array di 5 elementi
        //con gli stessi valori di numbers[] ma al contrario
        int reversedNumbers[] = new int[numbers.length];

        System.out.print("\nValori in reversedNumbers[]: ");

        for (int i = 0; i < reversedNumbers.length; i++) {
            reversedNumbers[i] = numbers[numbers.length - 1 - i];
            System.out.print(reversedNumbers[i] + " ");
        }

        //Tecnica dei due puntatori o due indici
        System.out.print("\nValori in numbers[] al ri-contrario con due indici: ");

        for (int i = 0, j = numbers.length - 1; i < numbers.length; i++, j--) {
            numbers[i] = reversedNumbers[j];
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        //Traccia esercizio 8: invertire numbers[] sovrascrivendolo

        System.out.print("\nNumbers[] invertito: ");
        for (int i = 0, j = numbers.length - 1; i < numbers.length; i++, j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

    }
}
