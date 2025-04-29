package org.generation.italy.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SpringJdbcProductRepository {
    private JdbcTemplate template;
    private static final String INSERT_PRODUCT = """
        INSERT INTO products
        (productname, supplierid, categoryid, unitprice, discontinued)
        VALUES (?,?,?,?,?)
        """;

    public SpringJdbcProductRepository(DataSource ds){
        this.template = new JdbcTemplate(ds);
    }

    public Product insert(Product newProduct) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, newProduct.getProductName());
            ps.setInt(2, newProduct.getSupplierId());
            ps.setInt(3, newProduct.getCategoryId());
            ps.setDouble(4, newProduct.getUnitPrice());
            ps.setInt(5, newProduct.getDiscontinued());
            return ps;
        }, keyHolder);
        int key = keyHolder.getKey().intValue();
        new Product.setProductId(key);
        return newProduct;
    }

