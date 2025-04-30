package org.generation.italy.jdbc.service;

import org.generation.italy.jdbc.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Optional<Product> findById(int id);
    List<Product> findProductsByNameLike(String namePart);
}
