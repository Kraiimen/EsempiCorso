
// Esercizi di ripasso dei concetti di array e variabili e oggetti, e di passbyvalue e passbyreference
// n.b. In java è sempre passbyvalue, solo che nel caso degli oggetti il valore è l'indirizzo, quindi indirettamente passando il value passo il reference

public class RipassoPersonale {
	static int z = 100; // Aggiungo una variabile globale (fuori dal main ma nella classe)
	public static void main(String[] args) {
		int x = 3;
		f1(x);
		System.out.println("All'interno del main: " + x);
		f1(35); //posso passare alla funzione anche direttamente un literal
		f2(z);
		f2(z);
		System.out.println("All'interno del main: " + z);
		int[] nums = {1, 2, 3}; // Dentro la variabile nums (variabile di un oggetto) non c'è l'array, ma un indirizzo
		System.out.println(nums[0]);
		f3(nums);
		System.out.println(nums[0]); //In questo caso nume[0] si è aggiornato dopo la chiamata di f3, perchè gli ho passato copia dell'indirizzo alle variabili originali
		Integer i1 = 10;
		Integer i2 = Integer.valueOf(20);
		// Sto ora creando due oggetti di classe Integer (classe wrapper), versione a oggetti delle primitive.
		// 10 è una primitiva. i1 dovrebbe essere un indirizzo no? In linea 18 sta avvenendo un boxing,
		// ovvero sto creando un oggetto di tipo Integer e ci sto mettendo dentro una primitiva int = 10.
		// In linea 19 non avviene in automatico ma lo sto facendo io, ma fanno la stessa cosa.
		swap(i1, i2);
		System.out.println("Il valore di i1 nel main dopo swap sarà: " + i1); // stamperà 10 e non 20, perché z1 e z2 sono copie di i1 e i2. Integer, come String, è immodificabile.
		String s1 = "Pippo";
		String s2 = "Pluto";
		swapStrings(s1, s2);
		System.out.println(s1); // Stamperà comunque Pippo
	}

	public static void f1(int x) {
		x += 3;
		System.out.println("All'interno di f1: " + x);
	}

	public static void f2(int ferrarelle) { //scritto ferrarelle per dimostrare che il nome ha poca importanza, le sto comunque passando z nel main, il valore di z viene copiato in ferrarelle
		z += 3;
		System.out.println("All'interno di f2 ferrarelle:  " + ferrarelle);
		System.out.println("All'interno di f2 z: " + z);
	}

	public static void f3(int[] ns) {
		ns[0] = 100;
		System.out.println(ns[0]);
		ns = new int[]{1000, 2000, 3000, 4000};  // In questo momento sto dicendo ad ns di puntare (indirizzo) a questo nuovo array, ma solo nella funzione, sto cambiando l'indirizzo
		System.out.println(ns[0]);
	}

	public static void swap(Integer z1, Integer z2) {
		Integer temp = z1;
		z1 = z2;
		z2 = temp; // Provo a fare uno swap, riuscirà? No, è impossibile. Queste sono copie degli indirizzi i1 e i2.
		System.out.println("Il valore di i1 nella funzione swap ora è: " + z1);
		// z1.setValue(100);    Questo è come fare ns = new int[]{1000, ecc.} in linea 42, sto dicendo all'indirizzo di puntare a questo nuovo valore
		// n.b. setValue non è una funzione degli Integer, era solo a mo di esempio
	}

	public static void swapStrings(String s1, String s2) {
		String temp = s1;
		s1 = s2;
		s2 = temp;    // Stessa identica cosa della funzione swap per l?integer, le Stringhe non possono essere modificate, s1 e s2 saranno copie degli indirizzi delle stringhe del main
	}
}

// L'esercizio permette di capire che aggiornare il valore di un parametro non aggiorna automaticamente 
// anche l'argomento. I 3 output saranno:
// 1) All'interno di f1: 6
// 2) All'interno del main: 3
// 3) All'interno di f1: 38
// 4) All'interno di f2 ferrarelle: 100          f2 aggiorna z ma stampa la z copiata inizialmente in ferrarelle = 100
// 5) All'interno di f2 z: 103                   stampa la z aggiornata
// 6) All'interno di f2 ferrarelle: 103          stessa cosa, ma prima z si era aggiornata e ora stampa 103 che è il valore della copia di z ferrarelle
// 7) All'interno di f2 z: 106                   stampa il valore aggiornato di z
// 8) All'interno del main: 106                  stampa la z aggiornata a 106
// 9) 1                                          valore di nums[0]
// 10) 100                                       valore di ns[0]
// 11) 1000                                      valore del nuovo array ns[0] creato nella funzione
// 12) 100                                       valore di nums[0] dopo chiamata di f3 e aggiornamento valore ns[0]
// 13) Il valore di i1 nella funzione swap ora è: 20           valore di i1 aggiornato in swap
// 14) Il valore di i1 nel main dopo swap sarà: 10             valore di i1 dopo swap nel main, che non viene aggiornato perché rappresenta un indirizzo
// 15) Pippo

// La funzione f1 aggiorna il valore del parametro (copia dell'argomento) x,
// l'argomento (variabile originale) x rimarrà invariato.
// Nel secondo caso la variabile è globale, per cui si aggiornerà anche nel main,
// ma ferrarelle resta comunque una copia della variabile globale z.
// Nel caso di un oggetto, come l'array, passo alla funzione un indirizzo all'array e non l'array stesso,
// per cui se aggiorno l'array nella funzione si aggiorna anche l'array originale.