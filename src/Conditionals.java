   // Esercizi Per if,else

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
       

		//Se hai meno di 15 anni, il costo sarà uguale a 50
		//Se hai tra i 15 e i 20 anni, il costo sarà 70
		//Se hai tra i 20 e i 32 anni, il costo sarà 200
		// se dopo le 18:00 lo sconto sarà del 10%
		// solamente quelli tra i 20 e i 31 prendono lo sconto
		
		int age = 32;
		double cost = 50;
		int time = 18;

		if(age <= 15){
			cost = 50;
		}
        else if(age <= 20){
			cost = 70;
		}
		else if( age <= 32){
			cost = 100;
		    if(time >= 18 && age<=32){        //Utlizzato comparatore di logica
				cost *= 0.9; // Applica lo sconto del 10%                
		    }
	    }
		else {
		  	cost= 200;
		}
	
		
      	System.out.println(cost);

	}
}