package org.generation.italy.jdbc;

import org.postgresql.jdbc.PgConnection;

import java.sql.*;
import java.util.List;

import org.postgresql.Driver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Examples {
    public static void main (String[] args) throws Exception{
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
//        String productsByCategoryAndPrice = "SELECT productid, productname, supplierid, categoryid, unitprice, discontinued FROM products WHERE categoryid = ? AND unitprice < ?";
//        String shippersByNameLike = "SELECT shipperid, companyname, phone FROM shippers WHERE companyname LIKE ?";
//        RowMapper<Product> rowMapper = rs -> new Product(
//                rs.getInt("productid"),
//                rs.getString("productname"),
//                rs.getInt("supplierid"),
//                rs.getInt("categoryid"),
//                rs.getDouble("unitprice"),
//                rs.getInt("discontinued")
//        );
//        Connection c = JdbcConnectionFactory.createConnection();
//        OurJdbcTemplate template = new OurJdbcTemplate(c);
//        List<Product> ps = template.<Product>query(productsByCategoryAndPrice, rowMapper, 2, 20);
//        ps.forEach(p -> System.out.println(p.getProductName()));
//        RowMapper<Shipper> rms = rs -> new Shipper(rs.getInt("shipperid"),
//                                                            rs.getString("companyname"),
//                                                            rs.getString("phone"));
//        List<Shipper> ls = template.query(shippersByNameLike, rms, "%pippo%");
//        ls.forEach(s -> System.out.println(s.getCompanyName()));
//        int ln = template.update("DELETE FROM products WHERE productid = ?", 10000);
//        System.out.println(ln);
//        c.commit();
//        String updateProd = """
//                UPDATE products
//                SET productname = ?, unitprice = ?
//                WHERE productid = ?
//                """;
//        int upLn = template.update(updateProd, "Product pippo", 15, 1);
//        System.out.println(upLn);
//        c.commit();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/company");
        dataSource.setUsername("postgresMaster");
        dataSource.setPassword("goPostgresGo");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM products",
                Integer.class
        );

        System.out.println("Total products: " + count);

    }
}