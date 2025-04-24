package org.generation.italy.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcProductRepository implements ProductRepository{
    private Connection con;
    private static final String DELETE_PRODUCT = """
            DELETE
            FROM products
            WHERE productid = ?
            """;
    private static final String FIND_BY_ID = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discontinued
            FROM products
            WHERE productid = ?
            """;
    private static final String FIND_ALL = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discontinued
            FROM products
            """;
    private static final String FIND_BY_NAME_LIKE = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discontinued
            FROM products
            WHERE productname LIKE ?
            """;
    private static final String INSERT_PRODUCT = """
            INSERT INTO products(productname, supplierid, categoryid, unitprice, discontinued) 
                VALUES(?, ?, ?, ?, ?)
            """;
    private static final String UPDATE_PRODUCT = """
            UPDATE products
            SET productname = ?, supplierid = ?, categoryid = ?, unitprice = ?, discontinued = ?
            WHERE productid = ?;
            """;

    public JdbcProductRepository(Connection con) {
        this.con = con;
    }

    @Override
    public Product create(Product newProduct) {
        try(PreparedStatement st = con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS)){
            st.setString(1, newProduct.getProductName()); // non metto l'id perché è un serial
            st.setInt(2, newProduct.getSupplierId());
            st.setInt(3, newProduct.getCategoryId());
            st.setDouble(4, newProduct.getUnitPrice());
            st.setInt(5, newProduct.getDiscontinued());
            st.executeUpdate(); // ignoro l'intero in ritorno perché se non funziona comunque crasha il create

            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    newProduct.setProductId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Failed to retrieve insert ID");
                }
            }
            return newProduct; // scoprire come leggere il valore dell'id assegnata e assegnarlo al newProduct - come jdbc scopre un id autoassegnato
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Product product) {
        try(PreparedStatement st = con.prepareStatement(INSERT_PRODUCT)){
            st.setString(1, product.getProductName()); // non metto l'id perché è un serial
            st.setInt(2, product.getSupplierId());
            st.setInt(3, product.getCategoryId());
            st.setDouble(4, product.getUnitPrice());
            st.setInt(5, product.getDiscontinued());
            st.setInt(6, product.getProductId());

            int rows = st.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(int id) { // questa query non va bene, bisogna usare query parametrizzata
//        try(Statement st = con.createStatement()){
//            int lines = st.executeUpdate(DELETE_PRODUCT + id);
//            return lines == 1;
//        }catch(SQLException e){
//            throw new DataException(e.getMessage(), e);
//        }
        try(PreparedStatement st = con.prepareStatement(DELETE_PRODUCT)){
            st.setInt(1, id);
            int rows = st.executeUpdate();
            return rows == 1;
        }catch(SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Product> findById(int id) {
        try(PreparedStatement st = con.prepareStatement(FIND_BY_ID)){
            st.setInt(1, id);
            try(ResultSet rs = st.executeQuery()){
                if(rs.next()){
                    Product p = fromResultSet(rs);
                    return Optional.of(p);
                } else {
                    return Optional.empty();
                }
            }
        } catch(SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> all = new ArrayList<>();
        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(FIND_ALL)){
            while(rs.next()){
                Product p  = fromResultSet(rs);
                all.add(p);
            }
            return all;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> findByNameLike(String namePart) {
        List<Product> productByNameLike = new ArrayList<>();
        try(PreparedStatement st = con.prepareStatement(FIND_BY_NAME_LIKE)){
            st.setString(1, "%" + namePart + "%");
            try(ResultSet rs = st.executeQuery()){
                while(rs.next()){
                    Product p = fromResultSet(rs);
                    productByNameLike.add(p);
                }
                return productByNameLike;
            }
        } catch(SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    private Product fromResultSet(ResultSet rs) throws SQLException {
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
