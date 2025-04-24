package org.generation.italy.jdbc;
import org.postgresql.jdbc.PgConnection;

import java.sql.*;

import org.postgresql.Driver;

public class Examples {
    public static void main(String[] args) throws SQLException {
       String url = "jdbc:postgresql://localhost:5432/company";
       String user = "postgresMaster";
       String password = "gotPostgresgoGo";
       String query = "SELECT productid AS id, productname, unitprice FROM products";
//SIMPLE FACTORY IDIOM (Il caso in cui invece di creare io un oggetto invoco FACTORY e lo crea per me)
        try( Connection con = JdbcConnectionFactory.createConnection();
             Statement st = con.createStatement()){ //TRY WHITH RESOURCES
            System.out.println("Connessione stabilita");
            System.out.println(con.getClass().getName());
            //FACTORY METHOD PATTERN
            //Metodo createStatement, lo eseguo su un oggetto di classe PgConnection
            System.out.println(st.getClass().getName());
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                System.out.printf("id: %d productname: %s unitprice: %f%n", rs.getInt(1), rs.getString("productname"), rs.getDouble("unitprice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
