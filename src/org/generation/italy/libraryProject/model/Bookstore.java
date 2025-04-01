package org.generation.italy.libraryProject.model;

import java.util.ArrayList;

public class Bookstore {
    private String name;
    private ArrayList<Book> books;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setBooks(ArrayList<Book> books){
        this.books = books;
    }
    public ArrayList<Book> getBooks(){
        return books;
    }
 //             /  Costruttori /
    public Bookstore(){
    }
    public Bookstore(String name, ArrayList<Book> books){
        this.name = name;
        this.books = books;
    }

    public void totLibriConConteggio(){
        int sum = 0;
        for(int i = 0; i < books.size() ; i++) {
            sum++;
        }
        System.out.println("il totale dei libri è: " + sum);
    }

    public int totLibriConSize(){
        if(books == null){
            return 0;
        }else{
            return books.size();
        }
    }
    public void addBooktoList(Book book){
        books.add(book);
    }

    public int totBooksForCategory(Category category){
        int maxbookcat = 0;
        for(int i = 0; i < books.size() ; i++){

            if(books.get(i).getCategory() != null && books.get(i).getCategory().equals(category)){
                maxbookcat++;
            }
        }
        return maxbookcat;
    }
    public double totPriceAuBooks(String author){
        double totPrice = 0.0;
        for(int i = 0 ; i<books.size() ; i++){
            if(books.get(i).getAuthor() != null && books.get(i).getAuthor().equals(author)){
                totPrice+= books.get(i).getPrice();
            }
        }
        return totPrice;
    }
    public void printInfo(String title){
        for(int i = 0; i < books.size() ; i++){
            if(books.get(i).getTitle() !=null && books.get(i).getTitle().equals(title)){
                System.out.println(books.get(i).toString());
            }

        }

    }


}
