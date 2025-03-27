package org.generation.italy.ravenClaw.library;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Year;

public class Start {
    public static void main(String [] args){
        ArrayList books = new ArrayList(Arrays.asList(
                new Book("Il Signore degli Anelli", 1200, 35, "j.r.r. tolkien", Year.of(1954), "Bompiani", Genre.FANTASY),
                new Book("Lo Hobbit", 310, 15, "j.r.r. tolkien", Year.of(1937), "Bompiani", Genre.FANTASY),
                new Book("Il Silmarillion", 480, 20, "j.r.r. tolkien", Year.of(1977), "Bompiani", Genre.FANTASY),
                new Book("1984", 328, 12, "george orwell", Year.of(1949), "Mondadori", Genre.NARRATIVE),
                new Book("La fattoria degli animali", 144, 9, "george orwell", Year.of(1945), "Mondadori", Genre.NARRATIVE),
                new Book("Il codice Da Vinci", 523, 18, "dan brown", Year.of(2003), "Mondadori", Genre.NARRATIVE),
                new Book("Angeli e demoni", 616, 20, "dan brown", Year.of(2000), "Mondadori", Genre.NARRATIVE),
                new Book("Inferno", 522, 18, "dan brown", Year.of(2013), "Mondadori", Genre.NARRATIVE),
                new Book("Harry Potter e la Pietra Filosofale", 309, 15, "j.k. rowling", Year.of(1997), "Salani", Genre.FANTASY),
                new Book("Harry Potter e la Camera dei Segreti", 341, 16, "j.k. rowling", Year.of(1998), "Salani", Genre.FANTASY),
                new Book("Harry Potter e il Prigioniero di Azkaban", 450, 18, "j.k. rowling", Year.of(1999), "Salani", Genre.FANTASY),
                new Book("Il nome della rosa", 503, 20, "umberto eco", Year.of(1980), "Bompiani", Genre.NARRATIVE),
                new Book("Il pendolo di Foucault", 656, 22, "umberto eco", Year.of(1988), "Bompiani", Genre.NARRATIVE),
                new Book("La misteriosa fiamma della regina Loana", 452, 18, "umberto eco", Year.of(2004), "Bompiani", Genre.NARRATIVE),
                new Book("I promessi sposi", 720, 18, "alessandro manzoni", Year.of(1827), "Feltrinelli", Genre.NARRATIVE),
                new Book("La Divina Commedia", 798, 25, "dante alighieri", Year.of(1321), "Feltrinelli", Genre.HISTORY),
                new Book("Le cronache di Narnia", 768, 28, "c.s. lewis", Year.of(1950), "Mondadori", Genre.FANTASY),
                new Book("Il giovane Holden", 277, 14, "j.d. salinger", Year.of(1951), "Einaudi", Genre.NARRATIVE),
                new Book("Shining", 512, 19, "stephen king", Year.of(1977), "Sperling & Kupfer", Genre.NARRATIVE),
                new Book("It", 1232, 30, "stephen king", Year.of(1986), "Sperling & Kupfer", Genre.NARRATIVE),
                new Book("Misery", 400, 17, "stephen king", Year.of(1987), "Sperling & Kupfer", Genre.NARRATIVE),
                new Book("Guerra e pace", 1225, 35, "lev tolstoj", Year.of(1869), "Einaudi", Genre.NARRATIVE),
                new Book("Anna Karenina", 864, 28, "lev tolstoj", Year.of(1877), "Garzanti", Genre.NARRATIVE),
                new Book("Il Gattopardo", 448, 18, "giuseppe tomasi di lampedusa", Year.of(1958), "Feltrinelli", Genre.NARRATIVE),
                new Book("Moby Dick", 720, 20, "herman melville", Year.of(1851), "Feltrinelli", Genre.NARRATIVE),
                new Book("Io, robot", 224, 13, "isaac asimov", Year.of(1950), "Mondadori", Genre.FANTASY),
                new Book("Fondazione", 296, 15, "isaac asimov", Year.of(1951), "Mondadori", Genre.FANTASY),
                new Book("Frankenstein", 280, 14, "mary shelley", Year.of(1818), "Einaudi", Genre.NARRATIVE),
                new Book("Dracula", 418, 17, "bram stoker", Year.of(1897), "Mondadori", Genre.NARRATIVE),
                new Book("Programmazione Java guida completa", 1056, 45, "herbert schildt", Year.of(2021), "McGraw-Hill", Genre.JAVA_PROGRAMMING),
                new Book("Java The Complete Reference", 1248, 50, "herbert schildt", Year.of(2019), "McGraw-Hill", Genre.JAVA_PROGRAMMING),
                new Book("Effective Java", 416, 42, "joshua bloch", Year.of(2018), "Addison-Wesley", Genre.JAVA_PROGRAMMING),
                new Book("Head First Java", 720, 38, "kathy sierra", Year.of(2005), "O'Reilly", Genre.JAVA_PROGRAMMING),
                new Book("Java Concurrency in Practice", 384, 40, "brian goetz", Year.of(2006), "Addison-Wesley", Genre.JAVA_PROGRAMMING),
                new Book("Refactoring", 448, 41, "martin fowler", Year.of(2018), "Addison-Wesley", Genre.JAVA_PROGRAMMING),
                new Book("Clean Code", 464, 37, "robert c. martin", Year.of(2008), "Prentice Hall", Genre.JAVA_PROGRAMMING),
                new Book("La ragazza del treno", 306, 15, "paula hawkins", Year.of(2015), "Piemme", Genre.NARRATIVE),
                new Book("La storia infinita", 448, 18, "michael ende", Year.of(1979), "Longanesi", Genre.FANTASY),
                new Book("Il mondo di Sofia", 560, 20, "jostein gaarder", Year.of(1991), "Longanesi", Genre.NON_FICTION),
                new Book("Storia della filosofia occidentale", 856, 32, "bertrand russell", Year.of(1945), "TEA", Genre.NON_FICTION),
                new Book("Storia d'Italia", 752, 30, "indro montanelli", Year.of(1965), "Rizzoli", Genre.HISTORY),
                new Book("L’arte della guerra", 250, 18, "sun tzu", Year.of(500), "TEA", Genre.HISTORY),
                new Book("Cime tempestose", 416, 16, "emily brontë", Year.of(1847), "Feltrinelli", Genre.NARRATIVE),
                new Book("Orgoglio e pregiudizio", 432, 15, "jane austen", Year.of(1813), "Einaudi", Genre.NARRATIVE),
                new Book("Don Chisciotte della Mancia", 1072, 32, "miguel de cervantes", Year.of(1605), "Einaudi", Genre.NARRATIVE)
        ));
        Library library = new Library("Ravenclaw", books);
        System.out.println(library.getBiggestGenre());
        System.out.println(library.getTotalByAuthor("J.R.R. Tolkien"));
        System.out.println(library.getNumberBooks());
        library.printDetailsFromTitle("Cime Tempestose");


    }
}
