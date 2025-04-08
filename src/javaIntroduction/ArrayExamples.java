package javaIntroduction;

public class ArrayExamples {
	public static void main(String[] args) {
		int[] numbers = new int[5]; //prof preferisce quadre sul tipo
		/* int numbers2[] = new int [5]; //le quadre vanno bene sia sul tipo che sul nome
		int x = 10;
		int[] numbers3 = new int[x];
		System.out.println(numbers[0]);
		System.out.println(numbers[4]);
		//System.out.println(numbers[5]); Mi darà errore quando eseguo
		System.out.println(numbers);
		numbers[1] = 100; //Assegno il valore 100 alla seconda posizione
		numbers[4] = 200; //Assegno 200 all'ultima posizione
		for(int i = 0; i < numbers.length; i++) {
				//System.out.println(numbers[i]);   //Così stampo tutti i valori
				System.out.println("Posizione: " + i + " Valore: " + numbers[i]);
		}
		for (int n : numbers) {
				System.out.println(n);   //nuovo tipo di ciclo
		}*/
		
		//Voglio andare ad inserire in numbers i quadrati dei numeri da 1 a 5;
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (i + 1) * (i + 1);
		}
		for (int n : numbers) {
			System.out.println(n);
		}
		
		//Voglio calcolare e stampare la somma di tutti i valori nell'array numbers
		int sum = 0;
		for (int j = 0; j < numbers.length; j++) {
			sum += numbers[j];
		}
		System.out.println(sum);

		//Voglio calcolare il numero massimo e stamparlo
		int max = numbers[0];
		for (int k = 1; k < numbers.length; k++) {
			if (max < numbers[k]) {
				max = numbers[k];
			}
		}
		System.out.println(max);

		//Voglio calcolare e stampare il numero di numeri pari presenti nell'array
		int even_nums = 0;
		for (int i = 0; i < numbers.length; i++) {
			if ((numbers[i] % 2) == 0) {
				even_nums++;
			}
		}
		System.out.println(even_nums);


		//VOGLIO Calcolare e stampare il numero di volte che il numero z è contenuto nell'array
		int z = 4;
		int counter = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 4) {
				counter++;
			}
		}
		System.out.println(counter);

		//Voglio verificare se i numeri nell'array sono ordinati in maniera crescente
		boolean sorted = true;
		//numbers[2] = 10000; ad esempio facendo così uscirebbe false
		for (int i = 0; i < (numbers.length - 1); i++) {
			if (numbers[i] > numbers[i+1]) {
				sorted = false;
				break; //una volta che so che non è ordinato posso uscirmene con break
			}
		}
		if(sorted) { //vuol dire che è uguale true
			System.out.println("L'array è ordinato");
		} else {
			System.out.println("L'array non è ordinato");
		}

		//Fare un ciclo for che stampi tutti gli elementi separati da spazi, non a capo
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println(""); //giusto per andare a capo alla fine

		//Voglio creare un altro array di 5 elementi che contenga gli stessi valori di numbers ma al contrario
		int[] reverse = new int [numbers.length];
		for (int i = 0; i < reverse.length; i++) {
			reverse[i] = numbers[numbers.length - 1 - i];
			System.out.print(reverse[i] + " ");
		} 
		System.out.println("");
		// O posso utilizzare due puntatori o indici
	/*	for (int f = numbers.length - 1, r = 0; r < numbers.length; f--, r++) {
			numbers[r] = reverse[f];
		}*/

		//Voglio invertire numbers, sovrascrivendolo
		int tmp;
		for (int i = 0, j = numbers.length - 1; i < j; i++, j--) {
			tmp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = tmp;
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}
