package edoardo.library;
import edoardo.libraryManagement.Book; 

public class Library{
    public static void main(String[] args){
        Book b = new Book();//
        System.out.println(b.getAuthor());
        System.out.println(b.getTitle());
        System.out.println(b.getNPages());
        b.setTitle("Signore degli Anelli");
        b.setAuthor("J.R.R. Tolkien");
        b.setNPages(1200);
        System.out.println(b.getAuthor());
        System.out.println(b.getTitle());
        System.out.println(b.getNPages());
        
        Book b2 = new Book(); //sono una nuova istanza
        System.out.println(b2.getAuthor());
        System.out.println(b2.getTitle());
        System.out.println(b2.getNPages());
        b2.setTitle("Hobbit");
        b2.setAuthor("J.R.R. Tolkien");
        b2.setNPages(432);
        System.out.println(b2.getAuthor());
        System.out.println(b2.getTitle());
        System.out.println(b2.getNPages());

    }
}