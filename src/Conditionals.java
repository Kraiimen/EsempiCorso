public class Conditionals {
	public static void main(String[] args){
		
		int x = 10;

		if(x == 3){
		  System.out.println("Si, si, x è uguale proprio a 3");
		}
		else if(x == 5){
		  System.out.println("Si, x è uguale a 5");
		}
		else if(x == 7){
		  System.out.println("Si, x è uguale a 7");
		}
		else{
		  System.out.println("X è diverso da 3, 5 e 7");
		  System.out.println("Che sfiga!");
		}

		
		int age = 32;
		double cost = 0;

		//Se hai meno di 15 anni, il costo sarà uguale a 50
		//Se hai tra i 15 e i 20 anni, il costo sarà 70
		//Se hai tra i 20 e i 32 anni, il costo sarà 100
		//Se hai più di 32 anni, il costo sarà di 200
		
		cost = 50;
		if (age >= 15){
			cost = 70;
			if(age >= 20){
				cost = 100;
				if(age >= 32){
					cost = 200;
				}
			}
		}
		System.out.println(cost);
	}
}