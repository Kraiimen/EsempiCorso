package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcProductRepository implements ProductRepository {
    private Connection con;
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
            INSERT INTO products(productname, supplierid, categoryid, unitprice, discontinued)
            VALUES(?, ?, ?, ?, ?)
            """;
    private static final String UPDATE_PRODUCT = """
            UPDATE products
            SET productname = ?, supplierid = ?, categoryid = ?, unitprice = ?, discontinued = ?
            WHERE productid = ?
            """;

    public JdbcProductRepository(Connection con) {
        this.con = con;
    }

    @Override
    public Product create(Product newProduct) throws DataException {
        try (PreparedStatement st = con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, newProduct.getProductName());
            st.setInt(2, newProduct.getSupplierId());
            st.setInt(3, newProduct.getCategoryId());
            st.setDouble(4, newProduct.getUnitPrice());
            st.setInt(5, newProduct.getDiscontinued());
            st.executeUpdate();

            try (ResultSet rs = st.getGeneratedKeys()) {
                if (rs.next()) {
                    int generatedKey = rs.getInt(1);
                    newProduct.setProductId(generatedKey);
                }
            }
            return newProduct;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(Product updatedProduct) throws DataException {
//        try (PreparedStatement st = con.prepareStatement(UPDATE_PRODUCT)) {
//            st.setString(1, updatedProduct.getProductName());
//            st.setInt(2, updatedProduct.getSupplierId());
//            st.setInt(3, updatedProduct.getCategoryId());
//            st.setDouble(4, updatedProduct.getUnitPrice());
//            st.setInt(5, updatedProduct.getDiscontinued());
//            st.setInt(6, updatedProduct.getProductId());
//            int rows = st.executeUpdate();
//            return rows == 1;
//        } catch (SQLException e) {
//            throw new DataException(e.getMessage(), e);
//        }

        OurJdbcTemplate template = new OurJdbcTemplate(con);
        int rows = template.update(UPDATE_PRODUCT,
                updatedProduct.getProductName(),
                updatedProduct.getSupplierId(),
                updatedProduct.getCategoryId(),
                updatedProduct.getUnitPrice(),
                updatedProduct.getDiscontinued(),
                updatedProduct.getProductId());

        return rows == 1;
    }

    @Override
    public boolean delete(int id) throws DataException {
//        try (PreparedStatement st = con.prepareStatement(DELETE_PRODUCT)) {
//            st.setInt(1, id);
//            int rows = st.executeUpdate();
//            return rows == 1;
//        } catch (SQLException e) {
//            throw new DataException(e.getMessage(), e);
//        }

        OurJdbcTemplate template = new OurJdbcTemplate(con);
        int rows = template.update(DELETE_PRODUCT, id);
        return rows == 1;
    }

    @Override
    public Optional<Product> findById(int id) throws DataException {
//        try (PreparedStatement st = con.prepareStatement(FIND_BY_ID)) {
//            st.setInt(1, id);
//            try (ResultSet rs = st.executeQuery()) {
//                if(rs.next()) {
//                    Product p = fromResultSet(rs);
//                    return Optional.of(p);
//                }
//                else {
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
//        List<Product> products = new ArrayList<>();
//        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(FIND_ALL)) {
//            while (rs.next()) {
//                Product p = fromResultSet(rs);
//                products.add(p);
//            }
//            return products;
//        } catch (SQLException e) {
//            throw new DataException(e.getMessage(), e);
//        }

        OurJdbcTemplate template = new OurJdbcTemplate(con);
        return template.query(FIND_ALL, JdbcProductRepository::fromResultSet);
    }

    @Override
    public List<Product> findByNameLike(String namePart) throws DataException {
//        return queryUsingVarArgs(FIND_BY_NAME_LIKE, namePart);
//        return queryUsingFunctionalInterface(FIND_BY_NAME_LIKE, ps -> {
//            try {
//                ps.setString(1,"%"+namePart+"%");
//            } catch (SQLException e) {
//                throw new DataException(e.getMessage(), e);
//            }
//        });

        OurJdbcTemplate template = new OurJdbcTemplate(con);
        return template.query(FIND_BY_NAME_LIKE, JdbcProductRepository::fromResultSet, "%"+namePart+"%");
    }

    public List<Product> queryUsingVarArgs(String query, Object... params) throws DataException {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product p = fromResultSet(rs);
                    products.add(p);
                }
            }

            return products;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    public List<Product> queryUsingFunctionalInterface(String query, PreparedStatementFiller filler) throws DataException {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            filler.fillStatement(ps);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product p = fromResultSet(rs);
                    products.add(p);
                }
            }

            return products;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    private static Product fromResultSet(ResultSet rs) throws SQLException {
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
