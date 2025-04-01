package rentalcar.rentalsystem;

import java.time.Year;

public class MotorBike extends Vehicle{
  //   /-----/-VARIABLES-/-----/
    private double costPerDays;

    //   /-----/-CONSTRUCTORS-/-----/
    public MotorBike(String plate, String model, Year year) {
        super(plate, model, year);
        costPerDays = 30;
    }

    //   /-----/-METHODS-/-----/
    @Override
    public double calculateRentCost(int days) {
        double discountCost = 0.1 * costPerDays;
        if (days > 5) {
            return discountCost * days;
        }
        else {
            return costPerDays * days;
        }
    }

    public double getCostPerDays() {
        return costPerDays;
    }
}
