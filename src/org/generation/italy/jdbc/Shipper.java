package org.generation.italy.jdbc;

public class Shipper {
    private int shipperid;
    private String companyName;
    private String phone;

    public Shipper(int shipperid, String companyname, String phone) {
        this.shipperid = shipperid;
        this.companyName = companyname;
        this.phone = phone;
    }

    public String getCompanyName() {
        return companyName;
    }
}
