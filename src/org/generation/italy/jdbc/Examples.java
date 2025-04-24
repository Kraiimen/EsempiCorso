package org.generation.italy.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Examples {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/company";
        String username = "postgresMaster";
        String password = "goPostgresGo";
        // il contenuto dopo due punti dipende dal db
        //prestare attenzione alla pubblicazione di questi dati su github

        String query = "SELECT productid, productname, unitprice FROM products";

        // simple factory idiom example
        // per evitare di fare una new, chiama il metodo statico
        //di una classe che ti fa la new, sarà la fabbrica di oggetti
        try (Connection con = JdbcConnectionFactory.createConnection();
             Statement st = con.createStatement();) {
            System.out.println("Connection established");
            System.out.println(con.getClass().getName());
            //factory method pattern
            //punta a una delle tante possibili implementazione di connection
            System.out.println(st.getClass().getName());
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.printf("id: %d productname: %s unitprice: %f%n", rs.getInt("productid"),
                        rs.getString("productname"), rs.getDouble("unitprice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
