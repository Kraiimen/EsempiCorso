package org.generation.italy.jdbc;

public class Shipper {
    private int shipperid;
    private String companyName;
    private String phone;

    public Shipper(int shipperid, String companyName, String phone) {
        this.shipperid = shipperid;
        this.companyName = companyName;
        this.phone = phone;
    }

    public int getShipperid() {
        return shipperid;
    }

    public String getCompanyname() {
        return companyName;
    }

    public String getPhone() {
        return phone;
    }
}
