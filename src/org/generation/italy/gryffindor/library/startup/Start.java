package org.generation.italy.gryffindor.library.startup;

import org.generation.italy.gryffindor.library.libraries.*;

import java.time.Year;

public class Start {

    public static void main(String[] args){
        Book b1 = new Book("Java",60,320,"Riccardo Audano,FedErico De SimOne", Year.of(2025),"Generation",Category.PROGRAMMING);
        Book b2 = new Book("Java",60,275,"Piero Scarcina,Emanuele Giustiniani, Federico de Simone", Year.of(2025),"Gryffindor",Category.PROGRAMMING);
        Book b3 = new Book("Divina Commedia",80,1000,"Dante Alighieri", Year.of(1321),"Alighieri &Co",Category.NARRATIVE);

        Bookstore bs = new Bookstore("Libreria");
        bs.addBook(b1);
        bs.addBook(b2);
        bs.addBook(b3);

        System.out.println("Tot libri: "+ bs.getTotalBooks());
        System.out.println("I libri nella categoria programmazione: "+ bs.booksByCategory(Category.PROGRAMMING));
        System.out.println("Il costo dei libri di Federico De Simone equivale a: "+ bs.totCostByAuthor("Federico De Simone"));
        System.out.println("Dati dei libri Java:");
        bs.printData("Java");
        System.out.println("Categoria più comune: "+ bs.mostCommonCategory());
    }
}
