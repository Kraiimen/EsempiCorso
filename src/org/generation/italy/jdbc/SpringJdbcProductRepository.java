package org.generation.italy.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class SpringJdbcProductRepository implements ProductRepository{
    private JdbcTemplate template;
    private static final String INSERT_PRODUCT = """
            INSERT INTO products 
            (productname, supplierid, categoryid, unitprice, discountinued) 
            VALUES(?,?,?,?,?)
            """;
    private static final String FIND_BY_ID = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discountinued
            FROM products
            WHERE productid = ?
            """;

    public SpringJdbcProductRepository(DataSource ds){
        this.template = new JdbcTemplate(ds);
    }

    public Product create(Product newProduct){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement ps= con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, newProduct.getProductName());
            ps.setInt(2, newProduct.getSupplierId());
            ps.setInt(3, newProduct.getCategoryId());
            ps.setDouble(4, newProduct.getUnitPrice());
            ps.setInt(5, newProduct.getDiscountinued());
            return ps;
        }, keyHolder);
        int key = keyHolder.getKey().intValue();
        newProduct.setProductId(key);
        return newProduct;
    }

    public Optional<Product> findById(int id){
        return Optional.ofNullable(template.queryForObject(FIND_BY_ID, rowMapper, id));
    }

    public boolean update(Product product){
        return false;
    }

    public boolean delete(int id){
        return false;
    }

    public List<Product> findAll(){
        return null;
    }

    public List<Product> findByNameLike(String namePart){
        return null;
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
}