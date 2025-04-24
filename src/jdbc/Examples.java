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

            System.out.println(st.getClass().getName());
            ResultSet rs = st.executeQuery(query); // Factory Method Pattern
            while(rs.next()){
                System.out.printf(
                        "productid: %d productname: %s unitprice: %f%n",
                        rs.getInt("productid"),
                        rs.getString("productname"),
                        rs.getDouble("unitprice")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
