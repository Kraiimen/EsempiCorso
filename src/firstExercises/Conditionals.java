package firstExercises;

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
		boolean isFemale = true;
		int orario = 14;
		final double FEMALE_DISCOUNT_PERCENTAGE = 0.2;
		final double MALE_DISCOUNT_PERCENTAGE = 0.1;
		final String day = "mercoledì";

		//Se hai meno di 15 anni, il costo sarà uguale a 50
		//Se hai tra i 15 e i 20 anni, il costo sarà 70 (20 esclusi)
		//Se hai tra i 20 e i 32 anni, il costo sarà 100 (32 esclusi)
		//Se hai da 32 anni in più, il costo sarà 200 

		if(age < 15) {
			cost = 50;

		} else if(age < 20) {
			cost = 70;

		// } else if(age < 32) {
		// 	cost = 100;
		// 	if(isFemale) {
		// 		if(orario > 15) {
		// 			cost = cost * (1 - FEMALE_DISCOUNT_PERCENTAGE);
		// 		}							
		// 	} else {
		// 		if(orario > 18) {
		// 			cost = cost * (1 - MALE_DISCOUNT_PERCENTAGE);
		// 		}
		// 	}	
		
		
		// } else if(age < 32 && isFemale && orario > 15) {			
		// 	cost = 100 * (1 - FEMALE_DISCOUNT_PERCENTAGE);

		// } else if(age < 32 && !isFemale && orario > 18) {
		// 	cost = 100 * (1 - MALE_DISCOUNT_PERCENTAGE);

		// } else if(age < 32) {
		// 	cost = 100;
		// }

		} else if(age < 32) { 
			cost = 100;  
			 if(isFemale && (orario > 15 || day.equals("mercoledì"))) {
				// cost = cost * (1 - FEMALE_DISCOUNT_PERCENTAGE);
				cost -= cost * FEMALE_DISCOUNT_PERCENTAGE;

			} else if(!isFemale && (orario > 18 || day.equals("domenica"))) { //importanza delle parentesi
				cost -= cost * MALE_DISCOUNT_PERCENTAGE; // un operatore booleano esegue solo due fattori alla volta

			}

		} else {
			cost = 200;

		}
		
		//se la persona sta nella fascia tra 20 e 32, è maschio e chiede un biglietto 
		// dopo le 18.00, gli scontiamo il 10% del costo. Se invece è femmina, 
		// le scontiamo il 20%, solo dopo le 15.00

		// FEMMINE: lo sconto verrà dato alle persone che arrivano dopo le 15.00 "oppure" deve 
		// essere un mercoledì
		// MASCHI: lo sconto viene dato dopo le 18.00 o se è domenica
















		if(age < 15){
		  cost = 50;
		}
		else if(age > 15 && age < 20){
		  cost = 70;
		}
		else if(age > 20 && age < 32){
		  cost = 200;
		}
		
		System.out.println(cost);
	}
}