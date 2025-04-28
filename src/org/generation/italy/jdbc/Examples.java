package org.generation.italy.jdbc;

import java.sql.*;
import java.util.List;

public class Examples {
    public static void main(String[] args) throws SQLException {
        String query = "SELECT productid AS id, productname, unitprice FROM products";
//        try (Connection con = JdbcConnectionFactory.createConnection(); Statement st = con.createStatement();){
//            System.out.println("Connessione stabilita");
//            System.out.println(con.getClass().getName());
//            System.out.println(st.getClass().getName());
//            ResultSet rs = st.executeQuery(query);
//            while(rs.next()){
//                System.out.printf("id: %d productname: %s unitprice: %f%n", rs.getInt("id"), rs.getString("productname"), rs.getDouble("unitprice"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String productsByCategoryAndPrice  = "SELECT productid, productname, supplierid, categoryid, unitprice, discontinued FROM products WHERE categoryid = ? AND unitprice < ?";
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
        List<Product> ps = template.query(productsByCategoryAndPrice, rowMapper, 2, 20);
        ps.forEach(p -> System.out.println(p.getProductName()));


        String shippersByNameLike  = "SELECT shipperid, companyname, phone FROM shippers WHERE companyname = ?";
        RowMapper<Shipper> rms = rs -> new Shipper(
                rs.getInt("shipperid"),
                rs.getString("companyname"),
                rs.getString("phone")
        );
        List<Shipper> ls = template.query(shippersByNameLike, rms, "%S%");
        ls.forEach(s -> System.out.println(s.getCompanyname()));

        int ln = template.update("DELETE FROM products WHERE productid = ?", 10000);
        System.out.println(ln);
        c.commit();

        String updateProd = """
                UPDATE products
                SET productname = ?, UNITPRICE = ?
                WHERE productid = ?
                """;
//        int upln = template.update(updateProd, "Product Pippo", 15, 1);
//        System.out.println(upln);
//        c.commit();

    }

}
