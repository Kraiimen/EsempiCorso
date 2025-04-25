package jdbc;

import org.postgresql.Driver;

import java.sql.*;
// import org.postgresql.Driver;

public class Examples {
    public static void main(String[] args) {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver JDBC non configurato correttamente!");
//            System.exit(-1);
//        }

//        Driver d = null;
        String query = "SELECT productid, productname, unitprice FROM products";

        try (Connection con = JdbcConnectionFactory.createConnection();
             Statement st = con.createStatement()) { // Factory Method Pattern
            System.out.println("Connessione stabilita!");
            System.out.println(con.getClass().getName());

            JdbcProductRepository jpr = new JdbcProductRepository(con);
            Product p = jpr.create(new Product(0, "Nuovo prodotto", 1, 2, 9.99, 0));

            System.out.println("NewProductId: "+p.getProductId());
            con.rollback();
        } catch (DataException | SQLException e) {
            e.printStackTrace();
        }
    }
}
