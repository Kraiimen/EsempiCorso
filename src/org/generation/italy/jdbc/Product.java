package org.generation.italy.jdbc;

public class Product {
    public Product(int productId, String productName, int supplierId, int categoryId,double unitPrice, int discontinued) {
        this.productId = productId;
        this.productName = productName;
        this.supplierId = supplierId;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
        this.discontinued = discontinued;
    }

    private int productId;
    private String productName;
    private int supplierId;
    private double unitPrice;
    private int categoryId;
    private int discontinued;

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

    public int getDiscontinued() {
        return discontinued;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getDiscountinued() {
        return discontinued;
    }
}
