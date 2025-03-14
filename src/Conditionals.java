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
		
		/*
			se hai meno di 15 anni, il costo sarà uguale a 50
			se hai tra 15 e 20, il costo sarà 70 (i 20 sono esclusi) 
			se hai tra i 20 e i 32 anni, il costo sarà 100 (32 esclusi)
			se hai da 32 in su il costo sarà uguale a 200
			se sta nella fascia tra 20 e 32, è mascchio e chiede un biglietto per uno spettacolo dopo le 18 si applica uno sconto del 10% o anche se è domenica
			se invece è femmina gli si sconta il 20% dopo le 15 o se lo prendono di mercoledì
			
			in sintesi
			se hai MENO di 15 anni, paghi 50$
			se hai MENO di 20 anni ma 15 o PIU paghi 70$
			se hai MENO di 32 anni, se sei una donna, paghi 100$ fino alle 15 sucessivamente paghi 100$ - 20% ogni giorno TRANNE il mercoledì, il mercoledì pahi 100$ - 20% tutta la giornata
			se hai MENO di 32 anni, se sei un uomo, paghi 100$ fino alle 18 sucessivamente paghi 100$ - 10% ogni giorno TRANNE la domenica, ma domenica paghi 100$ - 10% tutto il giorno
			se hai MENO di 32 anni e non rientri nelle regole paghi 100$
			se hai PIÙ di 32 anni paghi 200$
		 */
		int age =29;
		double cost=0;
		boolean isFemale = true;
		double time = 12.00;
		final double SM = 0.1; //SM sta per Sconto Maschi
		final double SF = 0.2; //SF sta per sconto femmine
		final String day = "mercoledì";
		if(age <15){
			cost = 50;
		}else if(age <20){
			cost = 70;
		}else if (age <32){
			cost =100;
			if(isFemale &&(time >15 || day.equals("mercoledì"))){
				cost -= cost*SF;
			}else if(!isFemale && (time >18 || day.equals("domenica"))){
			cost -= cost*SM;
			}
		}else{
			cost = 200;
		}
		System.out.println("femmina: " + isFemale);
		System.out.println("età: "+ age);
		System.out.println("orario: " + time);
		System.out.println("costo: " + cost);
				
	}
}