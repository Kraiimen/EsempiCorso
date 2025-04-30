package org.generation.italy.jdbc.model;

public class Product {

    private int productid;
    private String productname;
    private int supplierid;
    private int categoryid;
    private double unitprice;
    private int discontinued;

    public Product(int productid, String productname, int supplierid, int categoryid, double unitprice, int discontinued) {
        this.productid = productid;
        this.productname = productname;
        this.supplierid = supplierid;
        this.categoryid = categoryid;
        this.unitprice = unitprice;
        this.discontinued = discontinued;
    }

    public int getProductid() {
        return productid;
    }

    public String getProductname() {
        return productname;
    }

    public int getSupplierid() {
        return supplierid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public int getDiscontinued() {
        return discontinued;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
}
