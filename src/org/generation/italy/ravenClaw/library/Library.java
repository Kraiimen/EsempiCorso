package org.generation.italy.ravenClaw.library;

import java.util.ArrayList;

public class Library {

    private String name;
    private ArrayList bookList;

    //costruttore
    public Library(String name) {
        this.name = name;
        bookList = new ArrayList();
    }
    public Library(String name, ArrayList bookList) {
        this.name = name;
        this.bookList = bookList;
    }

    //metodi
    public int getNumberBooks() {
        return bookList.size();
    }
    public int getNumberByGenre(Genre genre) {
        int counter = 0;
        for(Object b : bookList) {
            Book book = (Book)b;
            if(book.getGenre() == genre) {
                counter++;
            }
        }
        return counter;
    }

//    public double getTotalByAuthor(String author) {
//        double sum = 0;
//        String authorLower = author.toLowerCase();
//        for(Object b : bookList) {
//            Book book = (Book)b;
//            String[] authorsNames = book.getAuthors().toLowerCase().split(",");
//            for(String name : authorsNames) {
//                if(name.equals(authorLower)) {
//                    sum += book.getPrice();
//                    break;
//                }
//            }
//        }
//        return sum;
//    }

    public double getTotalByAuthor2(String author) {
        double sum = 0;
        String authorLower = author.toLowerCase();
        for(Object b : bookList) {
            Book book = (Book)b;
            String authorsNames = book.getAuthors().toLowerCase();
            if(authorsNames.contains(authorLower)) {
                sum += book.getPrice();
            }
        }
        return sum;
    }
    public void printDetailsFromTitle(String title) {
        for(Object b : bookList) {
            Book book = (Book)b;
            String currentTitle = book.getTitle().toLowerCase();
            String inputTitle = title.toLowerCase();
            if(inputTitle.equals(currentTitle)) {
                book.printDetails();
                System.out.println();
            }
        }
    }
    public String getBiggestGenre() {
        int max = 0;
        String genre = "";
        for(Genre g : Genre.values()) {
            int numberOfBooksByGenre = getNumberByGenre(g);
            if(numberOfBooksByGenre > max) {
                max = numberOfBooksByGenre;
                genre = g.toString();
            }
        }
        return genre;
    }
}

//Metodo Bonus: ritornare la categoria che ha più libri. Non deve cambiare se aggiungo e tolgo categorie dal programma.