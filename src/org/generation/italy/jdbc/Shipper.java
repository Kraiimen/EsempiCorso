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

    public void setShipperid(int shipperid) {
        this.shipperid = shipperid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
