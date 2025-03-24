/*
Il programma simula una semplice gestione di una biblioteca. 
Gli utenti possono prendere in prestito libri, restituirli e visualizzare lo stato dei libri (disponibili o in prestito). 
Il programma dovrà gestire una lista di libri e una lista di utenti.


Lista di Libri: Ogni libro ha un titolo, un autore e uno stato (disponibile o in prestito).
Lista di Utenti: Ogni utente ha un nome e un elenco di libri presi in prestito.

Funzionalità:
Un utente può prendere in prestito un libro se è disponibile. 
-> funzione che prende in input un utente 
->chiama una funzione per vedere se il libro è disponibile e se 
true aggiorna l'array dei suoi libri se ha spazio
->creiamo una funzione per vedere se ha spazio
-> e rende il libro indisponibile
Un utente può restituire un libro che ha preso in prestito.
-> funzione che prende in input un utente, sovrascriviamo il suo valore con stringa vuota
Il programma deve notificare l'utente quando prende in prestito o restituisce un libro.
->stampiamo qualcosa succede uno dei 2 fatti
Il programma deve stampare una lista di tutti i libri con il loro stato (disponibile o in prestito) e una lista di utenti con i libri che hanno preso in prestito.
-> print generale con le informazioni dei libri e degli studenti
*/
import java.util.Arrays;
public class  ManagementLibrary{
    private static final int N_BOOKS = 10;
    private static final int N_CHARACTERISTICS_BOOKS = 3;
    private static final int N_USERS = 10;
    private static final int N_LOAN_BOOKS = 3;

    private static final String [][] BOOKS = {
            {"Il Nome della Rosa","Umberto Eco", "Disponibile"},
            {"1984","George Orwell", "Disponibile"},
            {"Il Signore degli Anelli","J.R.R. Tolkien", "Disponibile"},
            {"Orgoglio e Pregiudizio","Jane Austen", "Disponibile"},
            {"Il Piccolo Principe","Antoine de Saint-Exupéry", "Disponibile"},
            {"Moby Dick","Herman Melville", "Disponibile"},
            {"Don Chisciotte","Miguel de Cervantes", "Disponibile"},
            {"I Promessi Sposi","Alessandro Manzoni", "Disponibile"},
            {"Cime Tempestose","Emily Brontë", "Disponibile"},
            { "Dracula","Bram Stoker", "Disponibile"}
    };

    private static final String [][] BOOKS_LOANED = new String[N_USERS][N_LOAN_BOOKS];
    private static final String [] NAMES_USERS = {"Leo", "Mia", "Eli", "Noa", "Gio", "Lia", "Teo", "Zoe", "Ray", "Kim"};

    public static void main(String [] args){

        loanBook("Mia", "Il Piccolo Principe");
        loanBook("Mia", "I Promessi Sposi");
        loanBook("Mia", "Cime Tempestose");
        bringBackBook("Mia", "Il Piccolo Principe");



        printBooks();
        printUsersBooks();





    }
    //funzione per prendere in prestito un libro
    public static void loanBook(String user, String title){
        int bookPosition = getBookPosition(title); //mi restituisce la posizione del libro nell array BOOKS
        //Mi restituisce la posizione dell user in NAMES_USERS che è la stesssa che utilizzo per BOOKS_LOANED
        int indexUsers = Arrays.asList(NAMES_USERS).indexOf(user); 
        int roomAvailable = getRoomAvailable(indexUsers);//mi restituisce la prima cella disponibile
        //Esegue se il libro esiste, è disponibile, l utente ha spazio disponibile
        if (bookPosition != -1 && isAvailable(bookPosition) && roomAvailable != -1){
            BOOKS_LOANED[indexUsers][roomAvailable] = BOOKS[bookPosition][0];
            modifyStatus(bookPosition);
            System.out.println(NAMES_USERS[indexUsers] + " ha preso in prestito: " + BOOKS_LOANED[indexUsers][roomAvailable]);
        } else {
            System.out.println("Non puoi prendere in prestito il libro");
        }
    }
    //funzione per restituire un libro 
    public static void bringBackBook(String user, String title){
        int bookPosition = getBookPosition(title); //mi restituisce la posizione del libro nell array BOOKS
        //Mi restituisce la posizione dell user in NAMES_USERS che è la stesssa che utilizzo per BOOKS_LOANED
        int indexUsers = Arrays.asList(NAMES_USERS).indexOf(user); 
        //ci restituisce l indice del libro tra i libri presi in prestito dall user, se non lo trova ritorna -1
        int indexBookOfUser =Arrays.asList(BOOKS_LOANED[indexUsers]).indexOf(title);
        if(bookPosition != -1 && !isAvailable(bookPosition) && indexBookOfUser != -1){
            BOOKS_LOANED[indexUsers][indexBookOfUser] = "";
            modifyStatus(bookPosition);
            System.out.println(NAMES_USERS[indexUsers] + " ha restituito: " + BOOKS[bookPosition][0]);
        } else {
            System.out.println("Errore nell'esecuzione dell'operazione, ricontrolla i dati inseriti.");
        }
    }
    public static int getBookPosition(String title){
        for(int i = 0; i < BOOKS.length; i++){
            if (BOOKS[i][0].equals(title)){
                return i; //ritorniamo posizione del libro
            }
        }
        return -1; // se il libro non è mai stato presente in libreria
    }
    // Controlla che il libro è disponibile
    public static boolean isAvailable(int position){
        if (BOOKS[position][2].equals("Disponibile")){
            return true;
        }else{
            return false;
        }
    }
    //verifica se l utente puo prendere in prestito e se lo ha ritorna ls posizione dentro BOOKS_Loaned dove puo inserire il libro  altrimenti ritorna -1
    public static int getRoomAvailable (int userPosition){
        for (int i = 0; i < N_LOAN_BOOKS; i++){
            if (BOOKS_LOANED[userPosition][i] == null || BOOKS_LOANED[userPosition][i].equals("")){
                return i;
            }
        }
        return -1;
    }
    //modifica lo status, se disponibile mette indisponibile e viceversa
    public static void modifyStatus(int bookPosition){
        if (BOOKS[bookPosition][2].equals("Disponibile")){
            BOOKS[bookPosition][2] = "Indisponibile";
        } else{
            BOOKS[bookPosition][2] = "Disponibile";
        }
    }
    // stampa i libri
    public static void printBooks(){
        for (int i = 0; i < BOOKS.length; i++){
            System.out.println("- " + BOOKS[i][0] + " " + BOOKS[i][1] + " " + BOOKS[i][2]);
        }
    }
    // stampa l'utente e i libri che ha preso in prestito
    public static void printUsersBooks(){
        for (int i = 0; i < NAMES_USERS.length; i++){
            System.out.print(NAMES_USERS[i] + ":");
            for (int j = 0; j < N_LOAN_BOOKS ; j++){
                System.out.print(" " +BOOKS_LOANED[i][j]);
            }
            System.out.println();
        }


    }
}