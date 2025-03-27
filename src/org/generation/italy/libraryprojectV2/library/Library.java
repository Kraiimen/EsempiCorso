// Creare una classe biblioteca.

// La biblioteca avrà come suoi attributi un nome e una lista di oggetti di tipo libro.

// Un libro è un oggetto che ha
// un titolo, -un numero di pagine, -un costo, - una stringa che rappresenta il nome dell'autore o autori
// (es:"Mario Rossi,Luca Bianchi" se sono piu di uno), - l'anno di pubblicazione e - il nome della casa editrice.
// Infine ha anche una categoria.

// Le categorie possibili sono: - narrativa, - saggistica, - fantasy, - storia e -programmazione Java.

// Voglio aggiungere una serie di metodi utili alla biblioteca.
// In particolare vorrei un metodo che mi restituisca il numero totale dei libri che al momento contiene.
// Vorrei un altro metodo che prende in input una categoria e mi restituisce il conteggio di tutti i libri presenti nella biblioteca appartenenti a quella categoria.
// Voglio un altro metodo che mi restituisce il costo totale di tutti i libri che hanno un certo autore di cui do nome e cognome tra i suoi autori.
// Infine un metodo che mi stampa tutti i dati di un libro di cui io do il titolo. Se ci fossero piu libri con lo stesso titolo, me li deve stampare tutti.

package org.generation.italy.libraryprojectV2.library;

import org.generation.italy.libraryprojectV2.librarymanagement.Book;
import org.generation.italy.libraryprojectV2.librarymanagement.Categories;
import org.generation.italy.libraryprojectV2.librarymanagement.BooksManagement;

public class Library {
    public static void main(String[] args) {
        BooksManagement bm = new BooksManagement();

        // Creiamo oggetti di tipo Book
        bm.addBook(new Book("Harry Potter and the Sorcerer's Stone", 309, 10.99, "J.K. Rowling", 1997, "Bloomsbury", Categories.FANTASY));
        bm.addBook(new Book("Harry Potter and the Chamber of Secrets", 341, 11.99, "J.K. Rowling", 1998, "Bloomsbury", Categories.FANTASY));
        bm.addBook(new Book("Harry Potter and the Prisoner of Azkaban", 435, 12.99, "J.K. Rowling", 1999, "Bloomsbury", Categories.FANTASY));
        bm.addBook(new Book("The Great Gatsby", 180, 10.99, "F. Scott Fitzgerald", 1925, "Scribner", Categories.FICTION));
        bm.addBook(new Book("The Great Gatsby", 200, 12.49, "F. Scott Fitzgerald", 2021, "Penguin Classics", Categories.FICTION));
        bm.addBook(new Book("To Kill a Mockingbird", 281, 14.99, "Harper Lee", 1960, "J.B. Lippincott & Co.", Categories.FICTION));
        bm.addBook(new Book("1984", 328, 13.49, "George Orwell", 1949, "Secker & Warburg", Categories.FICTION));
        bm.addBook(new Book("Sapiens: A Brief History of Humankind", 443, 18.99, "Yuval Noah Harari", 2011, "Harper", Categories.NON_FICTION));
        bm.addBook(new Book("Educated", 334, 16.99, "Tara Westover", 2018, "Random House", Categories.NON_FICTION));
        bm.addBook(new Book("The Power of Habit", 371, 15.99, "Charles Duhigg", 2012, "Random House", Categories.NON_FICTION));
        bm.addBook(new Book("The Hobbit", 310, 12.99, "J.R.R. Tolkien", 1937, "George Allen & Unwin", Categories.FANTASY));
        bm.addBook(new Book("The Name of the Wind", 662, 17.99, "Patrick Rothfuss", 2007, "DAW Books", Categories.FANTASY));
        bm.addBook(new Book("Mistborn: The Final Empire", 541, 14.99, "Brandon Sanderson", 2006, "Tor Books", Categories.FANTASY));
        bm.addBook(new Book("The Diary of a Young Girl", 283, 11.99, "Anne Frank", 1947, "Contact Publishing", Categories.HISTORY));
        bm.addBook(new Book("Guns, Germs, and Steel", 480, 19.99, "Jared Diamond", 1997, "W. W. Norton & Company", Categories.HISTORY));
        bm.addBook(new Book("Effective Java", 412, 39.99, "Joshua Bloch", 2008, "Addison-Wesley", Categories.JAVA_CODING));
        bm.addBook(new Book("Java: The Complete Reference", 1248, 45.99, "Herbert Schildt", 2021, "McGraw Hill", Categories.JAVA_CODING));

        // Numero totale di libri
        System.out.println("\nNumero di libri nella libreria: "+bm.getBooksCounter());

        // Numero di libri di una categoria
        System.out.println("\nNumero di libri di narrativa: "+bm.getNumberOfBooksByCategories(Categories.FICTION));
        System.out.println("Numero di libri di saggistica: "+bm.getNumberOfBooksByCategories(Categories.NON_FICTION));
        System.out.println("Numero di libri fantasy: "+bm.getNumberOfBooksByCategories(Categories.FANTASY));
        System.out.println("Numero di libri di storia: "+bm.getNumberOfBooksByCategories(Categories.HISTORY));
        System.out.println("Numero di libri sulla programmazione java: "+bm.getNumberOfBooksByCategories(Categories.JAVA_CODING));

        // Costo totale di libri di un autore specifico
        System.out.println("\nCosto totale di tutti i libri di J.K. Rowling: €"+bm.getTotalCostOfBooksByAuthor("J.K. Rowling"));
        System.out.println("Costo totale di tutti i libri di J.R.R. Tolkien: €"+bm.getTotalCostOfBooksByAuthor("J.R.R. Tolkien"));
        System.out.println("Costo totale di tutti i libri di F. Scott Fitzgerald: €"+bm.getTotalCostOfBooksByAuthor("F. Scott Fitzgerald"));

        // Dati di un libro per titolo
        bm.getBooksByTitle("The Great Gatsby");
    }
}
