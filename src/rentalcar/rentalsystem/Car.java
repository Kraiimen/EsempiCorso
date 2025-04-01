package rentalcar.rentalsystem;

import java.time.Year;

public class Car extends Vehicle{
    //   /-----/-VARIABLES-/-----/
    private double costPerDay;

    //   /-----/-CONSTRUCTORS-/-----/
    public Car(String plate, String model, Year year) {
        super(plate, model, year);
        costPerDay = 50;
    }

    //   /-----/-METHODS-/-----/

    @Override
    public double calculateRentCost(int days) {
        return costPerDay * days;
    }
    public double getCostPerDay() {
        return costPerDay;
    }
}
