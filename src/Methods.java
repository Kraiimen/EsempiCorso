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

}