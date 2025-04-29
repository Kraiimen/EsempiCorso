package jdbc;

import java.util.List;

public class JdbcProductService implements ProductService {
    private ProductRepository productRepo;

    public JdbcProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public List<Product> findProductByNameLike(String namePart) {
        return List.of();
    }
}
