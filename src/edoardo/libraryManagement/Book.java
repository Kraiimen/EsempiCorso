package edoardo.libraryManagement;

public class Book{
    String author;//sono triste sono null
    String title;
    int nPages;
    
    public void setAuthor(String authorPar){
        author = authorPar;
    }
    public void setTitle(String titlePar){
        title = titlePar;
    }
    public void setNPages(int nPagesPar){
        nPages = nPagesPar;
    }
    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }
    public int getNPages(){
        return nPages;
    }

}