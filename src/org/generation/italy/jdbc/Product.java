package org.generation.italy.jdbc;

public class Product {
    private int productId;
    private String productName;
    private int supplierId;
    private int categoryId;
    private double unitPrice;
    private int discontinued;

    public Product(int productId, String productName, int supplierId, int categoryId,double unitPrice, int discontinued) {
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

    public int getDiscountinued() {
        return discontinued;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

}
