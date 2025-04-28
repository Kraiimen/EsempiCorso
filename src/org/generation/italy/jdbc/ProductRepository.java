package org.generation.italy.jdbc;

import java.util.List;

public interface ProductRepository {

    //CRUD METHODS
    Product create(Product newProduct) throws DataException;
    boolean update(Product newProduct) throws DataException;
    boolean delete(int Id) throws DataException;
    Product findById(int Id) throws DataException;
    List<Product> findAll() throws DataException;
    List<Product> findByNameLike(String namePart) throws DataException;

}
