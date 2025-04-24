package org.generation.italy.jdbc;

import java.sql.*;

public class Examples {
    public static void main(String[] args){
        String query = "SELECT productid, productname, unitprice FROM products";
        //Simple Factory Idiom
        try(Connection con = JdbcConnectionFactory.createConnection();
            //Factory method pattern
            Statement st = con.createStatement();) {
                System.out.println("Connessione stabilita");
                System.out.println(st.getClass().getName());
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    System.out.printf("id: %d productname: %s unitprice: %f%n", rs.getInt("productid"),
                            rs.getString("productname"), rs.getDouble("unitprice"));
                }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
