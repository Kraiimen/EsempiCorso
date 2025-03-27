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


//ESERCIZIO
//
//Creare una Classe Biblioteca. La Biblioteca avrà come suoi attributi un nome, una lista di oggetti di tipo libro.
//Come è fatto un libro? Ha un titolo, ha un numero di pagine, ha un costo, ha una Stringa che rappresenta il nome dell’autore o degli autori, l’anno di pubblicazione e il nome della casa editrice.
//Infine un libro ha anche una categoria: quelle possibili sono Narrativa, Saggistica, Fantasy, Storia e Programmazione Java.
//Voglio aggiungere una serie di metodi alla biblioteca.
//Mi piacerebbe avere un metodo nella Biblio che mi restituisca il numero totale di libri che contiene.
//Poi vorrei un II metodo che prenda in input una categoria e mi restituisca il conteggio di tutti i libri presenti nella biblioteca e appartenenti a quella categoria.
//Voglio un altro metodo che mi restituisca il costo totale di tutti i libri che hanno un certo autore (di cui do nome e cognome) tra gli autori (da solo o insieme ad altri).
//E infine un metodo che mi stampi tutti i dati di un libro di cui io do il titolo. Se ci fossero più libri con lo stesso titolo me li deve stampare tutti.
//Voglio un metodo che mi ritorni la categoria a cui appartengono più libri. Non dobbiamo essere costretti a cambiarlo se in futuro aggiungessimo più categorie.
