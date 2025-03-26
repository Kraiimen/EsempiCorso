package org.generation.italy.bankProject.accounting;
import java.time.LocalDate;//Fully Qualified Name, scrivendo il nome completo
import java.time.LocalDateTime;
import java.util.ArrayList;
//non ho bisogno di fare l'import.
//Le classi ne package default Java non sono importabili, perchè
//il pack default non ha nome.

public class Account {//La visibilità di default vuol dire visibile sono nel suo package, fuori dal package
    //non può essere utilizzata (DEFAULT: Class Account) non posso fare più di una classe public per file(il file deve avere lo stesso nome della classe public)
    //private, sono visibili solo alla classe che lo definisce

    private static int lastId;//Uso la variabile static per incrementare il contatore di ogni singolo id

    private double balance;//Se la variabile è privata, il cambiamento avverrà solo nella classe che contiene lo stato

    private int id;//Variabile locale di una funzione(o metodo, in java sono equivalenti), non verranno inizializzate, devo dargli un valore

    private LocalDate creationDate;//Serve ad indicare la data, la prima ricerca la fa
    //nel java.lang, se non la trova la va a cercare nel package, se non la trova
    //prima di dare errore, andrà a leggere la lista degli import.

    private ArrayList  movements;


    //Creo il primo costruttore

    public Account() {//Il costruttore va nella memoria HEAP e mi alloca la memoria inizializza le variabili di un oggetto al valore default e mi restituisce l'indirizzo
//        lastId++;
//        id = lastId;
//        this(0);//Lo zero è initialBalance, this() = Account() this sostituisce il nome della classe
            creationDate = LocalDate.now();
            movements = new ArrayList();
    }
        //CREO IL SECONDO COSTRUTTORE

    public Account(double initialBalance){//Costruttore, non prende nessun parametro in input, non ha bisogno del tipo di ritorno
        this();
//        lastId++;
//        id = lastId;
        bal = initialBalance;
    }//Il costruttore va nella memoria HEAP e mi alloca la memoria inizializza le variabili di un oggetto al valore default e mi restituisce l'indirizzo

    //CREO IL TERZO CROSTRUTTORE E GLI PASSO GLI ALTRI 2
    public Account(double initialBalance, LocalDate creationDate){
        this(initialBalance);
        this.creationDate = creationDate;
    }

    //Il valore default degli oggetti sarà null e 0 per i numeri.
    public void printBalance() {
        System.out.printf("IL CONTO CON ID %d HA COME SALDO %f%n", this.id, this.bal);//This. l' indirizzo dell' oggetto su cui ho chiamato il metodo
        //Quando stamperò al posto di %d andrà id; al posto di %n andrà balance.

    }

    public double deposit(double amount) {
        bal += amount;
        return bal;
        Movement move = new Movement(amount, balance, LocalDateTime.now(), MovementType.DEPOSIT);
        movements.add(move);
    }

    public double withdraw(double amount) {
        doInternalOperation();
        Movement move = new Movement(account, balance, LocalDateTime.now(), MovementType.WITHDRAWAL);
        movements.add(move);
        bal -= amount;
        return bal;
    }

    private void doInternalOperation() {

    }

    public double getBalance() {
        return bal / 100;//Serve per vedere in ogni momento il saldo dove vado a chiamare il get ed è un INCAPSULAMENTO
    }

    public void setBalance(double newBalance) {
        if (newBalance <= 0) {
            return;
        }
        bal = newBalance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate cR) {
        creationDate = cR;
    }

}

//INCAPSULAMENTO: Lo stato di una classe deve essere privato (STATO: insieme delle sue variabili)
//PRIVATE: Non c'entra nulla con la sicurezza del file, è una questione di ingegneria del software
//usiamo PRIVATE così il programma non sa che esiste la variabile e ci permette di modificarla a nostro piacimento
//99% Lo stato di una classe sarà private, lo usiamo quindi quando vogliamo confinare i cambiamenti alla classe di definizione.
//Una classe incapsulata è più facile da utilizzare perchè uso gli oggetti chiamando i metodi

//Un ARRAY LIST è una struttura dati simile all'array; più intelligentee mi offre più possibilità
//Una delle principali feature è che si "autoridimensiona", se gli do 101 elementi e gli do il limite di 100,
//creerà una copia di se stesso più grande.