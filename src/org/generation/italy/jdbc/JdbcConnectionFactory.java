package org.generation.italy.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/company";
    private static final String USER = "postgresMaster";
    private static final String PASSWORD = "gotPostgresgoGo";

    public static connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
