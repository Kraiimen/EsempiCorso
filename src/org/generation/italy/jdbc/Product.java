package org.generation.italy.jdbc;

public class Product {

    private int productId;
    private String productName;
    private int supplierId;
    private int categoryId;
    private double unitPrice;
    private int discountinued;

    public Product(int productId, String productName, int supplierId, int categoryId, double unitPrice, int discountinued) {
        this.productId = productId;
        this.productName = productName;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.discountinued = discountinued;
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
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
        return discountinued;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
