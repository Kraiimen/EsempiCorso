package jdbc;

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
            WHERE productid = ?
            """;

    public JdbcProductRepository(Connection con){
        this.con = con;
    }

    @Override
    public Product create(Product newProduct) throws DataException {
        try(PreparedStatement st = con.prepareStatement(INSERT_PRODUCT)){
            st.setString(1, newProduct.getProductName());
            st.setInt(2, newProduct.getSupplierId());
            st.setInt(3, newProduct.getCategoryId());
            st.setDouble(4, newProduct.getUnitPrice());
            st.setInt(5, newProduct.getDiscontinued());
            st.executeUpdate();

            // Qui dovremmo scoprire come leggere il valore dell'id, assegnarlo a newProduct e poi ritornare newProduct

            return newProduct;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Product updatedProduct) throws DataException {
        try(PreparedStatement st = con.prepareStatement(UPDATE_PRODUCT)) {
            st.setString(1, updatedProduct.getProductName());
            st.setInt(2, updatedProduct.getSupplierId());
            st.setInt(3, updatedProduct.getCategoryId());
            st.setDouble(4, updatedProduct.getUnitPrice());
            st.setInt(5, updatedProduct.getDiscontinued());
            st.setInt(6, updatedProduct.getProductId());
            int rows = st.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(int id) throws DataException {
        try(PreparedStatement st = con.prepareStatement(DELETE_PRODUCT)){
            st.setInt(1, id);
            int rows = st.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Product> findById(int id) throws DataException {
        try(PreparedStatement st = con.prepareStatement(FIND_BY_ID)) {
            st.setInt(1, id);
            try(ResultSet rs = st.executeQuery()) {
                if(rs.next()) {
                    Product p = getProductFromResultSet(rs);
                    return Optional.of(p);
                }
                else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> findAll() throws DataException {
        List<Product> products = new ArrayList<>();
        try(Statement st = con.createStatement(); ResultSet rs = st.executeQuery(FIND_ALL)){
            while (rs.next()){
                Product p = getProductFromResultSet(rs);
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Product> findByNameLike(String namePart) throws DataException {
        List<Product> products = new ArrayList<>();
        try(PreparedStatement st = con.prepareStatement(FIND_BY_ID)) {
            st.setString(1, "%"+namePart+"%");
            try(ResultSet rs = st.executeQuery()) {
                while (rs.next()){
                    Product p = getProductFromResultSet(rs);
                    products.add(p);
                }
            }
            return products;
        } catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    private Product getProductFromResultSet(ResultSet rs) throws SQLException{
        return new Product(
                rs.getInt("productid"),
                rs.getString("productname"),
                rs.getInt("supplierid"),
                rs.getInt("categoryid"),
                rs.getDouble("unitprice"),
                rs.getInt("discontinued")
        );
    }
}
