package org.generation.italy.jdbc.repository;

import org.generation.italy.jdbc.DataException;
import org.generation.italy.jdbc.OurJdbcTemplate;
import org.generation.italy.jdbc.PreparedStatementFiller;
import org.generation.italy.jdbc.model.Product;

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
    public Product create(Product np) {
//        try(PreparedStatement st = con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS)){ // il secondo parametro serve a mandare info agggiuntive, è un intero, dobbiamo dire che se facciamo un insert abbiamo bisogno della chiave
//            st.setString(1, np.getProductName()); // non metto l'id perché è un serial
//            st.setInt(2, np.getSupplierId());
//            st.setInt(3, np.getCategoryId());
//            st.setDouble(4, np.getUnitPrice());
//            st.setInt(5, np.getDiscontinued());
//            st.executeUpdate(); // ignoro l'intero in ritorno perché se non funziona comunque crasha il create
//
//            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    np.setProductId(generatedKeys.getInt(1));
//                }
//                else {
//                    throw new SQLException("Failed to retrieve insert ID");
//                }
//            }
//            return newProduct; // scoprire come leggere il valore dell'id assegnata e assegnarlo al newProduct - come jdbc scopre un id autoassegnato
//        } catch (SQLException e) {
//            throw new DataException(e.getMessage(), e);
//        }
        OurJdbcTemplate template = new OurJdbcTemplate(con); // con template generico
        int ln = template.createAndReturnKey(INSERT_PRODUCT, np.getProductName(), np.getSupplierId(), np.getCategoryId(), np.getUnitPrice(), np.getDiscontinued());
        np.setProductId(ln);
        return np;
    }

    @Override
    public boolean update(Product up) {
//        try(PreparedStatement st = con.prepareStatement(UPDATE_PRODUCT)){
//            st.setString(1, up.getProductName()); // non metto l'id perché è un serial
//            st.setInt(2, up.getSupplierId());
//            st.setInt(3, up.getCategoryId());
//            st.setDouble(4, up.getUnitPrice());
//            st.setInt(5, up.getDiscontinued());
//            st.setInt(6, up.getProductId());
//
//            int rows = st.executeUpdate();
//            return rows == 1;
//        } catch (SQLException e) {
//            throw new DataException(e.getMessage(), e);
//        }
        OurJdbcTemplate template = new OurJdbcTemplate(con); // con template generico
        int ln = template.update(UPDATE_PRODUCT, up.getProductName(), up.getSupplierId(), up.getCategoryId(),
                                                    up.getUnitPrice(), up.getDiscontinued(), up.getProductId());
        return ln == 1;
    }

    @Override
    public boolean delete(int id) { // questa query non va bene, bisogna usare query parametrizzata
//        try(Statement st = con.createStatement()){ // con statement -> non si fa
//            int lines = st.executeUpdate(DELETE_PRODUCT + id);
//            return lines == 1;
//        }catch(SQLException e){
//            throw new DataException(e.getMessage(), e);
//        }

//        try(PreparedStatement st = con.prepareStatement(DELETE_PRODUCT)){ // con prepared statement
//            st.setInt(1, id);
//            int rows = st.executeUpdate();
//            return rows == 1;
//        }catch(SQLException e){
//            throw new DataException(e.getMessage(), e);
//        }

        OurJdbcTemplate template = new OurJdbcTemplate(con); // con template
        int ln = template.update(DELETE_PRODUCT, id);
        return ln == 1;
    }

    @Override
    public Optional<Product> findById(int id) {
//        try(PreparedStatement st = con.prepareStatement(FIND_BY_ID)){ // senza template
//            st.setInt(1, id);
//            try(ResultSet rs = st.executeQuery()){
//                if(rs.next()){
//                    Product p = fromResultSet(rs);
//                    return Optional.of(p);
//                } else {
//                    return Optional.empty();
//                }
//            }
//        } catch(SQLException e){
//            throw new DataException(e.getMessage(), e);
//        }

        OurJdbcTemplate template = new OurJdbcTemplate(con); // con template
        return template.queryForObject(FIND_BY_ID, JdbcProductRepository::fromResultSet, id);
    }

    @Override
    public List<Product> findAll() {
//        List<Product> all = new ArrayList<>();
//        try (Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(FIND_ALL)){
//            while(rs.next()){
//                Product p  = fromResultSet(rs);
//                all.add(p);
//            }
//            return all;
//        } catch (SQLException e) {
//            throw new DataException(e.getMessage(), e);
//        }

        // con template
        OurJdbcTemplate template = new OurJdbcTemplate(con);
        return template.query(FIND_ALL, JdbcProductRepository::fromResultSet);
    }

    @Override
    public List<Product> findByNameLike(String namePart) throws DataException {
//        List<Product> productByNameLike = new ArrayList<>();
//        try(PreparedStatement st = con.prepareStatement(FIND_BY_NAME_LIKE)){
//            st.setString(1, "%" + namePart + "%");
//            try(ResultSet rs = st.executeQuery()){
//                while(rs.next()){
//                    Product p = fromResultSet(rs);
//                    productByNameLike.add(p);
//                }
//                return productByNameLike;
//            }
//        } catch(SQLException e){
//            throw new DataException(e.getMessage(), e);
//        }

//        return query(FIND_BY_NAME_LIKE, "%" + namePart + "%"); // con query generica di products che usa Object... params

//        return query2(FIND_BY_NAME_LIKE, (ps) -> { // con query generica di products che usa lambda
//            try {
//                ps.setString(1, "%" + namePart + "%");
//            }catch(SQLException e){
//                throw new DataException(e.getMessage(), e);
//            }
//        });

        OurJdbcTemplate template = new OurJdbcTemplate(con);
        return template.query(FIND_BY_NAME_LIKE, JdbcProductRepository::fromResultSet, "%" + namePart + "%");
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

    public List<Product> query(String query, Object... params) throws DataException{
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

    public List<Product> query2(String query, PreparedStatementFiller filler) throws DataException{
        List<Product> productList = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement(query)){
            filler.fillStatement(ps); // da fuori qualcuno passa una lambda che dice come fillare lo statement
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
