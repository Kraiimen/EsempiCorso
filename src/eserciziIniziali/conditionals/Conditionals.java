package eserciziIniziali.conditionals;

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
		double cost;
		boolean isFemale = true;
		int hour = 14;
		final double FEMALE_DISCOUNT_PERCENTAGE = 0.2;
		final double MALE_DISCOUNT_PERCENTAGE = 0.1;
		final String day = "mercoledì";

		//Se hai meno di 15 anni, il costo sarà uguale a 50
		//Se hai tra i 15 e i 20 anni, il costo sarà 70
		//Se hai tra i 20 e i 32 anni, il costo sarà 100
		//Se hai più di 32 anni, il costo sarà di 200, infine va stampato
		//Se è tra i 20 e i 32, ed è maschio, e dopo le 18 o è domenica, ha uno sconto del 10%
		//Se è tra i 20 e i 32, ed è femmina, e dopo le 15 o è mercoledì, ha uno sconto del 20%
		/*
		cost = 50;
		if (age >= 15){
			cost = 70;
			if(age >= 20){
				cost = 100;
				if(isFemale){
					if(hour > 15){
						cost *= (1 - FEMALE_DISCOUNT_PERCENTAGE);
					}
				}
				else{
					if(hour > 18){
						cost *= (1 - MALE_DISCOUNT_PERCENTAGE);
					}
				}
				if(age >= 32){
					cost = 200;
				}
			}
		}
		//*/


		/*
		cost = 200;
		if (age < 32){
			cost = 100;
			if(isFemale){
				if(hour > 15){
					cost *= (1 - FEMALE_DISCOUNT_PERCENTAGE);
				}
			}
			else{
				if(hour > 18){
					cost *= (1 - MALE_DISCOUNT_PERCENTAGE);
				}
			}
			if(age < 20){
				cost = 70;
				if(age < 15){
					cost = 50;
				}
			}
		}
		//*/


		/*
		cost = 200;
		if (age < 32){
			cost = 100;
			if(isFemale){
				if(hour > 15){
					cost *= (1 - FEMALE_DISCOUNT_PERCENTAGE);
				}
			}
			else{
				if(hour > 18){
					cost *= (1 - MALE_DISCOUNT_PERCENTAGE);
				}
			}
		}
		else if(age < 20){
			cost = 70;
		}
		else if(age < 15){
			cost = 50;
		}
		//*/

		
		/*
		cost = 50;
		if (age > 15){
			cost = 70;
		}
		else if(age > 20){
			cost = 100;
			if(isFemale){
				if(hour > 15){
					cost *= (1 - FEMALE_DISCOUNT_PERCENTAGE);
				}
			}
			else{
				if(hour > 18){
					cost *= (1 - MALE_DISCOUNT_PERCENTAGE);
				}
			}
		}
		else if(age > 32){
			cost = 200;
		}
		//*/

		
		//*
		cost = 50;
		if(age >= 15 && age < 20){
			cost = 70;
		}
		if(age >= 20 && age < 32){
			cost = 100;
			if(isFemale && hour > 15)
				{cost *= (1 - FEMALE_DISCOUNT_PERCENTAGE);
			}
			if(isFemale == false && hour > 18){
				cost *= (1 - MALE_DISCOUNT_PERCENTAGE);
			}
		}
		if(age >= 32){
			cost = 200;
		}
		//*/
		
		System.out.println(cost);
	}
}