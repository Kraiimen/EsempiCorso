package org.generation.italy.jdbc;

import java.util.List;

public class Product {
    private int productId;
    private String productName;
    private int supplierId;
    private int categoryId;
    private double unitPrice;
    private int discontinued;


    public Product(int productId, String productName, int supplierId, int categoryId, double unitPrice, int discontinued){
        this.productId = productId;
        this.productName = productName;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
        this.discontinued = discontinued;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductId() {
        return productId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getDiscontinued() {
        return discontinued;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
