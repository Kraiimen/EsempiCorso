package org.generation.italy.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JdbcProductRepository implements ProductRepository {

    private Connection con;
    private static final String DELETE_PRODUCT = """
            DELETE FROM products
            WHERE productid =  
            """;

    public JdbcProductRepository(Connection con) {
        this.con = con;
    }

    @Override
    public Product create(Product newProduct) {
        return null;
    }

    @Override
    public boolean update(Product newProduct) {
        return false;
    }

    @Override
    public boolean delete(int id) throws DataException {
        try (Statement st = con.createStatement()) {
            int lines = st.executeUpdate(DELETE_PRODUCT + id);
            return lines == 1;
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }

    }

    @Override
    public Product findById(int id) {
        try(PreparedStatement st = con.prepareStatement());
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public List<Product> findByNameLike(String namePart) {
        return List.of();
    }
}
