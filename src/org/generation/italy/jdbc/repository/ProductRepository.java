package org.generation.italy.jdbc.repository;

import org.generation.italy.jdbc.DataException;
import org.generation.italy.jdbc.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    // Metodi CRUD --> Create, Read, Update, Delete
    Product create(Product newProduct) throws DataException;
    boolean update(Product product) throws DataException;
    boolean delete(int id) throws DataException;
    Optional<Product> findById(int id) throws DataException; // Mi trova i prodotti tramite productid
    // Uso Optional per non tornare null nel caso in cui la query fallisce
    List<Product> findAll() throws DataException; // Mi torna tutti i prodotti
    List<Product> findByNameLike(String namePart) throws DataException; // Mi torna un prodotto che contiene la Stringa che gli passo
}
