package org.generation.italy.jdbc;

import org.generation.italy.jdbc.model.Product;

import java.sql.*;
import java.util.List;

import org.generation.italy.jdbc.model.Shipper;
import org.springframework.jdbc.datasource.DrivermanagerDataSource;

public class Examples {
    public static void main(String[] args) throws Exception{
        //throws Exception sul main è una porcata, la uso ora per non avere errori senza try catch

        // Prima bisognava caricare i driver manualmente, forzare il caricamento del driver sul driver manager
//        try {
//            Class.forName("org.postgresql.Driver")
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver jdbc non configurato correttamente");
//            System.exit(-1);
//        }
//        Driver d = null; // forzatura del driver Postgres sul driver manager
        String query = "SELECT productid AS id, productname, unitprice FROM products";
        // Simple Factory Idiom (idioma)
//        try(Connection con = JdbcConnectionFactory.createConnection();
//            Statement st = con.createStatement()) {
//            System.out.println("Connessione stabilita");
//            System.out.println(con.getClass().getName()); // Per vedere la classe puntata da con
//            // Factory method pattern (design pattern)
//            System.out.println(st.getClass().getName()); // Per vedere la classe puntata da st
//            ResultSet rs = st.executeQuery(query);
//            while(rs.next()) {
//                System.out.printf("id: %d productname: %s unitprice: %f%n", rs.getInt("id"), rs.getString("productname"), rs.getDouble("unitprice"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        String productsByCategoryAndPrice = "SELECT productid, productname, unitprice FROM pdoducts WHERE categoryid = ? AND unitprice < ?";
        String shippersByNameLike = "SELECT shipperid, companyname, phone FROM shippers WHERE companyname LIKE ?";
        RowMapper<Product> rowMapper = rs -> new Product(rs.getInt("productid"),
                rs.getString("productname"),
                rs.getInt("supplierid"),
                rs.getInt("categoryid"),
                rs.getDouble("unitprice"),
                rs.getInt("discontinued")
        );
        Connection c = JdbcConnectionFactory.createConnection();
        OurJdbctemplate template = new OurJdbctemplate(c);
        List<Product> ps = template.<Product>query(productsByCategoryAndPrice, rowMapper, 2, 20);
        //Il <Product> dopo template. e prima di query non è necessario perché il tipo T (Product in questo caso) lo abbiamo già passato a RowMapper
        ps.forEach(p -> System.out.println(p.getProductname()));
        // per ogni prodotto p stamperemo il productname

        RowMapper<Shipper> rms = rs -> new Shipper(rs.getInt("shipperid"),
                                                            rs.getString("companyName"),
                                                            rs.getString("phone"));
        List<Shipper> ls = template.query(shippersByNameLike, rms, "%S%");
        ls.forEach(s -> System.out.println(s.getCompanyname()));

        //Voglio cancellare un prodotto
        int ln = template.update("DELETE FROM products WHERE productid = ?", 10000);
        System.out.println(ln); //Stampa il numero di update
        c.commit();
        String updateProd = """
                UPDATE products
                SET productname = ?, unitprice = ?
                WHERE productid = ?
                """;

        int upLn = template.update(updateProd, "Product Pippo", 15, 1);


    }
}
