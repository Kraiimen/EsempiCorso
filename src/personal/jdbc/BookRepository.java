package personal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    //   /-----/-STATE-/-----/
    private static final String FIND_ALL = """
            SELECT bookid, title, author, year, price
            FROM books
            """;

    private Connection con;

    //   /-----/-CONSTRUCTORS-/-----/
    public BookRepository(Connection con) {
        this.con = con;
    }

    //   /-----/-METHODS-/-----/
    public List<Book> findAll() throws SQLException {
        List<Book> allBooks = new ArrayList<>();
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(FIND_ALL)) {
            while (rs.next()) {
                Book b = new Book(rs.getInt("bookid"),
                                    rs.getString("title"),
                                    rs.getString("author"),
                                    rs.getInt("year"),
                                    rs.getDouble("price"));
                allBooks.add(b);
            }
            return allBooks;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }



}
