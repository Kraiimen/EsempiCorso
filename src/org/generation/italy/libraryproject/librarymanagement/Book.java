package org.generation.italy.libraryproject.librarymanagement;

public class Book {
    private static int booksCounter = 0;
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
        booksCounter++;
    }

    public int getBooksCounter() {
        return booksCounter;
    }

}
