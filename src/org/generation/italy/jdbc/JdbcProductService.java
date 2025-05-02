package org.generation.italy.jdbc;

import java.util.List;

public class JdbcProductService implements ProductService {
    private ProductRepository productRepo;
    public JdbcProductService(ProductRepository repo){
//        productRepo = new JdbcProductRepository(); !!!!!NO!!!!!
        productRepo = repo; //Iniezione delle dipendenze
    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public List<Product> findProductsByNameLike(String namePart) {
        return List.of();
    }
}
