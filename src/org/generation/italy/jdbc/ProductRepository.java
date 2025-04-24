package org.generation.italy.jdbc;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
        Product create(Product newProduct) throws DataException;
        boolean update(Product product) throws DataException;
        boolean delete(int id) throws DataException;
        Optional<Product> findById(int id) throws DataException;
        List<Product> findAll() throws DataException;
        List<Product> findByNameLike(String namePart) throws DataException;
}
