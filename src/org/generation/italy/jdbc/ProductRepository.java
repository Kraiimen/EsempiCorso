package org.generation.italy.jdbc;

import org.generation.italy.bankProject.accounting.exceptions.DataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProductRepository  {
    //METODI CRUD
    Product create(Product newProduct) throws DataException;
    int update(Product product)throws DataException;
    boolean delete(int id)throws DataException;
    Optional<Product> findByID(int id)throws DataException;
    List<Product> findAll()throws DataException;
    List<Product> findByNameLike(String namePart)throws DataException;
}
