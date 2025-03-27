public class Intro {
	public static void main(String[] args){
		int num = 6;
		
		int numero = 7;

		

		byte b = 22; //8 bit va da un numero di -128 a 127
		short s = 10000; // 16 bit  va da -32668 a 32667
		int i = 100000; //32 bit 
		long myLong = 1000000000; //64 bit 

		char c = 'a'; //carattere unicode sistema di codifica standar che assegna un valore numerico unico a ogni carattere 
		int y = c;		

		System.out.println("5");
		System.out.println(num);
		System.out.println(numero);
		
		num = Integer.MAX_VALUE; //sovrascrivere num con un valore massimo che un int può contenere
		// Integer.Max_Value è una costante predefinita in Java che rappresenta il valore massimo di un int, cioè 2^31 - 1
		System.out.println(num);

		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(myLong);

		System.out.println(c);
		System.out.println(y);
		
		c = (char) y;
		System.out.println(c);

		y = 100000;
		c = (char) y;
		System.out.println(c);

		int x = (int) c;
		System.out.println(x);

		float f = 300.0f;
		double d = f;

		boolean bo1 = true;
		boolean bo2 = false;
		System.out.println(bo1);
		System.out.println(bo2);

		boolean result = (d == 300d);
		System.out.println(result);
		int t = 0;

		/*
			boolean bo3 = (boolean) t; //non consentito
		*/

		boolean bo4 = (t < i);
		System.out.println(bo4);
	}	
}