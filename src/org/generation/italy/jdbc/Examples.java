package org.generation.italy.jdbc;

import org.postgresql.jdbc.PgConnection;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

import org.postgresql.Driver;

public class Examples {
    public static void main(String[] args){
//        try {
//            Class.forName("org.postgresql");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver JDBC non configurato correttamente");
//            System.exit(-1); //Bisogna terminare il programma con lo status -1 per identificare quel qualcosa è andato storto
//        }

//        Driver d = null;

        String query = "SELECT productid, productname, unitprice FROM products";
        //Simple factory idiom
        try (Connection con = JdbcConnectionFactory.createConnection()){
            System.out.println("Connessione stabilita");
            System.out.println(con.getClass().getName());
            //Factory method pattern
            Statement st = con.createStatement();
            System.out.println(st.getClass().getName());
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){  // non sappiamo quante volte dobbiamo ciclare per ottenere tutti i risultati e dunque usiamo un while
                System.out.printf("id: %d productname: %s unitprice: %f%n", rs.getInt(1), rs.getString("productname"), rs.getDouble("unitprice"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
