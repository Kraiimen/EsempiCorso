package org.generation.italy.jdbc;

import org.postgresql.jdbc.PgConnection;

import java.sql.*;

import org.postgresql.Driver;

public class Examples {
    public static void main (String[] args){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver jdbc non configurato correttamente");
//            System.exit(-1);
//        }
//        Driver d = null;

        String query = "SELECT productid AS id, productname, unitprice FROM products";


        try(Connection con = JdbcConnectionFactory.createConnection(); //Simple Factory Idiom
            Statement st =  con.createStatement();) { // Factory method pattern
            System.out.println("Connessione stabilita");
            System.out.println(con.getClass().getName());
            System.out.println(st.getClass().getName());
            ResultSet rs = st.executeQuery(query);  // Factory method pattern
            while(rs.next()){
                System.out.printf("id: %d productname: %s unitprice: %f%n" , rs.getInt("id"), rs.getString("productname"), rs.getDouble("unitprice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
