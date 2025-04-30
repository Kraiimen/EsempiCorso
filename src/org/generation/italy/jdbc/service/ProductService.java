package org.generation.italy.jdbc.service;

import org.generation.italy.jdbc.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(int id);
    List<Product> findProductsByNameLike();

}
