package org.generation.italy.jdbc.model;

public class Product {
    private int productId;
    private String productName;
    private int supplierId;
    private int categoryId;
    private double unitPrice;
    private int discontinued;

    public Product(int productId, String productName, int supplierId, int categoryId, double unitPrice, int discontinued) {
        this.productId = productId;
        this.productName = productName;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
        this.discontinued = discontinued;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getDiscontinued() {
        return discontinued;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
