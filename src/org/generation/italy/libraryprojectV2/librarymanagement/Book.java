package org.generation.italy.libraryprojectV2.librarymanagement;

public class Book {
//    private int id;
    private String title;
    private int numPages;
    private double price;
    private String authors;
    private int releaseDate;
    private String publishingHouse;
    private Categories category;

    // Costruttore
    public Book(String title, int numPages, double price, String authors, int releaseDate, String publishingHouse, Categories category) {
        this.title = title;
        this.numPages = numPages;
        this.price = price;
        this.authors = authors;
        this.releaseDate = releaseDate;
        this.publishingHouse = publishingHouse;
        this.category = category;
    }

    // Getters
    public String getTitle() {
        return title;
    }
    public int getNumPages() {
        return numPages;
    }
    public double getPrice() {
        return price;
    }
    public String getAuthors() {
        return authors;
    }
    public int getReleaseDate() {
        return releaseDate;
    }
    public String getPublishingHouse() {
        return publishingHouse;
    }
    public Categories getCategory() {
        return category;
    }

    // Setters
//    public void setId(int id) {
//        this.id = id;
//    }
}
