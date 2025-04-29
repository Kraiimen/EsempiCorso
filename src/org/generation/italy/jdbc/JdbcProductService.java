package org.generation.italy.jdbc;

import java.util.List;

public class JdbcProductService implements ProductService {
    private ProductRepository productRepo; //una dipendenza della classe servizio

    public JdbcProductService(ProductRepository repo) {
//        productRepo = new JdbcProductRepository(); NO!!!
        this.productRepo = repo; //INIEZIONE DELLA DIPENDENZA
    }

    @Override
    public Product findProductById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public List<Product> findProductsByNameLike(String namePart) {
        return List.of();
    }
}
