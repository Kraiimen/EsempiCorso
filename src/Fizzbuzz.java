public class Fizzbuzz {
	public static void main (String[] args) {
		for (int num = 1; num <= 100; num++) {
			if (((num % 3) == 0) && ((num % 5) == 0)) {
				System.out.println("Fizzbuzz");
			}
			else if ((num % 3) == 0) {
				System.out.println("Fizz");
			}
			else if ((num % 5) == 0) {
				System.out.println("Buzz");
			}
			else {
				System.out.println(num);
			}
		}
	}
}

/*
Fizzbuzz
Voglio un programma che stampi i primi 100 numeri
Se il numero è un numero di 3 deve stampare fizz
Se è un multiplo di 5 deve stampare buzz
Se è un multiplo sia di 3 che di 5 deve stampare fizzbuzz
Se non è vera nessuna di queste condizioni non deve stampare nulla
*/