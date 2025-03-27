package org.generation.italy.gryffindor.library.libraries;

import java.util.ArrayList;

public class Bookstore {
//    Creare una classe biblioteca.
//    La biblioteca avrà come suoi attributi un nome e una lista di oggetti di tipo libro.
//    Un libro è un oggetto che ha un titolo, un numero di pagine, un costo,
//    una stringa che rappresenta il nome dell'autore o autori (es:"Mario Rossi,Luca Bianchi" se sono piu di uno),
//    l'anno di pubblicazione e il nome della casa editrice. Infine ha anche una categoria.
//    Le categorie possibili sono: narrativa, saggistica, fantasy, storia e programmazione Java.
//    Voglio aggiungere una serie di metodi utili alla biblioteca.
//    In particolare vorrei un metodo che mi restituisca il numero totale dei libri che al momento contiene.
//    Vorrei un altro metodo che prende in input una categoria e mi restituisce il conteggio di tutti i libri presenti nella biblioteca
//    appartenenti a quella categoria.
//    Voglio un altro metodo che mi restituisce il costo totale di tutti i libri che hanno un certo autore di cui do nome e cognome tra i suoi autori.
//    Infine un metodo che mi stampa tutti i dati di un libro di cui io do il titolo. Se ci fossero piu libri con lo stesso titolo, me li deve stampare tutti.

    // /-----------/ ATTRIBUTI (FIELDS) /-----------/
    private String name;
    private ArrayList books;

    // /-----------/ CONSTRUCTORS /-----------/
    public Bookstore(String name){
        this.name = name;
        books = new ArrayList();
    }

    // /-----------/ METHODS /-----------/
    public void addBook(Book b){
        //se uso un metodo (non-statico) su un oggetto null il programma crasha
        //con l'eccezione "nullPointerException" (o qualcosa del gene)
        if(books == null) {
            return;     //esce dal metodo
        }
        //aggiungo il libro alla lista solo se non è null
        if(books != null){
            books.add(b);
        }
    }

    public int getTotalBooks(){
        //leggi commento a riga 31
        if(books == null) {
            return 0;   //se la lista è null, dico che contiene 0 libri
        }
        return books.size();    //stiamo contando anche possibili libri null (ma anche stica... non mi va di correggere)
    }

    public int booksByCategory(Category c){
        //leggi commento a riga 31
        if(books == null) {
            return 0;   //se la lista è null, dico che contiene 0 libri nella categoria richiesta
        }
        int totBooks = 0;
        if(containsOnlyBooks()){
            for(Object obj : books) {
                if(obj == null){
                    continue;       //se il libro è null lo salto
                }
                Book b = (Book)obj;

                if (b.getCategory() == c) {
                    totBooks++;
                }
            }
        }
        return totBooks;
    }

    //Nome & Cognome in input sono una string singola, se è null o stringa vuota mi da il costo di tutti i libri
    public double totCostByAuthor(String authorFullName){
        //leggi commento a riga 31
        if(books == null) {
            return 0;   //se la lista è null, dico che nn ci sono libri di quell'autore
        }
        boolean isInputNullOrEmpty = authorFullName == null || authorFullName.isBlank();

        double totCost = 0;
        if(containsOnlyBooks()){
            for(Object obj : books) {
                if(obj == null){
                    continue;       //se il libro è null lo salto
                }
                Book b = (Book)obj;

                //Se il nome dato in input è null o vuoto, prendo i costi di tutti i libri
                if(isInputNullOrEmpty){
                    totCost += b.getPrice();
                }else{
                    //Leggi il commento in riga 31,
                    //Non ho bisogno di fare lo stesso controllo per il nome in input perchè l'ho già fatto nell'if (riga 87)
                    boolean isAuthorsNotNull = b.getAuthors() == null;
                    //.trim() = restituisce la stringa senza gli spazi vuoti ad inizio e fine della stringa
                    //.toUpperCase() = restituisce la stringa con tutti i caratteri in maiuscolo
                    //(per fare il controllo non-case-sensitive i.e. se converto tutte le stringhe che sto controllando in maiuscole,
                    //non importa quali lettere fossero maiuscole o minuscole nelle stringhe originali)
                    //.contains() = restituisce true se l'input è contenuto all'interno della stringa su cui lo uso
                    boolean isInputInAuthors = isAuthorsNotNull && b.getAuthors().trim().toUpperCase().contains(authorFullName.trim().toUpperCase());
                    if(isInputInAuthors){
                        totCost += b.getPrice();
                    }
                }
            }
        }
        return totCost;
    }

    public void printData(String title) {
        //leggi commento a riga 31
        if(books == null) {
            return;   //se la lista è null non stampo nulla
        }

        boolean isInputNullOrEmpty = title == null || title.isBlank();

        if(containsOnlyBooks()) {
            for (Object obj : books) {
                if(obj == null){
                    continue;       //se il libro è null lo salto
                }
                Book b = (Book) obj;

                boolean isTitleNotNull = b.getTitle() != null;

                //.equalsIgnoreCase() per evitare di dover fare il .toUpperCase() su entrambe le stringhe
                //(non andate a leggere come fa... ci ho provato e non mi ha fatto bene alla salute, fidatevi)
                if(isInputNullOrEmpty || (isTitleNotNull && b.getTitle().trim().equalsIgnoreCase(title.trim()))){
                    //tecnicamente non necessario scrivere .toString() perchè il print lo fa in automatico
                    //(noi lo scriviamo perchè vogliamo esplicitare che abbiamo modificato il .toString() basilare della classe)
                    System.out.println(b.toString());
                    System.out.println();
                }
            }
        }
    }

    // Metodo che ritorni la categoria a cui appartengono più libri
    public Category mostCommonCategory(){
        //leggi commento a riga 31
        if(books == null) {
            return null;
        }

        int max = 0;
        Category result = null;

        for(Category c : Category.values()){
            int booksPerCategory = 0;

            if(containsOnlyBooks()){
                for(Object obj : books){
                    if(obj == null){
                        continue;       //se il libro è null lo salto
                    }
                    Book b = (Book) obj;
                    if(b.getCategory() == c){
                        booksPerCategory++;
                    }
                }
                if(booksPerCategory>max){
                    max=booksPerCategory;
                    result = c;
                }
            }
        }
        return result;
    }

    // /-----------/ METHODS - UTILITY /-----------/
    private boolean containsOnlyBooks(){
        for(Object obj : books){
            if(obj.getClass() != Book.class){
                return false;
            }
        }
        return true;
    }

    // /-----------/ METHODS - GETTER & SETTER /-----------/
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
    public ArrayList getBooks(){
        return books;
    }
    public void setBooks(ArrayList b){
        if(b == null){
            return;
        }
        books = b;
    }
}
