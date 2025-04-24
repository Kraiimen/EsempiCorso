package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/company";
    private static final String USER = "postgresMaster";
    private static final String PASSWORD = "goPostgresGo";

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
