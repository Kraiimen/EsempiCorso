package org.generation.italy.gryffindor.library;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

public class Book {
    //        /---------/ ATTRIBUTI
    private String title;
    private double price;
    private int pages;
    private String authors;
    private Year year;
    private String editor;
    private Category cat;


    @Override
    public String toString() {
        String s = "Il titolo del libro è: " + title + "\n" +
                   "Il prezzo è: " + price + "\n" +
                   "Il numero di pagine è: " + pages + "\n" +
                   "Il libro è stato scritto da: " + authors + "\n" +
                   "L'anno di pubblicazione è: " + year.toString() + "\n" +
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
    public Year getYear() {
        return year;
    }
    public void setYear(Year y) {
        year = y;
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
