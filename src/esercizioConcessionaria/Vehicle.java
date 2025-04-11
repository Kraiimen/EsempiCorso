package esercizioConcessionaria;

import java.time.Year;

public abstract class Vehicle {
    private final String plate;
    private String model;
    private Year year;
    private boolean booked;


    public Vehicle(String plate, String model, Year year) {
        this.plate = plate;
        this.model = model;
        this.year = year;

    }

    public abstract double calculateRentCost(int days);

    public boolean isVehicleBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(this.getClass() != obj.getClass()){
            return false;
        }
        Vehicle v = (Vehicle)obj;
        return this.plate.equals(v.plate);
    }
    public String getPlate(){
        return plate;
    }
}
