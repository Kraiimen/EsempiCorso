package jdbc;

import java.util.List;

public interface ProductService {
    Product findProductById(int id);
    List<Product> findProductByNameLike(String namePart);
}
