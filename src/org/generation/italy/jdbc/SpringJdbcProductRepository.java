package org.generation.italy.jdbc;

import org.generation.italy.jdbc.model.Product;
import org.generation.italy.jdbc.repository.ProductRepository;
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

public class SpringJdbcProductRepository implements ProductRepository {
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
    private static final String UPDATE_PRODUCT = """
            UPDATE products
            SET productname = ?, supplierid = ?, categoryid = ?, unitprice = ?, discontinued = ?
            WHERE productid = ?;
            """;
    private static final String DELETE_PRODUCT = """
            DELETE FROM products
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

    private JdbcTemplate template;

    private RowMapper<Product> rowMapper = (rs, rowNum) -> {
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
    public Product create(Product newProduct){
        KeyHolder keyHolder = new GeneratedKeyHolder(); // Sarà un contenitore in cui Spring inserirà la chiave autogenerata dalla query
        template.update(con -> {
            PreparedStatement ps = con.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS); //metodo che prende in input uno statement e mi ritorna una Connection
            setParameters(ps,   newProduct.getProductname(),
                                newProduct.getSupplierid(),
                                newProduct.getCategoryid(),
                                newProduct.getUnitprice(),
                                newProduct.getDiscontinued()
            );
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
        return template.update(con -> {
            PreparedStatement ps = con.prepareStatement(UPDATE_PRODUCT);
            setParameters(ps,
                    product.getProductname(),
                    product.getSupplierid(),
                    product.getCategoryid(),
                    product.getUnitprice(),
                    product.getDiscontinued(),
                    product.getProductid()
            );
            return ps;
        });
    }

    public boolean delete(int id) {
        int linesAffected = template.update(con -> {
            PreparedStatement ps = con.prepareStatement(DELETE_PRODUCT);
            ps.setInt(1, id);
            return ps;
        });
        return linesAffected == 1;
    }

    public List<Product> findAll() {
        return template.queryForList(FIND_ALL, Product.class);
    }

    public List<Product> findByNameLike(String namePart) {
        return template.queryForList(FIND_BY_NAME_LIKE, Product.class, namePart);
    }

    private void setParameters(PreparedStatement ps, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]); //i+1 perché il params nell'array creato dal var in posizione 0, ad esempio, andrà a settare il parametro 1, e così via
        }
    }


}
