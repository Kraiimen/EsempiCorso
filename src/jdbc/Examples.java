package jdbc;

import org.postgresql.Driver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
// import org.postgresql.Driver;

public class Examples {
    public static void main(String[] args) throws Exception {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver JDBC non configurato correttamente!");
//            System.exit(-1);
//        }

//        Driver d = null;

//        String query = "SELECT productid, productname, unitprice FROM products";
//
//        try (Connection con = JdbcConnectionFactory.createConnection();
//             Statement st = con.createStatement()) { // Factory Method Pattern
//            System.out.println("Connessione stabilita!");
//            System.out.println(con.getClass().getName());
//
//            JdbcProductRepository jpr = new JdbcProductRepository(con);
//            Product p = jpr.create(new Product(0, "Nuovo prodotto", 1, 2, 9.99, 0));
//
//            System.out.println("NewProductId: "+p.getProductId());
//            con.rollback();
//        } catch (DataException | SQLException e) {
//            e.printStackTrace();
//        }

//        String productsByCategoryAndPrice = "SELECT productid, productname, supplierid, categoryid, unitprice, discontinued FROM products WHERE categoryid = ? AND unitprice < ?";
//        String shippersByNameLike = "SELECT shipperid, companyname, phone FROM shippers WHERE companyname LIKE ?";
//
//        RowMapper<Product> rowMapper = rs -> new Product(
//                rs.getInt("productid"),
//                rs.getString("productname"),
//                rs.getInt("supplierid"),
//                rs.getInt("categoryid"),
//                rs.getDouble("unitprice"),
//                rs.getInt("discontinued")
//        );
//        OurJdbcTemplate template = new OurJdbcTemplate(JdbcConnectionFactory.createConnection());
//        List<Product> results = template.query(productsByCategoryAndPrice, rowMapper, 2, 20);
//        results.forEach(p -> System.out.println(p.getProductName()));
//
//        System.out.println();
//
//        RowMapper<Shipper> rms = rs -> new Shipper(
//                rs.getInt("shipperid"),
//                rs.getString("companyname"),
//                rs.getString("phone")
//        );
//        List<Shipper> results1 = template.query(shippersByNameLike, rms, "%_S%");
//        results1.forEach(s -> System.out.println(s.getCompanyName()));

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/company");
        dataSource.setUsername("postgresMaster");
        dataSource.setPassword("goPostgresGo");

        SpringJdbcProductRepository spring = new SpringJdbcProductRepository(dataSource);
        List<Product> products = spring.findAll();
    }
}
