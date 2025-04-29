package org.generation.italy.jdbc;

import java.util.List;

public interface ProductService {
    Product findProductById(int id);

    List<Product> findProductsByNameLike(String namePart);
}
