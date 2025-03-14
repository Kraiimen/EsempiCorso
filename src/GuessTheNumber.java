import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
 
    Random dice = new Random();//Crea un oggetto Random che permette di generare numeri casuali.
    int n = dice.nextInt(100_001);//Il metodo nextInt(int bound) genera un numero intero casuale tra 0 e -1.
    //scrivendo 100_001, facciamo in modo che i numeri generati vadano da 0 fino a 100000.
    //Se avessimo scritto random.nextInt(100000); i numeri generati sarebbero da 0 a 99999, escludendo 100000.
    Scanner scanner = new Scanner(System.in);// (System.in) l'input standar di JAVA, riceve dati dalla tastiera.
        int tentativi = 0; //Prima creo la variante tentativi //l'utente non ha ancora fatto nessun tentativo, quindi ha senso partire da 0.
        int numeroUtente = -1; //Poi credo la variante numeroUtente //Sappiamo che il numero misterioso sarà tra 0 e 100000, quindi -1 non può mai essere una soluzione.
        int numeroMisterioso = 905;//Poi creo il numero misterioso

        System.out.println("Benvenuto nel gioco del Numero Misterioso!");//Poi creo l'inizio del gioco
        System.out.println("Devi indovinare un numero tra 0 e 100000.");//E aggiungo lo scopo del gioco

        while (numeroUtente != numeroMisterioso) {//Adesso avvio un ciclo while perchè il loop deve andare avanti finchè non si indovina il numero
            System.out.print("Inserisci un numero:");//Qui si inserisce il numero
            numeroUtente = scanner.nextInt();//Dopo aver stampato inserisci un numero, questa riga legge il numero inserito dal giocatore e lo assegna a numeroUtente
            //sennò il valore di numeroUtente non cambierebbe mai
            tentativi++;//Ogni volta che l’utente inserisce un numero, il conteggio dei tentativi aumenta di 1.
            //Se tentativi++; non fosse presente il numero di tentativi resterebbe sempre a 0 e il messaggio finale sbagliato.

            if (numeroUtente == numeroMisterioso) {//Qui "if" quindi "Se" numeroUtente == numeroMisterioso, il ciclo terminerà, e la macchina stamperà questo messaggio.
                System.out.println("Bravo, hai indovinato!");
            } else if (numeroUtente < numeroMisterioso) {//Qui "else if" quindi "E se" numeroUtente è minore di numeroMisterioso, la macchina stamperà questo messaggio e il loop ripartirà.
                System.out.println("Sbagliato! Il numero misterioso è più grande.");
            } else {//Qui come "else if" se sbaglieremo e inseriremo un numero più piccolo il loop ricomincerà.
                System.out.println("Sbagliato! Il numero misterioso è più piccolo.");
            }
        }
        
        System.out.println("Hai indovinato in " + tentativi + " tentativi.");//La doppia scritta tentativi e "tentativi" unita dal "+" serve a far concatenare a Java
        //e numeri,dove tentativo darà il numero e "tentativi" stamperà la parola vera e propria.
        scanner.close(); {//Qui vado a chiudere lo scanner perchè prendendo i dati dalla tastiera (System.in) ora non mi serve più.
        //Vinto il gioco il loop finirà e la macchina stamperà a video la vittoria e i tentativi totali.

        }
    }
}
    //continuare questo programma. Deve chiedere un numero misterioso, avere la risposta e: se azzecca stampa "bravo sei un genio"
    // se invece il numero dell'utente è sbagliato ed è minore, stampa "Hai sbagliato, il numero magico è maggiore"
    // se il numero è sbagliato ed è più piccolo stampa "Hai sbagliato, il numero è più piccolo"
    // voglio che il programma conti i tentativi e li riporti a fine del processo il numero dei tentativi




