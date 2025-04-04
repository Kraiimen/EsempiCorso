package org.generation.italy.vehiclesRental;

import java.time.Year;

public abstract class Vehicle {
    private String plate;
    private String model;
    private Year year;
    private boolean isRented;

    public Vehicle(String plate, String model, Year year){
        this.plate = plate;
        this.model = model;
        this.year = year;
    }

    public abstract double calculateRentalCost(int days);

    public boolean isVehicleRented() {
        return isRented;
    }

    public void setIsRented(boolean rented) {
        isRented = rented;
    }

    public String getPlate() {
        return plate;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(this.getClass() != obj.getClass()){
            return false;
        }
        Vehicle other = (Vehicle)obj;
        return other.plate.equals(this.plate);
    }

    @Override
    public String toString(){
        return "Plate: " + plate + "\nModel: "+ model + "\nImmatricolation year: " + year + "\nAvailability: " + (isRented ? "Yes" : "No");
    }
}
