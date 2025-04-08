package javaIntroduction;

public class ObjectArrays {
	public static void main(String[] args) {
		//String[] as = new String[5];
		//Provo a stampare la versione maiuscola del primo array
		//System.out.println(as[0].toUpperCase()); //compilerà ma non riuscirò ad eseguirlo, perchè c'è il null nell'array
		String[] students = {"Piero Scarcina, Gryffindor", "Lorenzo Coretti, Ravenclaw", "Carmine Erario"}; //In questo modo l'array è pieno e posso lavorarci
		System.out.println(students[0].toUpperCase()); //Ora stampa Piero Scarcina in maiuscolo
		String [] gryffindor = new String [6]; //Ora ci sono 6 null in gryffindor
		int grCounter = 0; //con questa variabile posso tenere traccia del riempimento andando a incrementare grCounter
		//Devo tenere traccia mentre lo riempio di fin dove è stato riempito l'array
		gryffindor[grCounter] = "Emanuele Giustiniani";
		grCounter++; //in un ciclo andrò a incrementare grCounter quando riempio con uno studente
		System.out.println(gryffindor[0]); //Così perdo facilmente traccia di dove sono arrivare a riempire
		//Se devo fare un sorteggio dovrò usare una variabile per tenere traccia del riempimento
		gryffindor[grCounter] = "Piero Scarcina";
		//System.out.println(gryffindor[1]);
		String s1 = students[0];
		String[] sTokens = s1.split(","); // In questo modo separerei il nome dello studente dala casata preferita
		System.out.println(sTokens[0]);
		System.out.println(sTokens[1]);
	}
}