package org.generation.italy.jbdc;

import java.util.List;

public interface ProductRepository {
    //metodi CRUD
    Product create(Product newProduct) throws DataExpection;
    boolean update(Product product);
    boolean delete(long productId);
    Product findById(int Id);
    List<Product> findAll();
    List<Product> findByNameLike(String namePart);
}
