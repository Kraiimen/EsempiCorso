public class Intro {
	public static void main(String[] args){
		int num = 6;
		
		int numero;
		numero = 7;
		

		byte b = 22;
		short s = 10000;
		int i = 100000;
		long myLong = 1000000000;

		char c = 'a';
		int y = c;		

		System.out.println("5");
		System.out.println(num);
		System.out.println(numero);
		
		num = Integer.MAX_VALUE;
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

		boolean bo = true;
		boolean bo2 = false;
		System.out.println(bo);
		System.out.println(bo2);

		boolean result = (d == 300d);
		System.out.println(result);
c
		int t = 0;

		/*
			boolean bo3 = (boolean) t; //non consentito
		*/

		boolean bo4 = (t < i);
		System.out.println(bo4);
	}	
}