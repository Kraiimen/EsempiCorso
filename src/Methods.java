import java.io.Console;

public class Methods{
	public static void main(String[] args) {
	/*	Console console = System.console();

		System.out.print("Dammi un numero > ");
		String input1 = console.readLine();
		int x1 = Integer.parseInt(input1);
		System.out.print("Dammi un numero > ");
		String input2 = console.readLine();
		int x2 = Integer.parseInt(input2); */

		int x1 = readInteger();
		int x2 = readInteger();
		int result = sum(x1, x2); //salvo l'output di sum in result

		System.out.println("La somma dei due numeri è " + (x1 + x2));
		System.out.println("La somma dei due numeri è " + result);
		printMessage();
		System.out.println(result); //3 volte la stessa cosa, semplificando sempre

		//Questo codice (quello commentato ora) funziona ma è molto ripetitivo


		greet();
		int nameLen = greetWithName("Piero");  //salvo la lunghezza del nome in una variabile int
		System.out.println(nameLen);
		nameLen = greetWithName("Sabrina");
		System.out.println(nameLen);

		boolean even = isEven(13);
		System.out.println(even);

		printLenAndUpperCaseLowerCase("Bella zio bellaaaaa!!");

		String longer = getLonger("Bella zio", "Bella zione");
		System.out.println(longer);
		
	}

	public static int readInteger() {
		Console console = System.console(); //aggiunta dopo, vedi giù

		System.out.print("Dammi un numero intero > ");
		String input = console.readLine();
		int x = Integer.parseInt(input);
		return x; //Non andrebbe perchè ho creato la variabile console nella main, va ricreata nella funzione
	}
	
	//voglio ora una funzione che sommi direttamente i due numeri
	public static int sum(int x, int y) {
		int z = x + y;
		return z;
	}

	//Voglio una funzione che stampi La somma dei due numeri è
	public static void printMessage() {
		System.out.print("La somma dei due numeri è ");
	}


	// quello che segue è la definizione della funzione greet
	public static void greet() {
		// la keyword public permette alla funzione di essere chiamata anche al di fuori di questa classe
		System.out.println("è un piacere conoscerti!"); 
	}

	
	public static int greetWithName(String name) {
		System.out.println("è un piacere conoscerti " + name);
		int len = name.length();  // la lunghezza del nome
		return len;  //ritorna a chi la chiama la lunghezza del nome
	}

	public static boolean isEven(int x) {
 /*
		if (x % 2 == 0) {
			return true;
		} else {
			return false; // il return deve esserci in entrambi i casi, perché la funzione deve tornare sempre una booleana
		} */ //posso fare semplicemente così
		return x % 2 == 0;
	}

	public static void printLenAndUpperCaseLowerCase(String sentence) { //nome troppo lungo, andrebbe fatto in più funzioni
			int stringLen = sentence.length();  //lunghezza della stringa
			System.out.println(stringLen);  //volendo potrei direttamente stampare sentence.length(), senza creare la variabile
			String lower = sentence.toLowerCase();
			String upper = sentence.toUpperCase();
			System.out.println(lower);
			System.out.println(upper);
	}

	public static String getLonger(String s1, String s2) {
/*		if (s1.length() > s2.length()) {
			return s1;
		} else {
			return s2;  //se sono uguali in questo caso torna la seconda
		}*/

		//posso scriverlo più compatta utilizzando l'operatore ternario
		return s1.length() > s2.length() ? s1 : s2;  //se la booleana è vera torna la cosa a sinistra dei : , altrimenti torna quella a destra
		//prima di ? e : posso utilizzare qualsiasi condizione booleana
	}

}