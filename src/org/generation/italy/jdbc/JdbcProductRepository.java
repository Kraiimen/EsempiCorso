package org.generation.italy.jdbc;

import org.generation.italy.bankProject.accounting.exceptions.DataException;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcProductRepository implements ProductRepository {
    private Connection con;
    private static final String DELETE_PRODUCT = """
            DELETE FROM products
            WHERE productid = 
            """;

    //Il select deve essere preciso, nulla *
    private static final String FIND_BY_ID = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discontinued
            FROM products
            WHERE productid = ?
            """;
    public static final String FIND_ALL = """
            SELECT *
            """;
    public static final String FIND_BY_NAME_LIKE = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discontinued
            FROM products
            WHERE productname LIKE ?
            """;
    private static final String INSERT_PRODUCT = """
            INSERT INTO products
            (productname, supplierid, categoryid, unitprice, discontinued)
            VALUES(?,?,?,?,?)
            """;
    public static final String UPDATE_PRODUCT = """
            UPDATE products
            SET productname = ?, supplierid = ?, categoryid = ?, unitprice = ?, discontinued = ?
            WHERE productid = ?;
            """;

    public JdbcProductRepository(Connection con){
        this.con = con;
    }


    @Override
    public Product create(Product newProduct) throws DataException {
//        try(PreparedStatement st = con.prepareStatement(INSERT_PRODUCT)) {
//
//            st.setString(1, newProduct.getProductName());
//            st.setInt(2, newProduct.getSupplierId());
//            st.setInt(3, newProduct.getCategoryId());
//            st.setDouble(4, newProduct.getUnitPrice());
//            st.setInt(5, newProduct.getDiscontinued());
//
//            return newProduct;
//        } catch (SQLException e) {
//            throw new DataException(e.getMessage(), e);
//        }
        OurJdbcTemplate template = new OurJdbcTemplate(con);
        template.createAndGetKeys(INSERT_PRODUCT,
                newProduct.getProductName(),
                newProduct.getSupplierId(),
                newProduct.getProductId(),
                newProduct.getDiscontinued(),
                newProduct.getUnitPrice(),
                newProduct.getCategoryId()
        );
//        newProduct.setProductId(key);
        return newProduct;
    }

    @Override
    public int update(Product updatedProduct) throws DataException {
        try(PreparedStatement st = con.prepareStatement(UPDATE_PRODUCT)) {

            st.setString(1, updatedProduct.getProductName());
            st.setInt(2, updatedProduct.getSupplierId());
            st.setInt(3, updatedProduct.getCategoryId());
            st.setDouble(4, updatedProduct.getUnitPrice());
            st.setInt(5, updatedProduct.getDiscontinued());
            st.setInt(6, updatedProduct.getProductId());

//            int rows = st.executeUpdate();
            return st.executeUpdate();

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }

    }

    @Override
    public boolean delete(int id) {
        try(Statement st = con.createStatement()){
           int lines =  st.executeUpdate(DELETE_PRODUCT + id);
            return lines == 1;
        } catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }
    //abominio:
    //1) creare una query complessa con collage di Stringhe è scomodo
    //2) da dove arriva l'id? i parametri che inseriamo nella stringa sono dati che vengono dall'utente dell'applicazione solitamente
    //   Se l'utente è biricchino e scrive martello: DELETE FROM products" manda il comando direttamente in esecuzione in sql
    //   e può cancellare dati dal database

    @Override
    public Optional<Product> findByID(int id) throws DataException {
        try(PreparedStatement st = con.prepareStatement(FIND_BY_ID)){
            st.setInt(1, id);
            try(ResultSet rs = st.executeQuery()){
                if(rs.next()) {
                    Product p = createProductFromResultSet(rs);


                    return Optional.of(p);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> all = new ArrayList<>();
        try(Statement st = con.createStatement(); ResultSet rs = st.executeQuery(FIND_ALL); ) {
            while(rs.next()) {
                Product p = createProductFromResultSet(rs);
                all.add(p);
            }
        return all;
        } catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> findByNameLike(String namePart) {
        List<Product> products = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement(FIND_BY_NAME_LIKE)) {
            ps.setString(1,namePart);
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()){
                    Product p = createProductFromResultSet(rs);
                    products.add(p);
                }
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
        return products;
    }


//        @Override
//    public List<Product> findByNameLike(String namePart) {
////      return query(FIND_BY_NAME_LIKE, "%" +namePart+"%");
//            return query2(FIND_BY_NAME_LIKE, ps ->) {
//                ps.set
//            }
//    }

    private Product createProductFromResultSet(ResultSet rs) throws SQLException{
        Product p = new Product(
                rs.getInt("productid"),
                rs.getString("productname"),
                rs.getInt("supplierid"),
                rs.getInt("categoryid"),
                rs.getDouble("unitprice"),
                rs.getInt("discontinued")
        );
        return p;
    }

    public List<Product> query(String query, Object... params) throws DataException {
        List<Product> productList = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product p = createProductFromResultSet(rs);
                    productList.add(p);
                }
                return productList;
            }

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }


    public List<Product> query2(String query, PreparedStatementFiller filler) throws DataException {
        List<Product> productList = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            filler.fillStatement(ps);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product p = createProductFromResultSet(rs);
                    productList.add(p);
                }
                return productList;
            }

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }
}
