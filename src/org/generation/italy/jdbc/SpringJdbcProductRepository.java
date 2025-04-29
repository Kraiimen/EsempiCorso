package org.generation.italy.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class SpringJdbcProductRepository {
    private JdbcTemplate template;
    private static final String INSERT_PRODUCT = """
            INSERT INTO products 
            (productname, supplierid, categoryid, unitprice, discontinued) 
            VALUES(?,?,?,?,?)
            """;

    public SpringJdbcProductRepository(DataSource ds){
        this.template = new JdbcTemplate(ds);
    }

    public Product insert(Product newProduct){
        KeyHolder keyHolder = new // * da recuperare il generate key holder
    }
}
