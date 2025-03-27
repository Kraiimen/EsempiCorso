package org.generation.italy.gryffindor.library.libraries;

import java.time.Year;

public class Book {
    // /-----------/ ATTRIBUTI (FIELDS) /-----------/
    private String title;
    private double price;
    private int pages;
    private String authors;
    private Year release;
    private String editor;
    private Category cat;

    // /-----------/ CONSTRUCTORS /-----------/
    public Book(String title, double price, int pages, String authors, Year release, String editor, Category cat){
        this.title = title;
        this.price = price;
        this.pages = pages;
        this.authors = authors;
        this.release = release;
        this.editor = editor;
        this.cat = cat;
    }

    // /-----------/ METODI /-----------/
    @Override   //MAGIA (∩ ͡° ͜ʖ ͡°)⊃━☆ﾟ. *
    public String toString(){
        //non dovrebbe essere necessario fare release.toString() e cat.toString(), però just in case (poi controllerò)
        String s = "il titolo è: " + title + "\n" +
                   "il prezzo è: " + price + "\n" +
                   "il numero di pagine è: " + pages + "\n" +
                   "il libro è stato scritto da: " + authors + "\n" +
                   "l'anno di pubblicazione è:" + release.toString() + "\n" +
                   "l'editore è: " + editor + "\n" +
                   "la categoria è: " + cat.toString();
        return s;
    }


    // /-----------/ METHODS - GETTER & SETTER /-----------/
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
    public Year getRelease(){
        return release;
    }
    public void setRelease(Year y){
        release = y;
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

