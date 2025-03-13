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
		//Se hai tra i 20 e i 32 anni, il costo sarà 200
		// se hai piu di 32 , il costo sara 300


		int time =18: //ora spettacolo del biglietto 
		//il prezzo del biglietto , se l orario e  dopo le 18, 10% di sconto

		//da 0 a 15
		if(age < 15){
		  cost = 50;
		}
		//tra 16 e 20
		else if(age < 20){
		  cost = 70;
		}
		//tra 21 e 32
		else if(age < 32){
		  cost = 200;
		}
		//da 33 in poi
		else{
		  cost =300;

		if (time>18){
		cost*= cost 0.9:
		}

		//int a = 0;
		//if()

		System.out.println(cost);
	}
}