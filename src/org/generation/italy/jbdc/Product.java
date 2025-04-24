package org.generation.italy.jbdc;

public class Product {
    private int productId;
    private String productName;
    private int supplierId;
    private int categoryId;
    private int discontinued;

    public Product(int productId, String productName, int supplierId, int categoryId, int discontinued) {
        this.productId = productId;
        this.productName = productName;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.discontinued = discontinued;
    }

}
