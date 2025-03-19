









public class ArrayExercises {
	public static void main(String[] args) {
		//Ex 01 Creare un array di 5 interi ed inizializzarlo con le potenze al qaudrato dei primi 5 numeri.
		int[] numbers = new int[5];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (i + 1) * (i + 1);
		}

		//Ex 02 Calcolare e stampare il valore della somma di tutti i numeri degli array.
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		System.out.println("La somma dei numeri dell'array è: " + sum);

		//Ex 03 Calcolare e stampare il valore minimo contenuto all'interno dell'array.
		//numbers[2] = -8;  Per verificare se funziona
		int minValue = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < minValue) {
				minValue = numbers[i];
			}
		}
		System.out.println("Il valore minimo è: " + minValue);

		//Ex 04 Calcolare il valore medio dei numeri contenuti nell'array (somma diviso numero dei valori, sarà un double)
		double medValue = sum / (numbers.length);
		System.out.println("Il valore medio dei numeri nell'array è: " + medValue);

		//Ex 05 Calcolare e stampare il numero di multipli di 2 nell'array.
		int counter = 0;
		for (int i = 0; i < numbers.length; i++) {
			if ((numbers[i] % 2) == 0) {
				counter++;
			}
		}
		System.out.println("Il numero dei multipli di 2 è: " + counter);


		//Ex 06 Dato un valore arbitrario del tipo int x = 4, calcolare e stampare il numero di volte in cui l'array lo contiene.
		
		//numbers[1] = 25;       prova per testare
		int z = 25;
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == z) {
				count++;
			}
		}
		System.out.print("Il numero di volte che il valore " + z);
		System.out.println(" è contenuto è: " + count);

		//Ex 07 Invertire l'array e stamparlo.
		for (int i = 0, j = (numbers.length - 1); i < j; i++, j--) {
			int tmp;
			tmp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = tmp;
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println("");

		
		//Ex 08  Dato un valore arbitrario int z = 8, verificare quante volte nell'array esistono due numeri consecutivi la cui somma fa z.
		
		int a = 13;
		int counter_a = 0;
		for (int i = 1; i < numbers.length; i++) {
			if ((numbers[i] + numbers[i - 1]) == a) {
				counter_a++;
			}
		}
		System.out.print("Il numero di volte in cui la somma di due elementi consecutivi danno il valore " + a);
		System.out.println(" è " + counter_a);

		//Ex 09  Verificare che nell'array non esistano 3 numeri consecutivi la cui somma è maggiore di 12.
		boolean sum_greater_12 = false;
		for (int i = 2; i < numbers.length; i++) {
			if ((numbers[i] + numbers[i - 1] + numbers [i -2]) > 12) {
				sum_greater_12 = true;
			}
		}
		System.out.println("Nell'array esistono 3 valori consecutivi la cui somma è maggiore di 12: " + sum_greater_12);

		
		//Ex 10 Trovare il numero che appare più volte nell'array - {2, 7, 12, 7, 1}. Se c'è un pareggio ne può stampare uno a caso.
		
		int mostFound = numbers[0];
		int maxCount = 0;
		numbers[1] = 4; //Così 4 dovrebbe essere il num più trovato
		for (int i = 0; i < numbers.length; i++) {
			int count_value = 1;
			for (int j = (i + 1); j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					count_value++;
				}
				if (count_value > maxCount) {
				maxCount = count_value;
				mostFound = numbers[i];
				}
			 }
		}
		System.out.print("Il numero trovato più volte é " + mostFound);
		System.out.println(" trovato un numero di volte pari a " + maxCount);
	}
}