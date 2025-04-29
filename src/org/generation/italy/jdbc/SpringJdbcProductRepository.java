package org.generation.italy.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class SpringJdbcProductRepository {
    private JdbcTemplate template;

    private static final String WRONG_DELETE_PRODUCT = """
            DELETE FROM products
            WHERE productid = 
            """;
    private static final String DELETE_PRODUCT = """
            DELETE FROM products
            WHERE productid = ?
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

    public SpringJdbcProductRepository(DataSource ds){
        this.template = new JdbcTemplate(ds);
    }

    public Product insert(Product newProduct){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement ps= con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            setParameters(ps, newProduct.getProductName(),
                              newProduct.getSupplierId(),
                              newProduct.getCategoryId(),
                              newProduct.getUnitPrice(),
                              newProduct.getDiscountinued()
            );
            return ps;
        }, keyHolder);
        int key = keyHolder.getKey().intValue();
        newProduct.setProductId(key);
        return newProduct;
    }

    public Optional<Product> findById(int id){
        return Optional.ofNullable(template.queryForObject(FIND_BY_ID, rowMapper, id));
    }

    public int update(Product product){
        return template.update(con -> {
            PreparedStatement ps = con.prepareStatement(UPDATE_PRODUCT);
            setParameters(ps,
                    product.getProductName(),
                    product.getSupplierId(),
                    product.getCategoryId(),
                    product.getUnitPrice(),
                    product.getDiscountinued(),
                    product.getProductId()
            );
            return ps;
        });
    }

    public boolean delete(int id){
        int linesAffected = template.update(con -> {
            PreparedStatement ps = con.prepareStatement(DELETE_PRODUCT);
            ps.setInt(1, id);
            return ps;
        });
        return linesAffected == 1;
    }

    public List<Product> findAll(){
        return template.queryForList(FIND_ALL, Product.class);
    }

    public List<Product> findByNameLike(String namePart){
        return template.queryForList(FIND_BY_NAME_LIKE, Product.class, namePart);
    }

    private RowMapper<Product> rowMapper = (rs, rowNum) ->{
        Product p = new Product(
                rs.getInt("productid"),
                rs.getString("productname"),
                rs.getInt("supplierid"),
                rs.getInt("categoryid"),
                rs.getDouble("unitprice"),
                rs.getInt("discontinued")
        );
        return p;
    };
    private void setParameters(PreparedStatement ps, Object... params) throws SQLException {
        for(int i = 0; i < params.length; i++){
            ps.setObject(i + 1, params[i]);
        }
    }
}







