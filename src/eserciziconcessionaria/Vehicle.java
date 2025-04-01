package eserciziconcessionaria;

import java.time.Year;

public abstract class Vehicle {
    private String plate;
    private String model;
    private Year year;
    private boolean booked;


    public Vehicle(String plate, String model, Year year) {
    this.plate = plate;
    this.model = model;
    this.year = year;
    }

    public abstract double calculateRentCost(int days);

    public boolean getBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String getPlate() {
        return plate;
    }
}