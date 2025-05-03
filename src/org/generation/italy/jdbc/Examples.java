package org.generation.italy.jdbc;

import org.postgresql.jdbc.PgConnection;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.List;

import org.postgresql.Driver;

public class Examples {
    public static void main(String[] args) throws Exception{


//        try {
//            Class.forName("org.postgresql");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver JDBC non configurato correttamente");
//            System.exit(-1); //Bisogna terminare il programma con lo status -1 per identificare quel qualcosa è andato storto
//        }

//        Driver d = null;

        String query = "SELECT productid, productname, unitprice FROM products";

        //Simple factory idiom
//        try (Connection con = JdbcConnectionFactory.createConnection()){
//            System.out.println("Connessione stabilita");
//            System.out.println(con.getClass().getName());
//            //Factory method pattern
//            Statement st = con.createStatement();
//            System.out.println(st.getClass().getName());
//            ResultSet rs = st.executeQuery(query);
//            while(rs.next()){  // non sappiamo quante volte dobbiamo ciclare per ottenere tutti i risultati e dunque usiamo un while
//                System.out.printf("id: %d productname: %s unitprice: %f%n", rs.getInt(1), rs.getString("productname"), rs.getDouble("unitprice"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String productsByCategoryAndPrice = "SELECT productid, productname,supplierid, categoryid, unitprice, discontinued FROM products WHERE categoryid = ? AND unitprice < ?";
        String shippersByNameLike = "SELECT shipperid, companyname, phone FROM shippers WHERE companyname LIKE ?";
        RowMapper<Product> rowMapper = rs -> new Product(
                rs.getInt("productid"),
                rs.getString("productname"),
                rs.getInt("supplierid"),
                rs.getInt("categoryid"),
                rs.getDouble("unitprice"),
                rs.getInt("discontinued")
        );
        Connection c = JdbcConnectionFactory.createConnection();
        OurJdbcTemplate template = new OurJdbcTemplate(c);
        List<Product> ps = template.query(productsByCategoryAndPrice, rowMapper, 2,20 );
        ps.forEach(p -> System.out.println(p.getProductName()));
        RowMapper<Shipper> rms = rs -> new Shipper(rs.getInt("shipperid"),
                                                            rs.getString("companyname"),
                                                            rs.getString("phone"));
        List<Shipper> ls = template.query(shippersByNameLike, rms, "%S%" );
        ls.forEach(s -> System.out.println(s.getCompanyName()));
        int ln = template.update("DELETE FROM products WHERE productid = ?",10000 );
        System.out.println(ln);
        c.commit();
        String updateProd = """
                UPDATE products
                SET productname = ?, unitprice = ?
                WHERE productid = ?
                """;
        int upLn = template.update(updateProd, "Product pippo", 15, 1);
        System.out.println(upLn);
        c.commit();
    }
}
