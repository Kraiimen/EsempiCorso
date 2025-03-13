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

		
		int age = 17;
		double cost = 0;

		//Se hai meno di oppure 15 anni, il costo sarà uguale a 50
		//Se hai tra i 15 e i 20 anni, il costo sarà 70
		//Se hai tra i 20 e i 32 anni, il costo sarà 200
		//Se hai più di 32, il costo sarà 300 

		//il prezzo del biglietto, se l'orario è dopo le 18:00, 10% di sconto
		//sconto solo se hai tra 20 e 32 anni

		int time = 18; //ora spettacolo del biglietto


		/* CONTROLLO ETA' */
		//da 0 a 15
		if(age <= 15){
			cost = 50;
		}
		//tra 16 e 20
		else if(age <= 20){
			cost = 70;
		}
		//tra 21 e 32
		else if(age <= 32){
			cost = 200;
			// CONTROLLO ORARIO
			if(time > 18){
				cost *= 0.9; // cost = cost * 0.9;
			}
		}
		//da 33 in poi
		else{
			cost = 300;
		}
		/* ------------ */

		
		//OPERATORI DI CONFRONTO == <= >= !=

		System.out.println(cost);
	}
}