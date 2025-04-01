package rentalcar.rentalsystem;

import java.time.Year;

public abstract class Vehicle {

    //   /-----/-VARIABLES-/-----/
    private String plate;
    private String model;
    private Year year;
    private boolean booked;

    //   /-----/-CONSTRUCTORS-/-----/
    public Vehicle(String plate, String model, Year year) {
        this.plate = plate;
        this.model = model;
        this.year = year;
    }

    //   /-----/-METHODS-/-----/
    public abstract double calculateRentCost(int days);

    public String getPlate() {
        return plate;
    }
    public String getModel() {
        return model;
    }
    public Year getYear() {
        return year;
    }
    public boolean isBooked() {
        return booked;
    }
    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
