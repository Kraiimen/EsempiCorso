package eserciziconcessionaria;

import java.time.Year;

public class MotorBike extends Vehicle {
    private final double DAILY_COST = 30;
    private final int DAYS_FOR_DISCOUNT = 5;
    private final double DISCOUNT_PERCENTAGE = 0.1;

    public MotorBike(String plate, String model, Year year){
        super(plate, model, year);
    }

    @Override
    public double calculateRentCost(int days){
        if (DAYS_FOR_DISCOUNT <= 5){
            return days * DAILY_COST;
        } else {
            return (days * DAILY_COST) * (days * DAILY_COST * DISCOUNT_PERCENTAGE);
        }
    }
}
