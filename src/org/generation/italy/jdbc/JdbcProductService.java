//package org.generation.italy.jdbc;
//
//import java.util.List;
//
//public class JdbcProductService implements ProductService{
//    private ProductRepository productRepo;
//
//    public JdbcProductService(ProductRepository repo){
////        productRepo = new JdbcProductRepository(); //NO
//        productRepo = repo; //iniezione della dipendenza
//
//    }
//
//    @Override
//    public Product findProductById(int id) {
//        return productRepo.findByID(id);
//    }
//
//    @Override
//    public List<Product> findProductByNameLike(String namePart) {
//        return List.of();
//    }
// //}
