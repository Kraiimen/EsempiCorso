package org.generation.italy.vehiclesRental;

import java.util.ArrayList;

public class Rental {
    private Vehicle vehicle;
    private String client;
    private int days;

    public Rental(Vehicle vehicle, String client, int days){
        this.vehicle = vehicle;
        this.client = client;
        this.days = days;
    }

    public boolean checkRental(){
        return vehicle.isVehicleRented();
    }
}
