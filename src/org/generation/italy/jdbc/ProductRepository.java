package org.generation.italy.jdbc;

import java.util.List;

public interface ProductRepository {
    //Metodo CRUD: Create Read Update Delete
    public interface JdbcProductRepository  {

        Product create(Product newProduct);
        boolean update(Product product);
        boolean delete(int id);
        Product findById(int id);
        List<Product> findAll();
        List<Product> findByNameLike(String namePart);
    }

}
