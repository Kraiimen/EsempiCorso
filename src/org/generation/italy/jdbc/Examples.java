package org.generation.italy.jdbc;

import org.postgresql.Driver;

import java.sql.*;

public class Examples {
    public static void main(String[] args) {
        // Prima bisognava caricare i driver manualmente, forzare il caricamento del driver sul driver manager
//        try {
//            Class.forName("org.postgresql.Driver")
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver jdbc non configurato correttamente");
//            System.exit(-1);
//        }
//        Driver d = null; // forzatura del driver Postgres sul driver manager
        String query = "SELECT productid AS id, productname, unitprice FROM products";
        // Simple Factory Idiom (idioma)
        try(Connection con = JdbcConnectionFactory.createConnection();
            Statement st = con.createStatement()) {
            System.out.println("Connessione stabilita");
            System.out.println(con.getClass().getName()); // Per vedere la classe puntata da con
            // Factory method pattern (design pattern)
            System.out.println(st.getClass().getName()); // Per vedere la classe puntata da st
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                System.out.printf("id: %d productname: %s unitprice: %f%n", rs.getInt("id"), rs.getString("productname"), rs.getDouble("unitprice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
