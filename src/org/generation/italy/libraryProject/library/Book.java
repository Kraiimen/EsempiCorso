package org.generation.italy.libraryProject.library;

import java.time.LocalDate;

public class Book {
    private String title;   // Variabili di istanza dell oggetto
    private int numPages;
    private double cost;
    private String author;
    private LocalDate yearPub;
    private String pubHouse;
    private Category categoryType;

    public Book(String title, int numPages, double cost, String author, LocalDate yearPub, String pubHouse, Category categoryType) {
        this.title = title;
        this.numPages = numPages;
        this.cost = cost;
        this.author = author;
        this.yearPub = yearPub;
        this.pubHouse = pubHouse;
        this.categoryType = categoryType;
    }

    public String getTitle() {
        return title;
    }

    public int getNumPages() {
        return numPages;
    }
    public double getCost() {
        return cost;
    }
    public String getAuthor() {
        return author;
    }
    public LocalDate getYearPub() {
        return yearPub;
    }
    public String getPubHouse() {
        return pubHouse;
    }
    public Category getCategoryType() {
        return categoryType;
    }
  // Se implementiamo questo metodo verrà chiamato automaticamente quando manderò ìn input un oggetto.
    @Override
    public String toString(){
        return "Title: "+ title + "\nNumPages: " + numPages + "\nCost: " + cost + "\nAuthor: " + author + "\nYear of Publication: " + yearPub + "\nPublishingHouse: "+ pubHouse + "\nCategory Type: "+ categoryType;
    }

}


