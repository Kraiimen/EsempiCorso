package org.generation.italy.libraryprojectV2.librarymanagement;

public class Book {
//    private int id;
    private String title;
    private int pageCount;
    private double price;
    private String authors;
    private int releaseDate;
    private String publisher;
    private Categories category;

    // Costruttore
    public Book(String title, int pageCount, double price, String authors, int releaseDate, String publisher, Categories category) {
        this.title = title;
        this.pageCount = pageCount;
        this.price = price;
        this.authors = authors;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
        this.category = category;
    }

    // Getters
    public String getTitle() {
        return title;
    }
    public int getPageCount() {
        return pageCount;
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
    public String getPublisher() {
        return publisher;
    }
    public Categories getCategory() {
        return category;
    }

    // Setters
//    public void setId(int id) {
//        this.id = id;
//    }
}
