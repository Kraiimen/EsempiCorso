public class Intro {
	public static void main(String[] args){
		System.out.println("5");
		int num =6;
		int numero;
		numero = 7;
		System.out.println(num);
		System.out.println(numero);
		num = Integer.MAX_VALUE;
		System.out.println(num);
		byte b = 22;
		Short s = 10000;	
		int i = 10000;
		long myLong = 10000000;

		char c = 'a';
		System.out.println(c);
		int y = c;
		System.out.println(y);	
		y = 100000;
		c=(char) y;
		System.out.println(c);
		int x = (int)c;
		System.out.println(x);
		long z = 3;
		i = (int)z;
		long zz = s;
		b = (byte)i;
		float f = 126.5f;
		double d = f;
		boolean bo =true;
		boolean bo2 = false;
		boolean result = d==126.5;
		System.out.println(result);
		double a1,b1;
		a1= 0.1;
		b1= 0.2;
		double sum = a1+b1;
		System.out.println(sum);
	}
}