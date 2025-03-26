package org.generation.italy.gryffindor.library.startup;

import org.generation.italy.gryffindor.library.libraries.*;

import java.time.Year;

public class Start {
    public static void main(String[] args) {
        Book b1 = new Book("Java", 60, 320, "Riccardo Audano, Federico De Simone", Year.of(2025), "Generation", Category.PROGRAMMING);
        Book b2 = new Book("Java", 50, 120, "Piero Scarcina, Emanuele Giustiniani, Federico De Simone", Year.of(2025), "Gryffindor", Category.PROGRAMMING);
        Book b3 = new Book("Divina Commedia", 90, 1000, "Dante Alighieri", Year.of(1321), "Alighieri &Co", Category.NARRATIVE);

        Bookstore bs = new Bookstore("Libreria");
        bs.addBook(b1);
        bs.addBook(b2);
        bs.addBook(b3);

        // /------/ METHODS CALLING
        System.out.println("Tot libri: " + bs.getTotalBooks());
        System.out.println("Libri nella categoria Programmazione: " + bs.booksByCategory(Category.PROGRAMMING));
        System.out.println("Totale costo libri di Federico De Simone: " + bs.totCostByAuthor("Federico de Simone")); //d minuscola per verificare che non risulti in errore

        System.out.println("Dati dei libri Java:");
        bs.printBookData("Java");

        System.out.println("La categoria di libri più comune " + bs.mostCommonCategory());

    }
}
