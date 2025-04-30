package org.generation.italy.jdbc.model;

public class Shipper {
    private int shipperid;
    private String companyname;
    private String phone;

    public Shipper(int shipperid, String companyname, String phone) {
        this.shipperid = shipperid;
        this.companyname = companyname;
        this.phone = phone;
    }

    public int getShipperid() {
        return shipperid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getPhone() {
        return phone;
    }

    public void setShipperid(int shipperid) {
        this.shipperid = shipperid;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
