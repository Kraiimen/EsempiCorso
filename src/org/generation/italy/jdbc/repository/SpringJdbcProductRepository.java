package org.generation.italy.jdbc.repository;

import org.generation.italy.jdbc.model.Product;
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
            (productname, supplierid, categoryid, unitprice, discontinued) 
            VALUES(?, ?, ?, ?, ?)
            """;
    private static final String FIND_BY_ID = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discontinued
            FROM products
            WHERE productid = ?
            """;
    private static final String UPDATE_PRODUCT = """
            UPDATE products
            SET productname = ?, supplierid = ?, categoryid = ?, unitprice = ?, discontinued = ?
            WHERE productid = ?;
            """;
    private static final String DELETE_PRODUCT = """
            DELETE
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

    public SpringJdbcProductRepository(DataSource ds){
        this.template = new JdbcTemplate(ds);
    }

    public Product create(Product newProduct){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement ps = con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, newProduct.getProductName());
            ps.setInt(2, newProduct.getSupplierId());
            ps.setInt(3, newProduct.getCategoryId());
            ps.setDouble(4, newProduct.getUnitPrice());
            ps.setInt(5, newProduct.getDiscontinued());
            return ps;
        }, keyHolder);
        int key = (Integer)keyHolder.getKeys().get("productid");
//        int key = keyHolder.getKey().intValue();
        newProduct.setProductId(key);
        return newProduct;
    }

    public Optional<Product> findById(int id){
        return Optional.ofNullable(template.queryForObject(FIND_BY_ID, rowMapper, id));
    }

    public boolean update(Product product){
        return template.update(UPDATE_PRODUCT,
                    product.getProductName(),
                    product.getSupplierId(),
                    product.getCategoryId(),
                    product.getUnitPrice(),
                    product.getDiscontinued(),
                    product.getProductId()
        ) == 1;
    }

//    public int update2(Product product) {
//        return template.update(con -> {
//            PreparedStatement ps = con.prepareStatement(UPDATE_PRODUCT);
//            ps.setString(1, product.getProductName());
//            ps.setInt(2, product.getSupplierId());
//            ps.setInt(3, product.getCategoryId());
//            ps.setDouble(4, product.getUnitPrice());
//            ps.setInt(5, product.getDiscontinued());
//            ps.setInt(6, product.getProductId());
//            return ps;
//        });
//    }

    public boolean delete(int id){
        return template.update(con -> {
            PreparedStatement ps = con.prepareStatement(DELETE_PRODUCT);
            ps.setInt(1, id);
            return ps;
        }) == 1;
    }

//    public boolean delete2(int id) {
//        return template.update(DELETE_PRODUCT, id) == 1;
//    }

    public List<Product> findAll(){
        return template.query(FIND_ALL, rowMapper);
    }

    public List<Product> findByNameLike(String namePart){
        return template.query(FIND_BY_NAME_LIKE, rowMapper, "%" + namePart + "%");
    }

    private RowMapper<Product> rowMapper = (rs, rownum) -> {
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
