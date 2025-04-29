package org.generation.italy.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcProductRepository implements ProductRepository{

    private Connection con;
    private static final String WRONG_DELETE_PRODUCT = """
            DELETE FROM products
            WHERE productid = 
            """;
    private static final String DELETE_PRODUCT = """
            DELETE FROM products
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
            INSERT INTO products 
            (productname, supplierid, categoryid, unitprice, discontinued) 
            VALUES(?,?,?,?,?)
            """;
    private static final String UPDATE_PRODUCT = """
            UPDATE products
            SET productname = ?, supplierid = ?, categoryid = ?, unitprice = ?, discontinued = ?
            WHERE productid = ?;
            """;

    public JdbcProductRepository (Connection con) {
        this.con = con;
    }

    @Override
    public Product create(Product newProduct) throws DataException {
//        try(PreparedStatement st = con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {
//
//            st.setString(1, newProduct.getProductName());
//            st.setInt(2, newProduct.getSupplierId());
//            st.setInt(3, newProduct.getCategoryId());
//            st.setDouble(4, newProduct.getUnitPrice());
//            st.setInt(5, newProduct.getDiscountinued());
//
//            st.executeUpdate(); //ignoro l'intero che mi ritorna, perchè o funziona e sarà 1 o se NON funge crasha
//            //qui dovremmo scoprire come leggere il valore dell'id assegnata, e assegnarlo con un set a newProduct e
//            //solo a quel punto, ritornarlo.
//            try(ResultSet rs= st.getGeneratedKeys()){
//                if(rs.next()){
//                    newProduct.setProductId(rs.getInt(1));
//                }
//            }
//            return newProduct;
//        } catch (SQLException e) {
//            throw new DataException(e.getMessage(), e);
//        }
        OurJdbcTemplate ojt = new OurJdbcTemplate(con);
        int key= ojt.createReturnKey(INSERT_PRODUCT,
                newProduct.getProductName(),
                newProduct.getSupplierId(),
                newProduct.getCategoryId() ,
                newProduct.getUnitPrice(),
                newProduct.getDiscontinued());
        newProduct.setProductId(key);
        return newProduct;
    }

    @Override
    public boolean update(Product up) throws DataException {
//        try(PreparedStatement st = con.prepareStatement(UPDATE_PRODUCT)) {
//
//            st.setString(1, updatedProduct.getProductName());
//            st.setInt(2, updatedProduct.getSupplierId());
//            st.setInt(3, updatedProduct.getCategoryId());
//            st.setDouble(4, updatedProduct.getUnitPrice());
//            st.setInt(5, updatedProduct.getDiscountinued());
//            st.setInt(6, updatedProduct.getProductId());
//
//            int rows = st.executeUpdate();
//            return rows == 1;
//
//        } catch (SQLException e) {
//            throw new DataException(e.getMessage(), e);
//        }
        OurJdbcTemplate template = new OurJdbcTemplate(con);
        int ln = template.update(UPDATE_PRODUCT, up.getProductName(), up.getSupplierId(), up.getCategoryId(),
                                                 up.getUnitPrice(), up.getDiscontinued(), up.getProductId());
        return ln == 1;
    }

    @Override
    public boolean delete(int id) throws DataException {
//        try(Statement st = con.createStatement()) {
//            int lines = st.executeUpdate(WRONG_DELETE_PRODUCT + id);
//            return lines == 1;
//        } catch (SQLException e) {
//            throw new DataException(e.getMessage(), e);
//        }
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
        OurJdbcTemplate template = new OurJdbcTemplate(con);
        int ln = template.update(DELETE_PRODUCT, id);
        return ln == 1;
    }

    @Override
    public Optional<Product> findById(int id) throws DataException {
        //uso Pre
//        try(PreparedStatement st = con.prepareStatement(FIND_BY_ID)) {
//            st.setInt(1, id);
//            try(ResultSet rs = st.executeQuery()) {
//                if(rs.next()) {
//                    Product p = fromResultSet(rs);
//                    return Optional.of(p);
//                } else {
//                    return Optional.empty();
//                }
//            }
//        } catch (SQLException e) {
//            throw new DataException(e.getMessage(), e);
//        }
        OurJdbcTemplate template = new OurJdbcTemplate(con);
        return template.queryForObject(FIND_BY_ID, JdbcProductRepository::fromResultSet, id);
    }

    @Override
    public List<Product> findAll() throws DataException {
//        List<Product> all = new ArrayList<>();
//        try(Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery(FIND_ALL);) {
//            while(rs.next()) {
//                Product p = fromResultSet(rs);
//                all.add(p);
//            }
//            return all;
//        } catch (SQLException e) {
//            throw new DataException(e.getMessage(), e);
//        }
        OurJdbcTemplate template = new OurJdbcTemplate(con);
        return template.query(FIND_ALL, JdbcProductRepository::fromResultSet);
    }

    @Override
    public List<Product> findByNameLike(String namePart) throws DataException {
//        return query(FIND_BY_NAME_LIKE, "%"+namePart+"%");
//        return query2(FIND_BY_NAME_LIKE, ps -> {
//            try{
//                ps.setString(1, "%"+namePart+"%");
//            }catch(SQLException e){
//                throw new DataException(e.getMessage(), e);
//            }
//        });
        OurJdbcTemplate template = new OurJdbcTemplate(con);
        return template.query(FIND_BY_NAME_LIKE, JdbcProductRepository::fromResultSet,"%"+namePart+"%");
    }

    private static Product fromResultSet(ResultSet rs) throws SQLException {
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


    public List<Product> queryVarArgs(String query, Object... params) throws DataException {
        List<Product> productList = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement(query)){
            for(int i = 0; i < params.length; i++){
                ps.setObject(i+1, params[i]);
            }
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Product p = fromResultSet(rs);
                    productList.add(p);
                }
                return productList;
            }
        }catch(SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }
    public List<Product> queryFunctionalInterface(String query, PreparedStatementFiller filler) throws DataException {
        List<Product> productList = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement(query)){
            filler.fillStatement(ps);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Product p = fromResultSet(rs);
                    productList.add(p);
                }
                return productList;
            }
        }catch(SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }


}
