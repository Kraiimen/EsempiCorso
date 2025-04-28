package personal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookTestMain {
    public static void main(String[] args) {

        try (Connection con = BookConnection.createConnection()) {
            BookRepository br = new BookRepository(con);
            List<Book> allBooks = br.findAll();
            allBooks.sort(null);
            allBooks.sort(new BookComparatorByYear());
            public Optional<Book> findByTitle() throws SQLException {

            }


        } catch (SQLException e) {
            System.out.println("Errore di connessione al database");
        }
    }
}
