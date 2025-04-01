package org.generation.italy.libraryProject.model;
import java.time.Year;

public class Book {
    private String title;
    private double price;
    private int pages;
    private String author;
    private String editor;
    private Year year;
    private Category category;

//              /Setter & Getter/

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public void setPages(int pages){
        this.pages = pages;
    }
    public int getPages(){
        return pages;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }
    public void setEditor(String editor){
        this.editor = editor;
    }
    public String getEditor(){
        return editor;
    }
    public void setYear(Year year){
        this.year = year;
    }
    public Year getYear(){
        return year;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public Category getCategory(){
        return category;
    }

//              /COSTRUTTORE/
    public Book(){
    }
    public Book(String title, double price, int pages, String author, String editor, Year year, Category category){
        this.title = title;
        this.price = price;
        this.pages = pages;
        this.author = author;
        this.editor = editor;
        this.year = year;
        this.category = category;
    }



    public String toString(){
       return "title: " + title + " price: " + price + " pages: " + pages + " author:" + author + " editor :" + editor +
       " year: " + year + " category:" + category;
    }

}
