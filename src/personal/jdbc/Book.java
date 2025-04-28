package personal.jdbc;

public class Book implements Comparable<Book> {
    //   /-----/-STATE-/-----/
    private int bookid;
    private String title;
    private String author;
    private int year;
    private double price;

    //   /-----/-CONSTRUCTORS-/-----/
    public Book(int bookid, String title, String author, int year, double price) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    //   /-----/-METHODS-/-----/
    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }

    //   /-----/-METHODS-GET-&-SET-/-----/
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    public double getPrice() {
        return price;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
