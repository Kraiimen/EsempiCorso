package org.generation.italy.libraryProject.library;
import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList booksList;

    public Library(String name) {  //
        this.name = name;
        booksList = new ArrayList();
    }
    // Funzione per il totale dei libri nella Library

    public int totalBooks() {  // ricaviamo la somma dei libri senza condizioni perchè arraylist è nella classe
        return booksList.size();
    }

    // Funzione per aggiungere i libri alla Library

    public void addBook(String title, int numPages, double cost, String author, LocalDate yearPub, String pubHouse, Category categoryType) {
        Book b = new Book(title, numPages, cost, author, yearPub, pubHouse, categoryType);
        booksList.add(b);// usaimo il metodo add per aggiungere i  libri nella library
    }
    // Funzione per calcolare il totale by category

    public int totalByCategory(Category categoryType) {
        int sum = 0;
        for (int i = 0; i < booksList.size(); i++) { // size() riprende la lunghezza dell'array
            Book b1 = (Book) booksList.get(i); //prende uno specifica cella nell'array in base alla condizone
            if (b1.getCategoryType() == categoryType) {
                sum++;
            }
        }
        return sum;
    }

    // Funzione per stampare il titolo di un libro
    public void printBooks() {
        for (Object o : booksList) {
            Book b = (Book) o;
            System.out.println(b);
        }
    }

    // Funzione per restituire il costo totale di tutti i libri dello stesso autore

    public double totalCostByAuthor(String author) {
        double costTotal = 0;
        for (Object o : booksList) { // for each simile al fro ,per ogni oggetto di tipo Oggetto che si torva all'interno di booklist
            Book b = (Book) o;
            if (b.getAuthor().equals(author)) {
                costTotal += b.getCost();
            }
        }
        return costTotal;
    }

    // Funzione per stampare il titolo di un libro
    public void printBookByTitle(String title) {
        for (Object o : booksList) {
            Book b = (Book) o;
            if (b.getTitle().equals(title)) {
                System.out.println(b);
            }
        }
    }

    public Category getMostPopularCategory(){
        Category[] categories = Category.values();
        int[] categoryCounter = new int[categories.length]; // crea un array con tutte le category esistenti anche se ne aggiugiamo altre
        for(Object obj : booksList){
            Book b = (Book)obj;
            for(int i = 0; i < categoryCounter.length; i++){
                if (categories[i] == b.getCategoryType()){
                    categoryCounter[i]++;
                    break;
                }
            }
        }
        int max = 0;
        int pos = 0;
        for(int i = 0; i < categoryCounter.length; i++){
            if (categoryCounter[i] > max){
                max = categoryCounter[i];
                pos = i; // ci da la posizione dell max nell'array
            }
        }
        return categories[pos];
    }




}
