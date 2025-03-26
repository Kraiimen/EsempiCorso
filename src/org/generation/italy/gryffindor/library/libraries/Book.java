package org.generation.italy.gryffindor.library.libraries;

import java.time.Year;

public class Book {
    //        /---------/ ATTRIBUTI
    private String title;
    private double price;
    private int pages;
    private String authors;
    private Year release;
    private String editor;
    private Category cat;

    //        /---------/ CONSTRUCTORS

    public Book(String title, double price, int pages, String authors, Year release, String editor, Category cat) {
        this.title = title;
        this.price = price;
        this.pages = pages;
        this.authors = authors;
        this.release = release;
        this.editor = editor;
        this.cat = cat;
    }


    @Override
    public String toString() {
        String s = "Il titolo del libro è: " + title + "\n" +
                   "Il prezzo è: " + price + "\n" +
                   "Il numero di pagine è: " + pages + "\n" +
                   "Il libro è stato scritto da: " + authors + "\n" +
                   "L'anno di pubblicazione è: " + release.toString() + "\n" +
                   "L'editore è: " + editor + "\n" +
                   "La categoria è: " + cat.toString();
        return s;
    }
    //toString serve a convertire tutti i valori di una classe in una Stringa


    //          /-METHODS-/ GETTER & SETTER
    public String getTitle() {
        return title;
    }
    public void setTitle(String t)  {
        title = t;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double p) {
        price = p;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int p) {
        pages = p;
    }
    public String getAuthors() {
        return authors;
    }
    public void setAuthors(String a) {
        authors = a;
    }
    public Year getRelease() {
        return release;
    }
    public void setRelease(Year y) {
        release = y;
    }
    public String getEditor() {
        return editor;
    }
    public void setEditor(String edit) {
        editor = edit;
    }
    public Category getCategory() {
        return cat;
    }
    public void setCategory(Category c) {
        cat = c;
    }

}
