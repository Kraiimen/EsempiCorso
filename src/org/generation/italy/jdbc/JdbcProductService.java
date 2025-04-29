package org.generation.italy.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JdbcProductService implements ProductService{
    private ProductRepository productRepo;

    public JdbcProductService(ProductRepository repo){
        productRepo = repo;
    }

    @Override
    public Optional<Product> findById(int id){
        return productRepo.findById(id);
    }

    @Override
    public List<Product> findProductsByNameLike(String namePart) {
        return List.of();
    }

    public void createProduct(String productName, int supplierId, int categoryId, double unitPrice, int discontinued){
        Product newProduct = new Product(0, productName, supplierId, categoryId, unitPrice, discontinued);
        try{
            productRepo.create(newProduct);
        } catch (DataException e){
            throw new RuntimeException(e);
        }
    }

    public void deleteProduct(Integer productId){
        try{
            productRepo.delete(productId);
        } catch (DataException e) {
            throw new RuntimeException(e);
        }
    }
}
