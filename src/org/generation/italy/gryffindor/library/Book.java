package org.generation.italy.gryffindor.library;

import java.time.Year;

public class Book {
    //         /-ATTRIBUTI-/
    private String title;
    private double price;
    private int pages;
    private String authors;
    private Year year;
    private String editor;
    private Category cat;

    @Override
    public String toString(){
        String s = "il titolo è: " + title + "\n" +
                   "il prezzo è: " + price + "\n" +
                   "il numero di pagine è: " + pages + "\n" +
                   "il libro è stato scritto da: " + authors + "\n" +
                   "l'anno di pubblicazione è:" + year.toString() + "\n" +
                   "l'editore è: " + editor + "\n" +
                   "la categoria è: " + cat.toString();
        return s;
    }


    //        /-METHODS-/ GETTER & SETTER
    public String getTitle(){
        return title;
    }
    public void setTitle(String t){
        title = t;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double pr){
        price = pr;
    }
    public int getPages(){
        return pages;
    }
    public void setPages(int p){
        pages = p;
    }
    public String getAuthors(){
        return authors;
    }
    public void setAuthors(String a){
        authors = a;
    }
    public Year getYear(){
        return year;
    }
    public void setYear(Year y){
        year = y;
    }
    public String getEditor(){
        return editor;
    }
    public void setEditor(String e){
        editor = e;
    }
    public Category getCategory(){
        return cat;
    }
    public void setCategory(Category c){
        cat = c;
    }

}

