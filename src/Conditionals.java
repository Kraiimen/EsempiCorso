public class Conditionals{
	public static void main(String[] args){
		int x = 2121;
		if(x==3){
			System.out.println("x=3");
		}else if(x==5){
			System.out.println("No, X è uguale a 5");
		}else if(x==7){
			System.out.println("No, X è uguale a 7");
		} else {
		System.out.println("X è diverso da 3, 5 o 7");
		}
		
		/*scrivere del codice che controlla la variabile age per capire quanti anni hai, e se hai meno di 15 anni, cost sarà 			uguale a 50, se invece hai tra 15 e 20 anni cost sarà uguale a 70, se hai tra 20 e 32 cost sarà uguale a 100, infine se 		hai più di 32 anni, cost sarà uguale a 200, poi stampa il valore di cost*/
		
		int age =26;
		double cost=0;
		if(age <=15){
			cost = 50;
		}else if(age >15 && age<=20){
			cost = 70;
		}else if(age >20 && age<=32){
			cost = 100;
		}else if(age >32){
			cost = 200;
		}
		System.out.println(cost);
	}
}