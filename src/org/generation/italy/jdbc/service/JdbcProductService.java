package org.generation.italy.jdbc.service;

import org.generation.italy.jdbc.DataException;
import org.generation.italy.jdbc.model.Product;
import org.generation.italy.jdbc.repository.ProductRepository;

import java.util.List;

public class JdbcProductService implements ProductService {
    private ProductRepository productRepo; //Dipendenza della classe servizio

    public JdbcProductService(ProductRepository repo) {
//        productRepo = new JdbcProductRepository(); //NO! La dipendenza diretta del servizio al repository è un abominio
        productRepo = repo; // Iniezione della dipendenze, sposta la responsabilità a qualcun altro

    }

    @Override
    public Product findById(int id) throws DataException {
        return productRepo.findById(id);
    }

    @Override
    public List<Product> findProductsByNameLike() {
        return List.of();
    }
}
