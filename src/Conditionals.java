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
		int time = 18;
		boolean isFemale = false;
		final double FEMALE_DISCOUNT_PERCENTAGE = 0.8;
		final double MALE_DISCOUNT_PERCENTAGE = 0.9;
		final String day = "mercoledì";

		//Se hai meno 15 anni, il costo sarà uguale a 50
		//Se hai tra i 15 e i 20 anni (esclusi), il costo sarà 70
		//Se hai tra i 20 e i 32 anni (esclusi), il costo sarà 100
		//Se hai più di 32, il costo sarà 200 

		//Se hai tra i 20 e i 32 anni
		//Se sei maschio, e l'orario del biglietto è dopo le 18 oppure è Domenica--> 10% di sconto
		//Se sei femmina, e l'orario è dopo le 15 oppure se è Mercoledì --> 20% di sconto

		if(age <= 15){
			cost = 50;
		}
		else if(age < 20){
			cost = 70;
		}

		// else if(age < 32) {
		// 	cost = 100;

		// 	if(isFemale) {
		// 		if(time > 15){
		// 			cost *= FEMALE_DISCOUNT_PERCENTAGE;
		// 		}
		// 	} else {
		// 		if(time > 18){
		// 			cost *= MALE_DISCOUNT_PERCENTAGE;
		// 		}
		// 	}
		// }


		// else if(age < 32 && isFemale && time > 15){
		// 	cost *= FEMALE_DISCOUNT_PERCENTAGE;
		// }
		// else if(age < 32 && !isFemale && time > 18){
		// 	cost *= MALE_DISCOUNT_PERCENTAGE;
		// }
		// else {
		// 	cost = 100;
		// }

		// else if(age < 32) {
		// 	cost = 100;

		// 	if(isFemale && time > 15){
		// 		cost *= FEMALE_DISCOUNT_PERCENTAGE;
		// 	}else if(!isFemale && time > 18){
		// 		cost *= MALE_DISCOUNT_PERCENTAGE;
		// 	}
		// }

		else if(age < 32) {
			if(isFemale && (time > 15 || day.equals("mercoledì"))){
		 		cost *= FEMALE_DISCOUNT_PERCENTAGE;
		 	}else if(!isFemale && (time > 15 || day.equals("domenica"))){
		 		cost *= MALE_DISCOUNT_PERCENTAGE;
		 	}
		}

		else {
			cost = 200;
		}

		System.out.println(cost);
	}
}

