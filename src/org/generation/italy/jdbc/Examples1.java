package org.generation.italy.jdbc;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class Examples1 {
    public static void main (String[] args) throws Exception {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver jdbc non configurato correttamente");
//            System.exit(-1);
//        }
//        Driver d = null;

        String query = "SELECT productid AS id, productname, unitprice FROM products";


//        try(Connection con = JdbcConnectionFactory.createConnection(); //Simple Factory Idiom
//            Statement st =  con.createStatement();) { // Factory method pattern
//            System.out.println("Connessione stabilita");
//            System.out.println(con.getClass().getName());
//            System.out.println(st.getClass().getName());
//            ResultSet rs = st.executeQuery(query);  // Factory method pattern
//            while(rs.next()){
//                System.out.printf("id: %d productname: %s unitprice: %f%n" , rs.getInt("id"),
//                                                                             rs.getString("productname"),
//                                                                             rs.getDouble("unitprice"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String productsByCategoryAndPrice = "SELECT productid, productname, supplierid, categoryid, unitprice, discontinued FROM products WHERE categoryid = ? AND unitprice < ?";
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
        List<Product> ps = template.<Product>query(productsByCategoryAndPrice, rowMapper, 2, 20);
        ps.forEach(p -> System.out.println(p.getProductName()));

        RowMapper<Shipper> rms = rs -> new Shipper(rs.getInt("shipperid"),
                rs.getString("companyname"),
                rs.getString("phone"));

        List<Shipper> ls = template.query(shippersByNameLike, rms, "%_S%");
        ls.forEach(s -> System.out.println(s.getCompanyName()));
        int ln = template.update("DELETE FROM products WHERE productid = ?", 10000);
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


        String updateProd1 = """
                DELETE FROM products
                WHERE productname = ? AND unitprice = ? AND
                productid = ?
                """;
        Connection c1 = JdbcConnectionFactory.createConnection();
        OurJdbcTemplate template2 = new OurJdbcTemplate(c1);
        int deleteOne = template2.update(updateProd1, "Pron", 15, 79);
        System.out.println(deleteOne);
        c1.commit();


        String querySql = " SELECT productid, productname, supplierid, categoryid, unitprice, discontinued FROM products WHERE productname LIKE ? AND unitprice > ?";
        RowMapper<Product> pm1 = rs -> new Product(
                rs.getInt("productid"),
                rs.getString("productname"),
                rs.getInt("supplierid"),
                rs.getInt("categoryid"),
                rs.getDouble("unitprice"),
                rs.getInt("discontinued")
        );

        List<Product> pl = template2.query(querySql, pm1, "%R%", 10);
        pl.forEach(p1 -> System.out.println(p1.getProductName()));


        String querySql1 = " SELECT productid, productname, supplierid, categoryid, unitprice, discontinued FROM products WHERE productid = ?";
        Optional<Product> pl1 = template2.queryForObject(querySql1, pm1, 3);
        pl1.ifPresent(product -> System.out.println("L'ID " + product.getProductId() +" corrisponde a "+ product.getProductName()));
    }
}