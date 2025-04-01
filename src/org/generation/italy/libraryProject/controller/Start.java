package org.generation.italy.libraryProject.controller;
import org.generation.italy.libraryProject.model.Book;
import org.generation.italy.libraryProject.model.Bookstore;
import org.generation.italy.libraryProject.model.Category;

import java.time.Year;
import java.util.ArrayList;

public class Start {
    public static void main(String[] args){


        Bookstore library = new Bookstore();
        library.setBooks(new ArrayList<Book>());

        int totBooks = library.totLibriConSize();
        System.out.println("il totale dei libri è: " + totBooks);

        Book libro1 = new Book();
        libro1.setAuthor("Bob Bravo");
        System.out.println(libro1.toString());


        Book libro2 = new Book("Harry Potter", 20.0 , 100, "Steph", "Mondadori", Year.of(2010), Category.FANTASY );
        System.out.println(libro2.toString());

        Book libro3 = new Book();
        libro3.setTitle("Bananae");
        libro3.setPrice(99.99);
        libro3.setPages(10);
        libro3.setAuthor("Miss Bananita");
        libro3.setEditor("Casa Bananopoli");
        libro3.setYear(Year.of(2011));
        libro3.setCategory(Category.HISTORY);

        Book libro4 = new Book();
        libro4.setTitle("Wisdommese");
        libro4.setPrice(9.99);
        libro4.setPages(199);
        libro4.setAuthor("MrSmart");
        libro4.setEditor("Amazon");
        libro4.setYear(Year.of(2010));
        libro4.setCategory(Category.ESSAY);

        Book libro5 = new Book();
        libro5.setTitle("Sorgesana");
        libro5.setPrice(1.99);
        libro5.setPages(6);
        libro5.setAuthor("Conad");
        libro5.setEditor("Sorgesana SpA");
        libro5.setYear(Year.of(2000));
        libro5.setCategory(Category.HISTORY);

        Book libro6 = new Book ( "Polpette", 5.99, 5 , "Mamma" , "Cucina" , Year.of(1997) , Category.PROGRAMMING);
        Book libro7 = new Book ( "Polpette", 5.99, 10 , "Mamma" , "taverna" , Year.of(1997) , Category.HISTORY);



        library.addBooktoList(libro1);
        library.addBooktoList(libro2);
        totBooks = library.totLibriConSize();
        System.out.println("il totale dei libri è: " + totBooks);

        int maxForCategory = library.totBooksForCategory(Category.FANTASY);
        System.out.println("il totale dei libri per la categoria Fantasy è: " + maxForCategory);

        double totPriceForAuthor = library.totPriceAuBooks("Steph");
        System.out.println("La somma del costo di tutti i libri di questo autore è : " + totPriceForAuthor);

        library.printInfo("Polpette");





    }

}
