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

public class SpringJdbcProductRepository {
   //   /-----/-STATE-/-----/
   private static final String INSERT_PRODUCT = """
            INSERT INTO products
            (productname, supplierid, categoryid, unitprice, discontinued)
            VALUES(?,?,?,?,?)
            """;
    private static final String FIND_BY_ID = """
            SELECT productid, productname, supplierid, categoryid, unitprice, discontinued 
            FROM products
            WHERE productid = ?
            """;
    private JdbcTemplate template;

    private RowMapper<Product> rowMapper = (rs,rowNum) -> {
        Product p = new Product(rs.getInt("productid"),
                rs.getString("productname"),
                rs.getInt("supplierid"),
                rs.getInt("categoryid"),
                rs.getDouble("unitprice"),
                rs.getInt("discontinued")
        );
        return p;
    };

    //   /-----/-CONSTRUCTORS-/-----/
    public SpringJdbcProductRepository(DataSource ds) {
        this.template = template;
    }

    //   /-----/-METHODS-/-----/
    public Product insert(Product newProduct) {
        KeyHolder keyHolder = new GeneratedKeyHolder(); // Sarà un contenitore in cui Spring inserirà la chiave autogenerata dalla query
        template.update(con -> {
            PreparedStatement ps = con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS); //metodo che prende in input uno statement e mi ritorna una Connection
            ps.setString(1, newProduct.getProductname());
            ps.setInt(2, newProduct.getSupplierid());
            ps.setInt(3, newProduct.getCategoryid());
            ps.setDouble(4, newProduct.getUnitprice());
            ps.setInt(5, newProduct.getDiscontinued());
            return ps;
        }, keyHolder);
        int key =  keyHolder.getKey().intValue();   // Number, classe madre di integer e long, per cui usiamo intValue per trasformare il Number in int
        newProduct.setProductid(key);
        return newProduct;
    }

    public Optional<Product> findById(int id) {
        return Optional.ofNullable(template.queryForObject(FIND_BY_ID, rowMapper, id)); // il metodo ofNullable mi torna un empty o l'optional del prodotto, senza if ecc.
    }

    //METODI DA IMPLEMENTARE
    public int update(Product product) {
        return 0;
    }

    public boolean delete(int id) {
        return false;
    }

    public List<Product> findAll() {
        return null;
    }

    public List<Product> findByNameLike(String namePart) {
        return null;
    }


}
