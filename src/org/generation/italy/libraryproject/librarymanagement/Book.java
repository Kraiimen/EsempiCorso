package org.generation.italy.libraryproject.librarymanagement;

import java.util.ArrayList;

public class Book {
    private static int booksCounter = 0;
    private static int fictionCounter = 0;
    private static int nonFictionCounter = 0;
    private static int fantasyCounter = 0;
    private static int historyCounter = 0;
    private static int javaCodingCounter = 0;
    private static ArrayList booksArrayList = new ArrayList();
    private String title;
    private int numPages;
    private double price;
    private String authors;
    private int releaseDate;
    private String publishingHouse;
    private Categories category;

    // COSTRUTTORI
    public Book(String title, int numPages, double price, String authors, int releaseDate, String publishingHouse, Categories category) {
        this.title = title;
        this.numPages = numPages;
        this.price = price;
        this.authors = authors;
        this.releaseDate = releaseDate;
        this.publishingHouse = publishingHouse;
        this.category = category;

        incrementCounter(category);
        booksArrayList.add(this);
    }

    // METODI
    private void incrementCounter(Categories category){
        booksCounter++;
        if(category == Categories.FICTION){
            fictionCounter++;
        }else if(category == Categories.NON_FICTION){
            nonFictionCounter++;
        }else if(category == Categories.FANTASY){
            fantasyCounter++;
        }else if(category == Categories.HISTORY){
            historyCounter++;
        }else{
            javaCodingCounter++;
        }
    }

    public int getNumberOfBooksByCategories(Categories category){
        if(category == Categories.FICTION){
            return fictionCounter;
        }else if(category == Categories.NON_FICTION){
            return nonFictionCounter;
        }else if(category == Categories.FANTASY){
            return fantasyCounter;
        }else if(category == Categories.HISTORY){
            return historyCounter;
        }else if (category == Categories.JAVA_CODING){
            return javaCodingCounter;
        }else{
            return 0;
        }
    }

    public double getTotalCostOfBooksByAuthor(String authors){
        double totalCost = 0;
        for(Object obj : booksArrayList){
            Book b = (Book) obj;
            if(b.authors.equals(authors)){
                totalCost += b.price;
            }
        }
        return totalCost;
    }

    public void getBooksByTitle(String title){
        String format = "Titolo: %s | Numero di pagine: %d | Costo: %f | Autore/i: %s | Anno di pubblicazione: %d | Casa editrice: %s | Categoria: %s";
        for(Object obj : booksArrayList){
            Book b = (Book) obj;
            if(b.title.equals(title)){
                System.out.printf(format, b.title, b.numPages, b.price, b.authors, b.releaseDate, b.publishingHouse, b.category.toString());
            }
        }
    }

    public int getBooksCounter() {
        return booksCounter;
    }
}
