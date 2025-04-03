package org.generation.italy.ravenClaw.library;


import java.time.Year;

public class Book {

    //ISTANCE FIELDS
    private String title;
    private int pages;
    private double price;
    private String authors;
    private Year publishYear;
    private String editor;
    private Genre genre;

    //COSTRUTTORI
    public Book(String title, int pages, double price, String authors, Year publishYear, String editor, Genre genre) {
        this.title = title;
        this.pages = pages;
        this.price = price;
        this.authors = authors;
        this.publishYear = publishYear;
        this.editor = editor;
        this.genre = genre;
    }

    //metodi
    public void printDetails() {
        System.out.println("Titolo: " + title);
        System.out.println("N° Pagine: " + pages);
        System.out.println("Prezzo: " + price);
        System.out.println("Autore: " + authors);
        System.out.println("Anno di Pubblicazione: " + publishYear);
        System.out.println("Casa Editrice: " + editor);
        System.out.println("Genere: " + genre);
    }


    //getter e setter
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public int getPages() {return pages;}
    public void setPages(int pages) {this.pages = pages;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public String getAuthors() {return authors;}
    public void setAuthors(String authors) {this.authors = authors;}

    public Year getPublishYear() {return publishYear;}
    public void setPublishYear(Year year) {this.publishYear = publishYear;}

    public String getEditor() {return editor;}
    public void setEditor(String editor) {this.editor = editor;}

    public Genre getGenre() {return genre;}
    public void setGenre(Genre genre) {this.genre = genre;}


}
