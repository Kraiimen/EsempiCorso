package org.generation.italy.gryffindor.library;

import java.util.ArrayList;
import java.util.Locale;

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
//         /--------/ ATTRIBUTI

    private String name;
    private ArrayList books;

    //          /------/ METHODS
    public int getTotalBooks(){
        if(books == null) {
            return 0;
        }
        return books.size();
    }

    public int booksByCategory(Category c){
        if(books == null) {
            return 0;
        }
        int totBooks = 0;
        if(containsOnlyBooks()){
            for(Object obj : books) {
                Book b = (Book)obj;
                if (b.getCategory() == c) {
                    totBooks++;
                }
            }
        }

        return totBooks;
    }
    private boolean containsOnlyBooks(){
        for(Object obj : books){
            if(obj.getClass() != Book.class){
                return false;
            }
        }
        return true;
    }
    //Nome & Cognome in input sono una string singola
    public double totCostByAuthor(String authorFullName){
        if(books == null) {
            return 0;
        }
        double totCost = 0;
        if(containsOnlyBooks()){
            for(Object obj : books) {
                Book b = (Book)obj;
                if(b.getAuthors().trim().toUpperCase().contains(authorFullName.trim().toUpperCase())){
                    totCost += b.getPrice();
                }
            }
        }
        return totCost;
    }
    public void printData(String title) {
        if(books == null) {
            return;
        }
        if(containsOnlyBooks()) {
            for (Object obj : books) {
                Book b = (Book) obj;
                if(b.getTitle().trim().toUpperCase().equals(title.trim().toUpperCase())){
                    System.out.println(b.toString());
                    System.out.println();
                }
            }
        }
    }
    // Metodo che ritorni la categoria a cui appartengono più libri
    public Category mostCommonCategory(){
        if(books == null) {
            return null;
        }

        int max = 0;
        for(Category c : Category.values()){
            int booksPerCategory = 0;
            if(containsOnlyBooks()){
                for(Object obj : books){
                    Book b = (Book) obj;
                }
            }


        }

    }

    //         /------/ METHODS /-/ GETTER & SETTER
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
        books = b;
    }

}
