package org.generation.italy.libraryProject.starter;

import org.generation.italy.libraryProject.library.Category;
import org.generation.italy.libraryProject.library.Library;

import java.time.LocalDate;

public class Start {
    public static void main(String[] args) {
        Library library1 = new Library("ReadingHouse");
        library1.addBook("1984", 100, 50.0, "George Orwell", LocalDate.of(1948, 1 , 8), "Feltrinelli", Category.NARRATIVA);
        library1.addBook("Fattoria degli animali", 100, 10.0, "George Orwell", LocalDate.of(1945, 1 , 8), "Feltrinelli", Category.FANTASY);
        library1.addBook("Fantasie", 100, 70.0, "George Orwell", LocalDate.of(1945, 1 , 8), "Feltrinelli", Category.SAGGISTICA);
        library1.addBook("1984", 100, 50.0, "George Orwell", LocalDate.of(1948, 1 , 8), "Feltrinelli", Category.FANTASY);

        int totalByCategory = library1.totalByCategory(Category.NARRATIVA);
        System.out.println(totalByCategory);
        library1.printBooks();

        double totalCost = library1.totalCostByAuthor("George Orwell");
        System.out.println(totalCost);

        library1.printBookByTitle("1984");

        Category c = library1.getMostPopularCategory();
        System.out.println("La categoria popolare è " + c);



    }
}