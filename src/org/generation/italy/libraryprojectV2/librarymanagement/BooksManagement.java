package org.generation.italy.libraryprojectV2.librarymanagement;

import java.util.ArrayList;

public class BooksManagement {
    private int booksCounter;
    private int fictionCounter;
    private int nonFictionCounter;
    private int fantasyCounter;
    private int historyCounter;
    private int javaCodingCounter;

    // ArrayList dove andranno gli oggetti di tipo Book
    private ArrayList books;

    public BooksManagement(){
        books = new ArrayList();
    }

    // METODI

    // Aggiunge il libro creato all'ArrayList e aumenta il contatore dei libri
    public void addBook(Book book){
        books.add(book);
        booksCounter++;

        // Aumenta il contatore dei libri di una categoria specifica
        incrementCategoryCounter(book.getCategory());

//        book.setId(booksCounter);
    }

    // Incrementa il contatore dei libri generale e della categoria specifica
    private void incrementCategoryCounter(Categories category){
        if(category == Categories.FICTION){
            fictionCounter++;
        }else if(category == Categories.NON_FICTION){
            nonFictionCounter++;
        }else if(category == Categories.FANTASY){
            fantasyCounter++;
        }else if(category == Categories.HISTORY){
            historyCounter++;
        }else{
            javaCodingCounter++;
        }
    }

    // Metodo che ritorna il numero di libri per categoria
    public int getNumberOfBooksByCategories(Categories category){
        if(category == Categories.FICTION){
            return fictionCounter;
        }else if(category == Categories.NON_FICTION){
            return nonFictionCounter;
        }else if(category == Categories.FANTASY){
            return fantasyCounter;
        }else if(category == Categories.HISTORY){
            return historyCounter;
        }else if (category == Categories.JAVA_CODING){
            return javaCodingCounter;
        }else{
            return 0;
        }
    }

    // Metodo che ritorna il costo totale dei libri per autore
    public double getTotalCostOfBooksByAuthor(String authors){
        double totalCost = 0;

        for(Object obj : books){
            Book book = (Book) obj;
            if(book.getAuthors().contains(authors)){
                totalCost += book.getPrice();
            }
        }

        return totalCost;
    }

    // Metodo che stampa i dati del libro in base al titolo
    public void getBooksByTitle(String title){
        String format = "\nTitolo: %s | Numero di pagine: %d | Costo: %f | Autore/i: %s | Anno di pubblicazione: %d | Casa editrice: %s | Categoria: %s";

        for(Object obj : books){
            Book b = (Book) obj;
            if(b.getTitle().equals(title)){
                System.out.printf(format, b.getTitle(), b.getPageCount(), b.getPrice(), b.getAuthors(), b.getReleaseDate(), b.getPublisher(), b.getCategory().toString());
            }
        }

    }

    public void categoryThatAppearsTheMost(){
        int max = fictionCounter;
    }

//    public String getBookTitle(int bookId){
//        Book b = (Book) booksArrayList.get(bookId-1);
//        return b.getTitle();
//    }

    // Getters
    public int getBooksCounter() {
        return books.size();
    }
}
