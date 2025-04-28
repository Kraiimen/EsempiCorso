package org.generation.italy.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcProductRepository implements ProductRepository{

    private Connection con;
    private static final String DELETE_PRODUCT = """
            DELETE FROM products
            WHERE productid = 
            """;
    private static final String FIND_BY_ID = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discountinued
            FROM products
            WHERE productid = ?
            """;
    private static final String FIND_ALL = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discountinued
            FROM products
            """;
    private static final String FIND_BY_NAME_LIKE = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discountinued
            FROM products
            WHERE productname LIKE ?
            """;
    private static final String INSERT_PRODUCT = """
            INSERT INTO products 
            (productname, supplierid, categoryid, unitprice, discountinued) 
            VALUES(?,?,?,?,?)
            """;
    private static final String UPDATE_PRODUCT = """
            UPDATE products
            SET productname = ?, supplierid = ?, categoryid = ?, unitprice = ?, discountinued = ?
            WHERE productid = ?;
            """;

    public JdbcProductRepository (Connection con) {
        this.con = con;
    }

    @Override
    public Product create(Product newProduct) throws DataException {
        try(PreparedStatement st = con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {


            st.setString(1, newProduct.getProductName());
            st.setInt(2, newProduct.getSupplierId());
            st.setInt(3, newProduct.getCategoryId());
            st.setDouble(4, newProduct.getUnitPrice());
            st.setInt(5, newProduct.getDiscountinued());

            st.executeUpdate(); //ignoro l'intero che mi ritorna, perchè o funziona e sarà 1 o se NON funge crasha

            try(ResultSet rs = st.getGeneratedKeys();){
                if(rs.next()){
                    newProduct.setProductId(rs.getInt(1));
                }
            }

            return newProduct;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }

    }

    @Override
    public boolean update(Product updatedProduct) throws DataException {
        try(PreparedStatement st = con.prepareStatement(INSERT_PRODUCT)) {

            st.setString(1, updatedProduct.getProductName());
            st.setInt(2, updatedProduct.getSupplierId());
            st.setInt(3, updatedProduct.getCategoryId());
            st.setDouble(4, updatedProduct.getUnitPrice());
            st.setInt(5, updatedProduct.getDiscountinued());
            st.setInt(6, updatedProduct.getProductId());

            int rows = st.executeUpdate();
            return rows == 1;

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(int id) throws DataException {
        try(Statement st = con.createStatement()) {
            int lines = st.executeUpdate(DELETE_PRODUCT + id);
            return lines == 1;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }

        //   Motivi per cui queste righe di codice sono un abominio:
        //
        //1) Creare una query complessa con collage di stringhe è scomodo e caotico.
        //2) Da dove arriva l'id? I parametri nella String originaria sono dati che vengono dall'utente...
        //   però lui/lei potrebbe dire "martello; DELETE FROM products" e finisce che manda in esecuzione un sql
        //   che non ho deciso io. E' una tecnica di hacking che si chiama SQL Injection, tral'altro...
        //3) I database creano dei piani di esecuzione per le loro query. Con queste righe avrei lo stesso piano di esecuzione
        //   molte volte, che è una perdita di tempo e sforzo del compilatore.

        //   SOLUZIONE:
        //   passare una quey con n buchi e n parametri

        //   a chi non rispetterà questa legge verrà amputata la parte più sporgente 😱

    }

    @Override
    public Optional<Product> findById(int id) throws DataException {
        //uso Pre
        try(PreparedStatement st = con.prepareStatement(FIND_BY_ID)) {
            st.setInt(1, id);
            try(ResultSet rs = st.executeQuery()) {
                if(rs.next()) {
                    Product p = fromResultSet(rs);
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
    public List<Product> findAll() throws DataException {
        List<Product> all = new ArrayList<>();
        try(Statement st = con.createStatement(); ResultSet rs = st.executeQuery(FIND_ALL);) {
            while(rs.next()) {
                Product p = fromResultSet(rs);
                all.add(p);
            }
            return all;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> findByNameLike(String namePart) throws DataException {
        List<Product> nameLike = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement(FIND_BY_NAME_LIKE)) {
            ps.setString(1, "%" + namePart + "%");
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Product p = fromResultSet(rs);
                    nameLike.add(p);
                }
                return nameLike;
            }
        } catch (SQLException e) {
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
