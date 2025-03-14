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
		final double MALE_DISCOUNT_PERCENTAGE = 0.1 ;//final è una costante
		final String day = "mercoledì";

		//Se hai meno di 15 anni, il costo sarà uguale a 50
		//Se hai tra i 15 e i 20 anni esclusi, il costo sarà 70
		//Se hai tra i 20 e i 32 anni esclusi, il costo sarà 100
		//Se hai da 32 anni in più, il costo sarà 200
		
		if(age < 15) {
			cost = 50;
		} else if (age < 20) { //ha già controllato il minore di 15
			cost = 70;
			//CASO 1
		// // } else if (age < 32) {
		// // 	cost = 100;
		// // 	if(isFemale) { //si può scrivere anche (isFemale == true) ma è già scontato così
		// // 		if(orario > 15) {
		// // 			cost = cost * (1 - FEMALE_DISCOUNT_PERCENTAGE);
		// // 		}

		// }

		// //	} else {
		// 		if(orario > 18) {
		// 			cost = cost * (1 - MALE_DISCOUNT_PERCENTAGE);
		// 		}
		//	}
		
		   // CASO 2
		// }else if (age < 32 && isFemale && orario > 18) { //&& combina booleane x dare risultato booleano, true solo se sono entrambe
		// 	cost = 100 * (1 - FEMALE_DISCOUNT_PERCENTAGE);
	
		// } else if(age < 32 && !isFemale && orario > 18) {
		// 	cost = 100 * (1 - MALE_DISCOUNT_PERCENTAGE);
		
		// } else if (age < 32) {
		// 	cost = 100;

		// }
		
		   //CASO 3
		} else if (age < 32) {
			cost = 100
			if(isFemale && (orario > 15 || day.equals("mercoledì"))) {
			//	cost = cost * (1 - FEMALE_DISCOUNT_PERCENTAGE);
			    cost -= cost * FEMALE_DISCOUNT_PERCENTAGE;
			
			} else if(!isFemale && (orario > 18 || day.equals("domenica"))) {
				cost -= cost * MALE_DISCOUNT_PERCENTAGE;
			}

		} else {
			cost = 200;
		}

		//se la persona sta nella fascia tra 20 e 32 ed è maschio e 
		//chiede un biglietto dopo le 18, gli scontiamo del 10% il costo del biglietto
		//se è femmina gli scontiamo il 20% dopo le 15

		// lo sconto verrà dato alle femmine che arrivano dopo le 15 oppure deve essere un mercoledì
		//lo sconto verrà dato ai maschi che arrivano dopo le 18 oppure deve essere una domenica

		//int x = 3;
		//x = x + 5;
		//x += 5; è la stessa cosa della riga sopra


		// x = x * 10;
		// x *= 10; stessa cosa 

		//x = x + 1;
		//x += 1;
		//x ++; uguale a sopra (POST INCREMENT OPERATOR, si può scrivere anche  ++ x;)

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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