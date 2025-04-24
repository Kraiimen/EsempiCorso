package org.generation.italy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/company;"
    private static final String USER = "postgresMaster";
    private static final String PASSWWORD = "goPostgresGo";

    public static Connection createConnection() {
        return DriverManager.getConnection(URL, USER, PASSWWORD);
    }

}
