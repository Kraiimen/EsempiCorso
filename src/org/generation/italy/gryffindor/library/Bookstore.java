package org.generation.italy.gryffindor.library;

import java.util.ArrayList;

public class Bookstore {
    //        /---------/ ATTRIBUTI
    private String name;
    private ArrayList books;

    //       /-METHODS-/
    public int getTotalBooks() {
        if (books == null) {
            return 0;
        }
        return books.size();
    }

    public int booksByCategory(Category c) {
        if (books == null) {
            return 0;
        }
        int totBooks = 0;
        if (containsOnlyBooks()) {
            for (Object obj : books) {
                Book b = (Book) obj;
                if (b.getCategory() == c) {  // == perchè è un enum
                    totBooks++;
                }
            }
        }
        return totBooks;
    }

    // Controllo che l'ArrayList contenga solo oggetti Book
    private boolean containsOnlyBooks(){
        for(Object obj : books){
            if(obj.getClass() != Book.class){  // getClass restituisce il tipo dell'oggetto e verifico che non sia diverso dalla classe Book
                return false;
            }
        }
        return true;
    }

    // Nome e cognome in input sono una singola Stringa
    public double totCostByAuthor(String authorFullName) {
        if (books == null) {
            return 0;
        }
        double totCost = 0;
        if (containsOnlyBooks()) {
            for (Object obj : books) {
                Book b = (Book)obj;
                if(b.getAuthors().trim().toUpperCase().contains(authorFullName.trim().toUpperCase())) {
                    totCost += b.getPrice();
                }
            }
        }
        return totCost;
    }

    public void printBookData(String title) {
        if (containsOnlyBooks()) {
            for (Object obj : books) {
                Book b = (Book)obj;
                if (b.getTitle().trim().toUpperCase().equals(title.trim().toUpperCase())) {
                    System.out.println(b.toString());
                    System.out.println();
                }
            }

    }


    //      /-METHODS-/-/ GETTER & SETTER
    public String getName() {
        return name;
    }
    public void setName(String n) {
        name = n;
    }
    public ArrayList getBooks() {
        return books;
    }
    public void setBooks(ArrayList b) {
        books = b;
    }

}
