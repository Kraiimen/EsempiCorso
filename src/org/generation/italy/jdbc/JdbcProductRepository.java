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
    private static final String FIND_ALL = """
            SELECT *
            """;
    private static final String FIND_BY_NAME_LIKE = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discontinued
            FROM products
            WHERE productname LIKE ?
            """;
    private static final String INSERT_PRODUCT = """
            INSERT INTO products
            (productname, supplierid, categoryid, unitprice, discontinued)
            VALUES(?,?,?,?,?)
            """;

    public JdbcProductRepository(Connection con){
        this.con = con;
    }

    @Override
    public Product create(Product newProduct) throws DataException {
        try(PreparedStatement st = con.prepareStatement(INSERT_PRODUCT)) {

            st.setString(1, newProduct.getProductName());
            st.setInt(2, newProduct.get);
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Product product) {
        return false;
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
    //   Se l'utente è biricchino e scrive martello: DELETE FROM producs" manda il comando direttamente in esecuzione in sql
    //   e può cancellare dati dal database

    @Override
    public Optional<Product> findByID(int id) throws DataException {
        try(PreparedStatement st = con.prepareStatement(FIND_BY_ID)){
            st.setInt(1, id);
            try(ResultSet rs = st.executeQuery()){
                if(rs.next()) {
                    Product p = new Product(
                            rs.getInt("productid"),
                            rs.getString("productname"),
                            rs.getInt("supplierid"),
                            rs.getInt("categoryid"),
                            rs.getDouble("unitprice"),
                            rs.getInt("discontinued")
                    );

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
                Product p = fromResultSet(rs);
                all.add(p);
            }

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
                    Product p = fromResultSet(rs);
                    products.add(p);
                }
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
        return products;
    }

    private Product fromResultSet(ResultSet rs) throws SQLException{
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
}
